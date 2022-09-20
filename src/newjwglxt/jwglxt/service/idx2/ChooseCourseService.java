package newjwglxt.jwglxt.service.idx2;

import newjwglxt.jwglxt.dao.idx2.ChooseCourseDaoImpl;
import newjwglxt.jwglxt.entity.ChooseCourse;

import java.sql.Connection;
import java.util.ArrayList;

public class ChooseCourseService implements Service_idx2<ChooseCourse> {
    @Override
    public void Add(Connection connection, ChooseCourse chooseCourse) {
        ChooseCourseDaoImpl chooseCourseDao = new ChooseCourseDaoImpl();
        chooseCourseDao.Insert(connection, chooseCourse);
    }

    @Override
    public void Delete(Connection connection, ChooseCourse chooseCourse) {
        ChooseCourseDaoImpl chooseCourseDao = new ChooseCourseDaoImpl();
        chooseCourseDao.Delete(connection, chooseCourse);
    }

    @Override
    public void Update(Connection connection, ChooseCourse chooseCourse) {
        ChooseCourseDaoImpl chooseCourseDao = new ChooseCourseDaoImpl();
        chooseCourseDao.Update(connection, chooseCourse);
    }

    @Override
    public ArrayList<ChooseCourse> CheckBySid(Connection connection, int sid) {
        ChooseCourseDaoImpl chooseCourseDao = new ChooseCourseDaoImpl();
        return chooseCourseDao.SelectBySid(connection, sid);
    }

    @Override
    public ArrayList<ChooseCourse> CheckByCid(Connection connection, int cid) {
        ChooseCourseDaoImpl chooseCourseDao = new ChooseCourseDaoImpl();
        return chooseCourseDao.SelectByCid(connection, cid);
    }
}
