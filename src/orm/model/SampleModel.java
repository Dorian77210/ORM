package orm.model;

import orm.annotation.RefersToField;
import orm.annotation.RefersToTable;

@RefersToTable(table = "User")
public class SampleModel extends BaseModel
{
    @RefersToField(tableField = "id", type = "java.lang.Integer")
    private int id;

    @RefersToField(tableField = "name", type = "java.lang.String")
    private String name;
    
    @Override
    public String toString()
    {
        return this.id + " " + this.name;
    }
}