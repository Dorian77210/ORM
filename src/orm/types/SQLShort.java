package orm.types;

public class SQLShort extends SQLAbstractType
{
    /**
     * Constructor of SQLShort
     * @param data The current data
     */
    public SQLShort(String data)
    {
        super(data);
    }

    @Override
    public Object getData()
    {
        return Short.parseShort(this.data);
    }
}