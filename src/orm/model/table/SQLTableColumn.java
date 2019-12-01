package orm.model.table;

public class SQLTableColumn
{
    /**
     * Static variable to don't take the size
     */
    private static final int INVALID_SIZE = -1;

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

    /**
     * Attribute to know if the column is auto increment
     */
    private boolean isAutoIncrement;

    /**
     * Attribute to know if the column is nullable
     */
    private boolean isNullable;

    /**
     * Attribute for specifics columns as Varchar
     */
    private int size;
    

    public SQLTableColumn(String columnName, SQLTableType columnType)
    {
        this.columnName = columnName;
        this.columnType = columnType;
        this.defaultValue = "";
        this.size = INVALID_SIZE;
    }

    public SQLTableColumn(String columnName, SQLTableType columnType, int size)
    {
        this(columnName, columnType);
        this.size = size;
    }

    @Override
    public String toString()
    {
        return this.columnName + " " + columnType;
    }
}