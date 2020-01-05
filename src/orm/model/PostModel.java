package orm.model;

import orm.annotation.RefersToField;
import orm.annotation.RefersToTable;
import orm.annotation.PrimaryKey;

@RefersToTable(table = "Post")
public class PostModel extends BaseModel
{
    @RefersToField(tableField = "id", type = "orm.types.SQLInteger")
    @PrimaryKey
    private long id;

    @RefersToField(tableField = "resume", type = "orm.types.SQLString")
    public String resume;

    @RefersToField(tableField = "user_id", type = "orm.types.SQLLong")
    private long userId;
    
    public PostModel()
    {
        super();
    }

    @Override
    public String toString()
    {
        return this.id + " " + this.resume + " " + this.userId;
    }
}