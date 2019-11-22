package orm.collection;

import java.util.ArrayList;

public class SQLCollection<T> extends ArrayList<T>
{   
    /**
     * Constructor of SQLCollection
     */
    public SQLCollection()
    {
        super();
    }
    
    public T first()
    {
        if(this.size() == 0)
        {
            throw new IndexOutOfBoundsException("The current length of your collection is " + this.size());
        }

        return this.get(0);
    }
}