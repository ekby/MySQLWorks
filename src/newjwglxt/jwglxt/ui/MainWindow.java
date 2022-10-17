package newjwglxt.jwglxt.ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainWindow extends JFrame {
    protected static JPanel contentPane;

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
        LoginPanel loginPanel = new LoginPanel();
        loginPanel.show();

        /*以下是学生界面*/
        /*以下是教师界面*/
        /*以下是教务管理员界面*/
        /*以下是系统管理员界面*/
    }
}
