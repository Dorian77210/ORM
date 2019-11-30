package orm.query.condition;

import orm.query.operator.SQLOperator;
import orm.query.SQLQuery;
import orm.query.clause.AbstractClause;
import orm.query.clause.ExistsClause;

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

    /**
     * Constructor of OrCondition
     * @param field The target field for the condition
     * @param operator The SQL operator for the condition
     * @param query The target query
     */
    public OrCondition(String field, SQLOperator operator, SQLQuery query)
    {
        super(field, operator, query, OR_KEYWORD);
    }

    /**
     * Constructor of OrCondition
     * @param conditions The conditions that compose the current condition
     */
    public OrCondition(AbstractCondition ...conditions)
    {
        super();
        this.clause += OR_KEYWORD + " (";

        for(AbstractCondition condition : conditions)
        {
            this.clause += " " + condition.getClause() + " ";
        }

        this.clause += ")";
    }

    /**
     * Constructor of OrCondition
     * @param existsClause An exists clause for the condition
     */
    public OrCondition(ExistsClause existsClause)
    {
        super();
        this.clause += OR_KEYWORD + " " + existsClause.getClause();
    }
}