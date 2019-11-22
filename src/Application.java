import orm.ORM;
import orm.query.operator.SQLOperator;
import orm.query.SQLQuery;
import orm.query.result.SQLResultSet;

import orm.model.SampleModel;

import orm.collection.SQLCollection;
public class Application {

    public static void main(String[] args) {
        if(ORM.loadMariaDBDriver())
        {
            if(ORM.connect("./config.json"))
            {
                System.out.println("Connected to the database");
                try {
                    SQLResultSet result = ORM.select("*").from("User").execute();
                    System.out.print(result.getResult());
                    SQLCollection<SampleModel> c = result.build(SampleModel.class);
                    System.out.println(c.first());
                } catch(Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}