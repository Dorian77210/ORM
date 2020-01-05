package orm.model.table.constraint;

public abstract class BaseConstraint
{   
    /**
     * Default constructor of BaseConstraint
     */
    public BaseConstraint()
    {
        super();
    }

    /**
     * Get a stringified representation of the current constraint
     * @return Te stringified representation of the current constraint
     */
    public abstract String getConstraintRepresentation();
}