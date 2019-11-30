package orm.builder;

// local imports
import orm.collection.SQLCollection;
import orm.query.result.SQLResultSet;
import orm.annotation.RefersToTable;
import orm.annotation.RefersToField;
import orm.exception.BuildingObjectException;
import orm.model.BaseModel;

import orm.types.SQLAbstractType;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Constructor;

import org.json.JSONArray;
import org.json.JSONObject;

public class ClassBuilder implements IClassBuilder
{
    @Override
    /**
     * Create a SQLCollection from a class
     * @param clazz The target class
     * @param set The current result set
     * 
     * @return A collection with objects a the class <code>clazz</code>
     */
    public <T extends BaseModel> SQLCollection<T> build(Class<T> clazz, SQLResultSet set) throws BuildingObjectException
    {
        SQLCollection<T> collection = new SQLCollection<T>();
        JSONArray data = set.getResult();
        int i, dataLength = data.length(), j;
        T element;
        Field field;

        // retrieve the table from the clazz
        if(clazz.isAnnotationPresent(RefersToTable.class))
        {
            RefersToTable tableAnnotation = clazz.getAnnotation(RefersToTable.class);
            String tableName = tableAnnotation.table();

            // retrieve the fields of the class
            Field[] fields = clazz.getDeclaredFields();

            for(i = 0; i < dataLength; i++)
            {
                // fetch on the data to retrieve each JSONArray
                JSONArray currentArray = data.getJSONArray(i);
                int currentArrayLength = currentArray.length();

                // create a new instance of the class
                try
                {
                    element = clazz.newInstance();
                } catch(IllegalAccessException illegalAccessException)
                {   
                    throw new BuildingObjectException(illegalAccessException.getMessage());
                } catch(InstantiationException instantiationException)
                {
                    throw new BuildingObjectException(instantiationException.getMessage());
                }

                // fetch on the columns of the current JSONObject
                for(j = 0; j < currentArrayLength; j++)
                {
                    JSONObject object = currentArray.getJSONObject(j);
                    String currentTable = object.getString(SQLResultSet.TABLE_JSON_KEY);
                    if(currentTable.equals(tableName))
                    {
                        String columnName = object.getString(SQLResultSet.COLUMN_NAME_JSON_KEY);
                        String columnValue = object.getString(SQLResultSet.COLUMN_VALUE_JSON_KEY);

                        // find the field that correspond to the column name
                        field = ClassBuilder.findFieldByName(columnName, fields);
                        if(field != null)
                        {
                            field.setAccessible(true);
                            // get the class associated to the field
                            RefersToField annotation = field.getAnnotation(RefersToField.class);
                            Constructor<?> constructor = null;
                            Class<?> fieldType;
                            String className = annotation.type();
                            // retrieve the constructor of the type field with String parameter
                            try {
                                fieldType = Class.forName(className);
                                constructor = fieldType.getConstructor(String.class);
                                // replace by custom types
                                SQLAbstractType value = (SQLAbstractType)constructor.newInstance(columnValue);
                                field.set(element, value.getData());
                            } catch(NoSuchMethodException noSuchMethodException)
                            {
                                throw new BuildingObjectException(noSuchMethodException.getMessage());
                            } catch(SecurityException securityException)
                            {
                                throw new BuildingObjectException(securityException.getMessage());
                            } catch(ClassNotFoundException classNotFoundException)
                            {
                                throw new BuildingObjectException(classNotFoundException.getMessage());
                            } catch(InstantiationException instantiationException)
                            {
                                throw new BuildingObjectException(instantiationException.getMessage());
                            } catch(IllegalAccessException illegalAccessException)
                            {
                                throw new BuildingObjectException(illegalAccessException.getMessage());
                            } catch(IllegalArgumentException illegalArgumentException)
                            {
                                throw new BuildingObjectException(illegalArgumentException.getMessage());
                            } catch(InvocationTargetException invocationTargetException)
                            {
                                throw new BuildingObjectException(invocationTargetException.getMessage());
                            }
                        }
                    }
                }

                element.setState(BaseModel.ModelState.INSERTED);
                
                collection.add(element);
            }
        }

        return collection;
    }

    /**
     * Find a field of a class with its name in the database
     * @param name The name of the field
     * @param fields The fields of the class
     * @return The field associated to the name
     */
    private static final Field findFieldByName(String name, Field[] fields)
    {
        Field field = null;
        int i, length = fields.length;

        for(i = 0; i < length; i++)
        {
            field = fields[i];
            if(field.isAnnotationPresent(RefersToField.class))
            {
                RefersToField annotation = field.getAnnotation(RefersToField.class);
                String refersTo = annotation.tableField();
                if(name.equals(refersTo))
                {
                    return field;
                }
            }
        }

        return null;
    }
}