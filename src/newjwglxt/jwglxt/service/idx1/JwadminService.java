package newjwglxt.jwglxt.service.idx1;

import newjwglxt.jwglxt.dao.idx1.JwadminDaoImpl;
import newjwglxt.jwglxt.dao.idx2.DropCourseDaoImpl;
import newjwglxt.jwglxt.entity.DropCourse;
import newjwglxt.jwglxt.entity.Jwadmin;
import newjwglxt.jwglxt.util.DbConnector;

import java.util.ArrayList;
import java.util.Vector;

public class JwadminService implements Service_idx1<Jwadmin>, LoginService<Jwadmin> {
    @Override
    public Jwadmin LoginVerify(DbConnector dbConnector, int id, String pw) {
        JwadminDaoImpl JwadminDao = new JwadminDaoImpl();
        ArrayList<Jwadmin> arrayList = JwadminDao.SelectById(dbConnector.getConnection(), id);

        if (arrayList.size() != 1)
            return null;
        else {
            Jwadmin Jwadmin = arrayList.get(0);
            if (Jwadmin.getPw().equals(pw))
                return Jwadmin;
            else
                return null;
        }
    }

    @Override
    public void Add(DbConnector dbConnector, Jwadmin Jwadmin) {
        JwadminDaoImpl JwadminDao = new JwadminDaoImpl();
        JwadminDao.Insert(dbConnector.getConnection(), Jwadmin);
    }

    @Override
    public void Delete(DbConnector dbConnector, Jwadmin Jwadmin) {
        JwadminDaoImpl JwadminDao = new JwadminDaoImpl();
        JwadminDao.Delete(dbConnector.getConnection(), Jwadmin);
    }

    @Override
    public void Update(DbConnector dbConnector, Jwadmin Jwadmin) {
        JwadminDaoImpl JwadminDao = new JwadminDaoImpl();
        JwadminDao.Update(dbConnector.getConnection(), Jwadmin);
    }

    @Override
    public ArrayList<Jwadmin> CheckById(DbConnector dbConnector, int id) {
        JwadminDaoImpl JwadminDao = new JwadminDaoImpl();
        return JwadminDao.SelectById(dbConnector.getConnection(), id);
    }

    @Override
    public ArrayList<Jwadmin> CheckByIdRough(DbConnector dbConnector, int id) {
        JwadminDaoImpl JwadminDao = new JwadminDaoImpl();
        return JwadminDao.SelectByIdRough(dbConnector.getConnection(), id);
    }

    @Override
    public ArrayList<Jwadmin> CheckByName(DbConnector dbConnector, String name) {
        JwadminDaoImpl JwadminDao = new JwadminDaoImpl();
        return JwadminDao.SelectByName(dbConnector.getConnection(), name);
    }

    @Override
    public ArrayList<Jwadmin> CheckByNameRough(DbConnector dbConnector, String name) {
        JwadminDaoImpl JwadminDao = new JwadminDaoImpl();
        return JwadminDao.SelectByNameRough(dbConnector.getConnection(), name);
    }

    public Vector<Vector<Object>> getDropCourseVector(DbConnector dbConnector) {
        DropCourseDaoImpl dropCourseDao = new DropCourseDaoImpl();
        ArrayList<DropCourse> dropCourses = dropCourseDao.Select(dbConnector.getConnection());
        Vector<Vector<Object>> dropCourseCol = new Vector<>();
        CourseService courseService = new CourseService();
        TeacherService teacherService = new TeacherService();
        StudentService studentService = new StudentService();

        for (DropCourse dropCourse : dropCourses) {
            Vector<Object> dropCourseRow = new Vector<>();
            //处理情况
            dropCourseRow.add(dropCourse.getDchandle());
            //学号
            dropCourseRow.add(dropCourse.getDcsid());
            //姓名
            dropCourseRow.add(studentService.CheckById(dbConnector, dropCourse.getDcsid()).get(0).getName());
            //课程号
            dropCourseRow.add(dropCourse.getDccid());
            //课程名
            dropCourseRow.add(courseService.CheckById(dbConnector, dropCourse.getDccid()).get(0).getCname());
            //任课教师
            dropCourseRow.add(teacherService.CheckById(dbConnector, courseService.CheckById(dbConnector, dropCourse.getDccid()).get(0).getCteacherid()).get(0).getName());

            dropCourseCol.add(dropCourseRow);
        }
        return dropCourseCol;
    }
}
