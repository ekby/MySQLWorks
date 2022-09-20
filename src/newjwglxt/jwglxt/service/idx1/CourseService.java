package newjwglxt.jwglxt.service.idx1;

import newjwglxt.jwglxt.dao.idx1.CourseDaoImpl;
import newjwglxt.jwglxt.entity.Course;

import java.sql.Connection;
import java.util.ArrayList;

public class CourseService implements Service_idx1<Course> {
    @Override
    public void Add(Connection connection, Course course) {
        CourseDaoImpl courseDao = new CourseDaoImpl();
        courseDao.Insert(connection, course);
    }

    @Override
    public void Delete(Connection connection, Course course) {
        CourseDaoImpl courseDao = new CourseDaoImpl();
        courseDao.Delete(connection, course);
    }

    @Override
    public void Update(Connection connection, Course course) {
        CourseDaoImpl courseDao = new CourseDaoImpl();
        courseDao.Update(connection, course);
    }

    @Override
    public ArrayList<Course> CheckById(Connection connection, int id) {
        CourseDaoImpl courseDao = new CourseDaoImpl();
        return courseDao.SelectById(connection, id);
    }

    @Override
    public ArrayList<Course> CheckByIdRough(Connection connection, int id) {
        CourseDaoImpl courseDao = new CourseDaoImpl();
        return courseDao.SelectByIdRough(connection, id);
    }

    @Override
    public ArrayList<Course> CheckByName(Connection connection, String name) {
        CourseDaoImpl courseDao = new CourseDaoImpl();
        return courseDao.SelectByName(connection, name);
    }

    @Override
    public ArrayList<Course> CheckByNameRough(Connection connection, String name) {
        CourseDaoImpl courseDao = new CourseDaoImpl();
        return courseDao.SelectByNameRough(connection, name);
    }
}
