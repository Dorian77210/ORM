package orm.query;

import java.util.List;
import java.util.ArrayList;

// personnal imports
import orm.query.clause.AbstractClause;
import orm.query.clause.FromClause;

public class SQLQuery
{
    /**
     * List of all of the clauses that composed the SQL query
     */
    private List<AbstractClause> clauses;

    /**
     * The current query in string
     */
    private String query;

    // -------- Constructors ------- //

    /**
     * Constructor of the SQLQuery
     */
    public SQLQuery()
    {
        this.clauses = new ArrayList<AbstractClause>();
        this.query = "";
    }

    /**
     * Constructor of the SQLQuery
     * @param clauses The clauses that composed the current query
     */
    public SQLQuery(AbstractClause ...clauses)
    {
        this();
        int i;
        for(i = 0; i < clauses.length; i++)
        {
            AbstractClause clause = clauses[i];
            this.clauses.add(clause);
            this.query += clause.getClause();
        }
    }

    // ---------- From method -------- //
    
    /**
     * Select a table for the current query
     * @param table The wanted table
     * @return The current SQLQuery
     */
    public SQLQuery from(String table)
    {
        AbstractClause from = new FromClause(table);
        this.clauses.add(from);
        this.query += " " + from.getClause();
        return this;
    }

    // ----------- toString methods ---------- //

    /**
     * @return The current SQL query
     */
    @Override
    public String toString()
    {
        return this.query;
    }

    /**
     * Method that return the current pretty value of the query 
     * @return
     */
    public String prettyToString()
    {
        String result = "";
        int i, length = this.clauses.size();

        for(i = 0; i < length; i++)
        {
            AbstractClause clause = this.clauses.get(i);
            result += clause.getClause();
            if(i != (length - 1))
            {
                result += "\n";
            }
        }

        return result;
    }
}