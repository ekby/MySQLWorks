package newjwglxt.jwglxt.service.idx1;

import newjwglxt.jwglxt.dao.idx1.CourseDaoImpl;
import newjwglxt.jwglxt.entity.ChooseCourse;
import newjwglxt.jwglxt.entity.Course;
import newjwglxt.jwglxt.entity.Student;
import newjwglxt.jwglxt.entity.Teacher;
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

    // 为studentPanel的可选课程功能返回该学生除去已选的课程之外的课程的信息
    public Vector<Vector<Object>> getCourseVector_exceptSelectedCourses(Connection connection, Student student) {
        CourseDaoImpl courseDao = new CourseDaoImpl();
        TeacherService teacherService = new TeacherService();
        ArrayList<Course> allCourses = courseDao.Select(connection);
        ArrayList<Integer> allCourses_cid = new ArrayList<>();
        for (Course course : allCourses) {
            allCourses_cid.add(course.getCid());
        }

        ChooseCourseService chooseCourseService = new ChooseCourseService();
        ArrayList<ChooseCourse> chosenCourses = chooseCourseService.CheckBySid(connection, student.getId());
        ArrayList<Integer> chosenCourses_cid = new ArrayList<>();
        for (ChooseCourse chooseCourse : chosenCourses) {
            chosenCourses_cid.add(chooseCourse.getCccid());
        }


        ArrayList<Integer> courses_cid = new ArrayList<>();
        for (int x : allCourses_cid) {
            if (!chosenCourses_cid.contains(x)) {
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

    // 为teacherPanel的我教的课程功能返回该老师所教的所有课程信息
    public Vector<Vector<Object>> getMyCourseVector_teacher(Connection connection, Teacher teacher) {
        CourseDaoImpl courseDao = new CourseDaoImpl();
        ArrayList<Course> myAllCourses = courseDao.SelectByTeacherID(connection, teacher.getId());
        Vector<Vector<Object>> courseCol = new Vector<>();
        for (Course course : myAllCourses) {
            Vector<Object> courseRow = new Vector<>();
            courseRow.add(course.getCid());
            courseRow.add(course.getCname());
            courseRow.add(course.getCdepartment());
            courseRow.add(course.getCcredit());
            courseRow.add(course.getCkclb());
            courseRow.add(course.getCroom());
            courseRow.add(course.getCtime());
            courseRow.add(course.getCsigned_num());
            courseRow.add(course.getCmax_num());
            courseCol.add(courseRow);
        }
        return courseCol;
    }

    // 为teacherPanel的成绩管理的JcomboBox返回该老师所教的课的Name向量
    public Vector<String> getMyCourseNameVector_teacher(Connection connection, Teacher teacher) {
        CourseDaoImpl courseDao = new CourseDaoImpl();
        ArrayList<Course> myAllCourses = courseDao.SelectByTeacherID(connection, teacher.getId());
        Vector<String> vector_myCourseName = new Vector<>();
        for (Course course : myAllCourses)
            vector_myCourseName.add(String.format("[%d]%s", course.getCid(), course.getCname()));
        return vector_myCourseName;
    }

}
