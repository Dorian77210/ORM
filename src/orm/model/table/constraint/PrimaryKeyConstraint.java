package orm.model.table.constraint;

import java.util.ArrayList;
import java.util.List;

public class PrimaryKeyConstraint extends BaseConstraint {

    /**
     * The <code>Primary Key</code> keyword in SQL
     */
    private static final String PRIMARY_KEY_KEYWORD = "PRIMARY KEY";

    /**
     * List of the fields that composed the primary key constraint
     */
    private List<String> primaryFields;

    /**
     * Constructor of PrimaryKeyConstraint
     * @param fields The list of the primary fields
     */
    public PrimaryKeyConstraint(String... fields) {
        super();
        this.primaryFields = new ArrayList<String>();
        for (String field : fields) {
            this.primaryFields.add(field);
        }
    }

    @Override
    public String getConstraintRepresentation() {
        final StringBuffer buffer = new StringBuffer();
        buffer.append(PRIMARY_KEY_KEYWORD)
              .append(" ");

        int i, size = this.primaryFields.size();
        for(i = 0; i < size; ++i)
        {
            String field = this.primaryFields.get(i);
            buffer.append("'" + field + "'");
            if(i != (size - 1))
            {
                buffer.append(",");
            }
        }

        return buffer.toString();
    }
}