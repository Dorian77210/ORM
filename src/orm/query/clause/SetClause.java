package orm.query.clause;

import orm.query.operator.SQLOperator;

public class SetClause extends AbstractClause
{

    /**
     * The <code>Set</code> keyword in SQL
     */
    private static final String SET_KEYWORD = "SET";

    public SetClause(boolean addComa, String column, Object value)
    {
        super();
        this.clause += addComa ? "," : SET_KEYWORD;
        this.clause += " " + column + " = '" + value + "'";

    }
}