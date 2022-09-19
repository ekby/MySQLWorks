package newjwglxt.jwglxt.entity;

public class Xtadmin extends People {
    public Xtadmin(String name, int id, String pw, String gender, String contact) {
        super(name, id, pw, gender, contact);
    }

    @Override
    public String toString() {
        return "Xtadmin{} " + super.toString();
    }
}
