package newjwglxt.jwglxt.dao;

import newjwglxt.jwglxt.concrete.Xtadmin;

import java.sql.Connection;
import java.util.ArrayList;

public class XtadminDaoImpl implements BaseDao<Xtadmin> {
    // TODO xtadmindao

    @Override
    public void Insert(Connection connection, Xtadmin xtadmin) {

    }

    @Override
    public void Delete(Connection connection, Xtadmin xtadmin) {

    }

    @Override
    public void Update(Connection connection, Xtadmin t0, Xtadmin t1) {

    }

    @Override
    public ArrayList<Xtadmin> SelectById(Connection connection, int id) {
        return null;
    }

    @Override
    public ArrayList<Xtadmin> SelectByIdRough(Connection connection, int id) {
        return null;
    }

    @Override
    public ArrayList<Xtadmin> SelectByName(Connection connection, String name) {
        return null;
    }

    @Override
    public ArrayList<Xtadmin> SelectByNameRough(Connection connection, String name) {
        return null;
    }
}
