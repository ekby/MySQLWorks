package newjwglxt.jwglxt.util;

import newjwglxt.jwglxt.service.idx1.JwadminService;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

import static newjwglxt.jwglxt.util.ComboboxStyle.setComboboxStyle;
import static newjwglxt.jwglxt.util.Judge.isNum;
import static newjwglxt.jwglxt.util.QuickButton.primaryBorderButton;

public class SelectFunc {
    public SelectFunc(String role, DbConnector dbConnector, JPanel panel_category, int btn_y, JPanel panel_container) {
        switch (role) {
            case "xtadmin": {
                init_xtadmin(dbConnector, panel_category, btn_y, panel_container);
                break;
            }
        }
    }

    private void init_xtadmin(DbConnector dbConnector, JPanel panel_category, int btn_y, JPanel panel_container) {
        // left
        JButton btnUnknown8 = primaryBorderButton("查找");
        btnUnknown8.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnUnknown8.setBounds(10, btn_y, 130, 35);
        panel_category.add(btnUnknown8);

        // right
        JPanel panel_Chazhao = new JPanel();
        panel_Chazhao.setLayout(null);
        panel_container.add(panel_Chazhao);

        // title
        JPanel panel_title_zhuye_jwadmin = new JPanel();
        panel_title_zhuye_jwadmin.setLayout(null);
        panel_title_zhuye_jwadmin.setForeground(SystemColor.activeCaption);
        panel_title_zhuye_jwadmin.setBackground(SystemColor.scrollbar);
        panel_title_zhuye_jwadmin.setBounds(0, 0, 553, 46);
        panel_Chazhao.add(panel_title_zhuye_jwadmin);

        JLabel lblNewLabel_8_1 = new JLabel("查找");
        lblNewLabel_8_1.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lblNewLabel_8_1.setBounds(10, 10, 64, 22);
        panel_title_zhuye_jwadmin.add(lblNewLabel_8_1);

        // search combobox
        JComboBox jComboBox = new JComboBox();
        jComboBox.setModel(new DefaultComboBoxModel(new String[]{"教职工号", "姓名"}));
        setComboboxStyle(jComboBox);
        jComboBox.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        jComboBox.setBounds(533 - 70 - 10 - 10 - 140 - 90 - 10, 56, 90, 26);
        panel_Chazhao.add(jComboBox);

        JTextField textFielda = new JTextField();
        textFielda.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        textFielda.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textFielda.setBounds(533 - 70 - 10 - 10 - 140, 56, 140, 26);
        panel_Chazhao.add(textFielda);

        JButton btnCreateCourse_1a = primaryBorderButton("查找");
        btnCreateCourse_1a.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnCreateCourse_1a.setBounds(533 - 70 - 10, 56, 70, 26);
        panel_Chazhao.add(btnCreateCourse_1a);

        // table
        JScrollPane scrollPane_jiaoshiliebiao = new JScrollPane();
        scrollPane_jiaoshiliebiao.setBounds(10, 46 + 10 + 26 + 10, 553 - 20, 455 - 46 - 10 - 10);
        panel_Chazhao.add(scrollPane_jiaoshiliebiao);

        JTable table_jiaoshiliebiao = new JTable();
        table_jiaoshiliebiao.getTableHeader().setReorderingAllowed(false);
        table_jiaoshiliebiao.getTableHeader().setFont(new Font("微软雅黑", Font.PLAIN, 11));
        table_jiaoshiliebiao.setFont(new Font("微软雅黑", Font.PLAIN, 11));
        scrollPane_jiaoshiliebiao.setViewportView(table_jiaoshiliebiao);

        Vector<String> table_title = new Vector<>();
        table_title.add("教职工号");
        table_title.add("姓名");
        table_title.add("性别");
        table_title.add("联系方式");

        JLabel lblNewLabel_8_1g = new JLabel("请检查输入!");
        lblNewLabel_8_1g.setFont(new Font("微软雅黑", Font.BOLD, 13));
        lblNewLabel_8_1g.setForeground(Color.red);
        lblNewLabel_8_1g.setBounds(533 - 70 - 10 - 10 - 140 - 90 - 10 - 64, 10, 64, 26);
        panel_title_zhuye_jwadmin.add(lblNewLabel_8_1g);
        lblNewLabel_8_1g.setVisible(false);

        btnUnknown8.addActionListener(e -> {
            panel_container.removeAll();
            panel_container.add(panel_Chazhao);
            panel_container.validate();
            panel_container.repaint();
            panel_Chazhao.setVisible(true);
        });

        btnCreateCourse_1a.addActionListener(e -> {
            String str = textFielda.getText();
            if (str.equals("")) {
                lblNewLabel_8_1g.setVisible(true);
            } else {
                if (isNum(str)) {

                    JwadminService jwadminService = new JwadminService();
//                    Vector<Vector<Object>> vectors = jwadminService.CheckByIdRough_Vector(dbConnector, str);
                }
            }
        });
    }

}
