package orm.model.table.constraint;

import orm.query.operator.SQLOperator;

public class CheckConstraint extends BaseConstraint
{

    /**
     * The <code>Check</code> keyword in SQL
     */
    private static final String CHECK_KEYWORD = "CHECK";

    /**
     * The field for the check constraint
     */
    private String field;

    /**
     * The SQL operator for the check constraint
     */
    private SQLOperator operator;

    /**
     * The value for the check constraint
     */
    private Object value;

    /**
     * Constructor of CheckCOnstraint
     * @param field The target field of the check constraint
     * @param operator The operator of the check constraint
     * @param value The value for the check constraint
     */
    public CheckConstraint(String field, SQLOperator operator, Object value)
    {
        super();
        this.field = field;
        this.operator = operator;
        this.value = value;
    }

    @Override
    public String getConstraintRepresentation()
    {
        final StringBuffer buffer = new StringBuffer();
        buffer.append(CHECK_KEYWORD)
              .append(" (")
              .append(this.field)
              .append(" ")
              .append(this.operator)
              .append(" ")
              .append("'")
              .append(this.value)
              .append("'")
              .append(")");
        return buffer.toString();
    }
}