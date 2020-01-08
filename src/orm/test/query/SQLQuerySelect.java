package orm.test.query;

import orm.ORM;
import orm.query.SQLQuery;

import orm.test.BaseTest;
import orm.test.exception.TestFailedException;

import java.util.List;
import java.util.Arrays;

public class SQLQuerySelect extends BaseTest
{
    public SQLQuerySelect()
    {
        super();
    }

    @Override
    public void run() throws TestFailedException
    {
        SQLQuery query = ORM.select("*");

        String sql = query.toString().replace("\n", "");
        String expectedSQL = "SELECT *";
        if(!expectedSQL.equals(sql))
        {
            throw new TestFailedException("The sql query '" + sql + "' is not equal to '" + expectedSQL + "'");
        }

        query = ORM.select("titi", "tata");
        sql = query.toString().replace("\n", "");
        expectedSQL = "SELECT titi, tata";
        if(!expectedSQL.equals(sql))
        {
            throw new TestFailedException("The sql query '" + sql + "' is not equal to '" + expectedSQL + "'");
        }

        List<String> columns = Arrays.asList("titi", "tata");
        query = ORM.select(columns);
        sql = query.toString().replace("\n", "");
        if(!expectedSQL.equals(sql))
        {
            throw new TestFailedException("The sql query '" + sql + "' is not equal to '" + expectedSQL + "'");
        }

        System.out.println("Test passed");
    }
}