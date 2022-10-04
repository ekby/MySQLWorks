package newjwglxt.jwglxt.ui;

import newjwglxt.jwglxt.entity.Xtadmin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XtadminPanel {
    protected JPanel xtadmin;

    public JPanel getPanel() {
        return xtadmin;
    }

    public XtadminPanel(Xtadmin xtadmin_login) {
        xtadmin = new JPanel();
        xtadmin.setLayout(null);
        xtadmin.setOpaque(false);
        MainWindow.contentPane.add(xtadmin, "name_611226331268200");

        JPanel panel_category_xtadmin = new JPanel();
        panel_category_xtadmin.setLayout(null);
        panel_category_xtadmin.setBounds(10, 10, 150, 451);
        xtadmin.add(panel_category_xtadmin);

        JButton btnHomePage_xtadmin = new JButton("主页");
        btnHomePage_xtadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnHomePage_xtadmin.setBounds(10, 10, 130, 35);
        panel_category_xtadmin.add(btnHomePage_xtadmin);

        JButton btnApprovalManagement_xtadmin = new JButton("审批管理");
        btnApprovalManagement_xtadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnApprovalManagement_xtadmin.setBounds(10, 55, 130, 35);
        panel_category_xtadmin.add(btnApprovalManagement_xtadmin);

        JButton btnUserManagement_xtadmin = new JButton("用户管理");
        btnUserManagement_xtadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnUserManagement_xtadmin.setBounds(10, 100, 130, 35);
        panel_category_xtadmin.add(btnUserManagement_xtadmin);

        JButton btnUserInfoManagemment_xtadmin = new JButton("个人信息管理");
        btnUserInfoManagemment_xtadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnUserInfoManagemment_xtadmin.setBounds(10, 145, 130, 35);
        panel_category_xtadmin.add(btnUserInfoManagemment_xtadmin);

        JButton btnAbout_xtadmin = new JButton("关于");
        btnAbout_xtadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnAbout_xtadmin.setBounds(10, 406, 130, 35);
        panel_category_xtadmin.add(btnAbout_xtadmin);

        JPanel panel_container_xtadmin = new JPanel();
        panel_container_xtadmin.setBounds(170, 10, 553, 451);
        xtadmin.add(panel_container_xtadmin);
        panel_container_xtadmin.setLayout(new CardLayout(0, 0));

        JPanel panel_homepage_xtadmin = new JPanel();
        panel_homepage_xtadmin.setLayout(null);
        panel_container_xtadmin.add(panel_homepage_xtadmin, "name_223808958587400");

        JPanel panel_approval_xtadmin = new JPanel();
        panel_approval_xtadmin.setLayout(null);
        panel_container_xtadmin.add(panel_approval_xtadmin, "name_1655028076360800");

        JPanel panel_user_xtadmin = new JPanel();
        panel_container_xtadmin.add(panel_user_xtadmin, "name_1655059689581500");
        panel_user_xtadmin.setLayout(null);

        JPanel panel_about_xtadmin = new JPanel();
        panel_about_xtadmin.setLayout(null);
        panel_container_xtadmin.add(panel_about_xtadmin, "about");

        JLabel pax_lbl1 = new JLabel("只因(just because)");
        pax_lbl1.setBounds(84, 62, 103, 16);
        panel_about_xtadmin.add(pax_lbl1);

        JPanel panel_selfinfo_xtadmin = new JPanel();
        panel_selfinfo_xtadmin.setLayout(null);
        panel_container_xtadmin.add(panel_selfinfo_xtadmin, "name_1655028076360800");

        JPanel panel_listContainer = new JPanel();
        panel_listContainer.setBounds(10, 53, 533, 388);
        panel_user_xtadmin.add(panel_listContainer);
        panel_listContainer.setLayout(new CardLayout(0, 0));

        JScrollPane studentList = new JScrollPane();
        panel_listContainer.add(studentList, "name_1656773210897400");

        JTable student_table = new JTable();
        student_table.setModel(new DefaultTableModel(new Object[][]{{null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null},}, new String[]{"\u5B66\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u5165\u5B66\u5E74\u4EFD", "\u4E13\u4E1A", "\u884C\u653F\u73ED", "\u5B66\u90E8\uFF08\u9662\uFF09", "\u8054\u7CFB\u65B9\u5F0F"}) {
            Class[] columnTypes = new Class[]{Integer.class, String.class, String.class, Integer.class, String.class, Integer.class, String.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });
        studentList.setViewportView(student_table);

        JScrollPane teacherList = new JScrollPane();
        panel_listContainer.add(teacherList, "name_1658528172865100");

        JTable teacher_table = new JTable();
        teacher_table.setModel(new DefaultTableModel(new Object[][]{{null, null, null, null, null, null, null}, {null, null, null, null, null, null, null}, {null, null, null, null, null, null, null}, {null, null, null, null, null, null, null}, {null, null, null, null, null, null, null}, {null, null, null, null, null, null, null}, {null, null, null, null, null, null, null}, {null, null, null, null, null, null, null}, {null, null, null, null, null, null, null}, {null, null, null, null, null, null, null}, {null, null, null, null, null, null, null}, {null, null, null, null, null, null, null}, {null, null, null, null, null, null, null}, {null, null, null, null, null, null, null}, {null, null, null, null, null, null, null},}, new String[]{"\u6559\u5DE5\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u5165\u804C\u5E74", "\u804C\u79F0", "\u5B66\u90E8\uFF08\u9662\uFF09", "\u8054\u7CFB\u65B9\u5F0F"}) {
            Class[] columnTypes = new Class[]{Integer.class, String.class, String.class, Integer.class, String.class, String.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });
        teacherList.setViewportView(teacher_table);

        JScrollPane jwadminList = new JScrollPane();
        panel_listContainer.add(jwadminList, "name_1658533383004300");

        JTable jwadmin_table = new JTable();
        jwadmin_table.setModel(new DefaultTableModel(new Object[][]{{null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null},}, new String[]{"\u804C\u5DE5\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u8054\u7CFB\u65B9\u5F0F"}) {
            Class[] columnTypes = new Class[]{Integer.class, String.class, String.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });
        jwadminList.setViewportView(jwadmin_table);

        JButton btn_studentList_xtadmin = new JButton("学生列表");
        btn_studentList_xtadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btn_studentList_xtadmin.setBounds(10, 10, 91, 33);
        panel_user_xtadmin.add(btn_studentList_xtadmin);

        JButton btn_teacherList_xtadmin = new JButton("教师列表");
        btn_teacherList_xtadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btn_teacherList_xtadmin.setBounds(108, 10, 91, 33);
        panel_user_xtadmin.add(btn_teacherList_xtadmin);

        JButton btn_jwadminList_xtadmin = new JButton("教务列表");
        btn_jwadminList_xtadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btn_jwadminList_xtadmin.setBounds(205, 10, 91, 33);
        panel_user_xtadmin.add(btn_jwadminList_xtadmin);

        JLabel lblImg_xtadmin = new JLabel("头像");
        lblImg_xtadmin.setOpaque(true);
        lblImg_xtadmin.setHorizontalAlignment(SwingConstants.CENTER);
        lblImg_xtadmin.setBackground(Color.WHITE);
        lblImg_xtadmin.setBounds(10, 10, 110, 150);
        panel_homepage_xtadmin.add(lblImg_xtadmin);

        JLabel lblHello_xtadmin = new JLabel("XXX，你好！");
        lblHello_xtadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblHello_xtadmin.setBounds(149, 10, 365, 35);
        panel_homepage_xtadmin.add(lblHello_xtadmin);

        JLabel lblId_xtadmin = new JLabel("职工号：");
        lblId_xtadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblId_xtadmin.setBounds(149, 55, 69, 24);
        panel_homepage_xtadmin.add(lblId_xtadmin);

        JLabel lblId_present_xtadmin = new JLabel("20110203");
        lblId_present_xtadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblId_present_xtadmin.setBounds(219, 55, 88, 24);
        panel_homepage_xtadmin.add(lblId_present_xtadmin);

        JLabel lblGender_xtadmin = new JLabel("性别：");
        lblGender_xtadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblGender_xtadmin.setBounds(149, 89, 69, 24);
        panel_homepage_xtadmin.add(lblGender_xtadmin);

        JLabel lblGender_present_xtadmin = new JLabel("男");
        lblGender_present_xtadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblGender_present_xtadmin.setBounds(219, 89, 88, 24);
        panel_homepage_xtadmin.add(lblGender_present_xtadmin);

        ActionListener actionlistenerXtadmin = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(btnHomePage_xtadmin)) {
                    panel_container_xtadmin.removeAll();
                    panel_container_xtadmin.add(panel_homepage_xtadmin);
                    panel_container_xtadmin.validate();
                    panel_container_xtadmin.repaint();
                    System.out.println("主页");
                    panel_homepage_xtadmin.setVisible(true);

                } else if (e.getSource().equals(btnApprovalManagement_xtadmin)) {
                    panel_container_xtadmin.removeAll();
                    panel_container_xtadmin.add(panel_approval_xtadmin);
                    panel_container_xtadmin.validate();
                    panel_container_xtadmin.repaint();
                    System.out.println("审批管理");
                    panel_approval_xtadmin.setVisible(true);

                } else if (e.getSource().equals(btnUserManagement_xtadmin)) {
                    panel_container_xtadmin.removeAll();
                    panel_container_xtadmin.add(panel_user_xtadmin);
                    panel_container_xtadmin.validate();
                    panel_container_xtadmin.repaint();
                    System.out.println("用户管理");
                    panel_user_xtadmin.setVisible(true);

                } else if (e.getSource().equals(btnUserInfoManagemment_xtadmin)) {
                    panel_container_xtadmin.removeAll();
                    panel_container_xtadmin.add(panel_selfinfo_xtadmin);
                    panel_container_xtadmin.validate();
                    panel_container_xtadmin.repaint();
                    System.out.println("个人信息管理");
                    panel_selfinfo_xtadmin.setVisible(true);

                } else if (e.getSource().equals(btnAbout_xtadmin)) {
                    panel_container_xtadmin.removeAll();
                    panel_container_xtadmin.add(panel_about_xtadmin);
                    panel_container_xtadmin.validate();
                    panel_container_xtadmin.repaint();
                    System.out.println("关于");
                    panel_about_xtadmin.setVisible(true);
                }
            }
        };

        btnHomePage_xtadmin.addActionListener(actionlistenerXtadmin);
        btnApprovalManagement_xtadmin.addActionListener(actionlistenerXtadmin);
        btnUserManagement_xtadmin.addActionListener(actionlistenerXtadmin);
        btnUserInfoManagemment_xtadmin.addActionListener(actionlistenerXtadmin);
        btnAbout_xtadmin.addActionListener(actionlistenerXtadmin);

        ActionListener actionListenerXtadmin_user = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(btn_studentList_xtadmin)) {
                    panel_listContainer.removeAll();
                    panel_listContainer.add(studentList);
                    panel_listContainer.validate();
                    panel_listContainer.repaint();
                    System.out.println("学生列表");
                    studentList.setVisible(true);

                } else if (e.getSource().equals(btn_teacherList_xtadmin)) {
                    panel_listContainer.removeAll();
                    panel_listContainer.add(teacherList);
                    panel_listContainer.validate();
                    panel_listContainer.repaint();
                    System.out.println("教师列表");
                    teacherList.setVisible(true);

                } else if (e.getSource().equals(btn_jwadminList_xtadmin)) {
                    panel_listContainer.removeAll();
                    panel_listContainer.add(jwadminList);
                    panel_listContainer.validate();
                    panel_listContainer.repaint();
                    System.out.println("教务列表");
                    jwadminList.setVisible(true);

                }
            }

        };
        btn_studentList_xtadmin.addActionListener(actionListenerXtadmin_user);
        btn_teacherList_xtadmin.addActionListener(actionListenerXtadmin_user);
        btn_jwadminList_xtadmin.addActionListener(actionListenerXtadmin_user);
    }

}
