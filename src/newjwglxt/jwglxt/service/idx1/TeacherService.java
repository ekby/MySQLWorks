package newjwglxt.jwglxt.service.idx1;

import newjwglxt.jwglxt.dao.idx1.TeacherDaoImpl;
import newjwglxt.jwglxt.entity.Teacher;
import newjwglxt.jwglxt.util.DbConnector;

import java.util.ArrayList;
import java.util.Vector;

public class TeacherService implements Service_idx1<Teacher>, LoginService<Teacher> {

    @Override
    public Teacher LoginVerify(DbConnector dbConnector, int id, String pw) {
        TeacherDaoImpl teacherDao = new TeacherDaoImpl();
        ArrayList<Teacher> arrayList = teacherDao.SelectById(dbConnector.getConnection(), id);

        if (arrayList.size() != 1)
            return null;
        else {
            Teacher teacher = arrayList.get(0);
            if (teacher.getPw().equals(pw))
                return teacher;
            else
                return null;
        }
    }

    @Override
    public void Add(DbConnector dbConnector, Teacher teacher) {
        TeacherDaoImpl teacherDao = new TeacherDaoImpl();
        teacherDao.Insert(dbConnector.getConnection(), teacher);
    }

    @Override
    public void Delete(DbConnector dbConnector, Teacher teacher) {
        TeacherDaoImpl teacherDao = new TeacherDaoImpl();
        teacherDao.Delete(dbConnector.getConnection(), teacher);
    }

    @Override
    public void Update(DbConnector dbConnector, Teacher teacher) {
        TeacherDaoImpl teacherDao = new TeacherDaoImpl();
        teacherDao.Update(dbConnector.getConnection(), teacher);
    }

    @Override
    public ArrayList<Teacher> CheckById(DbConnector dbConnector, int id) {
        TeacherDaoImpl teacherDao = new TeacherDaoImpl();
        return teacherDao.SelectById(dbConnector.getConnection(), id);
    }

    @Override
    public ArrayList<Teacher> CheckByIdRough(DbConnector dbConnector, int id) {
        TeacherDaoImpl teacherDao = new TeacherDaoImpl();
        return teacherDao.SelectByIdRough(dbConnector.getConnection(), id);
    }

    @Override
    public ArrayList<Teacher> CheckByName(DbConnector dbConnector, String name) {
        TeacherDaoImpl teacherDao = new TeacherDaoImpl();
        return teacherDao.SelectByName(dbConnector.getConnection(), name);
    }

    @Override
    public ArrayList<Teacher> CheckByNameRough(DbConnector dbConnector, String name) {
        TeacherDaoImpl teacherDao = new TeacherDaoImpl();
        return teacherDao.SelectByName(dbConnector.getConnection(), name);
    }

    public Vector<Vector<Object>> getAllTeacherVector_jwadmin(DbConnector dbConnector) {
        TeacherDaoImpl teacherDao = new TeacherDaoImpl();
        ArrayList<Teacher> allTeachers = teacherDao.Select(dbConnector.getConnection());
        Vector<Vector<Object>> teacherCol = new Vector<>();
        for (Teacher teacher : allTeachers) {
            Vector<Object> teacherRow = new Vector<>();
            teacherRow.add(teacher.getId());
            teacherRow.add(teacher.getName());
            teacherRow.add(teacher.getGender());
            teacherRow.add(teacher.getTfirstyear());
            teacherRow.add(teacher.getTtitle());
            teacherRow.add(teacher.getTcollege());
            teacherRow.add(teacher.getContact());
            teacherCol.add(teacherRow);
        }
        return teacherCol;
    }

    // 判断一个tid是否存在
    public boolean ifIdExist(DbConnector dbConnector, int id) {
        if (Integer.toString(id).length() != 5)
            return false;
        else {
            TeacherDaoImpl teacherDao = new TeacherDaoImpl();
            ArrayList<Teacher> teachers = teacherDao.Select(dbConnector.getConnection());
            for (Teacher teacher : teachers) {
                if (teacher.getId() == id)
                    return true;
            }
            return false;
        }
    }

    public Vector<Vector<Object>> CheckByIdRough_Vector(DbConnector dbConnector, int id) {
        TeacherDaoImpl teacherDao = new TeacherDaoImpl();
        ArrayList<Teacher> arrayList = teacherDao.SelectByIdRough(dbConnector.getConnection(), id);
        Vector<Vector<Object>> col = new Vector<>();
        for (Teacher jwadmin : arrayList) {
            Vector<Object> row = new Vector<>();
            row.add(jwadmin.getId());
            row.add(jwadmin.getName());
            row.add(jwadmin.getGender());
            row.add(jwadmin.getTfirstyear());
            row.add(jwadmin.getTtitle());
            row.add(jwadmin.getTcollege());
            row.add(jwadmin.getContact());
            col.add(row);
        }
        return col;
    }

    public Vector<Vector<Object>> CheckByNameRough_Vector(DbConnector dbConnector, String name) {
        TeacherDaoImpl teacherDao = new TeacherDaoImpl();
        ArrayList<Teacher> arrayList = teacherDao.SelectByNameRough(dbConnector.getConnection(), name);
        Vector<Vector<Object>> col = new Vector<>();
        for (Teacher jwadmin : arrayList) {
            Vector<Object> row = new Vector<>();
            row.add(jwadmin.getId());
            row.add(jwadmin.getName());
            row.add(jwadmin.getGender());
            row.add(jwadmin.getTfirstyear());
            row.add(jwadmin.getTtitle());
            row.add(jwadmin.getTcollege());
            row.add(jwadmin.getContact());
            col.add(row);
        }
        return col;
    }

    public Vector<Vector<Object>> CheckByTitleRough_Vector(DbConnector dbConnector, String title) {
        TeacherDaoImpl teacherDao = new TeacherDaoImpl();
        ArrayList<Teacher> arrayList = teacherDao.SelectByTitleRough(dbConnector.getConnection(), title);
        Vector<Vector<Object>> col = new Vector<>();
        for (Teacher jwadmin : arrayList) {
            Vector<Object> row = new Vector<>();
            row.add(jwadmin.getId());
            row.add(jwadmin.getName());
            row.add(jwadmin.getGender());
            row.add(jwadmin.getTfirstyear());
            row.add(jwadmin.getTtitle());
            row.add(jwadmin.getTcollege());
            row.add(jwadmin.getContact());
            col.add(row);
        }
        return col;
    }

    public Vector<Vector<Object>> CheckByCollegeRough_Vector(DbConnector dbConnector, String college) {
        TeacherDaoImpl teacherDao = new TeacherDaoImpl();
        ArrayList<Teacher> arrayList = teacherDao.SelectByCollegeRough(dbConnector.getConnection(), college);
        Vector<Vector<Object>> col = new Vector<>();
        for (Teacher jwadmin : arrayList) {
            Vector<Object> row = new Vector<>();
            row.add(jwadmin.getId());
            row.add(jwadmin.getName());
            row.add(jwadmin.getGender());
            row.add(jwadmin.getTfirstyear());
            row.add(jwadmin.getTtitle());
            row.add(jwadmin.getTcollege());
            row.add(jwadmin.getContact());
            col.add(row);
        }
        return col;
    }

    public Vector<Vector<Object>> CheckByFirstYearRough_Vector(DbConnector dbConnector, String fy) {
        TeacherDaoImpl teacherDao = new TeacherDaoImpl();
        ArrayList<Teacher> arrayList = teacherDao.SelectByFirstYearRough(dbConnector.getConnection(), fy);
        Vector<Vector<Object>> col = new Vector<>();
        for (Teacher jwadmin : arrayList) {
            Vector<Object> row = new Vector<>();
            row.add(jwadmin.getId());
            row.add(jwadmin.getName());
            row.add(jwadmin.getGender());
            row.add(jwadmin.getTfirstyear());
            row.add(jwadmin.getTtitle());
            row.add(jwadmin.getTcollege());
            row.add(jwadmin.getContact());
            col.add(row);
        }
        return col;
    }

}
