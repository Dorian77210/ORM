package orm.query.clause;

import orm.query.SQLOperator;

public class WhereClause extends AbstractClause
{
    /**
     * The <code>Where</code> keyword in SQL
     */
    private static final String WHERE_KEYWORD = "WHERE";

    /**
     * Constructor of the WhereClause
     * @param field The field for the condition
     * @param operator The operator for the condition
     * @param value The wanted value for the condition
     */
    public WhereClause(String field, SQLOperator operator, Object value)
    {
        super();
        StringBuffer buffer = new StringBuffer()
            .append(WHERE_KEYWORD)
            .append(" ")
            .append(field)
            .append(" ")
            .append(operator)
            .append(" ")
            .append(new StringBuilder().append(value).toString());
        
        this.clause = buffer.toString();
    }
}