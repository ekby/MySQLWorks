package newjwglxt.jwglxt.entity;

public class CourseTable {
    private String cname;
    private int cid;
    private String ctime;
    private String cplace;
    private double cgrade;
    private String ctype;
    private String cteachername;

    public CourseTable(String cname, int cid, String ctime, String cplace, double cgrade, String ctype, String cteachername){
        this.cname = cname;
        this.cid = cid;
        this.ctime = ctime;
        this.cplace = cplace;
        this.cgrade = cgrade;
        this.ctype = ctype;
        this.cteachername = cteachername;
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

    public String getCteachername() {
        return cteachername;
    }

    public void setCteachername(String cteachername) {
        this.cteachername = cteachername;
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
                ", cteachername='" + cteachername + '\'' +
                '}';
    }
}
