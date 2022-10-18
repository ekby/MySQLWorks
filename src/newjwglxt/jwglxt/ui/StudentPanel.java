package newjwglxt.jwglxt.ui;

import newjwglxt.jwglxt.entity.Course;
import newjwglxt.jwglxt.entity.CourseTable;
import newjwglxt.jwglxt.entity.Student;
import newjwglxt.jwglxt.service.idx1.CourseService;
import newjwglxt.jwglxt.util.Db;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Vector;

public class StudentPanel {
    protected JPanel student;

    public JPanel getPanel() {
        return student;
    }

    public StudentPanel(Student student_login) {
        student = new JPanel();
        student.setOpaque(false);
        MainWindow.contentPane.add(student, "name_601806090402700");
        student.setLayout(null);

        JPanel panel_category_student = new JPanel();
        panel_category_student.setBounds(10, 10, 150, 451);
        student.add(panel_category_student);
        panel_category_student.setLayout(null);

        JButton btnHomePage_student = new JButton("主页");
        btnHomePage_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnHomePage_student.setBounds(10, 10, 130, 35);
        panel_category_student.add(btnHomePage_student);

        JButton btnMyCourse_student = new JButton("我的课程");
        btnMyCourse_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnMyCourse_student.setBounds(10, 55, 130, 35);
        panel_category_student.add(btnMyCourse_student);

        JButton btnGrade_student = new JButton("查询成绩");
        btnGrade_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnGrade_student.setBounds(10, 100, 130, 35);
        panel_category_student.add(btnGrade_student);

        JButton btnShowtable_student = new JButton("课表查询");
        btnShowtable_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnShowtable_student.setBounds(10, 145, 130, 35);
        panel_category_student.add(btnShowtable_student);

        JButton btnChangeInfo_student = new JButton("个人信息修改");
        btnChangeInfo_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnChangeInfo_student.setBounds(10, 190, 130, 35);
        panel_category_student.add(btnChangeInfo_student);

        JButton btnAbout_student = new JButton("关于");
        btnAbout_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnAbout_student.setBounds(10, 406, 130, 35);
        panel_category_student.add(btnAbout_student);

        JPanel panel_container_student = new JPanel();
        panel_container_student.setBounds(170, 10, 549, 451);
        student.add(panel_container_student);
        CardLayout cl_panel_container_student = new CardLayout();
        panel_container_student.setLayout(cl_panel_container_student);

        JPanel panel_homePage_student = new JPanel();
        panel_container_student.add(panel_homePage_student, "主页");
        panel_homePage_student.setLayout(null);

        JLabel lblImg_student = new JLabel("头像");
        lblImg_student.setHorizontalAlignment(SwingConstants.CENTER);
        lblImg_student.setOpaque(true);
        lblImg_student.setBackground(Color.WHITE);
        lblImg_student.setBounds(10, 10, 110, 150);
        panel_homePage_student.add(lblImg_student);

        JLabel lblHello_student = new JLabel(student_login.getName() + "你好!");
        lblHello_student.setBounds(149, 19, 61, 16);
        panel_homePage_student.add(lblHello_student);

        JLabel lblSid_student = new JLabel("学号：");
        lblSid_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblSid_student.setBounds(149, 55, 69, 24);
        panel_homePage_student.add(lblSid_student);

        JLabel lblSid_present_student = new JLabel(Integer.toString(student_login.getId()));
        lblSid_present_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblSid_present_student.setBounds(219, 55, 88, 24);
        panel_homePage_student.add(lblSid_present_student);

        JLabel lblCollege_student = new JLabel("学部（院）：");
        lblCollege_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblCollege_student.setBounds(317, 55, 78, 24);
        panel_homePage_student.add(lblCollege_student);

        JLabel lblCollege_present_student = new JLabel(student_login.getScollege());
        lblCollege_present_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblCollege_present_student.setBounds(400, 55, 134, 24);
        panel_homePage_student.add(lblCollege_present_student);

        JLabel lblGender_student = new JLabel("性别：");
        lblGender_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblGender_student.setBounds(149, 89, 69, 24);
        panel_homePage_student.add(lblGender_student);

        JLabel lblGender_present_student = new JLabel(student_login.getGender());
        lblGender_present_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblGender_present_student.setBounds(219, 89, 88, 24);
        panel_homePage_student.add(lblGender_present_student);

        JLabel lblMajor_student = new JLabel("专业：");
        lblMajor_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblMajor_student.setBounds(317, 89, 78, 24);
        panel_homePage_student.add(lblMajor_student);

        JLabel lblMajor_present_student = new JLabel(student_login.getSmajor());
        lblMajor_present_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblMajor_present_student.setBounds(400, 89, 134, 24);
        panel_homePage_student.add(lblMajor_present_student);

        JLabel lblFirstYear_student = new JLabel("入学年份：");
        lblFirstYear_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblFirstYear_student.setBounds(149, 123, 69, 24);
        panel_homePage_student.add(lblFirstYear_student);

        JLabel lblFirstYear_present_student = new JLabel(Integer.toString(student_login.getSfirstyear()));
        lblFirstYear_present_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblFirstYear_present_student.setBounds(219, 123, 88, 24);
        panel_homePage_student.add(lblFirstYear_present_student);

        JLabel lblClasses_student = new JLabel("行政班：");
        lblClasses_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblClasses_student.setBounds(317, 123, 78, 24);
        panel_homePage_student.add(lblClasses_student);

        JLabel lblClasses_present_student = new JLabel(Integer.toString(student_login.getSclass()));
        lblClasses_present_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblClasses_present_student.setBounds(400, 123, 134, 24);
        panel_homePage_student.add(lblClasses_present_student);

        JPanel panel_coursePage_student = new JPanel();
        panel_container_student.add(panel_coursePage_student, "自主选课");
        panel_coursePage_student.setLayout(null);

        JLabel lbl_avaiblecourse = new JLabel("可选课程:");
        lbl_avaiblecourse.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        lbl_avaiblecourse.setBounds(27, 6, 102, 34);
        panel_coursePage_student.add(lbl_avaiblecourse);

        JScrollPane scrollPane_avaiblecourse = new JScrollPane();
        scrollPane_avaiblecourse.setBounds(27, 40, 499, 156);
        panel_coursePage_student.add(scrollPane_avaiblecourse);


        Vector<String> title_avaiblecourse = new Vector<String>();
        title_avaiblecourse.add("课程名称");
        title_avaiblecourse.add("课程编号");
        title_avaiblecourse.add("开课时间");
        title_avaiblecourse.add("开课地点");
        title_avaiblecourse.add("课程学分");
        title_avaiblecourse.add("课程类别");
        title_avaiblecourse.add("任课教师");

        Vector<Vector<Object>> data_avaiblecourse = new Vector<Vector<Object>>();

        CourseService courseService = new CourseService();
        Db db = new Db();
        Connection connection = db.getConnection();
        ArrayList<Course> courseArrayList = courseService.ShowCourse(connection);
        for (Course course : courseArrayList) {
            CourseTable ctava = new CourseTable(course.getCname(), course.getCid(), course.getCtime(),
                    course.getCroom(), course.getCcredit(), course.getCkclb(), course.getCteacherid());
            Vector<Object> obj = new Vector<>();
            obj.add(ctava.getCname());
            obj.add(ctava.getCid());
            obj.add(ctava.getCtime());
            obj.add(ctava.getCplace());
            obj.add(ctava.getCgrade());
            obj.add(ctava.getCtype());
            obj.add(ctava.getCteacher());
            data_avaiblecourse.add(obj);
        }

        DefaultTableModel model_availecourse = new DefaultTableModel(data_avaiblecourse, title_avaiblecourse) {
            //设置table内容不能改，但能被选中行
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable table_avaiblecourse = new JTable(model_availecourse);
        scrollPane_avaiblecourse.setViewportView(table_avaiblecourse);

        JButton btnchoose_course = new JButton("选课");
        btnchoose_course.setBounds(409, 206, 117, 29);
        panel_coursePage_student.add(btnchoose_course);

        JScrollPane scrollPane_nominatedCourse = new JScrollPane();
        scrollPane_nominatedCourse.setBounds(27, 272, 499, 137);
        panel_coursePage_student.add(scrollPane_nominatedCourse);

        JLabel lbl_ccsSuccess = new JLabel("选课成功！");
        lbl_ccsSuccess.setFont(new Font("Lucida Grande", Font.BOLD, 16));
        lbl_ccsSuccess.setBounds(238, 208, 82, 27);
        panel_coursePage_student.add(lbl_ccsSuccess);
        lbl_ccsSuccess.setForeground(Color.green);
        lbl_ccsSuccess.setVisible(false);

        JLabel lbl_ccsFalse = new JLabel("选课失败！");
        lbl_ccsFalse.setFont(new Font("Lucida Grande", Font.BOLD, 16));
        lbl_ccsFalse.setBounds(238, 208, 82, 27);
        panel_coursePage_student.add(lbl_ccsFalse);
        lbl_ccsFalse.setForeground(Color.red);
        lbl_ccsFalse.setVisible(false);

        JLabel lbl_ccsFalse_1 = new JLabel("选课失败,所选课程已被选！");
        lbl_ccsFalse_1.setFont(new Font("Lucida Grande", Font.BOLD, 16));
        lbl_ccsFalse_1.setBounds(238, 208, 82, 27);
        panel_coursePage_student.add(lbl_ccsFalse_1);
        lbl_ccsFalse_1.setForeground(Color.red);
        lbl_ccsFalse_1.setVisible(false);


        Vector<String> title_nominatedCourse = new Vector<String>();
        title_nominatedCourse.add("课程名称");
        title_nominatedCourse.add("课程编号");
        title_nominatedCourse.add("开课时间");
        title_nominatedCourse.add("开课地点");
        title_nominatedCourse.add("课程学分");
        title_nominatedCourse.add("课程类别");
        title_nominatedCourse.add("任课教师");

        Vector<Vector<Object>> data_nominatedCourse = new Vector<Vector<Object>>();

        JTable table_nominatedCourse = new JTable();
        DefaultTableModel model_nominatedCourse = new DefaultTableModel(data_nominatedCourse, title_nominatedCourse) {
            //设置table内容不能改，但能被选中行
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table_nominatedCourse.setModel(model_nominatedCourse);
        scrollPane_nominatedCourse.setViewportView(table_nominatedCourse);

        MouseListener mouseListener_choosecourse = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int flag = table_avaiblecourse.getSelectedRow();
                int sum = table_avaiblecourse.getColumnCount();
                System.out.println("第" + flag + "行");
                //object用来放选中课的信息

//                ChooseCourseService ccs = new ChooseCourseService();
//                ArrayList<ChooseCourse> chooseCourses

                //TODO:选多次其他的重复的课
                //TODO:向choosecourse表中增添数据
                //TODO:检测是否有时间、地点冲突
                Vector<Object> object = new Vector<>();

                for (int i = 0; i < table_nominatedCourse.getRowCount(); i++) {
//                    System.out.println(1);
                    if (table_nominatedCourse.getValueAt(i, 1) == table_avaiblecourse.getValueAt(flag, 1)) {
                        System.out.println("选课失败，所选课程已被选");
                        lbl_ccsSuccess.setVisible(true);
                        lbl_ccsFalse_1.setVisible(false);
                        lbl_ccsFalse.setVisible(false);

                    } else if (table_nominatedCourse.getValueAt(i, 2) == table_avaiblecourse.getValueAt(flag, 2)) {
                        System.out.println("选课失败，所选课程时间段已有其他课程");
                        lbl_ccsSuccess.setVisible(true);
                        lbl_ccsFalse_1.setVisible(false);
                        lbl_ccsFalse.setVisible(false);

                    } else {
                        for (int j = 0; j < sum; j++) {
                            object.add(table_avaiblecourse.getValueAt(flag, j));
//                        ccs.Add(connection, );
                        }
                    }

                    data_nominatedCourse.add(object);
                    lbl_ccsSuccess.setVisible(true);
                    lbl_ccsFalse_1.setVisible(false);
                    lbl_ccsFalse.setVisible(false);

                }

                System.out.println(object);
                System.out.println(data_nominatedCourse);
                DefaultTableModel modeltst = new DefaultTableModel(data_nominatedCourse, title_nominatedCourse);
                table_nominatedCourse.setModel(modeltst);

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
        };
        btnchoose_course.addMouseListener(mouseListener_choosecourse);

        JLabel lbl_nominatedCourse = new JLabel("已选课程:");
        lbl_nominatedCourse.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        lbl_nominatedCourse.setBounds(27, 235, 102, 34);
        panel_coursePage_student.add(lbl_nominatedCourse);

        JButton btn_dropcourse = new JButton("退选");
        btn_dropcourse.setBounds(409, 416, 117, 29);
        panel_coursePage_student.add(btn_dropcourse);

        JLabel lbl_dcsSuccess = new JLabel("退课成功！");
        lbl_dcsSuccess.setFont(new Font("Lucida Grande", Font.BOLD, 16));
        lbl_dcsSuccess.setBounds(238, 421, 82, 24);
        panel_coursePage_student.add(lbl_dcsSuccess);
        lbl_dcsSuccess.setForeground(Color.green);
        lbl_dcsSuccess.setVisible(false);

        JLabel lbl_dcsFalse = new JLabel("退课失败！");
        lbl_dcsFalse.setFont(new Font("Lucida Grande", Font.BOLD, 16));
        lbl_dcsFalse.setBounds(238, 421, 82, 24);
        panel_coursePage_student.add(lbl_dcsFalse);
        lbl_dcsFalse.setForeground(Color.red);
        lbl_dcsFalse.setVisible(false);

        MouseListener mouseListener_dropclass = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                int flag = table_nominatedCourse.getSelectedRow();
                if (flag != -1 && data_nominatedCourse.size() != 0) {
                    System.out.println("退课成功！");
                    data_nominatedCourse.remove(flag);
                    table_nominatedCourse.updateUI();
                    lbl_dcsSuccess.setVisible(true);
                    lbl_dcsFalse.setVisible(false);
                } else {
                    System.out.println("Can't drop.");
                    lbl_dcsFalse.setVisible(true);
                    lbl_dcsSuccess.setVisible(false);
                }

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
        };

        btn_dropcourse.addMouseListener(mouseListener_dropclass);

        //查看成绩
        JPanel panel_gradePage_student = new JPanel();
        panel_container_student.add(panel_gradePage_student, "name_610720492995100");
        panel_gradePage_student.setLayout(null);

        JLabel lbl_selectGrade = new JLabel("成绩查询");
        lbl_selectGrade.setFont(new

                Font("Lucida Grande", Font.BOLD, 20));
        lbl_selectGrade.setBounds(232, 28, 85, 33);
        panel_gradePage_student.add(lbl_selectGrade);

        JScrollPane scrollPane_selectGrade = new JScrollPane();
        scrollPane_selectGrade.setBounds(28, 86, 491, 260);
        panel_gradePage_student.add(scrollPane_selectGrade);

        JTable table_selectGrade = new JTable();
        scrollPane_selectGrade.setColumnHeaderView(table_selectGrade);

        Vector<Object> title_showcourse = new Vector<Object>();
        title_showcourse.add("课程编号");
        title_showcourse.add("成绩");
        title_showcourse.add("绩点");

        Vector<Vector<Object>> data_showcourse = new Vector<Vector<Object>>();

        DefaultTableModel showcourse = new DefaultTableModel(data_showcourse, title_showcourse){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table_selectGrade.setModel(showcourse);
        scrollPane_selectGrade.setViewportView(table_selectGrade);





        JPanel panel_coursetablePage_student = new JPanel();
        panel_container_student.add(panel_coursetablePage_student, "name_610722426758000");

        JPanel panel_changeinfoPage_student = new JPanel();
        panel_container_student.add(panel_changeinfoPage_student, "name_610724537767700");

        JPanel panel_about_student = new JPanel();
        panel_container_student.add(panel_about_student, "about");
        panel_about_student.setLayout(null);

        JLabel lbl_spa = new JLabel("曹尼玛");
        lbl_spa.setBounds(110, 85, 61, 16);
        panel_about_student.add(lbl_spa);

        ActionListener actionlistenerStudent = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(btnHomePage_student)) {
                    panel_container_student.removeAll();
                    panel_container_student.add(panel_homePage_student);
                    panel_container_student.validate();
                    panel_container_student.repaint();
                    System.out.println("1");
                    panel_homePage_student.setVisible(true);

                } else if (e.getSource().equals(btnMyCourse_student)) {
                    panel_container_student.removeAll();
                    panel_container_student.add(panel_coursePage_student);
                    panel_container_student.validate();
                    panel_container_student.repaint();
                    System.out.println("2");
                    panel_coursePage_student.setVisible(true);

                } else if (e.getSource().equals(btnGrade_student)) {
                    panel_container_student.removeAll();
                    panel_container_student.add(panel_gradePage_student);
                    panel_container_student.validate();
                    panel_container_student.repaint();
                    System.out.println("3");
                    panel_gradePage_student.setVisible(true);

                } else if (e.getSource().equals(btnShowtable_student)) {
                    panel_container_student.removeAll();
                    panel_container_student.add(panel_coursetablePage_student);
                    panel_container_student.validate();
                    panel_container_student.repaint();
                    System.out.println("4");
                    panel_coursetablePage_student.setVisible(true);

                } else if (e.getSource().equals(btnChangeInfo_student)) {
                    panel_container_student.removeAll();
                    panel_container_student.add(panel_changeinfoPage_student);
                    panel_container_student.validate();
                    panel_container_student.repaint();
                    System.out.println("5");
                    panel_changeinfoPage_student.setVisible(true);

                } else if (e.getSource().equals(btnAbout_student)) {
                    panel_container_student.removeAll();
                    panel_container_student.add(panel_about_student);
                    panel_container_student.validate();
                    panel_container_student.repaint();
                    System.out.println("6");
                    panel_about_student.setVisible(true);

                }
            }
        };

        btnHomePage_student.addActionListener(actionlistenerStudent);
        btnMyCourse_student.addActionListener(actionlistenerStudent);
        btnGrade_student.addActionListener(actionlistenerStudent);
        btnShowtable_student.addActionListener(actionlistenerStudent);
        btnChangeInfo_student.addActionListener(actionlistenerStudent);
        btnAbout_student.addActionListener(actionlistenerStudent);
    }

}
