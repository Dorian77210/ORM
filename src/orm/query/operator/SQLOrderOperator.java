package orm.query.operator;

public enum SQLOrderOperator {
    DESC("DESC"),
    ASC("ASC");

    public final String label;
    private SQLOrderOperator(String label)
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