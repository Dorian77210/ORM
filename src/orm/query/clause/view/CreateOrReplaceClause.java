package orm.query.clause.view;

import orm.query.clause.AbstractClause;
import orm.query.SQLQuery;

public class CreateOrReplaceClause extends AbstractClause
{

    /**
     * The <code>Create View Or Replace</code> keyword in SQL
     */
    private static final String CREATE_OR_REPLACE_VIEW_KEYWORD = "CREATE OR REPLACE VIEW";

    /**
     * The <code>As</code> keyword in SQL
     */
    private static final String AS_KEYWORD = "AS";
    public CreateOrReplaceClause(String viewName, SQLQuery query)
    {
        super();
        StringBuffer buffer = new StringBuffer();
        buffer.append(CREATE_OR_REPLACE_VIEW_KEYWORD).append(" ").append(viewName).append(" " + AS_KEYWORD).append(" ").append(query.prettyToString());
        this.clause = buffer.toString();
    }
}