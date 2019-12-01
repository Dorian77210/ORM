package orm.model.table;

// local imports
import orm.model.table.constraint.BaseConstraint;
import orm.model.table.constraint.ForeignKeyConstraint;

import java.util.List;
import java.util.ArrayList;

public class SQLTable
{

    /**
     * The name of the table
     */
    private String tableName;   

    /**
     * The list of the columns of the table
     */
    private List<SQLTableColumn> columns;

    /**
     * The list of the constraints for the table
     */
    private List<BaseConstraint> constraints;

    public SQLTable(String name)
    {
        this.tableName = name;
        this.columns = new ArrayList<SQLTableColumn>();
        this.constraints = new ArrayList<BaseConstraint>();
    }

    // -------- Constraints methods ------- //
    
    /**
     * Add a foreign key in the table
     * @param constraintName The name of the constraint
     * @param foreignKeyColumn The target column for the foreign key
     * @param tableReference The name of the target table
     * @param columnReference The name of the target column
     * @return The associated ForeignKeyConstraint
     */
    public ForeignKeyConstraint foreignKey(String constraintName, String foreignKeyColumn, String tableReference, String columnReference)
    {
        ForeignKeyConstraint foreignKeyConstraint = new ForeignKeyConstraint(constraintName, foreignKeyColumn, tableReference, columnReference);
        this.constraints.add(foreignKeyConstraint);
        return foreignKeyConstraint;
    }
}