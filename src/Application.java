import orm.ORM;
import orm.query.operator.SQLOperator;
import orm.query.SQLQuery;
import orm.query.result.SQLResultSet;

import orm.model.SampleModel;
import orm.model.table.SQLTable;

import orm.collection.SQLCollection;
public class Application {

    public static void main(String[] args) {
        if(ORM.loadMariaDBDriver())
        {
            if(ORM.connect("./config.json"))
            {
                SQLTable table = new SQLTable("Persons");
                table.integer("id");
                table.string("LastName", 255);
                table.string("FirstName", 255).nullable();
                table.integer("Age").nullable();
                table.string("City", 255).defaultValue("Sandrine");
                System.out.println(table.toString());
            }
        }
    }
}