package orm.builder;

import orm.collection.SQLCollection;
import orm.query.result.SQLResultSet;

import orm.annotation.RefersToTable;
import orm.annotation.RefersToField;

import java.lang.reflect.Field;

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
    public <T> SQLCollection<T> build(Class<T> clazz, SQLResultSet set)
    {
        SQLCollection<T> collection = new SQLCollection<T>();
        JSONArray data = set.getResult();
        int i, dataLength = data.length(), j;

        // retrieve the table from the clazz
        if(clazz.isAnnotationPresent(RefersToTable.class))
        {
            RefersToTable tableAnnotation = clazz.getAnnotation(RefersToTable.class);
            String tableName = tableAnnotation.table();

            // retrieve the fields of the class
            Field[] fields = clazz.getFields();

            for(i = 0; i < dataLength; i++)
            {
                // fetch on the data to retrieve each JSONArray
                JSONArray currentArray = data.getJSONArray(i);
                int currentArrayLength = currentArray.length();

                // fetch on the columns of the current JSONObject
                for(j = 0; j < currentArrayLength; j++)
                {
                    JSONObject object = currentArray.getJSONObject(j);
                    String currentTable = object.getString(SQLResultSet.TABLE_JSON_KEY);
                    if(currentTable.equals(tableName))
                    {
                        String rawColumnValue = object.getString(SQLResultSet.COLUMN_VALUE_JSON_KEY);
                        String columnValue = object.getString(SQLResultSet.COLUMN_VALUE_JSON_KEY);

                        // find the field that correspond to the column name
                    }
                }
            }
        }

        return collection;
    }
}