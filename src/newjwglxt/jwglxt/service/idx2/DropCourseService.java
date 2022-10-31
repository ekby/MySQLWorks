package newjwglxt.jwglxt.service.idx2;

import newjwglxt.jwglxt.dao.idx1.CourseDaoImpl;
import newjwglxt.jwglxt.dao.idx1.StudentDaoImpl;
import newjwglxt.jwglxt.dao.idx2.DropCourseDaoImpl;
import newjwglxt.jwglxt.entity.DropCourse;
import newjwglxt.jwglxt.entity.Student;
import newjwglxt.jwglxt.service.idx1.CourseService;
import newjwglxt.jwglxt.service.idx1.TeacherService;
import newjwglxt.jwglxt.util.DbConnector;

import java.util.ArrayList;
import java.util.Vector;

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

    public Vector<Vector<Object>> getDropCourseVector(DbConnector dbConnector, Student student) {
        //判断:0未判断；1退课审核通过；-1退课审核未通过
        DropCourseDaoImpl dropCourseDao = new DropCourseDaoImpl();
        ArrayList<DropCourse> dropCourses = dropCourseDao.Select(dbConnector.getConnection(), student);
        Vector<Vector<Object>> dropCourseCol = new Vector<>();
        CourseService courseService = new CourseService();
        TeacherService teacherService = new TeacherService();

        for (DropCourse dropCourse : dropCourses) {
            Vector<Object> dropCourseRow = new Vector<>();
            dropCourseRow.add(dropCourse.getDccid());
            if (dropCourse.getDchandle() == 0) {
                dropCourseRow.add("待处理");
            } else if (dropCourse.getDchandle() == -1) {
                dropCourseRow.add("已驳回");
            } else {
                dropCourseRow.add("成功");
            }
            dropCourseRow.add(courseService.CheckById(dbConnector, dropCourse.getDccid()).get(0).getCname());
            dropCourseRow.add(teacherService.CheckById(dbConnector, courseService.CheckById(dbConnector, dropCourse.getDccid()).get(0).getCteacherid()).get(0).getName());
            dropCourseRow.add(courseService.CheckById(dbConnector, dropCourse.getDccid()).get(0).getCkclb());
            dropCourseRow.add(courseService.CheckById(dbConnector, dropCourse.getDccid()).get(0).getCcredit());
            dropCourseCol.add(dropCourseRow);
        }

        return dropCourseCol;
    }

    public Vector<Vector<Object>> getUnhandledCourses(DbConnector dbConnector) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        CourseDaoImpl courseDao = new CourseDaoImpl();
        DropCourseDaoImpl dropCourseDao = new DropCourseDaoImpl();
        ArrayList<DropCourse> unhandeldCourses = dropCourseDao.Select(dbConnector.getConnection());
        Vector<Vector<Object>> col = new Vector<>();
        for (DropCourse dropCourse : unhandeldCourses) {
            if (dropCourse.getDchandle() == 0) {
                Vector<Object> row = new Vector<>();
                row.add(dropCourse.getDcid());
                row.add(dropCourse.getDcsid());
                row.add(studentDao.SelectById(dbConnector.getConnection(), dropCourse.getDcsid()).get(0).getName());
                row.add(dropCourse.getDccid());
                row.add(courseDao.SelectById(dbConnector.getConnection(), dropCourse.getDccid()).get(0).getCname());
                col.add(row);
            }
        }
        return col;
    }

    public ArrayList<DropCourse> CheckByDcid(DbConnector dbConnector, int dcid) {
        DropCourseDaoImpl dropCourseDao = new DropCourseDaoImpl();
        return dropCourseDao.SelectByDcid(dbConnector.getConnection(), dcid);
    }
}
