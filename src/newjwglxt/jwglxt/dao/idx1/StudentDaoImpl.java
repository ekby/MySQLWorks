package newjwglxt.jwglxt.dao.idx1;

import newjwglxt.jwglxt.entity.Student;

import java.sql.*;
import java.util.ArrayList;

public class StudentDaoImpl implements Dao_idx1<Student> {
    @Override
    public void Insert(Connection connection, Student student) {
        DatabaseMetaData databaseMetaData;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO student(id, name, gender, sfirstyear, smajor, sclass, scollege, contact, pw) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getGender());
            preparedStatement.setInt(4, student.getSfirstyear());
            preparedStatement.setString(5, student.getSmajor());
            preparedStatement.setInt(6, student.getSclass());
            preparedStatement.setString(7, student.getScollege());
            preparedStatement.setString(8, student.getContact());
            preparedStatement.setString(9, student.getPw());
            databaseMetaData = connection.getMetaData();
            if (preparedStatement.executeUpdate() != 0)
                System.out.println(String.format("%s: \n%s", databaseMetaData.getURL(), preparedStatement));
            else
                System.out.println(String.format("%s: Failed.", databaseMetaData.getURL()));
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void Delete(Connection connection, Student student) {
        DatabaseMetaData databaseMetaData;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM student WHERE id=?");
            preparedStatement.setInt(1, student.getId());
            databaseMetaData = connection.getMetaData();
            if (preparedStatement.executeUpdate() != 0)
                System.out.println(String.format("%s: \n%s", databaseMetaData.getURL(), preparedStatement));
            else
                System.out.println(String.format("%s: Failed.", databaseMetaData.getURL()));
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void Update(Connection connection, Student student) {
        DatabaseMetaData databaseMetaData;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE student SET name=?, gender=?, sfirstyear=?, smajor=?, sclass=?, scollege=?, contact=?, pw=? WHERE id=?");
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getGender());
            preparedStatement.setInt(3, student.getSfirstyear());
            preparedStatement.setString(4, student.getSmajor());
            preparedStatement.setInt(5, student.getSclass());
            preparedStatement.setString(6, student.getScollege());
            preparedStatement.setString(7, student.getContact());
            preparedStatement.setString(8, student.getPw());
            preparedStatement.setInt(9, student.getId());
            databaseMetaData = connection.getMetaData();
            if (preparedStatement.executeUpdate() != 0)
                System.out.println(String.format("%s: \n%s", databaseMetaData.getURL(), preparedStatement));
            else
                System.out.println(String.format("%s: Failed.", databaseMetaData.getURL()));
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ArrayList<Student> SelectById(Connection connection, int id) {
        DatabaseMetaData databaseMetaData;
        ArrayList<Student> arrayList;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM student WHERE id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  // 为了下文让指针能移动
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            arrayList = new ArrayList<>();
            databaseMetaData = connection.getMetaData();
            if (resultSet.next())
                System.out.println(String.format("%s: \n%s", databaseMetaData.getURL(), preparedStatement));
            else
                System.out.println(String.format("%s: Failed.", databaseMetaData.getURL()));
            resultSet.beforeFirst();
            while (resultSet.next()) {
                arrayList.add(new Student(resultSet.getString("name"), resultSet.getInt("id"), resultSet.getString("pw"),
                        resultSet.getString("gender"), resultSet.getString("contact"), resultSet.getInt("sfirstyear"),
                        resultSet.getInt("sclass"), resultSet.getString("smajor"), resultSet.getString("scollege")));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }

    @Override
    public ArrayList<Student> SelectByIdRough(Connection connection, int id) {
        DatabaseMetaData databaseMetaData;
        ArrayList<Student> arrayList;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM student WHERE id LIKE ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  // 为了下文让指针能移动
            preparedStatement.setString(1, "%" + id + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            arrayList = new ArrayList<>();
            databaseMetaData = connection.getMetaData();
            if (resultSet.next())
                System.out.println(String.format("%s: \n%s", databaseMetaData.getURL(), preparedStatement));
            else
                System.out.println(String.format("%s: Failed.", databaseMetaData.getURL()));
            resultSet.beforeFirst();
            while (resultSet.next()) {
                arrayList.add(new Student(resultSet.getString("name"), resultSet.getInt("id"), resultSet.getString("pw"),
                        resultSet.getString("gender"), resultSet.getString("contact"), resultSet.getInt("sfirstyear"),
                        resultSet.getInt("sclass"), resultSet.getString("smajor"), resultSet.getString("scollege")));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }

    @Override
    public ArrayList<Student> SelectByName(Connection connection, String name) {
        DatabaseMetaData databaseMetaData;
        ArrayList<Student> arrayList;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM student WHERE name=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  // 为了下文让指针能移动
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            arrayList = new ArrayList<>();
            databaseMetaData = connection.getMetaData();
            if (resultSet.next())
                System.out.println(String.format("%s: \n%s", databaseMetaData.getURL(), preparedStatement));
            else
                System.out.println(String.format("%s: Failed.", databaseMetaData.getURL()));
            resultSet.beforeFirst();
            while (resultSet.next()) {
                arrayList.add(new Student(resultSet.getString("name"), resultSet.getInt("id"), resultSet.getString("pw"),
                        resultSet.getString("gender"), resultSet.getString("contact"), resultSet.getInt("sfirstyear"),
                        resultSet.getInt("sclass"), resultSet.getString("smajor"), resultSet.getString("scollege")));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }

    @Override
    public ArrayList<Student> SelectByNameRough(Connection connection, String name) {
        DatabaseMetaData databaseMetaData;
        ArrayList<Student> arrayList;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM student WHERE name LIKE ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  // 为了下文让指针能移动
            preparedStatement.setString(1, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            arrayList = new ArrayList<>();
            databaseMetaData = connection.getMetaData();
            if (resultSet.next())
                System.out.println(String.format("%s: \n%s", databaseMetaData.getURL(), preparedStatement));
            else
                System.out.println(String.format("%s: Failed.", databaseMetaData.getURL()));
            resultSet.beforeFirst();
            while (resultSet.next()) {
                arrayList.add(new Student(resultSet.getString("name"), resultSet.getInt("id"), resultSet.getString("pw"),
                        resultSet.getString("gender"), resultSet.getString("contact"), resultSet.getInt("sfirstyear"),
                        resultSet.getInt("sclass"), resultSet.getString("smajor"), resultSet.getString("scollege")));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }

    @Override
    public ArrayList<Student> Select(Connection connection) {
        DatabaseMetaData databaseMetaData;
        ArrayList<Student> arrayList;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM student", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  // 为了下文让指针能移动
            ResultSet resultSet = preparedStatement.executeQuery();
            arrayList = new ArrayList<>();
            databaseMetaData = connection.getMetaData();
            if (resultSet.next())
                System.out.println(String.format("%s: \n%s", databaseMetaData.getURL(), preparedStatement));
            else
                System.out.println(String.format("%s: Failed.", databaseMetaData.getURL()));
            resultSet.beforeFirst();
            while (resultSet.next()) {
                arrayList.add(new Student(resultSet.getString("name"), resultSet.getInt("id"), resultSet.getString("pw"),
                        resultSet.getString("gender"), resultSet.getString("contact"), resultSet.getInt("sfirstyear"),
                        resultSet.getInt("sclass"), resultSet.getString("smajor"), resultSet.getString("scollege")));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }

    public ArrayList<Student> SelectByFirstYearRough(Connection connection, String fy) {
        DatabaseMetaData databaseMetaData;
        ArrayList<Student> arrayList;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM student WHERE student.sfirstyear LIKE ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  // 为了下文让指针能移动
            preparedStatement.setString(1, "%" + fy + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            arrayList = new ArrayList<>();
            databaseMetaData = connection.getMetaData();
            if (resultSet.next())
                System.out.println(String.format("%s: \n%s", databaseMetaData.getURL(), preparedStatement));
            else
                System.out.println(String.format("%s: Failed.", databaseMetaData.getURL()));
            resultSet.beforeFirst();
            while (resultSet.next()) {
                arrayList.add(new Student(resultSet.getString("name"), resultSet.getInt("id"), resultSet.getString("pw"),
                        resultSet.getString("gender"), resultSet.getString("contact"), resultSet.getInt("sfirstyear"),
                        resultSet.getInt("sclass"), resultSet.getString("smajor"), resultSet.getString("scollege")));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }

}
