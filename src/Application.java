import orm.ORM;
import orm.query.operator.SQLOperator;
import orm.query.SQLQuery;

public class Application {

    public static void main(String[] args) {
        if(ORM.loadMariaDBDriver())
        {
            if(ORM.connect("./config.json"))
            {
                System.out.println("Connected to the database");
                try {
                    ORM.select("*").from("User").execute();
                } catch(Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}