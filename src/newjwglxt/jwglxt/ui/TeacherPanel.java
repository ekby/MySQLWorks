package newjwglxt.jwglxt.ui;

import newjwglxt.jwglxt.entity.ChooseCourse;
import newjwglxt.jwglxt.entity.Teacher;
import newjwglxt.jwglxt.service.idx1.CourseService;
import newjwglxt.jwglxt.service.idx1.TeacherService;
import newjwglxt.jwglxt.service.idx2.ChooseCourseService;
import newjwglxt.jwglxt.util.DbConnector;
import newjwglxt.jwglxt.util.SHA256;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import static newjwglxt.jwglxt.ui.MainWindow.contentPane;

public class TeacherPanel {
    protected JPanel teacher;

    public JPanel getPanel() {
        return teacher;
    }

    public TeacherPanel(DbConnector dbConnector, Teacher teacher_login) {
        teacher = new JPanel();
        teacher.setLayout(null);
        teacher.setOpaque(false);
        MainWindow.contentPane.add(teacher, "name_611220147161800");

        // teacher左侧边栏
        JPanel panel_category_teacher = new JPanel();
        panel_category_teacher.setLayout(null);
        panel_category_teacher.setBounds(10, 10, 150, 451);
        teacher.add(panel_category_teacher);

        JButton btnHomePage_teacher = new JButton("主页");
        btnHomePage_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnHomePage_teacher.setBounds(10, 10, 130, 35);
        panel_category_teacher.add(btnHomePage_teacher);

        JButton btnCoursemanage_teacher = new JButton("我的课程");
        btnCoursemanage_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnCoursemanage_teacher.setBounds(10, 55, 130, 35);
        panel_category_teacher.add(btnCoursemanage_teacher);

        JButton btnScoreManage_teacher = new JButton("成绩管理");
        btnScoreManage_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnScoreManage_teacher.setBounds(10, 100, 130, 35);
        panel_category_teacher.add(btnScoreManage_teacher);

        JButton btnEditInfo_teacher = new JButton("个人信息修改");
        btnEditInfo_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnEditInfo_teacher.setBounds(10, 145, 130, 35);
        panel_category_teacher.add(btnEditInfo_teacher);

        JButton btnAbout_1 = new JButton("关于");
        btnAbout_1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnAbout_1.setBounds(10, 406, 130, 35);
        panel_category_teacher.add(btnAbout_1);

        // teacher右侧内容区
        JPanel panel_container_teacher = new JPanel();
        panel_container_teacher.setBounds(170, 10, 553, 451);
        teacher.add(panel_container_teacher);
        panel_container_teacher.setLayout(new CardLayout(0, 0));

        // teacher右侧内容区 -> 主页
        JPanel panel_homePage_teacher = new JPanel();
        panel_container_teacher.add(panel_homePage_teacher, "name_226288810767900");
        panel_homePage_teacher.setLayout(null);

        JButton btnExit_teacher = new JButton("更换账号");
        btnExit_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnExit_teacher.setBounds(443, 56, 100, 33);
        panel_homePage_teacher.add(btnExit_teacher);

        JLabel lblImg_teacher = new JLabel("头像");
        lblImg_teacher.setOpaque(true);
        lblImg_teacher.setHorizontalAlignment(SwingConstants.CENTER);
        lblImg_teacher.setBackground(Color.WHITE);
        lblImg_teacher.setBounds(10, 56, 110, 150);
        panel_homePage_teacher.add(lblImg_teacher);

        JLabel lblHello_teacher = new JLabel(String.format("%s, 你好！", teacher_login.getName()));
        lblHello_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblHello_teacher.setBounds(149, 56, 365, 35);
        panel_homePage_teacher.add(lblHello_teacher);

        JLabel lblTid_teacher = new JLabel("教职工号：");
        lblTid_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblTid_teacher.setBounds(149, 101, 69, 24);
        panel_homePage_teacher.add(lblTid_teacher);

        JLabel lblTid_present_teacher = new JLabel(String.valueOf(teacher_login.getId()));
        lblTid_present_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblTid_present_teacher.setBounds(219, 101, 88, 24);
        panel_homePage_teacher.add(lblTid_present_teacher);

        JLabel lblCollege_teacher = new JLabel("学部（院）：");
        lblCollege_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblCollege_teacher.setBounds(317, 101, 78, 24);
        panel_homePage_teacher.add(lblCollege_teacher);

        JLabel lblCollege_present_teacher = new JLabel(teacher_login.getTcollege());
        lblCollege_present_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblCollege_present_teacher.setBounds(400, 101, 134, 24);
        panel_homePage_teacher.add(lblCollege_present_teacher);

        JLabel lblGender_teacher = new JLabel("性别：");
        lblGender_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblGender_teacher.setBounds(149, 135, 69, 24);
        panel_homePage_teacher.add(lblGender_teacher);

        JLabel lblGender_present_teacher = new JLabel(teacher_login.getGender());
        lblGender_present_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblGender_present_teacher.setBounds(219, 135, 88, 24);
        panel_homePage_teacher.add(lblGender_present_teacher);

        JLabel lblFirstYear_teacher = new JLabel("入职年份：");
        lblFirstYear_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblFirstYear_teacher.setBounds(149, 169, 69, 24);
        panel_homePage_teacher.add(lblFirstYear_teacher);

        JLabel lblFirstYear_present_teacher = new JLabel(String.valueOf(teacher_login.getTfirstyear()));
        lblFirstYear_present_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblFirstYear_present_teacher.setBounds(219, 169, 88, 24);
        panel_homePage_teacher.add(lblFirstYear_present_teacher);

        JLabel lblTitle_teacher = new JLabel("职称：");
        lblTitle_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblTitle_teacher.setBounds(317, 135, 78, 24);
        panel_homePage_teacher.add(lblTitle_teacher);

        JLabel lblTitle_present_teacher = new JLabel(teacher_login.getTtitle());
        lblTitle_present_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblTitle_present_teacher.setBounds(400, 135, 167, 24);
        panel_homePage_teacher.add(lblTitle_present_teacher);

        JLabel lblContact_teacher = new JLabel("联系方式：");
        lblContact_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblContact_teacher.setBounds(317, 169, 78, 24);
        panel_homePage_teacher.add(lblContact_teacher);

        JLabel lblContact_present_teacher = new JLabel(teacher_login.getContact());
        lblContact_present_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblContact_present_teacher.setBounds(400, 169, 167, 24);
        panel_homePage_teacher.add(lblContact_present_teacher);

        // teacher右侧内容区 -> 主页 -> 标题区
        JPanel panel_title_zhuye_teacher = new JPanel();
        panel_title_zhuye_teacher.setLayout(null);
        panel_title_zhuye_teacher.setForeground(SystemColor.activeCaption);
        panel_title_zhuye_teacher.setBackground(SystemColor.scrollbar);
        panel_title_zhuye_teacher.setBounds(0, 0, 553, 46);
        panel_homePage_teacher.add(panel_title_zhuye_teacher);

        JLabel lblNewLabel_8_9 = new JLabel("主页");
        lblNewLabel_8_9.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lblNewLabel_8_9.setBounds(10, 10, 64, 22);
        panel_title_zhuye_teacher.add(lblNewLabel_8_9);


        // teacher右侧内容区 -> 我的课程
        JPanel panel_Coursemanage_teacher = new JPanel();
        panel_container_teacher.add(panel_Coursemanage_teacher, "name_225549232417500");
        panel_Coursemanage_teacher.setLayout(null);

        // teacher右侧内容区 -> 我的课程 -> 标题区
        JPanel panel_title_wodekecheng_teacher = new JPanel();
        panel_title_wodekecheng_teacher.setLayout(null);
        panel_title_wodekecheng_teacher.setForeground(SystemColor.activeCaption);
        panel_title_wodekecheng_teacher.setBackground(SystemColor.scrollbar);
        panel_title_wodekecheng_teacher.setBounds(0, 0, 553, 46);
        panel_Coursemanage_teacher.add(panel_title_wodekecheng_teacher);

        JLabel lbl_wodekecheng_teacher = new JLabel("我的课程");
        lbl_wodekecheng_teacher.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lbl_wodekecheng_teacher.setBounds(10, 10, 64, 22);
        panel_title_wodekecheng_teacher.add(lbl_wodekecheng_teacher);

        // teacher右侧内容区 -> 我的课程 -> 表格区
        JScrollPane scrollPane_3 = new JScrollPane();
        scrollPane_3.setBounds(10, 56, 533, 385);
        panel_Coursemanage_teacher.add(scrollPane_3);

        JTable table_mycourse = new JTable();
        scrollPane_3.setViewportView(table_mycourse);

        // teacher右侧内容区 -> 成绩管理
        CourseService courseService = new CourseService();

        JPanel panel_chengjiguanli_teacher = new JPanel();
        panel_container_teacher.add(panel_chengjiguanli_teacher, "name_225551826938200");
        panel_chengjiguanli_teacher.setLayout(null);

        JLabel lbl_xuanzekecheng_teacher = new JLabel("选择课程：");
        lbl_xuanzekecheng_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lbl_xuanzekecheng_teacher.setBounds(10, 56, 77, 34);
        panel_chengjiguanli_teacher.add(lbl_xuanzekecheng_teacher);

        JComboBox comboBox_chengjiguanli = new JComboBox();
        comboBox_chengjiguanli.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        comboBox_chengjiguanli.setBounds(84, 60, 145, 26);
        panel_chengjiguanli_teacher.add(comboBox_chengjiguanli);

        JButton btn_queren_teacher = new JButton("确认");
        btn_queren_teacher.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btn_queren_teacher.setBounds(443, 408, 100, 33);
        panel_chengjiguanli_teacher.add(btn_queren_teacher);

        // teacher右侧内容区 -> 成绩管理 -> 标题区
        JPanel panel_title_chengjiguanli_teacher = new JPanel();
        panel_title_chengjiguanli_teacher.setLayout(null);
        panel_title_chengjiguanli_teacher.setForeground(SystemColor.activeCaption);
        panel_title_chengjiguanli_teacher.setBackground(SystemColor.scrollbar);
        panel_title_chengjiguanli_teacher.setBounds(0, 0, 553, 46);
        panel_chengjiguanli_teacher.add(panel_title_chengjiguanli_teacher);

        JLabel lbl_chengjiguanli_teacher = new JLabel("成绩管理");
        lbl_chengjiguanli_teacher.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lbl_chengjiguanli_teacher.setBounds(10, 10, 64, 22);
        panel_title_chengjiguanli_teacher.add(lbl_chengjiguanli_teacher);

        // teacher右侧内容区 -> 成绩管理 -> 表格区
        JScrollPane scrollPane_4 = new JScrollPane();
        scrollPane_4.setBounds(10, 100, 533, 296);
        panel_chengjiguanli_teacher.add(scrollPane_4);

        JTable table_4 = new JTable();
        scrollPane_4.setViewportView(table_4);
        table_4.getTableHeader().setReorderingAllowed(false);

        final int[] selectedCourseID = new int[1];

        // teacher右侧内容区 -> 修改个人信息
        JPanel panel_editInfo_teacher = new JPanel();
        panel_container_teacher.add(panel_editInfo_teacher);
        panel_editInfo_teacher.setLayout(null);

        JLabel lbleditInfo_id = new JLabel("教职工号：");
        lbleditInfo_id.setHorizontalAlignment(SwingConstants.RIGHT);
        lbleditInfo_id.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lbleditInfo_id.setBounds(117, 90, 94, 26);
        panel_editInfo_teacher.add(lbleditInfo_id);

        JLabel lbleditInfo_name = new JLabel("姓名：");
        lbleditInfo_name.setHorizontalAlignment(SwingConstants.RIGHT);
        lbleditInfo_name.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lbleditInfo_name.setBounds(117, 126, 94, 26);
        panel_editInfo_teacher.add(lbleditInfo_name);

        JLabel lbleditInfo_pw = new JLabel("密码：");
        lbleditInfo_pw.setHorizontalAlignment(SwingConstants.RIGHT);
        lbleditInfo_pw.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lbleditInfo_pw.setBounds(117, 162, 94, 26);
        panel_editInfo_teacher.add(lbleditInfo_pw);

        JLabel lbleditInfo_gender = new JLabel("性别：");
        lbleditInfo_gender.setHorizontalAlignment(SwingConstants.RIGHT);
        lbleditInfo_gender.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lbleditInfo_gender.setBounds(117, 198, 94, 26);
        panel_editInfo_teacher.add(lbleditInfo_gender);

        JLabel lbleditInfo_firstyear = new JLabel("入职年份：");
        lbleditInfo_firstyear.setHorizontalAlignment(SwingConstants.RIGHT);
        lbleditInfo_firstyear.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lbleditInfo_firstyear.setBounds(117, 234, 94, 26);
        panel_editInfo_teacher.add(lbleditInfo_firstyear);

        JLabel lbleditInfo_coll = new JLabel("学部（院）：");
        lbleditInfo_coll.setHorizontalAlignment(SwingConstants.RIGHT);
        lbleditInfo_coll.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lbleditInfo_coll.setBounds(117, 270, 94, 26);
        panel_editInfo_teacher.add(lbleditInfo_coll);

        JLabel lbleditInfo_title = new JLabel("职称：");
        lbleditInfo_title.setHorizontalAlignment(SwingConstants.RIGHT);
        lbleditInfo_title.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lbleditInfo_title.setBounds(117, 306, 94, 26);
        panel_editInfo_teacher.add(lbleditInfo_title);

        JLabel lbleditInfo_contact = new JLabel("联系方式：");
        lbleditInfo_contact.setHorizontalAlignment(SwingConstants.RIGHT);
        lbleditInfo_contact.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lbleditInfo_contact.setBounds(117, 342, 94, 26);
        panel_editInfo_teacher.add(lbleditInfo_contact);

        // 教职工号
        JLabel textField_61 = new JLabel(String.valueOf(teacher_login.getId()));
        textField_61.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_61.setBounds(237, 90, 146, 26);
        panel_editInfo_teacher.add(textField_61);

        // 姓名
        JLabel textField_611 = new JLabel(String.valueOf(teacher_login.getName()));
        textField_611.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_611.setBounds(237, 126, 146, 26);
        panel_editInfo_teacher.add(textField_611);

        // 性别
        JLabel textField_612 = new JLabel(String.valueOf(teacher_login.getGender()));
        textField_612.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_612.setBounds(237, 198, 146, 26);
        panel_editInfo_teacher.add(textField_612);

        // 密码
        JPasswordField textField_511 = new JPasswordField();
        textField_511.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_511.setBounds(237, 162, 146, 26);
        panel_editInfo_teacher.add(textField_511);
        textField_511.setColumns(10);

        // 入职年份
        JLabel textField_6121 = new JLabel(String.valueOf(teacher_login.getTfirstyear()));
        textField_6121.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_6121.setBounds(237, 234, 146, 26);
        panel_editInfo_teacher.add(textField_6121);

        // 学院
        JLabel textField_6122 = new JLabel(String.valueOf(teacher_login.getTcollege()));
        textField_6122.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_6122.setBounds(237, 270, 146, 26);
        panel_editInfo_teacher.add(textField_6122);

        // 职称
        JLabel textField_6123 = new JLabel(String.valueOf(teacher_login.getTtitle()));
        textField_6123.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_6123.setBounds(237, 306, 146, 26);
        panel_editInfo_teacher.add(textField_6123);

        // 联系方式
        JTextField textField_5111 = new JTextField(teacher_login.getContact());
        textField_5111.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textField_5111.setBounds(237, 342, 146, 26);
        panel_editInfo_teacher.add(textField_5111);
        textField_5111.setColumns(10);

        JButton btneditInfo_confirm = new JButton("确认");
        btneditInfo_confirm.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btneditInfo_confirm.setBounds(443, 412, 100, 33);
        panel_editInfo_teacher.add(btneditInfo_confirm);
        btneditInfo_confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TeacherService teacherService = new TeacherService();
                String new_pw;
                if (textField_511.getText().equals(""))
                    new_pw = teacher_login.getPw();
                else
                    new_pw = SHA256.SHA256(textField_511.getText());

                System.out.println(textField_5111.getText());

                Teacher new_teacher = new Teacher(teacher_login.getName(), teacher_login.getId(), new_pw, teacher_login.getGender(), textField_5111.getText(), teacher_login.getTfirstyear(), teacher_login.getTtitle(), teacher_login.getTcollege());
                teacherService.Update(dbConnector, new_teacher);

                textField_5111.setText(teacherService.CheckById(dbConnector, teacher_login.getId()).get(0).getContact());

                // 密码框复位
                textField_511.setText("");
                // 联系方式重新从数据库读取
                textField_5111.setText(teacherService.CheckById(dbConnector, teacher_login.getId()).get(0).getContact());
                // 主页的联系方式重新从数据库读取
                lblContact_present_teacher.setText(teacherService.CheckById(dbConnector, teacher_login.getId()).get(0).getContact());
            }
        });

        // teacher右侧内容区 -> 修改个人信息 -> 标题区
        JPanel panel_title_edit_teacher = new JPanel();
        panel_title_edit_teacher.setLayout(null);
        panel_title_edit_teacher.setForeground(SystemColor.activeCaption);
        panel_title_edit_teacher.setBackground(SystemColor.scrollbar);
        panel_title_edit_teacher.setBounds(0, 0, 553, 46);
        panel_editInfo_teacher.add(panel_title_edit_teacher);

        JLabel lbl_edit_teacher = new JLabel("个人信息修改");
        lbl_edit_teacher.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lbl_edit_teacher.setBounds(10, 10, 100, 22);
        panel_title_edit_teacher.add(lbl_edit_teacher);

        ActionListener actionlistenerTeacher = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(btnHomePage_teacher)) {
                    panel_container_teacher.removeAll();
                    panel_container_teacher.add(panel_homePage_teacher);
                    panel_container_teacher.validate();
                    panel_container_teacher.repaint();
                    System.out.println("1");
                    panel_homePage_teacher.setVisible(true);

                } else if (e.getSource().equals(btnCoursemanage_teacher)) {
                    // 我的成绩
                    Vector<String> title_coursemanage_teacher = new Vector<>();
                    title_coursemanage_teacher.add("课程编号");
                    title_coursemanage_teacher.add("课程名称");
                    title_coursemanage_teacher.add("开课部门");
                    title_coursemanage_teacher.add("学分");
                    title_coursemanage_teacher.add("课程类别");
                    title_coursemanage_teacher.add("教室");
                    title_coursemanage_teacher.add("时间");
                    title_coursemanage_teacher.add("报名人数");
                    title_coursemanage_teacher.add("最大人数");

                    CourseService courseService = new CourseService();
                    Vector<Vector<Object>> data_coursemanage_teacher = courseService.getMyCourseVector_teacher(dbConnector, teacher_login);
                    DefaultTableModel new_model_mycourse_teacher = new DefaultTableModel(data_coursemanage_teacher, title_coursemanage_teacher) {
                        //设置table内容不能改，但能被选中行
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    };
                    table_mycourse.setModel(new_model_mycourse_teacher);
                    table_mycourse.getTableHeader().setReorderingAllowed(false);
                    table_mycourse.updateUI();

                    panel_container_teacher.removeAll();
                    panel_container_teacher.add(panel_Coursemanage_teacher);
                    panel_container_teacher.validate();
                    panel_container_teacher.repaint();
                    System.out.println("2");
                    panel_Coursemanage_teacher.setVisible(true);

                } else if (e.getSource().equals(btnScoreManage_teacher)) {
                    // 成绩管理
                    Vector<String> vector_myCourse_name = courseService.getMyCourseNameVector_teacher(dbConnector, teacher_login);
                    comboBox_chengjiguanli.setModel(new DefaultComboBoxModel(vector_myCourse_name));
                    Vector<String> title_xueshengfenshu = new Vector<>();
                    title_xueshengfenshu.add("学号");
                    title_xueshengfenshu.add("姓名");
                    title_xueshengfenshu.add("成绩");
                    if (vector_myCourse_name.isEmpty()) {
                        table_4.setModel(new DefaultTableModel(new Vector<String>() {
                        }, title_xueshengfenshu));
                    } else {
                        int firstID = getID(vector_myCourse_name.firstElement());
                        ChooseCourseService chooseCourseService = new ChooseCourseService();
                        Vector<Vector<Object>> data = chooseCourseService.getXueshengchengjibiaoVector(dbConnector, firstID);
                        table_4.setModel(new DefaultTableModel(data, title_xueshengfenshu));
                        table_4.updateUI();
                    }

                    panel_container_teacher.removeAll();
                    panel_container_teacher.add(panel_chengjiguanli_teacher);
                    panel_container_teacher.validate();
                    panel_container_teacher.repaint();
                    System.out.println("3");
                    panel_chengjiguanli_teacher.setVisible(true);
                } else if (e.getSource().equals(btn_queren_teacher)) {
                    System.out.println("确认");
                    int total_row = table_4.getRowCount();
                    for (int i = 0; i < total_row; i++) {
                        int sid = (int) table_4.getValueAt(i, 0);
                        int score = Integer.parseInt(table_4.getValueAt(i, 2).toString());
                        ChooseCourseService chooseCourseService = new ChooseCourseService();
                        ChooseCourse ccObject = chooseCourseService.CheckBySidAndCid(dbConnector, sid, selectedCourseID[0]).get(0);
                        ccObject.setCcscore(score);
                        ccObject.setCcgpa(getGPA(score));
                        chooseCourseService.Update(dbConnector, ccObject);
                        System.out.printf("---------> sid=%d, cid=%d, score=%d, gpa=%d%n", sid, selectedCourseID[0], score, getGPA(score));
                    }
                } else if (e.getSource().equals(btnExit_teacher)) {
                    contentPane.removeAll();
                    LoginPanel loginPanel = new LoginPanel();
                    contentPane.add(loginPanel.getPanel());
                    contentPane.validate();
                    contentPane.repaint();
                    loginPanel.getPanel().setVisible(true);

                    dbConnector.closeConnection();
                } else if (e.getSource().equals(btnEditInfo_teacher)) {
                    panel_container_teacher.removeAll();
                    panel_container_teacher.add(panel_editInfo_teacher);
                    panel_container_teacher.validate();
                    panel_container_teacher.repaint();
                    System.out.println("pe");
                    panel_chengjiguanli_teacher.setVisible(true);
                }
            }
        };
        btnHomePage_teacher.addActionListener(actionlistenerTeacher);
        btnCoursemanage_teacher.addActionListener(actionlistenerTeacher);
        btnScoreManage_teacher.addActionListener(actionlistenerTeacher);
        btn_queren_teacher.addActionListener(actionlistenerTeacher);
        btnExit_teacher.addActionListener(actionlistenerTeacher);
        btnEditInfo_teacher.addActionListener(actionlistenerTeacher);

        // 成绩管理JComboBox的监听器
        ItemListener itemListener = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println(e.getItem());
                    for (String str : courseService.getMyCourseNameVector_teacher(dbConnector, teacher_login)) {
                        if (e.getItem().equals(str)) {
                            selectedCourseID[0] = getID(str);
                            ChooseCourseService chooseCourseService = new ChooseCourseService();
                            Vector<Vector<Object>> data_xueshengfenshu = chooseCourseService.getXueshengchengjibiaoVector(dbConnector, selectedCourseID[0]);
                            Vector<String> title_xueshengfenshu = new Vector<>();
                            title_xueshengfenshu.add("学号");
                            title_xueshengfenshu.add("姓名");
                            title_xueshengfenshu.add("成绩");
                            DefaultTableModel model_chengjibiao = new DefaultTableModel(data_xueshengfenshu, title_xueshengfenshu) {
                                //设置table内容不能改，但能被选中行(除了第三列成绩)
                                @Override
                                public boolean isCellEditable(int row, int column) {
                                    if (column == 2)
                                        return true;
                                    else
                                        return false;
                                }
                            };
                            table_4.setModel(model_chengjibiao);
                            table_4.updateUI();
                        }
                    }
                }
            }
        };
        comboBox_chengjiguanli.addItemListener(itemListener);
    }

    // 从[1]大学英语得到1
    private static int getID(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= 4; i++) {
            if (str.charAt(i) == ']') {
                break;
            } else {
                stringBuilder.append(str.charAt(i));
            }
        }
        return Integer.parseInt(String.valueOf(stringBuilder));
    }

    // 从100分得到4绩点
    private static int getGPA(int score) {
        if (score >= 85)
            return 4;
        else if (score >= 70)
            return 3;
        else if (score >= 60)
            return 2;
        else
            return 0;
    }

}