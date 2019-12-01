package orm.model.table.constraint;

public enum OnUpdate {
    RESTRICT("RESTRICT"),
    NO_ACTION("NO ACTION"),
    SET_NULL("SET NULL"),
    CASCADE("CASCADE");

    public final String label;
    private OnUpdate(String label)
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