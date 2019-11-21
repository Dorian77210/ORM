package orm.query.clause;

public class LeftJoinClause extends AbstractJoinClause
{
    /**
     * The <code>Left Join</code> keyword in SQL
     */
    private static final String LEFT_JOIN_KEYWORD = "LEFT JOIN";

    /**
     * Constructor of the LeftJoinClause
     * @param table The target table for the jointure
     * @param firstField The first field of the jointure
     * @param secondField The second field of the jointure
     */
    public LeftJoinClause(String table, String firstField, String secondField)
    {
        super(table, firstField, secondField, LEFT_JOIN_KEYWORD);
    }
}