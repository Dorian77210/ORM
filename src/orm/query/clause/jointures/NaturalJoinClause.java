package orm.query.clause.jointures;

import orm.query.clause.AbstractClause;

public class NaturalJoinClause extends AbstractClause
{
    /**
     * The <code>Natural Join</code> keyword in SQL
     */
    private static final String NATURAL_JOIN_KEYWORD = "NATURAL JOIN";

    /**
     * Constructor of NaturalJoinClause
     * @param table The table for the jointure
     */
    public NaturalJoinClause(String table)
    {
        super();
        this.clause += NATURAL_JOIN_KEYWORD + " " + table;
    }
}