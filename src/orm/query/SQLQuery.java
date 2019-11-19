package orm.query;

import java.util.ArrayList;
import java.util.List;

// personnal imports
import orm.query.clause.AbstractClause;
import orm.query.clause.CrossJoinClause;
import orm.query.clause.FromClause;
import orm.query.clause.InnerJoinClause;
import orm.query.clause.IntersectClause;
import orm.query.clause.LeftJoinClause;
import orm.query.clause.RightJoinClause;
import orm.query.clause.UnionAllClause;
import orm.query.clause.UnionClause;
import orm.query.clause.WhereClause;

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

    // --------- Jointure methods ----------- //
   
    /**
     * Create an inner jointure
     * @param table The target table of the jointure
     * @param firstField The first field of the jointure
     * @param secondField The second field of the jointure
     * @return The current SQLQuery
     */
    public SQLQuery innerJoin(String table, String firstField, String secondField)
    {
        AbstractClause innerJoin = new InnerJoinClause(table, firstField, secondField);
        this.clauses.add(innerJoin);
        this.query += " " + innerJoin.getClause();
        return this;
    }

    /**
     * Create a right jointure
     * @param table The target table of the jointure
     * @param firstField The first field of the jointure
     * @param secondField The second field of the jointure
     * @return The current SQLQuery
     */
    public SQLQuery rightJoin(String table, String firstField, String secondField)
    {
        AbstractClause rightJoin = new RightJoinClause(table, firstField, secondField);
        this.clauses.add(rightJoin);
        this.query += " " + rightJoin.getClause();
        return this;
    }

    /**
     * Create a left jointure
     * @param table The target table of the jointure
     * @param firstField The first field of the jointure
     * @param secondField The second field of the jointure
     * @return The current SQLQuery
     */
    public SQLQuery leftJoin(String table, String firstField, String secondField)
    {
        AbstractClause leftJoin = new LeftJoinClause(table, firstField, secondField);
        this.clauses.add(leftJoin);
        this.query += " " + leftJoin.getClause();
        return this;
    }

    /**
     * Create a cross jointure
     * @param table The target table of the jointure
     * @return The current SQLQuery
     */
    public SQLQuery crossJoin(String table)
    {
        AbstractClause crossJoin = new CrossJoinClause(table);
        this.clauses.add(crossJoin);
        this.query += " " + crossJoin.getClause();
        return this;
    }

    /**
     * Create an union with other query
     * @param query The target query
     * @return The current SQLQuery
     */
    public SQLQuery union(SQLQuery query)
    {
        AbstractClause union = new UnionClause(query);
        this.clauses.add(union);
        this.query += " " + union.getClause();
        return this;
    }

    /**
     * Create an union all with other query
     * @param query The target query
     * @return The current SQLQuery
     */
    public SQLQuery unionAll(SQLQuery query)
    {
        AbstractClause unionAll = new UnionAllClause(query);
        this.clauses.add(unionAll);
        this.query += " " + unionAll.getClause();
        return this;
    }

    /**
     * Create an intersection with other query
     * @param query The target query
     * @return The current SQLQuery
     */
    public SQLQuery intersect(SQLQuery query)
    {
        AbstractClause intersect = new IntersectClause(query);
        this.clauses.add(intersect);
        this.query += " " + intersect.getClause();
        return this;
    }

    // ----------- Where methods ---------- //
    
    /**
     * Create a where clause
     * @param field The field for the condition
     * @param operator The operator for the condition
     * @param value The value for the condition
     * @return The current SQLQuery
     */
    public SQLQuery where(String field, SQLOperator operator, Object value)
    {
        AbstractClause where = new WhereClause(field, operator, value);
        this.cc
        lauses.add(where);
        this.query += " " + where.getClause();
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