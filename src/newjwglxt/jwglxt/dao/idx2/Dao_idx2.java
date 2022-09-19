package newjwglxt.jwglxt.dao.idx2;

import newjwglxt.jwglxt.dao.BaseDao;

import java.sql.Connection;
import java.util.ArrayList;

public interface Dao_idx2<T> extends BaseDao<T> {
    // 通过学生sid查找
    ArrayList<T> SelectBySid(Connection connection, int sid);

    // 通过课程cid查找
    ArrayList<T> SelectByCid(Connection connection, int cid);
}
