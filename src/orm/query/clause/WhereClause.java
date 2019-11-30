package orm.query.clause;

import orm.query.operator.SQLOperator;
import orm.query.condition.WhereCondition;
import orm.query.SQLQuery;

public class WhereClause extends AbstractClause
{
    /**
     * The <code>Where</code> keyword in SQL
     */
    protected static final String WHERE_KEYWORD = "WHERE";

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
            .append(" '")
            .append(new StringBuilder().append(value)
            .append("'")
            .toString());

        this.clause = buffer.toString();
    }

    /**
     * Constructor of the WhereClause
     * @param whereCondition The condition associated with the WhereClause
     */
    public WhereClause(WhereCondition whereCondition)
    {
        this(whereCondition.getField(), whereCondition.getOperator(), whereCondition.getValue());
    }

    /**
     * Constructor of the WhereClause
     * @param field The target field for the condition
     * @param operator The operator for the condition
     * @param query The target value
     */
    public WhereClause(String field, SQLOperator operator, SQLQuery query)
    {
        super();
        StringBuffer buffer = new StringBuffer()
            .append(WHERE_KEYWORD)
            .append(" ")
            .append(field)
            .append(" ")
            .append(operator)
            .append(" (")
            .append(query.toString())
            .append(" )");

        this.clause = buffer.toString();
    }
}