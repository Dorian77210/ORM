package orm.query.condition;

import orm.query.clause.AbstractClause;

import orm.query.operator.SQLOperator;

public class AbstractCondition extends AbstractClause
{   
    /**
     * Constructor of AbstractCondition
     * @param field The target field of the condition
     * @param operator The SQL operator for the condition
     * @param value The target value
     * @param conditionType The type of the condition
     */
    public AbstractCondition(String field, SQLOperator operator, Object value, String conditionType)
    {
        super();
        StringBuffer buffer = new StringBuffer()
            .append(conditionType)
            .append(" ")
            .append(field)
            .append(" ")
            .append(operator)
            .append(" ")
            .append(new StringBuffer().append(value).toString());

        this.clause += buffer.toString();
    }

    /**
     * Constructor of AbstractCondition
     * @param clause The target clause
     * @param conditionType The type of the condition
     */
    public AbstractCondition(AbstractClause clause, String conditionType)
    {
        super();
        this.clause += conditionType + " " + clause.getClause();
    }
}