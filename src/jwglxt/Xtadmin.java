package jwglxt;

import java.sql.*;
import java.util.ArrayList;

public class Xtadmin extends People {
    public Xtadmin(String name, String id, String pw, char gender, String contact) {
        super(name, id, pw, gender, contact);
    }

    public Teacher createTeacher(String name, String id, String pw, char gender, String contact, int tfirstyear, String ttitle, String tcollege) {
        Teacher teacher = new Teacher(name, id, pw, gender, contact, tfirstyear, ttitle, tcollege);
        Connection connection;
        try {
            connection = MySQLConnection.getConnection();
            if (!connection.isClosed())
                System.out.println("Connected.");
            else
                System.out.println("Connection Failed.");
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO teacher(id, name, tgender, tfirstyear, ttitle, tcollege, tcontact, tpd)  values(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, String.valueOf(gender));
            preparedStatement.setString(4, String.valueOf(tfirstyear));
            preparedStatement.setString(5, ttitle);
            preparedStatement.setString(6, tcollege);
            preparedStatement.setString(7, contact);
            preparedStatement.setString(8, pw);
            if (preparedStatement.executeUpdate() != 0)
                System.out.println("Insert successfully.");
            else
                System.out.println("Insert failed.");
            MySQLConnection.close(statement);
            MySQLConnection.close(connection);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return teacher;
    }

    public Student createStudent(String name, String id, String pw, char gender, String contact, int sfirstyear, String smajor, int sclass, String college) {
        Student student = new Student(id, name, pw, gender, contact, college, sfirstyear, smajor, sclass);
        Connection connection;
        try {
            connection = MySQLConnection.getConnection();
            if (!connection.isClosed())
                System.out.println("Connected.");
            else
                System.out.println("Connection Failed.");
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO student(id, name, sgender, sfirstyear, smajor, sclass, scontact, spw)  values(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, String.valueOf(gender));
            preparedStatement.setString(4, String.valueOf(sfirstyear));
            preparedStatement.setString(5, smajor);
            preparedStatement.setString(6, String.valueOf(sclass));
            preparedStatement.setString(7, contact);
            preparedStatement.setString(8, pw);
            if (preparedStatement.executeUpdate() != 0)
                System.out.println("Insert successfully.");
            else
                System.out.println("Insert failed.");
            MySQLConnection.close(statement);
            MySQLConnection.close(connection);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return student;
    }

    public Jwadmin createJwadmin(String name, String id, String pw, char gender, String contact) {
        Jwadmin jwadmin = new Jwadmin(name, id, pw, gender, contact);
        Connection connection;
        try {
            connection = MySQLConnection.getConnection();
            if (!connection.isClosed())
                System.out.println("Connected.");
            else
                System.out.println("Connection Failed.");
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO jwadmin(id, name, jgender, jcontact, jpw)  values(?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, String.valueOf(gender));
            preparedStatement.setString(4, contact);
            preparedStatement.setString(5, pw);
            if (preparedStatement.executeUpdate() != 0)
                System.out.println("Insert successfully.");
            else
                System.out.println("Insert failed.");
            MySQLConnection.close(statement);
            MySQLConnection.close(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return jwadmin;
    }

    public void deleteTeacher(String id) {
        Connection connection;
        try {
            connection = MySQLConnection.getConnection();
            if (!connection.isClosed())
                System.out.println("Connected.");
            else
                System.out.println("Connection Failed.");
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM teacher WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            if (preparedStatement.executeUpdate() != 0)
                System.out.println("Delete successfully.");
            else
                System.out.println("Delete failed.");
            MySQLConnection.close(statement);
            MySQLConnection.close(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteStudent(String id) {
        Connection connection;
        try {
            connection = MySQLConnection.getConnection();
            if (!connection.isClosed())
                System.out.println("Connected.");
            else
                System.out.println("Connection Failed.");
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM student WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            if (preparedStatement.executeUpdate() != 0)
                System.out.println("Delete successfully.");
            else
                System.out.println("Delete failed.");
            MySQLConnection.close(statement);
            MySQLConnection.close(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteJwadmin(String id) {
        Connection connection;
        try {
            connection = MySQLConnection.getConnection();
            if (!connection.isClosed())
                System.out.println("Connected.");
            else
                System.out.println("Connection Failed.");
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM jwadmin WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            if (preparedStatement.executeUpdate() != 0)
                System.out.println("Delete successfully.");
            else
                System.out.println("Delete failed.");
            MySQLConnection.close(statement);
            MySQLConnection.close(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<String> selectTeacher(String id) {
        ArrayList<String> arrayList = new ArrayList<>();
        Connection connection;
        try {
            connection = MySQLConnection.getConnection();
            if (!connection.isClosed())
                System.out.println("Connected.");
            else
                System.out.println("Connection Failed.");
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM teacher WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(resultSet.getString("tid").trim());
                arrayList.add(resultSet.getString("tname").trim());
                arrayList.add(resultSet.getString("tgender").trim());
                arrayList.add(resultSet.getString("tfirstyear").trim());
                arrayList.add(resultSet.getString("ttitle").trim());
            }
            MySQLConnection.close(resultSet);
            MySQLConnection.close(statement);
            MySQLConnection.close(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }

}
