package orm.model.table;

public class SQLTableColumn
{
    /**
     * Static variable to don't take the size
     */
    private static final int INVALID_SIZE = -1;

    /**
     * The <code>Auto Increment</code> keyword in SQL
     */
    private static final String AUTO_INCREMENT_KEYWORD = "AUTO_INCREMENT";

    /**
     * The <code>Default</code> keyword in SQL
     */
    private static final String DEFAULT_KEYWORD = "DEFAULT";

    /**
     * The <code>Not Null</code keyword in SQL
     */
    private static final String NOT_NULL_KEYWORD = "NOT NULL";

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
        this.defaultValue = null;
        this.isNullable = false;
        this.isAutoIncrement = false;
        this.size = INVALID_SIZE;
    }

    public SQLTableColumn(String columnName, SQLTableType columnType, int size)
    {
        this(columnName, columnType);
        this.size = size;
    }

    // ------ Setter methods ------ //

    /**
     * Set a default value for the current column
     * @param value The default value
     * @return The current SQLTableColumn
     */
    public SQLTableColumn defaultValue(Object value)
    {
        this.defaultValue = value;
        return this;
    }

    /**
     * Set at <code>true</code> the nullable status
     * @return The current SQLTableColumn
     */
    public SQLTableColumn nullable()
    {
        this.isNullable = true;
        return this;
    }

    /**
     * Set at <code>true</code> the auto increment status
     * @return The current SQLTableColumn
     */
    public SQLTableColumn autoIncrement()
    {
        this.isAutoIncrement = true;
        return this;
    }

    @Override
    public String toString()
    {
        StringBuffer buffer = new StringBuffer();
        buffer.append(this.columnName)
              .append(" ")
              .append(this.columnType)
              .append(this.size != INVALID_SIZE ? "(" + this.size + ")" : "")
              .append(" ")
              .append(this.isNullable ? "" : NOT_NULL_KEYWORD)
              .append(" ")
              .append(this.defaultValue != null ? DEFAULT_KEYWORD + " '" + this.defaultValue + "'" : "")
              .append(" ")
              .append(this.isAutoIncrement ? AUTO_INCREMENT_KEYWORD : "");

        return buffer.toString();
    }
}