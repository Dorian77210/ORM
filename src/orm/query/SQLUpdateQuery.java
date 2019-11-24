package orm.query;

// local imports
import orm.query.clause.AbstractClause;

public class SQLUpdateQuery extends AbstractSQLQuery
{
    
    // -------- Constructors ------- //

    /**
     * Constructor of the SQLUpdateQuery
     */
    public SQLUpdateQuery()
    {
        super();
    }

    /**
     * Constructor of the SQLQuery
     * @param clauses The clauses that composed the current query
     */
    public SQLUpdateQuery(AbstractClause ...clauses)
    {
        super(clauses);
    }
}