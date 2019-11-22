package orm.exception;

public class BuildingObjectException extends RuntimeException
{   
    /**
     * Constructor of the BuildingObjectException
     * @param message The messg=age of the exception
     */
    public BuildingObjectException(String message)
    {
        super(message);
    }
}