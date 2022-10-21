package newjwglxt.jwglxt;

import newjwglxt.jwglxt.dao.idx2.ChooseCourseDaoImpl;
import newjwglxt.jwglxt.entity.ChooseCourse;
import newjwglxt.jwglxt.service.idx2.ChooseCourseService;
import newjwglxt.jwglxt.util.DbConnector;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
//        Db db = new Db();
//
//        Student student = new Student("qk", 30121, "123", "f", "123", 2020, 201101, "xg", "jgxy");
//        StudentDaoImpl studentDao = new StudentDaoImpl();
//
////        studentDao.Insert(db.getConnection(), student);
//        Student student1 = new Student("qkkk", 30121, "123", "f", "123", 2020, 201101, "xg", "jgxy");
//        studentDao.Update(db.getConnection(), student, student1);

        DbConnector dbConnector = new DbConnector();
        Connection connection = dbConnector.getConnection();
//        System.out.println(studentDao.SelectById(connection, 30121).toString());
//        System.out.println(studentDao.SelectByName(connection, "xrc").toString());
//        System.out.println(studentDao.SelectByNameRough(connection, "x"));
//        System.out.println(studentDao.SelectByIdRough(connection, 0));
//        CourseDaoImpl courseDao = new CourseDaoImpl();
//        Course course0 = new Course(12, "骑马", "ds", 2.0, "ds", 20117, "12", "122", 12, 20);
//        Course course1 = new Course(12, "骑大象", "ds", 2.0, "ds", 20117, "12", "122", 12, 20);
//        courseDao.Insert(connection, course);
//        courseDao.Update(connection, course0, course1);
//        System.out.println(courseDao.SelectByIdRough(connection, 1));
//        System.out.println(courseDao.SelectByNameRough(connection, "x"));
//        CourseService courseService = new CourseService();
//        System.out.println(courseService.CheckByIdRough(connection, 1));

        ChooseCourseService chooseCourseService = new ChooseCourseService();
        ChooseCourse chooseCourse = new ChooseCourse(99, 30204, 12, 0, 0);
//        chooseCourseService.Add(connection, chooseCourse);
        ChooseCourseDaoImpl chooseCourseDao = new ChooseCourseDaoImpl();
        chooseCourseDao.Insert(connection, chooseCourse);

    }
}
