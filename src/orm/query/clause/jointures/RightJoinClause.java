package orm.query.clause.jointures;

public class RightJoinClause extends AbstractJoinClause
{
    /**
     * The <code>Right Join</code> keyword in SQL
     */
    private static final String RIGHT_JOIN_KEYWORD = "RIGHT JOIN";

    /**
     * Constructor of the RightJoinClause
     * @param table The target table of the jointure
     * @param firstField The first field of the jointure
     * @param secondField The second field of the jointure
     */
    public RightJoinClause(String table, String firstField, String secondField)
    {
        super(table, firstField, secondField, RIGHT_JOIN_KEYWORD);
    }
}