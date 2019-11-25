package orm.model;

// local imports
import orm.ORM;
import orm.query.SQLQuery;
import orm.annotation.PrimaryKey;
import orm.annotation.RefersToField;
import orm.annotation.RefersToTable;

import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseModel
{

    private static enum ModelState
    {
        INSERTED,
        DELETED,
        UPDATED,
        UNDEFINED
    }

    protected ModelState currentState;

    public BaseModel()
    {
        this.currentState = ModelState.UNDEFINED;
    }

    /**
     * Save the model in the database
     */
    public boolean save()
    {
        return this.currentState.equals(ModelState.INSERTED) ? this.update() : this.insert();
    }

    private boolean insert()
    {
        String table = "";
        String primaryKey = "";
        Field primaryKeyField = null;

        List<String> columns = new ArrayList<String>();
        List<Object> values = new ArrayList<Object>();

        try
        {
            Class<?> currentClass = this.getClass();
            Field[] fields = currentClass.getDeclaredFields();
            // retrieve the table of the class
            if(!currentClass.isAnnotationPresent(RefersToTable.class))
            {
                return false;
            }

            table = currentClass.getAnnotation(RefersToTable.class).table();
            for(Field field : fields)
            {
                // field to save in the database
                if(field.isAnnotationPresent(RefersToField.class))
                {
                    field.setAccessible(true);
                    RefersToField annotation = field.getAnnotation(RefersToField.class);
                    // primary key of the model, we must to save the name and the field
                    if(field.isAnnotationPresent(PrimaryKey.class))
                    {
                        primaryKey = annotation.tableField();
                        primaryKeyField = field;
                    }

                    columns.add(annotation.tableField());
                    values.add(field.get(this));
                }
            }

            this.currentState = ModelState.INSERTED;

            ResultSet set = ORM.insertInto(table, columns).values(values).executeUpdate();
            try {
                if(set.next())
                {
                    primaryKeyField.set(this, set.getObject(primaryKey));
                }
            } catch(SQLException exception)
            {
                System.err.println(exception.getMessage());
            }

            return true;
        } catch(SecurityException securityException)
        {
            System.err.println(securityException.getMessage());
            return false;
        } catch(IllegalAccessException illegalAccessException)
        {
            System.err.println(illegalAccessException.getMessage());
            return false;
        }
    }

    private boolean update()
    {

        this.currentState = ModelState.UPDATED;
        return true;
    }
}