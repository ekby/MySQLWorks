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

}
