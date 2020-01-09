package orm.test.util;

import java.lang.reflect.Constructor;
import orm.test.BaseTest;

public class TestRunner
{
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