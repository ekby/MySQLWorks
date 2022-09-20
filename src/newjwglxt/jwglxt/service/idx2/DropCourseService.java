package newjwglxt.jwglxt.service.idx2;

import newjwglxt.jwglxt.entity.DropCourse;

import java.sql.Connection;
import java.util.ArrayList;

public class DropCourseService implements Service_idx2<DropCourse> {
    @Override
    public void Add(Connection connection, DropCourse dropCourse) {

    }

    @Override
    public void Delete(Connection connection, DropCourse dropCourse) {

    }

    @Override
    public void Update(Connection connection, DropCourse dropCourse) {

    }

    @Override
    public ArrayList<DropCourse> CheckBySid(Connection connection, int sid) {
        return null;
    }

    @Override
    public ArrayList<DropCourse> CheckByCid(Connection connection, int cid) {
        return null;
    }
}
