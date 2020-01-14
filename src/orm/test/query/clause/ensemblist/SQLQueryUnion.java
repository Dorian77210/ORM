package orm.test.query.clause.ensemblist;

import orm.test.BaseTest;
import orm.test.exception.TestFailedException;

import orm.ORM;
import orm.query.SQLQuery;

public class SQLQueryUnion extends BaseTest
{
    public SQLQueryUnion()
    {
        super();
    }

    @Override
    public void run() throws TestFailedException
    {
        SQLQuery query = ORM.select("*").from("User").union(ORM.select("*").from("User"));

        String sql = query.toString();
        String expectedSQL = "SELECT *\nFROM User\nUNION (SELECT *\nFROM User)";
        if(!expectedSQL.equals(sql))
        {
            throw new TestFailedException("The sql query '" + sql + "' is not equal to '" + expectedSQL + "'");
        }

        query = ORM.select("titi", "toto").from("User").union(ORM.select("titi", "toto").from("User"));
        sql = query.toString();
        expectedSQL = "SELECT titi, toto\nFROM User\nUNION (SELECT titi, toto\nFROM User)";
        if(!expectedSQL.equals(sql))
        {
            throw new TestFailedException("The sql query '" + sql + "' is not equal to '" + expectedSQL + "'");
        }

        System.out.println("Test 'SQLQueryUnion' passed");
    }
}