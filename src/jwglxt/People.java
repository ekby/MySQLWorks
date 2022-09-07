package jwglxt;

public class People {
    private String name;
    private String id;
    private String pw;
    private char gender;
    private String contact;

    public People(String name, String id, String pw, char gender, String contact) {
        this.name = name;
        this.id = id;
        this.pw = pw;
        this.gender = gender;
        this.contact = contact;
    }

    public void createPerson(Student student) {

    }

    public void createPerson(Teacher teacher) {

    }

    public void createPerson(Jwadmin jwadmin) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
