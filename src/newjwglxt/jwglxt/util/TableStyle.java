package newjwglxt.jwglxt.util;

import javax.swing.*;
import java.awt.*;

public class TableStyle {
    public static void setTableStyle(JTable jTable) {
        jTable.getTableHeader().setFont(new Font("微软雅黑", Font.PLAIN, 11));
        jTable.setFont(new Font("微软雅黑", Font.PLAIN, 11));
    }
}
