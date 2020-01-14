package orm.test.query.clause.ensemblist;

import orm.test.BaseTest;
import orm.test.exception.TestFailedException;

import orm.ORM;
import orm.query.SQLQuery;

public class SQLQueryMinus extends BaseTest
{
    public SQLQueryMinus()
    {
        super();
    }

    @Override
    public void run() throws TestFailedException
    {
        SQLQuery query = ORM.select("*").from("User").minus(ORM.select("*").from("User"));

        String sql = query.toString();
        String expectedSQL = "SELECT *\nFROM User\nMINUS (SELECT *\nFROM User)";
        if(!expectedSQL.equals(sql))
        {
            throw new TestFailedException("The sql query '" + sql + "' is not equal to '" + expectedSQL + "'");
        }

        query = ORM.select("titi", "toto").from("User").minus(ORM.select("titi", "toto").from("User"));
        sql = query.toString();
        expectedSQL = "SELECT titi, toto\nFROM User\nMINUS (SELECT titi, toto\nFROM User)";
        if(!expectedSQL.equals(sql))
        {
            throw new TestFailedException("The sql query '" + sql + "' is not equal to '" + expectedSQL + "'");
        }

        System.out.println("Test 'SQLQueryMinus' passed");
    }
}