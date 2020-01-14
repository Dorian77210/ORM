package orm.test.model.view;

import orm.ORM;
import orm.query.SQLQuery;
import orm.query.result.SQLResultSet;

import orm.test.BaseTest;
import orm.test.exception.TestFailedException;

public class SelectOnViewTest extends BaseTest
{
    public SelectOnViewTest()
    {
        super();
    }

    @Override
    public void run() throws TestFailedException
    {
        SQLQuery query = ORM.select("*").fromAs("ViewTest", "User");
        try
        {
            SQLResultSet set = query.executeQuery();
            if(set == null)
            {
                throw new TestFailedException("Error during the selection in the view 'ViewTest'");
            }
        } catch(Exception e)
        {
            System.out.println(e.getMessage());
            throw new TestFailedException("Error during the selection in the view 'ViewTest'");
        }

        System.out.println("Test 'SelectOnViewTest' passed");
    }
}