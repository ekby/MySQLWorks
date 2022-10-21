package newjwglxt.jwglxt.service.idx1;

import newjwglxt.jwglxt.dao.idx1.StudentDaoImpl;
import newjwglxt.jwglxt.entity.Student;
import newjwglxt.jwglxt.util.DbConnector;

import java.util.ArrayList;

public class StudentService implements Service_idx1<Student>, LoginService<Student> {
    @Override
    public Student LoginVerify(DbConnector dbConnector, int id, String pw) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        ArrayList<Student> arrayList = studentDao.SelectById(dbConnector.getConnection(), id);

        if (arrayList.size() != 1)
            return null;
        else {
            Student student = arrayList.get(0);
            if (student.getPw().equals(pw))
                return student;
            else
                return null;
        }
    }

    @Override
    public void Add(DbConnector dbConnector, Student student) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        studentDao.Insert(dbConnector.getConnection(), student);
    }

    @Override
    public void Delete(DbConnector dbConnector, Student student) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        studentDao.Delete(dbConnector.getConnection(), student);
    }

    @Override
    public void Update(DbConnector dbConnector, Student student) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        studentDao.Update(dbConnector.getConnection(), student);
    }

    @Override
    public ArrayList<Student> CheckById(DbConnector dbConnector, int id) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        return studentDao.SelectById(dbConnector.getConnection(), id);
    }

    @Override
    public ArrayList<Student> CheckByIdRough(DbConnector dbConnector, int id) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        return studentDao.SelectByIdRough(dbConnector.getConnection(), id);
    }

    @Override
    public ArrayList<Student> CheckByName(DbConnector dbConnector, String name) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        return studentDao.SelectByName(dbConnector.getConnection(), name);
    }

    @Override
    public ArrayList<Student> CheckByNameRough(DbConnector dbConnector, String name) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        return studentDao.SelectByNameRough(dbConnector.getConnection(), name);
    }
}
