package orm.query.condition;

import orm.query.operator.SQLOperator;

public class WhereCondition
{   
    /**
     * The target field of the condition
     */
    private String field;

    /**
     * The operator used for the condition
     */
    private SQLOperator operator;

    /**
     * The value for the condition
     */
    private String value;

    /**
     * The constructor of the WhereCondition
     * @param field The target field of the condition
     * @param operator The operator for the condition
     * @param value The target value for the condition
     */
    public WhereCondition(String field, SQLOperator operator, Object value)
    {
        this.field = field;
        this.operator = operator;
        this.value = new StringBuffer().append(value).toString();
    }

    // ---------- Getters --------- //
    
    /**
     * Gte the field of the confition
     * @return The field of the condition
     */
    public String getField()
    {
        return this.field;
    }

    /**
     * Get the operator of the condition
     * @return The operator of the condition
     */
    public SQLOperator getOperator()
    {
        return this.operator;
    }

    /**
     * Get the target value of the condition
     * @return The target value of the condition
     */
    public String getValue()
    {
        return this.value;
    }


    // ---------- Setters --------- //

    /**
     * Set a new field for the condition
     * @param field The new value
     */
    public void setField(String field)
    {
        this.field = field;
    }

    /**
     * Set a new operator for the condition
     * @param operator The new operator
     */
    public void setOperator(SQLOperator operator)
    {
        this.operator = operator;
    }

    /**
     * Set a new value for the condition
     * @param value The new value
     */
    public void setValue(Object value)
    {
        this.value = new StringBuffer().append(value).toString();
    }
}