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
                // try {
                //     SQLQuery query = ORM.select("*").
                //         from("User")
                //         .limit(2)
                //         .offset(1);
                //     SQLResultSet result = query.execute();
                //     SQLCollection<SampleModel> c = result.build(SampleModel.class);
                //     c.dump();
                // } catch(Exception e)
                // {
                //     System.out.println(e.getMessage());
                // }

                try {
                    SQLQuery query = ORM.all("User");
                    SQLResultSet result = query.execute();
                    SQLCollection<SampleModel> c = result.build(SampleModel.class);
                    c.dump();
                } catch(Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}