package newjwglxt.jwglxt.entity;

import java.util.Objects;

public class Course {
    private int cid;
    private String cname;
    private String cdepartment;
    private double ccredit;
    private String ckclb;
    private int cteacherid;
    private String croom;
    private String ctime;
    private int csigned_num;
    private int cmax_num;

    public Course(int cid, String cname, String cdepartment, double ccredit, String ckclb, int cteacherid, String croom, String ctime, int csigned_num, int cmax_num) {
        this.cid = cid;
        this.cname = cname;
        this.cdepartment = cdepartment;
        this.ccredit = ccredit;
        this.ckclb = ckclb;
        this.cteacherid = cteacherid;
        this.croom = croom;
        this.ctime = ctime;
        this.csigned_num = csigned_num;
        this.cmax_num = cmax_num;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCdepartment() {
        return cdepartment;
    }

    public void setCdepartment(String cdepartment) {
        this.cdepartment = cdepartment;
    }

    public double getCcredit() {
        return ccredit;
    }

    public void setCcredit(Float ccredit) {
        this.ccredit = ccredit;
    }

    public String getCkclb() {
        return ckclb;
    }

    public void setCkclb(String ckclb) {
        this.ckclb = ckclb;
    }

    public int getCteacherid() {
        return cteacherid;
    }

    public void setCteacherid(int cteacherid) {
        this.cteacherid = cteacherid;
    }

    public String getCroom() {
        return croom;
    }

    public void setCroom(String croom) {
        this.croom = croom;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public int getCsigned_num() {
        return csigned_num;
    }

    public void setCsigned_num(int csigned_num) {
        this.csigned_num = csigned_num;
    }

    public int getCmax_num() {
        return cmax_num;
    }

    public void setCmax_num(int cmax_num) {
        this.cmax_num = cmax_num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return cid == course.cid && Double.compare(course.ccredit, ccredit) == 0 && cteacherid == course.cteacherid && csigned_num == course.csigned_num && cmax_num == course.cmax_num && Objects.equals(cname, course.cname) && Objects.equals(cdepartment, course.cdepartment) && Objects.equals(ckclb, course.ckclb) && Objects.equals(croom, course.croom) && Objects.equals(ctime, course.ctime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cid, cname, cdepartment, ccredit, ckclb, cteacherid, croom, ctime, csigned_num, cmax_num);
    }

    @Override
    public String toString() {
        return "Course{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", cdepartment='" + cdepartment + '\'' +
                ", ccredit=" + ccredit +
                ", ckclb='" + ckclb + '\'' +
                ", cteacherid=" + cteacherid +
                ", croom='" + croom + '\'' +
                ", ctime='" + ctime + '\'' +
                ", csigned_num=" + csigned_num +
                ", cmax_num=" + cmax_num +
                '}';
    }
}
