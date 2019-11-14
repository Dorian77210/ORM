import orm.ORM;

public class Application {

    public static void main(String[] args) {
        if(ORM.loadMariaDBDriver())
        {
            System.out.println(ORM.instance.connect("config.json"));
        }
    }
}