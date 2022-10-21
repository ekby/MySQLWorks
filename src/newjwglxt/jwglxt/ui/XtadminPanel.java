package newjwglxt.jwglxt.ui;

import newjwglxt.jwglxt.entity.Xtadmin;
import newjwglxt.jwglxt.util.DbConnector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class XtadminPanel {
    protected JPanel xtadmin;

    public JPanel getPanel() {
        return xtadmin;
    }

    public XtadminPanel(DbConnector dbConnector, Xtadmin xtadmin_login) {
        xtadmin = new JPanel();
        xtadmin.setLayout(null);
        xtadmin.setOpaque(false);
        MainWindow.contentPane.add(xtadmin, "name_611226331268200");

        // xtadmin左侧边栏
        JPanel panel_category_xtadmin = new JPanel();
        panel_category_xtadmin.setLayout(null);
        panel_category_xtadmin.setBounds(10, 10, 150, 451);
        xtadmin.add(panel_category_xtadmin);

        JButton btnHomePage_xtadmin = new JButton("主页");
        btnHomePage_xtadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnHomePage_xtadmin.setBounds(10, 10, 130, 35);
        panel_category_xtadmin.add(btnHomePage_xtadmin);

        JButton btnUserManagement_xtadmin = new JButton("用户管理");
        btnUserManagement_xtadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnUserManagement_xtadmin.setBounds(10, 55, 130, 35);
        panel_category_xtadmin.add(btnUserManagement_xtadmin);

        JButton btnAbout_xtadmin = new JButton("关于");
        btnAbout_xtadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnAbout_xtadmin.setBounds(10, 406, 130, 35);
        panel_category_xtadmin.add(btnAbout_xtadmin);

        // xtadmin右侧内容区
        JPanel panel_container_xtadmin = new JPanel();
        panel_container_xtadmin.setBounds(170, 10, 553, 451);
        xtadmin.add(panel_container_xtadmin);
        panel_container_xtadmin.setLayout(new CardLayout(0, 0));

        // xtadmin右侧内容区 -> 主页
        JPanel panel_homepage_xtadmin = new JPanel();
        panel_homepage_xtadmin.setLayout(null);
        panel_container_xtadmin.add(panel_homepage_xtadmin, "name_223808958587400");

        JButton btnExit_xtadmin = new JButton("更换账号");
        btnExit_xtadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnExit_xtadmin.setBounds(443, 56, 100, 33);
        panel_homepage_xtadmin.add(btnExit_xtadmin);

        JLabel lblImg_xtadmin = new JLabel("头像");
        lblImg_xtadmin.setOpaque(true);
        lblImg_xtadmin.setHorizontalAlignment(SwingConstants.CENTER);
        lblImg_xtadmin.setBackground(Color.WHITE);
        lblImg_xtadmin.setBounds(10, 56, 110, 150);
        panel_homepage_xtadmin.add(lblImg_xtadmin);

        JLabel lblHello_xtadmin = new JLabel("XXX，你好！");
        lblHello_xtadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblHello_xtadmin.setBounds(149, 56, 365, 35);
        panel_homepage_xtadmin.add(lblHello_xtadmin);

        JLabel lblId_xtadmin = new JLabel("职工号：");
        lblId_xtadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblId_xtadmin.setBounds(149, 101, 69, 24);
        panel_homepage_xtadmin.add(lblId_xtadmin);

        JLabel lblId_present_xtadmin = new JLabel("20110203");
        lblId_present_xtadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblId_present_xtadmin.setBounds(219, 101, 88, 24);
        panel_homepage_xtadmin.add(lblId_present_xtadmin);

        JLabel lblGender_xtadmin = new JLabel("性别：");
        lblGender_xtadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblGender_xtadmin.setBounds(149, 135, 69, 24);
        panel_homepage_xtadmin.add(lblGender_xtadmin);

        JLabel lblGender_present_xtadmin = new JLabel("男");
        lblGender_present_xtadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblGender_present_xtadmin.setBounds(219, 135, 88, 24);
        panel_homepage_xtadmin.add(lblGender_present_xtadmin);

        // xtadmin右侧内容区 -> 主页 -> 标题区
        JPanel panel_5_11 = new JPanel();
        panel_5_11.setLayout(null);
        panel_5_11.setForeground(SystemColor.activeCaption);
        panel_5_11.setBackground(SystemColor.scrollbar);
        panel_5_11.setBounds(0, 0, 553, 46);
        panel_homepage_xtadmin.add(panel_5_11);

        JLabel lblNewLabel_8_11 = new JLabel("主页");
        lblNewLabel_8_11.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lblNewLabel_8_11.setBounds(10, 10, 64, 22);
        panel_5_11.add(lblNewLabel_8_11);

        // xtadmin右侧内容区 -> 用户管理
        JPanel panel_userManege_xtadmin = new JPanel();
        panel_container_xtadmin.add(panel_userManege_xtadmin, "name_853865502652200");
        panel_userManege_xtadmin.setLayout(new CardLayout(0, 0));

        // xtadmin右侧内容区 -> 用户管理 -> 学生列表/教职工列表/教务列表
        JPanel panel_user_xtadmin = new JPanel();
        panel_user_xtadmin.setLayout(null);
        panel_userManege_xtadmin.add(panel_user_xtadmin, "name_853892487420000");

        JButton btn_studentList_xtadmin = new JButton("学生列表");
        btn_studentList_xtadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btn_studentList_xtadmin.setBounds(10, 56, 100, 33);
        panel_user_xtadmin.add(btn_studentList_xtadmin);

        JButton btn_teacherList_xtadmin = new JButton("教职工列表");
        btn_teacherList_xtadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btn_teacherList_xtadmin.setBounds(119, 56, 100, 33);
        panel_user_xtadmin.add(btn_teacherList_xtadmin);

        JButton btn_jwadminList_xtadmin = new JButton("教务列表");
        btn_jwadminList_xtadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btn_jwadminList_xtadmin.setBounds(229, 56, 100, 33);
        panel_user_xtadmin.add(btn_jwadminList_xtadmin);

        JButton btn_jwadminList_xtadmin_1 = new JButton("添加用户");
        btn_jwadminList_xtadmin_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btn_jwadminList_xtadmin_1.setBounds(443, 56, 100, 33);
        panel_user_xtadmin.add(btn_jwadminList_xtadmin_1);

        // xtadmin右侧内容区 -> 用户管理 -> 学生列表/教职工列表/教务列表 -> 表格区
        JPanel panel_listContainer = new JPanel();
        panel_listContainer.setBounds(10, 99, 533, 342);
        panel_user_xtadmin.add(panel_listContainer);
        panel_listContainer.setLayout(new CardLayout(0, 0));

        // xtadmin右侧内容区 -> 用户管理 -> 学生列表/教职工列表/教务列表 -> 表格区 -> 学生表
        JScrollPane scrollPane_5 = new JScrollPane();
        panel_listContainer.add(scrollPane_5, "name_854715487110700");

        JTable table_5 = new JTable();
        table_5.setModel(new DefaultTableModel(new Object[][]{
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
        },
                new String[]{"\u5B66\u53F7", "\u59D3\u540D", "\u6027\u522B", "\u5165\u5B66\u5E74\u4EFD", "\u4E13\u4E1A", "\u5B66\u90E8\uFF08\u9662\uFF09", "\u8054\u7CFB\u65B9\u5F0F"}));
        scrollPane_5.setViewportView(table_5);

        // xtadmin右侧内容区 -> 用户管理 -> 学生列表/教职工列表/教务列表 -> 表格区 -> 教职工表
        JScrollPane scrollPane_6 = new JScrollPane();
        panel_listContainer.add(scrollPane_6, "name_854722515418500");

        JTable table_6 = new JTable();
        table_6.setModel(new DefaultTableModel(new Object[][]{
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
        }, new String[]{"教工号", "姓名", "性别", "入职年份", "职称", "学部（院）", "联系方式"}));

        // xtadmin右侧内容区 -> 用户管理 -> 学生列表/教职工列表/教务列表 -> 表格区 -> 教务表
        JScrollPane scrollPane_7 = new JScrollPane();
        panel_listContainer.add(scrollPane_7, "name_854729110281000");

        JTable table_7 = new JTable();
        table_7.setModel(new DefaultTableModel(new Object[][]{
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
        }, new String[]{"教工号", "姓名", "性别", "联系方式"}));

        // xtadmin右侧内容区 -> 用户管理 -> 标题区
        JPanel panel_title_userManage_xtadmin_1 = new JPanel();
        panel_title_userManage_xtadmin_1.setLayout(null);
        panel_title_userManage_xtadmin_1.setForeground(SystemColor.activeCaption);
        panel_title_userManage_xtadmin_1.setBackground(SystemColor.scrollbar);
        panel_title_userManage_xtadmin_1.setBounds(0, 0, 553, 46);
        panel_user_xtadmin.add(panel_title_userManage_xtadmin_1);

        JLabel lbl_tianjia_xtadmin_1 = new JLabel("用户管理");
        lbl_tianjia_xtadmin_1.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lbl_tianjia_xtadmin_1.setBounds(10, 10, 234, 22);
        panel_title_userManage_xtadmin_1.add(lbl_tianjia_xtadmin_1);

        JLabel lbl_tianjia_xtadmin_1_xueshengliebiao = new JLabel("用户管理 / 学生列表");
        lbl_tianjia_xtadmin_1_xueshengliebiao.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lbl_tianjia_xtadmin_1_xueshengliebiao.setBounds(10, 10, 234, 22);
        panel_title_userManage_xtadmin_1.add(lbl_tianjia_xtadmin_1_xueshengliebiao);

        JLabel lbl_tianjia_xtadmin_1_jiaozhigongliebiao = new JLabel("用户管理 / 教职工列表");
        lbl_tianjia_xtadmin_1_jiaozhigongliebiao.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lbl_tianjia_xtadmin_1_jiaozhigongliebiao.setBounds(10, 10, 234, 22);
        panel_title_userManage_xtadmin_1.add(lbl_tianjia_xtadmin_1_jiaozhigongliebiao);

        JLabel lbl_tianjia_xtadmin_1_jiaowuliebiao = new JLabel("用户管理 / 教务列表");
        lbl_tianjia_xtadmin_1_jiaowuliebiao.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lbl_tianjia_xtadmin_1_jiaowuliebiao.setBounds(10, 10, 234, 22);
        panel_title_userManage_xtadmin_1.add(lbl_tianjia_xtadmin_1_jiaowuliebiao);

        // xtadmin右侧内容区 -> 用户管理 -> 添加用户
        JPanel panel_tianjiayonghu_xtadmin = new JPanel();
        panel_userManege_xtadmin.add(panel_tianjiayonghu_xtadmin, "name_853904895880500");
        panel_tianjiayonghu_xtadmin.setLayout(null);

        // xtadmin右侧内容区 -> 用户管理 -> 添加用户 -> 标题区
        JPanel panel_title_userManage_xtadmin = new JPanel();
        panel_title_userManage_xtadmin.setLayout(null);
        panel_title_userManage_xtadmin.setForeground(SystemColor.activeCaption);
        panel_title_userManage_xtadmin.setBackground(SystemColor.scrollbar);
        panel_title_userManage_xtadmin.setBounds(0, 0, 553, 46);
        panel_tianjiayonghu_xtadmin.add(panel_title_userManage_xtadmin);

        JLabel lbl_tianjia_xtadmin = new JLabel("用户管理 / 添加用户");
        lbl_tianjia_xtadmin.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lbl_tianjia_xtadmin.setBounds(10, 10, 234, 22);
        panel_title_userManage_xtadmin.add(lbl_tianjia_xtadmin);

        // xtadmin右侧内容区 -> 用户管理 -> 添加用户 -> 内容区
        JPanel panel_tianjia_1 = new JPanel();
        panel_tianjia_1.setLayout(null);
        panel_tianjia_1.setBounds(10, 56, 533, 385);
        panel_tianjiayonghu_xtadmin.add(panel_tianjia_1);

        JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("添加教师");
        rdbtnNewRadioButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        rdbtnNewRadioButton_2.setBounds(6, 6, 121, 23);
        panel_tianjia_1.add(rdbtnNewRadioButton_2);

        JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("添加学生");
        rdbtnNewRadioButton_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        rdbtnNewRadioButton_1_1.setBounds(129, 7, 121, 23);
        panel_tianjia_1.add(rdbtnNewRadioButton_1_1);

        JRadioButton rdbtnNewRadioButton_1_1_1 = new JRadioButton("添加教务管理员");
        rdbtnNewRadioButton_1_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        rdbtnNewRadioButton_1_1_1.setBounds(252, 7, 121, 23);
        panel_tianjia_1.add(rdbtnNewRadioButton_1_1_1);

        // xtadmin右侧内容区 -> 用户管理 -> 添加用户 -> 内容区 -> 添加教务管理员
        JPanel panel_tianjiayonghu_sub_xtadmin = new JPanel();
        panel_tianjiayonghu_sub_xtadmin.setBounds(0, 35, 533, 350);
        panel_tianjia_1.add(panel_tianjiayonghu_sub_xtadmin);
        panel_tianjiayonghu_sub_xtadmin.setLayout(new CardLayout(0, 0));

        JPanel panel_tianjiajiaowuguanliyuan_xtadmin = new JPanel();
        panel_tianjiayonghu_sub_xtadmin.add(panel_tianjiajiaowuguanliyuan_xtadmin, "name_415818239970300");
        panel_tianjiajiaowuguanliyuan_xtadmin.setLayout(null);

        JLabel lblNewLabel_7 = new JLabel("姓名：");
        lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_7.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_7.setBounds(121, 98, 94, 26);
        panel_tianjiajiaowuguanliyuan_xtadmin.add(lblNewLabel_7);

        JLabel lblNewLabel_7_1 = new JLabel("性别：");
        lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_7_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_7_1.setBounds(121, 134, 94, 26);
        panel_tianjiajiaowuguanliyuan_xtadmin.add(lblNewLabel_7_1);

        JLabel lblNewLabel_7_2 = new JLabel("联系方式：");
        lblNewLabel_7_2.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_7_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_7_2.setBounds(121, 170, 94, 26);
        panel_tianjiajiaowuguanliyuan_xtadmin.add(lblNewLabel_7_2);

        JTextField textField_10 = new JTextField();
        textField_10.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_10.setBounds(243, 98, 146, 26);
        panel_tianjiajiaowuguanliyuan_xtadmin.add(textField_10);
        textField_10.setColumns(10);

        JTextField textField_13 = new JTextField();
        textField_13.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_13.setColumns(10);
        textField_13.setBounds(243, 170, 146, 26);
        panel_tianjiajiaowuguanliyuan_xtadmin.add(textField_13);

        JComboBox comboBox_4 = new JComboBox();
        comboBox_4.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBox_4.setBounds(243, 136, 68, 23);
        panel_tianjiajiaowuguanliyuan_xtadmin.add(comboBox_4);

        JButton btnNewButton = new JButton("返回");
        btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnNewButton.setBounds(10, 307, 100, 33);
        panel_tianjiajiaowuguanliyuan_xtadmin.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("确认");
        btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnNewButton_1.setBounds(423, 307, 100, 33);
        panel_tianjiajiaowuguanliyuan_xtadmin.add(btnNewButton_1);

        // xtadmin右侧内容区 -> 用户管理 -> 添加用户 -> 内容区 -> 添加学生
        JPanel panel_tianjiaxuesheng_xtadmin = new JPanel();
        panel_tianjiaxuesheng_xtadmin.setLayout(null);
        panel_tianjiayonghu_sub_xtadmin.add(panel_tianjiaxuesheng_xtadmin, "name_416787770067000");

        JLabel lblNewLabel_6_6 = new JLabel("姓名：");
        lblNewLabel_6_6.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_6_6.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_6_6.setBounds(117, 28, 94, 26);
        panel_tianjiaxuesheng_xtadmin.add(lblNewLabel_6_6);

        JTextField textField_14 = new JTextField();
        textField_14.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_14.setColumns(10);
        textField_14.setBounds(237, 28, 146, 26);
        panel_tianjiaxuesheng_xtadmin.add(textField_14);

        JComboBox comboBox_2_3_2 = new JComboBox();
        comboBox_2_3_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBox_2_3_2.setBounds(237, 64, 68, 26);
        panel_tianjiaxuesheng_xtadmin.add(comboBox_2_3_2);

        JLabel lblNewLabel_6_1_1 = new JLabel("性别：");
        lblNewLabel_6_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_6_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_6_1_1.setBounds(117, 64, 94, 26);
        panel_tianjiaxuesheng_xtadmin.add(lblNewLabel_6_1_1);

        JLabel lblNewLabel_6_2_1 = new JLabel("入学年份：");
        lblNewLabel_6_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_6_2_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_6_2_1.setBounds(117, 100, 94, 26);
        panel_tianjiaxuesheng_xtadmin.add(lblNewLabel_6_2_1);

        JLabel lblNewLabel_6_3_1 = new JLabel("专业：");
        lblNewLabel_6_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_6_3_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_6_3_1.setBounds(117, 136, 94, 26);
        panel_tianjiaxuesheng_xtadmin.add(lblNewLabel_6_3_1);

        JLabel lblNewLabel_6_4_2 = new JLabel("联系方式：");
        lblNewLabel_6_4_2.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_6_4_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_6_4_2.setBounds(117, 244, 94, 26);
        panel_tianjiaxuesheng_xtadmin.add(lblNewLabel_6_4_2);

        JLabel lblNewLabel_6_5_1 = new JLabel("学部（院）：");
        lblNewLabel_6_5_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_6_5_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_6_5_1.setBounds(117, 208, 94, 26);
        panel_tianjiaxuesheng_xtadmin.add(lblNewLabel_6_5_1);

        JTextField textField_15 = new JTextField();
        textField_15.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_15.setColumns(10);
        textField_15.setBounds(237, 100, 146, 26);
        panel_tianjiaxuesheng_xtadmin.add(textField_15);

        JTextField textField_16 = new JTextField();
        textField_16.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_16.setColumns(10);
        textField_16.setBounds(237, 172, 146, 26);
        panel_tianjiaxuesheng_xtadmin.add(textField_16);

        JTextField textField_17 = new JTextField();
        textField_17.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_17.setColumns(10);
        textField_17.setBounds(237, 244, 146, 26);
        panel_tianjiaxuesheng_xtadmin.add(textField_17);

        JComboBox comboBox_2_3_1_2 = new JComboBox();
        comboBox_2_3_1_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBox_2_3_1_2.setBounds(237, 136, 146, 26);
        panel_tianjiaxuesheng_xtadmin.add(comboBox_2_3_1_2);

        JLabel lblNewLabel_6_4_1_1 = new JLabel("行政班：");
        lblNewLabel_6_4_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_6_4_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_6_4_1_1.setBounds(117, 172, 94, 26);
        panel_tianjiaxuesheng_xtadmin.add(lblNewLabel_6_4_1_1);

        JComboBox comboBox_2_3_1_1_1 = new JComboBox();
        comboBox_2_3_1_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBox_2_3_1_1_1.setBounds(237, 208, 146, 26);
        panel_tianjiaxuesheng_xtadmin.add(comboBox_2_3_1_1_1);

        JButton btnHomPage_jwadmin_2_2_1_1 = new JButton("确认");
        btnHomPage_jwadmin_2_2_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnHomPage_jwadmin_2_2_1_1.setBounds(423, 307, 100, 33);
        panel_tianjiaxuesheng_xtadmin.add(btnHomPage_jwadmin_2_2_1_1);

        JButton btnHomPage_jwadmin_2_2_1_1_1 = new JButton("返回");
        btnHomPage_jwadmin_2_2_1_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnHomPage_jwadmin_2_2_1_1_1.setBounds(10, 307, 100, 33);
        panel_tianjiaxuesheng_xtadmin.add(btnHomPage_jwadmin_2_2_1_1_1);

        // xtadmin右侧内容区 -> 用户管理 -> 添加用户 -> 内容区 -> 添加教师
        JPanel panel_tianjiajiaoshi_xtadmin = new JPanel();
        panel_tianjiajiaoshi_xtadmin.setLayout(null);
        panel_tianjiayonghu_sub_xtadmin.add(panel_tianjiajiaoshi_xtadmin, "name_416938202048200");

        JLabel lblNewLabel_8 = new JLabel("姓名：");
        lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_8.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_8.setBounds(119, 50, 94, 26);
        panel_tianjiajiaoshi_xtadmin.add(lblNewLabel_8);

        JLabel lblNewLabel_1_1 = new JLabel("性别：");
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_1_1.setBounds(119, 86, 94, 26);
        panel_tianjiajiaoshi_xtadmin.add(lblNewLabel_1_1);

        JLabel lblNewLabel_2_1 = new JLabel("入职年份：");
        lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_2_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_2_1.setBounds(119, 122, 94, 26);
        panel_tianjiajiaoshi_xtadmin.add(lblNewLabel_2_1);

        JLabel lblNewLabel_3_1 = new JLabel("职称：");
        lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_3_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_3_1.setBounds(119, 158, 94, 26);
        panel_tianjiajiaoshi_xtadmin.add(lblNewLabel_3_1);

        JLabel lblNewLabel_4_1 = new JLabel("学部（院）：");
        lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_4_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_4_1.setBounds(119, 194, 94, 26);
        panel_tianjiajiaoshi_xtadmin.add(lblNewLabel_4_1);

        JLabel lblNewLabel_5_1 = new JLabel("联系方式：");
        lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_5_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_5_1.setBounds(119, 230, 94, 26);
        panel_tianjiajiaoshi_xtadmin.add(lblNewLabel_5_1);

        JTextField textField_18 = new JTextField();
        textField_18.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_18.setColumns(10);
        textField_18.setBounds(239, 50, 146, 26);
        panel_tianjiajiaoshi_xtadmin.add(textField_18);

        JComboBox comboBox_2_4 = new JComboBox();
        comboBox_2_4.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBox_2_4.setBounds(239, 86, 68, 26);
        panel_tianjiajiaoshi_xtadmin.add(comboBox_2_4);

        JTextField textField_19 = new JTextField();
        textField_19.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_19.setColumns(10);
        textField_19.setBounds(239, 122, 146, 26);
        panel_tianjiajiaoshi_xtadmin.add(textField_19);

        JComboBox comboBox_2_1_1 = new JComboBox();
        comboBox_2_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBox_2_1_1.setBounds(239, 158, 146, 26);
        panel_tianjiajiaoshi_xtadmin.add(comboBox_2_1_1);

        JComboBox comboBox_2_2_1 = new JComboBox();
        comboBox_2_2_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBox_2_2_1.setBounds(239, 194, 146, 26);
        panel_tianjiajiaoshi_xtadmin.add(comboBox_2_2_1);

        JTextField textField_20 = new JTextField();
        textField_20.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_20.setColumns(10);
        textField_20.setBounds(239, 230, 146, 26);
        panel_tianjiajiaoshi_xtadmin.add(textField_20);

        JButton btnHomPage_jwadmin_2_2_2 = new JButton("确认");
        btnHomPage_jwadmin_2_2_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnHomPage_jwadmin_2_2_2.setBounds(423, 307, 100, 33);
        panel_tianjiajiaoshi_xtadmin.add(btnHomPage_jwadmin_2_2_2);

        JButton btnHomPage_jwadmin_2_2_1_1_2 = new JButton("返回");
        btnHomPage_jwadmin_2_2_1_1_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnHomPage_jwadmin_2_2_1_1_2.setBounds(10, 307, 100, 33);
        panel_tianjiajiaoshi_xtadmin.add(btnHomPage_jwadmin_2_2_1_1_2);


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

                } else if (e.getSource().equals(btnUserManagement_xtadmin)) {
                    panel_container_xtadmin.removeAll();
                    panel_container_xtadmin.add(panel_user_xtadmin);
                    panel_container_xtadmin.validate();
                    panel_container_xtadmin.repaint();
                    System.out.println("3");
                    panel_user_xtadmin.setVisible(true);

                } else if (e.getSource().equals(btn_jwadminList_xtadmin_1)) {
                    panel_userManege_xtadmin.removeAll();
                    panel_userManege_xtadmin.add(panel_tianjiayonghu_xtadmin);
                    panel_userManege_xtadmin.validate();
                    panel_userManege_xtadmin.repaint();
                    System.out.println("tianjiayonghu");
                    panel_tianjiayonghu_xtadmin.setVisible(true);
                    panel_container_xtadmin.removeAll();
                    panel_container_xtadmin.add(panel_userManege_xtadmin);
                    panel_container_xtadmin.validate();
                    panel_container_xtadmin.setVisible(true);

                } else if (e.getSource().equals(btnNewButton)) {
                    panel_container_xtadmin.removeAll();
                    panel_container_xtadmin.add(panel_user_xtadmin);
                    panel_container_xtadmin.validate();
                    panel_container_xtadmin.repaint();
                    panel_user_xtadmin.setVisible(true);

                }
            }
        };

        btnHomePage_xtadmin.addActionListener(actionlistenerXtadmin);
        btnUserManagement_xtadmin.addActionListener(actionlistenerXtadmin);
        btn_jwadminList_xtadmin_1.addActionListener(actionlistenerXtadmin);
        btnNewButton.addActionListener(actionlistenerXtadmin);
    }
}
