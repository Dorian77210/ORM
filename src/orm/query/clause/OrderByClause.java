package orm.query.clause;

import java.util.Map;
import java.util.HashMap;

// -------- local imports
import orm.query.operator.SQLOrderOperator;

public class OrderByClause extends AbstractClause
{
    /**
     * The <code>Order By</code> in SQL
     */
    private static final String ORDER_BY_KEYWORD = "ORDER_BY";
    
    /**
     * Constructor of OrdeByClause
     * @param columns
     */
    public OrderByClause(String ...columns)
    {
        super();
        this.clause += ORDER_BY_KEYWORD + " ";

        int i, length = columns.length;

        for(i = 0; i < length; i++)
        {
            String column = columns[i];
            this.clause += column;
            if(i == (length - 1))
            {
                this.clause += ",";
            }    
        }
    }

    /**
     * Constructor of OrderByClause
     * @param columns The different columns for the Order By
     * @param operators The operators for the Order By
     */
    public OrderByClause(SQLOrderOperator operator, String ...columns)
    {
        super();
        this.clause += ORDER_BY_KEYWORD + " ";

        int i, length = columns.length;

        for(i = 0; i < length; i++)
        {
            String column = columns[i];
            this.clause += column;
            if(i == (length - 1))
            {
                this.clause += ",";
            }
        }

        this.clause += " " + operator;
    }

    /**
     * Constructor of OrderByClause
     * @param map A map with association between columns and operators
     */
    public OrderByClause(Map<String, SQLOrderOperator> map)
    {
        super();
        this.clause += ORDER_BY_KEYWORD + " ";

        int i = 0, length = map.size();
        for(Map.Entry<String, SQLOrderOperator> entry : map.entrySet())
        {
            String column = entry.getKey();
            SQLOrderOperator operator = entry.getValue();
            this.clause += column + " " + operator;
            if(i == (length - 1))
            {
                this.clause += ",";
            }
            
            i++;
        }
    }
}