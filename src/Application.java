import orm.ORM;
import orm.query.SQLQuery;

import orm.query.SQLOperator;

public class Application {

    public static void main(String[] args) {
        if(ORM.loadMariaDBDriver())
        {
            System.out.println(ORM.instance().connect("config.json"));
            System.out.println(ORM.select("toto", "titi")
                .from("A")
                .crossJoin("B")
                .where("toto", SQLOperator.EQUAL, 10)
            );

            SQLQuery query = ORM.select("toto").from("A");
            System.out.println(ORM.select("titi").from("B").intersect(query));
        }
    }
}