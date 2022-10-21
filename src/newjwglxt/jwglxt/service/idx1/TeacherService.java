package newjwglxt.jwglxt.service.idx1;

import newjwglxt.jwglxt.dao.idx1.TeacherDaoImpl;
import newjwglxt.jwglxt.entity.Teacher;
import newjwglxt.jwglxt.util.DbConnector;

import java.util.ArrayList;

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

}
