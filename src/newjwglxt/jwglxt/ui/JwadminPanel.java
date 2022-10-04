package newjwglxt.jwglxt.ui;

import newjwglxt.jwglxt.entity.Jwadmin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JwadminPanel {
    protected JPanel jwadmin;

    public JPanel getPanel() {
        return jwadmin;
    }

    public JwadminPanel(Jwadmin jwadmin_login) {
        jwadmin = new JPanel();
        jwadmin.setLayout(null);
        jwadmin.setOpaque(false);
        MainWindow.contentPane.add(jwadmin, "name_611224359007700");

        JPanel panel_category_jwadmin = new JPanel();
        panel_category_jwadmin.setLayout(null);
        panel_category_jwadmin.setBounds(10, 10, 150, 451);
        jwadmin.add(panel_category_jwadmin);

        JButton btnHomPage_jwadmin = new JButton("主页");
        btnHomPage_jwadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnHomPage_jwadmin.setBounds(10, 10, 130, 35);
        panel_category_jwadmin.add(btnHomPage_jwadmin);

        JButton btnCoursemanage_jwadmin = new JButton("课程管理");
        btnCoursemanage_jwadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnCoursemanage_jwadmin.setBounds(10, 55, 130, 35);
        panel_category_jwadmin.add(btnCoursemanage_jwadmin);

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

        JButton btnAbout_jwadmin = new JButton("关于");
        btnAbout_jwadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnAbout_jwadmin.setBounds(10, 406, 130, 35);
        panel_category_jwadmin.add(btnAbout_jwadmin);

        JPanel panel_container_jwadmin = new JPanel();
        panel_container_jwadmin.setBounds(170, 10, 524, 451);
        jwadmin.add(panel_container_jwadmin);
        panel_container_jwadmin.setLayout(new CardLayout(0, 0));

        JPanel panel_HomePage_jwadmin = new JPanel();
        panel_container_jwadmin.add(panel_HomePage_jwadmin, "name_163311928504968");
        panel_HomePage_jwadmin.setLayout(null);

        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setBounds(78, 62, 61, 16);
        panel_HomePage_jwadmin.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setBounds(78, 105, 61, 16);
        panel_HomePage_jwadmin.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("New label");
        lblNewLabel_2.setBounds(78, 152, 61, 16);
        panel_HomePage_jwadmin.add(lblNewLabel_2);

        JPanel panel_CourseManagement_jwadmin = new JPanel();
        panel_container_jwadmin.add(panel_CourseManagement_jwadmin, "name_163326955340342");
        panel_CourseManagement_jwadmin.setLayout(null);

        JPanel panel_unknown1_jwadmin = new JPanel();
        panel_container_jwadmin.add(panel_unknown1_jwadmin, "name_163330807019563");
        panel_unknown1_jwadmin.setLayout(null);

        JPanel panel_unknown2_jwadmin = new JPanel();
        panel_container_jwadmin.add(panel_unknown2_jwadmin, "name_163334739393566");
        panel_unknown2_jwadmin.setLayout(null);

        JPanel panel_unknown3_jwadmin = new JPanel();
        panel_container_jwadmin.add(panel_unknown3_jwadmin, "name_163345920704447");
        panel_unknown3_jwadmin.setLayout(null);

        JPanel panel_About_jwadmin = new JPanel();
        panel_container_jwadmin.add(panel_About_jwadmin, "name_163349861980500");
        panel_About_jwadmin.setLayout(null);

        ActionListener actionlistenerJwadmin = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(btnHomPage_jwadmin)) {
                    panel_container_jwadmin.removeAll();
                    panel_container_jwadmin.add(panel_HomePage_jwadmin);
                    panel_container_jwadmin.validate();
                    panel_container_jwadmin.repaint();
                    System.out.println("主页");
                    panel_HomePage_jwadmin.setVisible(true);

                } else if (e.getSource().equals(btnCoursemanage_jwadmin)) {
                    panel_container_jwadmin.removeAll();
                    panel_container_jwadmin.add(panel_CourseManagement_jwadmin);
                    panel_container_jwadmin.validate();
                    panel_container_jwadmin.repaint();
                    System.out.println("课程管理");
                    panel_CourseManagement_jwadmin.setVisible(true);

                } else if (e.getSource().equals(btnUnknown7)) {
                    panel_container_jwadmin.removeAll();
                    panel_container_jwadmin.add(panel_unknown1_jwadmin);
                    panel_container_jwadmin.validate();
                    panel_container_jwadmin.repaint();
                    System.out.println("未知1");
                    panel_unknown1_jwadmin.setVisible(true);

                } else if (e.getSource().equals(btnUnknown8)) {
                    panel_container_jwadmin.removeAll();
                    panel_container_jwadmin.add(panel_unknown2_jwadmin);
                    panel_container_jwadmin.validate();
                    panel_container_jwadmin.repaint();
                    System.out.println("未知2");
                    panel_unknown2_jwadmin.setVisible(true);

                } else if (e.getSource().equals(btnUnknown9)) {
                    panel_container_jwadmin.removeAll();
                    panel_container_jwadmin.add(panel_unknown3_jwadmin);
                    panel_container_jwadmin.validate();
                    panel_container_jwadmin.repaint();
                    System.out.println("未知3");
                    panel_unknown3_jwadmin.setVisible(true);

                } else if (e.getSource().equals(btnAbout_jwadmin)) {
                    panel_container_jwadmin.removeAll();
                    panel_container_jwadmin.add(panel_About_jwadmin);
                    panel_container_jwadmin.validate();
                    panel_container_jwadmin.repaint();
                    System.out.println("关于");
                    panel_About_jwadmin.setVisible(true);
                }
            }
        };

        btnHomPage_jwadmin.addActionListener(actionlistenerJwadmin);
        btnCoursemanage_jwadmin.addActionListener(actionlistenerJwadmin);
        btnUnknown7.addActionListener(actionlistenerJwadmin);
        btnUnknown8.addActionListener(actionlistenerJwadmin);
        btnUnknown9.addActionListener(actionlistenerJwadmin);
        btnAbout_jwadmin.addActionListener(actionlistenerJwadmin);

    }
}
