package orm.model;

// local imports
import orm.ORM;
import orm.annotation.PrimaryKey;
import orm.annotation.RefersToField;
import orm.annotation.RefersToTable;
import orm.query.SQLQuery;
import orm.query.operator.SQLOperator;

import java.util.List;

import java.util.ArrayList;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONObject;
import org.json.JSONArray;

public class BaseModel
{

    /**
     * The different states of the current model
     */
    public static enum ModelState
    {
        INSERTED,
        DELETED,
        UPDATED,
        NEW
    }

    /**
     * The JSON key for the table field
     */
    private static final String TABLE_JSON_KEY = "table";

    /**
     * The JSON key for the mapping between field and database column
     */
    private static final String FIELD_MAPPING_WITH_DATABASE_JSON_KEY = "fieldsMapping";

    /**
     * The JSON key for the primary key in the model
     */
    private static final String PRIMARY_KEY_FIELD_JSON_KEY = "primaryKeyField";

    /**
     * The JSON key for the column associated to the primary key in the model
     */
    private static final String PRIMARY_KEY_COLUMN_JSON_KEY = "primaryKeyColumn";

    /**
     * The current state of the object
     */
    protected ModelState currentState;

    /**
     * JSON object that contains the database information
     */
    private JSONObject databaseRepresentation;

    public BaseModel()
    {
        this.currentState = ModelState.NEW;

        this.databaseRepresentation = new JSONObject();
        
        Class<?> currentClass = this.getClass();
        try
        {
            if (!currentClass.isAnnotationPresent(RefersToTable.class))
            {   
                throw new RuntimeException("You have to put a RefersToTable annotation in your class " + currentClass.getName());
            }

            this.databaseRepresentation.put(TABLE_JSON_KEY, currentClass.getAnnotation(RefersToTable.class).table());

            JSONArray array = new JSONArray();
            Field[] fields = currentClass.getDeclaredFields();
            for(Field field : fields)
            {
                if(field.isAnnotationPresent(RefersToField.class))
                {
                    RefersToField annotation = field.getAnnotation(RefersToField.class);
                    JSONObject fieldJSON = new JSONObject()
                        .put(field.getName(), annotation.tableField());
                    array.put(fieldJSON);

                    if(field.isAnnotationPresent(PrimaryKey.class))
                    {
                        this.databaseRepresentation.put(PRIMARY_KEY_FIELD_JSON_KEY, field.getName());
                        this.databaseRepresentation.put(PRIMARY_KEY_COLUMN_JSON_KEY, annotation.tableField());
                    }
                }
            }

            this.databaseRepresentation.put(FIELD_MAPPING_WITH_DATABASE_JSON_KEY, array);
        } catch(SecurityException securityException)
        {
            System.err.println(securityException.getMessage());
        }
    }

    /**
     * Save the model in the database
     */
    public boolean save()
    {
        if(this.currentState.equals(ModelState.NEW))
        {
            return this.insert();
        } else if(this.currentState.equals(ModelState.INSERTED) || (this.currentState.equals(ModelState.UPDATED)))
        {
            return this.update();
        }

        return false;
    }

    private boolean insert()
    {
        String table = this.databaseRepresentation.getString(TABLE_JSON_KEY);
        String primaryKey = this.databaseRepresentation.getString(PRIMARY_KEY_FIELD_JSON_KEY); 
        Field primaryKeyField = null;

        List<String> columns = new ArrayList<String>();
        List<Object> values = new ArrayList<Object>();

        try
        {
            Class<?> currentClass = this.getClass();
            primaryKeyField = currentClass.getDeclaredField(primaryKey);
            primaryKeyField.setAccessible(true);

            JSONArray fieldsMapping = this.databaseRepresentation.getJSONArray(FIELD_MAPPING_WITH_DATABASE_JSON_KEY);

            for(int i = 0; i < fieldsMapping.length(); i++)
            {
                JSONObject fieldMapping = fieldsMapping.getJSONObject(i);
                // field to save in the database
                String fieldName = fieldMapping.keys().next();

                Field field = currentClass.getDeclaredField(fieldName);
                field.setAccessible(true);

                columns.add(fieldMapping.getString(fieldName));
                values.add(field.get(this));
            }

            ResultSet set = ORM.insertInto(table, columns).values(values).executeUpdate();
            if(set == null)
            {
                return false;
            }

            this.currentState = ModelState.INSERTED;
            try {
                if(set.next())
                {
                    primaryKeyField.set(this, set.getObject(primaryKey));
                }
            } catch(SQLException exception)
            {
                System.err.println(exception.getMessage());
                return false;
            }

            return true;
        } catch(SecurityException securityException)
        {
            System.err.println(securityException.getMessage());
            return false;
        } catch(IllegalAccessException illegalAccessException)
        {
            System.out.println(illegalAccessException.getMessage());
            return false;
        } catch(NoSuchFieldException noSuchFieldException)
        {
            System.err.println(noSuchFieldException.getMessage());
            return false;
        }
    }

    private boolean update()
    {
        String table = this.databaseRepresentation.getString(TABLE_JSON_KEY);
        String primaryKey = this.databaseRepresentation.getString(PRIMARY_KEY_FIELD_JSON_KEY);
        String primaryKeyColumn = this.databaseRepresentation.getString(PRIMARY_KEY_COLUMN_JSON_KEY);
        Field primaryKeyField = null;
        SQLQuery query = ORM.update(table);

        try
        {
            Class<?> currentClass = this.getClass();
            primaryKeyField = currentClass.getDeclaredField(primaryKey);
            primaryKeyField.setAccessible(true);


            JSONArray fieldsMapping = this.databaseRepresentation.getJSONArray(FIELD_MAPPING_WITH_DATABASE_JSON_KEY);
        
            for(int i = 0; i < fieldsMapping.length(); i++)
            {
                JSONObject fieldMapping = fieldsMapping.getJSONObject(i);
                // retrieve the field in the json
                String fieldName = fieldMapping.keys().next();
                
                Field field = currentClass.getDeclaredField(fieldName);
                field.setAccessible(true);
                Object value = field.get(this);

                query.setValue(fieldMapping.getString(fieldName), value);
            }

            query.where(primaryKeyColumn, SQLOperator.EQUAL, primaryKeyField.get(this));
        } catch(SecurityException securityException)
        {
            System.err.println(securityException.getMessage());
            return false;
        } catch(NoSuchFieldException noSuchFieldException)
        {
            System.err.println(noSuchFieldException.getMessage());
            return false;
        } catch(IllegalAccessException illegalAccessException)
        {
            System.err.println(illegalAccessException.getMessage());
            return false;
        }


        ResultSet set = query.executeUpdate();
        if(set == null)
        {
            return false;
        }

        this.currentState = ModelState.UPDATED;
        return true;
    }

    /**
     * Set a new state for the model
     * @param state The new state
     */
    public void setState(ModelState state)
    {
        this.currentState = state;
    }
}