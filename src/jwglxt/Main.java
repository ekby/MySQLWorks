package jwglxt;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Xtadmin whd = new Xtadmin("whd", "20110116", "1", 'f', "0");
//        whd.createTeacher("shanxiaohong", "1", "1", 'f', "?", 2022, "yuanshi", "jjyglxy");
//        whd.createStudent("xrc", "0203", "020228", 'm', "null", 1921, "xinxiguanliyuxinxixitong", 201102, "jingjiyuguanli");
//        whd.createJwadmin("qk", "20110121", "woshiqiaoke", 'f', "?");
//        whd.deleteTeacher("1");
//        whd.modifyinfo_name("whd1", "xtadmin", "116");
//        whd.modifyinfo_contact("1234567890","xtadmin","116");
//        System.out.println(whd.selectTeacher("1"));
//        whd.modifyinfo_gender('A', "xtadmin", "116");
        whd.modifyinfo_password("0110231", "xtadmin", "116");

    }
}
