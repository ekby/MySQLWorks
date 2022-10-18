package newjwglxt.jwglxt.dao.idx1;


import newjwglxt.jwglxt.dao.BaseDao;
import newjwglxt.jwglxt.entity.Course;
import newjwglxt.jwglxt.entity.Teacher;

import java.sql.Connection;
import java.util.ArrayList;

public interface Dao_idx1<T> extends BaseDao<T> {
    // 完全匹配的id查找
    ArrayList<T> SelectById(Connection connection, int id);

    // 带有通配符的粗略id查找
    ArrayList<T> SelectByIdRough(Connection connection, int id);

    // 完全匹配的name查找
    ArrayList<T> SelectByName(Connection connection, String name);

    // 带有通配符的粗略name查找
    ArrayList<T> SelectByNameRough(Connection connection, String name);

    // 不按任何条件查找全部
    ArrayList<T> Select(Connection connection);

}
