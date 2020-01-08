package orm.test.util;

import java.lang.reflect.Constructor;
import orm.test.BaseTest;

public class TestRunner
{
    /**
     * Name of the method in the class of Tests
     */
    private static final String METHOD_CALLEE = "run";

    public static final <T extends BaseTest> boolean runTest(Class<T> clazz)
    {
        try
        {
            Constructor<T> constructor = clazz.getConstructor();
            BaseTest test = constructor.newInstance();
            test.run();
        } catch(Exception exception)
        {
            System.out.println(exception.getMessage());
            return false;
        }

        return true;
    }
}