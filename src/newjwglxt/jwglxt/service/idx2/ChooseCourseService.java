package newjwglxt.jwglxt.service.idx2;

import newjwglxt.jwglxt.dao.idx2.ChooseCourseDaoImpl;
import newjwglxt.jwglxt.entity.ChooseCourse;
import newjwglxt.jwglxt.entity.Student;
import newjwglxt.jwglxt.service.idx1.CourseService;
import newjwglxt.jwglxt.service.idx1.TeacherService;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Vector;

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

    public Vector<Vector<Object>> getCourseVector(Connection connection, Student student) {
        ChooseCourseDaoImpl chooseCourseDao = new ChooseCourseDaoImpl();

        TeacherService teacherService = new TeacherService();
        CourseService courseService = new CourseService();

        ArrayList<ChooseCourse> chooseCourses = chooseCourseDao.Select(connection, student.getId());
        Vector<Vector<Object>> courseCol = new Vector<>();
        for (ChooseCourse chooseCourse: chooseCourses) {
            Vector<Object> courseRow = new Vector<>();
            courseRow.add(courseService.CheckById(connection, chooseCourse.getCccid()).get(0).getCname());
            courseRow.add(chooseCourse.getCccid());
            courseRow.add(courseService.CheckById(connection, chooseCourse.getCccid()).get(0).getCtime());
            courseRow.add(courseService.CheckById(connection, chooseCourse.getCccid()).get(0).getCroom());
            courseRow.add(courseService.CheckById(connection, chooseCourse.getCccid()).get(0).getCcredit());
            courseRow.add(courseService.CheckById(connection, chooseCourse.getCccid()).get(0).getCkclb());
            courseRow.add(teacherService.CheckById(connection, courseService.CheckById(connection, chooseCourse.getCccid()).get(0).getCteacherid()).get(0).getName());
            courseCol.add(courseRow);
        }
        return courseCol;
    }


}
