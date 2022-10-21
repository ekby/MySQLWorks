package newjwglxt.jwglxt.service;

import newjwglxt.jwglxt.util.DbConnector;

public interface BaseService<T> {
    void Add(DbConnector dbConnector, T t);

    void Delete(DbConnector dbConnector, T t);

    void Update(DbConnector dbConnector, T t);

}
