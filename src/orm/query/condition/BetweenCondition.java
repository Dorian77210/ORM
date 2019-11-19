package orm.query.condition;

public class BetweenCondition implements AbstractCondition
{
    /**
     * The <code>Between</code> keyword in SQL
     */
    private static final String BETWEEN_KEYWORD = "BETWEEN";

    /**
     * The first value of the condition
     */
    private Object firstValue;

    /**
     * The second value of the condition
     */
    private Object secondValue;

    /**
     * The target field
     */
    private String field;

    /**
     * Constructor of the BetweenCondition
     * @param field The target field
     * @param firstValue The first value of the condition
     * @param secondValue The second value of the condition
     */
    public BetweenCondition(String field, Object firstValue, Object secondValue)
    {
        this.field = field;
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    @Override
    /**
     * Get the condition
     * @return The condition
     */
    public String getCondition()
    {
        StringBuffer buffer = new StringBuffer();
        buffer.append(this.field)
              .append(" ")
              .append(BETWEEN_KEYWORD)
              .append(" ")
              .append(new StringBuffer().append(this.firstValue).toString())
              .append(" ")
              .append(AndCondition.AND_KEYWORD)
              .append(" ")
              .append(new StringBuffer().append(this.secondValue).toString());

        return buffer.toString();
    }   
}