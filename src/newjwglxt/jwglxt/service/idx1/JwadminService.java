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
        JwadminService jwadminService = new JwadminService();
        StudentService studentService = new StudentService();

        for (DropCourse dropCourse : dropCourses) {
            Vector<Object> dropCourseRow = new Vector<>();
            //????????????
            dropCourseRow.add(dropCourse.getDchandle());
            //??????
            dropCourseRow.add(dropCourse.getDcsid());
            //??????
            dropCourseRow.add(studentService.CheckById(dbConnector, dropCourse.getDcsid()).get(0).getName());
            //?????????
            dropCourseRow.add(dropCourse.getDccid());
            //?????????
            dropCourseRow.add(courseService.CheckById(dbConnector, dropCourse.getDccid()).get(0).getCname());
            //????????????
            dropCourseRow.add(jwadminService.CheckById(dbConnector, courseService.CheckById(dbConnector, dropCourse.getDccid()).get(0).getCteacherid()).get(0).getName());

            dropCourseCol.add(dropCourseRow);
        }
        return dropCourseCol;
    }

    // ????????????jwid????????????
    public boolean ifIdExist(DbConnector dbConnector, int id) {
        if (Integer.toString(id).length() != 5)
            return false;
        else {
            JwadminDaoImpl jwadminDao = new JwadminDaoImpl();
            ArrayList<Jwadmin> jwadmins = jwadminDao.Select(dbConnector.getConnection());
            for (Jwadmin jwadmin : jwadmins) {
                if (jwadmin.getId() == id)
                    return true;
            }
            return false;
        }
    }

    public Vector<Vector<Object>> getAllJwadminVector(DbConnector dbConnector) {
        JwadminDaoImpl jwadminDao = new JwadminDaoImpl();
        ArrayList<Jwadmin> jwadmins = jwadminDao.Select(dbConnector.getConnection());
        Vector<Vector<Object>> jwCol = new Vector<>();
        for (Jwadmin jwadmin : jwadmins) {
            Vector<Object> jwadminRow = new Vector<>();
            jwadminRow.add(jwadmin.getId());
            jwadminRow.add(jwadmin.getName());
            jwadminRow.add(jwadmin.getGender());
            jwadminRow.add(jwadmin.getContact());
            jwCol.add(jwadminRow);
        }
        return jwCol;
    }

    public Vector<Vector<Object>> CheckByIdRough_Vector(DbConnector dbConnector, int id) {
        JwadminDaoImpl jwadminDao = new JwadminDaoImpl();
        ArrayList<Jwadmin> arrayList = jwadminDao.SelectByIdRough(dbConnector.getConnection(), id);
        Vector<Vector<Object>> col = new Vector<>();
        for (Jwadmin jwadmin : arrayList) {
            Vector<Object> row = new Vector<>();
            row.add(jwadmin.getId());
            row.add(jwadmin.getName());
            row.add(jwadmin.getGender());
            row.add(jwadmin.getContact());
            col.add(row);
        }
        return col;
    }

    public Vector<Vector<Object>> CheckByNameRough_Vector(DbConnector dbConnector, String name) {
        JwadminDaoImpl jwadminDao = new JwadminDaoImpl();
        ArrayList<Jwadmin> arrayList = jwadminDao.SelectByNameRough(dbConnector.getConnection(), name);
        Vector<Vector<Object>> col = new Vector<>();
        for (Jwadmin jwadmin : arrayList) {
            Vector<Object> row = new Vector<>();
            row.add(jwadmin.getId());
            row.add(jwadmin.getName());
            row.add(jwadmin.getGender());
            row.add(jwadmin.getContact());
            col.add(row);
        }
        return col;
    }
}
