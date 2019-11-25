package orm.query;

// local imports
import orm.query.clause.AbstractClause;

import java.util.List;
import java.util.ArrayList;

public abstract class AbstractSQLQuery
{

    /**
     * List of all of the clauses that composed the SQL query
     */
    protected List<AbstractClause> clauses;

    /**
     * Boolean that permit to know if the query (Update/Insert) has got values
     */
    protected boolean containsValues;

    /**
     * Constructor of the AbstractSQLQuery
     */
    public AbstractSQLQuery()
    {
        this.containsValues = false;
        this.clauses = new ArrayList<AbstractClause>();
    }

    /**
     * Constructor of the AbstractSQLQuery
     * @param clauses The clauses that composed the current query
     */
    public AbstractSQLQuery(AbstractClause ...clauses)
    {
        this();
        int i;
        for(i = 0; i < clauses.length; i++)
        {
            AbstractClause clause = clauses[i];
            this.clauses.add(clause);
        }
    }
}