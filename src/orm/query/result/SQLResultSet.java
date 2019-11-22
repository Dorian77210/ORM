package orm.query.result;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.json.JSONObject;
import org.json.JSONArray;

import orm.collection.SQLCollection;
import orm.builder.IClassBuilder;
import orm.builder.ClassBuilder;

public class SQLResultSet
{
    /**
     * A JSON array with contains the result of a SQL query 
     */
    private JSONArray set;

    // --------- JSON keys -------- //
    
    /**
     * The JSON key for the name of the table
     */
    public static final String TABLE_JSON_KEY = "table";

    /**
     * The JSON key for the value of column
     */
    public static final String COLUMN_VALUE_JSON_KEY = "columnValue";

    /**
     * The JSON key for the name of a column
     */
    public static final String COLUMN_NAME_JSON_KEY = "columnName";

    /**
     * Constructor of SQLResultSet
     */
    public SQLResultSet()
    {
        this.set = new JSONArray();
    }

    /**
     * Push the current tuple
     * @param set The current result set
     * @return <code>true</code> if the pushing is right, else <code>false</code>
     */
    public boolean push(ResultSet set)
    {
        JSONArray json = new JSONArray();
        try {
            ResultSetMetaData data = set.getMetaData();
            int count = data.getColumnCount(), i;
            for(i = 1; i <= count;i ++)
            {
                String columnName = data.getColumnLabel(i);
                String tableName = data.getTableName(i);
                String columnValue = set.getString(i);
                json.put(new JSONObject()
                    .put(TABLE_JSON_KEY, tableName)
                    .put(COLUMN_VALUE_JSON_KEY, columnValue)
                    .put(COLUMN_NAME_JSON_KEY, columnName)
                );
            }

            this.set.put(json);
        } catch(SQLException exception)
        {
            System.out.println(exception.getMessage());
            return false;
        }

        return true;
    }

    public <T> SQLCollection<T> build(Class<T> clazz)
    {
        IClassBuilder builder = new ClassBuilder();
        return builder.build(clazz, this);
    }

    // --------- Getters --------- //

    /**
     * Gte the current result 
     * @return The result
     */
    public JSONArray getResult()
    {
        return this.set;
    }
}