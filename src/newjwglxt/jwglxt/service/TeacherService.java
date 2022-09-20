package newjwglxt.jwglxt.service;
import newjwglxt.jwglxt.dao.idx1.TeacherDaoImpl;
import newjwglxt.jwglxt.entity.Teacher;

import java.sql.Connection;
import java.util.ArrayList;

public class TeacherService implements BaseService<Teacher>{

    @Override
    public Teacher LoginVerify(Connection connection, int id, String pw) {
        TeacherDaoImpl teacherDao = new TeacherDaoImpl();
        ArrayList<Teacher> arrayList = teacherDao.SelectById(connection, id);

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
    public void Add(Connection connection, Teacher teacher) {
        TeacherDaoImpl teacherDao = new TeacherDaoImpl();
        teacherDao.Insert(connection, teacher);
    }

    @Override
    public void Delete(Connection connection, Teacher teacher) {
        TeacherDaoImpl teacherDao = new TeacherDaoImpl();
        teacherDao.Delete(connection, teacher);
    }

    @Override
    public void Update(Connection connection, Teacher teacher) {
        TeacherDaoImpl teacherDao = new TeacherDaoImpl();
        teacherDao.Update(connection, teacher);
    }

    @Override
    public ArrayList<Teacher> CheckById(Connection connection, int id) {
        TeacherDaoImpl teacherDao = new TeacherDaoImpl();
        return teacherDao.SelectById(connection, id);
    }

    @Override
    public ArrayList<Teacher> CheckByIdRough(Connection connection, int id) {
        TeacherDaoImpl teacherDao = new TeacherDaoImpl();
        return teacherDao.SelectByIdRough(connection, id);
    }

    @Override
    public ArrayList<Teacher> CheckByName(Connection connection, String name) {
        TeacherDaoImpl teacherDao = new TeacherDaoImpl();
        return teacherDao.SelectByName(connection, name);
    }

    @Override
    public ArrayList<Teacher> CheckByNameRough(Connection connection, String name) {
        TeacherDaoImpl teacherDao = new TeacherDaoImpl();
        return teacherDao.SelectByName(connection, name);
    }

}
