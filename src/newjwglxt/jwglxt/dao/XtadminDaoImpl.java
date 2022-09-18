package newjwglxt.jwglxt.dao;

import newjwglxt.jwglxt.concrete.Xtadmin;

import java.sql.*;
import java.util.ArrayList;

public class XtadminDaoImpl implements BaseDao<Xtadmin> {
    // TODO xtadmindao

    @Override
    public void Insert(Connection connection, Xtadmin xtadmin) {
        DatabaseMetaData databaseMetaData;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO xtadmin VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setInt(1, xtadmin.getId());
            preparedStatement.setString(2, xtadmin.getName());
            preparedStatement.setString(3, xtadmin.getGender());
            preparedStatement.setString(4, xtadmin.getPw());
            preparedStatement.setString(5, xtadmin.getContact());
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
    public void Delete(Connection connection, Xtadmin xtadmin) {
        DatabaseMetaData databaseMetaData;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM xtadmin WHERE id=?");
            preparedStatement.setInt(1, xtadmin.getId());
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
    public void Update(Connection connection, Xtadmin t0, Xtadmin t1) {
        DatabaseMetaData databaseMetaData;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE xtadmin SET name=?, gender=?, pw=?, contact=? WHERE id=?");
            preparedStatement.setString(1, t1.getName());
            preparedStatement.setString(2, t1.getGender());
            preparedStatement.setString(3, t1.getContact());
            preparedStatement.setString(4, t1.getPw());
            preparedStatement.setInt(5, t0.getId());
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
    public ArrayList<Xtadmin> SelectById(Connection connection, int id) {
        DatabaseMetaData databaseMetaData;
        ArrayList<Xtadmin> arrayList;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM xtadmin WHERE id=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  // 为了下文让指针能移动
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
                arrayList.add(new Xtadmin(resultSet.getString("name"), resultSet.getInt("id"), resultSet.getString("pw"),
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
    public ArrayList<Xtadmin> SelectByIdRough(Connection connection, int id) {
        DatabaseMetaData databaseMetaData;
        ArrayList<Xtadmin> arrayList;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM xtadmin WHERE id LIKE ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  // 为了下文让指针能移动
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
                arrayList.add(new Xtadmin(resultSet.getString("name"), resultSet.getInt("id"), resultSet.getString("pw"),
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
    public ArrayList<Xtadmin> SelectByName(Connection connection, String name) {
        DatabaseMetaData databaseMetaData;
        ArrayList<Xtadmin> arrayList;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM xtadmin WHERE name=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  // 为了下文让指针能移动
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
                arrayList.add(new Xtadmin(resultSet.getString("name"), resultSet.getInt("id"), resultSet.getString("pw"),
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
    public ArrayList<Xtadmin> SelectByNameRough(Connection connection, String name) {
        DatabaseMetaData databaseMetaData;
        ArrayList<Xtadmin> arrayList;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM xtadmin WHERE name LIKE ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  // 为了下文让指针能移动
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
                arrayList.add(new Xtadmin(resultSet.getString("name"), resultSet.getInt("id"), resultSet.getString("pw"),
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
