package orm.query.condition;

import orm.query.operator.SQLOperator;

import orm.query.clause.AbstractClause;
import orm.query.SQLQuery;
import orm.query.clause.ExistsClause;

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

    /**
     * Constructor of the AndCondition
     * @param field The target field of the condition
     * @param operator The SQL operator for the condition
     * @param query The target query value
     */
    public AndCondition(String field, SQLOperator operator, SQLQuery query)
    {
        super(field, operator, query, AND_KEYWORD);
    }
    
    /**
     * Constructor of AndCondition
     * @param conditions The conditions that formed the current condition
     */
    public AndCondition(AbstractCondition ...conditions)
    {
        super();
        this.clause += AND_KEYWORD + " (";

        for(AbstractCondition condition : conditions)
        {
            this.clause += " " + condition.getClause() + " ";
        }

        this.clause += ")";
    }

    /**
     * Constructor of AndCondition
     * @param existsClause The exists clause for the condition
     */
    public AndCondition(ExistsClause existsClause)
    {
        super();
        this.clause += AND_KEYWORD + " " + existsClause.getClause();
    }
}