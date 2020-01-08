import orm.ORM;

import orm.test.util.TestRunner;
import orm.test.query.SQLQuerySelect;
import orm.test.query.SQLQuerySelectDistinct;

public class Application
{
    public static void main(String[] args)
    {
        if (ORM.loadMariaDBDriver())
        {
            if(ORM.connect("./config.json"))
            {
                TestRunner.runTest(SQLQuerySelect.class);
                TestRunner.runTest(SQLQuerySelectDistinct.class);
            }
        }
    }
}