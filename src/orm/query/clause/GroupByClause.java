package orm.query.clause;

public class GroupByClause extends AbstractClause
{
    /**
     * The <code>Group By</code> keyword in SQL
     */
    private static final String GROUP_BY_KEYWORD = "GROUP BY";

    /**
     * Constructor of GroupByClause
     * @param column The target column
     */
    public GroupByClause(String ...columns)
    {
        super();
        this.clause += GROUP_BY_KEYWORD + " ";

        int i, length = columns.length;

        for(i = 0; i < length; i++)
        {
            String column = columns[i];
            this.clause += column;
            if(i != (length - 1))
            {
                this.clause += ",";
            }
        }
    }
}