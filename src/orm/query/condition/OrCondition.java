package orm.query.condition;

import orm.query.operator.SQLOperator;

import orm.query.clause.AbstractClause;

public class OrCondition extends AbstractCondition
{
    /**
     * The <code>Or</code> keyword in SQL
     */
    private static final String OR_KEYWORD = "OR";

    /**
     * Constructor of OrCondition
     * @param field The target field of the condition
     * @param operator The SQL operator for the condition
     * @param value The target value
     */
    public OrCondition(String field, SQLOperator operator, Object value)
    {
        super(field, operator, value, OR_KEYWORD);
    }

    /**
     * Constructor of OrCondition
     * @param condition The condition
     */
    public OrCondition(WhereCondition condition)
    {
        this(condition.getField(), condition.getOperator(), condition.getValue());
    }

    /**
     * Constructor of OrCondition
     * @param clause The target clause
     */
    public OrCondition(AbstractClause clause)
    {
        super(clause, OR_KEYWORD);
    }
}