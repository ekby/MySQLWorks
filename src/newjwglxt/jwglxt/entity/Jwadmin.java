package newjwglxt.jwglxt.entity;

public class Jwadmin extends People {
    public Jwadmin(String name, int id, String pw, String gender, String contact) {
        super(name, id, pw, gender, contact);
    }

    @Override
    public String toString() {
        return "Jwadmin{} " + super.toString();
    }
}
