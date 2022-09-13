package jwglxt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Student extends People {
    private int sfirstyear, sclass;
    private String smajor, scollege;

    public Student(String id, String name, String pw, char gender, String contact, String scollege, int sfirstyear, String smajor, int sclass) {
        super(name, id, pw, gender, contact);
        this.sfirstyear = sfirstyear;
        this.smajor = smajor;
        this.sclass = sclass;
        this.scollege = scollege;
    }

    public ArrayList<Course> getCourseTable() {
        int sid = Integer.parseInt(this.getId());
        ArrayList<Course> courseArrayList = new ArrayList<>();
        Connection connection;
        try {
            connection = MySQLConnection.getConnection();
            if (!connection.isClosed())
                System.out.println(String.format("Connected to %s.", connection.getCatalog()));
            else
                System.out.println("Connection failed.");
            String sql = "SELECT * FROM course INNER JOIN choosecourse ON course.cid = choosecourse.cccid WHERE choosecourse.ccsid=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(sid));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                courseArrayList.add(new Course(Integer.parseInt(resultSet.getString("cid")), resultSet.getNString("cname"), resultSet.getNString("cdepartment"), Float.parseFloat(resultSet.getString("ccredit")), resultSet.getString("ckclb"), Integer.parseInt(resultSet.getString("cteacherid")), resultSet.getNString("croom"), String.valueOf(resultSet.getString("ctime")), Integer.parseInt(resultSet.getString("csigned_num")), Integer.parseInt(resultSet.getString("cmax_num"))));
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return courseArrayList;
    }

    public static void main(String[] args) {
        Student xhn = new Student("30204", "xhn", "123", 'm', "123", "jjyglxy", 2020, "xinguan", 201102);
        for (Course course : xhn.getCourseTable()) {
            System.out.println(course);
        }
    }
}
