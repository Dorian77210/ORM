package orm.query.clause.ensemblist;

import orm.query.SQLQuery;

public class UnionAllClause extends AbstractEnsemblistClause
{
    /**
     * The <code>Union All</code> keyword in SQL
     */
    private static final String UNION_ALL_KEYWORD = "UNION ALL";

    /**
     * Constructor of the UnionAllClause
     * @param clause The current clause
     */
    public UnionAllClause(String clause)
    {
        super(UNION_ALL_KEYWORD, clause);
    }

    /**
     * Constructor of the UnionAllClause
     * @param query The target query
     */
    public UnionAllClause(SQLQuery query)
    {
        this(query.toString());
    }
}