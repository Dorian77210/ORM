package orm.types;

public class SQLFloat extends SQLAbstractType
{
    /**
     * Constructor of SQLFloat
     * @param data The current data
     */
    public SQLFloat(String data)
    {
        super(data);
    }

    @Override
    public Object getData()
    {
        return Float.parseFloat(this.data);
    }
}