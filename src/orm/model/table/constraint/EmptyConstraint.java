package orm.model.table.constraint;

public class EmptyConstraint implements BaseConstraint
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