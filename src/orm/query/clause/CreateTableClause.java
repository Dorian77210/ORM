package orm.query.clause;

import orm.model.table.SQLTable;

public class CreateTableClause extends AbstractClause
{

    /**
     * Constructor of CreateTableClause
     * @param table The table to create
     */
    public CreateTableClause(SQLTable table)
    {
        super();
        this.clause += table.toString();
    }
}