package newjwglxt.jwglxt.service.idx2;

import newjwglxt.jwglxt.dao.idx2.ChooseCourseDaoImpl;
import newjwglxt.jwglxt.entity.ChooseCourse;
import newjwglxt.jwglxt.entity.Student;
import newjwglxt.jwglxt.service.idx1.CourseService;
import newjwglxt.jwglxt.service.idx1.StudentService;
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

    // 为studentPanel的查询自己已选课程功能返回数据库中该学生已选的课程信息
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

    // 为teacherPanel的成绩管理功能返回数据库中的sid, sname, score信息
    public Vector<Vector<Object>> getXueshengchengjibiaoVector(Connection connection, int courseID) {
        ChooseCourseService chooseCourseService = new ChooseCourseService();
        StudentService studentService = new StudentService();
        // sid_and_score装有选择该课的学生的学号和成绩信息
        ArrayList<ChooseCourse> sid_and_score = chooseCourseService.CheckByCid(connection, courseID);
        // snameArrayList装有选择该课的学生的姓名信息
        ArrayList<Student> snameArrayList = new ArrayList<>();
        for (ChooseCourse chooseCourse : sid_and_score) {
            ArrayList<Student> sname = studentService.CheckById(connection, chooseCourse.getCcsid());
            snameArrayList.add(sname.get(0));
        }
        Vector<Vector<Object>> sid_sname_score_COL = new Vector<>();
        for (int i = 0; i < sid_and_score.size(); i++) {
            Vector<Object> row = new Vector<>();
            row.add(sid_and_score.get(i).getCcsid());
            row.add(snameArrayList.get(i).getName());
            row.add(sid_and_score.get(i).getCcscore());
            sid_sname_score_COL.add(row);
        }
        return sid_sname_score_COL;
    }

    public ArrayList<ChooseCourse> CheckBySidAndCid(Connection connection, int sid, int cid) {
        ChooseCourseDaoImpl chooseCourseDao = new ChooseCourseDaoImpl();
        return chooseCourseDao.SelectBySidAndCid(connection, sid, cid);
    }
}
