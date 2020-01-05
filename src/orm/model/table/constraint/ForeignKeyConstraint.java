package orm.model.table.constraint;

public class ForeignKeyConstraint extends BaseConstraint
{

    /**
     * The <code>Foreign Key</code> keyword in SQL
     */
    private static final String FOREIGN_KEY_KEYWORD = "FOREIGN KEY";

    /**
     * The <code>References</code> keyword in SQL
     */
    private static final String REFERENCES_KEYWORD = "REFERENCES";

    /**
     * The <code>On Delete</code> keyword in SQL
     */
    private static final String ON_DELETE_KEYWORD = "ON DELETE";

    /**
     * The <code>On Update</code> keyword in SQL
     */
    private static final String ON_UPDATE_KEYWORD = "ON UPDATE";

    /**
     * The name of the constraint
     */
    private String constraintName;

    /**
     * The name of the column
     */
    private String foreignKeyColumn;

    /**
     * The name of the reference table
     */
    private String tableReference;

    /**
     * The name of the column reference
     */
    private String columnReference;

    /**
     * The action to do when delete on the column reference
     */
    private OnDelete onDelete;

    /**
     * The action to do when delete on the column reference
     */
    private OnUpdate onUpdate;

    public ForeignKeyConstraint(String constraintName, String foreignKeyColumn, String tableReference, String columnReference)
    {
        this.constraintName = constraintName;
        this.tableReference = tableReference;
        this.foreignKeyColumn = foreignKeyColumn;
        this.columnReference = columnReference;

        // default values
        this.onDelete = OnDelete.NO_ACTION;
        this.onUpdate = OnUpdate.NO_ACTION;
    }

    // ------ On Update/Delete methods ------ //

    /**
     * Set the on delete trigger for the current constraint
     * @param onDelete The new value for the trigger
     * @return The current constraint
     */
    public ForeignKeyConstraint onDelete(OnDelete onDelete)
    {
        this.onDelete = onDelete;
        return this;
    }

    /**
     * Set the on update trigger for the current constraint
     * @param onUpdate The new value for the trigger
     * @return The current constraint
     */
    public ForeignKeyConstraint onUpdate(OnUpdate onUpdate)
    {
        this.onUpdate = onUpdate;
        return this;
    }

    // ------ BaseConstraint Overrides ------ //

    @Override
    public String getConstraintRepresentation()
    {
        StringBuffer buffer = new StringBuffer();

        buffer.append("CONSTRAINT")
              .append(" `")
              .append(this.constraintName)
              .append("` ")
              .append(FOREIGN_KEY_KEYWORD)
              .append(" (")
              .append(this.foreignKeyColumn)
              .append(") ")
              .append(REFERENCES_KEYWORD)
              .append(" ")
              .append(this.tableReference)
              .append(" (")
              .append(this.columnReference)
              .append(") ")
              .append(ON_DELETE_KEYWORD)
              .append(" ")
              .append(this.onDelete)
              .append(" ")
              .append(ON_UPDATE_KEYWORD)
              .append(" ")
              .append(this.onUpdate);

        return buffer.toString();
    }
}