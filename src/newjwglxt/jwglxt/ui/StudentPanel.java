package newjwglxt.jwglxt.ui;

import newjwglxt.jwglxt.entity.ChooseCourse;
import newjwglxt.jwglxt.entity.Student;
import newjwglxt.jwglxt.service.idx1.CourseService;
import newjwglxt.jwglxt.service.idx2.ChooseCourseService;
import newjwglxt.jwglxt.util.DbConnector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

public class StudentPanel {
    protected JPanel student;

    public JPanel getPanel() {
        return student;
    }

    public StudentPanel(DbConnector dbConnector, Student student_login) {
        student = new JPanel();
        student.setOpaque(false);
        MainWindow.contentPane.add(student, "name_601806090402700");
        student.setLayout(null);

        // student左侧边栏
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

        // student右侧内容区
        JPanel panel_container_student = new JPanel();
        panel_container_student.setBounds(170, 10, 549, 451);
        student.add(panel_container_student);
        CardLayout cl_panel_container_student = new CardLayout();
        panel_container_student.setLayout(cl_panel_container_student);

        // student右侧内容区 -> 主页
        JPanel panel_homePage_student = new JPanel();
        panel_container_student.add(panel_homePage_student, "主页");
        panel_homePage_student.setLayout(null);

        JLabel lblImg_student = new JLabel("头像");
        lblImg_student.setHorizontalAlignment(SwingConstants.CENTER);
        lblImg_student.setOpaque(true);
        lblImg_student.setBackground(Color.WHITE);
        lblImg_student.setBounds(10, 10, 110, 150);
        panel_homePage_student.add(lblImg_student);

        JLabel lblHello_student = new JLabel("XXX，你好！");
        lblHello_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblHello_student.setBounds(149, 56, 365, 35);
        panel_homePage_student.add(lblHello_student);

        JLabel lblSid_student = new JLabel("学号：");
        lblSid_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblSid_student.setBounds(149, 101, 69, 24);
        panel_homePage_student.add(lblSid_student);

        JLabel lblSid_present_student = new JLabel(Integer.toString(student_login.getId()));
        lblSid_present_student.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblSid_present_student.setBounds(219, 101, 88, 24);
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

        // student右侧内容区 -> 主页 -> 标题区
        JPanel panel_5_4 = new JPanel();
        panel_5_4.setLayout(null);
        panel_5_4.setForeground(SystemColor.activeCaption);
        panel_5_4.setBackground(SystemColor.scrollbar);
        panel_5_4.setBounds(0, 0, 553, 46);
        panel_homePage_student.add(panel_5_4);

        JLabel lblNewLabel_8_4 = new JLabel("主页");
        lblNewLabel_8_4.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lblNewLabel_8_4.setBounds(10, 10, 64, 22);
        panel_5_4.add(lblNewLabel_8_4);


        //查看成绩
        JPanel panel_gradePage_student = new JPanel();
        panel_container_student.add(panel_gradePage_student, "name_610720492995100");
        panel_gradePage_student.setLayout(null);

        JLabel lbl_selectGrade = new JLabel("成绩查询");
        lbl_selectGrade.setFont(new Font("Lucida Grande", Font.BOLD, 20));
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

        DefaultTableModel showcourse = new DefaultTableModel(data_showcourse, title_showcourse) {
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
                    // student右侧内容区 -> 我的课程
                    JPanel panel_coursePage_student = new JPanel();
                    panel_container_student.add(panel_coursePage_student, "自主选课");
                    panel_coursePage_student.setLayout(null);

                    // student右侧内容区 -> 我的课程 -> 标题区
                    JPanel panel_title_wodekecheng_student = new JPanel();
                    panel_title_wodekecheng_student.setLayout(null);
                    panel_title_wodekecheng_student.setForeground(SystemColor.activeCaption);
                    panel_title_wodekecheng_student.setBackground(SystemColor.scrollbar);
                    panel_title_wodekecheng_student.setBounds(0, 0, 553, 46);
                    panel_coursePage_student.add(panel_title_wodekecheng_student);

                    JLabel lbltitle_wodekecheng_teacher = new JLabel("我的课程");
                    lbltitle_wodekecheng_teacher.setFont(new Font("微软雅黑", Font.BOLD, 16));
                    lbltitle_wodekecheng_teacher.setBounds(10, 10, 64, 22);
                    panel_title_wodekecheng_student.add(lbltitle_wodekecheng_teacher);

                    // student右侧内容区 -> 我的课程 -> 可选课程
                    JLabel lbl_avaiblecourse = new JLabel("可选课程:");
                    lbl_avaiblecourse.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
                    lbl_avaiblecourse.setBounds(10, 46, 77, 34);
                    panel_coursePage_student.add(lbl_avaiblecourse);

                    JScrollPane scrollPane_avaiblecourse = new JScrollPane();
                    scrollPane_avaiblecourse.setBounds(10, 80, 529, 141);
                    panel_coursePage_student.add(scrollPane_avaiblecourse);

                    Vector<String> title_avaiblecourse = new Vector<>();
                    title_avaiblecourse.add("课程名称");
                    title_avaiblecourse.add("课程编号");
                    title_avaiblecourse.add("开课时间");
                    title_avaiblecourse.add("开课地点");
                    title_avaiblecourse.add("课程学分");
                    title_avaiblecourse.add("课程类别");
                    title_avaiblecourse.add("任课教师");

                    CourseService courseService = new CourseService();

                    DefaultTableModel model_availecourse = new DefaultTableModel(courseService.getCourseVector_exceptSelectedCourses(dbConnector, student_login), title_avaiblecourse) {
                        //设置table内容不能改，但能被选中行
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    };

                    JTable table_avaiblecourse = new JTable(model_availecourse);
                    scrollPane_avaiblecourse.setViewportView(table_avaiblecourse);

                    JButton btnchoose_course = new JButton("选课");
                    btnchoose_course.setBounds(439, 231, 100, 29);
                    panel_coursePage_student.add(btnchoose_course);

                    JScrollPane scrollPane_nominatedCourse = new JScrollPane();
                    scrollPane_nominatedCourse.setBounds(10, 259, 529, 141);
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

                    // student右侧内容区 -> 我的课程 -> 已选课程
                    Vector<String> title_nominatedCourse = new Vector<>();
                    title_nominatedCourse.add("课程名称");
                    title_nominatedCourse.add("课程编号");
                    title_nominatedCourse.add("开课时间");
                    title_nominatedCourse.add("开课地点");
                    title_nominatedCourse.add("课程学分");
                    title_nominatedCourse.add("课程类别");
                    title_nominatedCourse.add("任课教师");

                    ChooseCourseService chooseCourseService = new ChooseCourseService();
                    Vector<Vector<Object>> data_nominatedCourse = chooseCourseService.getCourseVector(dbConnector, student_login);

                    JTable table_nominatedCourse = new JTable();
                    DefaultTableModel model_nominatedCourse = new DefaultTableModel(data_nominatedCourse, title_nominatedCourse) {
                        //设置table内容不能改，但能被选中行
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    };

                    table_nominatedCourse.setModel(model_nominatedCourse);
                    scrollPane_nominatedCourse.setViewportView(table_nominatedCourse);

                    // 选课按钮
                    MouseListener mouseListener_choosecourse = new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            int flag = table_avaiblecourse.getSelectedRow();
                            System.out.println("第" + flag + "行");
                            //object用来放选中课的信息

                            int seleted_cid = (Integer) table_avaiblecourse.getValueAt(flag, 1);
                            chooseCourseService.Add(dbConnector, new ChooseCourse(0, student_login.getId(), seleted_cid, 0, 0));

                            Vector<Vector<Object>> new_data_availableCourse = courseService.getCourseVector_exceptSelectedCourses(dbConnector, student_login);
                            Vector<Vector<Object>> new_data_nominatedCourse = chooseCourseService.getCourseVector(dbConnector, student_login);

                            DefaultTableModel new_model_availableCourse = new DefaultTableModel(new_data_availableCourse, title_nominatedCourse) {
                                //设置table内容不能改，但能被选中行
                                public boolean isCellEditable(int row, int column) {
                                    return false;
                                }
                            };
                            table_avaiblecourse.setModel(new_model_availableCourse);
                            table_avaiblecourse.updateUI();

                            DefaultTableModel new_model_nominatedCourse = new DefaultTableModel(new_data_nominatedCourse, title_nominatedCourse) {
                                //设置table内容不能改，但能被选中行
                                public boolean isCellEditable(int row, int column) {
                                    return false;
                                }
                            };
                            table_nominatedCourse.setModel(new_model_nominatedCourse);
                            table_nominatedCourse.updateUI();

//                ChooseCourseService ccs = new ChooseCourseService();
//                ArrayList<ChooseCourse> chooseCourses

                            //TODO:选多次其他的重复的课
                            //TODO:向choosecourse表中增添数据
                            //TODO:检测是否有时间、地点冲突
//                Vector<Object> object = new Vector<>();

//                for (int i = 0; i < table_nominatedCourse.getRowCount(); i++) {
////                    System.out.println(1);
//                    if (table_nominatedCourse.getValueAt(i, 1) == table_avaiblecourse.getValueAt(flag, 1)) {
//                        System.out.println("选课失败，所选课程已被选");
//                        lbl_ccsSuccess.setVisible(true);
//                        lbl_ccsFalse_1.setVisible(false);
//                        lbl_ccsFalse.setVisible(false);
//
//                    } else if (table_nominatedCourse.getValueAt(i, 2) == table_avaiblecourse.getValueAt(flag, 2)) {
//                        System.out.println("选课失败，所选课程时间段已有其他课程");
//                        lbl_ccsSuccess.setVisible(true);
//                        lbl_ccsFalse_1.setVisible(false);
//                        lbl_ccsFalse.setVisible(false);
//
//                    } else {
//                        for (int j = 0; j < sum; j++) {
//                            object.add(table_avaiblecourse.getValueAt(flag, j));
////                        ccs.Add(connection, );
//                        }
//                    }
//
//                    data_nominatedCourse.add(object);
//                    lbl_ccsSuccess.setVisible(true);
//                    lbl_ccsFalse_1.setVisible(false);
//                    lbl_ccsFalse.setVisible(false);
//
//                }


//                System.out.println(object);
//                System.out.println(data_nominatedCourse);

//                DefaultTableModel modeltst = new DefaultTableModel(data_nominatedCourse, title_nominatedCourse);
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
                    lbl_nominatedCourse.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
                    lbl_nominatedCourse.setBounds(10, 225, 77, 34);
                    panel_coursePage_student.add(lbl_nominatedCourse);

                    JButton btn_dropcourse = new JButton("退选");
                    btn_dropcourse.setBounds(439, 412, 100, 29);
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
