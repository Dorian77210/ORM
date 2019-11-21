package orm.query.clause.ensemblist;

import orm.query.SQLQuery;

public class IntersectClause extends AbstractEnsemblistClause
{
    /**
     * The <code>Intersect</code> keyword in SQL
     */
    private static final String INTERSECT_KEYWORD = "INTERSECT";

    /**
     * Constructor of IntersectClause
     * @param clause The current clause
     */
    public IntersectClause(String clause)
    {
        super(INTERSECT_KEYWORD, clause);
    }

    /**
     * Constructor of IntersectClause
     * @param query The target query of the intersection
     */
    public IntersectClause(SQLQuery query)
    {
        this(query.toString());
    }
}