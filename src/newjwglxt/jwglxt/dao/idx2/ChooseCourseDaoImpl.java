package newjwglxt.jwglxt.dao.idx2;

import newjwglxt.jwglxt.entity.ChooseCourse;

import java.sql.*;
import java.util.ArrayList;

public class ChooseCourseDaoImpl implements Dao_idx2<ChooseCourse> {
    @Override
    public void Insert(Connection connection, ChooseCourse chooseCourse) {
        DatabaseMetaData databaseMetaData;
        PreparedStatement preparedStatement;
        try {
            databaseMetaData = connection.getMetaData();
            preparedStatement = connection.prepareStatement("INSERT INTO choosecourse VALUES(?,?,?,?,?)");
            preparedStatement.setInt(1, chooseCourse.getCcid());
            preparedStatement.setInt(2, chooseCourse.getCccid());
            preparedStatement.setInt(3, chooseCourse.getCcsid());
            preparedStatement.setInt(4, chooseCourse.getCcscore());
            preparedStatement.setInt(5, chooseCourse.getCcgpa());
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
    public void Delete(Connection connection, ChooseCourse chooseCourse) {
        DatabaseMetaData databaseMetaData;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM choosecourse WHERE ccid=?");
            preparedStatement.setInt(1, chooseCourse.getCcid());
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
    public void Update(Connection connection, ChooseCourse t) {
        DatabaseMetaData databaseMetaData;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE choosecourse SET ccsid=?, cccid=?, ccscore=?, ccgpa=? WHERE ccid=?");
            preparedStatement.setInt(1, t.getCcsid());
            preparedStatement.setInt(2, t.getCccid());
            preparedStatement.setInt(3, t.getCcscore());
            preparedStatement.setInt(4, t.getCcgpa());
            preparedStatement.setInt(5, t.getCcid());
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
    public ArrayList<ChooseCourse> SelectBySid(Connection connection, int sid) {
        DatabaseMetaData databaseMetaData;
        ArrayList<ChooseCourse> arrayList;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM choosecourse WHERE ccsid=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  // 为了下文让指针能移动
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
                arrayList.add(new ChooseCourse(resultSet.getInt("ccid"), resultSet.getInt("ccsid"), resultSet.getInt("cccid"),
                        resultSet.getInt("ccscore"), resultSet.getInt("ccgpa")));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }

    @Override
    public ArrayList<ChooseCourse> SelectByCid(Connection connection, int cid) {
        DatabaseMetaData databaseMetaData;
        ArrayList<ChooseCourse> arrayList;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM choosecourse WHERE cccid=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  // 为了下文让指针能移动
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
                arrayList.add(new ChooseCourse(resultSet.getInt("ccid"), resultSet.getInt("ccsid"), resultSet.getInt("cccid"),
                        resultSet.getInt("ccscore"), resultSet.getInt("ccgpa")));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }
}
