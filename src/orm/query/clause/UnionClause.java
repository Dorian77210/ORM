package orm.query.clause;

import orm.query.SQLQuery;

public class UnionClause extends AbstractClause
{   
    /**
     * The <code>Union</code> keyword in SQL
     */
    private static final String UNION_KEYWORD = "UNION";

    /**
     * Constructor of UnionClause
     * @param clause The current clause
     */
    public UnionClause(String clause)
    {
        super();
        this.clause += UNION_KEYWORD + " " + clause;
    }

    /**
     * Constructor of UnionClause
     * @param query The target query
     */
    public UnionClause(SQLQuery query)
    {
        this(query.toString());
    }
}