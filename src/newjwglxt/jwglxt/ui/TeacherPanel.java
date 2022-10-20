package newjwglxt.jwglxt.ui;

import newjwglxt.jwglxt.entity.Teacher;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class TeacherPanel {
    protected JPanel teacher;

    public JPanel getPanel() {
        return teacher;
    }

    public TeacherPanel(Connection connection, Teacher teacher_login) {
        teacher = new JPanel();
        teacher.setLayout(null);
        teacher.setOpaque(false);
        MainWindow.contentPane.add(teacher, "name_611220147161800");

        // teacher左侧边栏
        JPanel panel_category_teacher = new JPanel();
        panel_category_teacher.setLayout(null);
        panel_category_teacher.setBounds(10, 10, 150, 451);
        teacher.add(panel_category_teacher);

        JButton btnHomePage_teacher = new JButton("主页");
        btnHomePage_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnHomePage_teacher.setBounds(10, 10, 130, 35);
        panel_category_teacher.add(btnHomePage_teacher);

        JButton btnCoursemanage_teacher = new JButton("我的课程");
        btnCoursemanage_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnCoursemanage_teacher.setBounds(10, 55, 130, 35);
        panel_category_teacher.add(btnCoursemanage_teacher);

        JButton btnUnknown4 = new JButton("成绩管理");
        btnUnknown4.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnUnknown4.setBounds(10, 100, 130, 35);
        panel_category_teacher.add(btnUnknown4);

        JButton btnAbout_1 = new JButton("关于");
        btnAbout_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnAbout_1.setBounds(10, 406, 130, 35);
        panel_category_teacher.add(btnAbout_1);

        // teacher右侧内容区
        JPanel panel_container_teacher = new JPanel();
        panel_container_teacher.setBounds(170, 10, 553, 451);
        teacher.add(panel_container_teacher);
        panel_container_teacher.setLayout(new CardLayout(0, 0));

        // teacher右侧内容区 -> 主页
        JPanel panel_homePage_teacher = new JPanel();
        panel_container_teacher.add(panel_homePage_teacher, "name_226288810767900");
        panel_homePage_teacher.setLayout(null);

        JButton btnExit_teacher = new JButton("更换账号");
        btnExit_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnExit_teacher.setBounds(443, 56, 100, 33);
        panel_homePage_teacher.add(btnExit_teacher);

        JLabel lblImg_teacher = new JLabel("头像");
        lblImg_teacher.setOpaque(true);
        lblImg_teacher.setHorizontalAlignment(SwingConstants.CENTER);
        lblImg_teacher.setBackground(Color.WHITE);
        lblImg_teacher.setBounds(10, 56, 110, 150);
        panel_homePage_teacher.add(lblImg_teacher);

        JLabel lblHello_teacher = new JLabel("XXX，你好！");
        lblHello_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblHello_teacher.setBounds(149, 56, 365, 35);
        panel_homePage_teacher.add(lblHello_teacher);

        JLabel lblTid_teacher = new JLabel("教职工号：");
        lblTid_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblTid_teacher.setBounds(149, 101, 69, 24);
        panel_homePage_teacher.add(lblTid_teacher);

        JLabel lblTid_present_teacher = new JLabel("20110203");
        lblTid_present_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblTid_present_teacher.setBounds(219, 101, 88, 24);
        panel_homePage_teacher.add(lblTid_present_teacher);

        JLabel lblCollege_teacher = new JLabel("学部（院）：");
        lblCollege_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblCollege_teacher.setBounds(317, 101, 78, 24);
        panel_homePage_teacher.add(lblCollege_teacher);

        JLabel lblCollege_present_teacher = new JLabel("经济与管理学院");
        lblCollege_present_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblCollege_present_teacher.setBounds(400, 101, 134, 24);
        panel_homePage_teacher.add(lblCollege_present_teacher);

        JLabel lblGender_teacher = new JLabel("性别：");
        lblGender_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblGender_teacher.setBounds(149, 135, 69, 24);
        panel_homePage_teacher.add(lblGender_teacher);

        JLabel lblGender_present_teacher = new JLabel("男");
        lblGender_present_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblGender_present_teacher.setBounds(219, 135, 88, 24);
        panel_homePage_teacher.add(lblGender_present_teacher);

        JLabel lblFirstYear_teacher = new JLabel("入职年份：");
        lblFirstYear_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblFirstYear_teacher.setBounds(149, 169, 69, 24);
        panel_homePage_teacher.add(lblFirstYear_teacher);

        JLabel lblFirstYear_present_teacher = new JLabel("2020");
        lblFirstYear_present_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblFirstYear_present_teacher.setBounds(219, 169, 88, 24);
        panel_homePage_teacher.add(lblFirstYear_present_teacher);

        JLabel lblTitle_teacher = new JLabel("职称：");
        lblTitle_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblTitle_teacher.setBounds(317, 135, 78, 24);
        panel_homePage_teacher.add(lblTitle_teacher);

        JLabel lblTitle_present_teacher = new JLabel("国家主席&国家军委主席");
        lblTitle_present_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblTitle_present_teacher.setBounds(376, 135, 167, 24);
        panel_homePage_teacher.add(lblTitle_present_teacher);

        // teacher右侧内容区 -> 主页 -> 标题区
        JPanel panel_title_zhuye_teacher = new JPanel();
        panel_title_zhuye_teacher.setLayout(null);
        panel_title_zhuye_teacher.setForeground(SystemColor.activeCaption);
        panel_title_zhuye_teacher.setBackground(SystemColor.scrollbar);
        panel_title_zhuye_teacher.setBounds(0, 0, 553, 46);
        panel_homePage_teacher.add(panel_title_zhuye_teacher);

        JLabel lblNewLabel_8_9 = new JLabel("主页");
        lblNewLabel_8_9.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lblNewLabel_8_9.setBounds(10, 10, 64, 22);
        panel_title_zhuye_teacher.add(lblNewLabel_8_9);

        // teacher右侧内容区 -> 我的课程
        JPanel panel_Coursemanage_teacher = new JPanel();
        panel_container_teacher.add(panel_Coursemanage_teacher, "name_225549232417500");
        panel_Coursemanage_teacher.setLayout(null);

        // teacher右侧内容区 -> 我的课程 -> 标题区
        JPanel panel_title_wodekecheng_teacher = new JPanel();
        panel_title_wodekecheng_teacher.setLayout(null);
        panel_title_wodekecheng_teacher.setForeground(SystemColor.activeCaption);
        panel_title_wodekecheng_teacher.setBackground(SystemColor.scrollbar);
        panel_title_wodekecheng_teacher.setBounds(0, 0, 553, 46);
        panel_Coursemanage_teacher.add(panel_title_wodekecheng_teacher);

        JLabel lbl_wodekecheng_teacher = new JLabel("我的课程");
        lbl_wodekecheng_teacher.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lbl_wodekecheng_teacher.setBounds(10, 10, 64, 22);
        panel_title_wodekecheng_teacher.add(lbl_wodekecheng_teacher);

        // teacher右侧内容区 -> 我的课程 -> 表格区
        JScrollPane scrollPane_3 = new JScrollPane();
        scrollPane_3.setBounds(10, 56, 533, 385);
        panel_Coursemanage_teacher.add(scrollPane_3);

        JTable table_3 = new JTable();
        table_3.setModel(new DefaultTableModel(new Object[][]{{null, null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null, null},}, new String[]{"\u8BFE\u7A0B\u7F16\u53F7", "\u8BFE\u7A0B\u540D\u79F0", "\u5F00\u8BFE\u90E8\u95E8", "\u5B66\u5206", "\u8BFE\u7A0B\u7C7B\u522B", "\u6559\u5BA4", "\u65F6\u95F4", "\u62A5\u540D\u4EBA\u6570", "\u6700\u5927\u4EBA\u6570"}));
        scrollPane_3.setViewportView(table_3);

        // teacher右侧内容区 -> 成绩管理
        JPanel panel_chengjiguanli_teacher = new JPanel();
        panel_container_teacher.add(panel_chengjiguanli_teacher, "name_225551826938200");
        panel_chengjiguanli_teacher.setLayout(null);

        JLabel lbl_xuanzekecheng_teacher = new JLabel("选择课程：");
        lbl_xuanzekecheng_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lbl_xuanzekecheng_teacher.setBounds(10, 56, 77, 34);
        panel_chengjiguanli_teacher.add(lbl_xuanzekecheng_teacher);

        JComboBox comboBox_3 = new JComboBox();
        comboBox_3.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBox_3.setBounds(84, 60, 145, 26);
        panel_chengjiguanli_teacher.add(comboBox_3);

        JButton btn_queren_teacher = new JButton("确认");
        btn_queren_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btn_queren_teacher.setBounds(443, 408, 100, 33);
        panel_chengjiguanli_teacher.add(btn_queren_teacher);

        // teacher右侧内容区 -> 成绩管理 -> 标题区
        JPanel panel_title_chengjiguanli_teacher = new JPanel();
        panel_title_chengjiguanli_teacher.setLayout(null);
        panel_title_chengjiguanli_teacher.setForeground(SystemColor.activeCaption);
        panel_title_chengjiguanli_teacher.setBackground(SystemColor.scrollbar);
        panel_title_chengjiguanli_teacher.setBounds(0, 0, 553, 46);
        panel_chengjiguanli_teacher.add(panel_title_chengjiguanli_teacher);

        JLabel lbl_chengjiguanli_teacher = new JLabel("成绩管理");
        lbl_chengjiguanli_teacher.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lbl_chengjiguanli_teacher.setBounds(10, 10, 64, 22);
        panel_title_chengjiguanli_teacher.add(lbl_chengjiguanli_teacher);

        // teacher右侧内容区 -> 成绩管理 -> 表格区
        JScrollPane scrollPane_4 = new JScrollPane();
        scrollPane_4.setBounds(10, 100, 533, 296);
        panel_chengjiguanli_teacher.add(scrollPane_4);

        JTable table_4 = new JTable();
        table_4.setModel(new DefaultTableModel(new Object[][]{{null, null, null}, {null, null, null}, {null, null, null}, {null, null, null}, {null, null, null}, {null, null, null}, {null, null, null}, {null, null, null}, {null, null, null}, {null, null, null}, {null, null, null}, {null, null, null}, {null, null, null}, {null, null, null}, {null, null, null},}, new String[]{"\u5B66\u53F7", "\u59D3\u540D", "\u6210\u7EE9"}));
        scrollPane_4.setViewportView(table_4);


        ActionListener actionlistenerTeacher = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(btnHomePage_teacher)) {
                    panel_container_teacher.removeAll();
                    panel_container_teacher.add(panel_homePage_teacher);
                    panel_container_teacher.validate();
                    panel_container_teacher.repaint();
                    System.out.println("1");
                    panel_homePage_teacher.setVisible(true);

                } else if (e.getSource().equals(btnCoursemanage_teacher)) {
                    panel_container_teacher.removeAll();
                    panel_container_teacher.add(panel_Coursemanage_teacher);
                    panel_container_teacher.validate();
                    panel_container_teacher.repaint();
                    System.out.println("2");
                    panel_Coursemanage_teacher.setVisible(true);

                } else if (e.getSource().equals(btnUnknown4)) {
                    panel_container_teacher.removeAll();
                    panel_container_teacher.add(panel_chengjiguanli_teacher);
                    panel_container_teacher.validate();
                    panel_container_teacher.repaint();
                    System.out.println("3");
                    panel_chengjiguanli_teacher.setVisible(true);
                }

            }
        };
        btnHomePage_teacher.addActionListener(actionlistenerTeacher);
        btnCoursemanage_teacher.addActionListener(actionlistenerTeacher);
        btnUnknown4.addActionListener(actionlistenerTeacher);

    }
}