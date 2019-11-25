package orm.types;

public class SQLString extends SQLAbstractType
{
    /**
     * Constructor of SQLString
     * @param data The current data
     */
    public SQLString(String data)
    {
        super(data);
    }

    @Override
    public Object getData()
    {
        return this.data;
    }
}