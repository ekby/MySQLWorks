package newjwglxt.jwglxt.dao.idx1;

import newjwglxt.jwglxt.entity.Jwadmin;

import java.sql.*;
import java.util.ArrayList;

public class JwadminDaoImpl implements Dao_idx1<Jwadmin> {
    @Override
    public void Insert(Connection connection, Jwadmin jwadmin) {
        DatabaseMetaData databaseMetaData;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO jwadmin VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, jwadmin.getId());
            preparedStatement.setString(2, jwadmin.getName());
            preparedStatement.setString(3, jwadmin.getGender());
            preparedStatement.setString(4, jwadmin.getPw());
            preparedStatement.setString(5, jwadmin.getContact());
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
    public void Delete(Connection connection, Jwadmin jwadmin) {
        DatabaseMetaData databaseMetaData;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM jwadmin WHERE id=?");
            preparedStatement.setInt(1, jwadmin.getId());
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
    public void Update(Connection connection, Jwadmin t) {
        DatabaseMetaData databaseMetaData;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE jwadmin SET name=?, gender=?, pw=?, contact=? WHERE id=?");
            preparedStatement.setString(1, t.getName());
            preparedStatement.setString(2, t.getGender());
            preparedStatement.setString(3, t.getContact());
            preparedStatement.setString(4, t.getPw());
            preparedStatement.setInt(5, t.getId());
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
    public ArrayList<Jwadmin> SelectById(Connection connection, int id) {
        DatabaseMetaData databaseMetaData;
        ArrayList<Jwadmin> arrayList;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM jwadmin WHERE id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  // 为了下文让指针能移动
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
                arrayList.add(new Jwadmin(resultSet.getString("name"), resultSet.getInt("id"), resultSet.getString("pw"),
                        resultSet.getString("gender"), resultSet.getString("contact")));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }

    @Override
    public ArrayList<Jwadmin> SelectByIdRough(Connection connection, int id) {
        DatabaseMetaData databaseMetaData;
        ArrayList<Jwadmin> arrayList;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM jwadmin WHERE id LIKE ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  // 为了下文让指针能移动
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
                arrayList.add(new Jwadmin(resultSet.getString("name"), resultSet.getInt("id"), resultSet.getString("pw"),
                        resultSet.getString("gender"), resultSet.getString("contact")));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }

    @Override
    public ArrayList<Jwadmin> SelectByName(Connection connection, String name) {
        DatabaseMetaData databaseMetaData;
        ArrayList<Jwadmin> arrayList;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM jwadmin WHERE name=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  // 为了下文让指针能移动
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
                arrayList.add(new Jwadmin(resultSet.getString("name"), resultSet.getInt("id"), resultSet.getString("pw"),
                        resultSet.getString("gender"), resultSet.getString("contact")));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }

    @Override
    public ArrayList<Jwadmin> SelectByNameRough(Connection connection, String name) {
        DatabaseMetaData databaseMetaData;
        ArrayList<Jwadmin> arrayList;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM jwadmin WHERE name LIKE ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  // 为了下文让指针能移动
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
                arrayList.add(new Jwadmin(resultSet.getString("name"), resultSet.getInt("id"), resultSet.getString("pw"),
                        resultSet.getString("gender"), resultSet.getString("contact")));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }
}
