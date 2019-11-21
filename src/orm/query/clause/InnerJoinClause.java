package orm.query.clause;

public class InnerJoinClause extends AbstractJoinClause
{
    /**
     * The clause <code>Inner Join</code> in SQL
     */
    private static final String INNER_JOIN_KEYWORD = "INNER JOIN";

    /**
     * Constructor of the <code>InnerJoinClause</codeW
     * @param table The target table of the jointure
     * @param firstField The first field of the jointure
     * @param secondField The second field of the jointure
     */
    public InnerJoinClause(String table, String firstField, String secondField)
    {
        super(table, firstField, secondField, INNER_JOIN_KEYWORD);
    }
}