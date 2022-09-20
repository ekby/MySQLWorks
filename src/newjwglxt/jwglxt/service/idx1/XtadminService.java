package newjwglxt.jwglxt.service.idx1;

import newjwglxt.jwglxt.dao.idx1.XtadminDaoImpl;
import newjwglxt.jwglxt.entity.Xtadmin;

import java.sql.Connection;
import java.util.ArrayList;

public class XtadminService implements Service_idx1<Xtadmin>, LoginService<Xtadmin> {
    @Override
    public Xtadmin LoginVerify(Connection connection, int id, String pw) {
        XtadminDaoImpl xtadminDao = new XtadminDaoImpl();
        ArrayList<Xtadmin> arrayList = xtadminDao.SelectById(connection, id);

        if (arrayList.size() != 1)
            return null;
        else {
            Xtadmin xtadmin = arrayList.get(0);
            if (xtadmin.getPw().equals(pw))
                return xtadmin;
            else
                return null;
        }
    }

    @Override
    public void Add(Connection connection, Xtadmin xtadmin) {
        XtadminDaoImpl xtadminDao = new XtadminDaoImpl();
        xtadminDao.Insert(connection, xtadmin);
    }

    @Override
    public void Delete(Connection connection, Xtadmin xtadmin) {
        XtadminDaoImpl xtadminDao = new XtadminDaoImpl();
        xtadminDao.Delete(connection, xtadmin);
    }

    @Override
    public void Update(Connection connection, Xtadmin xtadmin) {
        XtadminDaoImpl xtadminDao = new XtadminDaoImpl();
        xtadminDao.Update(connection, xtadmin);
    }

    @Override
    public ArrayList<Xtadmin> CheckById(Connection connection, int id) {
        XtadminDaoImpl xtadminDao = new XtadminDaoImpl();
        return xtadminDao.SelectById(connection, id);
    }

    @Override
    public ArrayList<Xtadmin> CheckByIdRough(Connection connection, int id) {
        XtadminDaoImpl xtadminDao = new XtadminDaoImpl();
        return xtadminDao.SelectByIdRough(connection, id);
    }

    @Override
    public ArrayList<Xtadmin> CheckByName(Connection connection, String name) {
        XtadminDaoImpl xtadminDao = new XtadminDaoImpl();
        return xtadminDao.SelectByName(connection, name);
    }

    @Override
    public ArrayList<Xtadmin> CheckByNameRough(Connection connection, String name) {
        XtadminDaoImpl xtadminDao = new XtadminDaoImpl();
        return xtadminDao.SelectByNameRough(connection, name);
    }
}
