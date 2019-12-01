package orm.query.clause;

public class DeleteClause extends AbstractClause
{
    
    /**
     * The <code>Delete From</code> clause in SQL
     */
    private static final String DELETE_FROM_KEYWORD = "DELETE FROM";

    public DeleteClause(String table)
    {
        super();
        this.clause += DELETE_FROM_KEYWORD + " " + table;
    }
}