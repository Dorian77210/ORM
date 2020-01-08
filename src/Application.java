import orm.ORM;

import orm.test.util.TestRunner;
import orm.test.query.clause.ensemblist.*;
import orm.test.query.clause.jointures.*;

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
                TestRunner.runTest(SQLQueryFrom.class);
                TestRunner.runTest(SQLQueryNaturalJoin.class);
                TestRunner.runTest(SQLQueryCrossJoin.class);
                TestRunner.runTest(SQLQueryRightJoin.class);
                TestRunner.runTest(SQLQueryLeftJoin.class);
                TestRunner.runTest(SQLQueryInnerJoin.class);
                TestRunner.runTest(SQLQueryFullJoin.class);

                TestRunner.runTest(SQLQueryIntersect.class);
                TestRunner.runTest(SQLQueryMinus.class);
                TestRunner.runTest(SQLQueryUnion.class);
                TestRunner.runTest(SQLQueryUnionAll.class);
            }
        }
    }
}