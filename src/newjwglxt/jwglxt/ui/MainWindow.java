package newjwglxt.jwglxt.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainWindow extends JFrame {
    // TODO ui

    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;

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
        contentPane.setLayout(new CardLayout(0, 0));

        JPanel login = new JPanel();
        login.setBackground(new Color(255, 255, 255));
        contentPane.add(login, "name_601797172477500");
        login.setLayout(null);

        JLabel lblNewLabel = new JLabel("一张图片");
        lblNewLabel.setOpaque(true);
        lblNewLabel.setBackground(new Color(224, 255, 255));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(0, 0, 515, 471);
        login.add(lblNewLabel);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(255, 255, 255));
        panel_2.setBounds(525, 0, 204, 471);
        login.add(panel_2);
        panel_2.setLayout(null);

        JPanel panel_3 = new JPanel();
        panel_3.setBounds(10, 74, 184, 321);
        panel_3.setBackground(new Color(255, 255, 255));
        panel_2.add(panel_3);
        panel_3.setLayout(null);

        JPanel panel_4 = new JPanel();
        panel_4.setBounds(0, 40, 184, 219);
        panel_4.setBackground(UIManager.getColor("Button.background"));
        panel_3.add(panel_4);
        panel_4.setLayout(null);

        JLabel lblNewLabel_2 = new JLabel("账号");
        lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_2.setBounds(10, 53, 54, 15);
        panel_4.add(lblNewLabel_2);

        textField = new JTextField();
        textField.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField.setBounds(10, 75, 164, 24);
        panel_4.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_2_1 = new JLabel("密码");
        lblNewLabel_2_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_2_1.setBounds(10, 118, 54, 15);
        panel_4.add(lblNewLabel_2_1);

        passwordField = new JPasswordField();
        passwordField.setBounds(10, 140, 164, 24);
        panel_4.add(passwordField);

        JButton btnNewButton = new JButton("登录");
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(50, 205, 50));
        btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 13));
        btnNewButton.setBounds(10, 180, 164, 24);
        panel_4.add(btnNewButton);

        JLabel lblNewLabel_1 = new JLabel("教务管理系统");
        lblNewLabel_1.setBounds(0, 0, 184, 40);
        panel_4.add(lblNewLabel_1);
        lblNewLabel_1.setOpaque(true);
        lblNewLabel_1.setBackground(new Color(255, 255, 255));
        lblNewLabel_1.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lblNewLabel_1.setPreferredSize(new Dimension(54, 40));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel student = new JPanel();
        student.setOpaque(false);
        contentPane.add(student, "name_601806090402700");
        student.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(10, 10, 150, 451);
        student.add(panel);
        panel.setLayout(null);

        JButton btnNewButton_1 = new JButton("主页");
        btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnNewButton_1.setBounds(10, 10, 130, 35);
        panel.add(btnNewButton_1);

        JButton btnNewButton_1_1 = new JButton("我的课程");
        btnNewButton_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnNewButton_1_1.setBounds(10, 55, 130, 35);
        panel.add(btnNewButton_1_1);

        JButton btnNewButton_1_2 = new JButton("主页");
        btnNewButton_1_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnNewButton_1_2.setBounds(10, 100, 130, 35);
        panel.add(btnNewButton_1_2);

        JButton btnNewButton_1_3 = new JButton("主页");
        btnNewButton_1_3.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnNewButton_1_3.setBounds(10, 145, 130, 35);
        panel.add(btnNewButton_1_3);

        JButton btnNewButton_1_4 = new JButton("主页");
        btnNewButton_1_4.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnNewButton_1_4.setBounds(10, 190, 130, 35);
        panel.add(btnNewButton_1_4);

        JButton btnNewButton_2 = new JButton("关于");
        btnNewButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnNewButton_2.setBounds(10, 406, 130, 35);
        panel.add(btnNewButton_2);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(170, 10, 549, 451);
        student.add(panel_1);
        panel_1.setLayout(new CardLayout(0, 0));

        JPanel home = new JPanel();
        panel_1.add(home, "name_610705678948800");
        home.setLayout(null);

        JLabel lblNewLabel_3 = new JLabel("头像");
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setOpaque(true);
        lblNewLabel_3.setBackground(Color.WHITE);
        lblNewLabel_3.setBounds(10, 10, 110, 150);
        home.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("XXX，你好！");
        lblNewLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_4.setBounds(149, 10, 365, 35);
        home.add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("学号：");
        lblNewLabel_5.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_5.setBounds(149, 55, 69, 24);
        home.add(lblNewLabel_5);

        JLabel lblNewLabel_5_1 = new JLabel("20110203");
        lblNewLabel_5_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_5_1.setBounds(219, 55, 88, 24);
        home.add(lblNewLabel_5_1);

        JLabel lblNewLabel_5_2 = new JLabel("学部（院）：");
        lblNewLabel_5_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_5_2.setBounds(317, 55, 78, 24);
        home.add(lblNewLabel_5_2);

        JLabel lblNewLabel_5_3 = new JLabel("经济与管理学院");
        lblNewLabel_5_3.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_5_3.setBounds(400, 55, 134, 24);
        home.add(lblNewLabel_5_3);

        JLabel lblNewLabel_5_4 = new JLabel("性别：");
        lblNewLabel_5_4.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_5_4.setBounds(149, 89, 69, 24);
        home.add(lblNewLabel_5_4);

        JLabel lblNewLabel_5_1_1 = new JLabel("男");
        lblNewLabel_5_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_5_1_1.setBounds(219, 89, 88, 24);
        home.add(lblNewLabel_5_1_1);

        JLabel lblNewLabel_5_2_1 = new JLabel("专业：");
        lblNewLabel_5_2_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_5_2_1.setBounds(317, 89, 78, 24);
        home.add(lblNewLabel_5_2_1);

        JLabel lblNewLabel_5_3_1 = new JLabel("信息管理与信息系统");
        lblNewLabel_5_3_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_5_3_1.setBounds(400, 89, 134, 24);
        home.add(lblNewLabel_5_3_1);

        JLabel lblNewLabel_5_4_1 = new JLabel("入学年份：");
        lblNewLabel_5_4_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_5_4_1.setBounds(149, 123, 69, 24);
        home.add(lblNewLabel_5_4_1);

        JLabel lblNewLabel_5_1_1_1 = new JLabel("2020");
        lblNewLabel_5_1_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_5_1_1_1.setBounds(219, 123, 88, 24);
        home.add(lblNewLabel_5_1_1_1);

        JLabel lblNewLabel_5_2_1_1 = new JLabel("行政班：");
        lblNewLabel_5_2_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_5_2_1_1.setBounds(317, 123, 78, 24);
        home.add(lblNewLabel_5_2_1_1);

        JLabel lblNewLabel_5_3_1_1 = new JLabel("201102");
        lblNewLabel_5_3_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_5_3_1_1.setBounds(400, 123, 134, 24);
        home.add(lblNewLabel_5_3_1_1);

        JPanel panel_6 = new JPanel();
        panel_1.add(panel_6, "name_610718268602000");
        panel_6.setLayout(null);

        JButton btnNewButton_3 = new JButton("课表");
        btnNewButton_3.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnNewButton_3.setBounds(10, 10, 130, 35);
        panel_6.add(btnNewButton_3);

        JButton btnNewButton_3_1 = new JButton("自主选课");
        btnNewButton_3_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnNewButton_3_1.setBounds(150, 10, 130, 35);
        panel_6.add(btnNewButton_3_1);

        JPanel panel_7 = new JPanel();
        panel_1.add(panel_7, "name_610720492995100");

        JPanel panel_8 = new JPanel();
        panel_1.add(panel_8, "name_610722426758000");

        JPanel panel_9 = new JPanel();
        panel_1.add(panel_9, "name_610724537767700");

        JPanel teacher = new JPanel();
        teacher.setLayout(null);
        teacher.setOpaque(false);
        contentPane.add(teacher, "name_611220147161800");

        JPanel panel_5 = new JPanel();
        panel_5.setLayout(null);
        panel_5.setBounds(10, 10, 150, 451);
        teacher.add(panel_5);

        JButton btnNewButton_1_5 = new JButton("主页");
        btnNewButton_1_5.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnNewButton_1_5.setBounds(10, 10, 130, 35);
        panel_5.add(btnNewButton_1_5);

        JButton btnNewButton_1_1_1 = new JButton("课程管理");
        btnNewButton_1_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnNewButton_1_1_1.setBounds(10, 55, 130, 35);
        panel_5.add(btnNewButton_1_1_1);

        JButton btnNewButton_1_2_1 = new JButton("主页");
        btnNewButton_1_2_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnNewButton_1_2_1.setBounds(10, 100, 130, 35);
        panel_5.add(btnNewButton_1_2_1);

        JButton btnNewButton_1_3_1 = new JButton("主页");
        btnNewButton_1_3_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnNewButton_1_3_1.setBounds(10, 145, 130, 35);
        panel_5.add(btnNewButton_1_3_1);

        JButton btnNewButton_1_4_1 = new JButton("主页");
        btnNewButton_1_4_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnNewButton_1_4_1.setBounds(10, 190, 130, 35);
        panel_5.add(btnNewButton_1_4_1);

        JButton btnNewButton_2_1 = new JButton("关于");
        btnNewButton_2_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnNewButton_2_1.setBounds(10, 406, 130, 35);
        panel_5.add(btnNewButton_2_1);

        JPanel panel_1_1 = new JPanel();
        panel_1_1.setBounds(170, 10, 524, 451);
        teacher.add(panel_1_1);
        panel_1_1.setLayout(new CardLayout(0, 0));

        JPanel jwadmin = new JPanel();
        jwadmin.setLayout(null);
        jwadmin.setOpaque(false);
        contentPane.add(jwadmin, "name_611224359007700");

        JPanel panel_10 = new JPanel();
        panel_10.setLayout(null);
        panel_10.setBounds(10, 10, 150, 451);
        jwadmin.add(panel_10);

        JButton btnNewButton_1_6 = new JButton("主页");
        btnNewButton_1_6.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnNewButton_1_6.setBounds(10, 10, 130, 35);
        panel_10.add(btnNewButton_1_6);

        JButton btnNewButton_1_1_2 = new JButton("课程管理");
        btnNewButton_1_1_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnNewButton_1_1_2.setBounds(10, 55, 130, 35);
        panel_10.add(btnNewButton_1_1_2);

        JButton btnNewButton_1_2_2 = new JButton("主页");
        btnNewButton_1_2_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnNewButton_1_2_2.setBounds(10, 100, 130, 35);
        panel_10.add(btnNewButton_1_2_2);

        JButton btnNewButton_1_3_2 = new JButton("主页");
        btnNewButton_1_3_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnNewButton_1_3_2.setBounds(10, 145, 130, 35);
        panel_10.add(btnNewButton_1_3_2);

        JButton btnNewButton_1_4_2 = new JButton("主页");
        btnNewButton_1_4_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnNewButton_1_4_2.setBounds(10, 190, 130, 35);
        panel_10.add(btnNewButton_1_4_2);

        JButton btnNewButton_2_2 = new JButton("关于");
        btnNewButton_2_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnNewButton_2_2.setBounds(10, 406, 130, 35);
        panel_10.add(btnNewButton_2_2);

        JPanel panel_1_2 = new JPanel();
        panel_1_2.setBounds(170, 10, 524, 451);
        jwadmin.add(panel_1_2);
        panel_1_2.setLayout(new CardLayout(0, 0));

        JPanel xtadmin = new JPanel();
        xtadmin.setLayout(null);
        xtadmin.setOpaque(false);
        contentPane.add(xtadmin, "name_611226331268200");

        JPanel panel_11 = new JPanel();
        panel_11.setLayout(null);
        panel_11.setBounds(10, 10, 150, 451);
        xtadmin.add(panel_11);

        JButton btnNewButton_1_7 = new JButton("主页");
        btnNewButton_1_7.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnNewButton_1_7.setBounds(10, 10, 130, 35);
        panel_11.add(btnNewButton_1_7);

        JButton btnNewButton_1_1_3 = new JButton("课程管理");
        btnNewButton_1_1_3.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnNewButton_1_1_3.setBounds(10, 55, 130, 35);
        panel_11.add(btnNewButton_1_1_3);

        JButton btnNewButton_1_2_3 = new JButton("主页");
        btnNewButton_1_2_3.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnNewButton_1_2_3.setBounds(10, 100, 130, 35);
        panel_11.add(btnNewButton_1_2_3);

        JButton btnNewButton_1_3_3 = new JButton("主页");
        btnNewButton_1_3_3.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnNewButton_1_3_3.setBounds(10, 145, 130, 35);
        panel_11.add(btnNewButton_1_3_3);

        JButton btnNewButton_1_4_3 = new JButton("主页");
        btnNewButton_1_4_3.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnNewButton_1_4_3.setBounds(10, 190, 130, 35);
        panel_11.add(btnNewButton_1_4_3);

        JButton btnNewButton_2_3 = new JButton("关于");
        btnNewButton_2_3.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnNewButton_2_3.setBounds(10, 406, 130, 35);
        panel_11.add(btnNewButton_2_3);

        JPanel panel_1_3 = new JPanel();
        panel_1_3.setBounds(170, 10, 524, 451);
        xtadmin.add(panel_1_3);
        panel_1_3.setLayout(new CardLayout(0, 0));
    }
}
