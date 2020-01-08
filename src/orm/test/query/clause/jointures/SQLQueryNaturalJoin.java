package orm.test.query.clause.jointures;

import orm.test.BaseTest;
import orm.test.exception.TestFailedException;

import orm.ORM;
import orm.query.SQLQuery;
import java.util.Arrays;

public class SQLQueryNaturalJoin extends BaseTest
{
    public SQLQueryNaturalJoin()
    {
        super();
    }

    @Override
    public void run() throws TestFailedException
    {
        SQLQuery query = ORM.select("*").from("User").naturalJoin("Post");

        String sql = query.toString();
        String expectedSQL = "SELECT *\nFROM User\nNATURAL JOIN Post";
        if(!expectedSQL.equals(sql))
        {
            throw new TestFailedException("The sql query '" + sql + "' is not equal to '" + expectedSQL + "'");
        }

        query = ORM.selectDistinct("*").from("User").naturalJoin("Post");

        sql = query.toString();
        expectedSQL = "SELECT DISTINCT *\nFROM User\nNATURAL JOIN Post";
        if(!expectedSQL.equals(sql))
        {
            throw new TestFailedException("The sql query '" + sql + "' is not equal to '" + expectedSQL + "'");
        }

        query = ORM.select("titi", "tata").from("User").naturalJoin("Post");
        sql = query.toString();
        expectedSQL = "SELECT titi, tata\nFROM User\nNATURAL JOIN Post";
        if(!expectedSQL.equals(sql))
        {
            throw new TestFailedException("The sql query '" + sql + "' is not equal to '" + expectedSQL + "'");
        }

        query = ORM.select(Arrays.asList("titi", "tata")).from("User").naturalJoin("Post");
        sql = query.toString();
        if(!expectedSQL.equals(sql))
        {
            throw new TestFailedException("The sql query '" + sql + "' is not equal to '" + expectedSQL + "'");
        }

        System.out.println("Test 'SQLQueryNaturalJoin' passed");
    }
}