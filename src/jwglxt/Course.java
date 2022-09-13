package jwglxt;

public class Course {
    private int cid;
    private String cname;
    private String cdepartment;
    private float ccredit;
    private String ckclb;
    private int ctid;
    private String croom;
    private String ctime;
    private int csigned_num;
    private int cmax_num;

    public Course(int cid, String cname, String cdepartment, float ccredit, String ckclb, int ctid, String croom, String ctime, int csigned_num, int cmax_num) {
        this.cid = cid;
        this.cname = cname;
        this.cdepartment = cdepartment;
        this.ccredit = ccredit;
        this.ckclb = ckclb;
        this.ctid = ctid;
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

    public float getCcredit() {
        return ccredit;
    }

    public void setCcredit(float ccredit) {
        this.ccredit = ccredit;
    }

    public String getCkclb() {
        return ckclb;
    }

    public void setCkclb(String ckclb) {
        this.ckclb = ckclb;
    }

    public int getCtid() {
        return ctid;
    }

    public void setCtid(int ctid) {
        this.ctid = ctid;
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
    public String toString() {
        return "Course{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", cdepartment='" + cdepartment + '\'' +
                ", ccredit=" + ccredit +
                ", ckclb='" + ckclb + '\'' +
                ", ctid=" + ctid +
                ", croom='" + croom + '\'' +
                ", ctime='" + ctime + '\'' +
                ", csigned_num=" + csigned_num +
                ", cmax_num=" + cmax_num +
                '}';
    }
}
