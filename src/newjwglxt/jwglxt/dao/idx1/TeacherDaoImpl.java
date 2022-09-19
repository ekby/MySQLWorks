package newjwglxt.jwglxt.dao.idx1;

import newjwglxt.jwglxt.entity.Teacher;

import java.sql.*;
import java.util.ArrayList;

public class TeacherDaoImpl implements Dao_idx1<Teacher> {
    @Override
    public void Insert(Connection connection, Teacher teacher) {
        DatabaseMetaData databaseMetaData;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO teacher VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, teacher.getId());
            preparedStatement.setString(2, teacher.getName());
            preparedStatement.setString(3, teacher.getGender());
            preparedStatement.setInt(4, teacher.getTfirstyear());
            preparedStatement.setString(5, teacher.getTtitle());
            preparedStatement.setString(6, teacher.getTcollege());
            preparedStatement.setString(7, teacher.getContact());
            preparedStatement.setString(8, teacher.getPw());
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
    public void Delete(Connection connection, Teacher teacher) {
        DatabaseMetaData databaseMetaData;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM teacher WHERE id=?");
            preparedStatement.setInt(1, teacher.getId());
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
    public void Update(Connection connection, Teacher t0, Teacher t1) {
        DatabaseMetaData databaseMetaData;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE teacher SET name=?, gender=?, tfirstyear=?, ttitle=?, tcollege=?, contact=?, pw=? WHERE id=?");
            preparedStatement.setString(1, t1.getName());
            preparedStatement.setString(2, t1.getGender());
            preparedStatement.setInt(3, t1.getTfirstyear());
            preparedStatement.setString(4, t1.getTtitle());
            preparedStatement.setString(5, t1.getTcollege());
            preparedStatement.setString(6, t1.getContact());
            preparedStatement.setString(7, t1.getPw());
            preparedStatement.setInt(8, t0.getId());
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
    public ArrayList<Teacher> SelectById(Connection connection, int id) {
        DatabaseMetaData databaseMetaData;
        ArrayList<Teacher> arrayList;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM teacher WHERE id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  // 为了下文让指针能移动
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
                arrayList.add(new Teacher(resultSet.getString("name"), resultSet.getInt("id"), resultSet.getString("pw"),
                        resultSet.getString("gender"), resultSet.getString("contact"), resultSet.getInt("tfirstyear"),
                        resultSet.getString("ttitle"), resultSet.getString("tcollege")));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }

    @Override
    public ArrayList<Teacher> SelectByIdRough(Connection connection, int id) {
        DatabaseMetaData databaseMetaData;
        ArrayList<Teacher> arrayList;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM teacher WHERE id LIKE ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  // 为了下文让指针能移动
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
                arrayList.add(new Teacher(resultSet.getString("name"), resultSet.getInt("id"), resultSet.getString("pw"),
                        resultSet.getString("gender"), resultSet.getString("contact"), resultSet.getInt("tfirstyear"),
                        resultSet.getString("ttitle"), resultSet.getString("tcollege")));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }

    @Override
    public ArrayList<Teacher> SelectByName(Connection connection, String name) {
        DatabaseMetaData databaseMetaData;
        ArrayList<Teacher> arrayList;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM teacher WHERE name=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  // 为了下文让指针能移动
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
                arrayList.add(new Teacher(resultSet.getString("name"), resultSet.getInt("id"), resultSet.getString("pw"),
                        resultSet.getString("gender"), resultSet.getString("contact"), resultSet.getInt("tfirstyear"),
                        resultSet.getString("ttitle"), resultSet.getString("tcollege")));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }

    @Override
    public ArrayList<Teacher> SelectByNameRough(Connection connection, String name) {
        DatabaseMetaData databaseMetaData;
        ArrayList<Teacher> arrayList;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM teacher WHERE name LIKE ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  // 为了下文让指针能移动
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
                arrayList.add(new Teacher(resultSet.getString("name"), resultSet.getInt("id"), resultSet.getString("pw"),
                        resultSet.getString("gender"), resultSet.getString("contact"), resultSet.getInt("tfirstyear"),
                        resultSet.getString("ttitle"), resultSet.getString("tcollege")));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }
}
