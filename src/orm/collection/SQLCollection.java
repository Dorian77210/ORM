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

    /**
     * Get the first element in the collection
     * @return The first element
     * @throws IndexOutOfBoundsException if the size is equal to 0
     */
    public T first()
    {
        if(this.size() == 0)
        {
            throw new IndexOutOfBoundsException("The current length of your collection is " + this.size());
        }

        return this.get(0);
    }

    /**
     * Print the collection 
     */
    public void dump()
    {
        this.forEach((T element) -> {
            System.out.println(element);
        });
    }
}