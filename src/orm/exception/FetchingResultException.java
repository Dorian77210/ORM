package orm.exception;

public class FetchingResultException extends Exception
{   
    /**
     * Constructor of FetchingResultException
     * @param message The message of the exception
     */
    public FetchingResultException(String message)
    {
        super(message);
    }
}