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


}
