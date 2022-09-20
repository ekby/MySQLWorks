package newjwglxt.jwglxt.service.idx2;

import newjwglxt.jwglxt.dao.idx2.DropCourseDaoImpl;
import newjwglxt.jwglxt.entity.DropCourse;

import java.sql.Connection;
import java.util.ArrayList;

public class DropCourseService implements Service_idx2<DropCourse> {
    @Override
    public void Add(Connection connection, DropCourse DropCourse) {
        DropCourseDaoImpl DropCourseDao = new DropCourseDaoImpl();
        DropCourseDao.Insert(connection, DropCourse);
    }

    @Override
    public void Delete(Connection connection, DropCourse DropCourse) {
        DropCourseDaoImpl DropCourseDao = new DropCourseDaoImpl();
        DropCourseDao.Delete(connection, DropCourse);
    }

    @Override
    public void Update(Connection connection, DropCourse DropCourse) {
        DropCourseDaoImpl DropCourseDao = new DropCourseDaoImpl();
        DropCourseDao.Update(connection, DropCourse);
    }

    @Override
    public ArrayList<DropCourse> CheckBySid(Connection connection, int sid) {
        DropCourseDaoImpl DropCourseDao = new DropCourseDaoImpl();
        return DropCourseDao.SelectBySid(connection, sid);
    }

    @Override
    public ArrayList<DropCourse> CheckByCid(Connection connection, int cid) {
        DropCourseDaoImpl DropCourseDao = new DropCourseDaoImpl();
        return DropCourseDao.SelectByCid(connection, cid);
    }
}
