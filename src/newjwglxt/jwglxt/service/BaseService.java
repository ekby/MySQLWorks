package newjwglxt.jwglxt.service;

import newjwglxt.jwglxt.entity.Teacher;

import java.sql.Connection;
import java.util.ArrayList;

public interface BaseService<T> {
    T LoginVerify(Connection connection, int id, String pw);

    void Add(Connection connection, T t);

    void Delete(Connection connection, T t);

    void Update(Connection connection, T t);

    ArrayList<T> CheckById(Connection connection, int id);

    ArrayList<T> CheckByIdRough(Connection connection, int id);

    ArrayList<T> CheckByName(Connection connection, String name);

    ArrayList<T> CheckByNameRough(Connection connection, String name);

}
