package newjwglxt.jwglxt.service.idx1;

import newjwglxt.jwglxt.dao.idx1.XtadminDaoImpl;
import newjwglxt.jwglxt.entity.Xtadmin;
import newjwglxt.jwglxt.util.DbConnector;

import java.util.ArrayList;

public class XtadminService implements Service_idx1<Xtadmin>, LoginService<Xtadmin> {
    @Override
    public Xtadmin LoginVerify(DbConnector dbConnector, int id, String pw) {
        XtadminDaoImpl xtadminDao = new XtadminDaoImpl();
        ArrayList<Xtadmin> arrayList = xtadminDao.SelectById(dbConnector.getConnection(), id);

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
    public void Add(DbConnector dbConnector, Xtadmin xtadmin) {
        XtadminDaoImpl xtadminDao = new XtadminDaoImpl();
        xtadminDao.Insert(dbConnector.getConnection(), xtadmin);
    }

    @Override
    public void Delete(DbConnector dbConnector, Xtadmin xtadmin) {
        XtadminDaoImpl xtadminDao = new XtadminDaoImpl();
        xtadminDao.Delete(dbConnector.getConnection(), xtadmin);
    }

    @Override
    public void Update(DbConnector dbConnector, Xtadmin xtadmin) {
        XtadminDaoImpl xtadminDao = new XtadminDaoImpl();
        xtadminDao.Update(dbConnector.getConnection(), xtadmin);
    }

    @Override
    public ArrayList<Xtadmin> CheckById(DbConnector dbConnector, int id) {
        XtadminDaoImpl xtadminDao = new XtadminDaoImpl();
        return xtadminDao.SelectById(dbConnector.getConnection(), id);
    }

    @Override
    public ArrayList<Xtadmin> CheckByIdRough(DbConnector dbConnector, int id) {
        XtadminDaoImpl xtadminDao = new XtadminDaoImpl();
        return xtadminDao.SelectByIdRough(dbConnector.getConnection(), id);
    }

    @Override
    public ArrayList<Xtadmin> CheckByName(DbConnector dbConnector, String name) {
        XtadminDaoImpl xtadminDao = new XtadminDaoImpl();
        return xtadminDao.SelectByName(dbConnector.getConnection(), name);
    }

    @Override
    public ArrayList<Xtadmin> CheckByNameRough(DbConnector dbConnector, String name) {
        XtadminDaoImpl xtadminDao = new XtadminDaoImpl();
        return xtadminDao.SelectByNameRough(dbConnector.getConnection(), name);
    }
}
