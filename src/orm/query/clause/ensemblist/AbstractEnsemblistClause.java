package orm.query.clause.ensemblist;

import orm.query.clause.AbstractClause;

public abstract class AbstractEnsemblistClause extends AbstractClause
{
    /**
     * Constructor of the AbstractEnsemblistClause
     * @param operator The ensemblist operator
     * @param clause The clause 
     */
    public AbstractEnsemblistClause(String operator, String clause)
    {
        super();
        this.clause += operator + " (" + clause + ")";
    }
}