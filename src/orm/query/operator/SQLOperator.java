package orm.query.operator;

public enum SQLOperator {
    EQUAL("="),
    NOY_EQUAL("<>"),
    GREATER_THAN(">"),
    LESS_THAN("<"),
    GREATER_EQUAL_THAN(">="),
    LESS_EQUAL_THAN("<=");

    public final String label;
    private SQLOperator(String label)
    {
        this.label = label;
    }

    @Override
    /**
     * @return the String representation of the enumeration
     */
    public String toString()
    {
        return this.label;
    }
}