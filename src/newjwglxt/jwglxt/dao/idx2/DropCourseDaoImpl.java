package newjwglxt.jwglxt.dao.idx2;

import newjwglxt.jwglxt.entity.DropCourse;

import java.sql.*;
import java.util.ArrayList;

public class DropCourseDaoImpl implements Dao_idx2<DropCourse> {
    @Override
    public void Insert(Connection connection, DropCourse dropCourse) {
        DatabaseMetaData databaseMetaData;
        PreparedStatement preparedStatement;
        try {
            databaseMetaData = connection.getMetaData();
            preparedStatement = connection.prepareStatement("INSERT INTO dropcourse VALUES(?,?,?,?)");
            preparedStatement.setInt(1, dropCourse.getDcid());
            preparedStatement.setInt(2, dropCourse.getDcsid());
            preparedStatement.setInt(3, dropCourse.getDccid());
            preparedStatement.setInt(4, dropCourse.getDchandle());
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
    public void Delete(Connection connection, DropCourse dropCourse) {
        DatabaseMetaData databaseMetaData;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM dropcourse WHERE dcid=?");
            preparedStatement.setInt(1, dropCourse.getDcid());
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
    public void Update(Connection connection, DropCourse t) {
        DatabaseMetaData databaseMetaData;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE dropcourse SET dcsid=?, dccid=?, dchandle=? WHERE dcid=?");
            preparedStatement.setInt(1, t.getDcsid());
            preparedStatement.setInt(2, t.getDccid());
            preparedStatement.setInt(3, t.getDchandle());
            preparedStatement.setInt(4, t.getDcid());
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
    public ArrayList<DropCourse> SelectBySid(Connection connection, int sid) {
        DatabaseMetaData databaseMetaData;
        ArrayList<DropCourse> arrayList;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM dropcourse WHERE dcsid=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  // 为了下文让指针能移动
            preparedStatement.setInt(1, sid);
            ResultSet resultSet = preparedStatement.executeQuery();
            arrayList = new ArrayList<>();
            databaseMetaData = connection.getMetaData();
            if (resultSet.next())
                System.out.println(String.format("%s: \n%s", databaseMetaData.getURL(), preparedStatement));
            else
                System.out.println(String.format("%s: Failed.", databaseMetaData.getURL()));
            resultSet.beforeFirst();
            while (resultSet.next()) {
                arrayList.add(new DropCourse(resultSet.getInt("dcid"), resultSet.getInt("dcsid"), resultSet.getInt("dccid"),
                        resultSet.getInt("dchandle")));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }

    @Override
    public ArrayList<DropCourse> SelectByCid(Connection connection, int cid) {
        DatabaseMetaData databaseMetaData;
        ArrayList<DropCourse> arrayList;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM dropcourse WHERE dccid=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  // 为了下文让指针能移动
            preparedStatement.setInt(1, cid);
            ResultSet resultSet = preparedStatement.executeQuery();
            arrayList = new ArrayList<>();
            databaseMetaData = connection.getMetaData();
            if (resultSet.next())
                System.out.println(String.format("%s: \n%s", databaseMetaData.getURL(), preparedStatement));
            else
                System.out.println(String.format("%s: Failed.", databaseMetaData.getURL()));
            resultSet.beforeFirst();
            while (resultSet.next()) {
                arrayList.add(new DropCourse(resultSet.getInt("dcid"), resultSet.getInt("dcsid"), resultSet.getInt("dccid"),
                        resultSet.getInt("dchandle")));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }

    @Override
    public ArrayList<DropCourse> Select(Connection connection, int id) {
        DatabaseMetaData databaseMetaData;
        ArrayList<DropCourse> arrayList;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM dropcourse WHERE dcsid = ? ", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  // 为了下文让指针能移动
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
                arrayList.add(new DropCourse(resultSet.getInt("dcid"), resultSet.getInt("dcsid"), resultSet.getInt("dccid"),
                        resultSet.getInt("dchandle")));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }

    @Override
    public ArrayList<DropCourse> Select(Connection connection) {
        DatabaseMetaData databaseMetaData;
        ArrayList<DropCourse> arrayList;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM dropcourse", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  // 为了下文让指针能移动
            ResultSet resultSet = preparedStatement.executeQuery();
            arrayList = new ArrayList<>();
            databaseMetaData = connection.getMetaData();
            if (resultSet.next())
                System.out.println(String.format("%s: \n%s", databaseMetaData.getURL(), preparedStatement));
            else
                System.out.println(String.format("%s: Failed.", databaseMetaData.getURL()));
            resultSet.beforeFirst();
            while (resultSet.next()) {
                arrayList.add(new DropCourse(resultSet.getInt("dcid"), resultSet.getInt("dcsid"), resultSet.getInt("dccid"),
                        resultSet.getInt("dchandle")));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }
}
