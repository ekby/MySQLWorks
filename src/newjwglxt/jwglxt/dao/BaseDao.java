package newjwglxt.jwglxt.dao;

import java.sql.Connection;

public interface BaseDao<T> {
    // 插入一条记录
    void Insert(Connection connection, T t);

    // 删除一条记录
    void Delete(Connection connection, T t);

    // 更新一条记录，但id不能更改
    void Update(Connection connection, T t);
}
