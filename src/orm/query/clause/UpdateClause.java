package orm.query.clause;

public class UpdateClause extends AbstractClause
{
    /**
     * The <code>Update</code> keyword in SQL
     */
    private static final String UPDATE_KEYWORD = "UPDATE";

    /**
     * Constructor of UpdateClause
     * @param table The table for the Update
     */
    public UpdateClause(String table)
    {
        super();
        this.clause += UPDATE_KEYWORD + " " + table;
    }
}