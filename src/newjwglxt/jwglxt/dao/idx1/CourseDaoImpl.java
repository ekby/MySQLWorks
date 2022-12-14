package newjwglxt.jwglxt.dao.idx1;

import newjwglxt.jwglxt.entity.Course;

import java.sql.*;
import java.util.ArrayList;

public class CourseDaoImpl implements Dao_idx1<Course> {
    @Override
    public void Insert(Connection connection, Course course) {
        DatabaseMetaData databaseMetaData;
        PreparedStatement preparedStatement;
        try {
            databaseMetaData = connection.getMetaData();
            preparedStatement = connection.prepareStatement("INSERT INTO course VALUES(?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, course.getCid());
            preparedStatement.setString(2, course.getCname());
            preparedStatement.setString(3, course.getCdepartment());
            preparedStatement.setDouble(4, course.getCcredit());
            preparedStatement.setString(5, course.getCkclb());
            preparedStatement.setInt(6, course.getCteacherid());
            preparedStatement.setString(7, course.getCroom());
            preparedStatement.setString(8, course.getCtime());
            preparedStatement.setInt(9, course.getCsigned_num());
            preparedStatement.setInt(10, course.getCmax_num());
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
    public void Delete(Connection connection, Course course) {
        DatabaseMetaData databaseMetaData;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM course WHERE cid=?");
            preparedStatement.setInt(1, course.getCid());
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
    public void Update(Connection connection, Course t) {
        DatabaseMetaData databaseMetaData;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE course SET cname=?, cdepartment=?, ccredit=?, ckclb=?, cteacherid=?, croom=?, ctime=?, csigned_num=?, cmax_num=? WHERE cid=?");
            preparedStatement.setString(1, t.getCname());
            preparedStatement.setString(2, t.getCdepartment());
            preparedStatement.setDouble(3, t.getCcredit());
            preparedStatement.setString(4, t.getCkclb());
            preparedStatement.setInt(5, t.getCteacherid());
            preparedStatement.setString(6, t.getCroom());
            preparedStatement.setString(7, t.getCtime());
            preparedStatement.setInt(8, t.getCsigned_num());
            preparedStatement.setInt(9, t.getCmax_num());
            preparedStatement.setInt(10, t.getCid());
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
    public ArrayList<Course> SelectById(Connection connection, int id) {
        DatabaseMetaData databaseMetaData;
        ArrayList<Course> arrayList;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM course WHERE cid=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  // ??????????????????????????????
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
                arrayList.add(new Course(resultSet.getInt("cid"), resultSet.getString("cname"), resultSet.getString("cdepartment"),
                        resultSet.getDouble("ccredit"), resultSet.getString("ckclb"), resultSet.getInt("cteacherid"),
                        resultSet.getString("croom"), resultSet.getString("ctime"), resultSet.getInt("csigned_num"), resultSet.getInt("cmax_num")));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }

    @Override
    public ArrayList<Course> SelectByIdRough(Connection connection, int id) {
        DatabaseMetaData databaseMetaData;
        ArrayList<Course> arrayList;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM course WHERE cid LIKE ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  // ??????????????????????????????
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
                arrayList.add(new Course(resultSet.getInt("cid"), resultSet.getString("cname"), resultSet.getString("cdepartment"),
                        resultSet.getDouble("ccredit"), resultSet.getString("ckclb"), resultSet.getInt("cteacherid"),
                        resultSet.getString("croom"), resultSet.getString("ctime"), resultSet.getInt("csigned_num"), resultSet.getInt("cmax_num")));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }

    @Override
    public ArrayList<Course> SelectByName(Connection connection, String name) {
        DatabaseMetaData databaseMetaData;
        ArrayList<Course> arrayList;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM course WHERE cname=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  // ??????????????????????????????
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
                arrayList.add(new Course(resultSet.getInt("cid"), resultSet.getString("cname"), resultSet.getString("cdepartment"),
                        resultSet.getDouble("ccredit"), resultSet.getString("ckclb"), resultSet.getInt("cteacherid"),
                        resultSet.getString("croom"), resultSet.getString("ctime"), resultSet.getInt("csigned_num"), resultSet.getInt("cmax_num")));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("?????????dao");
        System.out.println(arrayList);
        return arrayList;
    }

    @Override
    public ArrayList<Course> SelectByNameRough(Connection connection, String name) {
        DatabaseMetaData databaseMetaData;
        ArrayList<Course> arrayList;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM course WHERE cname LIKE ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  // ??????????????????????????????
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
                arrayList.add(new Course(resultSet.getInt("cid"), resultSet.getString("cname"), resultSet.getString("cdepartment"),
                        resultSet.getDouble("ccredit"), resultSet.getString("ckclb"), resultSet.getInt("cteacherid"),
                        resultSet.getString("croom"), resultSet.getString("ctime"), resultSet.getInt("csigned_num"), resultSet.getInt("cmax_num")));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("?????????dao");
        System.out.println(arrayList);
        return arrayList;
    }

    @Override
    public ArrayList<Course> Select(Connection connection) {
        DatabaseMetaData databaseMetaData;
        ArrayList<Course> arrayList;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM course", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  // ??????????????????????????????
            ResultSet resultSet = preparedStatement.executeQuery();
            arrayList = new ArrayList<>();
            databaseMetaData = connection.getMetaData();
            if (resultSet.next())
                System.out.println(String.format("%s: \n%s", databaseMetaData.getURL(), preparedStatement));
            else
                System.out.println(String.format("%s: Failed.", databaseMetaData.getURL()));
            resultSet.beforeFirst();
            while (resultSet.next()) {
                arrayList.add(new Course(resultSet.getInt("cid"), resultSet.getString("cname"), resultSet.getString("cdepartment"),
                        resultSet.getDouble("ccredit"), resultSet.getString("ckclb"), resultSet.getInt("cteacherid"),
                        resultSet.getString("croom"), resultSet.getString("ctime"), resultSet.getInt("csigned_num"), resultSet.getInt("cmax_num")));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }

    public ArrayList<Course> SelectByTeacherID(Connection connection, int tid) {
        DatabaseMetaData databaseMetaData;
        ArrayList<Course> arrayList;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM course WHERE cteacherid=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  // ??????????????????????????????
            preparedStatement.setInt(1, tid);
            ResultSet resultSet = preparedStatement.executeQuery();
            arrayList = new ArrayList<>();
            databaseMetaData = connection.getMetaData();
            if (resultSet.next())
                System.out.println(String.format("%s: \n%s", databaseMetaData.getURL(), preparedStatement));
            else
                System.out.println(String.format("%s: Failed.", databaseMetaData.getURL()));
            resultSet.beforeFirst();
            while (resultSet.next()) {
                arrayList.add(new Course(resultSet.getInt("cid"), resultSet.getString("cname"), resultSet.getString("cdepartment"),
                        resultSet.getDouble("ccredit"), resultSet.getString("ckclb"), resultSet.getInt("cteacherid"),
                        resultSet.getString("croom"), resultSet.getString("ctime"), resultSet.getInt("csigned_num"), resultSet.getInt("cmax_num")));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayList;

    }


    public ArrayList<Course> SelectedByDepartmentRough(Connection connection, String department) {
        DatabaseMetaData databaseMetaData;
        ArrayList<Course> arrayList;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM course WHERE cdepartment LIKE ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  // ??????????????????????????????
            preparedStatement.setString(1, "%" + department + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            arrayList = new ArrayList<>();
            databaseMetaData = connection.getMetaData();
            if (resultSet.next())
                System.out.println(String.format("%s: \n%s", databaseMetaData.getURL(), preparedStatement));
            else
                System.out.println(String.format("%s: Failed.", databaseMetaData.getURL()));
            resultSet.beforeFirst();
            while (resultSet.next()) {
                arrayList.add(new Course(resultSet.getInt("cid"), resultSet.getString("cname"), resultSet.getString("cdepartment"),
                        resultSet.getDouble("ccredit"), resultSet.getString("ckclb"), resultSet.getInt("cteacherid"),
                        resultSet.getString("croom"), resultSet.getString("ctime"), resultSet.getInt("csigned_num"), resultSet.getInt("cmax_num")));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayList;

    }

    public ArrayList<Course> SelectedByKclbRough (Connection connection, String kclb) {
        DatabaseMetaData databaseMetaData;
        ArrayList<Course> arrayList;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM course WHERE ckclb LIKE ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  // ??????????????????????????????
            preparedStatement.setString(1, "%" + kclb + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            arrayList = new ArrayList<>();
            databaseMetaData = connection.getMetaData();
            if (resultSet.next())
                System.out.println(String.format("%s: \n%s", databaseMetaData.getURL(), preparedStatement));
            else
                System.out.println(String.format("%s: Failed.", databaseMetaData.getURL()));
            resultSet.beforeFirst();
            while (resultSet.next()) {
                arrayList.add(new Course(resultSet.getInt("cid"), resultSet.getString("cname"), resultSet.getString("cdepartment"),
                        resultSet.getDouble("ccredit"), resultSet.getString("ckclb"), resultSet.getInt("cteacherid"),
                        resultSet.getString("croom"), resultSet.getString("ctime"), resultSet.getInt("csigned_num"), resultSet.getInt("cmax_num")));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayList;

    }

    public ArrayList<Course> SelectedByTNameRough(Connection connection, String tn) {
        DatabaseMetaData databaseMetaData;
        ArrayList<Course> arrayList;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT cid, cname, cdepartment, ccredit, ckclb, t.name, croom, ctime, csigned_num, cmax_num FROM course c INNER JOIN teacher t on c.cteacherid = t.id WHERE t.name LIKE ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);  // ??????????????????????????????
            preparedStatement.setString(1, "%" + tn + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            arrayList = new ArrayList<>();
            databaseMetaData = connection.getMetaData();
            if (resultSet.next())
                System.out.println(String.format("%s: \n%s", databaseMetaData.getURL(), preparedStatement));
            else
                System.out.println(String.format("%s: Failed.", databaseMetaData.getURL()));
            resultSet.beforeFirst();
            while (resultSet.next()) {
                arrayList.add(new Course(resultSet.getInt("cid"), resultSet.getString("cname"), resultSet.getString("cdepartment"),
                        resultSet.getDouble("ccredit"), resultSet.getString("ckclb"), resultSet.getString("name"),
                        resultSet.getString("croom"), resultSet.getString("ctime"), resultSet.getInt("csigned_num"), resultSet.getInt("cmax_num")));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayList;

    }


}
