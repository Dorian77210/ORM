package orm.test.query.clause.jointures;

import orm.test.BaseTest;
import orm.test.exception.TestFailedException;

import orm.ORM;
import orm.query.SQLQuery;
import java.util.Arrays;

public class SQLQueryCrossJoin extends BaseTest
{
    public SQLQueryCrossJoin()
    {
        super();
    }

    @Override
    public void run() throws TestFailedException
    {
        SQLQuery query = ORM.select("*").from("User").crossJoin("Post");

        String sql = query.toString();
        String expectedSQL = "SELECT *\nFROM User\nCROSS JOIN Post";
        if(!expectedSQL.equals(sql))
        {
            throw new TestFailedException("The sql query '" + sql + "' is not equal to '" + expectedSQL + "'");
        }

        query = ORM.selectDistinct("*").from("User").crossJoin("Post");

        sql = query.toString();
        expectedSQL = "SELECT DISTINCT *\nFROM User\nCROSS JOIN Post";
        if(!expectedSQL.equals(sql))
        {
            throw new TestFailedException("The sql query '" + sql + "' is not equal to '" + expectedSQL + "'");
        }

        query = ORM.select("titi", "tata").from("User").crossJoin("Post");
        sql = query.toString();
        expectedSQL = "SELECT titi, tata\nFROM User\nCROSS JOIN Post";
        if(!expectedSQL.equals(sql))
        {
            throw new TestFailedException("The sql query '" + sql + "' is not equal to '" + expectedSQL + "'");
        }

        query = ORM.select(Arrays.asList("titi", "tata")).from("User").crossJoin("Post");
        sql = query.toString();
        if(!expectedSQL.equals(sql))
        {
            throw new TestFailedException("The sql query '" + sql + "' is not equal to '" + expectedSQL + "'");
        }

        System.out.println("Test 'SQLQueryCrossJoin' passed");
    }
}