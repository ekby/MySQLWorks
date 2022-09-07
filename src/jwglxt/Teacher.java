package jwglxt;

public class Teacher extends People {
    private int tfirstyear;
    private String ttitle;
    private String tcollege;

    public Teacher(String name, String id, String pw, char gender, String contact, int tfirstyear, String ttitle, String tcollege) {
        super(name, id, pw, gender, contact);
        this.tfirstyear = tfirstyear;
        this.ttitle = ttitle;
        this.tcollege = tcollege;
    }

    public int getTfirstyear() {
        return tfirstyear;
    }

    public void setTfirstyear(int tfirstyear) {
        this.tfirstyear = tfirstyear;
    }

    public String getTtitle() {
        return ttitle;
    }

    public void setTtitle(String ttitle) {
        this.ttitle = ttitle;
    }

    public String getTcollege() {
        return tcollege;
    }

    public void setTcollege(String tcollege) {
        this.tcollege = tcollege;
    }
}
