package orm.model.table;

// local imports
import orm.model.table.constraint.BaseConstraint;
import orm.model.table.constraint.CheckConstraint;
import orm.model.table.constraint.ForeignKeyConstraint;
import orm.model.table.constraint.PrimaryKeyConstraint;
import orm.query.operator.SQLOperator;
import orm.ORM;

import java.util.List;
import java.util.ArrayList;

public class SQLTable
{
    /**
     * The <code>Create Table</code> keyword in SQL
     */
    private static final String CREATE_TABLE_KEYWORD = "CREATE TABLE";

    /**
     * The name of the table
     */
    private String tableName;   

    /**
     * The list of the columns of the table
     */
    private List<SQLTableColumn> columns;

    /**
     * The list of the constraints for the table
     */
    private List<BaseConstraint> constraints;

    public SQLTable(String name)
    {
        this.tableName = name;
        this.columns = new ArrayList<SQLTableColumn>();
        this.constraints = new ArrayList<BaseConstraint>();
    }

    // -------- Types methods ------- //    

    /**
     * Create a big integer column for the current table
     * @param columnName The name of the column
     * @return The new SQLTableColumn created
     */
    public SQLTableColumn bigInteger(String columnName)
    {
        return this.addColumn(columnName, SQLTableType.BIGINT);
    }

    /**
     * Create a binary column for the current table
     * @param columnName The name of the column
     * @return The new SQLTableColumn created
     */
    public SQLTableColumn binary(String columnName)
    {
        return this.addColumn(columnName, SQLTableType.BINARY);
    }

    /**
     * Create a boolean column for the current table
     * @param columnName The name of the column
     * @return The new SQLTableColumn created
     */
    public SQLTableColumn bool(String columnName)
    {
        return this.addColumn(columnName, SQLTableType.BOOLEAN);
    }

    /**
     * Create a blob column for the current table
     * @param columnName The name of the column
     * @return The new SQLTableColumn created
     */
    public SQLTableColumn blob(String columnName)
    {
        return this.addColumn(columnName, SQLTableType.BLOB);
    }

    /**
     * Create a date column for the current table
     * @param columnName The name of the column
     * @return The new SQLTableColumn created
     */
    public SQLTableColumn date(String columnName)
    {
        return this.addColumn(columnName, SQLTableType.DATE);
    }

    /**
     * Create a datetime column for the current column
     * @param columnName The name of the column
     * @return The new SQLTableColumn created
     */
    public SQLTableColumn dateTime(String columnName)
    {
        return this.addColumn(columnName, SQLTableType.DATETIME);
    }

    /**
     * Create a decimal column for the current table
     * @param columnName The name of the column
     * @return The new SQLTableColumn created
     */
    public SQLTableColumn decimal(String columnName)
    {
        return this.addColumn(columnName, SQLTableType.DECIMAL);
    }

    /**
     * Create a simple double column for the current table
     * @param columnName The name of the column
     * @return The new SQLTableColumn created
     */
    public SQLTableColumn doubleSimplePrecision(String columnName)
    {
        return this.addColumn(columnName, SQLTableType.DOUBLE);
    }

    /**
     * Create a double precision column for the current table
     * @param columnName The name of the column
     * @return The new SQLTableColumn created
     */
    public SQLTableColumn doublePrecision(String columnName)
    {
        return this.addColumn(columnName, SQLTableType.DOUBLE_PRECISION);
    }

    /**
     * Create a float column for the current table
     * @param columnName The name of the column
     * @return The new SQLTableColumn created
     */
    public SQLTableColumn floatNumber(String columnName)
    {
        return this.addColumn(columnName, SQLTableType.FLOAT);
    }

    /**
     * Create an integer column for the current table
     * @param columnName The name of the column
     * @return The new SQLTableColumn created
     */
    public SQLTableColumn integer(String columnName)
    {
        return this.addColumn(columnName, SQLTableType.INT);
    }

    /**
     * Create a json column for the current table
     * @param columnName The name of the column
     * @return The new SQLTableColumn created
     */
    public SQLTableColumn json(String columnName)
    {
        return this.addColumn(columnName, SQLTableType.JSON);
    }

    /**
     * Create a long blob column for the current table
     * @param columnName The name of the column
     * @return The new SQLTableColumn created
     */
    public SQLTableColumn longBlob(String columnName)
    {
        return this.addColumn(columnName, SQLTableType.LONG_BLOB);
    }

    /**
     * Create a long text column for the current table
     * @param columnName The name of the column
     * @return The new SQLTableColumn created
     */
    public SQLTableColumn longText(String columnName)
    {
        return this.addColumn(columnName, SQLTableType.LONG_TEXT);
    }

    /**
     * Create a medium blob for the current table
     * @param columnName The name of the column
     * @return The new SQLTableColumn created
     */
    public SQLTableColumn mediumBlob(String columnName)
    {
        return this.addColumn(columnName, SQLTableType.MEDIUM_BLOB);
    }

    /**
     * Create a medium int column for the current table
     * @param columnName The name of the column
     * @return The new SQLTableColumn created
     */
    public SQLTableColumn mediumInteger(String columnName)
    {
        return this.addColumn(columnName, SQLTableType.MEDIUM_INT);
    }

    /**
     * Create a medium text column for the current table
     * @param columnName The name of the column
     * @return The new wSQLTableColumn created
     */
    public SQLTableColumn mediumText(String columnName)
    {
        return this.addColumn(columnName, SQLTableType.MEDIUM_TEXT);
    }

    /**
     * Create a real column for the current table
     * @param columnName The name of the column
     * @return The new SQLTableColumn created
     */
    public SQLTableColumn real(String columnName)
    {
        return this.addColumn(columnName, SQLTableType.REAL);
    }

    /**
     * Create a small integer column for the current table
     * @param columnName The name of the column
     * @return The new SQLTableColumn created
     */
    public SQLTableColumn smallInteger(String columnName)
    {
        return this.addColumn(columnName, SQLTableType.SMALLINT);
    }

    /**
     * Create a varchar column for the current table
     * @param columnName The name of the column
     * @param size The size of the string 
     * @return The new SQLTableColumn created
     */
    public SQLTableColumn string(String columnName, int size)
    {
        return this.addColumn(columnName, SQLTableType.VARCHAR, size);
    }

    /**
     * Create a text column for the current table
     * @param columnName The name of the column
     * @return The new SQLTableColumn created
     */
    public SQLTableColumn text(String columnName)
    {
        return this.addColumn(columnName, SQLTableType.TEXT);
    }

    /**
     * Create a tiny integer column for the current table
     * @param columnName The name of the column
     * @return The new SQLTableColumn created
     */
    public SQLTableColumn tinyInteger(String columnName)
    {
        return this.addColumn(columnName, SQLTableType.TINY_INT);
    }

    /**
     * Create a tiny text column for the current table
     * @param columnName The name of the column
     * @return The new SQLTableColumn created
     */
    public SQLTableColumn tinyText(String columnName)
    {
        return this.addColumn(columnName, SQLTableType.TINYTEXT);
    }

    /**
     * Create an unsigned big integer column for the current table
     * @param columnName The name of the column
     * @return The new SQLTableColumn created
     */
    public SQLTableColumn unsignedBigInteger(String columnName)
    {
        return this.addColumn(columnName, SQLTableType.UNSIGNED_BIGINT);
    }

    /**
     * Create an unsigned decimal column for the current table
     * @param columnName The name of the column
     * @return The new SQLTableColumn created
     */
    public SQLTableColumn unsignedDecimal(String columnName)
    {
        return this.addColumn(columnName, SQLTableType.UNSIGNED_DECIMAL);
    }

    /**
     * Create an unsigned double column for the current table
     * @param columnName The name of the column
     * @return The new SQLTableColumn created
     */
    public SQLTableColumn unsignedDouble(String columnName)
    {
        return this.addColumn(columnName, SQLTableType.UNSIGNED_DOUBLE);
    }

    /**
     * Create an unsigned double precision for the current table
     * @param columnName The name of the column
     * @return The new SQLTableColumn created
     */
    public SQLTableColumn unsignedDoublePrecision(String columnName)
    {
        return this.addColumn(columnName, SQLTableType.UNSIGNED_DOUBLE_PRECISION);
    }

    /**
     * Create an unsigned float for the current table
     * @param columnName The name of the column
     * @return The new SQLTableColumn created
     */
    public SQLTableColumn unsignedFloat(String columnName)
    {
        return this.addColumn(columnName, SQLTableType.UNSIGNED_FLOAT);
    }

    /**
     * Create an unsigned integer column for the current table
     * @param columnName The name of the column
     * @return The new SQLTableColumn created
     */
    public SQLTableColumn unsignedInteger(String columnName)
    {
        return this.addColumn(columnName, SQLTableType.UNSIGNED_INT);
    }

    /**
     * Create an unsigned real column for the current table
     * @param columnName The name of the column
     * @return The new SQLTableColumn created
     */
    public SQLTableColumn unsignedReal(String columnName)
    {
        return this.addColumn(columnName, SQLTableType.UNSIGNED_REAL);
    }

    /**
     * Create an unsigned small integer for the current table
     * @param columnName The name of the column
     * @return The new SQLTableColumn created
     */
    public SQLTableColumn unsignedSmallInteger(String columnName)
    {
        return this.addColumn(columnName, SQLTableType.UNSIGNED_SMALLINT);
    }

    public SQLTableColumn unsignedTinyInteger(String columnName)
    {
        return this.addColumn(columnName, SQLTableType.UNSIGNED_TINY_INT);
    }

    /**
     * Generic method to add a column in the table
     * @param columnName The name of the column
     * @param type The type of the column
     * @return The new SQLTableColumn created
     */
    private SQLTableColumn addColumn(String columnName, SQLTableType type)
    {
        SQLTableColumn column = new SQLTableColumn(columnName, type);
        this.columns.add(column);
        return column;
    }

    /**
     * Generic method to add a column in the table
     * @param columnName The name of the column
     * @param type The type of the column
     * @param size The size for the column
     * @return The new SQLTableColumn created
     */
    private SQLTableColumn addColumn(String columnName, SQLTableType type, int size)
    {
        SQLTableColumn column = new SQLTableColumn(columnName, type, size);
        this.columns.add(column);
        return column;
    }



    // -------- Constraints methods ------- //
    
    /**
     * Add a foreign key in the table
     * @param constraintName The name of the constraint
     * @param foreignKeyColumn The target column for the foreign key
     * @param tableReference The name of the target table
     * @param columnReference The name of the target column
     * @return The associated ForeignKeyConstraint
     */
    public ForeignKeyConstraint foreignKey(String constraintName, String foreignKeyColumn, String tableReference, String columnReference)
    {
        ForeignKeyConstraint foreignKeyConstraint = new ForeignKeyConstraint(constraintName, foreignKeyColumn, tableReference, columnReference);
        this.constraints.add(foreignKeyConstraint);
        return foreignKeyConstraint;
    }

    /**
     * Add a primary key constraint in the table
     * @param fields The list of fields that composed the constraint
     */
    public void primaryKey(String ...fields)
    {
        PrimaryKeyConstraint primaryKeyConstraint = new PrimaryKeyConstraint(fields);
        this.constraints.add(primaryKeyConstraint);
    }

    /**
     * Add a check constraint in the table
     * @param field The target field for the constraint
     * @param operator The operator for the constraint
     * @param value The target value for the constraint
     */
    public void checkConstraint(String field, SQLOperator operator, Object value)
    {
        CheckConstraint checkConstraint = new CheckConstraint(field, operator, value);
        this.constraints.add(checkConstraint);
    }

    // -------- Updates methods ------ //

    /**
     * Create the current table in the database
     * @return <code>true</code> if it was a success, else <code>false</code>
     */
    public boolean create()
    {
        return ORM.createTable(this).executeUpdate() != null;
    }

    /**
     * Drop the current table
     * @return <code>true</code> if it was a success, else <code>false</code>
     */
    public boolean drop()
    {
        return ORM.deleteFrom(this.tableName).executeUpdate() != null;
    }

    // ------ toString ------ //
    @Override
    public String toString()
    {
        StringBuffer buffer = new StringBuffer();
        String representation;
        int i, columnsCount = this.columns.size(), constraintsCount = this.constraints.size();

        buffer.append(CREATE_TABLE_KEYWORD).append(" ").append(this.tableName).append(" (\n");

        // columns edition
        for(i = 0; i < columnsCount; i++)
        {
            SQLTableColumn column = this.columns.get(i);
            representation = "\t" + column.toString().trim();
            if(i == columnsCount)
            {
                if(constraintsCount > 0)
                {
                    representation += ",";
                }
            } else
            {
                if(i != (columnsCount - 1))
                {
                    representation += ",\n";
                }
            }

            buffer.append(representation);
        }

        // constraints edition
        for(i = 0; i < constraintsCount; i++)
        {
            BaseConstraint constraint = this.constraints.get(i);
            representation = ",\n\t" + constraint.getConstraintRepresentation().trim();

            buffer.append(representation);
        }

        buffer.append("\n);");

        return buffer.toString();
    }
}