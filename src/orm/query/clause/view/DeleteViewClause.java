package orm.query.clause.view;

import orm.query.clause.AbstractClause;


public class DeleteViewClause extends AbstractClause
{
    /**
     * The <code>Drop View</code> keyword in SQL
     */
    private static final String DROP_VIEW_KEYWORD = "DROP VIEW";

    public DeleteViewClause(String viewName)
    {
        super();
        this.clause += DROP_VIEW_KEYWORD + " " + viewName;
    }
}