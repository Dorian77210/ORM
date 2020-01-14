package orm.model;

import orm.annotation.RefersToField;
import orm.annotation.RefersToTable;
import orm.annotation.PrimaryKey;
import orm.annotation.AllowCascadingLoading;
import orm.collection.SQLCollection;
import orm.annotation.HasMany;

@RefersToTable(table = "User")
@AllowCascadingLoading
public class SampleModel extends BaseModel
{
    @RefersToField(tableField = "id", type = "orm.types.SQLInteger")
    @PrimaryKey
    private long id;

    @RefersToField(tableField = "lastname", type = "orm.types.SQLString")
    public String name;

    @HasMany(targetClass = "orm.model.PostModel", targetColumn = "user_id", sourceForeignKeyField = "id")
    public SQLCollection<PostModel> posts;
    
    public SampleModel()
    {
        super();
        this.name = "Test";
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return this.id + " " + this.name;
    }
}