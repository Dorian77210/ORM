package orm.test.query;

import orm.ORM;
import orm.query.SQLQuery;

import orm.test.BaseTest;
import orm.test.exception.TestFailedException;

import java.util.Arrays;
import java.util.List;

public class SQLQuerySelectDistinct extends BaseTest
{
    public SQLQuerySelectDistinct()
    {
        super();
    }

    @Override
    public void run() throws TestFailedException
    {
        SQLQuery query = ORM.selectDistinct("*");

        String sql = query.toString().replace("\n", "");
        String expectedSQL = "SELECT DISTINCT *";
        if(!expectedSQL.equals(sql))
        {
            throw new TestFailedException("The sql query '" + sql + "' is not equal to '" + expectedSQL + "'");
        }

        query = ORM.selectDistinct("titi", "tata");
        sql = query.toString().replace("\n", "");
        expectedSQL = "SELECT DISTINCT titi, tata";
        if(!expectedSQL.equals(sql))
        {
            throw new TestFailedException("The sql query '" + sql + "' is not equal to '" + expectedSQL + "'");
        }

        List<String> columns = Arrays.asList("titi", "tata");
        query = ORM.selectDistinct(columns);
        if(!expectedSQL.equals(sql))
        {
            throw new TestFailedException("The sql query '" + sql + "' is not equal to '" + expectedSQL + "'");
        }

        System.out.println("Test passed");
    }
}