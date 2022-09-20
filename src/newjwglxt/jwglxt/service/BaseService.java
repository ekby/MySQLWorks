package newjwglxt.jwglxt.service;

import java.sql.Connection;

public interface BaseService<T> {
    void Add(Connection connection, T t);

    void Delete(Connection connection, T t);

    void Update(Connection connection, T t);

}
