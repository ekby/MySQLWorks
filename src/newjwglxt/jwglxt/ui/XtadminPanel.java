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
import newjwglxt.jwglxt.util.SHA256;
import newjwglxt.jwglxt.util.ToPinYin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Vector;

import static newjwglxt.jwglxt.ui.MainWindow.contentPane;

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

        JButton btnEditInfo_xtadmin = new JButton("个人信息修改");
        btnEditInfo_xtadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnEditInfo_xtadmin.setBounds(10, 100, 130, 35);
        panel_category_xtadmin.add(btnEditInfo_xtadmin);

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
        btnExit_xtadmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contentPane.removeAll();
                LoginPanel loginPanel = new LoginPanel();
                contentPane.add(loginPanel.getPanel());
                contentPane.validate();
                contentPane.repaint();
                loginPanel.getPanel().setVisible(true);
                dbConnector.closeConnection();
            }
        });

        JLabel lblImg_xtadmin = new JLabel("头像");
        lblImg_xtadmin.setOpaque(true);
        lblImg_xtadmin.setHorizontalAlignment(SwingConstants.CENTER);
        lblImg_xtadmin.setBackground(Color.WHITE);
        lblImg_xtadmin.setBounds(10, 56, 110, 150);
        panel_homepage_xtadmin.add(lblImg_xtadmin);

        JLabel lblHello_xtadmin = new JLabel(String.format("%s，你好！", xtadmin_login.getName()));
        lblHello_xtadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblHello_xtadmin.setBounds(149, 56, 365, 35);
        panel_homepage_xtadmin.add(lblHello_xtadmin);

        JLabel lblId_xtadmin = new JLabel("职工号：");
        lblId_xtadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblId_xtadmin.setBounds(149, 101, 69, 24);
        panel_homepage_xtadmin.add(lblId_xtadmin);

        JLabel lblId_present_xtadmin = new JLabel(String.valueOf(xtadmin_login.getId()));
        lblId_present_xtadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblId_present_xtadmin.setBounds(219, 101, 88, 24);
        panel_homepage_xtadmin.add(lblId_present_xtadmin);

        JLabel lblGender_xtadmin = new JLabel("性别：");
        lblGender_xtadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblGender_xtadmin.setBounds(149, 135, 69, 24);
        panel_homepage_xtadmin.add(lblGender_xtadmin);

        JLabel lblGender_present_xtadmin = new JLabel(xtadmin_login.getGender());
        lblGender_present_xtadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblGender_present_xtadmin.setBounds(219, 135, 88, 24);
        panel_homepage_xtadmin.add(lblGender_present_xtadmin);

        JLabel lblcontact_jwadmin = new JLabel("联系方式：");
        lblcontact_jwadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblcontact_jwadmin.setBounds(343, 101, 88, 24);
        panel_homepage_xtadmin.add(lblcontact_jwadmin);

        JLabel lblcontact_pre_jw = new JLabel(xtadmin_login.getContact());
        lblcontact_pre_jw.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblcontact_pre_jw.setBounds(425, 101, 100, 24);
        panel_homepage_xtadmin.add(lblcontact_pre_jw);


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


        // xtadmin右侧内容区 -> 修改个人信息
        JPanel panel_editInfo_xtadmin = new JPanel();
        panel_container_xtadmin.add(panel_editInfo_xtadmin);
        panel_editInfo_xtadmin.setLayout(null);

        JLabel lbleditInfo_id = new JLabel("教职工号：");
        lbleditInfo_id.setHorizontalAlignment(SwingConstants.RIGHT);
        lbleditInfo_id.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lbleditInfo_id.setBounds(117, 135, 94, 26);
        panel_editInfo_xtadmin.add(lbleditInfo_id);

        JLabel lbleditInfo_name = new JLabel("姓名：");
        lbleditInfo_name.setHorizontalAlignment(SwingConstants.RIGHT);
        lbleditInfo_name.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lbleditInfo_name.setBounds(117, 171, 94, 26);
        panel_editInfo_xtadmin.add(lbleditInfo_name);

        JLabel lbleditInfo_pw = new JLabel("密码：");
        lbleditInfo_pw.setHorizontalAlignment(SwingConstants.RIGHT);
        lbleditInfo_pw.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lbleditInfo_pw.setBounds(117, 207, 94, 26);
        panel_editInfo_xtadmin.add(lbleditInfo_pw);

        JLabel lbleditInfo_gender = new JLabel("性别：");
        lbleditInfo_gender.setHorizontalAlignment(SwingConstants.RIGHT);
        lbleditInfo_gender.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lbleditInfo_gender.setBounds(117, 243, 94, 26);
        panel_editInfo_xtadmin.add(lbleditInfo_gender);

        JLabel lbleditInfo_contact = new JLabel("联系方式：");
        lbleditInfo_contact.setHorizontalAlignment(SwingConstants.RIGHT);
        lbleditInfo_contact.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lbleditInfo_contact.setBounds(117, 279, 94, 26);
        panel_editInfo_xtadmin.add(lbleditInfo_contact);

        // 教职工号
        JLabel textField_613 = new JLabel(String.valueOf(xtadmin_login.getId()));
        textField_613.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_613.setBounds(237, 135, 146, 26);
        panel_editInfo_xtadmin.add(textField_613);

        // 姓名
        JTextField textField_513 = new JTextField(xtadmin_login.getName());
        textField_513.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_513.setBounds(237, 171, 146, 26);
        panel_editInfo_xtadmin.add(textField_513);
        textField_513.setColumns(10);

        // 性别
        JComboBox comboBox_213 = new JComboBox(new String[]{"男", "女"});
        comboBox_213.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBox_213.setSelectedItem(xtadmin_login.getGender());
        comboBox_213.setBounds(237, 243, 68, 26);
        panel_editInfo_xtadmin.add(comboBox_213);

        // 密码
        JTextField textField_511 = new JTextField();
        textField_511.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_511.setBounds(237, 207, 146, 26);
        panel_editInfo_xtadmin.add(textField_511);
        textField_511.setColumns(10);

        // 联系方式
        JTextField textField_5111 = new JTextField(xtadmin_login.getContact());
        textField_5111.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_5111.setBounds(237, 279, 146, 26);
        panel_editInfo_xtadmin.add(textField_5111);
        textField_5111.setColumns(10);

        JButton btneditInfo_jwadmin = new JButton("确认");
        btneditInfo_jwadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btneditInfo_jwadmin.setBounds(443, 412, 100, 33);
        panel_editInfo_xtadmin.add(btneditInfo_jwadmin);
        btneditInfo_jwadmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("in");
                XtadminService xtadminService = new XtadminService();
                String new_name = textField_513.getText();
                String new_pw;
                String new_gender = (String) comboBox_213.getSelectedItem();
                String new_contact = textField_5111.getText();
                if (textField_511.getText().equals("")) new_pw = xtadmin_login.getPw();
                else new_pw = SHA256.SHA256(textField_511.getText());
                Xtadmin xtadmin = new Xtadmin(new_name, xtadmin_login.getId(), new_pw, new_gender, new_contact);
                // 更新数据库
                xtadminService.Update(dbConnector, xtadmin);
                // 更改xtadmin_login
                xtadmin_login.setName(new_name);
                xtadmin_login.setPw(new_pw);
                xtadmin_login.setGender(new_gender);
                xtadmin_login.setContact(new_contact);
                System.out.println(xtadmin_login);
                // 复位
                textField_511.setText("");
                textField_513.setText(new_name);
                comboBox_213.setSelectedItem(new_gender);
                textField_5111.setText(new_contact);
            }
        });

        // xtadmin右侧内容区 -> 修改人新信息 -> 标题区
        JPanel panel_title_edit_xtadmin = new JPanel();
        panel_title_edit_xtadmin.setLayout(null);
        panel_title_edit_xtadmin.setForeground(SystemColor.activeCaption);
        panel_title_edit_xtadmin.setBackground(SystemColor.scrollbar);
        panel_title_edit_xtadmin.setBounds(0, 0, 553, 46);
        panel_editInfo_xtadmin.add(panel_title_edit_xtadmin);

        JLabel lbl = new JLabel("个人信息修改");
        lbl.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lbl.setBounds(10, 10, 120, 22);
        panel_title_edit_xtadmin.add(lbl);


        // xtadmin右侧内容区 -> 用户管理
        JPanel panel_userManege_xtadmin = new JPanel();
        panel_container_xtadmin.add(panel_userManege_xtadmin);
        panel_userManege_xtadmin.setLayout(null);

        // xtadmin右侧内容区 -> 用户管理 -> 标题区
        JPanel panel_title_userManage_xtadmin = new JPanel();
        panel_title_userManage_xtadmin.setLayout(null);
        panel_title_userManage_xtadmin.setForeground(SystemColor.activeCaption);
        panel_title_userManage_xtadmin.setBackground(SystemColor.scrollbar);
        panel_title_userManage_xtadmin.setBounds(0, 0, 553, 46);
        panel_userManege_xtadmin.add(panel_title_userManage_xtadmin);

        JLabel lbl_tianjia_xtadmin_1_xueshengliebiao = new JLabel("用户管理 / 学生列表");
        lbl_tianjia_xtadmin_1_xueshengliebiao.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lbl_tianjia_xtadmin_1_xueshengliebiao.setBounds(10, 10, 234, 22);
        panel_title_userManage_xtadmin.add(lbl_tianjia_xtadmin_1_xueshengliebiao);

        JLabel lbl_tianjia_xtadmin_1_jiaozhigongliebiao = new JLabel("用户管理 / 教师列表");
        lbl_tianjia_xtadmin_1_jiaozhigongliebiao.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lbl_tianjia_xtadmin_1_jiaozhigongliebiao.setBounds(10, 10, 234, 22);
        panel_title_userManage_xtadmin.add(lbl_tianjia_xtadmin_1_jiaozhigongliebiao);

        JLabel lbl_tianjia_xtadmin_1_jiaowuliebiao = new JLabel("用户管理 / 教务列表");
        lbl_tianjia_xtadmin_1_jiaowuliebiao.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lbl_tianjia_xtadmin_1_jiaowuliebiao.setBounds(10, 10, 234, 22);
        panel_title_userManage_xtadmin.add(lbl_tianjia_xtadmin_1_jiaowuliebiao);

        JLabel lbl_tianjia_xtadmin_1_jiaowuliebiao1 = new JLabel("用户管理 / 添加用户");
        lbl_tianjia_xtadmin_1_jiaowuliebiao1.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lbl_tianjia_xtadmin_1_jiaowuliebiao1.setBounds(10, 10, 234, 22);
        panel_title_userManage_xtadmin.add(lbl_tianjia_xtadmin_1_jiaowuliebiao1);

        // sub区
        JPanel panel_userManage_sub_xtadmin = new JPanel();
        panel_userManege_xtadmin.add(panel_userManage_sub_xtadmin);
        panel_userManage_sub_xtadmin.setLayout(new CardLayout(0, 0));
        panel_userManage_sub_xtadmin.setBounds(0, 46, 543, 398);

        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_userManage_sub_xtadmin.add(panel_1);

        JButton btn_studentList_xtadmin = new JButton("学生列表");
        btn_studentList_xtadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btn_studentList_xtadmin.setBounds(10, 10, 100, 33);
        panel_1.add(btn_studentList_xtadmin);

        JButton btn_teacherList_xtadmin = new JButton("教师列表");
        btn_teacherList_xtadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btn_teacherList_xtadmin.setBounds(119, 10, 100, 33);
        panel_1.add(btn_teacherList_xtadmin);


        JButton btn_jwadminList_xtadmin = new JButton("教务列表");
        btn_jwadminList_xtadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btn_jwadminList_xtadmin.setBounds(229, 10, 100, 33);
        panel_1.add(btn_jwadminList_xtadmin);

        JButton btn_jwadminList_xtadmin_1 = new JButton("添加用户");
        btn_jwadminList_xtadmin_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btn_jwadminList_xtadmin_1.setBounds(443, 10, 100, 33);
        panel_1.add(btn_jwadminList_xtadmin_1);

        // xtadmin右侧内容区 -> 用户管理 -> 学生列表/教职工列表/教务列表 -> 表格区
        JPanel panel_listContainer = new JPanel();
        panel_listContainer.setBounds(10, 53, 533, 342);
        panel_1.add(panel_listContainer);
        panel_listContainer.setLayout(new CardLayout(0, 0));

        // xtadmin右侧内容区 -> 用户管理 -> 学生列表/教职工列表/教务列表 -> 表格区 -> 学生表
        JScrollPane scrollPane_5 = new JScrollPane();
        panel_listContainer.add(scrollPane_5);

        Vector<String> title_xueshengliebiao_jwadmin = new Vector<>();
        title_xueshengliebiao_jwadmin.add("学号");
        title_xueshengliebiao_jwadmin.add("姓名");
        title_xueshengliebiao_jwadmin.add("性别");
        title_xueshengliebiao_jwadmin.add("入学年份");
        title_xueshengliebiao_jwadmin.add("专业");
        title_xueshengliebiao_jwadmin.add("行政班");
        title_xueshengliebiao_jwadmin.add("学部（院）");
        title_xueshengliebiao_jwadmin.add("联系方式");

        StudentService studentService = new StudentService();
        Vector<Vector<Object>> dd = studentService.getAllStudentVector(dbConnector);

        JTable table_5 = new JTable();
        table_5.setModel(new DefaultTableModel(dd, title_xueshengliebiao_jwadmin) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        scrollPane_5.setViewportView(table_5);

        btn_studentList_xtadmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbl_tianjia_xtadmin_1_jiaozhigongliebiao.setVisible(false);
                lbl_tianjia_xtadmin_1_xueshengliebiao.setVisible(true);
                lbl_tianjia_xtadmin_1_jiaowuliebiao.setVisible(false);
                lbl_tianjia_xtadmin_1_jiaowuliebiao1.setVisible(false);

                panel_listContainer.removeAll();
                panel_listContainer.add(scrollPane_5);
                panel_listContainer.validate();
                panel_listContainer.repaint();
                scrollPane_5.setVisible(true);
            }
        });


        // xtadmin右侧内容区 -> 用户管理 -> 学生列表/教职工列表/教务列表 -> 表格区 -> 教职工表
        JScrollPane scrollPane_6 = new JScrollPane();
        panel_listContainer.add(scrollPane_6);

        Vector<String> title_jiaoshiliebiao_jwadmin = new Vector<>();
        title_jiaoshiliebiao_jwadmin.add("教师编号");
        title_jiaoshiliebiao_jwadmin.add("姓名");
        title_jiaoshiliebiao_jwadmin.add("性别");
        title_jiaoshiliebiao_jwadmin.add("入职年份");
        title_jiaoshiliebiao_jwadmin.add("职称");
        title_jiaoshiliebiao_jwadmin.add("学部（院）");
        title_jiaoshiliebiao_jwadmin.add("联系方式");

        JTable table_6 = new JTable();
        scrollPane_6.setViewportView(table_6);

        btn_teacherList_xtadmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbl_tianjia_xtadmin_1_jiaozhigongliebiao.setVisible(true);
                lbl_tianjia_xtadmin_1_xueshengliebiao.setVisible(false);
                lbl_tianjia_xtadmin_1_jiaowuliebiao.setVisible(false);
                lbl_tianjia_xtadmin_1_jiaowuliebiao1.setVisible(false);

                TeacherService teacherService = new TeacherService();
                Vector<Vector<Object>> data = teacherService.getAllTeacherVector_jwadmin(dbConnector);
                table_6.setModel(new DefaultTableModel(data, title_jiaoshiliebiao_jwadmin) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                });

                panel_listContainer.removeAll();
                panel_listContainer.add(scrollPane_6);
                panel_listContainer.validate();
                panel_listContainer.repaint();
                scrollPane_6.setVisible(true);
            }
        });
        // xtadmin右侧内容区 -> 用户管理 -> 学生列表/教职工列表/教务列表 -> 表格区 -> 教务表
        JScrollPane scrollPane_7 = new JScrollPane();
        panel_listContainer.add(scrollPane_7);

        Vector<String> title_jwadmin = new Vector<>();
        title_jwadmin.add("教职工号");
        title_jwadmin.add("姓名");
        title_jwadmin.add("性别");
        title_jwadmin.add("联系方式");

        JTable table_7 = new JTable();
        scrollPane_7.setViewportView(table_7);
        btn_jwadminList_xtadmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbl_tianjia_xtadmin_1_jiaozhigongliebiao.setVisible(false);
                lbl_tianjia_xtadmin_1_xueshengliebiao.setVisible(false);
                lbl_tianjia_xtadmin_1_jiaowuliebiao.setVisible(true);
                lbl_tianjia_xtadmin_1_jiaowuliebiao1.setVisible(false);

                JwadminService jwadminService = new JwadminService();
                Vector<Vector<Object>> data = jwadminService.getAllJwadminVector(dbConnector);
                table_7.setModel(new DefaultTableModel(data, title_jwadmin) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                });

                panel_listContainer.removeAll();
                panel_listContainer.add(scrollPane_7);
                panel_listContainer.validate();
                panel_listContainer.repaint();
                scrollPane_7.setVisible(true);
            }
        });


        // xtadmin右侧内容区 -> 用户管理 -> 添加用户
        JPanel panel_tianjiayonghu_xtadmin = new JPanel();
        panel_userManage_sub_xtadmin.add(panel_tianjiayonghu_xtadmin);
        panel_tianjiayonghu_xtadmin.setLayout(null);

        // xtadmin右侧内容区 -> 用户管理 -> 添加用户 -> 内容区
        JPanel panel_tianjia_1 = new JPanel();
        panel_tianjia_1.setLayout(null);
        panel_tianjia_1.setBounds(10, 10, 543, 431);
        panel_tianjiayonghu_xtadmin.add(panel_tianjia_1);

        JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("添加教师");
        rdbtnNewRadioButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        rdbtnNewRadioButton_2.setBounds(6, 6, 90, 23);
        panel_tianjia_1.add(rdbtnNewRadioButton_2);

        JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("添加学生");
        rdbtnNewRadioButton_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        rdbtnNewRadioButton_1_1.setBounds(99, 7, 90, 23);
        panel_tianjia_1.add(rdbtnNewRadioButton_1_1);

        JRadioButton rdbtnNewRadioButton_1_1_1 = new JRadioButton("添加教务管理员");
        rdbtnNewRadioButton_1_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        rdbtnNewRadioButton_1_1_1.setBounds(192, 7, 150, 23);
        panel_tianjia_1.add(rdbtnNewRadioButton_1_1_1);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rdbtnNewRadioButton_2);
        buttonGroup.add(rdbtnNewRadioButton_1_1);
        buttonGroup.add(rdbtnNewRadioButton_1_1_1);

        // xtadmin右侧内容区 -> 用户管理 -> 添加用户 -> 内容区 -> 添加教务管理员
        JPanel panel_tianjiayonghu_sub_xtadmin = new JPanel();
        panel_tianjiayonghu_sub_xtadmin.setBounds(0, 35, 543, 350);
        panel_tianjia_1.add(panel_tianjiayonghu_sub_xtadmin);
        panel_tianjiayonghu_sub_xtadmin.setLayout(new CardLayout(0, 0));

        JPanel panel_tianjiajiaowuguanliyuan_xtadmin = new JPanel();
        panel_tianjiayonghu_sub_xtadmin.add(panel_tianjiajiaowuguanliyuan_xtadmin, "name_415818239970300");
        panel_tianjiajiaowuguanliyuan_xtadmin.setLayout(null);

        rdbtnNewRadioButton_1_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel_tianjiayonghu_sub_xtadmin.removeAll();
                panel_tianjiayonghu_sub_xtadmin.add(panel_tianjiajiaowuguanliyuan_xtadmin);
                panel_tianjiayonghu_sub_xtadmin.validate();
                panel_tianjiayonghu_sub_xtadmin.repaint();
                panel_tianjiajiaowuguanliyuan_xtadmin.setVisible(true);
            }
        });

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

        JComboBox comboBox_4 = new JComboBox(new String[]{"男", "女"});
        comboBox_4.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBox_4.setBounds(243, 136, 68, 23);
        panel_tianjiajiaowuguanliyuan_xtadmin.add(comboBox_4);

        JButton btnNewButton = new JButton("返回");
        btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnNewButton.setBounds(0, 317, 100, 33);
        panel_tianjiajiaowuguanliyuan_xtadmin.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbl_tianjia_xtadmin_1_jiaozhigongliebiao.setVisible(false);
                lbl_tianjia_xtadmin_1_xueshengliebiao.setVisible(false);
                lbl_tianjia_xtadmin_1_jiaowuliebiao.setVisible(true);
                lbl_tianjia_xtadmin_1_jiaowuliebiao1.setVisible(false);

                panel_listContainer.removeAll();
                panel_listContainer.add(scrollPane_7);
                panel_listContainer.validate();
                panel_listContainer.repaint();
                scrollPane_7.setVisible(true);

                panel_userManage_sub_xtadmin.removeAll();
                panel_userManage_sub_xtadmin.add(panel_1);
                panel_userManage_sub_xtadmin.validate();
                panel_userManage_sub_xtadmin.repaint();
                panel_tianjia_1.setVisible(true);
            }
        });

        JButton btnNewButton_1 = new JButton("确认");
        btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnNewButton_1.setBounds(433, 317, 100, 33);
        panel_tianjiajiaowuguanliyuan_xtadmin.add(btnNewButton_1);
        btnNewButton_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String new_name = textField_10.getText();
                String new_gender = (String) comboBox_4.getSelectedItem();
                String new_contact = textField_13.getText();
                if (new_name.equals("") || new_contact.equals("")) {
                    System.out.println("有空值");
                } else {
                    String new_pw = SHA256.SHA256(ToPinYin.toPinyin(new_name));
                    Random random = new Random();
                    JwadminService jwadminService = new JwadminService();
                    int new_id;
                    do {
                        new_id = 10000 + random.nextInt(10000);
                    } while (jwadminService.ifIdExist(dbConnector, new_id));
                    Jwadmin jwadmin = new Jwadmin(new_name, new_id, new_pw, new_gender, new_contact);
                    jwadminService.Add(dbConnector, jwadmin);

                    textField_10.setText("");
                    comboBox_4.setSelectedIndex(0);
                    textField_13.setText("");
                }
            }
        });

        // xtadmin右侧内容区 -> 用户管理 -> 添加用户 -> 内容区 -> 添加学生
        JPanel panel_tianjiaxuesheng_xtadmin = new JPanel();
        panel_tianjiaxuesheng_xtadmin.setLayout(null);
        panel_tianjiayonghu_sub_xtadmin.add(panel_tianjiaxuesheng_xtadmin, "name_416787770067000");

        rdbtnNewRadioButton_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel_tianjiayonghu_sub_xtadmin.removeAll();
                panel_tianjiayonghu_sub_xtadmin.add(panel_tianjiaxuesheng_xtadmin);
                panel_tianjiayonghu_sub_xtadmin.validate();
                panel_tianjiayonghu_sub_xtadmin.repaint();
                panel_tianjiaxuesheng_xtadmin.setVisible(true);
            }
        });

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

        JComboBox comboBox_2_3_2 = new JComboBox(new String[]{"男", "女"});
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

        JTextField textField_17a = new JTextField();
        textField_17a.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_17a.setColumns(10);
        textField_17a.setBounds(237, 136, 146, 26);
        panel_tianjiaxuesheng_xtadmin.add(textField_17a);

        JLabel lblNewLabel_6_4_1_1 = new JLabel("行政班：");
        lblNewLabel_6_4_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_6_4_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_6_4_1_1.setBounds(117, 172, 94, 26);
        panel_tianjiaxuesheng_xtadmin.add(lblNewLabel_6_4_1_1);

        JComboBox comboBox_2_3_1_1_1 = new JComboBox(new String[]{"经济与管理学院", "文法学部", "信息学部", "理学部", "艺术设计学院"});
        comboBox_2_3_1_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBox_2_3_1_1_1.setBounds(237, 208, 146, 26);
        panel_tianjiaxuesheng_xtadmin.add(comboBox_2_3_1_1_1);

        JButton btnHomPage_jwadmin_2_2_1_1 = new JButton("确认");
        btnHomPage_jwadmin_2_2_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnHomPage_jwadmin_2_2_1_1.setBounds(433, 317, 100, 33);
        panel_tianjiaxuesheng_xtadmin.add(btnHomPage_jwadmin_2_2_1_1);
        btnHomPage_jwadmin_2_2_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String new_name = textField_14.getText();
                String new_gender = (String) comboBox_2_3_2.getSelectedItem();
                String new_major = textField_17a.getText();
                String new_class = textField_16.getText();
                String new_coll = (String) comboBox_2_3_1_1_1.getSelectedItem();
                String new_cont = textField_17.getText();
                String new_firstyear = textField_15.getText();
                if (new_name.equals("") || new_major.equals("") || new_class.equals("") || new_cont.equals("") || new_firstyear.equals("")) {
                    System.out.println("有空值");
                } else {
                    StudentService studentService = new StudentService();
                    int new_id;
                    Random random = new Random();
                    do {
                        new_id = 30000 + random.nextInt(10000);
                    } while (studentService.ifIdExist(dbConnector, new_id));
                    String new_pw = SHA256.SHA256(ToPinYin.toPinyin(new_name));
                    Student student = new Student(new_name, new_id, new_pw, new_gender, new_cont, Integer.parseInt(new_firstyear), Integer.parseInt(new_class), new_major, new_coll);
                    studentService.Add(dbConnector, student);
                    textField_14.setText("");
                    comboBox_2_3_2.setSelectedIndex(0);
                    textField_17a.setText("");
                    textField_16.setText("");
                    comboBox_2_3_1_1_1.setSelectedIndex(0);
                    textField_17.setText("");
                    textField_15.setText("");
                }
            }
        });

        JButton btnHomPage_jwadmin_2_2_1_1_1 = new JButton("返回");
        btnHomPage_jwadmin_2_2_1_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnHomPage_jwadmin_2_2_1_1_1.setBounds(0, 317, 100, 33);
        panel_tianjiaxuesheng_xtadmin.add(btnHomPage_jwadmin_2_2_1_1_1);
        btnHomPage_jwadmin_2_2_1_1_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbl_tianjia_xtadmin_1_jiaozhigongliebiao.setVisible(false);
                lbl_tianjia_xtadmin_1_xueshengliebiao.setVisible(true);
                lbl_tianjia_xtadmin_1_jiaowuliebiao.setVisible(false);
                lbl_tianjia_xtadmin_1_jiaowuliebiao1.setVisible(false);

                panel_listContainer.removeAll();
                panel_listContainer.add(scrollPane_5);
                panel_listContainer.validate();
                panel_listContainer.repaint();
                scrollPane_5.setVisible(true);

                panel_userManage_sub_xtadmin.removeAll();
                panel_userManage_sub_xtadmin.add(panel_1);
                panel_userManage_sub_xtadmin.validate();
                panel_userManage_sub_xtadmin.repaint();
                panel_tianjia_1.setVisible(true);
            }
        });

        // xtadmin右侧内容区 -> 用户管理 -> 添加用户 -> 内容区 -> 添加教师
        JPanel panel_tianjiajiaoshi_xtadmin = new JPanel();
        panel_tianjiajiaoshi_xtadmin.setLayout(null);
        panel_tianjiayonghu_sub_xtadmin.add(panel_tianjiajiaoshi_xtadmin, "name_416938202048200");

        rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel_tianjiayonghu_sub_xtadmin.removeAll();
                panel_tianjiayonghu_sub_xtadmin.add(panel_tianjiajiaoshi_xtadmin);
                panel_tianjiayonghu_sub_xtadmin.validate();
                panel_tianjiayonghu_sub_xtadmin.repaint();
                panel_tianjiajiaoshi_xtadmin.setVisible(true);
            }
        });

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

        JComboBox comboBox_2_4 = new JComboBox(new String[]{"男", "女"});
        comboBox_2_4.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBox_2_4.setBounds(239, 86, 68, 26);
        panel_tianjiajiaoshi_xtadmin.add(comboBox_2_4);

        JTextField textField_19 = new JTextField();
        textField_19.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_19.setColumns(10);
        textField_19.setBounds(239, 122, 146, 26);
        panel_tianjiajiaoshi_xtadmin.add(textField_19);

        JComboBox comboBox_2_1_1 = new JComboBox(new String[]{"讲师", "副教授", "教授", "院士"});
        comboBox_2_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBox_2_1_1.setBounds(239, 158, 146, 26);
        panel_tianjiajiaoshi_xtadmin.add(comboBox_2_1_1);

        JComboBox comboBox_2_2_1 = new JComboBox(new String[]{"经济与管理学院", "文法学部", "信息学部", "理学部", "艺术设计学院"});
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
        btnHomPage_jwadmin_2_2_2.setBounds(433, 317, 100, 33);
        panel_tianjiajiaoshi_xtadmin.add(btnHomPage_jwadmin_2_2_2);
        btnHomPage_jwadmin_2_2_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String new_name = textField_18.getText();
                String new_gender = (String) comboBox_2_4.getSelectedItem();
                String new_firstyear = textField_19.getText();
                String new_title = (String) comboBox_2_1_1.getSelectedItem();
                String new_coll = (String) comboBox_2_2_1.getSelectedItem();
                String new_cont = textField_20.getText();
                if (new_name.equals("") || new_firstyear.equals("") || new_cont.equals("")) {
                    System.out.println("有空值");
                } else {
                    String new_pw = SHA256.SHA256(ToPinYin.toPinyin(new_name));
                    TeacherService teacherService = new TeacherService();
                    Random random = new Random();
                    int new_id;
                    do {
                        new_id = 20000 + random.nextInt(10000);
                    } while (teacherService.ifIdExist(dbConnector, new_id));
                    Teacher teacher = new Teacher(new_name, new_id, new_pw, new_gender, new_cont, Integer.parseInt(new_firstyear), new_title, new_coll);
                    teacherService.Add(dbConnector, teacher);

                    textField_18.setText("");
                    comboBox_2_4.setSelectedIndex(0);
                    textField_19.setText("");
                    comboBox_2_1_1.setSelectedIndex(0);
                    comboBox_2_2_1.setSelectedIndex(0);
                    textField_20.setText("");
                }
            }
        });

        JButton btnHomPage_jwadmin_2_2_1_1_2 = new JButton("返回");
        btnHomPage_jwadmin_2_2_1_1_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnHomPage_jwadmin_2_2_1_1_2.setBounds(0, 317, 100, 33);
        panel_tianjiajiaoshi_xtadmin.add(btnHomPage_jwadmin_2_2_1_1_2);
        btnHomPage_jwadmin_2_2_1_1_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbl_tianjia_xtadmin_1_jiaozhigongliebiao.setVisible(true);
                lbl_tianjia_xtadmin_1_xueshengliebiao.setVisible(false);
                lbl_tianjia_xtadmin_1_jiaowuliebiao.setVisible(false);
                lbl_tianjia_xtadmin_1_jiaowuliebiao1.setVisible(false);

                panel_listContainer.removeAll();
                panel_listContainer.add(scrollPane_6);
                panel_listContainer.validate();
                panel_listContainer.repaint();
                scrollPane_6.setVisible(true);

                panel_userManage_sub_xtadmin.removeAll();
                panel_userManage_sub_xtadmin.add(panel_1);
                panel_userManage_sub_xtadmin.validate();
                panel_userManage_sub_xtadmin.repaint();
                panel_tianjia_1.setVisible(true);
            }
        });


        ActionListener actionlistenerXtadmin = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(btnHomePage_xtadmin)) {
                    // 主页
                    lblHello_xtadmin.setText(xtadmin_login.getName());
                    lblcontact_pre_jw.setText(xtadmin_login.getContact());
                    lblGender_present_xtadmin.setText(xtadmin_login.getGender());

                    panel_container_xtadmin.removeAll();
                    panel_container_xtadmin.add(panel_homepage_xtadmin);
                    panel_container_xtadmin.validate();
                    panel_container_xtadmin.repaint();
                    panel_homepage_xtadmin.setVisible(true);
                } else if (e.getSource().equals(btnUserManagement_xtadmin)) {
                    // 用户管理
                    lbl_tianjia_xtadmin_1_jiaozhigongliebiao.setVisible(false);
                    lbl_tianjia_xtadmin_1_xueshengliebiao.setVisible(true);
                    lbl_tianjia_xtadmin_1_jiaowuliebiao.setVisible(false);
                    lbl_tianjia_xtadmin_1_jiaowuliebiao1.setVisible(false);

                    rdbtnNewRadioButton_2.setSelected(true);
                    panel_userManage_sub_xtadmin.removeAll();
                    panel_userManage_sub_xtadmin.add(panel_1);
                    panel_userManage_sub_xtadmin.validate();
                    panel_userManage_sub_xtadmin.repaint();
                    panel_1.setVisible(true);

                    StudentService studentService = new StudentService();
                    Vector<Vector<Object>> data = studentService.getAllStudentVector(dbConnector);
                    table_5.setModel(new DefaultTableModel(data, title_xueshengliebiao_jwadmin) {
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    });

                    panel_listContainer.removeAll();
                    panel_listContainer.add(scrollPane_5);
                    panel_listContainer.validate();
                    panel_listContainer.repaint();
                    scrollPane_5.setVisible(true);

                    panel_container_xtadmin.removeAll();
                    panel_container_xtadmin.add(panel_userManege_xtadmin);
                    panel_container_xtadmin.validate();
                    panel_container_xtadmin.repaint();
                    System.out.println("3");
                    panel_userManege_xtadmin.setVisible(true);
                } else if (e.getSource().equals(btn_jwadminList_xtadmin_1)) {
                    // 添加用户
                    lbl_tianjia_xtadmin_1_jiaozhigongliebiao.setVisible(false);
                    lbl_tianjia_xtadmin_1_xueshengliebiao.setVisible(false);
                    lbl_tianjia_xtadmin_1_jiaowuliebiao.setVisible(false);
                    lbl_tianjia_xtadmin_1_jiaowuliebiao1.setVisible(true);

                    rdbtnNewRadioButton_2.setSelected(true);
                    panel_tianjiayonghu_sub_xtadmin.removeAll();
                    panel_tianjiayonghu_sub_xtadmin.add(panel_tianjiajiaoshi_xtadmin);
//                    panel_tianjiayonghu_sub_xtadmin.validate();
//                    panel_tianjiayonghu_sub_xtadmin.repaint();
//                    panel_tianjiajiaoshi_xtadmin.setVisible(true);

                    panel_userManage_sub_xtadmin.removeAll();
                    panel_userManage_sub_xtadmin.add(panel_tianjiayonghu_xtadmin);
                    panel_userManage_sub_xtadmin.validate();
                    panel_userManage_sub_xtadmin.repaint();
                    panel_tianjiayonghu_xtadmin.setVisible(true);
                } else if (e.getSource().equals(btnNewButton)) {
                    // 返回
                    panel_container_xtadmin.removeAll();
                    panel_container_xtadmin.add(panel_userManege_xtadmin);
                    panel_container_xtadmin.validate();
                    panel_container_xtadmin.repaint();
                    panel_userManege_xtadmin.setVisible(true);
                } else if (e.getSource().equals(btnEditInfo_xtadmin)) {
                    // 修改个人信息
                    panel_container_xtadmin.removeAll();
                    panel_container_xtadmin.add(panel_editInfo_xtadmin);
                    panel_container_xtadmin.validate();
                    panel_container_xtadmin.repaint();
                    panel_editInfo_xtadmin.setVisible(true);
                }
            }
        };
        btnHomePage_xtadmin.addActionListener(actionlistenerXtadmin);
        btnUserManagement_xtadmin.addActionListener(actionlistenerXtadmin);
        btn_jwadminList_xtadmin_1.addActionListener(actionlistenerXtadmin);
        btnNewButton.addActionListener(actionlistenerXtadmin);
        btnEditInfo_xtadmin.addActionListener(actionlistenerXtadmin);
    }
}
