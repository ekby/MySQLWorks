package newjwglxt.jwglxt.entity;

public class DropCourse {
    private int dcid;
    private int dcsid;
    private int dccid;
    private int dchandle;

    public DropCourse(int dcid, int dcsid, int dccid, int dchandle) {
        this.dcid = dcid;
        this.dcsid = dcsid;
        this.dccid = dccid;
        this.dchandle = dchandle;
    }

    public DropCourse() {

    }

    public int getDcid() {
        return dcid;
    }

    public void setDcid(int dcid) {
        this.dcid = dcid;
    }

    public int getDcsid() {
        return dcsid;
    }

    public void setDcsid(int dcsid) {
        this.dcsid = dcsid;
    }

    public int getDccid() {
        return dccid;
    }

    public void setDccid(int dccid) {
        this.dccid = dccid;
    }

    public int getDchandle() {
        return dchandle;
    }

    public void setDchandle(int dchandle) {
        this.dchandle = dchandle;
    }
}
