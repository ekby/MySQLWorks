package newjwglxt.jwglxt.service.idx1;

import newjwglxt.jwglxt.util.DbConnector;

public interface LoginService<T> {
    T LoginVerify(DbConnector dbConnector, int id, String pw);

}
