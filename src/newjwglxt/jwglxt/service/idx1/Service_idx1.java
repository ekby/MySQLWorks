package newjwglxt.jwglxt.service.idx1;

import newjwglxt.jwglxt.service.BaseService;

import java.sql.Connection;
import java.util.ArrayList;

public interface Service_idx1<T> extends BaseService<T> {

    ArrayList<T> CheckById(Connection connection, int id);

    ArrayList<T> CheckByIdRough(Connection connection, int id);

    ArrayList<T> CheckByName(Connection connection, String name);

    ArrayList<T> CheckByNameRough(Connection connection, String name);

}
