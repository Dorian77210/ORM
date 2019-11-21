package orm.query.condition;

import orm.query.operator.SQLOperator;

import orm.query.clause.AbstractClause;

public class AndCondition extends AbstractCondition
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
        super(field, operator, value, AND_KEYWORD);
    }

    /**
     * Constructor of AndConditon
     * @param condition The condition
     */
    public AndCondition(WhereCondition condition)
    {
        this(condition.getField(), condition.getOperator(), condition.getValue());
    }

    /**
     * Constructor of AndCondition
     * @param clause The target clause
     */
    public AndCondition(AbstractClause clause)
    {
        super(clause, AND_KEYWORD);
    }
}