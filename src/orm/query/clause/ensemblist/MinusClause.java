package orm.query.clause.ensemblist;

import orm.query.SQLQuery;

public class MinusClause extends AbstractEnsemblistClause
{
    /**
     * The <code>Minus</code> keyword in SQL
     */
    private static final String MINUS_KEYWORD = "MINUS";

    /**
     * Constructor of the MinusClause
     * @param clause The clause 
     */
    public MinusClause(String clause)
    {
        super(MINUS_KEYWORD, clause);
    }

    /**
     * Constructor of the MinusClause
     * @param query The associated query
     */
    public MinusClause(SQLQuery query)
    {
        this(query.toString());
    }
} 