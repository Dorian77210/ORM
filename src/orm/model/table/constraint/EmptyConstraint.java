package orm.model.table.constraint;

public class EmptyConstraint extends BaseConstraint
{

    /**
     * Default constructor of the EmptyConstraint
     */
    public EmptyConstraint()
    {

    }

    @Override
    public String getConstraintRepresentation()
    {
        return "";
    }
}