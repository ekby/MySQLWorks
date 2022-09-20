package newjwglxt.jwglxt.service.idx1;

import java.sql.Connection;

public interface LoginService<T> {
    T LoginVerify(Connection connection, int id, String pw);

}
