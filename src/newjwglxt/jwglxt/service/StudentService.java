package newjwglxt.jwglxt.service;

import jwglxt.Student;

import java.sql.Connection;

public class StudentService implements BaseService<Student> {
    @Override
    public boolean LoginVerify(Connection connection, Student student) {
        return false;
    }

    @Override
    public void ChangePassword(Connection connection, Student student) {

    }

    @Override
    public void Add(Connection connection, Student student) {

    }

    @Override
    public void Delete(Connection connection, Student student) {

    }

    @Override
    public void Update(Connection connection, Student student) {

    }

    @Override
    public Student Check(Connection connection, Student student) {
        return null;
    }
}
