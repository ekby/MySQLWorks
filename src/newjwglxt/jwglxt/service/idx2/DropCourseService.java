package newjwglxt.jwglxt.service.idx2;

import newjwglxt.jwglxt.dao.idx2.DropCourseDaoImpl;
import newjwglxt.jwglxt.entity.DropCourse;
import newjwglxt.jwglxt.util.DbConnector;

import java.util.ArrayList;

public class DropCourseService implements Service_idx2<DropCourse> {
    @Override
    public void Add(DbConnector dbConnector, DropCourse DropCourse) {
        DropCourseDaoImpl DropCourseDao = new DropCourseDaoImpl();
        DropCourseDao.Insert(dbConnector.getConnection(), DropCourse);
    }

    @Override
    public void Delete(DbConnector dbConnector, DropCourse DropCourse) {
        DropCourseDaoImpl DropCourseDao = new DropCourseDaoImpl();
        DropCourseDao.Delete(dbConnector.getConnection(), DropCourse);
    }

    @Override
    public void Update(DbConnector dbConnector, DropCourse DropCourse) {
        DropCourseDaoImpl DropCourseDao = new DropCourseDaoImpl();
        DropCourseDao.Update(dbConnector.getConnection(), DropCourse);
    }

    @Override
    public ArrayList<DropCourse> CheckBySid(DbConnector dbConnector, int sid) {
        DropCourseDaoImpl DropCourseDao = new DropCourseDaoImpl();
        return DropCourseDao.SelectBySid(dbConnector.getConnection(), sid);
    }

    @Override
    public ArrayList<DropCourse> CheckByCid(DbConnector dbConnector, int cid) {
        DropCourseDaoImpl DropCourseDao = new DropCourseDaoImpl();
        return DropCourseDao.SelectByCid(dbConnector.getConnection(), cid);
    }
}
