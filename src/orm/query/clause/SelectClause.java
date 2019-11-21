package orm.query.clause;

import java.util.List;

public class SelectClause extends AbstractClause
{
    /**
     * The clause <code>Select</code> in SQL
     */
    private static final String SELECT_KEYWORD = "SELECT";

    /**
     * Constructor of the SelectClause
     * @param field The current clause 
     */
    public SelectClause(String field)
    {
        super();
        this.clause += SELECT_KEYWORD + " " + field;
    }

    /**
     * Constructor of the SelectClause
     * @param args The differents params to select for the final query
     */
    public SelectClause(String ...args)
    {
        super();
        this.clause += SELECT_KEYWORD;

        int i;
        for(i = 0; i < args.length; i++)
        {
            String arg = args[i];
            this.clause += " " + arg;
            if(i != (args.length - 1))
            {
                this.clause += ",";
            }
        }
    }

    /**
     * Constructor of the SelectClause
     * @param args The differents params to select for the final query
     */
    public SelectClause(List<String> args)
    {   
        super();
        this.clause += SELECT_KEYWORD;

        int i, length = args.size();
        for(i = 0; i < length; i++)
        {
            String arg = args.get(i);
            this.clause += " " + arg;
            if(i != (length - 1))
            {
                this.clause += ",";
            }
        }
    }
}