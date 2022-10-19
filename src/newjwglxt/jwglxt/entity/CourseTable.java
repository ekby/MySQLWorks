package newjwglxt.jwglxt.entity;

public class CourseTable {
    private String cname;
    private int cid;
    private String ctime;
    private String cplace;
    private double cgrade;
    private String ctype;
    private int cteacherid;

    public CourseTable(String cname, int cid, String ctime, String cplace, double cgrade, String ctype, int cteacherid){
        this.cname = cname;
        this.cid = cid;
        this.ctime = ctime;
        this.cplace = cplace;
        this.cgrade = cgrade;
        this.ctype = ctype;
        this.cteacherid = cteacherid;
    }

    public CourseTable(){

    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getCplace() {
        return cplace;
    }

    public void setCplace(String cplace) {
        this.cplace = cplace;
    }

    public double getCgrade() {
        return cgrade;
    }

    public void setCgrade(double cgrade) {
        this.cgrade = cgrade;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    public int getCteacher() {
        return cteacherid;
    }

    public void setCteacher(int cteacherid) {
        this.cteacherid = cteacherid;
    }

    @Override
    public String toString() {
        return "CourseTable{" +
                "cname='" + cname + '\'' +
                ", cid=" + cid +
                ", ctime='" + ctime + '\'' +
                ", cplace='" + cplace + '\'' +
                ", cgrade=" + cgrade +
                ", ctype='" + ctype + '\'' +
                ", cteacherid=" + cteacherid +
                '}';
    }
}
