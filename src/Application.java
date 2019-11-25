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
                SampleModel model = new SampleModel();
                model.save();
            }
        }
    }
}