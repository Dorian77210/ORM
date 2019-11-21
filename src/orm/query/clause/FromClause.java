package orm.query.clause;

public class FromClause extends AbstractClause
{
    /**
     * The clause <code>From</code> in SQL
     */
    private static final String FROM_KEYWORD = "FROM";

    /**
     * Constructor of the FromClause
     * @param table The table for the current request
     */
    public FromClause(String table)
    {
        super();
        this.clause += FROM_KEYWORD + " " + table;
    }
}