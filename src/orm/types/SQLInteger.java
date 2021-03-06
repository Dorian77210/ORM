package orm.types;

public class SQLInteger extends SQLAbstractType
{
    /**
     * Constructor of SQLInteger
     * @param data The current data
     */
    public SQLInteger(String data)
    {
        super(data);
    }

    @Override
    public Object getData()
    {
        return Integer.parseInt(this.data);
    }
}