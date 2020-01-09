package orm.query.clause;

public class FromClause extends AbstractClause
{
    /**
     * The clause <code>From</code> in SQL
     */
    private static final String FROM_KEYWORD = "FROM";

    /**
     * The <code>As</code> keyword in SQL
     */
    private static final String AS_KEYWORD = "AS";

    /**
     * Constructor of the FromClause
     * @param table The table for the current request
     */
    public FromClause(String table)
    {
        super();
        this.clause += FROM_KEYWORD + " " + table;
    }

    /**
     * Constructor of the FromClause
     * @param table The table for the current request
     * @param alias The alias for the table
     */
    public FromClause(String table, String alias)
    {
        this(table);
        this.clause += " " + AS_KEYWORD + " " + alias;
    }
}