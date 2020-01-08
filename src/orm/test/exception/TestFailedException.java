package orm.test.exception;

public class TestFailedException extends Exception
{
    /**
     * Constructor of TestFailedException
     * @param message The message of the exception
     */
    public TestFailedException(String message)
    {
        super(message);
    }
}