package newjwglxt.jwglxt.util;

public class Judge {
    public static boolean isChinese(String s) {
        return s.trim().matches("^[\\u4E00-\\u9FA5]+$");
    }

    public static boolean isNum(String s) {
        return s.trim().matches("^[0-9]*$") && !s.trim().equals("");
    }

    public static boolean isCredit(String s) {
        // 仅一位小数
        if (isNum(s))
            return true;
        else return s.matches("^-?(?:0|[1-9][0-9]*)\\.[0-9]{1}$");
    }

    public static boolean isYear(String s) {
        return isNum(s) && s.trim().length() == 4 && (s.trim().charAt(0) == '1' || s.trim().charAt(0) == '2');
    }

    public static boolean isPhoneNum(String s) {
        return s.trim().matches("^(?:(?:\\+|00)86)?1[3-9]\\d{9}$") || s.trim().matches("^(?:(?:\\d{3}-)?\\d{8}|^(?:\\d{4}-)?\\d{7,8})\n(?:-\\d+)?$");
    }

    public static boolean isSID(String s) {
        return isNum(s) && s.trim().charAt(0) == '3' && s.trim().length() == 5;
    }

    public static boolean isTID(String s) {
        return isNum(s) && s.trim().charAt(0) == '2' && s.trim().length() == 5;
    }

    public static boolean isJWID(String s) {
        return isNum(s) && s.trim().charAt(0) == '1' && s.trim().length() == 5;
    }

    public static boolean isCID(String s) {
        return isNum(s) && s.trim().length() == 4;
    }

    public static boolean stringHasExceptLetter(String s) {
        char[] c = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            c[i] = s.charAt(i);
            if (!((c[i] >= 65 && c[i] <= 90) || (c[i] >= 97 && c[i] <= 122))) {
                return true;
            }
        }
        return false;
    }
    public static boolean isName(String s) {
        return (s.matches("[\u4E00-\u9FA5]+") || !stringHasExceptLetter(s)) && s.length() != 0 && s.length() != 1;
    }

    public static boolean isTime(String s) {
        if (s.length() != 11)
            return false;
        int startWeek = new Integer(String.valueOf(s.charAt(0)) + s.charAt(1));
//        System.out.println(startWeek);

        int endWeek = new Integer(String.valueOf(s.charAt(2)) + s.charAt(3));
//        System.out.println(endWeek);

        char weekDay = s.charAt(4);
//        System.out.println(weekDay);

        int startTime = new Integer(String.valueOf(s.charAt(5)) + s.charAt(6));
//        System.out.println(startTime);

        int endTime = new Integer(String.valueOf(s.charAt(7)) + s.charAt(8));
//        System.out.println(endTime);

        if (startWeek <= 0 || endWeek <= 0 || endTime > 20 || startWeek > endWeek) {
            return false;
        } else if (weekDay < 65 || weekDay > 71) {
            //weekday只能是A-G
            return false;
        } else if (startTime <= 0 || endTime <= 0 || endTime > 12 || startTime > endTime) {
            return false;
        } else return s.charAt(9) >= 48 && s.charAt(9) <= 57 && s.charAt(10) >= 48 && s.charAt(10) <= 57;
    }

    public static void main(String[] args) {
        System.out.println(isName("夏润成"));
    }
}
