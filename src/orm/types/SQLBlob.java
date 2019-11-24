package orm.types;

import javax.sql.rowset.serial.SerialBlob;

public class SQLBlob extends SQLAbstractType
{
    /**
     * Constructor of SQLBlob
     * @param data The current data
     */
    public SQLBlob(String data)
    {
        super(data);
    }

    @Override
    public Object getData()
    {
        try {
            return new SerialBlob(this.data.getBytes());
        } catch(Exception sqlException)
        {
            System.err.println(sqlException.getMessage());
        }

        return null;
    }
}