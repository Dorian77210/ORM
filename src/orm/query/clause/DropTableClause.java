package orm.query.clause;

public class DropTableClause extends AbstractClause
{   
    /**
     * The <code>Drop Table</code> keyword in SQL
     */
    private static final String DROP_TABLE_KEYWORD = "DROP TABLE";

    /**
     * Constructor of DropTableClause
     * @param tableName The name of the table
     */
    public DropTableClause(String tableName)
    {
        super();
        this.clause += DROP_TABLE_KEYWORD + " " + tableName;
    }
}