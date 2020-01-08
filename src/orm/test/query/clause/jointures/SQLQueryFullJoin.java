package orm.test.query.clause.jointures;

import orm.test.BaseTest;
import orm.test.exception.TestFailedException;

import orm.ORM;
import orm.query.SQLQuery;
import java.util.Arrays;

public class SQLQueryFullJoin extends BaseTest
{
    public SQLQueryFullJoin()
    {
        super();
    }

    @Override
    public void run() throws TestFailedException
    {
        SQLQuery query = ORM.select("*").from("User").fullJoin("Post", "id", "user_id");

        String sql = query.toString();
        String expectedSQL = "SELECT *\nFROM User\nFULL JOIN Post ON id = user_id";
        if(!expectedSQL.equals(sql))
        {
            throw new TestFailedException("The sql query '" + sql + "' is not equal to '" + expectedSQL + "'");
        }

        query = ORM.selectDistinct("*").from("User").fullJoin("Post", "id", "user_id");

        sql = query.toString();
        expectedSQL = "SELECT DISTINCT *\nFROM User\nFULL JOIN Post ON id = user_id";
        if(!expectedSQL.equals(sql))
        {
            throw new TestFailedException("The sql query '" + sql + "' is not equal to '" + expectedSQL + "'");
        }

        query = ORM.select("titi", "tata").from("User").fullJoin("Post", "id", "user_id");
        sql = query.toString();
        expectedSQL = "SELECT titi, tata\nFROM User\nFULL JOIN Post ON id = user_id";
        if(!expectedSQL.equals(sql))
        {
            throw new TestFailedException("The sql query '" + sql + "' is not equal to '" + expectedSQL + "'");
        }

        query = ORM.select(Arrays.asList("titi", "tata")).from("User").fullJoin("Post", "id", "user_id");
        sql = query.toString();
        if(!expectedSQL.equals(sql))
        {
            throw new TestFailedException("The sql query '" + sql + "' is not equal to '" + expectedSQL + "'");
        }

        System.out.println("Test 'SQLQueryFullJoin' passed");
    }
}