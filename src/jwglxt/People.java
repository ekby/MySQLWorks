package jwglxt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class People {
    private String name;
    private String id;
    private String pw;
    private char gender;
    private String contact;

    public People(String name, String id, String pw, char gender, String contact) {
        this.name = name;
        this.id = id;
        this.pw = pw;
        this.gender = gender;
        this.contact = contact;
    }

    public void createPerson(Student student) {

    }

    public void createPerson(Teacher teacher) {

    }

    public void createPerson(Jwadmin jwadmin) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void modifyinfo_name(String new_name, String tableName, String uid) {
        Connection connection;
        try {
            connection = MySQLConnection.getConnection();
            if (!connection.isClosed())
                System.out.println("Connected.");
            else
                System.out.println("Connection Failed.");
            Statement statement = connection.createStatement();
            String sql = "UPDATE ? SET name = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tableName);
            preparedStatement.setString(2, new_name);
            preparedStatement.setString(3, uid);
            if (preparedStatement.executeUpdate() != 0)
                System.out.println("Name modify successfully.");
            else
                System.out.println("Name modify failed.");
            MySQLConnection.close(statement);
            MySQLConnection.close(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void modifyinfo_contact(String new_contact) {
        if (new_contact.length() != 11) {
            System.out.println("联系方式应为11位，联系方式修改为默认联系方式00000000000。");
            this.contact = "00000000000";
        } else {
            for (int i = 0; i < new_contact.length(); i++) {
                if (!Character.isDigit(new_contact.charAt(i)))
                    break;
                System.out.println("联系方式中不能有字符，联系方式修改为默认联系方式00000000000。");
                this.contact = "00000000000";
            }
            System.out.println("修改成功！");
            this.contact = new_contact;
        }
    }
}
