package newjwglxt.jwglxt.ui;

import newjwglxt.jwglxt.entity.Jwadmin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class JwadminPanel {
    protected JPanel jwadmin;

    public JPanel getPanel() {
        return jwadmin;
    }

    public JwadminPanel(Connection connection, Jwadmin jwadmin_login) {
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

        JLabel lblCourseId_1_1 = new JLabel("任正非");
        lblCourseId_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblCourseId_1_1.setBounds(192, 154, 79, 26);
        panel_xinjiankecheng_jwadmin.add(lblCourseId_1_1);

        JTextField textField = new JTextField();
        textField.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField.setBounds(89, 46, 165, 26);
        panel_xinjiankecheng_jwadmin.add(textField);
        textField.setColumns(10);

        JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBox.setBounds(89, 82, 165, 26);
        panel_xinjiankecheng_jwadmin.add(comboBox);

        JComboBox comboBox_1 = new JComboBox();
        comboBox_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBox_1.setBounds(89, 118, 165, 26);
        panel_xinjiankecheng_jwadmin.add(comboBox_1);

        JTextField textField_1 = new JTextField();
        textField_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_1.setColumns(10);
        textField_1.setBounds(89, 154, 93, 26);
        panel_xinjiankecheng_jwadmin.add(textField_1);

        JComboBox comboBox_1_1 = new JComboBox();
        comboBox_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBox_1_1.setBounds(89, 190, 165, 26);
        panel_xinjiankecheng_jwadmin.add(comboBox_1_1);

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

        JComboBox comboBox_1_1_1 = new JComboBox();
        comboBox_1_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBox_1_1_1.setBounds(358, 190, 165, 26);
        panel_xinjiankecheng_jwadmin.add(comboBox_1_1_1);

//        JButton btnAbout_2_1 = new JButton("新建课程");
//        btnAbout_2_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
//        btnAbout_2_1.setBounds(393, 345, 130, 35);
//        panel_xinjiankecheng_jwadmin.add(btnAbout_2_1);

        JTextField textField_4 = new JTextField();
        textField_4.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_4.setColumns(10);
        textField_4.setBounds(89, 10, 93, 26);
        panel_xinjiankecheng_jwadmin.add(textField_4);

        JButton btnCreateCourse_1 = new JButton("确认");
        btnCreateCourse_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnCreateCourse_1.setBounds(423, 304, 100, 33);
        panel_xinjiankecheng_jwadmin.add(btnCreateCourse_1);

        // jwadmin右侧内容区 -> 课程管理 -> 所有课程
        JScrollPane scrollPane_AllCourse = new JScrollPane();
        panel_course_sub_jwadmin.add(scrollPane_AllCourse, "name_830259794174500");

        JTable table_xtadmin = new JTable();
        table_xtadmin.setModel(new DefaultTableModel(new Object[][]{{null, null, null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null, null, null},}, new String[]{"\u8BFE\u7A0B\u7F16\u53F7", "\u8BFE\u7A0B\u540D\u79F0", "\u5F00\u8BFE\u90E8\u95E8", "\u5B66\u5206", "\u8BFE\u7A0B\u7C7B\u522B", "\u6388\u8BFE\u6559\u5E08", "\u8BFE\u7A0B\u6559\u5BA4", "\u65F6\u95F4", "\u9009\u8BFE\u4EBA\u6570", "\u6700\u5927\u4EBA\u6570"}));
        scrollPane_AllCourse.setViewportView(table_xtadmin);

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

        JLabel lblHello_jwadmin = new JLabel("XXX，你好！");
        lblHello_jwadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblHello_jwadmin.setBounds(149, 56, 365, 35);
        panel_homePage_jwadmin.add(lblHello_jwadmin);

        JLabel lblTid_jwadmin = new JLabel("教职工号：");
        lblTid_jwadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblTid_jwadmin.setBounds(149, 101, 69, 24);
        panel_homePage_jwadmin.add(lblTid_jwadmin);

        JLabel lblTid_present_jwadmin = new JLabel("20110203");
        lblTid_present_jwadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblTid_present_jwadmin.setBounds(219, 101, 88, 24);
        panel_homePage_jwadmin.add(lblTid_present_jwadmin);

        JLabel lblCollege_jwadmin = new JLabel("学部（院）：");
        lblCollege_jwadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblCollege_jwadmin.setBounds(317, 101, 78, 24);
        panel_homePage_jwadmin.add(lblCollege_jwadmin);

        JLabel lblCollege_present_jwadmin = new JLabel("经济与管理学院");
        lblCollege_present_jwadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblCollege_present_jwadmin.setBounds(400, 101, 134, 24);
        panel_homePage_jwadmin.add(lblCollege_present_jwadmin);

        JLabel lblGender_jwadmin = new JLabel("性别：");
        lblGender_jwadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblGender_jwadmin.setBounds(149, 135, 69, 24);
        panel_homePage_jwadmin.add(lblGender_jwadmin);

        JLabel lblGender_present_jwadmin = new JLabel("男");
        lblGender_present_jwadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblGender_present_jwadmin.setBounds(219, 135, 88, 24);
        panel_homePage_jwadmin.add(lblGender_present_jwadmin);

        JLabel lblFirstYear_jwadmin = new JLabel("入职年份：");
        lblFirstYear_jwadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblFirstYear_jwadmin.setBounds(149, 169, 69, 24);
        panel_homePage_jwadmin.add(lblFirstYear_jwadmin);

        JLabel lblFirstYear_present_jwadmin = new JLabel("2020");
        lblFirstYear_present_jwadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblFirstYear_present_jwadmin.setBounds(219, 169, 88, 24);
        panel_homePage_jwadmin.add(lblFirstYear_present_jwadmin);

        JLabel lblTitle_jwadmin = new JLabel("职称：");
        lblTitle_jwadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblTitle_jwadmin.setBounds(317, 135, 78, 24);
        panel_homePage_jwadmin.add(lblTitle_jwadmin);

        JLabel lblTitle_present_jwadmin = new JLabel("国家主席&国家军委主席");
        lblTitle_present_jwadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblTitle_present_jwadmin.setBounds(376, 135, 167, 24);
        panel_homePage_jwadmin.add(lblTitle_present_jwadmin);

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

        // jwadmin右侧内容区 -> 人员管理
        JPanel panel_renyuanmanage_jwadmin = new JPanel();
        panel_container_jwadmin.add(panel_renyuanmanage_jwadmin, "name_832752096213200");
        panel_renyuanmanage_jwadmin.setLayout(null);

        JButton btnHomPage_jwadmin_1 = new JButton("教职工列表");
        btnHomPage_jwadmin_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnHomPage_jwadmin_1.setBounds(10, 56, 100, 33);
        panel_renyuanmanage_jwadmin.add(btnHomPage_jwadmin_1);

        JButton btnHomPage_jwadmin_2 = new JButton("学生列表");
        btnHomPage_jwadmin_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnHomPage_jwadmin_2.setBounds(120, 56, 100, 33);
        panel_renyuanmanage_jwadmin.add(btnHomPage_jwadmin_2);

        JButton btnHomPage_jwadmin_2_1 = new JButton("添加教职工/学生");
        btnHomPage_jwadmin_2_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnHomPage_jwadmin_2_1.setBounds(413, 56, 130, 33);
        panel_renyuanmanage_jwadmin.add(btnHomPage_jwadmin_2_1);

        // jwadmin右侧内容区 -> 人员管理 -> 表格区
        JPanel panel_renyuanmanage = new JPanel();
        panel_renyuanmanage.setBounds(10, 99, 533, 346);
        panel_renyuanmanage_jwadmin.add(panel_renyuanmanage);
        panel_renyuanmanage.setLayout(new CardLayout(0, 0));

        JScrollPane scrollPane = new JScrollPane();
        panel_renyuanmanage.add(scrollPane, "name_832952906374300");

        JTable table = new JTable();
        table.setModel(new DefaultTableModel(new Object[][]{{null, null, null, null, null, null, null}, {null, null, null, null, null, null, null}, {null, null, null, null, null, null, null}, {null, null, null, null, null, null, null}, {null, null, null, null, null, null, null}, {null, null, null, null, null, null, null}, {null, null, null, null, null, null, null}, {null, null, null, null, null, null, null}, {null, null, null, null, null, null, null}, {null, null, null, null, null, null, null}, {null, null, null, null, null, null, null}, {null, null, null, null, null, null, null}, {null, null, null, null, null, null, null}, {null, null, null, null, null, null, null}, {null, null, null, null, null, null, null},}, new String[]{"\u6559\u804C\u5DE5\u7F16\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u5165\u804C\u5E74\u4EFD", "\u804C\u79F0", "\u5B66\u90E8\uFF08\u9662\uFF09", "\u8054\u7CFB\u65B9\u5F0F"}));
        scrollPane.setViewportView(table);

        JScrollPane scrollPane_1 = new JScrollPane();
        panel_renyuanmanage.add(scrollPane_1, "name_833096910647600");

        JTable table_1 = new JTable();
        table_1.setModel(new DefaultTableModel(new Object[][]{{null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null}, {null, null, null, null, null, null, null, null},}, new String[]{"\u5B66\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u5165\u5B66\u5E74\u4EFD", "\u4E13\u4E1A", "\u884C\u653F\u73ED", "\u5B66\u90E8\uFF08\u9662\uFF09", "\u8054\u7CFB\u65B9\u5F0F"}));
        scrollPane_1.setViewportView(table_1);

        // jwadmin右侧内容区 -> 人员管理 -> 添加教职工/学生
        JPanel panel_tianjia = new JPanel();
        panel_renyuanmanage.add(panel_tianjia, "name_833802145576100");
        panel_tianjia.setLayout(null);

        JRadioButton rdbtnNewRadioButton = new JRadioButton("添加教职工");
        rdbtnNewRadioButton.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        rdbtnNewRadioButton.setBounds(6, 6, 121, 23);
        panel_tianjia.add(rdbtnNewRadioButton);

        JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("添加学生");
        rdbtnNewRadioButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        rdbtnNewRadioButton_1.setBounds(129, 7, 121, 23);
        panel_tianjia.add(rdbtnNewRadioButton_1);

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
        lblNewLabel.setBounds(119, 26, 94, 26);
        panel_3.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("性别：");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_1.setBounds(119, 62, 94, 26);
        panel_3.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("入职年份：");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_2.setBounds(119, 98, 94, 26);
        panel_3.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("职称：");
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_3.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_3.setBounds(119, 134, 94, 26);
        panel_3.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("学部（院）：");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_4.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_4.setBounds(119, 170, 94, 26);
        panel_3.add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("联系方式：");
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_5.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_5.setBounds(119, 206, 94, 26);
        panel_3.add(lblNewLabel_5);

        JTextField textField_5 = new JTextField();
        textField_5.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_5.setBounds(239, 26, 146, 26);
        panel_3.add(textField_5);
        textField_5.setColumns(10);

        JComboBox comboBox_2 = new JComboBox();
        comboBox_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBox_2.setBounds(239, 62, 68, 26);
        panel_3.add(comboBox_2);

        JTextField textField_6 = new JTextField();
        textField_6.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_6.setColumns(10);
        textField_6.setBounds(239, 98, 146, 26);
        panel_3.add(textField_6);

        JComboBox comboBox_2_1 = new JComboBox();
        comboBox_2_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBox_2_1.setBounds(239, 134, 146, 26);
        panel_3.add(comboBox_2_1);

        JComboBox comboBox_2_2 = new JComboBox();
        comboBox_2_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBox_2_2.setBounds(239, 170, 146, 26);
        panel_3.add(comboBox_2_2);

        JTextField textField_7 = new JTextField();
        textField_7.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_7.setColumns(10);
        textField_7.setBounds(239, 206, 146, 26);
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

        JLabel lbl_title_renyuanguanli_jwadmin = new JLabel("人员管理");
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

        // jwadmin右侧内容区 -> 退课审批
        JPanel panel_tuikeApproval = new JPanel();
        panel_container_jwadmin.add(panel_tuikeApproval, "name_835090315174800");
        panel_tuikeApproval.setLayout(null);

        JScrollPane scrollPane_2 = new JScrollPane();
        scrollPane_2.setBounds(10, 56, 533, 344);
        panel_tuikeApproval.add(scrollPane_2);

        JTable table_2 = new JTable();
        table_2.setModel(new DefaultTableModel(new Object[][]{{null, null, null, null, null, null}, {null, null, null, null, null, null}, {null, null, null, null, null, null}, {null, null, null, null, null, null}, {null, null, null, null, null, null}, {null, null, null, null, null, null}, {null, null, null, null, null, null}, {null, null, null, null, null, null}, {null, null, null, null, null, null}, {null, null, null, null, null, null}, {null, null, null, null, null, null}, {null, null, null, null, null, null}, {null, null, null, null, null, null}, {null, null, null, null, null, null}, {null, null, null, null, null, null},}, new String[]{"\u5B66\u53F7", "\u59D3\u540D", "\u8BFE\u7A0B\u7F16\u53F7", "\u8BFE\u7A0B", "\u4EFB\u8BFE\u6559\u5E08", "\u7533\u8BF7\u65F6\u95F4"}));
        scrollPane_2.setViewportView(table_2);

        JButton btnAbout_2_4 = new JButton("同意");
        btnAbout_2_4.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnAbout_2_4.setBounds(413, 410, 130, 35);
        panel_tuikeApproval.add(btnAbout_2_4);

        JButton btnAbout_2_5 = new JButton("驳回");
        btnAbout_2_5.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnAbout_2_5.setBounds(273, 410, 130, 35);
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
//                    panel_course_sub_jwadmin.removeAll();
//                    panel_course_sub_jwadmin.add(scrollPane_AllCourse);
//                    panel_course_sub_jwadmin.validate();
//                    panel_course_sub_jwadmin.repaint();
//                    scrollPane_AllCourse.setVisible(true);
                    panel_container_jwadmin.removeAll();
                    panel_container_jwadmin.add(panel_coursePage_jwadmin);
                    panel_container_jwadmin.validate();
                    panel_container_jwadmin.repaint();
                    panel_coursePage_jwadmin.setVisible(true);
                    System.out.println("kechengguanli");
                } else if (e.getSource().equals(btnApproval)) {
                    panel_container_jwadmin.removeAll();
                    panel_container_jwadmin.add(panel_renyuanmanage_jwadmin);
                    panel_container_jwadmin.validate();
                    panel_container_jwadmin.repaint();
                    panel_renyuanmanage_jwadmin.setVisible(true);
                } else if (e.getSource().equals(btnUnknown8)) {
                    panel_container_jwadmin.removeAll();
                    panel_container_jwadmin.add(panel_tuikeApproval);
                    panel_container_jwadmin.validate();
                    panel_container_jwadmin.repaint();
                    panel_tuikeApproval.setVisible(true);
                } else if (e.getSource().equals(btnAllCourse)) {
                    panel_course_sub_jwadmin.removeAll();
                    panel_course_sub_jwadmin.add(scrollPane_AllCourse);
                    panel_course_sub_jwadmin.validate();
                    panel_course_sub_jwadmin.repaint();
                    scrollPane_AllCourse.setVisible(true);
                } else if (e.getSource().equals(btnCreateCourse)) {
                    panel_course_sub_jwadmin.removeAll();
                    panel_course_sub_jwadmin.add(panel_xinjiankecheng_jwadmin);
                    panel_course_sub_jwadmin.validate();
                    panel_course_sub_jwadmin.repaint();
                    panel_xinjiankecheng_jwadmin.setVisible(true);
                } else if (e.getSource().equals(btnHomPage_jwadmin_1)) {
                    panel_renyuanmanage.removeAll();
                    panel_renyuanmanage.add(scrollPane);
                    panel_renyuanmanage.validate();
                    panel_renyuanmanage.repaint();
                    scrollPane.setVisible(true);
                } else if (e.getSource().equals(btnHomPage_jwadmin_2)) {
                    panel_renyuanmanage.removeAll();
                    panel_renyuanmanage.add(scrollPane_1);
                    panel_renyuanmanage.validate();
                    panel_renyuanmanage.repaint();
                    scrollPane_1.setVisible(true);
                } else if (e.getSource().equals(btnHomPage_jwadmin_2_1)) {
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
    }
}