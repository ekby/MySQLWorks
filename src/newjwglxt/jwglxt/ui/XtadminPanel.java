package newjwglxt.jwglxt.ui;

import newjwglxt.jwglxt.entity.Jwadmin;
import newjwglxt.jwglxt.entity.Xtadmin;
import newjwglxt.jwglxt.service.idx1.JwadminService;
import newjwglxt.jwglxt.service.idx1.XtadminService;
import newjwglxt.jwglxt.util.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.Vector;

import static newjwglxt.jwglxt.ui.MainWindow.contentPane;
import static newjwglxt.jwglxt.util.ComboboxStyle.setComboboxStyle;
import static newjwglxt.jwglxt.util.Judge.*;
import static newjwglxt.jwglxt.util.QuickButton.primaryBorderButton;
import static newjwglxt.jwglxt.util.TableStyle.setTableStyle;

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

        JButton btnHomePage_xtadmin = primaryBorderButton("主页");
        btnHomePage_xtadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnHomePage_xtadmin.setBounds(10, 10, 130, 35);
        panel_category_xtadmin.add(btnHomePage_xtadmin);

        JButton btnUserManagement_xtadmin = primaryBorderButton("用户管理");
        btnUserManagement_xtadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnUserManagement_xtadmin.setBounds(10, 55, 130, 35);
        panel_category_xtadmin.add(btnUserManagement_xtadmin);

        JButton btnEditInfo_xtadmin = primaryBorderButton("个人信息修改");
        btnEditInfo_xtadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnEditInfo_xtadmin.setBounds(10, 145, 130, 35);
        panel_category_xtadmin.add(btnEditInfo_xtadmin);

        JButton btnAbout_xtadmin = primaryBorderButton("关于");
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

        JButton btnExit_xtadmin = primaryBorderButton("更换账号");
        btnExit_xtadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnExit_xtadmin.setBounds(443, 56, 100, 33);
        panel_homepage_xtadmin.add(btnExit_xtadmin);
        btnExit_xtadmin.addActionListener(e -> {
            contentPane.removeAll();
            LoginPanel loginPanel = new LoginPanel();
            contentPane.add(loginPanel.getPanel());
            contentPane.validate();
            contentPane.repaint();
            loginPanel.getPanel().setVisible(true);
            dbConnector.closeConnection();
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
        textField_513.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        textField_513.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_513.setBounds(237, 171, 146, 26);
        panel_editInfo_xtadmin.add(textField_513);
        textField_513.setColumns(10);

        // 性别
        JComboBox comboBox_213 = new JComboBox(new String[]{"男", "女"});
        setComboboxStyle(comboBox_213);
        comboBox_213.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBox_213.setSelectedItem(xtadmin_login.getGender());
        comboBox_213.setBounds(237, 243, 68, 26);
        panel_editInfo_xtadmin.add(comboBox_213);

        // 密码
        JPasswordField textField_511 = new JPasswordField();
        textField_511.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        textField_511.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_511.setBounds(237, 207, 146, 26);
        panel_editInfo_xtadmin.add(textField_511);
        textField_511.setColumns(10);

        // 联系方式
        JTextField textField_5111 = new JTextField(xtadmin_login.getContact());
        textField_5111.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        textField_5111.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_5111.setBounds(237, 279, 146, 26);
        panel_editInfo_xtadmin.add(textField_5111);
        textField_5111.setColumns(10);

        JLabel lbleditInfo_genderm = new JLabel("请检查输入!");
        lbleditInfo_genderm.setHorizontalAlignment(SwingConstants.RIGHT);
        lbleditInfo_genderm.setForeground(Color.red);
        lbleditInfo_genderm.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lbleditInfo_genderm.setBounds(333, 412, 100, 33);
        panel_editInfo_xtadmin.add(lbleditInfo_genderm);
        lbleditInfo_genderm.setVisible(false);

        JButton btneditInfo_jwadmin = primaryBorderButton("确认");
        btneditInfo_jwadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btneditInfo_jwadmin.setBounds(443, 412, 100, 33);
        panel_editInfo_xtadmin.add(btneditInfo_jwadmin);
        btneditInfo_jwadmin.addActionListener(e -> {
            System.out.println("in");
            XtadminService xtadminService = new XtadminService();
            String new_name = textField_513.getText();
            String new_pw;
            String new_gender = (String) comboBox_213.getSelectedItem();
            String new_contact = textField_5111.getText();

            if (new_name.equals("") || isNum(new_name) || new_contact.equals("") || !isPhoneNum(new_contact)) {
                lbleditInfo_genderm.setVisible(true);
            } else {
                lbleditInfo_genderm.setVisible(false);
                if (textField_511.getText().equals("")) {
                    new_pw = xtadmin_login.getPw();
                } else new_pw = SHA256.SHA256(textField_511.getText());
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

//        JLabel lbl_tianjia_xtadmin_1_xueshengliebiao = new JLabel("用户管理 / 学生列表");
//        lbl_tianjia_xtadmin_1_xueshengliebiao.setFont(new Font("微软雅黑", Font.BOLD, 16));
//        lbl_tianjia_xtadmin_1_xueshengliebiao.setBounds(10, 10, 234, 22);
//        panel_title_userManage_xtadmin.add(lbl_tianjia_xtadmin_1_xueshengliebiao);
//
//        JLabel lbl_tianjia_xtadmin_1_jiaozhigongliebiao = new JLabel("用户管理 / 教师列表");
//        lbl_tianjia_xtadmin_1_jiaozhigongliebiao.setFont(new Font("微软雅黑", Font.BOLD, 16));
//        lbl_tianjia_xtadmin_1_jiaozhigongliebiao.setBounds(10, 10, 234, 22);
//        panel_title_userManage_xtadmin.add(lbl_tianjia_xtadmin_1_jiaozhigongliebiao);

        JLabel lbl_tianjia_xtadmin_1_jiaowuliebiao = new JLabel("用户管理 / 教务列表");
        lbl_tianjia_xtadmin_1_jiaowuliebiao.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lbl_tianjia_xtadmin_1_jiaowuliebiao.setBounds(10, 10, 234, 22);
        panel_title_userManage_xtadmin.add(lbl_tianjia_xtadmin_1_jiaowuliebiao);

        JLabel lbl_tianjia_xtadmin_1_jiaowuliebiao1a = new JLabel("用户管理 / 修改用户");
        lbl_tianjia_xtadmin_1_jiaowuliebiao1a.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lbl_tianjia_xtadmin_1_jiaowuliebiao1a.setBounds(10, 10, 234, 22);
        panel_title_userManage_xtadmin.add(lbl_tianjia_xtadmin_1_jiaowuliebiao1a);
        lbl_tianjia_xtadmin_1_jiaowuliebiao1a.setVisible(false);

        JLabel lbl_tianjia_xtadmin_1_jiaowuliebiao1 = new JLabel("用户管理 / 添加用户");
        lbl_tianjia_xtadmin_1_jiaowuliebiao1.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lbl_tianjia_xtadmin_1_jiaowuliebiao1.setBounds(10, 10, 234, 22);
        panel_title_userManage_xtadmin.add(lbl_tianjia_xtadmin_1_jiaowuliebiao1);
        lbl_tianjia_xtadmin_1_jiaowuliebiao1.setVisible(false);

        // sub区
        JPanel panel_userManage_sub_xtadmin = new JPanel();
        panel_userManege_xtadmin.add(panel_userManage_sub_xtadmin);
        panel_userManage_sub_xtadmin.setLayout(new CardLayout(0, 0));
        panel_userManage_sub_xtadmin.setBounds(0, 46, 543, 398);

        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);
        panel_userManage_sub_xtadmin.add(panel_1);

//        JButton btn_studentList_xtadmin = primaryBorderButton("学生列表");
//        btn_studentList_xtadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
//        btn_studentList_xtadmin.setBounds(10, 10, 100, 33);
//        panel_1.add(btn_studentList_xtadmin);
//
//        JButton btn_teacherList_xtadmin = primaryBorderButton("教师列表");
//        btn_teacherList_xtadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
//        btn_teacherList_xtadmin.setBounds(119, 10, 100, 33);
//        panel_1.add(btn_teacherList_xtadmin);
//
//        JButton btn_jwadminList_xtadmin = primaryBorderButton("教务列表");
//        btn_jwadminList_xtadmin.setFont(new Font("微软雅黑", Font.PLAIN, 13));
//        btn_jwadminList_xtadmin.setBounds(229, 10, 100, 33);
//        panel_1.add(btn_jwadminList_xtadmin);
//
        JButton btn_jwadminList_xtadmin_1a = primaryBorderButton("删除");
        btn_jwadminList_xtadmin_1a.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btn_jwadminList_xtadmin_1a.setBounds(313, 10, 70, 33);
        panel_1.add(btn_jwadminList_xtadmin_1a);

        JButton btn_jwadminList_xtadmin_1b = primaryBorderButton("编辑");
        btn_jwadminList_xtadmin_1b.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btn_jwadminList_xtadmin_1b.setBounds(393, 10, 70, 33);
        panel_1.add(btn_jwadminList_xtadmin_1b);

        JButton btn_jwadminList_xtadmin_1 = primaryBorderButton("添加");
        btn_jwadminList_xtadmin_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btn_jwadminList_xtadmin_1.setBounds(473, 10, 70, 33);
        panel_1.add(btn_jwadminList_xtadmin_1);

        // xtadmin右侧内容区 -> 用户管理 -> 学生列表/教职工列表/教务列表 -> 表格区
        JPanel panel_listContainer = new JPanel();
        panel_listContainer.setBounds(10, 53, 533, 342);
        panel_1.add(panel_listContainer);
        panel_listContainer.setLayout(new CardLayout(0, 0));

        // xtadmin右侧内容区 -> 用户管理 -> 学生列表/教职工列表/教务列表 -> 表格区 -> 学生表
//        JScrollPane scrollPane_5 = new JScrollPane();
//        panel_listContainer.add(scrollPane_5);
//
//        Vector<String> title_xueshengliebiao_jwadmin = new Vector<>();
//        title_xueshengliebiao_jwadmin.add("学号");
//        title_xueshengliebiao_jwadmin.add("姓名");
//        title_xueshengliebiao_jwadmin.add("性别");
//        title_xueshengliebiao_jwadmin.add("入学年份");
//        title_xueshengliebiao_jwadmin.add("专业");
//        title_xueshengliebiao_jwadmin.add("行政班");
//        title_xueshengliebiao_jwadmin.add("学部（院）");
//        title_xueshengliebiao_jwadmin.add("联系方式");
//
//        StudentService studentService = new StudentService();
//        Vector<Vector<Object>> dd = studentService.getAllStudentVector(dbConnector);
//
//        JTable table_5 = new JTable();
//        setTableStyle(table_5);
//        table_5.setModel(new DefaultTableModel(dd, title_xueshengliebiao_jwadmin) {
//            @Override
//            public boolean isCellEditable(int row, int column) {
//                return false;
//            }
//        });
//        table_5.getTableHeader().setReorderingAllowed(false);
//        scrollPane_5.setViewportView(table_5);

//        btn_studentList_xtadmin.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                lbl_tianjia_xtadmin_1_jiaozhigongliebiao.setVisible(false);
//                lbl_tianjia_xtadmin_1_xueshengliebiao.setVisible(true);
//                lbl_tianjia_xtadmin_1_jiaowuliebiao.setVisible(false);
//                lbl_tianjia_xtadmin_1_jiaowuliebiao1.setVisible(false);
//
//                panel_listContainer.removeAll();
//                panel_listContainer.add(scrollPane_5);
//                panel_listContainer.validate();
//                panel_listContainer.repaint();
//                scrollPane_5.setVisible(true);
//            }
//        });


        // xtadmin右侧内容区 -> 用户管理 -> 学生列表/教职工列表/教务列表 -> 表格区 -> 教职工表
//        JScrollPane scrollPane_6 = new JScrollPane();
//        panel_listContainer.add(scrollPane_6);
//
//        Vector<String> title_jiaoshiliebiao_jwadmin = new Vector<>();
//        title_jiaoshiliebiao_jwadmin.add("教师编号");
//        title_jiaoshiliebiao_jwadmin.add("姓名");
//        title_jiaoshiliebiao_jwadmin.add("性别");
//        title_jiaoshiliebiao_jwadmin.add("入职年份");
//        title_jiaoshiliebiao_jwadmin.add("职称");
//        title_jiaoshiliebiao_jwadmin.add("学部（院）");
//        title_jiaoshiliebiao_jwadmin.add("联系方式");
//
//        JTable table_6 = new JTable();
//        table_6.getTableHeader().setReorderingAllowed(false);
//        setTableStyle(table_6);
//        scrollPane_6.setViewportView(table_6);
//
//        btn_teacherList_xtadmin.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                lbl_tianjia_xtadmin_1_jiaozhigongliebiao.setVisible(true);
//                lbl_tianjia_xtadmin_1_xueshengliebiao.setVisible(false);
//                lbl_tianjia_xtadmin_1_jiaowuliebiao.setVisible(false);
//                lbl_tianjia_xtadmin_1_jiaowuliebiao1.setVisible(false);
//
//                TeacherService teacherService = new TeacherService();
//                Vector<Vector<Object>> data = teacherService.getAllTeacherVector_jwadmin(dbConnector);
//                table_6.setModel(new DefaultTableModel(data, title_jiaoshiliebiao_jwadmin) {
//                    @Override
//                    public boolean isCellEditable(int row, int column) {
//                        return false;
//                    }
//                });
//
//                panel_listContainer.removeAll();
//                panel_listContainer.add(scrollPane_6);
//                panel_listContainer.validate();
//                panel_listContainer.repaint();
//                scrollPane_6.setVisible(true);
//            }
//        });

        // xtadmin右侧内容区 -> 用户管理 -> 学生列表/教职工列表/教务列表 -> 表格区 -> 教务表
        JScrollPane scrollPane_7 = new JScrollPane();
        panel_listContainer.add(scrollPane_7);

        Vector<String> title_jwadmin = new Vector<>();
        title_jwadmin.add("教职工号");
        title_jwadmin.add("姓名");
        title_jwadmin.add("性别");
        title_jwadmin.add("联系方式");

        JTable table_7 = new JTable();
        table_7.getTableHeader().setReorderingAllowed(false);
        setTableStyle(table_7);
        scrollPane_7.setViewportView(table_7);

        btn_jwadminList_xtadmin_1a.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("jw");
                int id = (int) table_7.getValueAt(table_7.getSelectedRow(), 0);
                System.out.println(id);
                JwadminService jwadminService = new JwadminService();
                Jwadmin jwadmin = jwadminService.CheckById(dbConnector, id).get(0);
                jwadminService.Delete(dbConnector, jwadmin);

                Vector<Vector<Object>> data_jw = jwadminService.getAllJwadminVector(dbConnector);
                table_7.setModel(new DefaultTableModel(data_jw, title_jwadmin) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                });
                table_7.updateUI();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
//        btn_jwadminList_xtadmin.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                lbl_tianjia_xtadmin_1_jiaozhigongliebiao.setVisible(false);
//                lbl_tianjia_xtadmin_1_xueshengliebiao.setVisible(false);
//                lbl_tianjia_xtadmin_1_jiaowuliebiao.setVisible(true);
//                lbl_tianjia_xtadmin_1_jiaowuliebiao1.setVisible(false);
//
//                JwadminService jwadminService = new JwadminService();
//                Vector<Vector<Object>> data = jwadminService.getAllJwadminVector(dbConnector);
//                table_7.setModel(new DefaultTableModel(data, title_jwadmin) {
//                    @Override
//                    public boolean isCellEditable(int row, int column) {
//                        return false;
//                    }
//                });
//
//                panel_listContainer.removeAll();
//                panel_listContainer.add(scrollPane_7);
//                panel_listContainer.validate();
//                panel_listContainer.repaint();
//                scrollPane_7.setVisible(true);
//            }
//        });


        // xtadmin右侧内容区 -> 用户管理 -> 添加用户
        JPanel panel_tianjiayonghu_xtadmin = new JPanel();
        panel_userManage_sub_xtadmin.add(panel_tianjiayonghu_xtadmin);
        panel_tianjiayonghu_xtadmin.setLayout(null);

        // xtadmin右侧内容区 -> 用户管理 -> 添加用户 -> 内容区
        JPanel panel_tianjia_1 = new JPanel();
        panel_tianjia_1.setLayout(null);
        panel_tianjia_1.setBounds(10, 10, 543, 431);
        panel_tianjiayonghu_xtadmin.add(panel_tianjia_1);

//        JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("添加教师");
//        rdbtnNewRadioButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
//        rdbtnNewRadioButton_2.setBounds(6, 6, 90, 23);
//        panel_tianjia_1.add(rdbtnNewRadioButton_2);
//
//        JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("添加学生");
//        rdbtnNewRadioButton_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
//        rdbtnNewRadioButton_1_1.setBounds(99, 7, 90, 23);
//        panel_tianjia_1.add(rdbtnNewRadioButton_1_1);
//
//        JRadioButton rdbtnNewRadioButton_1_1_1 = new JRadioButton("添加教务管理员");
//        rdbtnNewRadioButton_1_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
//        rdbtnNewRadioButton_1_1_1.setBounds(192, 7, 150, 23);
//        panel_tianjia_1.add(rdbtnNewRadioButton_1_1_1);
//
//        ButtonGroup buttonGroup = new ButtonGroup();
//        buttonGroup.add(rdbtnNewRadioButton_2);
//        buttonGroup.add(rdbtnNewRadioButton_1_1);
//        buttonGroup.add(rdbtnNewRadioButton_1_1_1);

        // xtadmin右侧内容区 -> 用户管理 -> 添加用户 -> 内容区 -> 添加教务管理员
        JPanel panel_tianjiayonghu_sub_xtadmin = new JPanel();
        panel_tianjiayonghu_sub_xtadmin.setBounds(0, 35, 543, 350);
        panel_tianjia_1.add(panel_tianjiayonghu_sub_xtadmin);
        panel_tianjiayonghu_sub_xtadmin.setLayout(new CardLayout(0, 0));

        JPanel panel_tianjiajiaowuguanliyuan_xtadmin = new JPanel();
        panel_tianjiayonghu_sub_xtadmin.add(panel_tianjiajiaowuguanliyuan_xtadmin);
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
        textField_10.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        textField_10.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_10.setBounds(243, 98, 146, 26);
        panel_tianjiajiaowuguanliyuan_xtadmin.add(textField_10);
        textField_10.setColumns(10);

        JTextField textField_13 = new JTextField();
        textField_13.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        textField_13.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_13.setColumns(10);
        textField_13.setBounds(243, 170, 146, 26);
        panel_tianjiajiaowuguanliyuan_xtadmin.add(textField_13);

        JComboBox comboBox_4 = new JComboBox(new String[]{"男", "女"});
        setComboboxStyle(comboBox_4);
        comboBox_4.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBox_4.setBounds(243, 136, 68, 23);
        panel_tianjiajiaowuguanliyuan_xtadmin.add(comboBox_4);

        JButton btnNewButton = primaryBorderButton("返回");
        btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnNewButton.setBounds(0, 317, 100, 33);
        panel_tianjiajiaowuguanliyuan_xtadmin.add(btnNewButton);
        btnNewButton.addActionListener(e -> {
//            lbl_tianjia_xtadmin_1_jiaozhigongliebiao.setVisible(false);
//            lbl_tianjia_xtadmin_1_xueshengliebiao.setVisible(false);
            lbl_tianjia_xtadmin_1_jiaowuliebiao.setVisible(true);
            lbl_tianjia_xtadmin_1_jiaowuliebiao1.setVisible(false);
            lbl_tianjia_xtadmin_1_jiaowuliebiao1a.setVisible(false);

            JwadminService jwadminService = new JwadminService();
            table_7.setModel(new DefaultTableModel(jwadminService.getAllJwadminVector(dbConnector), title_jwadmin));

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
        });

        JLabel lblNewLabel_7_2g = new JLabel("请检查输入!");
        lblNewLabel_7_2g.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_7_2g.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_7_2g.setVisible(false);
        lblNewLabel_7_2g.setForeground(Color.red);
        lblNewLabel_7_2g.setBounds(323, 317, 100, 33);
        panel_tianjiajiaowuguanliyuan_xtadmin.add(lblNewLabel_7_2g);

//        rdbtnNewRadioButton_1_1_1.addActionListener(e -> {
//            lblNewLabel_7_2g.setVisible(false);
//            panel_tianjiayonghu_sub_xtadmin.removeAll();
//            panel_tianjiayonghu_sub_xtadmin.add(panel_tianjiajiaowuguanliyuan_xtadmin);
//            panel_tianjiayonghu_sub_xtadmin.validate();
//            panel_tianjiayonghu_sub_xtadmin.repaint();
//            panel_tianjiajiaowuguanliyuan_xtadmin.setVisible(true);
//        });

        JButton btnNewButton_1 = primaryBorderButton("确认");
        btnNewButton_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnNewButton_1.setBounds(433, 317, 100, 33);
        panel_tianjiajiaowuguanliyuan_xtadmin.add(btnNewButton_1);
        btnNewButton_1.addActionListener(e -> {
            String new_name = textField_10.getText();
            String new_gender = (String) comboBox_4.getSelectedItem();
            String new_contact = textField_13.getText();

            if (!isName(new_name) || !isPhoneNum(new_contact)) {
                lblNewLabel_7_2g.setVisible(true);
                System.out.println("有空值");
            } else {
                lblNewLabel_7_2g.setVisible(false);
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
        });

        // xtadmin右侧内容区 -> 用户管理 -> 编辑
        JPanel panel_tianjia_1y = new JPanel();
        panel_tianjia_1y.setLayout(null);
        panel_tianjia_1y.setBounds(10, 10, 543, 431);
        panel_tianjiayonghu_xtadmin.add(panel_tianjia_1y);

//        JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("添加教师");
//        rdbtnNewRadioButton_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
//        rdbtnNewRadioButton_2.setBounds(6, 6, 90, 23);
//        panel_tianjia_1.add(rdbtnNewRadioButton_2);
//
//        JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("添加学生");
//        rdbtnNewRadioButton_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
//        rdbtnNewRadioButton_1_1.setBounds(99, 7, 90, 23);
//        panel_tianjia_1.add(rdbtnNewRadioButton_1_1);
//
//        JRadioButton rdbtnNewRadioButton_1_1_1 = new JRadioButton("添加教务管理员");
//        rdbtnNewRadioButton_1_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
//        rdbtnNewRadioButton_1_1_1.setBounds(192, 7, 150, 23);
//        panel_tianjia_1.add(rdbtnNewRadioButton_1_1_1);
//
//        ButtonGroup buttonGroup = new ButtonGroup();
//        buttonGroup.add(rdbtnNewRadioButton_2);
//        buttonGroup.add(rdbtnNewRadioButton_1_1);
//        buttonGroup.add(rdbtnNewRadioButton_1_1_1);

        // xtadmin右侧内容区 -> 用户管理 -> 添加用户 -> 内容区 -> 添加教务管理员
        JPanel panel_tianjiayonghu_sub_xtadminy = new JPanel();
        panel_tianjiayonghu_sub_xtadminy.setBounds(0, 35, 543, 350);
        panel_tianjia_1.add(panel_tianjiayonghu_sub_xtadminy);
        panel_tianjiayonghu_sub_xtadminy.setLayout(new CardLayout(0, 0));

        JPanel panel_tianjiajiaowuguanliyuan_xtadminy = new JPanel();
        panel_tianjiayonghu_sub_xtadmin.add(panel_tianjiajiaowuguanliyuan_xtadminy);
        panel_tianjiajiaowuguanliyuan_xtadminy.setLayout(null);

        JLabel lblNewLabel_7yj = new JLabel("教职工号：");
        lblNewLabel_7yj.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_7yj.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_7yj.setBounds(121, 98 - 36, 94, 26);
        panel_tianjiajiaowuguanliyuan_xtadminy.add(lblNewLabel_7yj);

        JTextField textField_10yj = new JTextField();
        textField_10yj.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        textField_10yj.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_10yj.setBounds(243, 98 - 36, 146, 26);
        panel_tianjiajiaowuguanliyuan_xtadminy.add(textField_10yj);
        textField_10yj.setColumns(10);

        JLabel lblNewLabel_7y = new JLabel("姓名：");
        lblNewLabel_7y.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_7y.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_7y.setBounds(121, 98, 94, 26);
        panel_tianjiajiaowuguanliyuan_xtadminy.add(lblNewLabel_7y);

        JLabel lblNewLabel_7_1y = new JLabel("性别：");
        lblNewLabel_7_1y.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_7_1y.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_7_1y.setBounds(121, 134, 94, 26);
        panel_tianjiajiaowuguanliyuan_xtadminy.add(lblNewLabel_7_1y);

        JLabel lblNewLabel_7_2y = new JLabel("联系方式：");
        lblNewLabel_7_2y.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_7_2y.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_7_2y.setBounds(121, 170, 94, 26);
        panel_tianjiajiaowuguanliyuan_xtadminy.add(lblNewLabel_7_2y);

        JTextField textField_10y = new JTextField();
        textField_10y.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        textField_10y.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_10y.setBounds(243, 98, 146, 26);
        panel_tianjiajiaowuguanliyuan_xtadminy.add(textField_10y);
        textField_10y.setColumns(10);

        JTextField textField_13y = new JTextField();
        textField_13y.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        textField_13y.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_13y.setColumns(10);
        textField_13y.setBounds(243, 170, 146, 26);
        panel_tianjiajiaowuguanliyuan_xtadminy.add(textField_13y);

        JComboBox comboBox_4y = new JComboBox(new String[]{"男", "女"});
        setComboboxStyle(comboBox_4);
        comboBox_4y.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBox_4y.setBounds(243, 134, 68, 26);
        panel_tianjiajiaowuguanliyuan_xtadminy.add(comboBox_4y);

        textField_10yj.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String str;
                JwadminService jwadminService = new JwadminService();
                try {
                    str = e.getDocument().getText(0, textField_10yj.getDocument().getLength());
                    if (!str.equals("") && isJWID(str)) {
                        if (jwadminService.ifIdExist(dbConnector, Integer.parseInt(str))) {
                            System.out.printf("insert IN: %s\n", str);
                            Jwadmin jwadmin = jwadminService.CheckById(dbConnector, Integer.parseInt(str)).get(0);
                            textField_10y.setText(jwadmin.getName());
                            comboBox_4y.setSelectedItem(jwadmin.getGender());
                            textField_13y.setText(jwadmin.getContact());
                        } else {
                            textField_10y.setText("");
                            comboBox_4y.setSelectedIndex(0);
                            textField_13y.setText("");
                        }
                    }
                } catch (BadLocationException ex) {
                    throw new RuntimeException(ex);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String str;
                JwadminService jwadminService = new JwadminService();
                try {
                    str = e.getDocument().getText(0, textField_10yj.getDocument().getLength());
                    if (!str.equals("") && isJWID(str)) {
                        if (jwadminService.ifIdExist(dbConnector, Integer.parseInt(str))) {
                            System.out.printf("insert IN: %s\n", str);
                            Jwadmin jwadmin = jwadminService.CheckById(dbConnector, Integer.parseInt(str)).get(0);
                            textField_10y.setText(jwadmin.getName());
                            comboBox_4y.setSelectedItem(jwadmin.getGender());
                            textField_13y.setText(jwadmin.getContact());
                        } else {
                            textField_10y.setText("");
                            comboBox_4y.setSelectedIndex(0);
                            textField_13y.setText("");
                        }
                    }
                } catch (BadLocationException ex) {
                    throw new RuntimeException(ex);
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });

        JButton btnNewButtony = primaryBorderButton("返回");
        btnNewButtony.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnNewButtony.setBounds(0, 317, 100, 33);
        panel_tianjiajiaowuguanliyuan_xtadminy.add(btnNewButtony);
        btnNewButtony.addActionListener(e -> {
//            lbl_tianjia_xtadmin_1_jiaozhigongliebiao.setVisible(false);
//            lbl_tianjia_xtadmin_1_xueshengliebiao.setVisible(false);
            lbl_tianjia_xtadmin_1_jiaowuliebiao.setVisible(true);
            lbl_tianjia_xtadmin_1_jiaowuliebiao1.setVisible(false);
            lbl_tianjia_xtadmin_1_jiaowuliebiao1a.setVisible(false);

            JwadminService jwadminService = new JwadminService();
            table_7.setModel(new DefaultTableModel(jwadminService.getAllJwadminVector(dbConnector), title_jwadmin));

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
        });

        JLabel lblNewLabel_7_2gy = new JLabel("请检查输入!");
        lblNewLabel_7_2gy.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_7_2gy.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_7_2gy.setVisible(false);
        lblNewLabel_7_2gy.setForeground(Color.red);
        lblNewLabel_7_2gy.setBounds(323, 317, 100, 33);
        panel_tianjiajiaowuguanliyuan_xtadminy.add(lblNewLabel_7_2gy);

//        rdbtnNewRadioButton_1_1_1.addActionListener(e -> {
//            lblNewLabel_7_2g.setVisible(false);
//            panel_tianjiayonghu_sub_xtadmin.removeAll();
//            panel_tianjiayonghu_sub_xtadmin.add(panel_tianjiajiaowuguanliyuan_xtadmin);
//            panel_tianjiayonghu_sub_xtadmin.validate();
//            panel_tianjiayonghu_sub_xtadmin.repaint();
//            panel_tianjiajiaowuguanliyuan_xtadmin.setVisible(true);
//        });

        // 确认编辑
        JButton btnNewButton_1y = primaryBorderButton("确认");
        btnNewButton_1y.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnNewButton_1y.setBounds(433, 317, 100, 33);
        panel_tianjiajiaowuguanliyuan_xtadminy.add(btnNewButton_1y);
        btnNewButton_1y.addActionListener(e -> {
            String new_id = textField_10yj.getText();
            String new_name = textField_10y.getText();
            String new_gender = (String) comboBox_4y.getSelectedItem();
            String new_contact = textField_13y.getText();

            if (!isJWID(new_id) || !isName(new_name) || !isPhoneNum(new_contact)) {
                lblNewLabel_7_2gy.setVisible(true);
                System.out.println("有空值");
            } else {
                lblNewLabel_7_2gy.setVisible(false);
                JwadminService jwadminService = new JwadminService();
                Jwadmin jwadmin = new Jwadmin(new_name, Integer.parseInt(new_id), jwadminService.CheckById(dbConnector, Integer.parseInt(new_id)).get(0).getPw(), new_gender, new_contact);
                jwadminService.Update(dbConnector, jwadmin);

                textField_10yj.setText("");
                textField_10y.setText("");
                comboBox_4y.setSelectedIndex(0);
                textField_13y.setText("");
            }
        });

//        // xtadmin右侧内容区 -> 用户管理 -> 添加用户 -> 内容区 -> 添加学生
//        JPanel panel_tianjiaxuesheng_xtadmin = new JPanel();
//        panel_tianjiaxuesheng_xtadmin.setLayout(null);
//        panel_tianjiayonghu_sub_xtadmin.add(panel_tianjiaxuesheng_xtadmin);
//
//        JLabel lblNewLabel_6_6 = new JLabel("姓名：");
//        lblNewLabel_6_6.setHorizontalAlignment(SwingConstants.RIGHT);
//        lblNewLabel_6_6.setFont(new Font("微软雅黑", Font.PLAIN, 13));
//        lblNewLabel_6_6.setBounds(117, 28, 94, 26);
//        panel_tianjiaxuesheng_xtadmin.add(lblNewLabel_6_6);
//
//        JTextField textField_14 = new JTextField();
//        textField_14.setBorder(new QuickButton.RoundBorder(Color.black, 0));
//        textField_14.setFont(new Font("微软雅黑", Font.PLAIN, 13));
//        textField_14.setColumns(10);
//        textField_14.setBounds(237, 28, 146, 26);
//        panel_tianjiaxuesheng_xtadmin.add(textField_14);
//
//        JComboBox comboBox_2_3_2 = new JComboBox(new String[]{"男", "女"});
//        setComboboxStyle(comboBox_2_3_2);
//        comboBox_2_3_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
//        comboBox_2_3_2.setBounds(237, 64, 68, 26);
//        panel_tianjiaxuesheng_xtadmin.add(comboBox_2_3_2);
//
//        JLabel lblNewLabel_6_1_1 = new JLabel("性别：");
//        lblNewLabel_6_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
//        lblNewLabel_6_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
//        lblNewLabel_6_1_1.setBounds(117, 64, 94, 26);
//        panel_tianjiaxuesheng_xtadmin.add(lblNewLabel_6_1_1);
//
//        JLabel lblNewLabel_6_2_1 = new JLabel("入学年份：");
//        lblNewLabel_6_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
//        lblNewLabel_6_2_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
//        lblNewLabel_6_2_1.setBounds(117, 100, 94, 26);
//        panel_tianjiaxuesheng_xtadmin.add(lblNewLabel_6_2_1);
//
//        JLabel lblNewLabel_6_3_1 = new JLabel("专业：");
//        lblNewLabel_6_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
//        lblNewLabel_6_3_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
//        lblNewLabel_6_3_1.setBounds(117, 136, 94, 26);
//        panel_tianjiaxuesheng_xtadmin.add(lblNewLabel_6_3_1);
//
//        JLabel lblNewLabel_6_4_2 = new JLabel("联系方式：");
//        lblNewLabel_6_4_2.setHorizontalAlignment(SwingConstants.RIGHT);
//        lblNewLabel_6_4_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
//        lblNewLabel_6_4_2.setBounds(117, 244, 94, 26);
//        panel_tianjiaxuesheng_xtadmin.add(lblNewLabel_6_4_2);
//
//        JLabel lblNewLabel_6_5_1 = new JLabel("学部（院）：");
//        lblNewLabel_6_5_1.setHorizontalAlignment(SwingConstants.RIGHT);
//        lblNewLabel_6_5_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
//        lblNewLabel_6_5_1.setBounds(117, 208, 94, 26);
//        panel_tianjiaxuesheng_xtadmin.add(lblNewLabel_6_5_1);
//
//        JTextField textField_15 = new JTextField();
//        textField_15.setBorder(new QuickButton.RoundBorder(Color.black, 0));
//        textField_15.setFont(new Font("微软雅黑", Font.PLAIN, 13));
//        textField_15.setColumns(10);
//        textField_15.setBounds(237, 100, 146, 26);
//        panel_tianjiaxuesheng_xtadmin.add(textField_15);
//
//        JTextField textField_16 = new JTextField();
//        textField_16.setBorder(new QuickButton.RoundBorder(Color.black, 0));
//        textField_16.setFont(new Font("微软雅黑", Font.PLAIN, 13));
//        textField_16.setColumns(10);
//        textField_16.setBounds(237, 172, 146, 26);
//        panel_tianjiaxuesheng_xtadmin.add(textField_16);
//
//        JTextField textField_17 = new JTextField();
//        textField_17.setBorder(new QuickButton.RoundBorder(Color.black, 0));
//        textField_17.setFont(new Font("微软雅黑", Font.PLAIN, 13));
//        textField_17.setColumns(10);
//        textField_17.setBounds(237, 244, 146, 26);
//        panel_tianjiaxuesheng_xtadmin.add(textField_17);
//
//        JTextField textField_17a = new JTextField();
//        textField_17a.setBorder(new QuickButton.RoundBorder(Color.black, 0));
//        textField_17a.setFont(new Font("微软雅黑", Font.PLAIN, 13));
//        textField_17a.setColumns(10);
//        textField_17a.setBounds(237, 136, 146, 26);
//        panel_tianjiaxuesheng_xtadmin.add(textField_17a);
//
//        JLabel lblNewLabel_6_4_1_1 = new JLabel("行政班：");
//        lblNewLabel_6_4_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
//        lblNewLabel_6_4_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
//        lblNewLabel_6_4_1_1.setBounds(117, 172, 94, 26);
//        panel_tianjiaxuesheng_xtadmin.add(lblNewLabel_6_4_1_1);
//
//        JComboBox comboBox_2_3_1_1_1 = new JComboBox(new String[]{"经济与管理学院", "文法学部", "信息学部", "理学部", "艺术设计学院"});
//        setComboboxStyle(comboBox_2_3_1_1_1);
//        comboBox_2_3_1_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
//        comboBox_2_3_1_1_1.setBounds(237, 208, 146, 26);
//        panel_tianjiaxuesheng_xtadmin.add(comboBox_2_3_1_1_1);
//
//        JLabel lblNewLabel_7_2gn = new JLabel("请检查输入!");
//        lblNewLabel_7_2gn.setHorizontalAlignment(SwingConstants.RIGHT);
//        lblNewLabel_7_2gn.setFont(new Font("微软雅黑", Font.PLAIN, 13));
//        lblNewLabel_7_2gn.setVisible(false);
//        lblNewLabel_7_2gn.setForeground(Color.red);
//        lblNewLabel_7_2gn.setBounds(323, 317, 100, 33);
//        panel_tianjiaxuesheng_xtadmin.add(lblNewLabel_7_2gn);
//
//        rdbtnNewRadioButton_1_1.addActionListener(e -> {
//            lblNewLabel_7_2gn.setVisible(false);
//            panel_tianjiayonghu_sub_xtadmin.removeAll();
//            panel_tianjiayonghu_sub_xtadmin.add(panel_tianjiaxuesheng_xtadmin);
//            panel_tianjiayonghu_sub_xtadmin.validate();
//            panel_tianjiayonghu_sub_xtadmin.repaint();
//            panel_tianjiaxuesheng_xtadmin.setVisible(true);
//        });
//
//        JButton btnHomPage_jwadmin_2_2_1_1 = primaryBorderButton("确认");
//        btnHomPage_jwadmin_2_2_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
//        btnHomPage_jwadmin_2_2_1_1.setBounds(433, 317, 100, 33);
//        panel_tianjiaxuesheng_xtadmin.add(btnHomPage_jwadmin_2_2_1_1);
//        btnHomPage_jwadmin_2_2_1_1.addActionListener(e -> {
//            String new_name = textField_14.getText();
//            String new_gender = (String) comboBox_2_3_2.getSelectedItem();
//            String new_major = textField_17a.getText();
//            String new_class = textField_16.getText();
//            String new_coll = (String) comboBox_2_3_1_1_1.getSelectedItem();
//            String new_cont = textField_17.getText();
//            String new_firstyear = textField_15.getText();
//
//            if (new_name.equals("") || new_major.equals("") || new_class.equals("") || new_cont.equals("") || new_firstyear.equals("") ||
//                    isNum(new_name) || isNum(new_major) || !isNum(new_class) || !isPhoneNum(new_cont) || !isYear(new_firstyear)) {
//                lblNewLabel_7_2gn.setVisible(true);
//            } else {
//                lblNewLabel_7_2gn.setVisible(false);
//                StudentService studentService1 = new StudentService();
//                int new_id;
//                Random random = new Random();
//                do {
//                    new_id = 30000 + random.nextInt(10000);
//                } while (studentService1.ifIdExist(dbConnector, new_id));
//                String new_pw = SHA256.SHA256(ToPinYin.toPinyin(new_name));
//                Student student = new Student(new_name, new_id, new_pw, new_gender, new_cont, Integer.parseInt(new_firstyear), Integer.parseInt(new_class), new_major, new_coll);
//                studentService1.Add(dbConnector, student);
//                textField_14.setText("");
//                comboBox_2_3_2.setSelectedIndex(0);
//                textField_17a.setText("");
//                textField_16.setText("");
//                comboBox_2_3_1_1_1.setSelectedIndex(0);
//                textField_17.setText("");
//                textField_15.setText("");
//            }
//        });
//
//        JButton btnHomPage_jwadmin_2_2_1_1_1 = primaryBorderButton("返回");
//        btnHomPage_jwadmin_2_2_1_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
//        btnHomPage_jwadmin_2_2_1_1_1.setBounds(0, 317, 100, 33);
//        panel_tianjiaxuesheng_xtadmin.add(btnHomPage_jwadmin_2_2_1_1_1);
//        btnHomPage_jwadmin_2_2_1_1_1.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                lbl_tianjia_xtadmin_1_jiaozhigongliebiao.setVisible(false);
//                lbl_tianjia_xtadmin_1_xueshengliebiao.setVisible(true);
//                lbl_tianjia_xtadmin_1_jiaowuliebiao.setVisible(false);
//                lbl_tianjia_xtadmin_1_jiaowuliebiao1.setVisible(false);
//
//                panel_listContainer.removeAll();
//                panel_listContainer.add(scrollPane_5);
//                panel_listContainer.validate();
//                panel_listContainer.repaint();
//                scrollPane_5.setVisible(true);
//
//                panel_userManage_sub_xtadmin.removeAll();
//                panel_userManage_sub_xtadmin.add(panel_1);
//                panel_userManage_sub_xtadmin.validate();
//                panel_userManage_sub_xtadmin.repaint();
//                panel_tianjia_1.setVisible(true);
//            }
//        });
//
//        // xtadmin右侧内容区 -> 用户管理 -> 添加用户 -> 内容区 -> 添加教师
//        JPanel panel_tianjiajiaoshi_xtadmin = new JPanel();
//        panel_tianjiajiaoshi_xtadmin.setLayout(null);
//        panel_tianjiayonghu_sub_xtadmin.add(panel_tianjiajiaoshi_xtadmin, "name_416938202048200");
//
//
//        JLabel lblNewLabel_8 = new JLabel("姓名：");
//        lblNewLabel_8.setHorizontalAlignment(SwingConstants.RIGHT);
//        lblNewLabel_8.setFont(new Font("微软雅黑", Font.PLAIN, 13));
//        lblNewLabel_8.setBounds(119, 50, 94, 26);
//        panel_tianjiajiaoshi_xtadmin.add(lblNewLabel_8);
//
//        JLabel lblNewLabel_1_1 = new JLabel("性别：");
//        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
//        lblNewLabel_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
//        lblNewLabel_1_1.setBounds(119, 86, 94, 26);
//        panel_tianjiajiaoshi_xtadmin.add(lblNewLabel_1_1);
//
//        JLabel lblNewLabel_2_1 = new JLabel("入职年份：");
//        lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.RIGHT);
//        lblNewLabel_2_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
//        lblNewLabel_2_1.setBounds(119, 122, 94, 26);
//        panel_tianjiajiaoshi_xtadmin.add(lblNewLabel_2_1);
//
//        JLabel lblNewLabel_3_1 = new JLabel("职称：");
//        lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
//        lblNewLabel_3_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
//        lblNewLabel_3_1.setBounds(119, 158, 94, 26);
//        panel_tianjiajiaoshi_xtadmin.add(lblNewLabel_3_1);
//
//        JLabel lblNewLabel_4_1 = new JLabel("学部（院）：");
//        lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
//        lblNewLabel_4_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
//        lblNewLabel_4_1.setBounds(119, 194, 94, 26);
//        panel_tianjiajiaoshi_xtadmin.add(lblNewLabel_4_1);
//
//        JLabel lblNewLabel_5_1 = new JLabel("联系方式：");
//        lblNewLabel_5_1.setHorizontalAlignment(SwingConstants.RIGHT);
//        lblNewLabel_5_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
//        lblNewLabel_5_1.setBounds(119, 230, 94, 26);
//        panel_tianjiajiaoshi_xtadmin.add(lblNewLabel_5_1);
//
//        JTextField textField_18 = new JTextField();
//        textField_18.setBorder(new QuickButton.RoundBorder(Color.black, 0));
//        textField_18.setFont(new Font("微软雅黑", Font.PLAIN, 13));
//        textField_18.setColumns(10);
//        textField_18.setBounds(239, 50, 146, 26);
//        panel_tianjiajiaoshi_xtadmin.add(textField_18);
//
//        JComboBox comboBox_2_4 = new JComboBox(new String[]{"男", "女"});
//        setComboboxStyle(comboBox_2_4);
//        comboBox_2_4.setFont(new Font("微软雅黑", Font.PLAIN, 13));
//        comboBox_2_4.setBounds(239, 86, 68, 26);
//        panel_tianjiajiaoshi_xtadmin.add(comboBox_2_4);
//
//        JTextField textField_19 = new JTextField();
//        textField_19.setBorder(new QuickButton.RoundBorder(Color.black, 0));
//        textField_19.setFont(new Font("微软雅黑", Font.PLAIN, 13));
//        textField_19.setColumns(10);
//        textField_19.setBounds(239, 122, 146, 26);
//        panel_tianjiajiaoshi_xtadmin.add(textField_19);
//
//        JComboBox comboBox_2_1_1 = new JComboBox(new String[]{"讲师", "副教授", "教授", "院士"});
//        setComboboxStyle(comboBox_2_1_1);
//        comboBox_2_1_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
//        comboBox_2_1_1.setBounds(239, 158, 146, 26);
//        panel_tianjiajiaoshi_xtadmin.add(comboBox_2_1_1);
//
//        JComboBox comboBox_2_2_1 = new JComboBox(new String[]{"经济与管理学院", "文法学部", "信息学部", "理学部", "艺术设计学院"});
//
//        setComboboxStyle(comboBox_2_2_1);
//        comboBox_2_2_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
//        comboBox_2_2_1.setBounds(239, 194, 146, 26);
//        panel_tianjiajiaoshi_xtadmin.add(comboBox_2_2_1);
//
//        JTextField textField_20 = new JTextField();
//        textField_20.setBorder(new QuickButton.RoundBorder(Color.black, 0));
//        textField_20.setFont(new Font("微软雅黑", Font.PLAIN, 13));
//        textField_20.setColumns(10);
//        textField_20.setBounds(239, 230, 146, 26);
//        panel_tianjiajiaoshi_xtadmin.add(textField_20);
//
//        JLabel lblNewLabel_7_2gng = new JLabel("请检查输入!");
//        lblNewLabel_7_2gng.setHorizontalAlignment(SwingConstants.RIGHT);
//        lblNewLabel_7_2gng.setFont(new Font("微软雅黑", Font.PLAIN, 13));
//        lblNewLabel_7_2gng.setVisible(false);
//        lblNewLabel_7_2gng.setForeground(Color.red);
//        lblNewLabel_7_2gng.setBounds(323, 317, 100, 33);
//        panel_tianjiajiaoshi_xtadmin.add(lblNewLabel_7_2gng);
//
//        rdbtnNewRadioButton_2.addActionListener(e -> {
//            lblNewLabel_7_2gng.setVisible(false);
//            panel_tianjiayonghu_sub_xtadmin.removeAll();
//            panel_tianjiayonghu_sub_xtadmin.add(panel_tianjiajiaoshi_xtadmin);
//            panel_tianjiayonghu_sub_xtadmin.validate();
//            panel_tianjiayonghu_sub_xtadmin.repaint();
//            panel_tianjiajiaoshi_xtadmin.setVisible(true);
//        });
//
//        JButton btnHomPage_jwadmin_2_2_2 = primaryBorderButton("确认");
//        btnHomPage_jwadmin_2_2_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
//        btnHomPage_jwadmin_2_2_2.setBounds(433, 317, 100, 33);
//        panel_tianjiajiaoshi_xtadmin.add(btnHomPage_jwadmin_2_2_2);
//        btnHomPage_jwadmin_2_2_2.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String new_name = textField_18.getText();
//                String new_gender = (String) comboBox_2_4.getSelectedItem();
//                String new_firstyear = textField_19.getText();
//                String new_title = (String) comboBox_2_1_1.getSelectedItem();
//                String new_coll = (String) comboBox_2_2_1.getSelectedItem();
//                String new_cont = textField_20.getText();
//                if (new_name.equals("") || new_firstyear.equals("") || new_cont.equals("") ||
//                        isNum(new_name) || !isYear(new_firstyear) || !isPhoneNum(new_cont)) {
//                    lblNewLabel_7_2gng.setVisible(true);
//                } else {
//                    lblNewLabel_7_2gng.setVisible(false);
//                    String new_pw = SHA256.SHA256(ToPinYin.toPinyin(new_name));
//                    TeacherService teacherService = new TeacherService();
//                    Random random = new Random();
//                    int new_id;
//                    do {
//                        new_id = 20000 + random.nextInt(10000);
//                    } while (teacherService.ifIdExist(dbConnector, new_id));
//                    Teacher teacher = new Teacher(new_name, new_id, new_pw, new_gender, new_cont, Integer.parseInt(new_firstyear), new_title, new_coll);
//                    teacherService.Add(dbConnector, teacher);
//
//                    textField_18.setText("");
//                    comboBox_2_4.setSelectedIndex(0);
//                    textField_19.setText("");
//                    comboBox_2_1_1.setSelectedIndex(0);
//                    comboBox_2_2_1.setSelectedIndex(0);
//                    textField_20.setText("");
//                }
//            }
//        });
//
//        JButton btnHomPage_jwadmin_2_2_1_1_2 = primaryBorderButton("返回");
//        btnHomPage_jwadmin_2_2_1_1_2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
//        btnHomPage_jwadmin_2_2_1_1_2.setBounds(0, 317, 100, 33);
//        panel_tianjiajiaoshi_xtadmin.add(btnHomPage_jwadmin_2_2_1_1_2);
//        btnHomPage_jwadmin_2_2_1_1_2.addActionListener(e -> {
//            lbl_tianjia_xtadmin_1_jiaozhigongliebiao.setVisible(true);
//            lbl_tianjia_xtadmin_1_xueshengliebiao.setVisible(false);
//            lbl_tianjia_xtadmin_1_jiaowuliebiao.setVisible(false);
//            lbl_tianjia_xtadmin_1_jiaowuliebiao1.setVisible(false);
//
//            panel_listContainer.removeAll();
//            panel_listContainer.add(scrollPane_6);
//            panel_listContainer.validate();
//            panel_listContainer.repaint();
//            scrollPane_6.setVisible(true);
//
//            panel_userManage_sub_xtadmin.removeAll();
//            panel_userManage_sub_xtadmin.add(panel_1);
//            panel_userManage_sub_xtadmin.validate();
//            panel_userManage_sub_xtadmin.repaint();
//            panel_tianjia_1.setVisible(true);
//        });

        // 查找
        SelectFunc selectFunc = new SelectFunc("xtadmin", dbConnector, panel_category_xtadmin, 100, panel_container_xtadmin);


        ActionListener actionlistenerXtadmin = e -> {
            if (e.getSource().equals(btnHomePage_xtadmin)) {
                // 主页
                lblHello_xtadmin.setText(String.format("%s，你好！", xtadmin_login.getName()));
                lblcontact_pre_jw.setText(xtadmin_login.getContact());
                lblGender_present_xtadmin.setText(xtadmin_login.getGender());

                panel_container_xtadmin.removeAll();
                panel_container_xtadmin.add(panel_homepage_xtadmin);
                panel_container_xtadmin.validate();
                panel_container_xtadmin.repaint();
                panel_homepage_xtadmin.setVisible(true);
            } else if (e.getSource().equals(btnUserManagement_xtadmin)) {
                // 用户管理
//                lbl_tianjia_xtadmin_1_jiaozhigongliebiao.setVisible(false);
//                lbl_tianjia_xtadmin_1_xueshengliebiao.setVisible(true);
                lbl_tianjia_xtadmin_1_jiaowuliebiao.setVisible(true);
                lbl_tianjia_xtadmin_1_jiaowuliebiao1.setVisible(false);
                lbl_tianjia_xtadmin_1_jiaowuliebiao1a.setVisible(false);

//                rdbtnNewRadioButton_2.setSelected(true);
                panel_userManage_sub_xtadmin.removeAll();
                panel_userManage_sub_xtadmin.add(panel_1);
                panel_userManage_sub_xtadmin.validate();
                panel_userManage_sub_xtadmin.repaint();
                panel_1.setVisible(true);

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

                panel_container_xtadmin.removeAll();
                panel_container_xtadmin.add(panel_userManege_xtadmin);
                panel_container_xtadmin.validate();
                panel_container_xtadmin.repaint();
                System.out.println("3");
                panel_userManege_xtadmin.setVisible(true);
            } else if (e.getSource().equals(btn_jwadminList_xtadmin_1)) {
                // 添加用户
//                lbl_tianjia_xtadmin_1_jiaozhigongliebiao.setVisible(false);
//                lbl_tianjia_xtadmin_1_xueshengliebiao.setVisible(false);
                lbl_tianjia_xtadmin_1_jiaowuliebiao.setVisible(false);
                lbl_tianjia_xtadmin_1_jiaowuliebiao1.setVisible(true);
                lbl_tianjia_xtadmin_1_jiaowuliebiao1a.setVisible(false);

//                rdbtnNewRadioButton_2.setSelected(true);
                panel_tianjiayonghu_sub_xtadmin.removeAll();
                panel_tianjiayonghu_sub_xtadmin.add(panel_tianjiajiaowuguanliyuan_xtadmin);
//                    panel_tianjiayonghu_sub_xtadmin.validate();
//                    panel_tianjiayonghu_sub_xtadmin.repaint();
//                    panel_tianjiajiaoshi_xtadmin.setVisible(true);

                panel_userManage_sub_xtadmin.removeAll();
                panel_userManage_sub_xtadmin.add(panel_tianjiayonghu_xtadmin);
                panel_userManage_sub_xtadmin.validate();
                panel_userManage_sub_xtadmin.repaint();
                panel_tianjiayonghu_xtadmin.setVisible(true);
            } else if (e.getSource().equals(btn_jwadminList_xtadmin_1b)) {
                // 编辑用户
                lbl_tianjia_xtadmin_1_jiaowuliebiao.setVisible(false);
                lbl_tianjia_xtadmin_1_jiaowuliebiao1.setVisible(false);
                lbl_tianjia_xtadmin_1_jiaowuliebiao1a.setVisible(true);

                panel_tianjiayonghu_sub_xtadmin.removeAll();
                panel_tianjiayonghu_sub_xtadmin.add(panel_tianjiajiaowuguanliyuan_xtadminy);
                panel_userManage_sub_xtadmin.removeAll();
                panel_userManage_sub_xtadmin.add(panel_tianjiayonghu_xtadmin);
                panel_userManage_sub_xtadmin.validate();
                panel_userManage_sub_xtadmin.repaint();
                panel_tianjiayonghu_xtadmin.setVisible(true);
            } else if (e.getSource().equals(btnEditInfo_xtadmin)) {
                // 修改个人信息
                panel_container_xtadmin.removeAll();
                panel_container_xtadmin.add(panel_editInfo_xtadmin);
                panel_container_xtadmin.validate();
                panel_container_xtadmin.repaint();
                panel_editInfo_xtadmin.setVisible(true);
            } else if (e.getSource().equals(btnAbout_xtadmin)) {
                JPanel panel_about_xtadmin = new JPanel();
                panel_container_xtadmin.add(panel_about_xtadmin, "about");
                panel_about_xtadmin.setLayout(null);

                JPanel panel_title_about_xtadmin = new JPanel();
                panel_title_about_xtadmin.setLayout(null);
                panel_title_about_xtadmin.setForeground(SystemColor.activeCaption);
                panel_title_about_xtadmin.setBackground(SystemColor.scrollbar);
                panel_title_about_xtadmin.setBounds(0, 0, 553, 46);
                panel_about_xtadmin.add(panel_title_about_xtadmin);

                JLabel lbltitle_about = new JLabel("关于SPWD教务管理系统");
                lbltitle_about.setFont(new Font("微软雅黑", Font.BOLD, 16));
                lbltitle_about.setBounds(10, 10, 200, 22);
                panel_title_about_xtadmin.add(lbltitle_about);

                JLabel lbl_spa = new JLabel("SPWD教务管理系统");
                lbl_spa.setFont(new Font("Lucida Grande", Font.BOLD, 16));
                lbl_spa.setBounds(207, 149, 170, 28);
                panel_about_xtadmin.add(lbl_spa);

                JLabel lbl_spa_1 = new JLabel("Version 10.5.608");
                lbl_spa_1.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
                lbl_spa_1.setBounds(227, 174, 115, 28);
                panel_about_xtadmin.add(lbl_spa_1);

                JLabel lblNewLabel_3_1_1_1 = new JLabel("Developed by:");
                lblNewLabel_3_1_1_1.setBounds(185, 234, 95, 16);
                panel_about_xtadmin.add(lblNewLabel_3_1_1_1);

                JLabel lblNewLabel_3_1_1_1_1 = new JLabel("Xia Runcheng");
                lblNewLabel_3_1_1_1_1.setBounds(284, 234, 95, 16);
                panel_about_xtadmin.add(lblNewLabel_3_1_1_1_1);

                JLabel lblNewLabel_3_1_1_1_1_1 = new JLabel("Wang Handi");
                lblNewLabel_3_1_1_1_1_1.setBounds(284, 254, 95, 16);
                panel_about_xtadmin.add(lblNewLabel_3_1_1_1_1_1);

                JLabel lblNewLabel_3_1_1_1_1_1_1 = new JLabel("Dong Liyao");
                lblNewLabel_3_1_1_1_1_1_1.setBounds(284, 274, 95, 16);
                panel_about_xtadmin.add(lblNewLabel_3_1_1_1_1_1_1);

                JLabel lblNewLabel_3 = new JLabel("Copyright © 2022 SpecialWudi Inc. Practice makes PERFECT.");
                lblNewLabel_3.setBounds(86, 406, 391, 16);
                panel_about_xtadmin.add(lblNewLabel_3);

                JLabel lblNewLabel_3_1e = new JLabel("BJUT-11-B105 版权所有");
                lblNewLabel_3_1e.setBounds(205, 383, 147, 16);
                panel_about_xtadmin.add(lblNewLabel_3_1e);

                JLabel lblNewLabel_3_1_1 = new JLabel("客服电话：156XXXX9915");
                lblNewLabel_3_1_1.setBounds(201, 362, 181, 16);
                panel_about_xtadmin.add(lblNewLabel_3_1_1);

                ImageIcon img = new ImageIcon("src/newjwglxt/jwglxt/logo.png");
                Image image = img.getImage();
                image = image.getScaledInstance(64, 64, Image.SCALE_AREA_AVERAGING);
                img.setImage(image);

                JLabel label = new JLabel(img);
                label.setBounds(247, 73, 64, 64);
                panel_about_xtadmin.add(label);

                panel_container_xtadmin.removeAll();
                panel_container_xtadmin.add(panel_about_xtadmin);
                panel_container_xtadmin.validate();
                panel_container_xtadmin.repaint();
                System.out.println("about");
                panel_about_xtadmin.setVisible(true);

            }
        };
        btnHomePage_xtadmin.addActionListener(actionlistenerXtadmin);
        btnUserManagement_xtadmin.addActionListener(actionlistenerXtadmin);
        btn_jwadminList_xtadmin_1.addActionListener(actionlistenerXtadmin);
        btnEditInfo_xtadmin.addActionListener(actionlistenerXtadmin);
        btnAbout_xtadmin.addActionListener(actionlistenerXtadmin);
        btn_jwadminList_xtadmin_1b.addActionListener(actionlistenerXtadmin);
    }
}
