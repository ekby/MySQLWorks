package jwglxt;

public class Student extends People {
    private int sfirstyear, sclass;
    private String smajor, scollege;

    public Student(String id, String name, String pw, char gender, String contact, String scollege, int sfirstyear, String smajor, int sclass) {
        super(name, id, pw, gender, contact);
        this.sfirstyear = sfirstyear;
        this.smajor = smajor;
        this.sclass = sclass;
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
}
