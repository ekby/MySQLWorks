package jwglxt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

//    public String getGender() {
//        return gender;
//    }

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
            String sql = String.format("UPDATE %s SET name = ? WHERE id = ?", tableName);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, new_name);
            preparedStatement.setString(2, uid);
            if (preparedStatement.executeUpdate() != 0)
                System.out.println("Conduct successfully.");
            else
                System.out.println("Conduct failed.");
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void modifyinfo_contact(String new_contact, String tableName, String uid) {
        Connection connection;
        try {
            connection = MySQLConnection.getConnection();
            if (!connection.isClosed())
                System.out.println("Connected.");
            else
                System.out.println("Connection Failed.");
            String sql = String.format("UPDATE %s SET contact = ? WHERE id = ?", tableName);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // 先判断是否为11位，不是直接滚蛋
            if (new_contact.length() != 11) {
                System.out.println("修改失败，\n联系方式应为11位，修改为默认联系方式00000000000。");
                preparedStatement.setString(1, "00000000000");
                preparedStatement.setString(2, uid);
            } else {
                //如果是11位，遍历字符串，看有没有字符不是数字，就直接滚蛋
                for (int i = 0; i < new_contact.length(); i++) {
                    if (!Character.isDigit(new_contact.charAt(i))) {
                        System.out.println("联系方式中不能有字符，联系方式修改为默认联系方式00000000000。");
                        preparedStatement.setString(1, "00000000000");
                        preparedStatement.setString(2, uid);
                        break;
                    }
                    //如果遍历完了，i+1正好是length，证明没有不是数字的字符，成功
                    if (i + 1 == new_contact.length()) {
                        System.out.println("联系方式修改成功！");
                        preparedStatement.setString(1, new_contact);
                        preparedStatement.setString(2, uid);
                    }
                }
            }

            if (preparedStatement.executeUpdate() != 0)
                System.out.println("Conduct successfully.");
            else
                System.out.println("Conduct failed.");
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void modifyinfo_gender(char new_gender, String tableName, String uid) {
        Connection connection;
        try {
            connection = MySQLConnection.getConnection();
            if (!connection.isClosed())
                System.out.println("Connected.");
            else
                System.out.println("Connection Failed.");
            String sql = String.format("UPDATE %s SET gender = ? WHERE id = ?", tableName);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(new_gender));
            preparedStatement.setString(2, uid);
            if (preparedStatement.executeUpdate() != 0)
                System.out.println("Conduct successfully.");
            else
                System.out.println("Conduct failed.");
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void modifyinfo_password(String new_password, String tableName, String uid) {
        Connection connection;
        try {
            connection = MySQLConnection.getConnection();
            if (!connection.isClosed())
                System.out.println("Connected.");
            else
                System.out.println("Connection Failed.");
            String sql = String.format("UPDATE %s SET pw = ? WHERE id = ?", tableName);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            if(new_password.length() != 6){
                System.out.println("密码必须为6位数字、字母或其他字符。");
                preparedStatement.setString(1, "123456");
                preparedStatement.setString(2, uid);
            } else {
                System.out.println("修改密码成功。");
                preparedStatement.setString(1, new_password);
                preparedStatement.setString(2, uid);
            }

            if (preparedStatement.executeUpdate() != 0)
                System.out.println("Conduct successfully.");
            else
                System.out.println("Conduct failed.");
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
