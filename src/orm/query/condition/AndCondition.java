package orm.query.condition;

import orm.query.SQLOperator;
import orm.query.clause.AbstractClause;

public class AndCondition extends AbstractClause implements AbstractCondition
{
    /**
     * The <code>And</code> keyword in SQL
     */
    public static final String AND_KEYWORD = "AND";

    /**
     * Constructor of AndCondition
     * @param field The target field of the condition
     * @param operator The SQL operator for the condition
     * @param value The target value
     */
    public AndCondition(String field, SQLOperator operator, Object value)
    {
        super();
        StringBuffer buffer = new StringBuffer()
            .append(AND_KEYWORD)
            .append(" ")
            .append(field)
            .append(" ")
            .append(operator)
            .append(" ")
            .append(new StringBuffer().append(value).toString());

        this.clause += buffer.toString();
    }

    /**
     * Constructor of AndConditon
     * @param condition The condition
     */
    public AndCondition(WhereCondition condition)
    {
        this(condition.getField(), condition.getOperator(), condition.getValue());
    }

    public AndCondition(ComposedCondition condition)
    {
        super();
        this.clause += condition.getCondition();
    }

    @Override
    /**
     * Get the condition
     * @return The condition
     */
    public String getCondition()
    {
        return this.clause;
    }
}