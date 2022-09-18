package newjwglxt.jwglxt.dao;

import newjwglxt.jwglxt.concrete.Jwadmin;

import java.sql.Connection;
import java.util.ArrayList;

public class JwadminDaoImpl implements BaseDao<Jwadmin> {
    // TODO jwadmindao

    @Override
    public void Insert(Connection connection, Jwadmin jwadmin) {

    }

    @Override
    public void Delete(Connection connection, Jwadmin jwadmin) {

    }

    @Override
    public void Update(Connection connection, Jwadmin t0, Jwadmin t1) {

    }

    @Override
    public ArrayList<Jwadmin> SelectById(Connection connection, int id) {
        return null;
    }

    @Override
    public ArrayList<Jwadmin> SelectByIdRough(Connection connection, int id) {
        return null;
    }

    @Override
    public ArrayList<Jwadmin> SelectByName(Connection connection, String name) {
        return null;
    }

    @Override
    public ArrayList<Jwadmin> SelectByNameRough(Connection connection, String name) {
        return null;
    }
}
