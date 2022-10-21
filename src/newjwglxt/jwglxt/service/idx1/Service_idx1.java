package newjwglxt.jwglxt.service.idx1;

import newjwglxt.jwglxt.service.BaseService;
import newjwglxt.jwglxt.util.DbConnector;

import java.util.ArrayList;

public interface Service_idx1<T> extends BaseService<T> {

    ArrayList<T> CheckById(DbConnector dbConnector, int id);

    ArrayList<T> CheckByIdRough(DbConnector dbConnector, int id);

    ArrayList<T> CheckByName(DbConnector dbConnector, String name);

    ArrayList<T> CheckByNameRough(DbConnector dbConnector, String name);

}
