package orm.query.condition;

import orm.query.clause.AbstractClause;

import java.util.ArrayList;
import java.util.List;

public class ComposedCondition  extends AbstractClause implements AbstractCondition
{
    /**
     * The begin string for a composed condition
     */
    private static final String COMPOSED_CONDITION_BEGIN = "(";

    /**
     * The end string for a composed condition
     */
    private static final String COMPOSED_CONDITION_END = ")";

    /**
     * A list with all of the condition that compose this composed condition
     */
    private List<AbstractCondition> conditions;

    public ComposedCondition(WhereCondition whereCondition)
    {
        super();
        this.conditions = new ArrayList<AbstractCondition>();
        this.conditions.add(whereCondition);
        this.clause += whereCondition.getCondition();
    }

    public ComposedCondition and(WhereCondition whereCondition)
    {
        this.conditions.add(new AndCondition(whereCondition));
        return this;
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