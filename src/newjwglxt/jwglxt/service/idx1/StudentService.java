package newjwglxt.jwglxt.service.idx1;

import newjwglxt.jwglxt.dao.idx1.StudentDaoImpl;
import newjwglxt.jwglxt.entity.Student;

import java.sql.Connection;
import java.util.ArrayList;

public class StudentService implements Service_idx1<Student>, LoginService<Student> {
    @Override
    public Student LoginVerify(Connection connection, int id, String pw) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        ArrayList<Student> arrayList = studentDao.SelectById(connection, id);

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
    public void Add(Connection connection, Student student) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        studentDao.Insert(connection, student);
    }

    @Override
    public void Delete(Connection connection, Student student) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        studentDao.Delete(connection, student);
    }

    @Override
    public void Update(Connection connection, Student student) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        studentDao.Update(connection, student);
    }

    @Override
    public ArrayList<Student> CheckById(Connection connection, int id) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        return studentDao.SelectById(connection, id);
    }

    @Override
    public ArrayList<Student> CheckByIdRough(Connection connection, int id) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        return studentDao.SelectByIdRough(connection, id);
    }

    @Override
    public ArrayList<Student> CheckByName(Connection connection, String name) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        return studentDao.SelectByName(connection, name);
    }

    @Override
    public ArrayList<Student> CheckByNameRough(Connection connection, String name) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        return studentDao.SelectByNameRough(connection, name);
    }
}
