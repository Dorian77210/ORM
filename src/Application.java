import orm.ORM;
import orm.query.operator.SQLOperator;
import orm.query.SQLQuery;
import orm.query.result.SQLResultSet;

import orm.model.SampleModel;

public class Application {

    public static void main(String[] args) {
        if(ORM.loadMariaDBDriver())
        {
            if(ORM.connect("./config.json"))
            {
                System.out.println("Connected to the database");
                try {
                    SQLResultSet result = ORM.select("*").from("User").execute();
                    result.build(SampleModel.class);
                } catch(Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}