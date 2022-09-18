package newjwglxt.jwglxt.concrete;

public abstract class People {
    private String name;
    private int id;
    private String pw;
    private String gender;
    private String contact;

    public People(String name, int id, String pw, String gender, String contact) {
        this.name = name;
        this.id = id;
        this.pw = pw;
        this.gender = gender;
        this.contact = contact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

//    public void modifyinfo_name(Connection connection, String tableName, String uid, String new_name) {
//        try {
//            String sql = String.format("UPDATE %s SET name = ? WHERE id = ?", tableName);
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, new_name);
//            preparedStatement.setString(2, uid);
//            if (preparedStatement.executeUpdate() != 0)
//                System.out.println("Conduct successfully.");
//            else
//                System.out.println("Conduct failed.");
//            preparedStatement.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void modifyinfo_contact(Connection connection, String tableName, String uid, String new_contact) {
//        try {
//            String sql = String.format("UPDATE %s SET contact = ? WHERE id = ?", tableName);
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            // 先判断是否为11位，不是直接滚蛋
//            if (new_contact.length() != 11) {
//                System.out.println("修改失败，\n联系方式应为11位，修改为默认联系方式00000000000。");
//                preparedStatement.setString(1, "00000000000");
//                preparedStatement.setString(2, uid);
//            } else {
//                //如果是11位，遍历字符串，看有没有字符不是数字，就直接滚蛋
//                for (int i = 0; i < new_contact.length(); i++) {
//                    if (!Character.isDigit(new_contact.charAt(i))) {
//                        System.out.println("联系方式中不能有字符，联系方式修改为默认联系方式00000000000。");
//                        preparedStatement.setString(1, "00000000000");
//                        preparedStatement.setString(2, uid);
//                        break;
//                    }
//                    //如果遍历完了，i+1正好是length，证明没有不是数字的字符，成功
//                    if (i + 1 == new_contact.length()) {
//                        System.out.println("联系方式修改成功！");
//                        preparedStatement.setString(1, new_contact);
//                        preparedStatement.setString(2, uid);
//                    }
//                }
//            }
//            if (preparedStatement.executeUpdate() != 0)
//                System.out.println("Conduct successfully.");
//            else
//                System.out.println("Conduct failed.");
//            preparedStatement.close();
//            connection.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void modifyinfo_gender(Connection connection, String tableName, String uid, char new_gender) {
//        try {
//            String sql = String.format("UPDATE %s SET gender = ? WHERE id = ?", tableName);
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, String.valueOf(new_gender));
//            preparedStatement.setString(2, uid);
//            if (preparedStatement.executeUpdate() != 0)
//                System.out.println("Conduct successfully.");
//            else
//                System.out.println("Conduct failed.");
//            preparedStatement.close();
//            connection.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void modifyinfo_password(Connection connection, String tableName, String uid, String new_password) {
//        try {
//            String sql = String.format("UPDATE %s SET pw = ? WHERE id = ?", tableName);
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            if(new_password.length() != 6){
//                System.out.println("密码必须为6位数字、字母或其他字符。");
//                preparedStatement.setString(1, "123456");
//                preparedStatement.setString(2, uid);
//            } else {
//                System.out.println("修改密码成功。");
//                preparedStatement.setString(1, new_password);
//                preparedStatement.setString(2, uid);
//            }
//            if (preparedStatement.executeUpdate() != 0)
//                System.out.println("Conduct successfully.");
//            else
//                System.out.println("Conduct failed.");
//            preparedStatement.close();
//            connection.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }


    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", pw='" + pw + '\'' +
                ", gender='" + gender + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
