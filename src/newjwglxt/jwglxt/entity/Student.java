package newjwglxt.jwglxt.entity;

public class Student extends People {
    private int sfirstyear, sclass;
    private String smajor, scollege;

    public Student(String name, int id, String pw, String gender, String contact, int sfirstyear, int sclass, String smajor, String scollege) {
        super(name, id, pw, gender, contact);
        this.sfirstyear = sfirstyear;
        this.sclass = sclass;
        this.smajor = smajor;
        this.scollege = scollege;
    }

    public int getSfirstyear() {
        return sfirstyear;
    }

    public void setSfirstyear(int sfirstyear) {
        this.sfirstyear = sfirstyear;
    }

    public int getSclass() {
        return sclass;
    }

    public void setSclass(int sclass) {
        this.sclass = sclass;
    }

    public String getSmajor() {
        return smajor;
    }

    public void setSmajor(String smajor) {
        this.smajor = smajor;
    }

    public String getScollege() {
        return scollege;
    }

    public void setScollege(String scollege) {
        this.scollege = scollege;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sfirstyear=" + sfirstyear +
                ", sclass=" + sclass +
                ", smajor='" + smajor + '\'' +
                ", scollege='" + scollege + '\'' +
                "} " + super.toString();
    }
}
