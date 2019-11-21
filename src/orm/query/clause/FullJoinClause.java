package orm.query.clause;

public class FullJoinClause extends AbstractJoinClause
{
    /**
     * The <code>Full Join</code> keyword in SQL
     */
    private static final String FULL_JOIN_KEYWORD = "FULL JOIN";

    public FullJoinClause(String table, String firstField, String secondField)
    {
        super(table, firstField, secondField, FULL_JOIN_KEYWORD);
    }
}