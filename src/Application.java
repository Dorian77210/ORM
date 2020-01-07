import orm.ORM;
import orm.collection.SQLCollection;
import orm.model.SampleModel;
import orm.model.table.SQLTable;
import orm.query.operator.SQLOperator;
import orm.query.result.SQLResultSet;

public class Application
{
    public static void main(String[] args)
    {
        if (ORM.loadMariaDBDriver())
        {
            if(ORM.connect("./config.json"))
            {
                try
                {
                    SQLCollection<SampleModel> collection = ORM.select("*").from("User").where("id", SQLOperator.EQUAL, 1).executeQuery().build(SampleModel.class);
                    SampleModel model = collection.first();
                    model.posts.dump();
                } catch(Exception exception)
                {
                    System.err.println(exception);
                }
            }
        }
    }
}