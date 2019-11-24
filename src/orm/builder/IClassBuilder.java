package orm.builder;

import orm.collection.SQLCollection;
import orm.query.result.SQLResultSet;
import orm.model.BaseModel;

public interface IClassBuilder
{
    <T extends BaseModel> SQLCollection<T> build(Class<T> clazz, SQLResultSet set);
}