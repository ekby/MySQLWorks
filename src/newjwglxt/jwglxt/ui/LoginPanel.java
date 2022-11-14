package newjwglxt.jwglxt.ui;

import newjwglxt.jwglxt.entity.Jwadmin;
import newjwglxt.jwglxt.entity.Student;
import newjwglxt.jwglxt.entity.Teacher;
import newjwglxt.jwglxt.entity.Xtadmin;
import newjwglxt.jwglxt.service.idx1.JwadminService;
import newjwglxt.jwglxt.service.idx1.StudentService;
import newjwglxt.jwglxt.service.idx1.TeacherService;
import newjwglxt.jwglxt.service.idx1.XtadminService;
import newjwglxt.jwglxt.util.DbConnector;
import newjwglxt.jwglxt.util.QuickButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import static newjwglxt.jwglxt.ui.MainWindow.contentPane;
import static newjwglxt.jwglxt.util.QuickButton.greenButton;
import static newjwglxt.jwglxt.util.SHA256.SHA256;

public class LoginPanel {
    private DbConnector dbConnector;
    private final JPanel login;

    public LoginPanel() {
        login = new JPanel();
        login.setBackground(new Color(255, 255, 255));
        contentPane.add(login, "name_601797172477500");
        login.setLayout(null);

        java.net.URL fileURL = this.getClass().getResource("/newjwglxt/jwglxt/util/Halland.png");
        assert fileURL != null;
        ImageIcon img = new ImageIcon(fileURL);
        Image image = img.getImage();
        image = image.getScaledInstance(515, 471, Image.SCALE_AREA_AVERAGING);
        img.setImage(image);
        JLabel LoginPicture = new JLabel(img);
        LoginPicture.setOpaque(true);
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
        LoginPanel_mid.setBounds(0, 100, 198, 233);
        LoginPanel.add(LoginPanel_mid);

        JLabel Label_login_account = new JLabel("账号");
        Label_login_account.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        Label_login_account.setBounds(10, 53, 54, 15);
        LoginPanel_mid.add(Label_login_account);

        JTextField textField_login_account = new JTextField();
        textField_login_account.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_login_account.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        textField_login_account.setColumns(10);
        textField_login_account.setBounds(10, 75, 178, 24);
        LoginPanel_mid.add(textField_login_account);

        JLabel Label_login_password = new JLabel("密码");
        Label_login_password.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        Label_login_password.setBounds(10, 123, 54, 15);
        LoginPanel_mid.add(Label_login_password);

        JPasswordField passwordField_login_password = new JPasswordField();
        passwordField_login_password.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        passwordField_login_password.setBounds(10, 145, 178, 24);
        LoginPanel_mid.add(passwordField_login_password);

        JButton btnLogin = greenButton("登录");
        btnLogin.setFont(new Font("微软雅黑", Font.BOLD, 14));
        btnLogin.setBounds(10, 195, 178, 24);
        LoginPanel_mid.add(btnLogin);

        JLabel Label_jwglxt_title = new JLabel("教务管理系统");
        Label_jwglxt_title.setOpaque(true);
        Label_jwglxt_title.setHorizontalAlignment(SwingConstants.CENTER);
        Label_jwglxt_title.setFont(new Font("微软雅黑", Font.BOLD, 18));
        Label_jwglxt_title.setBackground(Color.WHITE);
        Label_jwglxt_title.setBounds(0, 0, 198, 40);
        LoginPanel_mid.add(Label_jwglxt_title);

        JLabel login_reminder = new JLabel("登陆失败，没输用户名或密码");
        login_reminder.setBounds(12, 330, 198, 42);
        login_reminder.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        LoginPanel.add(login_reminder);
        login_reminder.setForeground(Color.red);
        login_reminder.setVisible(false);

        JLabel login_reminder_pw = new JLabel("登陆失败，用户名或密码错误");
        login_reminder_pw.setBounds(12, 330, 198, 42);
        LoginPanel.add(login_reminder_pw);
        login_reminder_pw.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        login_reminder_pw.setForeground(Color.red);
        login_reminder_pw.setVisible(false);

        // 登陆验证
        // 点击了登陆按钮再建立connection，否则挂在登陆界面就连接浪费资源。
        // getConnection()被移到了监听器的位置
//        Connection connection = db.getConnection();

        // 只输入用户名未输入密码报错
        ActionListener actionListenerLogin = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(btnLogin) || e.getSource().equals(textField_login_account) || e.getSource().equals(passwordField_login_password)) {
                    String accountText = textField_login_account.getText();
                    String passwordText_SHA256 = SHA256(String.valueOf(passwordField_login_password.getPassword()));

                    if (accountText.equals("") || String.valueOf(passwordField_login_password.getPassword()).equals("")) {
                        System.out.println("没输用户名或密码");
                        // 界面显示没输账号或密码
                        login_reminder_pw.setVisible(false);
                        login_reminder.setVisible(true);
                    } else {
                        System.out.println("输了密码");
                        if (accountText.length() == 3) {
                            dbConnector = new DbConnector();
                            System.out.println("xtadmin");
                            XtadminService xtadminService = new XtadminService();
                            Xtadmin xtadmin_login = xtadminService.LoginVerify(dbConnector, Integer.parseInt(accountText), passwordText_SHA256);
                            if (xtadmin_login != null) {
                                // 账号密码正确，登录到xtadmin的界面
                                contentPane.removeAll();
                                XtadminPanel xtadminPanel = new XtadminPanel(dbConnector, xtadmin_login);
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
                                dbConnector = new DbConnector();
                                System.out.println("jwadmin");
                                JwadminService jwadminService;
                                jwadminService = new JwadminService();
                                Jwadmin jwadmin_login = jwadminService.LoginVerify(dbConnector, Integer.parseInt(accountText), passwordText_SHA256);
                                if (jwadmin_login != null) {
                                    // 账号密码正确，登录到jwadmin的界面
                                    contentPane.removeAll();
                                    JwadminPanel jwadminPanel = new JwadminPanel(dbConnector, jwadmin_login);
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
                                dbConnector = new DbConnector();
                                System.out.println("teacher");
                                TeacherService teacherService = new TeacherService();
                                Teacher teacher_login = teacherService.LoginVerify(dbConnector, Integer.parseInt(accountText), passwordText_SHA256);
                                if (teacher_login != null) {
                                    // 账号密码正确，登录到teacher的界面
                                    contentPane.removeAll();
                                    TeacherPanel teacherPanel = new TeacherPanel(dbConnector, teacher_login);
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
                                dbConnector = new DbConnector();
                                System.out.println("student");
                                StudentService studentservice = new StudentService();
                                Student student_login = studentservice.LoginVerify(dbConnector, Integer.parseInt(accountText), passwordText_SHA256);
                                if (student_login != null) {
                                    // 账号密码正确，登录到student的界面
                                    contentPane.removeAll();
                                    StudentPanel studentPanel = new StudentPanel(dbConnector, student_login);
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
                        } else {
                            System.out.println("没有对应账户");
                            login_reminder.setVisible(false);
                            login_reminder_pw.setVisible(true);
                        }
                    }
                }
            }
        };
        btnLogin.addActionListener(actionListenerLogin);
        enterPressesWhenFocused(btnLogin);
        enterPressesWhenFocused(textField_login_account, actionListenerLogin);
        enterPressesWhenFocused(passwordField_login_password, actionListenerLogin);

    }

    public static void enterPressesWhenFocused(JButton button) {
        button.registerKeyboardAction(button.getActionForKeyStroke(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false)),
                KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false), JComponent.WHEN_FOCUSED);

        button.registerKeyboardAction(button.getActionForKeyStroke(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, true)),
                KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true), JComponent.WHEN_FOCUSED);

    }

    public static void enterPressesWhenFocused(JTextField textField, ActionListener actionListener) {
        textField.registerKeyboardAction(actionListener,
                KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false), JComponent.WHEN_FOCUSED);

        textField.registerKeyboardAction(actionListener,
                KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, true), JComponent.WHEN_FOCUSED);
    }

    public JPanel getPanel() {
        return login;
    }
}
