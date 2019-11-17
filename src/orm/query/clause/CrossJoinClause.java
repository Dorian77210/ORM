package orm.query.clause;

public class CrossJoinClause extends AbstractClause
{
    /**
     * The <code>Cross Join</code> keyword in SQL
     */
    private static final String CROSS_JOIN_KEYWORD = "CROSS JOIN";

    /**
     * Constructor of the CrossJoinClause
     * @param table The target table for the jointure
     */
    public CrossJoinClause(String table)
    {
        super();
        this.clause += CROSS_JOIN_KEYWORD + " " + table;
    }
}