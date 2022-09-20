package newjwglxt.jwglxt.service;

import java.sql.Connection;

public interface BaseService<T> {
    boolean LoginVerify(Connection connection, T t);

    void ChangePassword(Connection connection, T t);

    void Add(Connection connection, T t);

    void Delete(Connection connection, T t);

    void Update(Connection connection, T t);

    T Check(Connection connection, T t);


}
