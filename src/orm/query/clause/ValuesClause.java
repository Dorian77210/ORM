package orm.query.clause;

import java.util.List;

public class ValuesClause extends AbstractClause
{
    public ValuesClause(boolean addComa, Object... values)
    {
        super();
        int length = values.length, i;
        
        if(addComa)
        {
            this.clause += ",";
        }

        this.clause += "(";
        for(i = 0; i < length; i++)
        {
            String value = new StringBuffer().append("'").append(values[i]).append("'").toString();
            this.clause += value;
            if(i != (length - 1))
            {
                this.clause += ",";
            }
        }

        this.clause += ")";
    }

    public ValuesClause(boolean addComa, List<Object> objects)
    {
        this(addComa, objects.toArray());
    }
}