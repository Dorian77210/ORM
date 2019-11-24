package orm.types;

public class SQLBoolean extends SQLAbstractType
{  
    /**
     * Constructor of SQLBoolean
     * @param data The data
     */
    public SQLBoolean(String data)
    {
        super(data);
    }

    @Override
    public Object getData()
    {
        return Boolean.parseBoolean(this.data);
    }
}