package orm.types;

public class SQLLong extends SQLAbstractType
{
    /**
     * Constructor of SQLLong
     * @param data The current data
     */
    public SQLLong(String data)
    {
        super(data);
    }

    @Override
    public Object getData()
    {
        return Long.parseLong(this.data);
    }
}