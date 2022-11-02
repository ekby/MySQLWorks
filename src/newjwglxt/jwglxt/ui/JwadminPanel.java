package newjwglxt.jwglxt.ui;

import newjwglxt.jwglxt.entity.*;
import newjwglxt.jwglxt.service.idx1.CourseService;
import newjwglxt.jwglxt.service.idx1.JwadminService;
import newjwglxt.jwglxt.service.idx1.StudentService;
import newjwglxt.jwglxt.service.idx1.TeacherService;
import newjwglxt.jwglxt.service.idx2.ChooseCourseService;
import newjwglxt.jwglxt.service.idx2.DropCourseService;
import newjwglxt.jwglxt.util.DbConnector;
import newjwglxt.jwglxt.util.QuickButton;
import newjwglxt.jwglxt.util.SHA256;
import newjwglxt.jwglxt.util.ToPinYin;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Vector;

import static newjwglxt.jwglxt.ui.MainWindow.contentPane;
import static newjwglxt.jwglxt.util.ComboboxStyle.setComboboxStyle;
import static newjwglxt.jwglxt.util.QuickButton.primaryBorderButton;

public class JwadminPanel {
    protected JPanel jwadmin;

    public JPanel getPanel() {
        return jwadmin;
    }

    public JwadminPanel(DbConnector dbConnector, Jwadmin jwadmin_login) {
        jwadmin = new JPanel();
        jwadmin.setLayout(null);
        jwadmin.setOpaque(false);
        MainWindow.contentPane.add(jwadmin);

        // jwadmin左侧边栏
        JPanel panel_category_jwadmin = new JPanel();
        panel_category_jwadmin.setLayout(null);
        panel_category_jwadmin.setBounds(10, 10, 150, 455);
        jwadmin.add(panel_category_jwadmin);

        JButton btnHomPage_jwadmin = primaryBorderButton("主页");
        btnHomPage_jwadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnHomPage_jwadmin.setBounds(10, 10, 130, 35);
        panel_category_jwadmin.add(btnHomPage_jwadmin);

        JButton btnCoursemanae_jwadmin = primaryBorderButton("课程管理");
        btnCoursemanae_jwadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnCoursemanae_jwadmin.setBounds(10, 55, 130, 35);
        panel_category_jwadmin.add(btnCoursemanae_jwadmin);

        JButton btnApproval = primaryBorderButton("人员管理");
        btnApproval.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnApproval.setBounds(10, 100, 130, 35);
        panel_category_jwadmin.add(btnApproval);

        JButton btnUnknown8 = primaryBorderButton("退课审批");
        btnUnknown8.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnUnknown8.setBounds(10, 145, 130, 35);
        panel_category_jwadmin.add(btnUnknown8);

        JButton btn_edit_info = primaryBorderButton("编辑个人信息");
        btn_edit_info.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btn_edit_info.setBounds(10, 190, 130, 35);
        panel_category_jwadmin.add(btn_edit_info);

        JButton btnAbout_2 = primaryBorderButton("关于");
        btnAbout_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnAbout_2.setBounds(10, 410, 130, 35);
        panel_category_jwadmin.add(btnAbout_2);

        // jwadmin右侧内容区
        JPanel panel_container_jwadmin = new JPanel();
        panel_container_jwadmin.setBounds(170, 10, 553, 455);
        jwadmin.add(panel_container_jwadmin);
        panel_container_jwadmin.setLayout(new CardLayout(0, 0));

        // jwadmin右侧内容区 -> 主页
        JPanel panel_homePage_jwadmin = new JPanel();
        panel_homePage_jwadmin.setLayout(null);
        panel_container_jwadmin.add(panel_homePage_jwadmin, "name_829339301915200");

        JButton btnExit_jwadmin = primaryBorderButton("更换账号");
        btnExit_jwadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnExit_jwadmin.setBounds(443, 56, 100, 33);
        panel_homePage_jwadmin.add(btnExit_jwadmin);

        JLabel lblImg_jwadmin = new JLabel("头像");
        lblImg_jwadmin.setOpaque(true);
        lblImg_jwadmin.setHorizontalAlignment(SwingConstants.CENTER);
        lblImg_jwadmin.setBackground(Color.WHITE);
        lblImg_jwadmin.setBounds(10, 56, 110, 150);
        panel_homePage_jwadmin.add(lblImg_jwadmin);

        JLabel lblHello_jwadmin = new JLabel(String.format("%s，你好！", jwadmin_login.getName()));
        lblHello_jwadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblHello_jwadmin.setBounds(149, 56, 365, 35);
        panel_homePage_jwadmin.add(lblHello_jwadmin);

        JLabel lblTid_jwadmin = new JLabel("教职工号：");
        lblTid_jwadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblTid_jwadmin.setBounds(149, 101, 69, 24);
        panel_homePage_jwadmin.add(lblTid_jwadmin);

        JLabel lblTid_present_jwadmin = new JLabel(String.valueOf(jwadmin_login.getId()));
        lblTid_present_jwadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblTid_present_jwadmin.setBounds(219, 101, 88, 24);
        panel_homePage_jwadmin.add(lblTid_present_jwadmin);

        JLabel lblGender_jwadmin = new JLabel("性别：");
        lblGender_jwadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblGender_jwadmin.setBounds(149, 135, 69, 24);
        panel_homePage_jwadmin.add(lblGender_jwadmin);

        JLabel lblGender_present_jwadmin = new JLabel(jwadmin_login.getGender());
        lblGender_present_jwadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblGender_present_jwadmin.setBounds(219, 135, 88, 24);
        panel_homePage_jwadmin.add(lblGender_present_jwadmin);

        JLabel lblcontact_jwadmin = new JLabel("联系方式：");
        lblcontact_jwadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblcontact_jwadmin.setBounds(343, 101, 88, 24);
        panel_homePage_jwadmin.add(lblcontact_jwadmin);

        JLabel lblcontact_pre_jw = new JLabel(jwadmin_login.getContact());
        lblcontact_pre_jw.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblcontact_pre_jw.setBounds(425, 101, 100, 24);
        panel_homePage_jwadmin.add(lblcontact_pre_jw);

        // jwadmin右侧内容区 -> 主页 -> 标题区
        JPanel panel_title_zhuye_jwadmin = new JPanel();
        panel_title_zhuye_jwadmin.setLayout(null);
        panel_title_zhuye_jwadmin.setForeground(SystemColor.activeCaption);
        panel_title_zhuye_jwadmin.setBackground(SystemColor.scrollbar);
        panel_title_zhuye_jwadmin.setBounds(0, 0, 553, 46);
        panel_homePage_jwadmin.add(panel_title_zhuye_jwadmin);

        JLabel lblNewLabel_8_1 = new JLabel("主页");
        lblNewLabel_8_1.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lblNewLabel_8_1.setBounds(10, 10, 64, 22);
        panel_title_zhuye_jwadmin.add(lblNewLabel_8_1);


        // jwadmin右侧内容区 -> 课程管理
        JPanel panel_coursePage_jwadmin = new JPanel();
        panel_container_jwadmin.add(panel_coursePage_jwadmin, "name_829297613509800");
        panel_coursePage_jwadmin.setLayout(null);

        JButton btnAllCourse = primaryBorderButton("所有课程");
        btnAllCourse.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnAllCourse.setBounds(10, 55, 100, 33);
        panel_coursePage_jwadmin.add(btnAllCourse);

        JButton btnCreateCoursea = primaryBorderButton("编辑课程");
        btnCreateCoursea.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnCreateCoursea.setBounds(333, 55, 100, 33);
        panel_coursePage_jwadmin.add(btnCreateCoursea);

        JButton btnCreateCourse = primaryBorderButton("新建课程");
        btnCreateCourse.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnCreateCourse.setBounds(443, 55, 100, 33);
        panel_coursePage_jwadmin.add(btnCreateCourse);

        JPanel panel_course_sub_jwadmin = new JPanel();
        panel_course_sub_jwadmin.setBounds(10, 98, 543, 357);
        panel_coursePage_jwadmin.add(panel_course_sub_jwadmin);
        panel_course_sub_jwadmin.setLayout(new CardLayout(0, 0));

        // jwadmin右侧内容区 -> 课程管理 -> 标题区
        JPanel panel_title_kechengguanli_jwadmin = new JPanel();
        panel_title_kechengguanli_jwadmin.setBackground(SystemColor.scrollbar);
        panel_title_kechengguanli_jwadmin.setForeground(SystemColor.activeCaption);
        panel_title_kechengguanli_jwadmin.setBounds(0, 0, 553, 46);
        panel_coursePage_jwadmin.add(panel_title_kechengguanli_jwadmin);
        panel_title_kechengguanli_jwadmin.setLayout(null);

        JLabel lbl_title_kechengguanli_jwadmin = new JLabel("课程管理 / 所有课程");
        lbl_title_kechengguanli_jwadmin.setBounds(10, 10, 207, 22);
        lbl_title_kechengguanli_jwadmin.setFont(new Font("微软雅黑", Font.BOLD, 16));
        panel_title_kechengguanli_jwadmin.add(lbl_title_kechengguanli_jwadmin);

        JLabel lbl_title_kechengguanli_jwadmin_1 = new JLabel("课程管理 / 新建课程");
        lbl_title_kechengguanli_jwadmin_1.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lbl_title_kechengguanli_jwadmin_1.setBounds(10, 10, 207, 22);
        panel_title_kechengguanli_jwadmin.add(lbl_title_kechengguanli_jwadmin_1);

        lbl_title_kechengguanli_jwadmin_1.setVisible(false);

        // jwadmin右侧内容区 -> 课程管理 -> 所有课程
        JScrollPane scrollPane_AllCourse = new JScrollPane();
        panel_course_sub_jwadmin.add(scrollPane_AllCourse, "name_830259794174500");

        Vector<String> title_kechengguanli_jwadmin = new Vector<>();
        title_kechengguanli_jwadmin.add("课程编号");
        title_kechengguanli_jwadmin.add("课程名称");
        title_kechengguanli_jwadmin.add("开课部门");
        title_kechengguanli_jwadmin.add("学分");
        title_kechengguanli_jwadmin.add("课程类别");
        title_kechengguanli_jwadmin.add("教师");
        title_kechengguanli_jwadmin.add("地点");
        title_kechengguanli_jwadmin.add("时间");
        title_kechengguanli_jwadmin.add("报名人数");
        title_kechengguanli_jwadmin.add("最大人数");

        JTable table_chengjiguanli = new JTable();
        table_chengjiguanli.getTableHeader().setReorderingAllowed(false);
        table_chengjiguanli.getTableHeader().setFont(new Font("微软雅黑", Font.PLAIN, 11));
        table_chengjiguanli.setFont(new Font("微软雅黑", Font.PLAIN, 11));
        scrollPane_AllCourse.setViewportView(table_chengjiguanli);

        // jwadmin右侧内容区 -> 课程管理 -> 编辑课程
        JPanel panel_bianjikecheng = new JPanel();
        panel_course_sub_jwadmin.add(panel_bianjikecheng);
        panel_bianjikecheng.setLayout(null);

        JTextField textField_bianhao = new JTextField();
        textField_bianhao.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        textField_bianhao.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_bianhao.setBounds(89, 25, 72, 26);
        panel_bianjikecheng.add(textField_bianhao);
        textField_bianhao.setColumns(10);

        JLabel lblCourseId_2aa = new JLabel("课程编号：");
        lblCourseId_2aa.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblCourseId_2aa.setBounds(10, 25, 79, 26);
        panel_bianjikecheng.add(lblCourseId_2aa);

        JLabel lblCourseId_2a = new JLabel("课程名称：");
        lblCourseId_2a.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblCourseId_2a.setBounds(10, 61, 79, 26);
        panel_bianjikecheng.add(lblCourseId_2a);

        JLabel lblCourseId_3a = new JLabel("开课部门：");
        lblCourseId_3a.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblCourseId_3a.setBounds(10, 97, 79, 26);
        panel_bianjikecheng.add(lblCourseId_3a);

        JLabel lblCourseId_4a = new JLabel("学分：");
        lblCourseId_4a.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblCourseId_4a.setBounds(283, 61, 79, 26);
        panel_bianjikecheng.add(lblCourseId_4a);

        JLabel lblCourseId_4_1a = new JLabel("课程类别：");
        lblCourseId_4_1a.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblCourseId_4_1a.setBounds(10, 133, 79, 26);
        panel_bianjikecheng.add(lblCourseId_4_1a);

        JLabel lblCourseId_4_2a = new JLabel("教师编号：");
        lblCourseId_4_2a.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblCourseId_4_2a.setBounds(10, 169, 79, 26);
        panel_bianjikecheng.add(lblCourseId_4_2a);

        JLabel lblCourseId_4_4a = new JLabel("上课地点：");
        lblCourseId_4_4a.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblCourseId_4_4a.setBounds(10, 205, 79, 26);
        panel_bianjikecheng.add(lblCourseId_4_4a);

        JLabel lblCourseId_4_5a = new JLabel("上课时间：");
        lblCourseId_4_5a.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblCourseId_4_5a.setBounds(283, 205, 79, 26);
        panel_bianjikecheng.add(lblCourseId_4_5a);

        JLabel lblCourseId_4_6a = new JLabel("最大人数：");
        lblCourseId_4_6a.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblCourseId_4_6a.setBounds(10, 241, 79, 26);
        panel_bianjikecheng.add(lblCourseId_4_6a);

        // 教师姓名
        JLabel lblCourseId_1_1a = new JLabel("");
        lblCourseId_1_1a.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblCourseId_1_1a.setBounds(192, 169, 79, 26);
        panel_bianjikecheng.add(lblCourseId_1_1a);

        JTextField textFielda = new JTextField();
        textFielda.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        textFielda.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textFielda.setBounds(89, 61, 140, 26);
        panel_bianjikecheng.add(textFielda);
        textFielda.setColumns(10);

        String[] departmentLista = new String[]{"经济与管理学院", "文法学部", "信息学部", "艺术设计学院", "理学部"};

        JComboBox comboBoxa = new JComboBox(departmentLista);
        setComboboxStyle(comboBoxa);
        comboBoxa.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBoxa.setBounds(89, 97, 165, 26);
        comboBoxa.setSelectedIndex(0);
        panel_bianjikecheng.add(comboBoxa);

        String[] kclbLista = new String[]{"学科基础必修课", "公共基础必修课", "专业选修课"};
        JComboBox comboBox_1a = new JComboBox(kclbLista);
        setComboboxStyle(comboBox_1a);
        comboBox_1a.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBox_1a.setBounds(89, 133, 165, 26);
        panel_bianjikecheng.add(comboBox_1a);

        // 教师编号
        JTextField textField_1a = new JTextField();
        textField_1a.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        textField_1a.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_1a.setColumns(10);
        textField_1a.setBounds(89, 169, 93, 26);
        panel_bianjikecheng.add(textField_1a);

        JTextField tta = new JTextField();
        tta.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        tta.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        tta.setBounds(89, 205, 165, 26);
        tta.setColumns(10);
        panel_bianjikecheng.add(tta);

        JTextField textField_2a = new JTextField();
        textField_2a.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        textField_2a.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_2a.setColumns(10);
        textField_2a.setBounds(89, 241, 93, 26);
        panel_bianjikecheng.add(textField_2a);

        JTextField textField_3a = new JTextField();
        textField_3a.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        textField_3a.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_3a.setColumns(10);
        textField_3a.setBounds(333, 61, 93, 26);
        panel_bianjikecheng.add(textField_3a);

        JTextField ttta = new JTextField();
        ttta.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        ttta.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_3a.setColumns(10);
        ttta.setBounds(358, 205, 165, 26);
        panel_bianjikecheng.add(ttta);

        JButton btnCreateCourse_1a = primaryBorderButton("确认");
        btnCreateCourse_1a.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnCreateCourse_1a.setBounds(433, 314, 100, 33);
        panel_bianjikecheng.add(btnCreateCourse_1a);
        btnCreateCourse_1a.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String new_id = textField_bianhao.getText();
                String new_name = textFielda.getText();
                String new_dep = (String) comboBoxa.getSelectedItem();
                String new_credit = textField_3a.getText();
                String new_kclb = (String) comboBox_1a.getSelectedItem();
                int new_tid = Integer.parseInt(textField_1a.getText());
                String new_room = tta.getText();
                String new_time = ttta.getText();
                int new_sign;
                int new_max = Integer.parseInt(textField_2a.getText());

                if (new_id.equals("")) {
                    System.out.println("空cid");
                } else {
                    CourseService courseService = new CourseService();
                    new_sign = courseService.CheckById(dbConnector, Integer.parseInt(new_id)).get(0).getCsigned_num();
                    Course course = new Course(Integer.parseInt(new_id), new_name, new_dep, Double.parseDouble(new_credit), new_kclb, new_tid, new_room, new_time, new_sign, new_max);
                    courseService.Update(dbConnector, course);

                    textField_bianhao.setText("");
                    textFielda.setText("");
                    comboBoxa.setSelectedIndex(0);
                    textField_3a.setText("");
                    comboBox_1a.setSelectedIndex(0);
                    textField_1a.setText("");
                    tta.setText("");
                    ttta.setText("");
                    textField_2a.setText("");
                    lblCourseId_1_1a.setText("");
                }
            }
        });

        DocumentListener documentListenera = new DocumentListener() {
            String str;
            CourseService courseService = new CourseService();

            @Override
            public void insertUpdate(DocumentEvent e) {
                try {
                    str = e.getDocument().getText(0, textField_bianhao.getDocument().getLength());
                    System.out.printf("insert: %s\n", str);
                    // 判断cid是否存在
                    if (!str.equals("")) {
                        if (courseService.ifIdExist(dbConnector, Integer.parseInt(str))) {
                            System.out.printf("insert IN: %s\n", str);
                            Course course = courseService.CheckById(dbConnector, Integer.parseInt(str)).get(0);
                            textFielda.setText(course.getCname());
                            comboBoxa.setSelectedItem(course.getCdepartment());
                            textField_3a.setText(Double.toString(course.getCcredit()));
                            comboBox_1a.setSelectedItem(course.getCkclb());
                            textField_1a.setText(Integer.toString(course.getCteacherid()));
                            tta.setText(course.getCroom());
                            ttta.setText(course.getCtime());
                            textField_2a.setText(Integer.toString(course.getCmax_num()));
                        } else {
                            textFielda.setText("");
                            comboBoxa.setSelectedIndex(0);
                            textField_3a.setText("");
                            comboBox_1a.setSelectedIndex(0);
                            textField_1a.setText("");
                            tta.setText("");
                            ttta.setText("");
                            textField_2a.setText("");
                            lblCourseId_1_1a.setText("");
                        }
                    }
                } catch (BadLocationException ex) {
                    throw new RuntimeException(ex);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                try {
                    str = e.getDocument().getText(0, textField_bianhao.getDocument().getLength());
                    System.out.printf("insert: %s\n", str);
                    // 判断cid是否存在
                    if (!str.equals("")) {
                        if (courseService.ifIdExist(dbConnector, Integer.parseInt(str))) {
                            System.out.printf("insert IN: %s\n", str);
                            Course course = courseService.CheckById(dbConnector, Integer.parseInt(str)).get(0);
                            textFielda.setText(course.getCname());
                            comboBoxa.setSelectedItem(course.getCdepartment());
                            textField_3a.setText(Double.toString(course.getCcredit()));
                            comboBox_1a.setSelectedItem(course.getCkclb());
                            textField_1a.setText(Integer.toString(course.getCteacherid()));
                            tta.setText(course.getCroom());
                            ttta.setText(course.getCtime());
                            textField_2a.setText(Integer.toString(course.getCmax_num()));
                        } else {
                            textFielda.setText("");
                            comboBoxa.setSelectedIndex(0);
                            textField_3a.setText("");
                            comboBox_1a.setSelectedIndex(0);
                            textField_1a.setText("");
                            tta.setText("");
                            ttta.setText("");
                            textField_2a.setText("");
                            lblCourseId_1_1a.setText("");
                        }
                    }
                } catch (BadLocationException ex) {
                    throw new RuntimeException(ex);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        };
        textField_bianhao.getDocument().addDocumentListener(documentListenera);

        DocumentListener documentListenerb = new DocumentListener() {
            String str;
            TeacherService teacherService = new TeacherService();

            @Override
            public void insertUpdate(DocumentEvent e) {
                try {
                    str = e.getDocument().getText(0, textField_1a.getDocument().getLength());
                    System.out.printf("insert: %s\n", str);
                    // 判断tid是否存在
                    if (!str.equals("")) {
                        if (teacherService.ifIdExist(dbConnector, Integer.parseInt(str))) {
                            System.out.printf("insert IN: %s\n", str);
                            lblCourseId_1_1a.setText(teacherService.CheckById(dbConnector, Integer.parseInt(str)).get(0).getName());
                        } else {
                            lblCourseId_1_1a.setText("");
                        }
                    }
                } catch (BadLocationException ex) {
                    throw new RuntimeException(ex);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                try {
                    str = e.getDocument().getText(0, textField_1a.getDocument().getLength());
                    System.out.printf("insert: %s\n", str);
                    // 判断tid是否存在
                    if (!str.equals("")) {
                        if (teacherService.ifIdExist(dbConnector, Integer.parseInt(str))) {
                            System.out.printf("insert IN: %s\n", str);
                            lblCourseId_1_1a.setText(teacherService.CheckById(dbConnector, Integer.parseInt(str)).get(0).getName());
                        } else {
                            lblCourseId_1_1a.setText("");
                        }
                    }
                } catch (BadLocationException ex) {
                    throw new RuntimeException(ex);
                }

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        };
        textField_1a.getDocument().addDocumentListener(documentListenerb);


        // jwadmin右侧内容区 -> 课程管理 -> 新建课程
        JPanel panel_xinjiankecheng_jwadmin = new JPanel();
        panel_course_sub_jwadmin.add(panel_xinjiankecheng_jwadmin, "name_830120605913200");
        panel_xinjiankecheng_jwadmin.setLayout(null);

        JLabel lblCourseId_2 = new JLabel("课程名称：");
        lblCourseId_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblCourseId_2.setBounds(10, 46, 79, 26);
        panel_xinjiankecheng_jwadmin.add(lblCourseId_2);

        JLabel lblCourseId_3 = new JLabel("开课部门：");
        lblCourseId_3.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblCourseId_3.setBounds(10, 82, 79, 26);
        panel_xinjiankecheng_jwadmin.add(lblCourseId_3);

        JLabel lblCourseId_4 = new JLabel("学分：");
        lblCourseId_4.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblCourseId_4.setBounds(283, 46, 79, 26);
        panel_xinjiankecheng_jwadmin.add(lblCourseId_4);

        JLabel lblCourseId_4_1 = new JLabel("课程类别：");
        lblCourseId_4_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblCourseId_4_1.setBounds(10, 118, 79, 26);
        panel_xinjiankecheng_jwadmin.add(lblCourseId_4_1);

        JLabel lblCourseId_4_2 = new JLabel("教师编号：");
        lblCourseId_4_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblCourseId_4_2.setBounds(10, 154, 79, 26);
        panel_xinjiankecheng_jwadmin.add(lblCourseId_4_2);

        JLabel lblCourseId_4_4 = new JLabel("上课地点：");
        lblCourseId_4_4.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblCourseId_4_4.setBounds(10, 190, 79, 26);
        panel_xinjiankecheng_jwadmin.add(lblCourseId_4_4);

        JLabel lblCourseId_4_5 = new JLabel("上课时间：");
        lblCourseId_4_5.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblCourseId_4_5.setBounds(283, 190, 79, 26);
        panel_xinjiankecheng_jwadmin.add(lblCourseId_4_5);

        JLabel lblCourseId_4_6 = new JLabel("最大人数：");
        lblCourseId_4_6.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblCourseId_4_6.setBounds(10, 226, 79, 26);
        panel_xinjiankecheng_jwadmin.add(lblCourseId_4_6);

        // 教师姓名
        JLabel lblCourseId_1_1 = new JLabel("");
        lblCourseId_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblCourseId_1_1.setBounds(192, 154, 79, 26);
        panel_xinjiankecheng_jwadmin.add(lblCourseId_1_1);

        JTextField textField = new JTextField();
        textField.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        textField.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField.setBounds(89, 46, 145, 26);
        panel_xinjiankecheng_jwadmin.add(textField);
        textField.setColumns(10);

        String[] departmentList = new String[]{"经济与管理学院", "文法学部", "信息学部", "艺术设计学院", "理学部"};
        JComboBox comboBox = new JComboBox(departmentList);
        setComboboxStyle(comboBox);
        comboBox.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBox.setBounds(89, 82, 165, 26);
        comboBox.setSelectedIndex(0);
        panel_xinjiankecheng_jwadmin.add(comboBox);

        String[] kclbList = new String[]{"学科基础必修课", "公共基础必修课", "专业选修课"};
        JComboBox comboBox_1 = new JComboBox(kclbList);
        setComboboxStyle(comboBox_1);
        comboBox_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBox_1.setBounds(89, 118, 165, 26);
        panel_xinjiankecheng_jwadmin.add(comboBox_1);

        // 教师编号
        JTextField textField_1 = new JTextField();
        textField_1.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        textField_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_1.setColumns(10);
        textField_1.setBounds(89, 154, 93, 26);
        panel_xinjiankecheng_jwadmin.add(textField_1);
        // textfield实时监听器
        DocumentListener documentListener = new DocumentListener() {
            String str;
            TeacherService teacherService = new TeacherService();

            @Override
            public void insertUpdate(DocumentEvent e) {
                try {
                    str = e.getDocument().getText(0, textField_1.getDocument().getLength());
                    System.out.printf("insert: %s\n", str);
                    // 判断tid是否存在
                    if (!str.equals("")) {
                        if (teacherService.ifIdExist(dbConnector, Integer.parseInt(str))) {
                            System.out.printf("insert IN: %s\n", str);
                            lblCourseId_1_1.setText(teacherService.CheckById(dbConnector, Integer.parseInt(str)).get(0).getName());
                        } else {
                            lblCourseId_1_1.setText("");
                        }
                    }
                } catch (BadLocationException ex) {
                    throw new RuntimeException(ex);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                try {
                    str = e.getDocument().getText(0, textField_1.getDocument().getLength());
                    System.out.printf("remove: %s\n", str);
                    // removeUpdate的特性：str可能是null
                    if (!str.equals("")) {
                        System.out.println("!re");
                        if (teacherService.ifIdExist(dbConnector, Integer.parseInt(str))) {
                            System.out.printf("remove IN: %s\n", str);
                            lblCourseId_1_1.setText(teacherService.CheckById(dbConnector, Integer.parseInt(str)).get(0).getName());
                        } else {
                            lblCourseId_1_1.setText("");
                        }
                    }
                } catch (BadLocationException ex) {
                    throw new RuntimeException(ex);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }

        };
        textField_1.getDocument().addDocumentListener(documentListener);


        JTextField tt = new JTextField();
        tt.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        tt.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        tt.setBounds(89, 190, 165, 26);
        tt.setColumns(10);
        panel_xinjiankecheng_jwadmin.add(tt);

        JTextField textField_2 = new JTextField();
        textField_2.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        textField_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_2.setColumns(10);
        textField_2.setBounds(89, 226, 93, 26);
        panel_xinjiankecheng_jwadmin.add(textField_2);

        JTextField textField_3 = new JTextField();
        textField_3.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        textField_3.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_3.setColumns(10);
        textField_3.setBounds(333, 46, 93, 26);
        panel_xinjiankecheng_jwadmin.add(textField_3);

        //教师上课时间
        JTextField ttt = new JTextField();
        ttt.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        ttt.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_3.setColumns(10);
        ttt.setBounds(358, 190, 165, 26);
        panel_xinjiankecheng_jwadmin.add(ttt);

        JButton btnCreateCourse_1 = primaryBorderButton("确认");
        btnCreateCourse_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnCreateCourse_1.setBounds(433, 314, 100, 33);
        panel_xinjiankecheng_jwadmin.add(btnCreateCourse_1);

        // jwadmin右侧内容区 -> 人员管理
        JPanel panel_renyuanmanage_jwadmin = new JPanel();
        panel_container_jwadmin.add(panel_renyuanmanage_jwadmin);
        panel_renyuanmanage_jwadmin.setLayout(null);

        JButton btnHomPage_jwadmin_1 = primaryBorderButton("教师列表");
        btnHomPage_jwadmin_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnHomPage_jwadmin_1.setBounds(10, 56, 100, 33);
        panel_renyuanmanage_jwadmin.add(btnHomPage_jwadmin_1);

        JButton btnHomPage_jwadmin_2 = primaryBorderButton("学生列表");
        btnHomPage_jwadmin_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnHomPage_jwadmin_2.setBounds(120, 56, 100, 33);
        panel_renyuanmanage_jwadmin.add(btnHomPage_jwadmin_2);

        JButton btnHomPage_jwadmin_2_11 = primaryBorderButton("编辑教师/学生");
        btnHomPage_jwadmin_2_11.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnHomPage_jwadmin_2_11.setBounds(273, 56, 130, 33);
        panel_renyuanmanage_jwadmin.add(btnHomPage_jwadmin_2_11);

        JButton btnHomPage_jwadmin_2_1 = primaryBorderButton("添加教师/学生");
        btnHomPage_jwadmin_2_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnHomPage_jwadmin_2_1.setBounds(413, 56, 130, 33);
        panel_renyuanmanage_jwadmin.add(btnHomPage_jwadmin_2_1);

        // jwadmin右侧内容区 -> 人员管理 -> 表格区
        JPanel panel_renyuanmanage = new JPanel();
        panel_renyuanmanage.setBounds(10, 99, 533, 346);
        panel_renyuanmanage_jwadmin.add(panel_renyuanmanage);
        panel_renyuanmanage.setLayout(new CardLayout(0, 0));

        JScrollPane scrollPane_jiaoshiliebiao = new JScrollPane();
        panel_renyuanmanage.add(scrollPane_jiaoshiliebiao);

        JTable table_jiaoshiliebiao = new JTable();
        table_jiaoshiliebiao.getTableHeader().setReorderingAllowed(false);
        table_jiaoshiliebiao.getTableHeader().setFont(new Font("微软雅黑", Font.PLAIN, 11));
        table_jiaoshiliebiao.setFont(new Font("微软雅黑", Font.PLAIN, 11));
        scrollPane_jiaoshiliebiao.setViewportView(table_jiaoshiliebiao);

        Vector<String> title_jiaoshiliebiao_jwadmin = new Vector<>();
        title_jiaoshiliebiao_jwadmin.add("教师编号");
        title_jiaoshiliebiao_jwadmin.add("姓名");
        title_jiaoshiliebiao_jwadmin.add("性别");
        title_jiaoshiliebiao_jwadmin.add("入职年份");
        title_jiaoshiliebiao_jwadmin.add("职称");
        title_jiaoshiliebiao_jwadmin.add("学部（院）");
        title_jiaoshiliebiao_jwadmin.add("联系方式");

        JScrollPane scrollPane_xueshengliebiao = new JScrollPane();
        panel_renyuanmanage.add(scrollPane_xueshengliebiao);

        Vector<String> title_xueshengliebiao_jwadmin = new Vector<>();
        title_xueshengliebiao_jwadmin.add("学号");
        title_xueshengliebiao_jwadmin.add("姓名");
        title_xueshengliebiao_jwadmin.add("性别");
        title_xueshengliebiao_jwadmin.add("入学年份");
        title_xueshengliebiao_jwadmin.add("专业");
        title_xueshengliebiao_jwadmin.add("行政班");
        title_xueshengliebiao_jwadmin.add("学部（院）");
        title_xueshengliebiao_jwadmin.add("联系方式");

        JTable table_xueshengliebiao = new JTable();
        table_xueshengliebiao.getTableHeader().setReorderingAllowed(false);
        scrollPane_xueshengliebiao.setViewportView(table_xueshengliebiao);

        // jwadmin右侧内容区 -> 人员管理 -> 修改教职工/学生
        JPanel panel_xiugai = new JPanel();
        panel_renyuanmanage.add(panel_xiugai, "name_833802145576100");
        panel_xiugai.setLayout(null);

        JRadioButton rdbtnNewRadioButton1 = new JRadioButton("编辑教师");
        rdbtnNewRadioButton1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        rdbtnNewRadioButton1.setBounds(6, 6, 121, 23);
        rdbtnNewRadioButton1.setSelected(true);
        panel_xiugai.add(rdbtnNewRadioButton1);

        JRadioButton rdbtnNewRadioButton_11 = new JRadioButton("编辑学生");
        rdbtnNewRadioButton_11.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        rdbtnNewRadioButton_11.setBounds(129, 7, 121, 23);
        panel_xiugai.add(rdbtnNewRadioButton_11);

        // btnGroup为了让两个radioButton不能同时被选中
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(rdbtnNewRadioButton1);
        buttonGroup1.add(rdbtnNewRadioButton_11);

        // jwadmin右侧内容区 -> 人员管理 -> 修改教职工/学生 -> 修改教师
        JPanel panel_21 = new JPanel();
        panel_21.setBounds(0, 35, 543, 321);
        panel_xiugai.add(panel_21);
        panel_21.setLayout(new CardLayout(0, 0));

        JPanel panel_31 = new JPanel();
        panel_21.add(panel_31);
        panel_31.setLayout(null);

        JLabel lblNewLabel10 = new JLabel("教职工号：");
        lblNewLabel10.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel10.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel10.setBounds(117, 13, 94, 26);
        panel_31.add(lblNewLabel10);

        JTextField textField_510 = new JTextField();
        textField_510.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        textField_510.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_510.setBounds(237, 13, 73, 26);
        panel_31.add(textField_510);
        textField_510.setColumns(10);

        JLabel lblNewLabel1 = new JLabel("姓名：");
        lblNewLabel1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel1.setBounds(117, 49, 94, 26);
        panel_31.add(lblNewLabel1);

        JLabel lblNewLabel_11 = new JLabel("性别：");
        lblNewLabel_11.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_11.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_11.setBounds(117, 85, 94, 26);
        panel_31.add(lblNewLabel_11);

        JLabel lblNewLabel_21 = new JLabel("入职年份：");
        lblNewLabel_21.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_21.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_21.setBounds(117, 121, 94, 26);
        panel_31.add(lblNewLabel_21);

        JLabel lblNewLabel_31 = new JLabel("职称：");
        lblNewLabel_31.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_31.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_31.setBounds(117, 157, 94, 26);
        panel_31.add(lblNewLabel_31);

        JLabel lblNewLabel_41 = new JLabel("学部（院）：");
        lblNewLabel_41.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_41.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_41.setBounds(117, 193, 94, 26);
        panel_31.add(lblNewLabel_41);

        JLabel lblNewLabel_51 = new JLabel("联系方式：");
        lblNewLabel_51.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_51.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_51.setBounds(117, 229, 94, 26);
        panel_31.add(lblNewLabel_51);

        JTextField textField_51 = new JTextField();
        textField_51.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        textField_51.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_51.setBounds(237, 49, 146, 26);
        panel_31.add(textField_51);
        textField_51.setColumns(10);

        JComboBox comboBox_21 = new JComboBox(new String[]{"男", "女"});
        setComboboxStyle(comboBox_21);
        comboBox_21.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBox_21.setBounds(237, 85, 68, 26);
        panel_31.add(comboBox_21);

        JTextField textField_61 = new JTextField();
        textField_61.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        textField_61.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_61.setColumns(10);
        textField_61.setBounds(237, 121, 146, 26);
        panel_31.add(textField_61);

        JComboBox comboBox_2_11 = new JComboBox(new String[]{"讲师", "副教授", "教授", "院士"});
        setComboboxStyle(comboBox_2_11);
        comboBox_2_11.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBox_2_11.setBounds(237, 157, 146, 26);
        panel_31.add(comboBox_2_11);

        JComboBox comboBox_2_21 = new JComboBox(new String[]{"经济与管理学院", "文法学部", "信息学部", "艺术设计学院"});
        setComboboxStyle(comboBox_2_21);
        comboBox_2_21.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBox_2_21.setBounds(237, 193, 146, 26);
        panel_31.add(comboBox_2_21);

        JTextField textField_71 = new JTextField();
        textField_71.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        textField_71.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_71.setColumns(10);
        textField_71.setBounds(237, 229, 146, 26);
        panel_31.add(textField_71);

        // 教师编号textfield的动态监听器
        DocumentListener documentListener1 = new DocumentListener() {
            String str;
            TeacherService teacherService = new TeacherService();

            @Override
            public void insertUpdate(DocumentEvent e) {
                try {
                    str = e.getDocument().getText(0, textField_510.getDocument().getLength());
                    System.out.printf("insert: %s\n", str);
                    // 判断tid是否存在
                    if (!str.equals("")) {
                        if (teacherService.ifIdExist(dbConnector, Integer.parseInt(str))) {
                            System.out.printf("insert IN: %s\n", str);
                            Teacher teacher = teacherService.CheckById(dbConnector, Integer.parseInt(str)).get(0);
                            // 姓名
                            textField_51.setText(teacher.getName());
                            // 性别
                            if (teacher.getGender().equals("男")) comboBox_21.setSelectedIndex(0);
                            else comboBox_21.setSelectedIndex(1);
                            // 入职年份
                            textField_61.setText(Integer.toString(teacher.getTfirstyear()));
                            // 职称
                            comboBox_2_11.setSelectedItem(teacher.getTtitle());
                            // 学院
                            comboBox_2_21.setSelectedItem(teacher.getTcollege());
                            // contact
                            textField_71.setText(teacher.getContact());
                        } else {
                            textField_51.setText("");
                            comboBox_21.setSelectedIndex(0);
                            textField_61.setText("");
                            comboBox_2_11.setSelectedIndex(0);
                            comboBox_2_21.setSelectedIndex(0);
                            textField_71.setText("");
                        }
                    }
                } catch (BadLocationException ex) {
                    throw new RuntimeException(ex);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                try {
                    str = e.getDocument().getText(0, textField_510.getDocument().getLength());
                    System.out.printf("remove: %s\n", str);
                    // 判断tid是否存在
                    if (!str.equals("")) {
                        System.out.printf("rem: %s\n", str);
                        if (teacherService.ifIdExist(dbConnector, Integer.parseInt(str))) {
                            System.out.printf("remove IN: %s\n", str);
                            Teacher teacher = teacherService.CheckById(dbConnector, Integer.parseInt(str)).get(0);
                            // 姓名
                            textField_51.setText(teacher.getName());
                            // 性别
                            comboBox_21.setSelectedItem(teacher.getGender());
                            // 入职年份
                            textField_61.setText(Integer.toString(teacher.getTfirstyear()));
                            // 职称
                            comboBox_2_11.setSelectedItem(teacher.getTtitle());
                            // 学院
                            comboBox_2_21.setSelectedItem(teacher.getTcollege());
                            // contact
                            textField_71.setText(teacher.getContact());
                        } else {
                            textField_51.setText("");
                            comboBox_21.setSelectedIndex(0);
                            textField_61.setText("");
                            comboBox_2_11.setSelectedIndex(0);
                            comboBox_2_21.setSelectedIndex(0);
                            textField_71.setText("");
                        }
                    }
                } catch (BadLocationException ex) {
                    throw new RuntimeException(ex);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        };
        textField_510.getDocument().addDocumentListener(documentListener1);

        JButton btnHomPage_jwadmin_2_21 = primaryBorderButton("确认");
        btnHomPage_jwadmin_2_21.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnHomPage_jwadmin_2_21.setBounds(433, 278, 100, 33);
        panel_31.add(btnHomPage_jwadmin_2_21);
        btnHomPage_jwadmin_2_21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int new_teacher_id = Integer.parseInt(textField_510.getText());
                String new_teacher_name = textField_51.getText();
                String new_teacher_gender = (String) comboBox_21.getSelectedItem();
                String new_teacher_firstyear = textField_61.getText();
                String new_teacher_title = (String) comboBox_2_11.getSelectedItem();
                String new_teacher_college = (String) comboBox_2_21.getSelectedItem();
                String new_teacher_conctact = textField_71.getText();
                if (new_teacher_name.equals("") || new_teacher_firstyear.equals("") || new_teacher_conctact.equals("")) {
                    System.out.println("有空值");
                } else {
                    TeacherService teacherService = new TeacherService();
                    String new_teacher_pw = teacherService.CheckById(dbConnector, new_teacher_id).get(0).getPw();
                    Teacher teacher = new Teacher(new_teacher_name, new_teacher_id, new_teacher_pw, new_teacher_gender, new_teacher_conctact, Integer.parseInt(new_teacher_firstyear), new_teacher_title, new_teacher_college);
                    teacherService.Update(dbConnector, teacher);

                    // 清空表单
                    textField_510.setText("");
                    textField_51.setText("");
                    comboBox_21.setSelectedIndex(0);
                    textField_61.setText("");
                    comboBox_2_11.setSelectedIndex(0);
                    comboBox_2_21.setSelectedIndex(0);
                    textField_71.setText("");
                }
            }
        });

        // jwadmin右侧内容区 -> 人员管理 -> 修改教职工/学生 -> 修改学生
        JPanel panel_4a = new JPanel();
        panel_21.add(panel_4a, "name_834083056259600");
        panel_4a.setLayout(null);

        JLabel lblNewLabel_6aq = new JLabel("学号：");
        lblNewLabel_6aq.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_6aq.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_6aq.setBounds(117, 5, 94, 26);
        panel_4a.add(lblNewLabel_6aq);

        JTextField textField_8aq = new JTextField();
        textField_8aq.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        textField_8aq.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_8aq.setColumns(10);
        textField_8aq.setBounds(237, 5, 73, 26);
        panel_4a.add(textField_8aq);

        JLabel lblNewLabel_6a = new JLabel("姓名：");
        lblNewLabel_6a.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_6a.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_6a.setBounds(117, 41, 94, 26);
        panel_4a.add(lblNewLabel_6a);

        JTextField textField_8a = new JTextField();
        textField_8a.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        textField_8a.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_8a.setColumns(10);
        textField_8a.setBounds(237, 41, 146, 26);
        panel_4a.add(textField_8a);

        JComboBox comboBox_2_3a = new JComboBox(new String[]{"男", "女"});
        setComboboxStyle(comboBox_2_3a);
        comboBox_2_3a.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBox_2_3a.setBounds(237, 77, 68, 26);
        panel_4a.add(comboBox_2_3a);

        JLabel lblNewLabel_6_1a = new JLabel("性别：");
        lblNewLabel_6_1a.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_6_1a.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_6_1a.setBounds(117, 77, 94, 26);
        panel_4a.add(lblNewLabel_6_1a);

        JLabel lblNewLabel_6_2a = new JLabel("入学年份：");
        lblNewLabel_6_2a.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_6_2a.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_6_2a.setBounds(117, 113, 94, 26);
        panel_4a.add(lblNewLabel_6_2a);

        JLabel lblNewLabel_6_3a = new JLabel("专业：");
        lblNewLabel_6_3a.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_6_3a.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_6_3a.setBounds(117, 149, 94, 26);
        panel_4a.add(lblNewLabel_6_3a);

        JLabel lblNewLabel_6_4a = new JLabel("联系方式：");
        lblNewLabel_6_4a.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_6_4a.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_6_4a.setBounds(117, 257, 94, 26);
        panel_4a.add(lblNewLabel_6_4a);

        JLabel lblNewLabel_6_5a = new JLabel("学部（院）：");
        lblNewLabel_6_5a.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_6_5a.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_6_5a.setBounds(117, 221, 94, 26);
        panel_4a.add(lblNewLabel_6_5a);

        JTextField textField_9a = new JTextField();
        textField_9a.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        textField_9a.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_9a.setColumns(10);
        textField_9a.setBounds(237, 113, 146, 26);
        panel_4a.add(textField_9a);

        JTextField textField_11a = new JTextField();
        textField_11a.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        textField_11a.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_11a.setColumns(10);
        textField_11a.setBounds(237, 185, 146, 26);
        panel_4a.add(textField_11a);

        JTextField textField_12a = new JTextField();
        textField_12a.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        textField_12a.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_12a.setColumns(10);
        textField_12a.setBounds(237, 257, 146, 26);
        panel_4a.add(textField_12a);

        JTextField textField_121a = new JTextField();
        textField_121a.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        textField_121a.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_121a.setColumns(10);
        textField_121a.setBounds(237, 149, 146, 26);
        panel_4a.add(textField_121a);

        JLabel lblNewLabel_6_4_1a = new JLabel("行政班：");
        lblNewLabel_6_4_1a.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_6_4_1a.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_6_4_1a.setBounds(117, 185, 94, 26);
        panel_4a.add(lblNewLabel_6_4_1a);

        JComboBox comboBox_2_3_1_1a = new JComboBox(new String[]{"经济与管理学院", "文法学部", "信息学部", "理学部", "艺术设计学院"});
        setComboboxStyle(comboBox_2_3_1_1a);
        comboBox_2_3_1_1a.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBox_2_3_1_1a.setBounds(237, 221, 146, 26);
        panel_4a.add(comboBox_2_3_1_1a);

        DocumentListener documentListener2 = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                System.out.println("in dl2");
                String str;
                StudentService studentService = new StudentService();
                try {
                    str = e.getDocument().getText(0, textField_8aq.getDocument().getLength());
                    if (!str.equals("")) {
                        if (studentService.ifIdExist(dbConnector, Integer.parseInt(str))) {
                            Student student = studentService.CheckById(dbConnector, Integer.parseInt(str)).get(0);
                            // 姓名
                            textField_8a.setText(student.getName());
                            // 性别
                            comboBox_2_3a.setSelectedItem(student.getGender());
                            // 入学年份
                            textField_9a.setText(Integer.toString(student.getSfirstyear()));
                            // 专业
                            textField_121a.setText(student.getSmajor());
                            // 行政班
                            textField_11a.setText(Integer.toString(student.getSclass()));
                            // 学院
                            comboBox_2_3_1_1a.setSelectedItem(student.getScollege());
                            // contact
                            textField_12a.setText(student.getContact());
                        } else {
                            textField_8a.setText("");
                            comboBox_2_3a.setSelectedIndex(0);
                            textField_9a.setText("");
                            textField_121a.setText("");
                            textField_11a.setText("");
                            comboBox_2_3_1_1a.setSelectedIndex(0);
                            textField_12a.setText("");
                        }
                    }
                } catch (BadLocationException ex) {
                    throw new RuntimeException(ex);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String str;
                StudentService studentService = new StudentService();
                try {
                    str = e.getDocument().getText(0, textField_8aq.getDocument().getLength());
                    if (!str.equals("")) {
                        if (studentService.ifIdExist(dbConnector, Integer.parseInt(str))) {
                            Student student = studentService.CheckById(dbConnector, Integer.parseInt(str)).get(0);
                            // 姓名
                            textField_8a.setText(student.getName());
                            // 性别
                            comboBox_2_3a.setSelectedItem(student.getGender());
                            // 入学年份
                            textField_9a.setText(Integer.toString(student.getSfirstyear()));
                            // 专业
                            textField_121a.setText(student.getSmajor());
                            // 行政班
                            textField_11a.setText(Integer.toString(student.getSclass()));
                            // 学院
                            comboBox_2_3_1_1a.setSelectedItem(student.getScollege());
                            // contact
                            textField_12a.setText(student.getContact());
                        } else {
                            textField_8a.setText("");
                            comboBox_2_3a.setSelectedIndex(0);
                            textField_9a.setText("");
                            textField_121a.setText("");
                            textField_11a.setText("");
                            comboBox_2_3_1_1a.setSelectedIndex(0);
                            textField_12a.setText("");
                        }
                    }
                } catch (BadLocationException ex) {
                    throw new RuntimeException(ex);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        };
        textField_8aq.getDocument().addDocumentListener(documentListener2);


        JButton btnHomPage_jwadmin_2_21a = primaryBorderButton("确认");
        btnHomPage_jwadmin_2_21a.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnHomPage_jwadmin_2_21a.setBounds(433, 278, 100, 33);
        panel_4a.add(btnHomPage_jwadmin_2_21a);
        btnHomPage_jwadmin_2_21a.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int new_stu_id = Integer.parseInt(textField_8aq.getText());
                String new_stu_name = textField_8a.getText();
                String new_stu_gender = (String) comboBox_2_3a.getSelectedItem();
                String new_stu_firstyear = textField_9a.getText();
                String new_stu_major = textField_121a.getText();
                String new_stu_class = textField_11a.getText();
                String new_stu_coll = (String) comboBox_2_3_1_1a.getSelectedItem();
                String new_stu_contact = textField_12a.getText();

                if (new_stu_name.equals("") || new_stu_firstyear.equals("") || new_stu_major.equals("") || new_stu_class.equals("") || new_stu_coll.equals("") || new_stu_contact.equals("")) {
                    System.out.println("有空值");
                } else {
                    StudentService studentService = new StudentService();
                    String new_stu_pw = studentService.CheckById(dbConnector, new_stu_id).get(0).getPw();
                    Student student = new Student(new_stu_name, new_stu_id, new_stu_pw, new_stu_gender, new_stu_contact, Integer.parseInt(new_stu_firstyear), Integer.parseInt(new_stu_class), new_stu_major, new_stu_coll);
                    studentService.Update(dbConnector, student);

                    textField_8aq.setText("");
                    textField_8a.setText("");
                    comboBox_2_3a.setSelectedIndex(0);
                    textField_9a.setText("");
                    textField_121a.setText("");
                    textField_11a.setText("");
                    comboBox_2_3_1_1a.setSelectedIndex(0);
                    textField_12a.setText("");
                }
            }
        });


        // jwadmin右侧内容区 -> 人员管理 -> 添加教职工/学生
        JPanel panel_tianjia = new JPanel();
        panel_renyuanmanage.add(panel_tianjia, "name_833802145576100");
        panel_tianjia.setLayout(null);

        JRadioButton rdbtnNewRadioButton = new JRadioButton("添加教师");
        rdbtnNewRadioButton.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        rdbtnNewRadioButton.setBounds(6, 6, 121, 23);
        rdbtnNewRadioButton.setSelected(true);
        panel_tianjia.add(rdbtnNewRadioButton);

        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("添加学生");
        rdbtnNewRadioButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        rdbtnNewRadioButton_1.setBounds(129, 7, 121, 23);
        panel_tianjia.add(rdbtnNewRadioButton_1);

        // btnGroup为了让两个radioButton不能同时被选中
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rdbtnNewRadioButton);
        buttonGroup.add(rdbtnNewRadioButton_1);


        // jwadmin右侧内容区 -> 人员管理 -> 添加教职工/学生 -> 添加教职工
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(0, 35, 543, 321);
        panel_tianjia.add(panel_2);
        panel_2.setLayout(new CardLayout(0, 0));

        JPanel panel_3 = new JPanel();
        panel_2.add(panel_3);
        panel_3.setLayout(null);

        JLabel lblNewLabel = new JLabel("姓名：");
        lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel.setBounds(117, 26, 94, 26);
        panel_3.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("性别：");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_1.setBounds(117, 62, 94, 26);
        panel_3.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("入职年份：");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_2.setBounds(117, 98, 94, 26);
        panel_3.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("职称：");
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_3.setBounds(117, 134, 94, 26);
        panel_3.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("学部（院）：");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_4.setBounds(117, 170, 94, 26);
        panel_3.add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("联系方式：");
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_5.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_5.setBounds(117, 206, 94, 26);
        panel_3.add(lblNewLabel_5);

        JTextField textField_5 = new JTextField();
        textField_5.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        textField_5.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_5.setBounds(237, 26, 146, 26);
        panel_3.add(textField_5);
        textField_5.setColumns(10);

        JComboBox comboBox_2 = new JComboBox(new String[]{"男", "女"});
        setComboboxStyle(comboBox_2);
        comboBox_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBox_2.setBounds(237, 62, 68, 26);
        panel_3.add(comboBox_2);

        JTextField textField_6 = new JTextField();
        textField_6.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        textField_6.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_6.setColumns(10);
        textField_6.setBounds(237, 98, 146, 26);
        panel_3.add(textField_6);

        JComboBox comboBox_2_1 = new JComboBox(new String[]{"讲师", "副教授", "教授", "院士"});
        setComboboxStyle(comboBox_2_1);
        comboBox_2_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBox_2_1.setBounds(237, 134, 146, 26);
        panel_3.add(comboBox_2_1);

        JComboBox comboBox_2_2 = new JComboBox(new String[]{"经济与管理学院", "文法学部", "信息学部", "艺术设计学院"});

        setComboboxStyle(comboBox_2_2);
        comboBox_2_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBox_2_2.setBounds(237, 170, 146, 26);
        panel_3.add(comboBox_2_2);

        JTextField textField_7 = new JTextField();
        textField_7.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        textField_7.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_7.setColumns(10);
        textField_7.setBounds(237, 206, 146, 26);
        panel_3.add(textField_7);

        JButton btnHomPage_jwadmin_2_2 = primaryBorderButton("确认");
        btnHomPage_jwadmin_2_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnHomPage_jwadmin_2_2.setBounds(433, 278, 100, 33);
        panel_3.add(btnHomPage_jwadmin_2_2);
        btnHomPage_jwadmin_2_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String new_teacher_name = textField_5.getText();
                String new_teacher_gender = (String) comboBox_2.getSelectedItem();
                String new_teacher_firstyear = textField_6.getText();
                String new_teacher_title = (String) comboBox_2_1.getSelectedItem();
                String new_teacher_college = (String) comboBox_2_2.getSelectedItem();
                String new_teacher_conctact = textField_7.getText();
                if (new_teacher_name.equals("") || new_teacher_firstyear.equals("") || new_teacher_conctact.equals("")) {
                    System.out.println("有空值");
                } else {
                    // 给新用户自动生成密码，按照姓名拼音
                    String new_teacher_pw = SHA256.SHA256(ToPinYin.toPinyin(new_teacher_name));
                    Random random = new Random();
                    TeacherService teacherService = new TeacherService();
                    int new_teacher_id;
                    do {
                        new_teacher_id = 20000 + random.nextInt(10000);
                    } while (teacherService.ifIdExist(dbConnector, new_teacher_id));

                    Teacher teacher = new Teacher(new_teacher_name, new_teacher_id, new_teacher_pw, new_teacher_gender, new_teacher_conctact, Integer.parseInt(new_teacher_firstyear), new_teacher_title, new_teacher_college);
                    teacherService.Add(dbConnector, teacher);

                    // 清空表单
                    textField_5.setText("");
                    comboBox_2.setSelectedIndex(0);
                    textField_6.setText("");
                    comboBox_2_1.setSelectedIndex(0);
                    comboBox_2_2.setSelectedIndex(0);
                    textField_7.setText("");
                }
            }
        });

        // jwadmin右侧内容区 -> 人员管理 -> 添加教职工/学生 -> 添加学生
        JPanel panel_4 = new JPanel();
        panel_2.add(panel_4, "name_834083056259600");
        panel_4.setLayout(null);

        JLabel lblNewLabel_6 = new JLabel("姓名：");
        lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_6.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_6.setBounds(117, 20, 94, 26);
        panel_4.add(lblNewLabel_6);

        JTextField textField_8 = new JTextField();
        textField_8.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        textField_8.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_8.setColumns(10);
        textField_8.setBounds(237, 20, 146, 26);
        panel_4.add(textField_8);

        JComboBox comboBox_2_3 = new JComboBox(new String[]{"男", "女"});
        setComboboxStyle(comboBox_2_3);
        comboBox_2_3.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBox_2_3.setBounds(237, 56, 68, 26);
        panel_4.add(comboBox_2_3);

        JLabel lblNewLabel_6_1 = new JLabel("性别：");
        lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_6_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_6_1.setBounds(117, 56, 94, 26);
        panel_4.add(lblNewLabel_6_1);

        JLabel lblNewLabel_6_2 = new JLabel("入学年份：");
        lblNewLabel_6_2.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_6_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_6_2.setBounds(117, 92, 94, 26);
        panel_4.add(lblNewLabel_6_2);

        JLabel lblNewLabel_6_3 = new JLabel("专业：");
        lblNewLabel_6_3.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_6_3.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_6_3.setBounds(117, 128, 94, 26);
        panel_4.add(lblNewLabel_6_3);

        JLabel lblNewLabel_6_4 = new JLabel("联系方式：");
        lblNewLabel_6_4.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_6_4.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_6_4.setBounds(117, 236, 94, 26);
        panel_4.add(lblNewLabel_6_4);

        JLabel lblNewLabel_6_5 = new JLabel("学部（院）：");
        lblNewLabel_6_5.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_6_5.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_6_5.setBounds(117, 200, 94, 26);
        panel_4.add(lblNewLabel_6_5);

        JTextField textField_9 = new JTextField();
        textField_9.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        textField_9.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_9.setColumns(10);
        textField_9.setBounds(237, 92, 146, 26);
        panel_4.add(textField_9);

        JTextField textField_11 = new JTextField();
        textField_11.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        textField_11.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_11.setColumns(10);
        textField_11.setBounds(237, 164, 146, 26);
        panel_4.add(textField_11);

        JTextField textField_12 = new JTextField();
        textField_12.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        textField_12.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_12.setColumns(10);
        textField_12.setBounds(237, 236, 146, 26);
        panel_4.add(textField_12);

        JTextField textField_121 = new JTextField();
        textField_121.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        textField_121.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_121.setColumns(10);
        textField_121.setBounds(237, 128, 146, 26);
        panel_4.add(textField_121);

        JLabel lblNewLabel_6_4_1 = new JLabel("行政班：");
        lblNewLabel_6_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_6_4_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_6_4_1.setBounds(117, 164, 94, 26);
        panel_4.add(lblNewLabel_6_4_1);

        JComboBox comboBox_2_3_1_1 = new JComboBox(new String[]{"经济与管理学院", "文法学部", "信息学部", "理学部", "艺术设计学院"});

        setComboboxStyle(comboBox_2_3_1_1);
        comboBox_2_3_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBox_2_3_1_1.setBounds(237, 200, 146, 26);
        panel_4.add(comboBox_2_3_1_1);

        JButton btnHomPage_jwadmin_2_2_1 = primaryBorderButton("确认");
        btnHomPage_jwadmin_2_2_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnHomPage_jwadmin_2_2_1.setBounds(433, 278, 100, 33);
        panel_4.add(btnHomPage_jwadmin_2_2_1);
        btnHomPage_jwadmin_2_2_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String new_stu_name = textField_8.getText();
                String new_stu_gender = (String) comboBox_2_3.getSelectedItem();
                String new_stu_firstyear = textField_9.getText();
                String new_stu_major = textField_121.getText();
                String new_stu_class = textField_11.getText();
                String new_stu_college = (String) comboBox_2_3_1_1.getSelectedItem();
                String new_stu_contact = textField_12.getText();
                if (new_stu_name.equals("") || new_stu_firstyear.equals("") || new_stu_major.equals("") || new_stu_class.equals("") || new_stu_contact.equals("")) {
                    System.out.println("有空值");
                } else {
                    StudentService studentService = new StudentService();
                    String new_stu_pw = SHA256.SHA256(ToPinYin.toPinyin(new_stu_name));
                    int new_stu_id;
                    Random random = new Random();
                    do {
                        new_stu_id = 30000 + random.nextInt(10000);
                    } while (studentService.ifIdExist(dbConnector, new_stu_id));
                    Student student = new Student(new_stu_name, new_stu_id, new_stu_pw, new_stu_gender, new_stu_contact, Integer.parseInt(new_stu_firstyear), Integer.parseInt(new_stu_class), new_stu_major, new_stu_college);
                    studentService.Add(dbConnector, student);

                    textField_8.setText("");
                    comboBox_2_3.setSelectedIndex(0);
                    textField_9.setText("");
                    textField_121.setText("");
                    textField_11.setText("");
                    comboBox_2_3_1_1.setSelectedIndex(0);
                    textField_12.setText("");
                }
            }
        });

        // jwadmin右侧内容区 -> 人员管理 -> 标题区
        JPanel panel_title_renyuanguanli_jwadmin = new JPanel();
        panel_title_renyuanguanli_jwadmin.setLayout(null);
        panel_title_renyuanguanli_jwadmin.setForeground(SystemColor.activeCaption);
        panel_title_renyuanguanli_jwadmin.setBackground(SystemColor.scrollbar);
        panel_title_renyuanguanli_jwadmin.setBounds(0, 0, 553, 46);
        panel_renyuanmanage_jwadmin.add(panel_title_renyuanguanli_jwadmin);

        JLabel lbl_title_renyuanguanli1_jwadmin = new JLabel("人员管理 / 编辑教师/学生");
        lbl_title_renyuanguanli1_jwadmin.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lbl_title_renyuanguanli1_jwadmin.setBounds(10, 10, 215, 22);
        panel_title_renyuanguanli_jwadmin.add(lbl_title_renyuanguanli1_jwadmin);

        JLabel lbl_title_renyuanguanli_jwadmin = new JLabel("人员管理 / 添加教师/学生");
        lbl_title_renyuanguanli_jwadmin.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lbl_title_renyuanguanli_jwadmin.setBounds(10, 10, 215, 22);
        panel_title_renyuanguanli_jwadmin.add(lbl_title_renyuanguanli_jwadmin);

        JLabel lbl_title_renyuanguanli_jwadmin_1 = new JLabel("人员管理 / 教师列表");
        lbl_title_renyuanguanli_jwadmin_1.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lbl_title_renyuanguanli_jwadmin_1.setBounds(10, 10, 215, 22);
        panel_title_renyuanguanli_jwadmin.add(lbl_title_renyuanguanli_jwadmin_1);

        JLabel lbl_title_renyuanguanli_jwadmin_1_1 = new JLabel("人员管理 / 学生列表");
        lbl_title_renyuanguanli_jwadmin_1_1.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lbl_title_renyuanguanli_jwadmin_1_1.setBounds(10, 10, 215, 22);
        panel_title_renyuanguanli_jwadmin.add(lbl_title_renyuanguanli_jwadmin_1_1);

        lbl_title_renyuanguanli_jwadmin.setVisible(false);
        lbl_title_renyuanguanli_jwadmin_1_1.setVisible(false);

        // jwadmin右侧内容区 -> 退课审批
        JPanel panel_tuikeApproval = new JPanel();
        panel_container_jwadmin.add(panel_tuikeApproval, "name_835090315174800");
        panel_tuikeApproval.setLayout(null);

        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(10, 56, 533, 346);
        panel_tuikeApproval.add(scrollPane_2);

        JTable table_2 = new JTable();
        table_2.getTableHeader().setReorderingAllowed(false);
        table_2.getTableHeader().setFont(new Font("微软雅黑", Font.PLAIN, 11));
        table_2.setFont(new Font("微软雅黑", Font.PLAIN, 11));
        scrollPane_2.setViewportView(table_2);
        Vector<String> title_tuikeshenpi_jwadmin = new Vector<>();
        title_tuikeshenpi_jwadmin.add("工单编号");
        title_tuikeshenpi_jwadmin.add("学生学号");
        title_tuikeshenpi_jwadmin.add("学生姓名");
        title_tuikeshenpi_jwadmin.add("课程编号");
        title_tuikeshenpi_jwadmin.add("课程名称");


        JButton btnAbout_2_4 = primaryBorderButton("同意");
        btnAbout_2_4.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnAbout_2_4.setBounds(443, 412, 100, 33);
        panel_tuikeApproval.add(btnAbout_2_4);
        btnAbout_2_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dcid = (int) table_2.getValueAt(table_2.getSelectedRow(), 0);
                DropCourseService dropCourseService = new DropCourseService();
                DropCourse dropCourse = dropCourseService.CheckByDcid(dbConnector, dcid).get(0);
                dropCourse.setDchandle(1);
                dropCourseService.Update(dbConnector, dropCourse);

                // 更新退课表
                Vector<Vector<Object>> new_data = dropCourseService.getUnhandledCourses(dbConnector);
                table_2.setModel(new DefaultTableModel(new_data, title_tuikeshenpi_jwadmin));
            }
        });

        JButton btnAbout_2_5 = primaryBorderButton("驳回");
        btnAbout_2_5.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnAbout_2_5.setBounds(335, 412, 100, 33);
        panel_tuikeApproval.add(btnAbout_2_5);
        btnAbout_2_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dcid = (int) table_2.getValueAt(table_2.getSelectedRow(), 0);
                DropCourseService dropCourseService = new DropCourseService();
                DropCourse dropCourse = dropCourseService.CheckByDcid(dbConnector, dcid).get(0);
                dropCourse.setDchandle(-1);
                dropCourseService.Update(dbConnector, dropCourse);

                // 更新退课表
                Vector<Vector<Object>> new_data = dropCourseService.getUnhandledCourses(dbConnector);
                table_2.setModel(new DefaultTableModel(new_data, title_tuikeshenpi_jwadmin));
            }
        });

        // jwadmin右侧内容区 -> 退课审批 -> 标题区
        JPanel panel_title_tuikeshenpi_jwadmin = new JPanel();
        panel_title_tuikeshenpi_jwadmin.setLayout(null);
        panel_title_tuikeshenpi_jwadmin.setForeground(SystemColor.activeCaption);
        panel_title_tuikeshenpi_jwadmin.setBackground(SystemColor.scrollbar);
        panel_title_tuikeshenpi_jwadmin.setBounds(0, 0, 553, 46);
        panel_tuikeApproval.add(panel_title_tuikeshenpi_jwadmin);

        JLabel lblNewLabel_8_3 = new JLabel("退课审批");
        lblNewLabel_8_3.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lblNewLabel_8_3.setBounds(10, 10, 64, 22);
        panel_title_tuikeshenpi_jwadmin.add(lblNewLabel_8_3);

        // 学院combobox
        final String[] selected_value_of_comboboxes = new String[]{"经济与管理学院", "学科基础必修课"};
        ItemListener itemListener_depart = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    selected_value_of_comboboxes[0] = (String) e.getItem();
                    System.out.println(e.getItem());
                }
            }
        };
        ItemListener itemListener_kclb = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    selected_value_of_comboboxes[1] = (String) e.getItem();
                    System.out.println(e.getItem());
                }
            }
        };
        comboBox.addItemListener(itemListener_depart);
        comboBox_1.addItemListener(itemListener_kclb);

        // jwadmin右侧内容区 -> 关于
        JPanel panel_about_jwadmin = new JPanel();
        panel_about_jwadmin.setLayout(null);
        panel_container_jwadmin.add(panel_about_jwadmin);

        // jwadmin右侧内容区 -> 关于 -> 标题区
        JPanel panel_title_about_jwadmin = new JPanel();
        panel_title_about_jwadmin.setLayout(null);
        panel_title_about_jwadmin.setForeground(SystemColor.activeCaption);
        panel_title_about_jwadmin.setBackground(SystemColor.scrollbar);
        panel_title_about_jwadmin.setBounds(0, 0, 553, 46);
        panel_about_jwadmin.add(panel_title_about_jwadmin);

        JLabel lblabout = new JLabel("关于");
        lblabout.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lblabout.setBounds(10, 10, 64, 22);
        panel_title_about_jwadmin.add(lblabout);

        JLabel lblabout_1 = new JLabel("教务管理系统 ");
        lblabout_1.setFont(new Font("微软雅黑", Font.BOLD, 14));
        lblabout_1.setBounds(10, 56, 150, 22);
        panel_about_jwadmin.add(lblabout_1);

        // jwadmin右侧内容区 -> 修改个人信息
        JPanel panel_editInfo_jwadmin = new JPanel();
        panel_container_jwadmin.add(panel_editInfo_jwadmin);
        panel_editInfo_jwadmin.setLayout(null);

        JLabel lbleditInfo_id = new JLabel("教职工号：");
        lbleditInfo_id.setHorizontalAlignment(SwingConstants.RIGHT);
        lbleditInfo_id.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lbleditInfo_id.setBounds(117, 135, 94, 26);
        panel_editInfo_jwadmin.add(lbleditInfo_id);

        JLabel lbleditInfo_name = new JLabel("姓名：");
        lbleditInfo_name.setHorizontalAlignment(SwingConstants.RIGHT);
        lbleditInfo_name.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lbleditInfo_name.setBounds(117, 171, 94, 26);
        panel_editInfo_jwadmin.add(lbleditInfo_name);

        JLabel lbleditInfo_pw = new JLabel("密码：");
        lbleditInfo_pw.setHorizontalAlignment(SwingConstants.RIGHT);
        lbleditInfo_pw.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lbleditInfo_pw.setBounds(117, 207, 94, 26);
        panel_editInfo_jwadmin.add(lbleditInfo_pw);

        JLabel lbleditInfo_gender = new JLabel("性别：");
        lbleditInfo_gender.setHorizontalAlignment(SwingConstants.RIGHT);
        lbleditInfo_gender.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lbleditInfo_gender.setBounds(117, 243, 94, 26);
        panel_editInfo_jwadmin.add(lbleditInfo_gender);

        JLabel lbleditInfo_contact = new JLabel("联系方式：");
        lbleditInfo_contact.setHorizontalAlignment(SwingConstants.RIGHT);
        lbleditInfo_contact.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lbleditInfo_contact.setBounds(117, 279, 94, 26);
        panel_editInfo_jwadmin.add(lbleditInfo_contact);

        // 教职工号
        JLabel textField_613 = new JLabel(String.valueOf(jwadmin_login.getId()));
        textField_613.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_613.setBounds(237, 135, 146, 26);
        panel_editInfo_jwadmin.add(textField_613);

        // 姓名
        JTextField textField_513 = new JTextField(jwadmin_login.getName());
        textField_513.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        textField_513.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_513.setBounds(237, 171, 146, 26);
        panel_editInfo_jwadmin.add(textField_513);
        textField_513.setColumns(10);

        // 性别
        JComboBox comboBox_213 = new JComboBox(new String[]{"男", "女"});

        setComboboxStyle(comboBox_213);
        comboBox_213.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        if (jwadmin_login.getGender().equals("女")) comboBox_213.setSelectedIndex(1);
        comboBox_213.setBounds(237, 243, 68, 26);
        panel_editInfo_jwadmin.add(comboBox_213);

        // 密码
        JPasswordField textField_511 = new JPasswordField();
        textField_511.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_511.setBounds(237, 207, 146, 26);
        panel_editInfo_jwadmin.add(textField_511);
        textField_511.setColumns(10);

        // 联系方式
        JTextField textField_5111 = new JTextField(jwadmin_login.getContact());
        textField_5111.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        textField_5111.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_5111.setBounds(237, 279, 146, 26);
        panel_editInfo_jwadmin.add(textField_5111);
        textField_5111.setColumns(10);

        JButton btneditInfo_jwadmin = primaryBorderButton("确认");
        btneditInfo_jwadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btneditInfo_jwadmin.setBounds(443, 412, 100, 33);
        panel_editInfo_jwadmin.add(btneditInfo_jwadmin);
        btneditInfo_jwadmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JwadminService jwadminService = new JwadminService();
                String new_name = textField_513.getText();
                int new_id = jwadmin_login.getId();
                String new_gender = (String) comboBox_213.getSelectedItem();
                String new_cont = textField_5111.getText();
                String new_pw;
                if (textField_511.getText().equals("")) new_pw = jwadmin_login.getPw();
                else new_pw = SHA256.SHA256(textField_511.getText());

                Jwadmin new_jwadmin = new Jwadmin(new_name, new_id, new_pw, new_gender, new_cont);
                jwadminService.Update(dbConnector, new_jwadmin);

                // jwadmin_login更新
                jwadmin_login.setName(new_name);
                jwadmin_login.setGender(new_gender);
                jwadmin_login.setPw(new_pw);
                jwadmin_login.setContact(new_cont);

                // 复位
                textField_513.setText(jwadmin_login.getName());
                comboBox_213.setSelectedItem(jwadmin_login.getGender());
                textField_5111.setText(jwadmin_login.getContact());
                textField_511.setText("");
            }
        });

        // jwadmin右侧内容区 -> 修改个人信息 -> 标题区
        JPanel panel_title_editInfo_jwadmin = new JPanel();
        panel_title_editInfo_jwadmin.setLayout(null);
        panel_title_editInfo_jwadmin.setBounds(0, 0, 553, 46);
        panel_editInfo_jwadmin.add(panel_title_editInfo_jwadmin);
        panel_title_editInfo_jwadmin.setBackground(SystemColor.scrollbar);
        panel_title_editInfo_jwadmin.setForeground(SystemColor.activeCaption);

        JLabel lbl_title_editinfo_jwadmin = new JLabel("编辑个人信息");
        lbl_title_editinfo_jwadmin.setBounds(10, 10, 207, 22);
        lbl_title_editinfo_jwadmin.setFont(new Font("微软雅黑", Font.BOLD, 16));
        panel_title_editInfo_jwadmin.add(lbl_title_editinfo_jwadmin);

        ActionListener actionListener_jwamin = e -> {
            if (e.getSource().equals(btnHomPage_jwadmin)) {
                JwadminService jwadminService = new JwadminService();
                lblHello_jwadmin.setText(String.format("%s，你好！", jwadminService.CheckById(dbConnector, jwadmin_login.getId()).get(0).getName()));
                lblGender_present_jwadmin.setText(jwadminService.CheckById(dbConnector, jwadmin_login.getId()).get(0).getGender());
                lblcontact_pre_jw.setText(jwadminService.CheckById(dbConnector, jwadmin_login.getId()).get(0).getContact());

                panel_container_jwadmin.removeAll();
                panel_container_jwadmin.add(panel_homePage_jwadmin);
                panel_container_jwadmin.validate();
                panel_container_jwadmin.repaint();
                panel_homePage_jwadmin.setVisible(true);
                System.out.println("zhuye");
            } else if (e.getSource().equals(btnCoursemanae_jwadmin)) {
                // 课程管理
                lbl_title_kechengguanli_jwadmin_1.setVisible(false);
                lbl_title_kechengguanli_jwadmin.setVisible(true);

                CourseService courseService = new CourseService();
                Vector<Vector<Object>> data_kechengguanli_jwadmin = courseService.getAllCourseVector_jwadmin(dbConnector);
                DefaultTableModel new_model_kechengguanli_jwadmin = new DefaultTableModel(data_kechengguanli_jwadmin, title_kechengguanli_jwadmin) {
                    //设置table内容不能改，但能被选中行
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };
                table_chengjiguanli.setModel(new_model_kechengguanli_jwadmin);
                table_chengjiguanli.updateUI();

                // 把成绩表scrollPanel加到subPanel
                panel_course_sub_jwadmin.removeAll();
                panel_course_sub_jwadmin.add(scrollPane_AllCourse);
                panel_course_sub_jwadmin.validate();
                panel_course_sub_jwadmin.repaint();
                scrollPane_AllCourse.setVisible(true);

                // subPanel一直在coursePage里

                // 把coursePage加到container里
                panel_container_jwadmin.removeAll();
                panel_container_jwadmin.add(panel_coursePage_jwadmin);
                panel_container_jwadmin.validate();
                panel_container_jwadmin.repaint();
                panel_coursePage_jwadmin.setVisible(true);
                System.out.println("kechengguanli");
            } else if (e.getSource().equals(btnApproval)) {
                // 人员管理
                lbl_title_renyuanguanli_jwadmin.setVisible(false);
                lbl_title_renyuanguanli_jwadmin_1.setVisible(true);
                lbl_title_renyuanguanli_jwadmin_1_1.setVisible(false);
                lbl_title_renyuanguanli1_jwadmin.setVisible(false);

                TeacherService teacherService = new TeacherService();
                Vector<Vector<Object>> data_jiaoshiliebiao = teacherService.getAllTeacherVector_jwadmin(dbConnector);
                table_jiaoshiliebiao.setModel(new DefaultTableModel(data_jiaoshiliebiao, title_jiaoshiliebiao_jwadmin) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                });
                table_jiaoshiliebiao.updateUI();

                panel_renyuanmanage.removeAll();
                panel_renyuanmanage.add(scrollPane_jiaoshiliebiao);
                panel_renyuanmanage.validate();
                panel_renyuanmanage.repaint();
                scrollPane_jiaoshiliebiao.setVisible(true);

                panel_container_jwadmin.removeAll();
                panel_container_jwadmin.add(panel_renyuanmanage_jwadmin);
                panel_container_jwadmin.validate();
                panel_container_jwadmin.repaint();
                panel_renyuanmanage_jwadmin.setVisible(true);
            } else if (e.getSource().equals(btnUnknown8)) {
                // 退课审批
                DropCourseService dropCourseService = new DropCourseService();
                Vector<Vector<Object>> data_tuikeshenpi_jwadmin = dropCourseService.getUnhandledCourses(dbConnector);
                table_2.setModel(new DefaultTableModel(data_tuikeshenpi_jwadmin, title_tuikeshenpi_jwadmin) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                });
                table_2.updateUI();

                panel_container_jwadmin.removeAll();
                panel_container_jwadmin.add(panel_tuikeApproval);
                panel_container_jwadmin.validate();
                panel_container_jwadmin.repaint();
                panel_tuikeApproval.setVisible(true);
            } else if (e.getSource().equals(btnAllCourse)) {
                // 课程管理 -> 所有课程
                System.out.println("suoyoukecheng");

                lbl_title_kechengguanli_jwadmin_1.setVisible(false);
                lbl_title_kechengguanli_jwadmin.setVisible(true);

                CourseService courseService = new CourseService();
                Vector<Vector<Object>> data_kechengguanli_jwadmin = courseService.getAllCourseVector_jwadmin(dbConnector);
                DefaultTableModel new_model_kechengguanli_jwadmin = new DefaultTableModel(data_kechengguanli_jwadmin, title_kechengguanli_jwadmin) {
                    //设置table内容不能改，但能被选中行
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };
                table_chengjiguanli.setModel(new_model_kechengguanli_jwadmin);
                table_chengjiguanli.updateUI();

                panel_course_sub_jwadmin.removeAll();
                panel_course_sub_jwadmin.add(scrollPane_AllCourse);
                panel_course_sub_jwadmin.validate();
                panel_course_sub_jwadmin.repaint();
                scrollPane_AllCourse.setVisible(true);
            } else if (e.getSource().equals(btnCreateCourse)) {
                // 课程管理 -> 新建课程
                lbl_title_kechengguanli_jwadmin_1.setVisible(true);
                lbl_title_kechengguanli_jwadmin.setVisible(false);
                textField.setText("");
                textField_3.setText("");
                textField_1.setText("");
                tt.setText("");
                ttt.setText("");
                textField_2.setText("");
                comboBox.setSelectedIndex(0);
                comboBox_1.setSelectedIndex(0);
                selected_value_of_comboboxes[0] = "经济与管理学院";
                selected_value_of_comboboxes[1] = "学科基础必修课";
                lblCourseId_1_1.setText("");
//                    // 每次点击新建课程，复位
//                    selected_value_of_comboboxes[0] = "经济与管理学院";
//                    selected_value_of_comboboxes[1] = "学科基础必修课";
//                    comboBox.setSelectedIndex(0);
//                    comboBox_1.setSelectedIndex(0);

                panel_course_sub_jwadmin.removeAll();
                panel_course_sub_jwadmin.add(panel_xinjiankecheng_jwadmin);
                panel_course_sub_jwadmin.validate();
                panel_course_sub_jwadmin.repaint();
                panel_xinjiankecheng_jwadmin.setVisible(true);
            } else if (e.getSource().equals(btnHomPage_jwadmin_1)) {
                // 教师列表
                lbl_title_renyuanguanli_jwadmin.setVisible(false);
                lbl_title_renyuanguanli_jwadmin_1.setVisible(true);
                lbl_title_renyuanguanli_jwadmin_1_1.setVisible(false);
                lbl_title_renyuanguanli1_jwadmin.setVisible(false);

                TeacherService teacherService = new TeacherService();
                Vector<Vector<Object>> data_jiaoshiliebiao = teacherService.getAllTeacherVector_jwadmin(dbConnector);
                table_jiaoshiliebiao.setModel(new DefaultTableModel(data_jiaoshiliebiao, title_jiaoshiliebiao_jwadmin) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                });
                table_jiaoshiliebiao.updateUI();

                panel_renyuanmanage.removeAll();
                panel_renyuanmanage.add(scrollPane_jiaoshiliebiao);
                panel_renyuanmanage.validate();
                panel_renyuanmanage.repaint();
                scrollPane_jiaoshiliebiao.setVisible(true);
            } else if (e.getSource().equals(btnHomPage_jwadmin_2)) {
                // 学生列表
                lbl_title_renyuanguanli_jwadmin.setVisible(false);
                lbl_title_renyuanguanli_jwadmin_1.setVisible(false);
                lbl_title_renyuanguanli_jwadmin_1_1.setVisible(true);
                lbl_title_renyuanguanli1_jwadmin.setVisible(false);

                StudentService studentService = new StudentService();
                Vector<Vector<Object>> data_xueshengliebiao = studentService.getAllStudentVector(dbConnector);
                table_xueshengliebiao.setModel(new DefaultTableModel(data_xueshengliebiao, title_xueshengliebiao_jwadmin) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                });
                table_xueshengliebiao.updateUI();

                panel_renyuanmanage.removeAll();
                panel_renyuanmanage.add(scrollPane_xueshengliebiao);
                panel_renyuanmanage.validate();
                panel_renyuanmanage.repaint();
                scrollPane_xueshengliebiao.setVisible(true);
            } else if (e.getSource().equals(btnHomPage_jwadmin_2_1)) {
                // 新建教师/学生
                lbl_title_renyuanguanli_jwadmin.setVisible(true);
                lbl_title_renyuanguanli_jwadmin_1.setVisible(false);
                lbl_title_renyuanguanli_jwadmin_1_1.setVisible(false);
                lbl_title_renyuanguanli1_jwadmin.setVisible(false);

                panel_renyuanmanage.removeAll();
                panel_renyuanmanage.add(panel_tianjia);
                panel_renyuanmanage.validate();
                panel_renyuanmanage.repaint();
                panel_tianjia.setVisible(true);
            } else if (e.getSource().equals(btnHomPage_jwadmin_2_11)) {
                // 修改教师/学生
                lbl_title_renyuanguanli_jwadmin.setVisible(false);
                lbl_title_renyuanguanli_jwadmin_1.setVisible(false);
                lbl_title_renyuanguanli_jwadmin_1_1.setVisible(false);
                lbl_title_renyuanguanli1_jwadmin.setVisible(true);

                panel_renyuanmanage.removeAll();
                panel_renyuanmanage.add(panel_xiugai);
                panel_renyuanmanage.validate();
                panel_renyuanmanage.repaint();
                panel_xiugai.setVisible(true);
            } else if (e.getSource().equals(rdbtnNewRadioButton)) {
                // 新建教师/学生 -> 添加教师
                panel_2.removeAll();
                panel_2.add(panel_3);
                panel_2.validate();
                panel_2.repaint();
                panel_3.setVisible(true);
            } else if (e.getSource().equals(rdbtnNewRadioButton_1)) {
                // 新建教师/学生 -> 添加学生
                panel_2.removeAll();
                panel_2.add(panel_4);
                panel_2.validate();
                panel_2.repaint();
                panel_4.setVisible(true);
            } else if (e.getSource().equals(rdbtnNewRadioButton1)) {
                // 修改教师/学生 -> 修改教师
                panel_21.removeAll();
                panel_21.add(panel_31);
                panel_21.validate();
                panel_21.repaint();
                panel_31.setVisible(true);

            } else if (e.getSource().equals(rdbtnNewRadioButton_11)) {
                // 修改教师/学生 -> 修改学生
                panel_21.removeAll();
                panel_21.add(panel_4a);
                panel_21.validate();
                panel_21.repaint();
                panel_4a.setVisible(true);

            } else if (e.getSource().equals(btnExit_jwadmin)) {
                // 重新登陆按钮
                System.out.println("tuichudenglu");
                contentPane.removeAll();
                LoginPanel loginPanel = new LoginPanel();
                contentPane.add(loginPanel.getPanel());
                contentPane.validate();
                contentPane.repaint();
                loginPanel.getPanel().setVisible(true);
                dbConnector.closeConnection();
            } else if (e.getSource().equals(btnCreateCourse_1)) {
                // 确认新建课程
                if (textField.getText().equals("") || textField_3.getText().equals("") || textField_1.getText().equals("") || tt.getText().equals("") || ttt.getText().equals("")) {
                    System.out.println("有空值");
                } else {
                    Random random = new Random();
                    int cid = (random.nextInt(9) + 1) * 1000 + random.nextInt(10) * 100 + random.nextInt(10) * 10 + random.nextInt(10);
                    String cname = textField.getText();
                    int cxuefen = Integer.parseInt(textField_3.getText());
                    String depart = selected_value_of_comboboxes[0];
                    String kclb = selected_value_of_comboboxes[1];
                    int tid = Integer.parseInt(textField_1.getText());
                    String croom = tt.getText();
                    String ctime = ttt.getText();
                    int cmax_num = Integer.parseInt(textField_2.getText());
                    CourseService courseService = new CourseService();
                    Course courseWaitJudge = new Course(cid, cname, depart, cxuefen, kclb, tid, croom, ctime, 0, cmax_num);

                    //判断时间是否冲突
                    ChooseCourseService chooseCourseService = new ChooseCourseService();
                    courseService.Add(dbConnector, courseWaitJudge);

                    //todo judge结果永远为false
                    System.out.println(chooseCourseService.judgeCourseForTeacher(dbConnector, courseWaitJudge));

                    if (chooseCourseService.judgeCourseForTeacher(dbConnector, courseWaitJudge)) {
                        // 确认后复位
                        textField.setText("");
                        textField_3.setText("");
                        textField_1.setText("");
                        tt.setText("");
                        ttt.setText("");
                        textField_2.setText("");
                        comboBox.setSelectedIndex(0);
                        comboBox_1.setSelectedIndex(0);
                        selected_value_of_comboboxes[0] = "经济与管理学院";
                        selected_value_of_comboboxes[1] = "学科基础必修课";
                        lblCourseId_1_1.setText("");
                    } else {
                        ttt.setText("");
                        courseService.Delete(dbConnector, courseWaitJudge);
                    }

                }

            } else if (e.getSource().equals(btnAbout_2)) {
                panel_container_jwadmin.removeAll();
                panel_container_jwadmin.add(panel_about_jwadmin);
                panel_container_jwadmin.validate();
                panel_container_jwadmin.repaint();
                panel_container_jwadmin.setVisible(true);
            } else if (e.getSource().equals(btn_edit_info)) {
                panel_container_jwadmin.removeAll();
                panel_container_jwadmin.add(panel_editInfo_jwadmin);
                panel_container_jwadmin.validate();
                panel_container_jwadmin.repaint();
                panel_container_jwadmin.setVisible(true);
            } else if (e.getSource().equals(btnCreateCoursea)) {
                // 课程管理 -> 编辑课程
                panel_course_sub_jwadmin.removeAll();
                panel_course_sub_jwadmin.add(panel_bianjikecheng);
                panel_course_sub_jwadmin.validate();
                panel_course_sub_jwadmin.repaint();
                panel_xinjiankecheng_jwadmin.setVisible(true);
            }
        };
        btnHomPage_jwadmin.addActionListener(actionListener_jwamin);
        btnCoursemanae_jwadmin.addActionListener(actionListener_jwamin);
        btnApproval.addActionListener(actionListener_jwamin);
        btnUnknown8.addActionListener(actionListener_jwamin);
        btnAllCourse.addActionListener(actionListener_jwamin);
        btnCreateCourse.addActionListener(actionListener_jwamin);
        btnHomPage_jwadmin_1.addActionListener(actionListener_jwamin);
        btnHomPage_jwadmin_2.addActionListener(actionListener_jwamin);
        btnHomPage_jwadmin_2_1.addActionListener(actionListener_jwamin);
        rdbtnNewRadioButton.addActionListener(actionListener_jwamin);
        rdbtnNewRadioButton_1.addActionListener(actionListener_jwamin);
        btnExit_jwadmin.addActionListener(actionListener_jwamin);
        btnCreateCourse_1.addActionListener(actionListener_jwamin);
        btnAbout_2.addActionListener(actionListener_jwamin);
        btn_edit_info.addActionListener(actionListener_jwamin);
        btnHomPage_jwadmin_2_11.addActionListener(actionListener_jwamin);
        rdbtnNewRadioButton1.addActionListener(actionListener_jwamin);
        rdbtnNewRadioButton_11.addActionListener(actionListener_jwamin);
        btnCreateCoursea.addActionListener(actionListener_jwamin);
    }
}
