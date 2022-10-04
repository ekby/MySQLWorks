package newjwglxt.jwglxt.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherPanel {
    protected JPanel teacher;

    public JPanel getPanel() {
        return teacher;
    }

    public TeacherPanel() {
        teacher = new JPanel();
        teacher.setLayout(null);
        teacher.setOpaque(false);
        MainWindow.contentPane.add(teacher, "name_611220147161800");

        JPanel panel_category_teacher = new JPanel();
        panel_category_teacher.setLayout(null);
        panel_category_teacher.setBounds(10, 10, 150, 451);
        teacher.add(panel_category_teacher);

        JButton btnHomePage_teacher = new JButton("主页");
        btnHomePage_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnHomePage_teacher.setBounds(10, 10, 130, 35);
        panel_category_teacher.add(btnHomePage_teacher);

        JButton btnCoursemanage_teacher = new JButton("课程管理");
        btnCoursemanage_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnCoursemanage_teacher.setBounds(10, 55, 130, 35);
        panel_category_teacher.add(btnCoursemanage_teacher);

        JButton btnUnknown4 = new JButton("Unknown4");
        btnUnknown4.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnUnknown4.setBounds(10, 100, 130, 35);
        panel_category_teacher.add(btnUnknown4);

        JButton btnUnknown5 = new JButton("Unknown5");
        btnUnknown5.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnUnknown5.setBounds(10, 145, 130, 35);
        panel_category_teacher.add(btnUnknown5);

        JButton btnUnknown6 = new JButton("Unknown6");
        btnUnknown6.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnUnknown6.setBounds(10, 190, 130, 35);
        panel_category_teacher.add(btnUnknown6);

        JButton btnAbout_teacher = new JButton("关于");
        btnAbout_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnAbout_teacher.setBounds(10, 406, 130, 35);
        panel_category_teacher.add(btnAbout_teacher);

        JPanel panel_container_teacher = new JPanel();
        panel_container_teacher.setBounds(170, 10, 553, 451);
        teacher.add(panel_container_teacher);
        panel_container_teacher.setLayout(new CardLayout(0, 0));

        JPanel panel_homePage_teacher = new JPanel();
        panel_container_teacher.add(panel_homePage_teacher, "name_226288810767900");
        panel_homePage_teacher.setLayout(null);

        JPanel panel_Coursemanage_teacher = new JPanel();
        panel_container_teacher.add(panel_Coursemanage_teacher, "name_225549232417500");
        panel_Coursemanage_teacher.setLayout(null);

        JPanel unknown4 = new JPanel();
        panel_container_teacher.add(unknown4, "name_225551826938200");

        JPanel unknown5 = new JPanel();
        panel_container_teacher.add(unknown5, "name_225553981683100");

        JPanel unknown6 = new JPanel();
        panel_container_teacher.add(unknown6, "name_225556005001600");

        JPanel panel_about_teacher = new JPanel();
        panel_container_teacher.add(panel_about_teacher, "关于");
        panel_about_teacher.setLayout(null);

        JLabel pat_about = new JLabel("只因(just beacuse)");
        pat_about.setBounds(84, 62, 103, 16);
        panel_about_teacher.add(pat_about);

        JLabel lblImg_teacher = new JLabel("头像");
        lblImg_teacher.setOpaque(true);
        lblImg_teacher.setHorizontalAlignment(SwingConstants.CENTER);
        lblImg_teacher.setBackground(Color.WHITE);
        lblImg_teacher.setBounds(10, 10, 110, 150);
        panel_homePage_teacher.add(lblImg_teacher);

        JLabel lblHello_teacher = new JLabel("XXX，你好！");
        lblHello_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblHello_teacher.setBounds(149, 10, 365, 35);
        panel_homePage_teacher.add(lblHello_teacher);

        JLabel lblTid_teacher = new JLabel("教职工号：");
        lblTid_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblTid_teacher.setBounds(149, 55, 69, 24);
        panel_homePage_teacher.add(lblTid_teacher);

        JLabel lblTid_present_teacher = new JLabel("20110203");
        lblTid_present_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblTid_present_teacher.setBounds(219, 55, 88, 24);
        panel_homePage_teacher.add(lblTid_present_teacher);

        JLabel lblCollege_teacher = new JLabel("学部（院）：");
        lblCollege_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblCollege_teacher.setBounds(317, 55, 78, 24);
        panel_homePage_teacher.add(lblCollege_teacher);

        JLabel lblCollege_present_teacher = new JLabel("经济与管理学院");
        lblCollege_present_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblCollege_present_teacher.setBounds(400, 55, 134, 24);
        panel_homePage_teacher.add(lblCollege_present_teacher);

        JLabel lblGender_teacher = new JLabel("性别：");
        lblGender_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblGender_teacher.setBounds(149, 89, 69, 24);
        panel_homePage_teacher.add(lblGender_teacher);

        JLabel lblGender_present_teacher = new JLabel("男");
        lblGender_present_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblGender_present_teacher.setBounds(219, 89, 88, 24);
        panel_homePage_teacher.add(lblGender_present_teacher);

        JLabel lblFirstYear_teacher = new JLabel("入职年份：");
        lblFirstYear_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblFirstYear_teacher.setBounds(149, 123, 69, 24);
        panel_homePage_teacher.add(lblFirstYear_teacher);

        JLabel lblFirstYear_present_teacher = new JLabel("2020");
        lblFirstYear_present_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblFirstYear_present_teacher.setBounds(219, 123, 88, 24);
        panel_homePage_teacher.add(lblFirstYear_present_teacher);

        JLabel lblTitle_teacher = new JLabel("职称：");
        lblTitle_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblTitle_teacher.setBounds(317, 89, 78, 24);
        panel_homePage_teacher.add(lblTitle_teacher);

        JLabel lblTitle_present_teacher = new JLabel("国家主席&国家军委主席");
        lblTitle_present_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblTitle_present_teacher.setBounds(376, 89, 167, 24);
        panel_homePage_teacher.add(lblTitle_present_teacher);

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
                    panel_container_teacher.add(unknown4);
                    panel_container_teacher.validate();
                    panel_container_teacher.repaint();
                    System.out.println("3");
                    unknown4.setVisible(true);

                } else if (e.getSource().equals(btnUnknown5)) {
                    panel_container_teacher.removeAll();
                    panel_container_teacher.add(unknown5);
                    panel_container_teacher.validate();
                    panel_container_teacher.repaint();
                    System.out.println("4");
                    unknown5.setVisible(true);

                } else if (e.getSource().equals(btnUnknown6)) {
                    panel_container_teacher.removeAll();
                    panel_container_teacher.add(unknown6);
                    panel_container_teacher.validate();
                    panel_container_teacher.repaint();
                    System.out.println("5");
                    unknown6.setVisible(true);

                } else if (e.getSource().equals(btnAbout_teacher)) {
                    panel_container_teacher.removeAll();
                    panel_container_teacher.add(panel_about_teacher);
                    panel_container_teacher.validate();
                    panel_container_teacher.repaint();
                    System.out.println("6");
                    panel_about_teacher.setVisible(true);
                }
            }
        };

        btnHomePage_teacher.addActionListener(actionlistenerTeacher);
        btnCoursemanage_teacher.addActionListener(actionlistenerTeacher);
        btnUnknown4.addActionListener(actionlistenerTeacher);
        btnUnknown5.addActionListener(actionlistenerTeacher);
        btnUnknown6.addActionListener(actionlistenerTeacher);
        btnAbout_teacher.addActionListener(actionlistenerTeacher);

    }
}
