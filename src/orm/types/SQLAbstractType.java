package orm.types;

public abstract class SQLAbstractType
{

    /**
     * The current data
     */
    protected String data;

    public SQLAbstractType(String data)
    {
        this.data = data;
    }
    
    public Object getData()
    {
        return null;
    }
}