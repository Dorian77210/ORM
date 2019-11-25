package orm.types;

public class SQLDouble extends SQLAbstractType
{
    /**
     * Constructor of SQLDouble
     * @param data The current data
     */
    public SQLDouble(String data)
    {
        super(data);
    }

    @Override
    public Object getData()
    {
        return Double.parseDouble(this.data);
    }
}