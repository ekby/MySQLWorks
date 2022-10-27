package newjwglxt.jwglxt.service.idx2;

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

    public Vector<Vector<Object>> getDropCourseVector(DbConnector dbConnector, Student student){
        DropCourseDaoImpl dropCourseDao = new DropCourseDaoImpl();
        ArrayList<DropCourse> dropCourses = dropCourseDao.Select(dbConnector.getConnection(), student.getId());
        Vector<Vector<Object>> dropCourseCol = new Vector<>();
        CourseService courseService = new CourseService();
        TeacherService teacherService = new TeacherService();

        for(DropCourse dropCourse : dropCourses){
            Vector<Object> dropCourseRow = new Vector<>();
            dropCourseRow.add(dropCourse.getDccid());
            dropCourseRow.add(courseService.CheckById(dbConnector, dropCourse.getDccid()).get(0).getCname());
            dropCourseRow.add(teacherService.CheckById(dbConnector, courseService.CheckById(dbConnector, dropCourse.getDccid()).get(0).getCteacherid()).get(0).getName());
            dropCourseRow.add(courseService.CheckById(dbConnector, dropCourse.getDccid()).get(0).getCkclb());
            dropCourseRow.add(courseService.CheckById(dbConnector, dropCourse.getDccid()).get(0).getCcredit());
            dropCourseRow.add(dropCourse.getDchandle());
            dropCourseCol.add(dropCourseRow);
        }

        return dropCourseCol;
    }
}
