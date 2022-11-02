package newjwglxt.jwglxt.service.idx1;

import newjwglxt.jwglxt.dao.idx1.StudentDaoImpl;
import newjwglxt.jwglxt.entity.Student;
import newjwglxt.jwglxt.util.DbConnector;

import java.util.ArrayList;
import java.util.Vector;

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

    public Vector<Vector<Object>> getAllStudentVector(DbConnector dbConnector) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        ArrayList<Student> allStudents = studentDao.Select(dbConnector.getConnection());
        Vector<Vector<Object>> studentCol = new Vector<>();
        for (Student student : allStudents) {
            Vector<Object> studentRow = new Vector<>();
            studentRow.add(student.getId());
            studentRow.add(student.getName());
            studentRow.add(student.getGender());
            studentRow.add(student.getSfirstyear());
            studentRow.add(student.getSmajor());
            studentRow.add(student.getSclass());
            studentRow.add(student.getScollege());
            studentRow.add(student.getContact());
            studentCol.add(studentRow);
        }
        return studentCol;
    }

    // 判断一个sid是否存在
    public boolean ifIdExist(DbConnector dbConnector, int id) {
        if (Integer.toString(id).length() != 5)
            return false;
        else {
            StudentDaoImpl studentDao = new StudentDaoImpl();
            ArrayList<Student> students = studentDao.Select(dbConnector.getConnection());
            for (Student student : students) {
                if (student.getId() == id)
                    return true;
            }
            return false;
        }
    }

    public Vector<Vector<Object>> CheckByIdRough_Vector(DbConnector dbConnector, int id) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        ArrayList<Student> allStudents = studentDao.SelectByIdRough(dbConnector.getConnection(), id);
        Vector<Vector<Object>> studentCol = new Vector<>();
        for (Student student : allStudents) {
            Vector<Object> studentRow = new Vector<>();
            studentRow.add(student.getId());
            studentRow.add(student.getName());
            studentRow.add(student.getGender());
            studentRow.add(student.getSfirstyear());
            studentRow.add(student.getSmajor());
            studentRow.add(student.getSclass());
            studentRow.add(student.getScollege());
            studentRow.add(student.getContact());
            studentCol.add(studentRow);
        }
        return studentCol;
    }

    public Vector<Vector<Object>> CheckByNameRough_Vector(DbConnector dbConnector, String name) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        ArrayList<Student> allStudents = studentDao.SelectByNameRough(dbConnector.getConnection(), name);
        Vector<Vector<Object>> studentCol = new Vector<>();
        for (Student student : allStudents) {
            Vector<Object> studentRow = new Vector<>();
            studentRow.add(student.getId());
            studentRow.add(student.getName());
            studentRow.add(student.getGender());
            studentRow.add(student.getSfirstyear());
            studentRow.add(student.getSmajor());
            studentRow.add(student.getSclass());
            studentRow.add(student.getScollege());
            studentRow.add(student.getContact());
            studentCol.add(studentRow);
        }
        return studentCol;
    }

    public Vector<Vector<Object>> CheckByFirstYearRough_Vector(DbConnector dbConnector, String fy) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        ArrayList<Student> allStudents = studentDao.SelectByFirstYearRough(dbConnector.getConnection(), fy);
        Vector<Vector<Object>> studentCol = new Vector<>();
        for (Student student : allStudents) {
            Vector<Object> studentRow = new Vector<>();
            studentRow.add(student.getId());
            studentRow.add(student.getName());
            studentRow.add(student.getGender());
            studentRow.add(student.getSfirstyear());
            studentRow.add(student.getSmajor());
            studentRow.add(student.getSclass());
            studentRow.add(student.getScollege());
            studentRow.add(student.getContact());
            studentCol.add(studentRow);
        }
        return studentCol;
    }


}
