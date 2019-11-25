package orm.query.clause;

/**
 * The class <code>AbstractClause</code> is an abstraction of the different clauses existing in SQL
 * @version 1.0
 * @author Dorian TERBAH
 */

public abstract class AbstractClause
{   
    /**
     * The current clause in String
     */
    protected String clause;

    /**
     * Constructor of AbstractClause
     * @param content The content of the clause
     */
    public AbstractClause(String clause)
    {
        this.clause = clause;
    }

    /**
     * Constructor of AbstractClause
     */
    public AbstractClause()
    {
        this("");
    }

    /**
     * Set a new value for the current clause
     * @param clause The new value for the clause
     */
    public void setClause(String clause)
    {
        this.clause = clause;
    }

    /**
     * Get the content of the clause
     * @return
     */
    public String getClause()
    {
        return this.clause;
    }
}