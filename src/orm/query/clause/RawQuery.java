package orm.query.clause;

public class RawQuery extends AbstractClause
{
    /**
     * Constructor of RawQuery
     * @param sql The sql associated
     */
    public RawQuery(String sql)
    {
        super();
        this.clause += sql;
    }
}