package newjwglxt.jwglxt.entity;

public class ChooseCourse {
    private int ccid;
    private int ccsid;
    private int cccid;
    private int ccscore;
    private int ccgpa;

    public ChooseCourse(int ccid, int ccsid, int cccid, int ccscore, int ccgpa) {
        this.ccid = ccid;
        this.ccsid = ccsid;
        this.cccid = cccid;
        this.ccscore = ccscore;
        this.ccgpa = ccgpa;
    }

    public int getCcid() {
        return ccid;
    }

    public void setCcid(int ccid) {
        this.ccid = ccid;
    }

    public int getCcsid() {
        return ccsid;
    }

    public void setCcsid(int ccsid) {
        this.ccsid = ccsid;
    }

    public int getCccid() {
        return cccid;
    }

    public void setCccid(int cccid) {
        this.cccid = cccid;
    }

    public int getCcscore() {
        return ccscore;
    }

    public void setCcscore(int ccscore) {
        this.ccscore = ccscore;
    }

    public int getCcgpa() {
        return ccgpa;
    }

    public void setCcgpa(int ccgpa) {
        this.ccgpa = ccgpa;
    }
}
