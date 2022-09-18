package newjwglxt.jwglxt.dao;


import java.sql.Connection;
import java.util.ArrayList;

public interface BaseDao<T> {
    // 插入一条记录
    public void Insert(Connection connection, T t);

    // 删除一条记录
    public void Delete(Connection connection, T t);

    // 更新一条记录，但id不能更改
    public void Update(Connection connection, T t0, T t1);

    // 完全匹配的id查找
    public ArrayList<T> SelectById(Connection connection, int id);

    // 带有通配符的粗略id查找
    public ArrayList<T> SelectByIdRough(Connection connection, int id);

    // 完全匹配的name查找
    public ArrayList<T> SelectByName(Connection connection, String name);

    // 带有通配符的粗略name查找
    public ArrayList<T> SelectByNameRough(Connection connection, String name);
}
