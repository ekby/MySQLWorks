package newjwglxt.jwglxt.service.idx1;

import newjwglxt.jwglxt.dao.idx1.JwadminDaoImpl;
import newjwglxt.jwglxt.entity.Jwadmin;

import java.sql.Connection;
import java.util.ArrayList;

public class JwadminService implements Service_idx1<Jwadmin>, LoginService<Jwadmin> {
    @Override
    public Jwadmin LoginVerify(Connection connection, int id, String pw) {
        JwadminDaoImpl JwadminDao = new JwadminDaoImpl();
        ArrayList<Jwadmin> arrayList = JwadminDao.SelectById(connection, id);

        if (arrayList.size() != 1)
            return null;
        else {
            Jwadmin Jwadmin = arrayList.get(0);
            if (Jwadmin.getPw().equals(pw))
                return Jwadmin;
            else
                return null;
        }
    }

    @Override
    public void Add(Connection connection, Jwadmin Jwadmin) {
        JwadminDaoImpl JwadminDao = new JwadminDaoImpl();
        JwadminDao.Insert(connection, Jwadmin);
    }

    @Override
    public void Delete(Connection connection, Jwadmin Jwadmin) {
        JwadminDaoImpl JwadminDao = new JwadminDaoImpl();
        JwadminDao.Delete(connection, Jwadmin);
    }

    @Override
    public void Update(Connection connection, Jwadmin Jwadmin) {
        JwadminDaoImpl JwadminDao = new JwadminDaoImpl();
        JwadminDao.Update(connection, Jwadmin);
    }

    @Override
    public ArrayList<Jwadmin> CheckById(Connection connection, int id) {
        JwadminDaoImpl JwadminDao = new JwadminDaoImpl();
        return JwadminDao.SelectById(connection, id);
    }

    @Override
    public ArrayList<Jwadmin> CheckByIdRough(Connection connection, int id) {
        JwadminDaoImpl JwadminDao = new JwadminDaoImpl();
        return JwadminDao.SelectByIdRough(connection, id);
    }

    @Override
    public ArrayList<Jwadmin> CheckByName(Connection connection, String name) {
        JwadminDaoImpl JwadminDao = new JwadminDaoImpl();
        return JwadminDao.SelectByName(connection, name);
    }

    @Override
    public ArrayList<Jwadmin> CheckByNameRough(Connection connection, String name) {
        JwadminDaoImpl JwadminDao = new JwadminDaoImpl();
        return JwadminDao.SelectByNameRough(connection, name);
    }

}
