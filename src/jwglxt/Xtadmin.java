package jwglxt;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

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
            String sql = "INSERT INTO teacher(id, name, gender, tfirstyear, ttitle, tcollege, contact, pw)  values(?, ?, ?, ?, ?, ?, ?, ?)";
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
            String sql = "INSERT INTO student(id, name, gender, sfirstyear, smajor, sclass, contact, pw)  values(?, ?, ?, ?, ?, ?, ?, ?)";
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
            String sql = "INSERT INTO jwadmin(id, name, gender, contact, pw)  values(?, ?, ?, ?, ?)";
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

    public Course createCourse(String cname, String cdepartment, String ccredit, String ckclb, String cteacherid, String croom, int[] ctime, String csigned_num, String cmax_num) {
        Course course = new Course(0, cname, cdepartment, Float.parseFloat(ccredit), ckclb, Integer.parseInt(cteacherid), croom, ctime, Integer.parseInt(csigned_num), Integer.parseInt(cmax_num));
        Connection connection;
        try {
            connection = MySQLConnection.getConnection();
            if (!connection.isClosed())
                System.out.println("Connected.");
            else
                System.out.println("Connection Failed.");
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO course(cid, cname, cdepartment, ccredit, ckclb, cteacherid, croom, ctime, csigned_num, cmax_num) values(0, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cname);
            preparedStatement.setString(2, cdepartment);
            preparedStatement.setString(3, ccredit);
            preparedStatement.setString(4, ckclb);
            preparedStatement.setString(5, cteacherid);
            preparedStatement.setString(6, croom);
            preparedStatement.setString(7, Arrays.toString(ctime));
            preparedStatement.setString(8, csigned_num);
            preparedStatement.setString(9, cmax_num);
            if (preparedStatement.executeUpdate() != 0)
                System.out.println("Insert successfully.");
            else
                System.out.println("Insert failed.");
            MySQLConnection.close(statement);
            MySQLConnection.close(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return course;
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

    public void deleteCourse(String id) {
        Connection connection;
        try {
            connection = MySQLConnection.getConnection();
            if (!connection.isClosed())
                System.out.println("Connected.");
            else
                System.out.println("Connection Failed.");
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM course WHERE cid=?";
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
                System.out.println("Connection failed.");
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
                arrayList.add(resultSet.getString("tcollege").trim());
                arrayList.add(resultSet.getString("tcontact").trim());
            }
            MySQLConnection.close(resultSet);
            MySQLConnection.close(statement);
            MySQLConnection.close(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }

    public ArrayList<String> selectStudent(String id) {
        ArrayList<String> arrayList = new ArrayList<>();
        Connection connection;
        try {
            connection = MySQLConnection.getConnection();
            if (!connection.isClosed())
                System.out.println("Connected.");
            else
                System.out.println("Connection failed.");
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM student WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(resultSet.getString("sid").trim());
                arrayList.add(resultSet.getString("sname").trim());
                arrayList.add(resultSet.getString("sgender").trim());
                arrayList.add(resultSet.getString("sfirstyear").trim());
                arrayList.add(resultSet.getString("smajor").trim());
                arrayList.add(resultSet.getString("sclass").trim());
                arrayList.add(resultSet.getString("scollege").trim());
                arrayList.add(resultSet.getString("scontact").trim());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }

    public ArrayList<String> selectJwadmin(String id) {
        ArrayList<String> arrayList = new ArrayList<>();
        Connection connection;
        try {
            connection = MySQLConnection.getConnection();
            if (!connection.isClosed())
                System.out.println("Connected.");
            else
                System.out.println("Connection failed.");
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM jwadmin WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(resultSet.getString("jid").trim());
                arrayList.add(resultSet.getString("jname").trim());
                arrayList.add(resultSet.getString("jgender").trim());
                arrayList.add(resultSet.getString("jcontact").trim());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }

    public ArrayList<String> selectCourse(String id) {
        ArrayList<String> arrayList = new ArrayList<>();
        Connection connection;
        try {
            connection = MySQLConnection.getConnection();
            if (!connection.isClosed())
                System.out.println("Connected.");
            else
                System.out.println("Connection failed.");
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM course WHERE cid=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                arrayList.add(resultSet.getString("cid").trim());
                arrayList.add(resultSet.getString("cname").trim());
                arrayList.add(resultSet.getString("cdepartment").trim());
                arrayList.add(resultSet.getString("ccredit").trim());
                arrayList.add(resultSet.getString("ckclb").trim());
                arrayList.add(resultSet.getString("cteacherid").trim());
                arrayList.add(resultSet.getString("croom").trim());
                arrayList.add(resultSet.getString("ctime").trim());
                arrayList.add(resultSet.getString("csigned_num").trim());
                arrayList.add(resultSet.getString("cmax_num").trim());

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayList;

    }

    public void modifyCourse_cname(String id, String content) {
        Connection connection;
        try {
            connection = MySQLConnection.getConnection();
            if (!connection.isClosed())
                System.out.println("Connected.");
            else
                System.out.println("Connection failed.");
            Statement statement = connection.createStatement();
            String sql = "UPDATE course SET cname = ? WHERE cid=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, content);
            preparedStatement.setString(2, id);
            if (preparedStatement.executeUpdate() != 0)
                System.out.println("Update successfully.");
            else
                System.out.println("Update failed.");
            MySQLConnection.close(statement);
            MySQLConnection.close(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void modifyCourse_cdepartment(String id, String content) {
        Connection connection;
        try {
            connection = MySQLConnection.getConnection();
            if (!connection.isClosed())
                System.out.println("Connected.");
            else
                System.out.println("Connection failed.");
            Statement statement = connection.createStatement();
            String sql = "UPDATE course SET cdepartment = ? WHERE cid=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, content);
            preparedStatement.setString(2, id);
            if (preparedStatement.executeUpdate() != 0)
                System.out.println("Update successfully.");
            else
                System.out.println("Update failed.");
            MySQLConnection.close(statement);
            MySQLConnection.close(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void modifyCourse_ccredit(String id, String content) {
        Connection connection;
        try {
            String column = "";
            connection = MySQLConnection.getConnection();
            if (!connection.isClosed())
                System.out.println("Connected.");
            else
                System.out.println("Connection failed.");
            Statement statement = connection.createStatement();
            String sql = "UPDATE course SET ccredit = ? WHERE cid=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, content);
            preparedStatement.setString(2, id);
            if (preparedStatement.executeUpdate() != 0)
                System.out.println("Update successfully.");
            else
                System.out.println("Update failed.");
            MySQLConnection.close(statement);
            MySQLConnection.close(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void modifyCourse_ckclb(String id, String content) {
        Connection connection;
        try {
            String column = "";
            connection = MySQLConnection.getConnection();
            if (!connection.isClosed())
                System.out.println("Connected.");
            else
                System.out.println("Connection failed.");
            Statement statement = connection.createStatement();
            String sql = "UPDATE course SET ckclb = ? WHERE cid=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, content);
            preparedStatement.setString(2, id);
            if (preparedStatement.executeUpdate() != 0)
                System.out.println("Update successfully.");
            else
                System.out.println("Update failed.");
            MySQLConnection.close(statement);
            MySQLConnection.close(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void modifyCourse_cteacherid(String id, String content) {
        Connection connection;
        try {
            String column = "";
            connection = MySQLConnection.getConnection();
            if (!connection.isClosed())
                System.out.println("Connected.");
            else
                System.out.println("Connection failed.");
            Statement statement = connection.createStatement();
            String sql = "UPDATE course SET cteacherid = ? WHERE cid=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, content);
            preparedStatement.setString(2, id);
            if (preparedStatement.executeUpdate() != 0)
                System.out.println("Update successfully.");
            else
                System.out.println("Update failed.");
            MySQLConnection.close(statement);
            MySQLConnection.close(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void modifyCourse_croom(String id, String content) {
        Connection connection;
        try {
            String column = "";
            connection = MySQLConnection.getConnection();
            if (!connection.isClosed())
                System.out.println("Connected.");
            else
                System.out.println("Connection failed.");
            Statement statement = connection.createStatement();
            String sql = "UPDATE course SET croom = ? WHERE cid=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, content);
            preparedStatement.setString(2, id);
            if (preparedStatement.executeUpdate() != 0)
                System.out.println("Update successfully.");
            else
                System.out.println("Update failed.");
            MySQLConnection.close(statement);
            MySQLConnection.close(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void modifyCourse_ctime(String id, String content) {
        Connection connection;
        try {
            String column = "";
            connection = MySQLConnection.getConnection();
            if (!connection.isClosed())
                System.out.println("Connected.");
            else
                System.out.println("Connection failed.");
            Statement statement = connection.createStatement();
            String sql = "UPDATE course SET ctime = ? WHERE cid=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, content);
            preparedStatement.setString(2, id);
            if (preparedStatement.executeUpdate() != 0)
                System.out.println("Update successfully.");
            else
                System.out.println("Update failed.");
            MySQLConnection.close(statement);
            MySQLConnection.close(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void modifyCourse_csigned_num(String id, String content) {
        Connection connection;
        try {
            String column = "";
            connection = MySQLConnection.getConnection();
            if (!connection.isClosed())
                System.out.println("Connected.");
            else
                System.out.println("Connection failed.");
            Statement statement = connection.createStatement();
            String sql = "UPDATE course SET csigned_num = ? WHERE cid=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, content);
            preparedStatement.setString(2, id);
            if (preparedStatement.executeUpdate() != 0)
                System.out.println("Update successfully.");
            else
                System.out.println("Update failed.");
            MySQLConnection.close(statement);
            MySQLConnection.close(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void modifyCourse_cmax_num(String id, String content) {
        Connection connection;
        try {
            String column = "";
            connection = MySQLConnection.getConnection();
            if (!connection.isClosed())
                System.out.println("Connected.");
            else
                System.out.println("Connection failed.");
            Statement statement = connection.createStatement();
            String sql = "UPDATE course SET cmax_num = ? WHERE cid=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, content);
            preparedStatement.setString(2, id);
            if (preparedStatement.executeUpdate() != 0)
                System.out.println("Update successfully.");
            else
                System.out.println("Update failed.");
            MySQLConnection.close(statement);
            MySQLConnection.close(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
