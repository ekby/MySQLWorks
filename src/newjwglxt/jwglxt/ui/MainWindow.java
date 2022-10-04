package newjwglxt.jwglxt.ui;

import newjwglxt.jwglxt.service.idx1.JwadminService;
import newjwglxt.jwglxt.service.idx1.StudentService;
import newjwglxt.jwglxt.service.idx1.TeacherService;
import newjwglxt.jwglxt.service.idx1.XtadminService;
import newjwglxt.jwglxt.util.Db;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import static newjwglxt.jwglxt.util.SHA256.SHA256;


public class MainWindow extends JFrame {
    // TODO ui

    private JPanel contentPane;
    private JTable student_table;
    private JTable teacher_table;
    private JTable jwadmin_table;
    private JTextField textField_login_account;
    private JPasswordField passwordField_login_password;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainWindow frame = new MainWindow();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public MainWindow() {
        setTitle("教务管理系统");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 755, 520);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        CardLayout cdprime = new CardLayout();
        contentPane.setLayout(cdprime);

        /*以下是用户登录界面*/
        JPanel login = new JPanel();
        login.setBackground(new Color(255, 255, 255));
        contentPane.add(login, "name_601797172477500");
        login.setLayout(null);

        JLabel LoginPicture = new JLabel("一张图片");
        LoginPicture.setOpaque(true);
        LoginPicture.setBackground(new Color(224, 255, 255));
        LoginPicture.setHorizontalAlignment(SwingConstants.CENTER);
        LoginPicture.setBounds(0, 0, 515, 471);
        login.add(LoginPicture);

        JPanel LoginPanel = new JPanel();
        LoginPanel.setBackground(new Color(255, 255, 255));
        LoginPanel.setBounds(525, 0, 198, 471);
        login.add(LoginPanel);
        LoginPanel.setLayout(null);

        JPanel LoginPanel_mid = new JPanel();
        LoginPanel_mid.setLayout(null);
        LoginPanel_mid.setBackground(SystemColor.menu);
        LoginPanel_mid.setBounds(0, 112, 198, 219);
        LoginPanel.add(LoginPanel_mid);

        JLabel Label_login_account = new JLabel("账号");
        Label_login_account.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        Label_login_account.setBounds(10, 53, 54, 15);
        LoginPanel_mid.add(Label_login_account);

        textField_login_account = new JTextField();
        textField_login_account.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_login_account.setColumns(10);
        textField_login_account.setBounds(10, 75, 178, 24);
        LoginPanel_mid.add(textField_login_account);

        JLabel Label_login_password = new JLabel("密码");
        Label_login_password.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        Label_login_password.setBounds(10, 118, 54, 15);
        LoginPanel_mid.add(Label_login_password);

        passwordField_login_password = new JPasswordField();
        passwordField_login_password.setBounds(10, 140, 178, 24);
        LoginPanel_mid.add(passwordField_login_password);

        JButton btnLogin = new JButton("登录");
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFont(new Font("微软雅黑", Font.BOLD, 13));
        btnLogin.setBackground(new Color(50, 205, 50));
        btnLogin.setBounds(10, 180, 178, 24);
        LoginPanel_mid.add(btnLogin);

        JLabel Label_jwglxt_title = new JLabel("教务管理系统");
        Label_jwglxt_title.setPreferredSize(new Dimension(54, 40));
        Label_jwglxt_title.setOpaque(true);
        Label_jwglxt_title.setHorizontalAlignment(SwingConstants.CENTER);
        Label_jwglxt_title.setFont(new Font("微软雅黑", Font.BOLD, 16));
        Label_jwglxt_title.setBackground(Color.WHITE);
        Label_jwglxt_title.setBounds(0, 0, 198, 40);
        LoginPanel_mid.add(Label_jwglxt_title);


        /*以下是学生界面*/
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
        lblImg_student.setBounds(10, 10, 110, 150);
        panel_homePage_student.add(lblImg_student);

        JLabel lblHello_student = new JLabel("XXX，你好！");
        lblHello_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblHello_student.setBounds(149, 10, 365, 35);
        panel_homePage_student.add(lblHello_student);

        JLabel lblSid_student = new JLabel("学号：");
        lblSid_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblSid_student.setBounds(149, 55, 69, 24);
        panel_homePage_student.add(lblSid_student);

        JLabel lblSid_present_student = new JLabel("20110203");
        lblSid_present_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblSid_present_student.setBounds(219, 55, 88, 24);
        panel_homePage_student.add(lblSid_present_student);

        JLabel lblCollege_student = new JLabel("学部（院）：");
        lblCollege_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblCollege_student.setBounds(317, 55, 78, 24);
        panel_homePage_student.add(lblCollege_student);

        JLabel lblCollege_present_student = new JLabel("经济与管理学院");
        lblCollege_present_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblCollege_present_student.setBounds(400, 55, 134, 24);
        panel_homePage_student.add(lblCollege_present_student);

        JLabel lblGender_student = new JLabel("性别：");
        lblGender_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblGender_student.setBounds(149, 89, 69, 24);
        panel_homePage_student.add(lblGender_student);

        JLabel lblGender_present_student = new JLabel("男");
        lblGender_present_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblGender_present_student.setBounds(219, 89, 88, 24);
        panel_homePage_student.add(lblGender_present_student);

        JLabel lblMajor_student = new JLabel("专业：");
        lblMajor_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblMajor_student.setBounds(317, 89, 78, 24);
        panel_homePage_student.add(lblMajor_student);

        JLabel lblMajor_present_student = new JLabel("信息管理与信息系统");
        lblMajor_present_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblMajor_present_student.setBounds(400, 89, 134, 24);
        panel_homePage_student.add(lblMajor_present_student);

        JLabel lblFirstYear_student = new JLabel("入学年份：");
        lblFirstYear_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblFirstYear_student.setBounds(149, 123, 69, 24);
        panel_homePage_student.add(lblFirstYear_student);

        JLabel lblFirstYear_present_student = new JLabel("2020");
        lblFirstYear_present_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblFirstYear_present_student.setBounds(219, 123, 88, 24);
        panel_homePage_student.add(lblFirstYear_present_student);

        JLabel lblClasses_student = new JLabel("行政班：");
        lblClasses_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblClasses_student.setBounds(317, 123, 78, 24);
        panel_homePage_student.add(lblClasses_student);

        JLabel lblClasses_present_student = new JLabel("201102");
        lblClasses_present_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblClasses_present_student.setBounds(400, 123, 134, 24);
        panel_homePage_student.add(lblClasses_present_student);

        JPanel panel_coursePage_student = new JPanel();
        panel_container_student.add(panel_coursePage_student, "我的课程");
        panel_coursePage_student.setLayout(null);

        JButton btnCourseTable = new JButton("课表");
        btnCourseTable.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnCourseTable.setBounds(10, 10, 130, 35);
        panel_coursePage_student.add(btnCourseTable);

        JButton btnChooseClass = new JButton("自主选课");
        btnChooseClass.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnChooseClass.setBounds(150, 10, 130, 35);
        panel_coursePage_student.add(btnChooseClass);

        JPanel unknown1 = new JPanel();
        panel_container_student.add(unknown1, "name_610720492995100");

        JPanel unknown2 = new JPanel();
        panel_container_student.add(unknown2, "name_610722426758000");

        JPanel unknown3 = new JPanel();
        panel_container_student.add(unknown3, "name_610724537767700");


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


        /*以下是教师界面*/
        JPanel teacher = new JPanel();
        teacher.setLayout(null);
        teacher.setOpaque(false);
        contentPane.add(teacher, "name_611220147161800");

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

        JButton btnAbout_1 = new JButton("关于");
        btnAbout_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnAbout_1.setBounds(10, 406, 130, 35);
        panel_category_teacher.add(btnAbout_1);

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
                }
            }
        };

        btnHomePage_teacher.addActionListener(actionlistenerTeacher);
        btnCoursemanage_teacher.addActionListener(actionlistenerTeacher);
        btnUnknown4.addActionListener(actionlistenerTeacher);
        btnUnknown5.addActionListener(actionlistenerTeacher);
        btnUnknown6.addActionListener(actionlistenerTeacher);


        /*以下是教务管理员界面*/
        JPanel jwadmin = new JPanel();
        jwadmin.setLayout(null);
        jwadmin.setOpaque(false);
        contentPane.add(jwadmin, "name_611224359007700");

        JPanel panel_category_jwadmin = new JPanel();
        panel_category_jwadmin.setLayout(null);
        panel_category_jwadmin.setBounds(10, 10, 150, 451);
        jwadmin.add(panel_category_jwadmin);

        JButton btnHomPage_jwadmin = new JButton("主页");
        btnHomPage_jwadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnHomPage_jwadmin.setBounds(10, 10, 130, 35);
        panel_category_jwadmin.add(btnHomPage_jwadmin);

        JButton btnCoursemanae_jwadmin = new JButton("课程管理");
        btnCoursemanae_jwadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnCoursemanae_jwadmin.setBounds(10, 55, 130, 35);
        panel_category_jwadmin.add(btnCoursemanae_jwadmin);

        JButton btnUnknown7 = new JButton("主页");
        btnUnknown7.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnUnknown7.setBounds(10, 100, 130, 35);
        panel_category_jwadmin.add(btnUnknown7);

        JButton btnUnknown8 = new JButton("主页");
        btnUnknown8.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnUnknown8.setBounds(10, 145, 130, 35);
        panel_category_jwadmin.add(btnUnknown8);

        JButton btnUnknown9 = new JButton("主页");
        btnUnknown9.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnUnknown9.setBounds(10, 190, 130, 35);
        panel_category_jwadmin.add(btnUnknown9);

        JButton btnAbout_2 = new JButton("关于");
        btnAbout_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnAbout_2.setBounds(10, 406, 130, 35);
        panel_category_jwadmin.add(btnAbout_2);

        JPanel panel_container_jwadmin = new JPanel();
        panel_container_jwadmin.setBounds(170, 10, 524, 451);
        jwadmin.add(panel_container_jwadmin);
        panel_container_jwadmin.setLayout(new CardLayout(0, 0));


        /*以下是系统管理员界面*/
        JPanel xtadmin = new JPanel();
        xtadmin.setLayout(null);
        xtadmin.setOpaque(false);
        contentPane.add(xtadmin, "name_611226331268200");

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
        panel_container_xtadmin.add(panel_approval_xtadmin, "name_1655028076360800");

        JPanel panel_user_xtadmin = new JPanel();
        panel_container_xtadmin.add(panel_user_xtadmin, "name_1655059689581500");
        panel_user_xtadmin.setLayout(null);

        JPanel panel_listContainer = new JPanel();
        panel_listContainer.setBounds(10, 53, 533, 388);
        panel_user_xtadmin.add(panel_listContainer);
        panel_listContainer.setLayout(new CardLayout(0, 0));

        JScrollPane studentList = new JScrollPane();
        panel_listContainer.add(studentList, "name_1656773210897400");

        student_table = new JTable();
        student_table.setModel(new DefaultTableModel(new Object[][]{{null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null},}, new String[]{"\u5B66\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u5165\u5B66\u5E74\u4EFD", "\u4E13\u4E1A", "\u884C\u653F\u73ED", "\u5B66\u90E8\uFF08\u9662\uFF09", "\u8054\u7CFB\u65B9\u5F0F"}) {
            Class[] columnTypes = new Class[]{Integer.class, String.class, String.class, Integer.class, String.class, Integer.class, String.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });
        studentList.setViewportView(student_table);

        JScrollPane teacherList = new JScrollPane();
        panel_listContainer.add(teacherList, "name_1658528172865100");

        teacher_table = new JTable();
        teacher_table.setModel(new DefaultTableModel(new Object[][]{{null, null, null, null, null, null, null}, {null, null, null, null, null, null, null}, {null, null, null, null, null, null, null}, {null, null, null, null, null, null, null}, {null, null, null, null, null, null, null}, {null, null, null, null, null, null, null}, {null, null, null, null, null, null, null}, {null, null, null, null, null, null, null}, {null, null, null, null, null, null, null}, {null, null, null, null, null, null, null}, {null, null, null, null, null, null, null}, {null, null, null, null, null, null, null}, {null, null, null, null, null, null, null}, {null, null, null, null, null, null, null}, {null, null, null, null, null, null, null},}, new String[]{"\u6559\u5DE5\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u5165\u804C\u5E74", "\u804C\u79F0", "\u5B66\u90E8\uFF08\u9662\uFF09", "\u8054\u7CFB\u65B9\u5F0F"}) {
            Class[] columnTypes = new Class[]{Integer.class, String.class, String.class, Integer.class, String.class, String.class, String.class};

            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });
        teacherList.setViewportView(teacher_table);

        JScrollPane jwadminList = new JScrollPane();
        panel_listContainer.add(jwadminList, "name_1658533383004300");

        jwadmin_table = new JTable();
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

        Db db = new Db();
        Connection connection = db.getConnection();

        ActionListener actionListenerLogin = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(btnLogin)) {
                    String accountText = textField_login_account.getText();
                    String passwordText_SHA256 = SHA256(String.valueOf(passwordField_login_password.getPassword()));

                    if (accountText.equals("") || passwordText_SHA256.equals(SHA256(""))) {
                        System.out.println("美术密码");
                        // TODO 如果账户或密码为空则在界面提示
                    } else {
                        System.out.println("输了密码");
                        if (accountText.length() == 3) {
                            System.out.println("xtadmin");
                            XtadminService xtadminService = new XtadminService();
                            if (xtadminService.LoginVerify(connection, Integer.parseInt(accountText), passwordText_SHA256) != null) {
                                // 账号密码正确，登录到xtadmin的界面
                                contentPane.removeAll();
                                contentPane.add(xtadmin);
                                contentPane.validate();
                                contentPane.repaint();
                                xtadmin.setVisible(true);
                            } else {
                                // TODO 账号密码错误，在登陆界面提示
                            }
                        } else if (accountText.length() == 5) {
                            System.out.println("jinle5");
                            if (accountText.charAt(0) == '1') {
                                JwadminService jwadminService = new JwadminService();
                                if (jwadminService.LoginVerify(connection, Integer.parseInt(accountText), passwordText_SHA256) != null) {
                                    // 账号密码正确，登录到jwadmin的界面
                                    contentPane.removeAll();
                                    contentPane.add(jwadmin);
                                    contentPane.validate();
                                    contentPane.repaint();
                                    jwadmin.setVisible(true);
                                } else {
                                    // TODO 账号密码错误，在登陆界面提示
                                }
                            } else if (accountText.charAt(0) == '2') {
                                TeacherService teacherService = new TeacherService();
                                if (teacherService.LoginVerify(connection, Integer.parseInt(accountText), passwordText_SHA256) != null) {
                                    // 账号密码正确，登录到teacher的界面
                                    contentPane.removeAll();
                                    contentPane.add(teacher);
                                    contentPane.validate();
                                    contentPane.repaint();
                                    teacher.setVisible(true);
                                } else {
                                    // TODO 账号密码错误，在登陆界面提示
                                }
                            } else if (accountText.charAt(0) == '3') {
                                System.out.println("stu");
                                StudentService studentService = new StudentService();
                                if (studentService.LoginVerify(connection, Integer.parseInt(accountText), passwordText_SHA256) != null) {
                                    // 账号密码正确，登录到student的界面
                                    contentPane.removeAll();
                                    contentPane.add(student);
                                    contentPane.validate();
                                    contentPane.repaint();
                                    student.setVisible(true);
                                } else {
                                    // TODO 账号密码错误，在登陆界面提示
                                }
                            }
                        } else {
                            // TODO 账号密码错误，在登陆界面提示
                        }
                    }
                }
            }
        };
        btnLogin.addActionListener(actionListenerLogin);


        ActionListener actionlistenerXtadmin = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(btnHomePage_xtadmin)) {
                    panel_container_xtadmin.removeAll();
                    panel_container_xtadmin.add(panel_homepage_xtadmin);
                    panel_container_xtadmin.validate();
                    panel_container_xtadmin.repaint();
                    System.out.println("1");
                    panel_homepage_xtadmin.setVisible(true);

                } else if (e.getSource().equals(btnApprovalManagement_xtadmin)) {
                    panel_container_xtadmin.removeAll();
                    panel_container_xtadmin.add(panel_approval_xtadmin);
                    panel_container_xtadmin.validate();
                    panel_container_xtadmin.repaint();
                    System.out.println("2");
                    panel_approval_xtadmin.setVisible(true);

                } else if (e.getSource().equals(btnUserManagement_xtadmin)) {
                    panel_container_xtadmin.removeAll();
                    panel_container_xtadmin.add(panel_user_xtadmin);
                    panel_container_xtadmin.validate();
                    panel_container_xtadmin.repaint();
                    System.out.println("3");
                    panel_user_xtadmin.setVisible(true);

//              } else if(e.getSource().equals(btnUnknown5)) {
//              	panel_container_teacher.removeAll();
//                  panel_container_teacher.add(unknown5);
//                  panel_container_teacher.validate();
//                  panel_container_teacher.repaint();
//                  System.out.println("4");
//                  unknown5.setVisible(true);

                }
            }
        };

        btnHomePage_xtadmin.addActionListener(actionlistenerXtadmin);
        btnApprovalManagement_xtadmin.addActionListener(actionlistenerXtadmin);
        btnUserManagement_xtadmin.addActionListener(actionlistenerXtadmin);
    }
}
