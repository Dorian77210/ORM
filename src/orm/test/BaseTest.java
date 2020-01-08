package orm.test;

import orm.test.exception.TestFailedException;

public abstract class BaseTest
{
    /**
     * Constructor of BaseTest
     */
    public BaseTest()
    {

    }

    public abstract void run() throws TestFailedException;
}