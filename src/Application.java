import orm.ORM;

public class Application
{
    public static void main(String[] args)
    {
        if (ORM.loadMariaDBDriver())
        {
            if(ORM.connect("./config.json"))
            {
                System.out.println("Connected");
            }
        }
    }
}