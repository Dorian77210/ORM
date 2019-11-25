package orm.query.clause;

public class LimitClause extends AbstractClause
{
    /**
     * The <code>Limit</code> keyword in SQL
     */
    private static final String LIMIT_KEYWORD = "LIMIT";    

    /**
     * Constructor of LimitClause
     * @param limit The value of the limit
     */
    public LimitClause(int limit)
    {
        super();
        this.clause += LIMIT_KEYWORD + " " + limit;
    }
}