package orm.query.condition;

import orm.query.clause.AbstractClause;

public class BetweenCondition extends AbstractCondition
{
    /**
     * The <code>Between</code> keyword in SQL
     */
    private static final String BETWEEN_KEYWORD = "BETWEEN";

    /**
     * Constructor of the BetweenCondition
     * @param field The target field
     * @param firstValue The first value of the condition
     * @param secondValue The second value of the condition
     */
    public BetweenCondition(String field, Object firstValue, Object secondValue)
    {
        super();
        StringBuffer buffer = new StringBuffer()
            .append(field)
            .append(" ")
            .append(BETWEEN_KEYWORD)
            .append(" ")
            .append(firstValue)
            .append(" AND ")
            .append(secondValue);

        this.clause = buffer.toString();
    }
}