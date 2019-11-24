package orm.query.clause;

public class OffsetClause extends AbstractClause
{
    /**
     * The <code>Offset</code> keyword in SQL
     */
    private static final String OFFSET_KEYWORD = "OFFSET";

    /**
     * Constructor of OffsetClause
     * @param offset The wanted offset
     */
    public OffsetClause(int offset)
    {
        super();
        this.clause += OFFSET_KEYWORD + " " + offset;
    }
}