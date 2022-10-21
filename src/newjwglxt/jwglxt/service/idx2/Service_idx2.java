package newjwglxt.jwglxt.service.idx2;

import newjwglxt.jwglxt.service.BaseService;
import newjwglxt.jwglxt.util.DbConnector;

import java.util.ArrayList;

public interface Service_idx2<T> extends BaseService<T> {
    ArrayList<T> CheckBySid(DbConnector dbConnector, int sid);

    ArrayList<T> CheckByCid(DbConnector dbConnector, int cid);
}
