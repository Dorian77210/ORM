package orm.model;

import orm.annotation.RefersToField;
import orm.annotation.RefersToTable;

@RefersToTable(table = "User")
public class SampleModel extends BaseModel
{
    @RefersToField(tableField = "id", type = Integer.class)
    private int id;

    @RefersToField(tableField = "name", type = String.class)
    private String name;


    public SampleModel()
    {
        super();
    }
}