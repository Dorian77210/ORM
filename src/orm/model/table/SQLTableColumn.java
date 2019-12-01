package orm.model.table;

public class SQLTableColumn
{

    /**
     * The type of the column
     */
    private SQLTableType columnType;

    /**
     * Name of the column
     */
    private String columnName;

    /**
     * The defaut value of the column
     */
    private Object defaultValue;

    

    public SQLTableColumn(String columnName, SQLTableType columnType)
    {
        this.columnName = columnName;
        this.columnType = columnType;
        this.defaultValue = "";
    }

    @Override
    public String toString()
    {
        return this.columnName + " " + columnType;
    }
}