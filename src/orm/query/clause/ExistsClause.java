package orm.query.clause;

import orm.query.SQLQuery;

public class ExistsClause extends AbstractClause
{
    /**
     * The <code>Exists</code> keyword in SQL
     */
    private static final String EXISTS_KEYWORD = "EXISTS";

    /**
     * Constructor of ExistsClause
     * @param query The query for the clause
     */
    public ExistsClause(SQLQuery query)
    {
        super();
        this.clause += "( " + query.toString() + " )";
    }
}