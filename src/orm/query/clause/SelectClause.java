package orm.query.clause;

// local imports
import orm.query.operator.SQLSelectOperator;

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
        this(field, false);
    }

    /**
     * Constructor of the SelectClause
     * @param field The current clause
     * @param distinct A boolean to know if the selection is distinct or not
     */
    public SelectClause(String field, boolean distinct)
    {
        super();
        this.clause += SELECT_KEYWORD + " ";
        if(distinct)
        {
            this.clause += SQLSelectOperator.DISTINCT + " ";
        }

        this.clause += field;
    }
    
    /**
     * Constructor of the SelectClause
     * @param distinct A boolean to know if the selection is distinct or not
     * @param args The differents params to select for the final query
     */
    public SelectClause(boolean distinct, String ...args)
    {
        super();
        this.clause += SELECT_KEYWORD;
        
        if(distinct)
        {
            this.clause += " " + SQLSelectOperator.DISTINCT;
        }

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
    public SelectClause(String ...args)
    {
        this(false, args);
    }

    /**
     * Constructor of the SelectClause
     * @param args The differents params to select for the final query
     * @param distinct A boolean to know if the selection is distinct or not
     */
    public SelectClause(List<String> args, boolean distinct)
    {   
        super();
        this.clause += SELECT_KEYWORD;
        if(distinct)
        {
            this.clause += " " + SQLSelectOperator.DISTINCT;
        }

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

    /**
     * Constructor of the SelectClause
     * @param args The differents params to select for the final query
     */
    public SelectClause(List<String> args)
    {
        this(args, false);
    }
}