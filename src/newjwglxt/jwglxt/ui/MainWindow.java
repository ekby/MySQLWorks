package newjwglxt.jwglxt.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainWindow extends JFrame {
    // TODO ui

    protected static JPanel contentPane;
//    private JTable student_table;
//    private JTable teacher_table;
//    private JTable jwadmin_table;
//    private JTextField textField_login_account;
//    private JPasswordField passwordField_login_password;

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

        LoginPanel loginPanel = new LoginPanel();
        loginPanel.show();

    }
}
