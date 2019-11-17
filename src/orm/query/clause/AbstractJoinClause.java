package orm.query.clause;

class AbstractJoinClause extends AbstractClause
{

    /**
     * The <code>On</code> keyword in SQL
     */
    private static final String ON_KEYWORD = "ON";

    /**
     * Constructor of the AbstractJoinClause
     * @param table The target table for the jointure
     * @param firstField The first field of the jointure
     * @param secondField The second field of the jointure
     * @param joinType The type of the jointure
     */
    AbstractJoinClause(String table, String firstField, String secondField, String joinType)
    {   
        super();
        StringBuffer buffer = new StringBuffer();
        buffer.append(joinType)
              .append(" ")
              .append(table)
              .append(" ")
              .append(ON_KEYWORD)
              .append(" ")
              .append(firstField)
              .append(" = ")
              .append(secondField);
        
        this.clause += buffer.toString();
    }
}