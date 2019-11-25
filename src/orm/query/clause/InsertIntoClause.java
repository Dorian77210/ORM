package orm.query.clause;

import java.util.List;

public class InsertIntoClause extends AbstractClause
{
    /**
     * The <code>Insert into</code> keyword in SQL
     */
    private static final String INSERT_INTO_KEYWORD = "INSERT INTO";

    /**
     * The <code>Values</code> keyword in SQL
     */
    private static final String VALUES_KEYWORD = "VALUES";

    /**
     * Constructor of InsertIntoClause
     * @param table The target table
     * @param columns The columns in the table
     */
    public InsertIntoClause(String table, String... columns)
    {
        super();
        this.clause += INSERT_INTO_KEYWORD + " " + table;
        if(columns.length > 0)
        {
            int length = columns.length, i;
            this.clause += "(";

            for(i = 0; i < length; i++)
            {
                String column = columns[i];
                this.clause += column;
                if(i != (length - 1))
                {
                    this.clause += ",";
                }
            }

            this.clause += ") " + VALUES_KEYWORD;
        }
    }

    public InsertIntoClause(String table, List<String> columns)
    {
        this(table, columns.toArray(new String[columns.size()]));
    }
}