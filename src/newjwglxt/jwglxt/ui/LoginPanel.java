package newjwglxt.jwglxt.ui;

import newjwglxt.jwglxt.entity.Jwadmin;
import newjwglxt.jwglxt.entity.Student;
import newjwglxt.jwglxt.entity.Teacher;
import newjwglxt.jwglxt.entity.Xtadmin;
import newjwglxt.jwglxt.service.idx1.JwadminService;
import newjwglxt.jwglxt.service.idx1.StudentService;
import newjwglxt.jwglxt.service.idx1.TeacherService;
import newjwglxt.jwglxt.service.idx1.XtadminService;
import newjwglxt.jwglxt.util.Db;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import static newjwglxt.jwglxt.ui.MainWindow.contentPane;
import static newjwglxt.jwglxt.util.SHA256.SHA256;

public class LoginPanel {
    public LoginPanel() {
    }

    public void show() {
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

        JTextField textField_login_account = new JTextField();
        textField_login_account.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_login_account.setColumns(10);
        textField_login_account.setBounds(10, 75, 178, 24);
        LoginPanel_mid.add(textField_login_account);

        JLabel Label_login_password = new JLabel("密码");
        Label_login_password.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        Label_login_password.setBounds(10, 118, 54, 15);
        LoginPanel_mid.add(Label_login_password);

        JPasswordField passwordField_login_password = new JPasswordField();
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

        JLabel login_reminder = new JLabel("登陆失败，没输用户名或密码");
        login_reminder.setBounds(20, 320, 198, 42);
        LoginPanel.add(login_reminder);
        login_reminder.setForeground(Color.red);
        login_reminder.setVisible(false);

        JLabel login_reminder_pw = new JLabel("登陆失败，用户名或密码非对");
        login_reminder_pw.setBounds(20, 320, 198, 42);
        LoginPanel.add(login_reminder_pw);
        login_reminder_pw.setForeground(Color.red);
        login_reminder_pw.setVisible(false);

        // 登陆验证
        Db db = new Db();
        Connection connection = db.getConnection();

        ActionListener actionListenerLogin = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(btnLogin)) {
                    String accountText = textField_login_account.getText();
                    String passwordText_SHA256 = SHA256(String.valueOf(passwordField_login_password.getPassword()));

                    if (accountText.equals("") || passwordText_SHA256.equals(SHA256(""))) {
                        System.out.println("没输用户名或密码");
                        // 界面显示没输账号或密码
                        login_reminder_pw.setVisible(false);
                        login_reminder.setVisible(true);
                    } else {
                        System.out.println("输了密码");
                        if (accountText.length() == 3) {
                            System.out.println("xtadmin");
                            XtadminService xtadminService = new XtadminService();
                            Xtadmin xtadmin_login = xtadminService.LoginVerify(connection, Integer.parseInt(accountText), passwordText_SHA256);
                            if (xtadmin_login != null) {
                                // 账号密码正确，登录到xtadmin的界面
                                contentPane.removeAll();
                                XtadminPanel xtadminPanel = new XtadminPanel(xtadmin_login);
                                contentPane.add(xtadminPanel.getPanel());
                                contentPane.validate();
                                contentPane.repaint();
                                xtadminPanel.getPanel().setVisible(true);
                            } else {
                                // 界面显示账号密码输入错误
                                login_reminder.setVisible(false);
                                login_reminder_pw.setVisible(true);
                            }
                        } else if (accountText.length() == 5) {
                            if (accountText.charAt(0) == '1') {
                                System.out.println("jwadmin");
                                JwadminService jwadminService;
                                jwadminService = new JwadminService();
                                Jwadmin jwadmin_login = jwadminService.LoginVerify(connection, Integer.parseInt(accountText), passwordText_SHA256);
                                if (jwadmin_login != null) {
                                    // 账号密码正确，登录到jwadmin的界面
                                    contentPane.removeAll();
                                    JwadminPanel jwadminPanel = new JwadminPanel(jwadmin_login);
                                    contentPane.add(jwadminPanel.getPanel());
                                    contentPane.validate();
                                    contentPane.repaint();
                                    jwadminPanel.getPanel().setVisible(true);
                                } else {
                                    // 界面显示账号密码输入错误
                                    login_reminder.setVisible(false);
                                    login_reminder_pw.setVisible(true);
                                }
                            } else if (accountText.charAt(0) == '2') {
                                System.out.println("teacher");
                                TeacherService teacherService = new TeacherService();
                                Teacher teacher_login = teacherService.LoginVerify(connection, Integer.parseInt(accountText), passwordText_SHA256);
                                if (teacher_login != null) {
                                    // 账号密码正确，登录到teacher的界面
                                    contentPane.removeAll();
                                    TeacherPanel teacherPanel = new TeacherPanel(teacher_login);
                                    contentPane.add(teacherPanel.getPanel());
                                    contentPane.validate();
                                    contentPane.repaint();
                                    teacherPanel.getPanel().setVisible(true);
                                } else {
                                    // 界面显示账号密码输入错误
                                    login_reminder.setVisible(false);
                                    login_reminder_pw.setVisible(true);
                                }
                            } else if (accountText.charAt(0) == '3') {
                                System.out.println("student");
                                StudentService studentservice = new StudentService();
                                Student student_login = studentservice.LoginVerify(connection, Integer.parseInt(accountText), passwordText_SHA256);
                                if (student_login != null) {
                                    // 账号密码正确，登录到student的界面
                                    contentPane.removeAll();
                                    StudentPanel studentPanel = new StudentPanel(student_login);
                                    contentPane.add(studentPanel.getPanel());
                                    contentPane.validate();
                                    contentPane.repaint();
                                    studentPanel.getPanel().setVisible(true);
                                } else {
                                    // 界面显示账号密码输入错误
                                    login_reminder.setVisible(false);
                                    login_reminder_pw.setVisible(true);
                                }
                            }
                        }
                    }
                }
            }
        };
        btnLogin.addActionListener(actionListenerLogin);
    }
}
