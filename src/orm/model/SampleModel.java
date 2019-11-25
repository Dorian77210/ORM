package orm.model;

import orm.annotation.RefersToField;
import orm.annotation.RefersToTable;
import orm.annotation.PrimaryKey;

@RefersToTable(table = "User")
public class SampleModel extends BaseModel
{
    @RefersToField(tableField = "id", type = "orm.types.SQLInteger")
    @PrimaryKey
    private long id;

    @RefersToField(tableField = "name", type = "orm.types.SQLString")
    public String name;
    
    public SampleModel()
    {
        super();
        this.name = "Test";
    }

    @Override
    public String toString()
    {
        return this.id + " " + this.name;
    }
}