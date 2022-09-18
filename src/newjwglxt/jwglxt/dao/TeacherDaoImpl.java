package newjwglxt.jwglxt.dao;

import newjwglxt.jwglxt.concrete.Teacher;

import java.sql.Connection;
import java.util.ArrayList;

public class TeacherDaoImpl implements BaseDao<Teacher> {
    // TODO teacherdaoimpl

    @Override
    public void Insert(Connection connection, Teacher teacher) {

    }

    @Override
    public void Delete(Connection connection, Teacher teacher) {

    }

    @Override
    public void Update(Connection connection, Teacher t0, Teacher t1) {

    }

    @Override
    public ArrayList<Teacher> SelectById(Connection connection, int id) {
        return null;
    }

    @Override
    public ArrayList<Teacher> SelectByIdRough(Connection connection, int id) {
        return null;
    }

    @Override
    public ArrayList<Teacher> SelectByName(Connection connection, String name) {
        return null;
    }

    @Override
    public ArrayList<Teacher> SelectByNameRough(Connection connection, String name) {
        return null;
    }
}
