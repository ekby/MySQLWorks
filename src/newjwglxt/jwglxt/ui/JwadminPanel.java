package newjwglxt.jwglxt.ui;

import newjwglxt.jwglxt.entity.Course;
import newjwglxt.jwglxt.entity.Jwadmin;
import newjwglxt.jwglxt.service.idx1.CourseService;
import newjwglxt.jwglxt.service.idx1.JwadminService;
import newjwglxt.jwglxt.service.idx1.StudentService;
import newjwglxt.jwglxt.service.idx1.TeacherService;
import newjwglxt.jwglxt.service.idx2.DropCourseService;
import newjwglxt.jwglxt.util.DbConnector;

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
import java.util.Arrays;
import java.util.Vector;

import static newjwglxt.jwglxt.ui.MainWindow.contentPane;

public class JwadminPanel {
    protected JPanel jwadmin;

    public JPanel getPanel() {
        return jwadmin;
    }

    public JwadminPanel(DbConnector dbConnector, Jwadmin jwadmin_login) {
        JwadminService jwadminService = new JwadminService();

        // jwadmin左侧边栏
        jwadmin = new JPanel();
        jwadmin.setLayout(null);
        jwadmin.setOpaque(false);
        MainWindow.contentPane.add(jwadmin, "name_611224359007700");

        JPanel panel_category_jwadmin = new JPanel();
        panel_category_jwadmin.setLayout(null);
        panel_category_jwadmin.setBounds(10, 10, 150, 455);
        jwadmin.add(panel_category_jwadmin);

        JButton btnHomPage_jwadmin = new JButton("主页");
        btnHomPage_jwadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnHomPage_jwadmin.setBounds(10, 10, 130, 35);
        panel_category_jwadmin.add(btnHomPage_jwadmin);

        JButton btnCoursemanae_jwadmin = new JButton("课程管理");
        btnCoursemanae_jwadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnCoursemanae_jwadmin.setBounds(10, 55, 130, 35);
        panel_category_jwadmin.add(btnCoursemanae_jwadmin);

        JButton btnApproval = new JButton("人员管理");
        btnApproval.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnApproval.setBounds(10, 100, 130, 35);
        panel_category_jwadmin.add(btnApproval);

        JButton btnUnknown8 = new JButton("退课审批");
        btnUnknown8.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnUnknown8.setBounds(10, 145, 130, 35);
        panel_category_jwadmin.add(btnUnknown8);

        JButton btnAbout_2 = new JButton("关于");
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

        JButton btnExit_jwadmin = new JButton("更换账号");
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

        JButton btnAllCourse = new JButton("所有课程");
        btnAllCourse.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnAllCourse.setBounds(10, 55, 100, 33);
        panel_coursePage_jwadmin.add(btnAllCourse);

        JButton btnCreateCourse = new JButton("新建课程");
        btnCreateCourse.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnCreateCourse.setBounds(120, 55, 100, 33);
        panel_coursePage_jwadmin.add(btnCreateCourse);

        JPanel panel_course_sub_jwadmin = new JPanel();
        panel_course_sub_jwadmin.setBounds(10, 98, 533, 347);
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
        scrollPane_AllCourse.setViewportView(table_chengjiguanli);

        // jwadmin右侧内容区 -> 课程管理 -> 新建课程
        JPanel panel_xinjiankecheng_jwadmin = new JPanel();
        panel_course_sub_jwadmin.add(panel_xinjiankecheng_jwadmin, "name_830120605913200");
        panel_xinjiankecheng_jwadmin.setLayout(null);

        JLabel lblCourseId = new JLabel("课程编号：");
        lblCourseId.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblCourseId.setBounds(10, 10, 79, 26);
        panel_xinjiankecheng_jwadmin.add(lblCourseId);

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
        textField.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField.setBounds(89, 46, 165, 26);
        panel_xinjiankecheng_jwadmin.add(textField);
        textField.setColumns(10);

        String[] departmentList = new String[]{"经济与管理学院", "文法学部", "信息学部", "艺术设计学院", "理学部"};
        JComboBox comboBox = new JComboBox(departmentList);
        comboBox.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBox.setBounds(89, 82, 165, 26);
        comboBox.setSelectedIndex(0);
        panel_xinjiankecheng_jwadmin.add(comboBox);

        String[] kclbList = new String[]{"学科基础必修课", "公共基础必修课", "专业选修课"};
        JComboBox comboBox_1 = new JComboBox(kclbList);
        comboBox_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBox_1.setBounds(89, 118, 165, 26);
        panel_xinjiankecheng_jwadmin.add(comboBox_1);

        // 教师编号
        JTextField textField_1 = new JTextField();
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
                    if (str != "") {
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
        tt.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        tt.setBounds(89, 190, 165, 26);
        tt.setColumns(10);
        panel_xinjiankecheng_jwadmin.add(tt);

        JTextField textField_2 = new JTextField();
        textField_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_2.setColumns(10);
        textField_2.setBounds(89, 226, 93, 26);
        panel_xinjiankecheng_jwadmin.add(textField_2);

        JTextField textField_3 = new JTextField();
        textField_3.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_3.setColumns(10);
        textField_3.setBounds(333, 46, 93, 26);
        panel_xinjiankecheng_jwadmin.add(textField_3);

        JTextField ttt = new JTextField();
        ttt.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_3.setColumns(10);
        ttt.setBounds(358, 190, 165, 26);
        panel_xinjiankecheng_jwadmin.add(ttt);

        JTextField textField_4 = new JTextField();
        textField_4.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_4.setColumns(10);
        textField_4.setBounds(89, 10, 93, 26);
        panel_xinjiankecheng_jwadmin.add(textField_4);

        JButton btnCreateCourse_1 = new JButton("确认");
        btnCreateCourse_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnCreateCourse_1.setBounds(423, 304, 100, 33);
        panel_xinjiankecheng_jwadmin.add(btnCreateCourse_1);


        // jwadmin右侧内容区 -> 人员管理
        JPanel panel_renyuanmanage_jwadmin = new JPanel();
        panel_container_jwadmin.add(panel_renyuanmanage_jwadmin, "name_832752096213200");
        panel_renyuanmanage_jwadmin.setLayout(null);

        JButton btnHomPage_jwadmin_1 = new JButton("教师列表");
        btnHomPage_jwadmin_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnHomPage_jwadmin_1.setBounds(10, 56, 100, 33);
        panel_renyuanmanage_jwadmin.add(btnHomPage_jwadmin_1);

        JButton btnHomPage_jwadmin_2 = new JButton("学生列表");
        btnHomPage_jwadmin_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnHomPage_jwadmin_2.setBounds(120, 56, 100, 33);
        panel_renyuanmanage_jwadmin.add(btnHomPage_jwadmin_2);

        JButton btnHomPage_jwadmin_2_1 = new JButton("添加教师/学生");
        btnHomPage_jwadmin_2_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnHomPage_jwadmin_2_1.setBounds(413, 56, 130, 33);
        panel_renyuanmanage_jwadmin.add(btnHomPage_jwadmin_2_1);

        // jwadmin右侧内容区 -> 人员管理 -> 表格区
        JPanel panel_renyuanmanage = new JPanel();
        panel_renyuanmanage.setBounds(10, 99, 533, 346);
        panel_renyuanmanage_jwadmin.add(panel_renyuanmanage);
        panel_renyuanmanage.setLayout(new CardLayout(0, 0));

        JScrollPane scrollPane_jiaoshiliebiao = new JScrollPane();
        panel_renyuanmanage.add(scrollPane_jiaoshiliebiao, "name_832952906374300");

        JTable table_jiaoshiliebiao = new JTable();
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
        panel_renyuanmanage.add(scrollPane_xueshengliebiao, "name_833096910647600");

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
        scrollPane_xueshengliebiao.setViewportView(table_xueshengliebiao);

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
        panel_2.setBounds(0, 35, 533, 311);
        panel_tianjia.add(panel_2);
        panel_2.setLayout(new CardLayout(0, 0));

        JPanel panel_3 = new JPanel();
        panel_2.add(panel_3, "name_834076557968500");
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
        textField_5.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_5.setBounds(237, 26, 146, 26);
        panel_3.add(textField_5);
        textField_5.setColumns(10);

        JComboBox comboBox_2 = new JComboBox();
        comboBox_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBox_2.setBounds(237, 62, 68, 26);
        panel_3.add(comboBox_2);

        JTextField textField_6 = new JTextField();
        textField_6.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_6.setColumns(10);
        textField_6.setBounds(237, 98, 146, 26);
        panel_3.add(textField_6);

        JComboBox comboBox_2_1 = new JComboBox();
        comboBox_2_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBox_2_1.setBounds(237, 134, 146, 26);
        panel_3.add(comboBox_2_1);

        JComboBox comboBox_2_2 = new JComboBox();
        comboBox_2_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBox_2_2.setBounds(237, 170, 146, 26);
        panel_3.add(comboBox_2_2);

        JTextField textField_7 = new JTextField();
        textField_7.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_7.setColumns(10);
        textField_7.setBounds(237, 206, 146, 26);
        panel_3.add(textField_7);

        JButton btnHomPage_jwadmin_2_2 = new JButton("确认");
        btnHomPage_jwadmin_2_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnHomPage_jwadmin_2_2.setBounds(423, 270, 100, 33);
        panel_3.add(btnHomPage_jwadmin_2_2);

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
        textField_8.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_8.setColumns(10);
        textField_8.setBounds(237, 20, 146, 26);
        panel_4.add(textField_8);

        JComboBox comboBox_2_3 = new JComboBox();
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
        textField_9.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_9.setColumns(10);
        textField_9.setBounds(237, 92, 146, 26);
        panel_4.add(textField_9);

        JTextField textField_11 = new JTextField();
        textField_11.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_11.setColumns(10);
        textField_11.setBounds(237, 164, 146, 26);
        panel_4.add(textField_11);

        JTextField textField_12 = new JTextField();
        textField_12.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_12.setColumns(10);
        textField_12.setBounds(237, 236, 146, 26);
        panel_4.add(textField_12);

        JComboBox comboBox_2_3_1 = new JComboBox();
        comboBox_2_3_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBox_2_3_1.setBounds(237, 128, 146, 26);
        panel_4.add(comboBox_2_3_1);

        JLabel lblNewLabel_6_4_1 = new JLabel("行政班：");
        lblNewLabel_6_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_6_4_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_6_4_1.setBounds(117, 164, 94, 26);
        panel_4.add(lblNewLabel_6_4_1);

        JComboBox comboBox_2_3_1_1 = new JComboBox();
        comboBox_2_3_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBox_2_3_1_1.setBounds(237, 200, 146, 26);
        panel_4.add(comboBox_2_3_1_1);

        JButton btnHomPage_jwadmin_2_2_1 = new JButton("确认");
        btnHomPage_jwadmin_2_2_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnHomPage_jwadmin_2_2_1.setBounds(423, 268, 100, 33);
        panel_4.add(btnHomPage_jwadmin_2_2_1);

        // jwadmin右侧内容区 -> 人员管理 -> 标题区
        JPanel panel_title_renyuanguanli_jwadmin = new JPanel();
        panel_title_renyuanguanli_jwadmin.setLayout(null);
        panel_title_renyuanguanli_jwadmin.setForeground(SystemColor.activeCaption);
        panel_title_renyuanguanli_jwadmin.setBackground(SystemColor.scrollbar);
        panel_title_renyuanguanli_jwadmin.setBounds(0, 0, 553, 46);
        panel_renyuanmanage_jwadmin.add(panel_title_renyuanguanli_jwadmin);

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
        scrollPane_2.setViewportView(table_2);
        Vector<String> title_tuikeshenpi_jwadmin = new Vector<>();
        title_tuikeshenpi_jwadmin.add("工单编号");
        title_tuikeshenpi_jwadmin.add("学生学号");
        title_tuikeshenpi_jwadmin.add("学生姓名");
        title_tuikeshenpi_jwadmin.add("课程编号");
        title_tuikeshenpi_jwadmin.add("课程名称");


        JButton btnAbout_2_4 = new JButton("同意");
        btnAbout_2_4.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnAbout_2_4.setBounds(443, 412, 100, 33);
        panel_tuikeApproval.add(btnAbout_2_4);

        JButton btnAbout_2_5 = new JButton("驳回");
        btnAbout_2_5.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnAbout_2_5.setBounds(335, 412, 100, 33);
        panel_tuikeApproval.add(btnAbout_2_5);

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

        ActionListener actionListener_jwamin = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(btnHomPage_jwadmin)) {
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
                    textField_4.setText("");
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
                    lbl_title_renyuanguanli_jwadmin.setVisible(true);
                    lbl_title_renyuanguanli_jwadmin_1.setVisible(false);
                    lbl_title_renyuanguanli_jwadmin_1_1.setVisible(false);

                    panel_renyuanmanage.removeAll();
                    panel_renyuanmanage.add(panel_tianjia);
                    panel_renyuanmanage.validate();
                    panel_renyuanmanage.repaint();
                    panel_tianjia.setVisible(true);
                } else if (e.getSource().equals(rdbtnNewRadioButton)) {
                    panel_2.removeAll();
                    panel_2.add(panel_3);
                    panel_2.validate();
                    panel_2.repaint();
                    panel_3.setVisible(true);
                } else if (e.getSource().equals(rdbtnNewRadioButton_1)) {
                    panel_2.removeAll();
                    panel_2.add(panel_4);
                    panel_2.validate();
                    panel_2.repaint();
                    panel_4.setVisible(true);
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
                    if (textField_4.getText().equals("") || textField.getText().equals("") || textField_3.getText().equals("") || textField_1.getText().equals("") || tt.getText().equals("") || ttt.getText().equals("")) {
                        System.out.println("有空值");
                    } else {
                        int cid = Integer.parseInt(textField_4.getText());
                        String cname = textField.getText();
                        int cxuefen = Integer.parseInt(textField_3.getText());
                        String depart = selected_value_of_comboboxes[0];
                        String kclb = selected_value_of_comboboxes[1];
                        int tid = Integer.parseInt(textField_1.getText());
                        String croom = tt.getText();
                        String ctime = ttt.getText();
                        int cmax_num = Integer.parseInt(textField_2.getText());
                        System.out.println(Arrays.toString(selected_value_of_comboboxes));
                        CourseService courseService = new CourseService();
                        courseService.Add(dbConnector, new Course(cid, cname, depart, cxuefen, kclb, tid, croom, ctime, 0, cmax_num));
                        // 确认后复位
                        textField_4.setText("");
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
                    }
                }
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

    }
}
