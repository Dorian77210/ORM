package orm.test.model.view;

import orm.test.BaseTest;
import orm.ORM;
import orm.test.exception.TestFailedException;

public class DeleteViewTest extends BaseTest
{

    public DeleteViewTest()
    {
        super();
    }

    @Override
    public void run() throws TestFailedException
    {
        // create the view
        if(!ORM.deleteView("ViewTest"))
        {
            throw new TestFailedException("Error during the deletion of the view 'ViewTest'");
        }

        System.out.println("Test 'DeleteViewPassed' passed");
    }
}