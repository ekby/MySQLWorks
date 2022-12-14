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

/*
    public ArrayList<Student> CheckByClass(DbConnector dbConnector, int sclass) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        return studentDao.SelectByClass(dbConnector.getConnection(), sclass);
    }
*/

/*
    public ArrayList<Student> CheckByMajor(DbConnector dbConnector, String major) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        return studentDao.SelectByMajor(dbConnector.getConnection(), major);
    }
*/

/*
    public ArrayList<Student> CheckByDepartment(DbConnector dbConnector, String department) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        return studentDao.SelectByDepartment(dbConnector.getConnection(), department);
    }
*/

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

    // ????????????sid????????????
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

    public Vector<Vector<Object>> CheckByClass_Vector(DbConnector dbConnector, String c) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        ArrayList<Student> allStudents = studentDao.SelectByClassRough(dbConnector.getConnection(), c);
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

    public Vector<Vector<Object>> CheckByMajorRough_Vector(DbConnector dbConnector, String m) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        ArrayList<Student> allStudents = studentDao.SelectByMajorRough(dbConnector.getConnection(), m);
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

    public Vector<Vector<Object>> CheckByCollegeRough_Vector(DbConnector dbConnector, String c) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        ArrayList<Student> allStudents = studentDao.SelectByDepartmentRough(dbConnector.getConnection(), c);
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
