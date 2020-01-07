package orm.query.clause.view;

import orm.query.SQLQuery;
import orm.query.clause.AbstractClause;

public class CreateViewClause extends AbstractClause
{   
    /**
     * The <code>Create View</code> keyword in SQL
     */
    private static final String CREATE_VIEW_KEYWORD = "CREATE VIEW";

    /**
     * The <code>As</code> keyword in SQL
     */
    private static final String AS_KEYWORD = "AS";

    public CreateViewClause(String viewName, SQLQuery query)
    {
        super();
        StringBuffer buffer = new StringBuffer();
        buffer.append(CREATE_VIEW_KEYWORD).append(" ").append(viewName).append(" " + AS_KEYWORD).append(" ").append(query.prettyToString());
        this.clause = buffer.toString();
    }
}