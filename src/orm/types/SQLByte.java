package orm.types;

public class SQLByte extends SQLAbstractType
{
    /**
     * Constructor of SQLByte
     * @param data The data
     */
    public SQLByte(String data)
    {
        super(data);
    }

    @Override
    public Object getData()
    {
        return Byte.parseByte(this.data);
    }
}