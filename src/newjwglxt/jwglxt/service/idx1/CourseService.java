package newjwglxt.jwglxt.service.idx1;

import newjwglxt.jwglxt.dao.idx1.CourseDaoImpl;
import newjwglxt.jwglxt.entity.ChooseCourse;
import newjwglxt.jwglxt.entity.Course;
import newjwglxt.jwglxt.entity.Student;
import newjwglxt.jwglxt.service.idx2.ChooseCourseService;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Vector;

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

    public ArrayList<Course> ShowCourse(Connection connection) {
        CourseDaoImpl courseDao = new CourseDaoImpl();
        return courseDao.Select(connection);
    }

    public Vector<Vector<Object>> getCourseVector_exceptSelectedCourses(Connection connection, Student student) {
        CourseDaoImpl courseDao = new CourseDaoImpl();
        TeacherService teacherService = new TeacherService();
        ArrayList<Course> allCourses = courseDao.Select(connection);
        ArrayList<Integer> allCourses_cid = new ArrayList<>();
        for (Course course: allCourses) {
            allCourses_cid.add(course.getCid());
        }

        ChooseCourseService chooseCourseService = new ChooseCourseService();
        ArrayList<ChooseCourse> chosenCourses = chooseCourseService.CheckBySid(connection, student.getId());
        ArrayList<Integer> chosenCourses_cid = new ArrayList<>();
        for (ChooseCourse chooseCourse: chosenCourses) {
            chosenCourses_cid.add(chooseCourse.getCccid());
        }


        ArrayList<Integer> courses_cid = new ArrayList<>();
        for (int x: allCourses_cid) {
            if (!chosenCourses_cid.contains(x)){
                courses_cid.add(x);
            }
        }

        CourseService courseService = new CourseService();

        Vector<Vector<Object>> courseCol = new Vector<>();
        for (int cid : courses_cid) {
            Vector<Object> courseRow = new Vector<>();
            courseRow.add(courseService.CheckById(connection, cid).get(0).getCname());
            courseRow.add(cid);
            courseRow.add(courseService.CheckById(connection, cid).get(0).getCtime());
            courseRow.add(courseService.CheckById(connection, cid).get(0).getCroom());
            courseRow.add(courseService.CheckById(connection, cid).get(0).getCcredit());
            courseRow.add(courseService.CheckById(connection, cid).get(0).getCkclb());
            courseRow.add(teacherService.CheckById(connection, courseService.CheckById(connection, cid).get(0).getCteacherid()).get(0).getName());
            courseCol.add(courseRow);
        }


        return courseCol;
    }
}
