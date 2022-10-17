package newjwglxt.jwglxt.ui;

import newjwglxt.jwglxt.entity.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static newjwglxt.jwglxt.ui.MainWindow.contentPane;

public class StudentPanel {
    protected JPanel student;

    public JPanel getPanel() {
        return student;
    }

    public StudentPanel(Student student_login) {
        JPanel student = new JPanel();
        student.setOpaque(false);
        contentPane.add(student, "name_601806090402700");
        student.setLayout(null);

        JPanel panel_category_student = new JPanel();
        panel_category_student.setBounds(10, 10, 150, 451);
        student.add(panel_category_student);
        panel_category_student.setLayout(null);

        JButton btnHomePage_student = new JButton("主页");
        btnHomePage_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnHomePage_student.setBounds(10, 10, 130, 35);
        panel_category_student.add(btnHomePage_student);

        JButton btnMyCourse_student = new JButton("我的课程");
        btnMyCourse_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnMyCourse_student.setBounds(10, 55, 130, 35);
        panel_category_student.add(btnMyCourse_student);

        JButton btnUnknown1 = new JButton("unknown1");
        btnUnknown1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnUnknown1.setBounds(10, 100, 130, 35);
        panel_category_student.add(btnUnknown1);

        JButton btnUnknown2 = new JButton("unknown2");
        btnUnknown2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnUnknown2.setBounds(10, 145, 130, 35);
        panel_category_student.add(btnUnknown2);

        JButton btnUnknown3 = new JButton("unknown3");
        btnUnknown3.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnUnknown3.setBounds(10, 190, 130, 35);
        panel_category_student.add(btnUnknown3);

        JButton btnAbout = new JButton("关于");
        btnAbout.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnAbout.setBounds(10, 406, 130, 35);
        panel_category_student.add(btnAbout);

        JPanel panel_container_student = new JPanel();
        panel_container_student.setBounds(170, 10, 549, 451);
        student.add(panel_container_student);
        CardLayout cl_panel_container_student = new CardLayout();
        panel_container_student.setLayout(cl_panel_container_student);

        JPanel panel_homePage_student = new JPanel();
        panel_container_student.add(panel_homePage_student, "主页");
        panel_homePage_student.setLayout(null);

        JLabel lblImg_student = new JLabel("头像");
        lblImg_student.setHorizontalAlignment(SwingConstants.CENTER);
        lblImg_student.setOpaque(true);
        lblImg_student.setBackground(Color.WHITE);
        lblImg_student.setBounds(10, 56, 110, 150);
        panel_homePage_student.add(lblImg_student);

        JLabel lblHello_student = new JLabel("XXX，你好！");
        lblHello_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblHello_student.setBounds(149, 56, 365, 35);
        panel_homePage_student.add(lblHello_student);

        JLabel lblSid_student = new JLabel("学号：");
        lblSid_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblSid_student.setBounds(149, 101, 69, 24);
        panel_homePage_student.add(lblSid_student);

        JLabel lblSid_present_student = new JLabel("20110203");
        lblSid_present_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblSid_present_student.setBounds(219, 101, 88, 24);
        panel_homePage_student.add(lblSid_present_student);

        JLabel lblCollege_student = new JLabel("学部（院）：");
        lblCollege_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblCollege_student.setBounds(317, 101, 78, 24);
        panel_homePage_student.add(lblCollege_student);

        JLabel lblCollege_present_student = new JLabel("经济与管理学院");
        lblCollege_present_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblCollege_present_student.setBounds(400, 101, 134, 24);
        panel_homePage_student.add(lblCollege_present_student);

        JLabel lblGender_student = new JLabel("性别：");
        lblGender_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblGender_student.setBounds(149, 135, 69, 24);
        panel_homePage_student.add(lblGender_student);

        JLabel lblGender_present_student = new JLabel("男");
        lblGender_present_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblGender_present_student.setBounds(219, 135, 88, 24);
        panel_homePage_student.add(lblGender_present_student);

        JLabel lblMajor_student = new JLabel("专业：");
        lblMajor_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblMajor_student.setBounds(317, 135, 78, 24);
        panel_homePage_student.add(lblMajor_student);

        JLabel lblMajor_present_student = new JLabel("信息管理与信息系统");
        lblMajor_present_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblMajor_present_student.setBounds(400, 135, 134, 24);
        panel_homePage_student.add(lblMajor_present_student);

        JLabel lblFirstYear_student = new JLabel("入学年份：");
        lblFirstYear_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblFirstYear_student.setBounds(149, 169, 69, 24);
        panel_homePage_student.add(lblFirstYear_student);

        JLabel lblFirstYear_present_student = new JLabel("2020");
        lblFirstYear_present_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblFirstYear_present_student.setBounds(219, 169, 88, 24);
        panel_homePage_student.add(lblFirstYear_present_student);

        JLabel lblClasses_student = new JLabel("行政班：");
        lblClasses_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblClasses_student.setBounds(317, 169, 78, 24);
        panel_homePage_student.add(lblClasses_student);

        JLabel lblClasses_present_student = new JLabel("201102");
        lblClasses_present_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblClasses_present_student.setBounds(400, 169, 134, 24);
        panel_homePage_student.add(lblClasses_present_student);

        JPanel panel_5_4 = new JPanel();
        panel_5_4.setLayout(null);
        panel_5_4.setForeground(SystemColor.activeCaption);
        panel_5_4.setBackground(SystemColor.scrollbar);
        panel_5_4.setBounds(0, 0, 553, 46);
        panel_homePage_student.add(panel_5_4);

        JLabel lblNewLabel_8_4 = new JLabel("主页");
        lblNewLabel_8_4.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lblNewLabel_8_4.setBounds(10, 10, 64, 22);
        panel_5_4.add(lblNewLabel_8_4);

        JPanel panel_coursePage_student = new JPanel();
        panel_container_student.add(panel_coursePage_student, "我的课程");
        panel_coursePage_student.setLayout(null);

        JButton btnCourseTable = new JButton("课表");
        btnCourseTable.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnCourseTable.setBounds(10, 56, 100, 33);
        panel_coursePage_student.add(btnCourseTable);

        JButton btnChooseClass = new JButton("自主选课");
        btnChooseClass.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnChooseClass.setBounds(120, 56, 100, 33);
        panel_coursePage_student.add(btnChooseClass);

        JPanel panel_5_5 = new JPanel();
        panel_5_5.setLayout(null);
        panel_5_5.setForeground(SystemColor.activeCaption);
        panel_5_5.setBackground(SystemColor.scrollbar);
        panel_5_5.setBounds(0, 0, 553, 46);
        panel_coursePage_student.add(panel_5_5);

        JLabel lblNewLabel_8_5 = new JLabel("我的课程");
        lblNewLabel_8_5.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lblNewLabel_8_5.setBounds(10, 10, 64, 22);
        panel_5_5.add(lblNewLabel_8_5);

        JPanel unknown1 = new JPanel();
        panel_container_student.add(unknown1, "name_610720492995100");
        unknown1.setLayout(null);

        JPanel panel_5_6 = new JPanel();
        panel_5_6.setLayout(null);
        panel_5_6.setForeground(SystemColor.activeCaption);
        panel_5_6.setBackground(SystemColor.scrollbar);
        panel_5_6.setBounds(0, 0, 553, 46);
        unknown1.add(panel_5_6);

        JLabel lblNewLabel_8_6 = new JLabel("课程管理");
        lblNewLabel_8_6.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lblNewLabel_8_6.setBounds(10, 10, 64, 22);
        panel_5_6.add(lblNewLabel_8_6);

        JPanel unknown2 = new JPanel();
        panel_container_student.add(unknown2, "name_610722426758000");
        unknown2.setLayout(null);

        JPanel panel_5_7 = new JPanel();
        panel_5_7.setLayout(null);
        panel_5_7.setForeground(SystemColor.activeCaption);
        panel_5_7.setBackground(SystemColor.scrollbar);
        panel_5_7.setBounds(0, 0, 553, 46);
        unknown2.add(panel_5_7);

        JLabel lblNewLabel_8_7 = new JLabel("课程管理");
        lblNewLabel_8_7.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lblNewLabel_8_7.setBounds(10, 10, 64, 22);
        panel_5_7.add(lblNewLabel_8_7);

        JPanel unknown3 = new JPanel();
        panel_container_student.add(unknown3, "name_610724537767700");
        unknown3.setLayout(null);

        JPanel panel_5_8 = new JPanel();
        panel_5_8.setLayout(null);
        panel_5_8.setForeground(SystemColor.activeCaption);
        panel_5_8.setBackground(SystemColor.scrollbar);
        panel_5_8.setBounds(0, 0, 553, 46);
        unknown3.add(panel_5_8);

        JLabel lblNewLabel_8_8 = new JLabel("课程管理");
        lblNewLabel_8_8.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lblNewLabel_8_8.setBounds(10, 10, 64, 22);
        panel_5_8.add(lblNewLabel_8_8);

        ActionListener actionlistenerStudent = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(btnHomePage_student)) {
                    panel_container_student.removeAll();
                    panel_container_student.add(panel_homePage_student);
                    panel_container_student.validate();
                    panel_container_student.repaint();
                    System.out.println("1");
                    panel_homePage_student.setVisible(true);

                } else if (e.getSource().equals(btnMyCourse_student)) {
                    panel_container_student.removeAll();
                    panel_container_student.add(panel_coursePage_student);
                    panel_container_student.validate();
                    panel_container_student.repaint();
                    System.out.println("2");
                    panel_coursePage_student.setVisible(true);

                } else if (e.getSource().equals(btnUnknown1)) {
                    panel_container_student.removeAll();
                    panel_container_student.add(unknown1);
                    panel_container_student.validate();
                    panel_container_student.repaint();
                    System.out.println("3");
                    unknown1.setVisible(true);

                } else if (e.getSource().equals(btnUnknown2)) {
                    panel_container_student.removeAll();
                    panel_container_student.add(unknown2);
                    panel_container_student.validate();
                    panel_container_student.repaint();
                    System.out.println("4");
                    unknown2.setVisible(true);

                } else if (e.getSource().equals(btnUnknown3)) {
                    panel_container_student.removeAll();
                    panel_container_student.add(unknown3);
                    panel_container_student.validate();
                    panel_container_student.repaint();
                    System.out.println("5");
                    unknown3.setVisible(true);
                }
            }
        };

        btnHomePage_student.addActionListener(actionlistenerStudent);
        btnMyCourse_student.addActionListener(actionlistenerStudent);
        btnUnknown1.addActionListener(actionlistenerStudent);
        btnUnknown2.addActionListener(actionlistenerStudent);
        btnUnknown3.addActionListener(actionlistenerStudent);
    }

}
