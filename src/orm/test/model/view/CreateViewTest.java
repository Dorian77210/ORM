package orm.test.model.view;

import orm.test.BaseTest;
import orm.ORM;
import orm.query.operator.SQLOperator;
import orm.test.exception.TestFailedException;

public class CreateViewTest extends BaseTest
{

    public CreateViewTest()
    {
        super();
    }

    @Override
    public void run() throws TestFailedException
    {
        // create the view
        if(!ORM.createView("ViewTest", ORM.select("*").from("User").where("id", SQLOperator.EQUAL, 1)))
        {
            throw new TestFailedException("Error during the creation of the view 'ViewTest'");
        }

        System.out.println("Test 'CreateViewTest' passed");
    }
}