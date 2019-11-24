package orm.query.operator;

public enum SQLSelectOperator {
    DISTINCT("DISTINCT"),
    ALL("ALL");

    public final String label;
    private SQLSelectOperator(String label)
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