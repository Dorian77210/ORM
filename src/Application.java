import orm.ORM;
import orm.collection.SQLCollection;
import orm.model.SampleModel;
import orm.model.table.SQLTable;
import orm.query.result.SQLResultSet;

public class Application
{
    public static void main(String[] args)
    {
        if (ORM.loadMariaDBDriver())
        {
            if(ORM.connect("./config.json"))
            {
                SQLTable table = new SQLTable("Post");
                table.bigInteger("id").primaryKey().autoIncrement();
                table.bigInteger("user_id");
                table.text("resume");

                table.foreignKey("post_fk", "user_id", "User", "id");

                System.out.println(table);

                table.create();
            }
        }
    }
}