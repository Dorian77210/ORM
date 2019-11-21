package orm.builder;

import orm.collection.SQLCollection;
import orm.query.result.SQLResultSet;

public interface IClassBuilder
{
    <T> SQLCollection<T> build(Class<T> clazz, SQLResultSet set);
}