package newjwglxt.jwglxt.service.idx2;

import newjwglxt.jwglxt.service.BaseService;

import java.sql.Connection;
import java.util.ArrayList;

public interface Service_idx2<T> extends BaseService<T> {
    ArrayList<T> CheckBySid(Connection connection, int sid);

    ArrayList<T> CheckByCid(Connection connection, int cid);
}
