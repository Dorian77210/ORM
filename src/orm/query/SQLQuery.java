package orm.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// ------ SQL imports
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// personnal imports
import orm.ORM;

import orm.query.clause.AbstractClause;
import orm.query.condition.AndCondition;
import orm.query.condition.BetweenCondition;
import orm.query.condition.OrCondition;
import orm.query.clause.CrossJoinClause;
import orm.exception.FetchingResultException;
import orm.query.clause.FromClause;
import orm.query.clause.GroupByClause;
import orm.query.clause.InnerJoinClause;
import orm.query.clause.ensemblist.IntersectClause;
import orm.query.clause.LeftJoinClause;
import orm.query.clause.ensemblist.MinusClause;
import orm.query.clause.RightJoinClause;
import orm.query.clause.OrderByClause;
import orm.query.operator.SQLOperator;
import orm.query.operator.SQLOrderOperator;
import orm.query.result.SQLResultSet;
import orm.query.clause.ensemblist.UnionAllClause;
import orm.query.clause.ensemblist.UnionClause;
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
        return this;
    }

    // ------------- Ensemblist SQL ------------- //

    /**
     * Create an union with other query
     * @param query The target query
     * @return The current SQLQuery
     */
    public SQLQuery union(SQLQuery query)
    {
        AbstractClause union = new UnionClause(query);
        this.clauses.add(union);
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
        return this;
    }

    /**
     * Create a difference with orhter query
     * @param query The target query
     * @return The current SQLQuery
     */
    public SQLQuery minus(SQLQuery query)
    {
        AbstractClause minus = new MinusClause(query);
        this.clauses.add(minus);
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
        this.clauses.add(where);
        return this;
    }

    /**
     * Create an and condition for the query
     * @param field The field for the condition
     * @param operator The operator for the condition
     * @param value The value for the condition
     * @return The current SQLQuery
     */
    public SQLQuery andWhere(String field, SQLOperator operator, Object value)
    {
        AbstractClause andWhere = new AndCondition(field, operator, value);
        this.clauses.add(andWhere);
        return this;
    }

    /**
     * Create an Or condition for the query
     * @param field The field for the condition
     * @param operator The operator for the condition
     * @param value The value for the condition
     * @return The current SQLQuery
     */
    public SQLQuery orWhere(String field, SQLOperator operator, Object value)
    {
        AbstractClause orWhere = new OrCondition(field, operator, value);
        this.clauses.add(orWhere);
        return this;
    }

    /**
     * Create a between clause for the query
     * @param field The field for the condition
     * @param firstValue The first value of the between condition
     * @param secondValue The second value of the between condition
     * @return The current SQLQuery
     */
    public SQLQuery whereBetween(String field, Object firstValue, Object secondValue)
    {
        AbstractClause whereBetween = new BetweenCondition(field, firstValue, secondValue);
        this.clauses.add(whereBetween);
        return this;
    }

    /**
     * Create an or between clause for the query
     * @param field The field for the condition
     * @param firstValue The first value of the between condition
     * @param secondValue The second value of the between condition
     * @return The current SQLQuery
     */
    public SQLQuery andWhereBetween(String field, Object firstValue, Object secondValue)
    {
        AbstractClause andWhereBetween = new AndCondition(new BetweenCondition(field, firstValue, secondValue));
        this.clauses.add(andWhereBetween);
        return this;
    }

    /**
     * Create an or between clause for the query
     * @param field The field for the condition
     * @param firstValue The first value of the between condition
     * @param secondValue The second value of the between condition
     * @return The current SQLQuery
     */
    public SQLQuery orWhereBetween(String field, Object firstValue, Object secondValue)
    {
        AbstractClause orWhereBetween = new OrCondition(new BetweenCondition(field, firstValue, secondValue));
        this.clauses.add(orWhereBetween);
        return this;
    }

    // ----------- Group by methods ---------- //
    
    /**
     * Create a group by clause for the query
     * @param column The target column
     * @return The current SQLQuery
     */
    public SQLQuery groupBy(String column)
    {
        AbstractClause groupBy = new GroupByClause(column);
        this.clauses.add(groupBy);
        return this;
    }

    // ----------- Order by methods ---------- //    

    /**
     * Create an order by clause for the query
     * @param columns The columns for the order by clause
     * @return The current SQLQuery
     */
    public SQLQuery orderBy(String ...columns)
    {
        AbstractClause orderBy = new OrderByClause(columns);
        this.clauses.add(orderBy);
        return this;
    }

    /**
     * Create an order by clause for the query
     * @param columns The columns for the order by clause
     * @param operator The operator for the order by
     * @return The current SQLQuery
     */
    public SQLQuery orderBy(SQLOrderOperator operator, String ...columns)
    {
        AbstractClause orderBy = new OrderByClause(operator, columns);
        this.clauses.add(orderBy);
        return this;
    }

    /**
     * Create an order by clause for the query
     * @param map A map with association between columns and operators
     * @return The current SQLQuery
     */
    public SQLQuery orderBy(Map<String, SQLOrderOperator> map)
    {
        AbstractClause orderBy = new OrderByClause(map);
        this.clauses.add(orderBy);
        return this;
    }

    // ----------- Execute method ----------- //

    /**
     * Execute the current query
     */
    public SQLResultSet execute() throws FetchingResultException
    {
        Connection connection = ORM.getConnection();
        ResultSet result;
        PreparedStatement statement;
        String query = this.toString();
        SQLResultSet set = new SQLResultSet();

        try {
            statement = connection.prepareStatement(query);
            result = statement.executeQuery();
            while(result.next())
            {
                set.push(result);
            }
        } catch(SQLException exception) 
        {
            System.err.println(exception.getMessage());
            throw new FetchingResultException("Error during fetching on the result of your query");
        }

        return set;
    }

    // ----------- toString methods ---------- //

    /**
     * @return The current SQL query
     */
    @Override
    public String toString()
    {
        return this.prettyToString();
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