package newjwglxt.jwglxt.ui;

import newjwglxt.jwglxt.entity.ChooseCourse;
import newjwglxt.jwglxt.entity.DropCourse;
import newjwglxt.jwglxt.entity.Student;
import newjwglxt.jwglxt.service.idx1.CourseService;
import newjwglxt.jwglxt.service.idx1.StudentService;
import newjwglxt.jwglxt.service.idx1.TeacherService;
import newjwglxt.jwglxt.service.idx2.ChooseCourseService;
import newjwglxt.jwglxt.service.idx2.DropCourseService;
import newjwglxt.jwglxt.util.DbConnector;
import newjwglxt.jwglxt.util.QuickButton;
import newjwglxt.jwglxt.util.SHA256;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Objects;
import java.util.Vector;

import static newjwglxt.jwglxt.ui.MainWindow.contentPane;
import static newjwglxt.jwglxt.util.ComboboxStyle.setComboboxStyle;
import static newjwglxt.jwglxt.util.Judge.isName;
import static newjwglxt.jwglxt.util.Judge.isPhoneNum;
import static newjwglxt.jwglxt.util.QuickButton.primaryBorderButton;

public class StudentPanel {
    protected JPanel student;

    public JPanel getPanel() {
        return student;
    }

    public void FitTableColumns(JTable myTable) {
        JTableHeader header = myTable.getTableHeader();
        int rowCount = myTable.getRowCount();
        Enumeration<TableColumn> columns = myTable.getColumnModel().getColumns();
        while (columns.hasMoreElements()) {
            TableColumn column = (TableColumn) columns.nextElement();
            int col = header.getColumnModel().getColumnIndex(column.getIdentifier());
            int width = (int) myTable.getTableHeader().getDefaultRenderer()
                    .getTableCellRendererComponent(myTable, column.getIdentifier()
                            , false, false, -1, col).getPreferredSize().getWidth();
            for (int row = 0; row < rowCount; row++) {
                int preferedWidth = (int) myTable.getCellRenderer(row, col).getTableCellRendererComponent(myTable,
                        myTable.getValueAt(row, col), false, false, row, col).getPreferredSize().getWidth();
                width = Math.max(width, preferedWidth);
            }
            header.setResizingColumn(column); // ???????????????
            column.setWidth(width + myTable.getIntercellSpacing().width);
        }
    }

    public StudentPanel(DbConnector dbConnector, Student student_login) {
        student = new JPanel();
        student.setOpaque(false);
        MainWindow.contentPane.add(student, "name_601806090402700");
        student.setLayout(null);

        // student????????????
        JPanel panel_category_student = new JPanel();
        panel_category_student.setBounds(10, 10, 150, 451);
        student.add(panel_category_student);
        panel_category_student.setLayout(null);

        JButton btnHomePage_student = primaryBorderButton("??????");
        btnHomePage_student.setFont(new Font("????????????", Font.PLAIN, 13));
        btnHomePage_student.setBounds(10, 10, 130, 35);
        panel_category_student.add(btnHomePage_student);

        JButton btnMyCourse_student = primaryBorderButton("????????????");
        btnMyCourse_student.setFont(new Font("????????????", Font.PLAIN, 13));
        btnMyCourse_student.setBounds(10, 55, 130, 35);
        panel_category_student.add(btnMyCourse_student);

        JButton btn_dropcoursepresent = primaryBorderButton("??????????????????");
        btn_dropcoursepresent.setFont(new Font("????????????", Font.PLAIN, 13));
        btn_dropcoursepresent.setBounds(10, 100, 130, 35);
        panel_category_student.add(btn_dropcoursepresent);

        JButton btnGrade_student = primaryBorderButton("????????????");
        btnGrade_student.setFont(new Font("????????????", Font.PLAIN, 13));
        btnGrade_student.setBounds(10, 145, 130, 35);
        panel_category_student.add(btnGrade_student);

        JButton btnShowtable_student = primaryBorderButton("????????????");
        btnShowtable_student.setFont(new Font("????????????", Font.PLAIN, 13));
        btnShowtable_student.setBounds(10, 190, 130, 35);
        panel_category_student.add(btnShowtable_student);

        JButton btnChangeInfo_student = primaryBorderButton("??????????????????");
        btnChangeInfo_student.setFont(new Font("????????????", Font.PLAIN, 13));
        btnChangeInfo_student.setBounds(10, 235, 130, 35);
        panel_category_student.add(btnChangeInfo_student);

        JButton btnAbout_student = primaryBorderButton("??????");
        btnAbout_student.setFont(new Font("????????????", Font.PLAIN, 13));
        btnAbout_student.setBounds(10, 406, 130, 35);
        panel_category_student.add(btnAbout_student);

        // student???????????????
        JPanel panel_container_student = new JPanel();
        panel_container_student.setBounds(170, 10, 549, 451);
        student.add(panel_container_student);
        CardLayout cl_panel_container_student = new CardLayout();
        panel_container_student.setLayout(cl_panel_container_student);

        // student??????????????? -> ??????
        JPanel panel_homePage_student = new JPanel();
        panel_container_student.add(panel_homePage_student, "??????");
        panel_homePage_student.setLayout(null);

        JButton btnExit_student = primaryBorderButton("????????????");
        btnExit_student.setFont(new Font("????????????", Font.PLAIN, 13));
        btnExit_student.setBounds(443, 56, 100, 33);
        panel_homePage_student.add(btnExit_student);

        JLabel lblImg_student = new JLabel("??????");
        lblImg_student.setHorizontalAlignment(SwingConstants.CENTER);
        lblImg_student.setOpaque(true);
        lblImg_student.setBackground(Color.WHITE);
        lblImg_student.setBounds(10, 56, 110, 150);
        panel_homePage_student.add(lblImg_student);

        JLabel lblHello_student_present = new JLabel(String.format("%s,?????????", student_login.getName()));
        lblHello_student_present.setFont(new Font("????????????", Font.PLAIN, 13));
        lblHello_student_present.setBounds(149, 56, 365, 35);
        panel_homePage_student.add(lblHello_student_present);

        JLabel lblSid_student = new JLabel("?????????");
        lblSid_student.setFont(new Font("????????????", Font.PLAIN, 13));
        lblSid_student.setBounds(149, 101, 69, 24);
        panel_homePage_student.add(lblSid_student);

        JLabel lblSid_present_student = new JLabel(Integer.toString(student_login.getId()));
        lblSid_present_student.setFont(new Font("????????????", Font.PLAIN, 13));
        lblSid_present_student.setBounds(219, 101, 88, 24);
        panel_homePage_student.add(lblSid_present_student);

        JLabel lblCollege_student = new JLabel("??????????????????");
        lblCollege_student.setFont(new Font("????????????", Font.PLAIN, 13));
        lblCollege_student.setBounds(317, 101, 78, 24);
        panel_homePage_student.add(lblCollege_student);

        JLabel lblCollege_present_student = new JLabel(student_login.getScollege());
        lblCollege_present_student.setFont(new Font("????????????", Font.PLAIN, 13));
        lblCollege_present_student.setBounds(400, 101, 134, 24);
        panel_homePage_student.add(lblCollege_present_student);

        JLabel lblGender_student = new JLabel("?????????");
        lblGender_student.setFont(new Font("????????????", Font.PLAIN, 13));
        lblGender_student.setBounds(149, 135, 69, 24);
        panel_homePage_student.add(lblGender_student);

        JLabel lblGender_present_student = new JLabel(student_login.getGender());
        lblGender_present_student.setFont(new Font("????????????", Font.PLAIN, 13));
        lblGender_present_student.setBounds(219, 135, 88, 24);
        panel_homePage_student.add(lblGender_present_student);

        //todo calculate
        JLabel lblMajor_student = new JLabel("?????????");
        lblMajor_student.setFont(new Font("????????????", Font.PLAIN, 13));
        lblMajor_student.setBounds(317, 135, 78, 24);
        panel_homePage_student.add(lblMajor_student);

        JLabel lblMajor_present_student = new JLabel(student_login.getSmajor());
        lblMajor_present_student.setFont(new Font("????????????", Font.PLAIN, 13));
        lblMajor_present_student.setBounds(400, 135, 134, 24);
        panel_homePage_student.add(lblMajor_present_student);

        JLabel lblFirstYear_student = new JLabel("???????????????");
        lblFirstYear_student.setFont(new Font("????????????", Font.PLAIN, 13));
        lblFirstYear_student.setBounds(149, 169, 69, 24);
        panel_homePage_student.add(lblFirstYear_student);

        JLabel lblFirstYear_present_student = new JLabel(Integer.toString(student_login.getSfirstyear()));
        lblFirstYear_present_student.setFont(new Font("????????????", Font.PLAIN, 13));
        lblFirstYear_present_student.setBounds(219, 169, 88, 24);
        panel_homePage_student.add(lblFirstYear_present_student);

        JLabel lblContact_student = new JLabel("???????????????");
        lblContact_student.setFont(new Font("????????????", Font.PLAIN, 13));
        lblContact_student.setBounds(149, 203, 69, 24);
        panel_homePage_student.add(lblContact_student);

        JLabel lblContact_present_student = new JLabel(student_login.getContact());
        lblContact_present_student.setFont(new Font("????????????", Font.PLAIN, 13));
        lblContact_present_student.setBounds(219, 203, 88, 24);
        panel_homePage_student.add(lblContact_present_student);

        JLabel lblClasses_student = new JLabel("????????????");
        lblClasses_student.setFont(new Font("????????????", Font.PLAIN, 13));
        lblClasses_student.setBounds(317, 169, 78, 24);
        panel_homePage_student.add(lblClasses_student);

        JLabel lblClasses_present_student = new JLabel(Integer.toString(student_login.getSclass()));
        lblClasses_present_student.setFont(new Font("????????????", Font.PLAIN, 13));
        lblClasses_present_student.setBounds(400, 169, 134, 24);
        panel_homePage_student.add(lblClasses_present_student);

        // student??????????????? -> ?????? -> ?????????
        JPanel panel_5_4 = new JPanel();
        panel_5_4.setLayout(null);
        panel_5_4.setForeground(SystemColor.activeCaption);
        panel_5_4.setBackground(SystemColor.scrollbar);
        panel_5_4.setBounds(0, 0, 553, 46);
        panel_homePage_student.add(panel_5_4);

        JLabel lblNewLabel_8_4 = new JLabel("??????");
        lblNewLabel_8_4.setFont(new Font("????????????", Font.BOLD, 16));
        lblNewLabel_8_4.setBounds(10, 10, 64, 22);
        panel_5_4.add(lblNewLabel_8_4);


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

                    //??????????????????
                } else if (e.getSource().equals(btnMyCourse_student)) {
                    // student??????????????? -> ????????????
                    JPanel panel_coursePage_student = new JPanel();
                    panel_container_student.add(panel_coursePage_student, "????????????");
                    panel_coursePage_student.setLayout(null);

                    // student??????????????? -> ???????????? -> ?????????
                    JPanel panel_title_wodekecheng_student = new JPanel();
                    panel_title_wodekecheng_student.setLayout(null);
                    panel_title_wodekecheng_student.setForeground(SystemColor.activeCaption);
                    panel_title_wodekecheng_student.setBackground(SystemColor.scrollbar);
                    panel_title_wodekecheng_student.setBounds(0, 0, 553, 46);
                    panel_coursePage_student.add(panel_title_wodekecheng_student);

                    JLabel lbltitle_wodekecheng_teacher = new JLabel("????????????");
                    lbltitle_wodekecheng_teacher.setFont(new Font("????????????", Font.BOLD, 16));
                    lbltitle_wodekecheng_teacher.setBounds(10, 10, 64, 22);
                    panel_title_wodekecheng_student.add(lbltitle_wodekecheng_teacher);

                    // student??????????????? -> ???????????? -> ????????????
                    JLabel lbl_avaiblecourse = new JLabel("????????????:");
                    lbl_avaiblecourse.setFont(new Font("????????????", Font.PLAIN, 13));
                    lbl_avaiblecourse.setBounds(10, 46, 77, 34);
                    panel_coursePage_student.add(lbl_avaiblecourse);

                    JLabel lbl_selectcourse = new JLabel("????????????:");
                    lbl_selectcourse.setFont(new Font("????????????", Font.PLAIN, 13));
                    lbl_selectcourse.setBounds(182, 46, 77, 34);
                    panel_coursePage_student.add(lbl_selectcourse);

                    String[] selectWay = new String[]{"?????????", "????????????(???)", "????????????", "????????????", "????????????"};
                    JComboBox comboBox_selectWay = new JComboBox(selectWay);
                    setComboboxStyle(comboBox_selectWay);
                    comboBox_selectWay.setSelectedItem(student_login.getGender());
                    comboBox_selectWay.setFont(new Font("????????????", Font.PLAIN, 13));
                    comboBox_selectWay.setBounds(247, 48, 115, 30);
                    panel_coursePage_student.add(comboBox_selectWay);

                    JTextField textField_Select = new JTextField();
                    textField_Select.setFont(new Font("????????????", Font.PLAIN, 13));
                    textField_Select.setBounds(372, 48, 80, 30);
                    panel_coursePage_student.add(textField_Select);
                    textField_Select.setColumns(10);

                    JButton btnchoose_select = primaryBorderButton("??????");
                    btnchoose_select.setBounds(459, 48, 80, 30);
                    panel_coursePage_student.add(btnchoose_select);

                    JScrollPane scrollPane_avaiblecourse = new JScrollPane();
                    scrollPane_avaiblecourse.setBounds(10, 80, 529, 141);
                    panel_coursePage_student.add(scrollPane_avaiblecourse);

                    JButton btnchoose_course = primaryBorderButton("??????");
                    btnchoose_course.setBounds(439, 231, 100, 29);
                    panel_coursePage_student.add(btnchoose_course);

                    JScrollPane scrollPane_nominatedCourse = new JScrollPane();
                    scrollPane_nominatedCourse.setBounds(10, 269, 529, 141);
                    panel_coursePage_student.add(scrollPane_nominatedCourse);

                    JLabel lbl_ccsSuccess = new JLabel("???????????????");
                    lbl_ccsSuccess.setFont(new Font("????????????", Font.BOLD, 16));
                    lbl_ccsSuccess.setBounds(238, 225, 82, 27);
                    panel_coursePage_student.add(lbl_ccsSuccess);
                    lbl_ccsSuccess.setForeground(Color.green);
                    lbl_ccsSuccess.setVisible(false);

                    JLabel lbl_ccsFalse = new JLabel("???????????????");
                    lbl_ccsFalse.setFont(new Font("????????????", Font.BOLD, 16));
                    lbl_ccsFalse.setBounds(238, 225, 82, 27);
                    panel_coursePage_student.add(lbl_ccsFalse);
                    lbl_ccsFalse.setForeground(Color.red);
                    lbl_ccsFalse.setVisible(false);

                    Vector<String> title_avaiblecourse = new Vector<>();
                    title_avaiblecourse.add("????????????");
                    title_avaiblecourse.add("????????????");
                    title_avaiblecourse.add("????????????");
                    title_avaiblecourse.add("????????????");
                    title_avaiblecourse.add("????????????");
                    title_avaiblecourse.add("????????????");
                    title_avaiblecourse.add("????????????");

                    CourseService courseService = new CourseService();

                    //???????????????model
                    DefaultTableModel model_availecourse = new DefaultTableModel(courseService.getCourseVector_exceptSelectedCourses(dbConnector, student_login), title_avaiblecourse) {
                        //??????table????????????????????????????????????
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    };

                    //todo ?????????????????????????????????????????????????????????model

                    //???????????????????????????
                    JTable table_avaiblecourse = new JTable(model_availecourse);
                    table_avaiblecourse.getTableHeader().setReorderingAllowed(false);
                    scrollPane_avaiblecourse.setViewportView(table_avaiblecourse);

                    MouseListener mouseListener_check = new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            //????????????
                            if (Objects.equals(comboBox_selectWay.getSelectedItem(), "????????????") || textField_Select.getText().length() == 0) {
                                table_avaiblecourse.setModel(model_availecourse);
                                System.out.println("????????????");
                                //todo ???model??????????????????model
                            } else if (Objects.equals(comboBox_selectWay.getSelectedItem(), "?????????")) {
                                Vector<Vector<Object>> data_selectByCname = courseService.getSelectedByCnameVectorForStudent(dbConnector, student_login, textField_Select.getText());
                                DefaultTableModel modelAvalibleCourseCheckByCname = new DefaultTableModel(data_selectByCname, title_avaiblecourse) {
                                    //??????table????????????????????????????????????
                                    public boolean isCellEditable(int row, int column) {
                                        return false;
                                    }
                                };
                                table_avaiblecourse.setModel(modelAvalibleCourseCheckByCname);
                                scrollPane_avaiblecourse.setViewportView(table_avaiblecourse);
                                table_avaiblecourse.updateUI();
                                System.out.println(textField_Select.getText());
                                System.out.println("?????????????????????");
                            } else if (Objects.equals(comboBox_selectWay.getSelectedItem(), "????????????(???)")) {
                                Vector<Vector<Object>> data_selectByDepartment = courseService.getSelectedByDepartmentVectorForStudent(dbConnector, student_login, textField_Select.getText());
                                DefaultTableModel modelAvalibleCourseCheckByDepartment = new DefaultTableModel(data_selectByDepartment, title_avaiblecourse) {
                                    //??????table????????????????????????????????????
                                    public boolean isCellEditable(int row, int column) {
                                        return false;
                                    }
                                };
                                table_avaiblecourse.setModel(modelAvalibleCourseCheckByDepartment);
                                scrollPane_avaiblecourse.setViewportView(table_avaiblecourse);
                                table_avaiblecourse.updateUI();
                                System.out.println(textField_Select.getText());
                                System.out.println("??????????????????(???)??????");
                            } else if (Objects.equals(comboBox_selectWay.getSelectedItem(), "????????????")) {
                                Vector<Vector<Object>> data_selectByKclb = courseService.getSelectedByKclbVectorForStudent(dbConnector, student_login, textField_Select.getText());
                                DefaultTableModel modelAvalibleCourseCheckByKclb = new DefaultTableModel(data_selectByKclb, title_avaiblecourse) {
                                    //??????table????????????????????????????????????
                                    public boolean isCellEditable(int row, int column) {
                                        return false;
                                    }
                                };
                                table_avaiblecourse.setModel(modelAvalibleCourseCheckByKclb);
                                scrollPane_avaiblecourse.setViewportView(table_avaiblecourse);
                                table_avaiblecourse.updateUI();
                                System.out.println(textField_Select.getText());
                                System.out.println("????????????????????????");
                            } else if (Objects.equals(comboBox_selectWay.getSelectedItem(), "????????????")) {
                                Vector<Vector<Object>> data_selectByTeacherName = courseService.getSelectedByTeacherVectorForStudent(dbConnector, student_login, textField_Select.getText());
                                DefaultTableModel modelAvalibleCourseCheckByTeacher = new DefaultTableModel(data_selectByTeacherName, title_avaiblecourse) {
                                    //??????table????????????????????????????????????
                                    public boolean isCellEditable(int row, int column) {
                                        return false;
                                    }
                                };
                                table_avaiblecourse.setModel(modelAvalibleCourseCheckByTeacher);
                                scrollPane_avaiblecourse.setViewportView(table_avaiblecourse);
                                table_avaiblecourse.updateUI();
                                System.out.println(textField_Select.getText());
                                System.out.println("????????????????????????");
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
                    btnchoose_select.addMouseListener(mouseListener_check);



                    // student??????????????? -> ???????????? -> ????????????
                    //todo ???????????????????????????select
                    Vector<String> title_nominatedCourse = new Vector<>();
                    title_nominatedCourse.add("????????????");
                    title_nominatedCourse.add("????????????");
                    title_nominatedCourse.add("????????????");
                    title_nominatedCourse.add("????????????");
                    title_nominatedCourse.add("????????????");
                    title_nominatedCourse.add("????????????");
                    title_nominatedCourse.add("????????????");

                    ChooseCourseService chooseCourseService = new ChooseCourseService();
                    Vector<Vector<Object>> data_nominatedCourse = chooseCourseService.getCourseVector(dbConnector, student_login);

                    JTable table_nominatedCourse = new JTable();

                    DefaultTableModel model_nominatedCourse = new DefaultTableModel(data_nominatedCourse, title_nominatedCourse) {
                        //??????table????????????????????????????????????
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    };

                    table_nominatedCourse.setModel(model_nominatedCourse);
                    table_nominatedCourse.getTableHeader().setReorderingAllowed(false);
                    scrollPane_nominatedCourse.setViewportView(table_nominatedCourse);

                    // ????????????
                    MouseListener mouseListener_choosecourse = new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            int flag = table_avaiblecourse.getSelectedRow();
                            System.out.println("???" + flag + "???");
                            //object???????????????????????????

                            int selected_cid = (Integer) table_avaiblecourse.getValueAt(flag, 1);

                            //todo ??????????????????????????????????????????????????????????????????
                            System.out.println(chooseCourseService.judgeCourse(dbConnector, student_login.getId(), selected_cid));
                            if (chooseCourseService.judgeCourse(dbConnector, student_login.getId(), selected_cid)) {
                                chooseCourseService.Add(dbConnector, new ChooseCourse(0, student_login.getId(), selected_cid, 0, 0));

                                Vector<Vector<Object>> new_data_availableCourse = courseService.getCourseVector_exceptSelectedCourses(dbConnector, student_login);
                                Vector<Vector<Object>> new_data_nominatedCourse = chooseCourseService.getCourseVector(dbConnector, student_login);

                                DefaultTableModel new_model_availableCourse = new DefaultTableModel(new_data_availableCourse, title_nominatedCourse) {
                                    //??????table????????????????????????????????????
                                    public boolean isCellEditable(int row, int column) {
                                        return false;
                                    }
                                };
                                table_avaiblecourse.setModel(new_model_availableCourse);
                                table_avaiblecourse.updateUI();

                                DefaultTableModel new_model_nominatedCourse = new DefaultTableModel(new_data_nominatedCourse, title_nominatedCourse) {
                                    //??????table????????????????????????????????????
                                    public boolean isCellEditable(int row, int column) {
                                        return false;
                                    }
                                };
                                table_nominatedCourse.setModel(new_model_nominatedCourse);
                                table_nominatedCourse.updateUI();
                                lbl_ccsSuccess.setVisible(true);
                                lbl_ccsFalse.setVisible(false);
                                panel_coursePage_student.updateUI();

                            } else {
                                lbl_ccsFalse.setVisible(true);
                                lbl_ccsSuccess.setVisible(false);
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
                    btnchoose_course.addMouseListener(mouseListener_choosecourse);

                    JLabel lbl_nominatedCourse = new JLabel("????????????:");
                    lbl_nominatedCourse.setFont(new Font("????????????", Font.PLAIN, 13));
                    lbl_nominatedCourse.setBounds(10, 235, 77, 34);
                    panel_coursePage_student.add(lbl_nominatedCourse);

                    JButton btn_dropcourse = primaryBorderButton("??????");
                    btn_dropcourse.setBounds(439, 422, 100, 29);
                    panel_coursePage_student.add(btn_dropcourse);

                    JLabel lbl_dcsSuccess = new JLabel("???????????????");
                    lbl_dcsSuccess.setFont(new Font("????????????", Font.BOLD, 16));
                    lbl_dcsSuccess.setBounds(238, 421, 82, 24);
                    panel_coursePage_student.add(lbl_dcsSuccess);
                    lbl_dcsSuccess.setForeground(Color.green);
                    lbl_dcsSuccess.setVisible(false);

                    JLabel lbl_dcsFalse = new JLabel("???????????????");
                    lbl_dcsFalse.setFont(new Font("????????????", Font.BOLD, 16));
                    lbl_dcsFalse.setBounds(238, 421, 82, 24);
                    panel_coursePage_student.add(lbl_dcsFalse);
                    lbl_dcsFalse.setForeground(Color.red);
                    lbl_dcsFalse.setVisible(false);

                    MouseListener mouseListener_dropclass = new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {

                            int flag = table_nominatedCourse.getSelectedRow();
                            System.out.println(flag);
                            int stuGrade = chooseCourseService.CheckBySidAndCid(dbConnector, student_login.getId(), (Integer)table_nominatedCourse.getValueAt(flag, 1)).get(0).getCcscore();

                            if (flag != -1 && data_nominatedCourse.size() != 0 && stuGrade == 0) {
                                System.out.println("??????????????????????????????????????????");
                                lbl_dcsSuccess.setVisible(true);
                                lbl_dcsFalse.setVisible(false);

                                //todo bug ???????????????????????????????????????flag????????????????????????
                                //?????????????????????????????????
                                DropCourseService dropCourseService = new DropCourseService();
                                table_nominatedCourse.updateUI();
                                int dccid = (Integer) table_nominatedCourse.getValueAt(flag, 1);
                                System.out.println(dccid);
                                int dcsid = student_login.getId();
                                DropCourse dropCourse = new DropCourse(0, dcsid, dccid, 0);
                                System.out.println(dropCourse);
                                dropCourseService.Add(dbConnector, dropCourse);
                                System.out.println("????????????????????????");

                                //??????????????????????????????????????????
                                chooseCourseService.Delete(dbConnector, chooseCourseService.CheckByCid(dbConnector, (int) table_nominatedCourse.getValueAt(flag, 1)).get(0));
                                Vector<Vector<Object>> new_data_nominatedCourse = chooseCourseService.getCourseVector(dbConnector, student_login);
                                DefaultTableModel new_model_nominatedCourse = new DefaultTableModel(new_data_nominatedCourse, title_nominatedCourse);
                                table_nominatedCourse.setModel(new_model_nominatedCourse);
                                table_nominatedCourse.updateUI();
                                System.out.println("????????????????????????");



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

                    //??????????????????
                } else if (e.getSource().equals(btnGrade_student)) {
                    //????????????
                    // student??????????????? -> ???????????? -> ?????????
                    JPanel panel_gradePage_student = new JPanel();
                    panel_container_student.add(panel_gradePage_student, "name_610720492995100");
                    panel_gradePage_student.setLayout(null);

                    JPanel panel_title_grade_student = new JPanel();
                    panel_title_grade_student.setLayout(null);
                    panel_title_grade_student.setForeground(SystemColor.activeCaption);
                    panel_title_grade_student.setBackground(SystemColor.scrollbar);
                    panel_title_grade_student.setBounds(0, 0, 553, 46);
                    panel_gradePage_student.add(panel_title_grade_student);

                    JLabel lbltitle_mygrade = new JLabel("??????");
                    lbltitle_mygrade.setFont(new Font("????????????", Font.BOLD, 16));
                    lbltitle_mygrade.setBounds(10, 10, 64, 22);
                    panel_title_grade_student.add(lbltitle_mygrade);


                    JScrollPane scrollPane_selectGrade = new JScrollPane();
                    scrollPane_selectGrade.setBounds(28, 86, 491, 260);
                    panel_gradePage_student.add(scrollPane_selectGrade);

                    JTable table_selectGrade = new JTable();
                    scrollPane_selectGrade.setColumnHeaderView(table_selectGrade);

                    Vector<Object> title_showcourse = new Vector<Object>();
                    title_showcourse.add("????????????");
                    title_showcourse.add("????????????");
                    title_showcourse.add("????????????");
                    title_showcourse.add("??????");
                    title_showcourse.add("??????");
                    title_showcourse.add("??????");

                    ChooseCourseService chooseCourseService = new ChooseCourseService();
                    Vector<Vector<Object>> data_showcourse = chooseCourseService.getScoreVector(dbConnector, student_login);

                    DefaultTableModel showcourse = new DefaultTableModel(data_showcourse, title_showcourse) {
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    };

                    table_selectGrade.setModel(showcourse);
                    table_selectGrade.getTableHeader().setReorderingAllowed(false);
                    table_selectGrade.updateUI();
                    scrollPane_selectGrade.setViewportView(table_selectGrade);

                    panel_container_student.removeAll();
                    panel_container_student.add(panel_gradePage_student);
                    panel_container_student.validate();
                    panel_container_student.repaint();
                    System.out.println("3");
                    panel_gradePage_student.setVisible(true);

                } else if (e.getSource().equals(btn_dropcoursepresent)) {
                    JPanel panel_dropclasspresent_student = new JPanel();
                    panel_container_student.add(panel_dropclasspresent_student, "????????????");
                    panel_dropclasspresent_student.setLayout(null);

                    // student??????????????? -> ???????????? -> ?????????
                    JPanel panel_title_dropclass_student = new JPanel();
                    panel_title_dropclass_student.setLayout(null);
                    panel_title_dropclass_student.setForeground(SystemColor.activeCaption);
                    panel_title_dropclass_student.setBackground(SystemColor.scrollbar);
                    panel_title_dropclass_student.setBounds(0, 0, 553, 46);
                    panel_dropclasspresent_student.add(panel_title_dropclass_student);

                    JLabel lbltitle_dropclass = new JLabel("????????????");
                    lbltitle_dropclass.setFont(new Font("????????????", Font.BOLD, 16));
                    lbltitle_dropclass.setBounds(10, 10, 64, 22);
                    panel_title_dropclass_student.add(lbltitle_dropclass);

                    JScrollPane scrollPane_dropclass = new JScrollPane();
                    scrollPane_dropclass.setBounds(28, 86, 491, 260);
                    panel_dropclasspresent_student.add(scrollPane_dropclass);

                    JTable table_dropclass = new JTable();
                    scrollPane_dropclass.setColumnHeaderView(table_dropclass);

                    Vector<Object> dropclass_title = new Vector<>();
                    dropclass_title.add("????????????");
                    dropclass_title.add("????????????");
                    dropclass_title.add("????????????");
                    dropclass_title.add("????????????");
                    dropclass_title.add("????????????");
                    dropclass_title.add("??????");

                    DropCourseService dropCourseService = new DropCourseService();
                    Vector<Vector<Object>> dropclass_data = dropCourseService.getDropCourseVector(dbConnector, student_login);

                    DefaultTableModel dropclassTableModel = new DefaultTableModel(dropclass_data, dropclass_title) {
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    };

                    table_dropclass.setModel(dropclassTableModel);
                    table_dropclass.getTableHeader().setReorderingAllowed(false);
                    table_dropclass.updateUI();
                    scrollPane_dropclass.setViewportView(table_dropclass);

                    panel_container_student.removeAll();
                    panel_container_student.add(panel_dropclasspresent_student);
                    panel_container_student.validate();
                    panel_container_student.repaint();
                    System.out.println("4");
                    panel_dropclasspresent_student.setVisible(true);

                } else if (e.getSource().equals(btnShowtable_student)) {
                    //todo ????????????
                    JPanel panel_coursetablePage_student = new JPanel();
                    panel_coursetablePage_student.setLayout(null);
                    panel_container_student.add(panel_coursetablePage_student, "name_610722426758000");

                    // student??????????????? -> ???????????? -> ?????????
                    JPanel panel_title_coursetable_student = new JPanel();
                    panel_title_coursetable_student.setLayout(null);
                    panel_title_coursetable_student.setForeground(SystemColor.activeCaption);
                    panel_title_coursetable_student.setBackground(SystemColor.scrollbar);
                    panel_title_coursetable_student.setBounds(0, 0, 553, 46);
                    panel_coursetablePage_student.add(panel_title_coursetable_student);

                    JLabel lbltitle_coursetable = new JLabel(String.format("%s??????", student_login.getName()));
                    lbltitle_coursetable.setFont(new Font("????????????", Font.BOLD, 16));
                    lbltitle_coursetable.setBounds(10, 10, 100, 22);
                    panel_title_coursetable_student.add(lbltitle_coursetable);


                    JScrollPane scrollPane_CourseTable = new JScrollPane();
                    scrollPane_CourseTable.setBounds(28, 86, 491, 260);
                    panel_coursetablePage_student.add(scrollPane_CourseTable);

                    String[][] courseTableData = {
                            {"1", null, null, null, null, null, null, null},
                            {"2", null, null, null, null, null, null, null},
                            {"3", null, null, null, null, null, null, null},
                            {"4", null, null, null, null, null, null, null},
                            {"5", null, null, null, null, null, null, null},
                            {"6", null, null, null, null, null, null, null},
                            {"7", null, null, null, null, null, null, null},
                            {"8", null, null, null, null, null, null, null},
                            {"9", null, null, null, null, null, null, null},
                            {"10", null, null, null, null, null, null, null},
                            {"11", null, null, null, null, null, null, null},
                            {"12", null, null, null, null, null, null, null},};
                    String[] courseTableTitle = {" ", "?????????", "?????????", "?????????", "?????????", "?????????", "?????????", "?????????"};
                    JTable tableCoursePresent = new JTable(courseTableData, courseTableTitle) {
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    };

                    //??????????????????????????????
                    tableCoursePresent.getTableHeader().setReorderingAllowed(false);
                    scrollPane_CourseTable.setColumnHeaderView(tableCoursePresent);
                    tableCoursePresent.updateUI();
                    scrollPane_CourseTable.setViewportView(tableCoursePresent);

                    ChooseCourseService chooseCourseService = new ChooseCourseService();
                    CourseService courseService = new CourseService();
                    TeacherService teacherService = new TeacherService();
                    ArrayList<ChooseCourse> chooseCourses = chooseCourseService.CheckBySid(dbConnector, student_login.getId());

                    /* ???????????????? */
                    for (ChooseCourse chooseCourse : chooseCourses) {
                        String time = courseService.CheckById(dbConnector, chooseCourse.getCccid()).get(0).getCtime();

                        StringBuilder beginTime = new StringBuilder();
                        beginTime.append(time.charAt(5));
                        beginTime.append(time.charAt(6));
                        int beginTime_int = new Integer(String.valueOf(beginTime));

                        StringBuilder endTime = new StringBuilder();
                        endTime.append(time.charAt(7));
                        endTime.append(time.charAt(8));
                        int endTime_int = new Integer(String.valueOf(endTime));

                        StringBuilder beginWeek = new StringBuilder();
                        beginWeek.append(time.charAt(0));
                        beginWeek.append(time.charAt(1));
                        int beginWeek_int = new Integer(String.valueOf(beginWeek));

                        StringBuilder endWeek = new StringBuilder();
                        endWeek.append(time.charAt(2));
                        endWeek.append(time.charAt(3));
                        int endWeek_int = new Integer(String.valueOf(endWeek));

                        if (time.charAt(4) == 'A') {
                            for (int i = beginTime_int - 1; i < endTime_int; i++) {
                                courseTableData[i][1] = courseService.CheckById(dbConnector, chooseCourse.getCccid()).get(0).getCname() + "\n"
                                        + courseService.CheckById(dbConnector, chooseCourse.getCccid()).get(0).getCroom() + "\n"
                                        + "???" + beginWeek_int + "??????" + "???" + endWeek_int + "???" + "\n"
                                        + teacherService.CheckById(dbConnector, courseService.CheckById(dbConnector, chooseCourse.getCccid()).get(0).getCteacherid()).get(0).getName();
                            }
                        } else if (time.charAt(4) == 'B') {
                            for (int i = beginTime_int - 1; i < endTime_int; i++) {
                                courseTableData[i][2] = courseService.CheckById(dbConnector, chooseCourse.getCccid()).get(0).getCname() + "\n"
                                        + courseService.CheckById(dbConnector, chooseCourse.getCccid()).get(0).getCroom() + "\n"
                                        + "???" + beginWeek_int + "??????" + "???" + endWeek_int + "???" + "\n"
                                        + teacherService.CheckById(dbConnector, courseService.CheckById(dbConnector, chooseCourse.getCccid()).get(0).getCteacherid()).get(0).getName();
                            }
                        } else if (time.charAt(4) == 'C') {
                            for (int i = beginTime_int - 1; i < endTime_int; i++) {
                                courseTableData[i][3] = courseService.CheckById(dbConnector, chooseCourse.getCccid()).get(0).getCname() + "\n"
                                        + courseService.CheckById(dbConnector, chooseCourse.getCccid()).get(0).getCroom() + "\n"
                                        + "???" + beginWeek_int + "??????" + "???" + endWeek_int + "???" + "\n"
                                        + teacherService.CheckById(dbConnector, courseService.CheckById(dbConnector, chooseCourse.getCccid()).get(0).getCteacherid()).get(0).getName();
                            }
                        } else if (time.charAt(4) == 'D') {
                            for (int i = beginTime_int - 1; i < endTime_int; i++) {
                                courseTableData[i][4] = courseService.CheckById(dbConnector, chooseCourse.getCccid()).get(0).getCname() + "\n"
                                        + courseService.CheckById(dbConnector, chooseCourse.getCccid()).get(0).getCroom() + "\n"
                                        + "???" + beginWeek_int + "??????" + "???" + endWeek_int + "???" + "\n"
                                        + teacherService.CheckById(dbConnector, courseService.CheckById(dbConnector, chooseCourse.getCccid()).get(0).getCteacherid()).get(0).getName();
                            }
                        } else if (time.charAt(4) == 'E') {
                            for (int i = beginTime_int - 1; i < endTime_int; i++) {
                                courseTableData[i][5] = courseService.CheckById(dbConnector, chooseCourse.getCccid()).get(0).getCname() + "\n"
                                        + courseService.CheckById(dbConnector, chooseCourse.getCccid()).get(0).getCroom() + "\n"
                                        + "???" + beginWeek_int + "??????" + "???" + endWeek_int + "???" + "\n"
                                        + teacherService.CheckById(dbConnector, courseService.CheckById(dbConnector, chooseCourse.getCccid()).get(0).getCteacherid()).get(0).getName();
                            }
                        } else if (time.charAt(4) == 'F') {
                            for (int i = beginTime_int - 1; i < endTime_int; i++) {
                                courseTableData[i][6] = courseService.CheckById(dbConnector, chooseCourse.getCccid()).get(0).getCname() + "\n"
                                        + courseService.CheckById(dbConnector, chooseCourse.getCccid()).get(0).getCroom() + "\n"
                                        + "???" + beginWeek_int + "??????" + "???" + endWeek_int + "???" + "\n"
                                        + teacherService.CheckById(dbConnector, courseService.CheckById(dbConnector, chooseCourse.getCccid()).get(0).getCteacherid()).get(0).getName();
                            }
                        } else if (time.charAt(4) == 'G') {
                            for (int i = beginTime_int - 1; i < endTime_int; i++) {
                                courseTableData[i][7] = courseService.CheckById(dbConnector, chooseCourse.getCccid()).get(0).getCname() + "\n"
                                        + courseService.CheckById(dbConnector, chooseCourse.getCccid()).get(0).getCroom() + "\n"
                                        + "???" + beginWeek_int + "??????" + "???" + endWeek_int + "???" + "\n"
                                        + teacherService.CheckById(dbConnector, courseService.CheckById(dbConnector, chooseCourse.getCccid()).get(0).getCteacherid()).get(0).getName();
                            }
                        }
                    }

                    panel_container_student.removeAll();
                    panel_container_student.add(panel_coursetablePage_student);
                    panel_container_student.validate();
                    panel_container_student.repaint();
                    System.out.println("5");
                    panel_coursetablePage_student.setVisible(true);

                } else if (e.getSource().equals(btnChangeInfo_student)) {
                    JPanel panel_changeinfoPage_student = new JPanel();
                    panel_container_student.add(panel_changeinfoPage_student, "name_610724537767700");
                    panel_changeinfoPage_student.setLayout(null);

                    // student??????????????? -> ?????????????????? -> ?????????
                    JPanel panel_title_changeinfo_student = new JPanel();
                    panel_title_changeinfo_student.setLayout(null);
                    panel_title_changeinfo_student.setForeground(SystemColor.activeCaption);
                    panel_title_changeinfo_student.setBackground(SystemColor.scrollbar);
                    panel_title_changeinfo_student.setBounds(0, 0, 553, 46);
                    panel_changeinfoPage_student.add(panel_title_changeinfo_student);

                    JLabel lbltitle_changeinfo = new JLabel("??????????????????");
                    lbltitle_changeinfo.setFont(new Font("????????????", Font.BOLD, 16));
                    lbltitle_changeinfo.setBounds(10, 10, 100, 22);
                    panel_title_changeinfo_student.add(lbltitle_changeinfo);

                    JLabel lblChangeInfoTitle = new JLabel("??????????????????");
                    lblChangeInfoTitle.setFont(new Font("????????????", Font.BOLD, 18));
                    lblChangeInfoTitle.setBounds(224, 19, 116, 33);
                    panel_changeinfoPage_student.add(lblChangeInfoTitle);

                    JLabel lblSid = new JLabel("??????:");
                    lblSid.setFont(new Font("????????????", Font.BOLD, 13));
                    lblSid.setBounds(39, 102, 61, 16);
                    panel_changeinfoPage_student.add(lblSid);

                    JLabel lblSidPresent = new JLabel(String.valueOf(student_login.getId()));
                    lblSidPresent.setFont(new Font("????????????", Font.PLAIN, 13));
                    lblSidPresent.setBounds(128, 102, 89, 16);
                    panel_changeinfoPage_student.add(lblSidPresent);

                    JLabel lblSname = new JLabel("??????:");
                    lblSname.setFont(new Font("????????????", Font.BOLD, 13));
                    lblSname.setBounds(39, 154, 61, 16);
                    panel_changeinfoPage_student.add(lblSname);

                    JTextField textField_Sname = new JTextField();
                    textField_Sname.setText(String.valueOf(student_login.getName()));
                    textField_Sname.setFont(new Font("????????????", Font.PLAIN, 13));
                    textField_Sname.setBounds(124, 149, 130, 26);
                    panel_changeinfoPage_student.add(textField_Sname);
                    textField_Sname.setColumns(10);

                    JLabel lblPwd = new JLabel("????????????:");
                    lblPwd.setFont(new Font("????????????", Font.BOLD, 13));
                    lblPwd.setBounds(39, 206, 76, 16);
                    panel_changeinfoPage_student.add(lblPwd);

                    JPasswordField textField_Spwd = new JPasswordField();
                    textField_Spwd.setBorder(new QuickButton.RoundBorder(Color.black, 0));
                    textField_Spwd.setFont(new Font("????????????", Font.PLAIN, 13));
                    textField_Spwd.setBounds(124, 201, 130, 26);
                    panel_changeinfoPage_student.add(textField_Spwd);
                    textField_Spwd.setColumns(10);

                    JLabel lblScontact = new JLabel("????????????:");
                    lblScontact.setFont(new Font("????????????", Font.BOLD, 13));
                    lblScontact.setBounds(39, 258, 76, 16);
                    panel_changeinfoPage_student.add(lblScontact);

                    JTextField textField_Scontact = new JTextField();
                    textField_Scontact.setText(String.valueOf(student_login.getContact()));
                    textField_Scontact.setFont(new Font("????????????", Font.PLAIN, 13));
                    textField_Scontact.setBounds(124, 253, 130, 26);
                    panel_changeinfoPage_student.add(textField_Scontact);
                    textField_Scontact.setColumns(10);

                    JLabel lblSgender = new JLabel("??????:");
                    lblSgender.setFont(new Font("????????????", Font.BOLD, 13));
                    lblSgender.setBounds(39, 310, 61, 16);
                    panel_changeinfoPage_student.add(lblSgender);

                    String[] genders = new String[]{"???", "???"};
                    JComboBox comboBox_Sgender = new JComboBox(genders);
                    setComboboxStyle(comboBox_Sgender);
                    comboBox_Sgender.setSelectedItem(student_login.getGender());
                    comboBox_Sgender.setFont(new Font("????????????", Font.PLAIN, 13));
                    comboBox_Sgender.setBounds(124, 310, 76, 20);
                    panel_changeinfoPage_student.add(comboBox_Sgender);

                    JLabel lblScollege = new JLabel("??????:");
                    lblScollege.setFont(new Font("????????????", Font.BOLD, 13));
                    lblScollege.setBounds(332, 102, 61, 16);
                    panel_changeinfoPage_student.add(lblScollege);

                    JLabel lblScollegepresent = new JLabel(student_login.getScollege());
                    lblScollegepresent.setFont(new Font("????????????", Font.PLAIN, 13));
                    lblScollegepresent.setBounds(413, 102, 120, 16);
                    panel_changeinfoPage_student.add(lblScollegepresent);

                    JLabel lblMajor = new JLabel("??????:");
                    lblMajor.setFont(new Font("????????????", Font.BOLD, 13));
                    lblMajor.setBounds(332, 154, 61, 16);
                    panel_changeinfoPage_student.add(lblMajor);

                    JLabel lblSmajorPresent = new JLabel(student_login.getSmajor());
                    lblSmajorPresent.setFont(new Font("????????????", Font.PLAIN, 13));
                    lblSmajorPresent.setBounds(413, 154, 130, 16);
                    panel_changeinfoPage_student.add(lblSmajorPresent);

                    JLabel lblSclass = new JLabel("??????:");
                    lblSclass.setFont(new Font("????????????", Font.BOLD, 13));
                    lblSclass.setBounds(332, 206, 61, 16);
                    panel_changeinfoPage_student.add(lblSclass);

                    JLabel lblSclassPresent = new JLabel(String.valueOf(student_login.getSclass()));
                    lblSclassPresent.setFont(new Font("????????????", Font.PLAIN, 13));
                    lblSclassPresent.setBounds(413, 206, 76, 16);
                    panel_changeinfoPage_student.add(lblSclassPresent);

                    JLabel lblSFirstyear = new JLabel("????????????:");
                    lblSFirstyear.setFont(new Font("????????????", Font.BOLD, 13));
                    lblSFirstyear.setBounds(330, 258, 76, 16);
                    panel_changeinfoPage_student.add(lblSFirstyear);

                    JLabel lblFirstYearpresent = new JLabel(String.valueOf(student_login.getSfirstyear()));
                    lblFirstYearpresent.setFont(new Font("????????????", Font.PLAIN, 13));
                    lblFirstYearpresent.setBounds(413, 258, 76, 16);
                    panel_changeinfoPage_student.add(lblFirstYearpresent);

                    JButton btnSubmit = primaryBorderButton("????????????");
                    btnSubmit.setFont(new Font("????????????", Font.BOLD, 13));
                    btnSubmit.setBounds(400, 379, 117, 29);
                    panel_changeinfoPage_student.add(btnSubmit);

                    JLabel lblFalse_name = new JLabel("???????????????????????????");
                    lblFalse_name.setFont(new Font("????????????", Font.BOLD, 13));
                    lblFalse_name.setBounds(130, 179, 140, 16);
                    lblFalse_name.setForeground(Color.red);
                    panel_changeinfoPage_student.add(lblFalse_name);

                    JLabel lblFalse_contact = new JLabel("??????????????????????????????");
                    lblFalse_contact.setFont(new Font("????????????", Font.BOLD, 13));
                    lblFalse_contact.setBounds(130, 283, 140, 16);
                    lblFalse_contact.setForeground(Color.red);
                    panel_changeinfoPage_student.add(lblFalse_contact);

                    lblFalse_name.setVisible(false);
                    lblFalse_contact.setVisible(false);

                    ActionListener actionListener_changeinfo = new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            StudentService studentService = new StudentService();

                            int sid = student_login.getId();

                            String sname;
                            if (!isName(textField_Sname.getText())) {
                                System.out.println("???????????????????????????");
                                sname = student_login.getName();
                                lblFalse_name.setVisible(true);
                            } else {
                                sname = textField_Sname.getText();
                            }

                            String spwd;
                            if (textField_Spwd.getText().equals("")) {
                                spwd = student_login.getPw();
                            } else {
                                spwd = SHA256.SHA256(textField_Spwd.getText());
                            }

                            String scontact;
                            if (!isPhoneNum(textField_Scontact.getText())) {
                                System.out.println("?????????????????????????????????");
                                scontact = student_login.getContact();
                                lblFalse_contact.setVisible(true);
                            } else {
                                scontact = textField_Scontact.getText();
                            }

                            String sgender = (String) comboBox_Sgender.getSelectedItem();
                            String scollege = student_login.getScollege();
                            String smajor = student_login.getSmajor();
                            int sclass = student_login.getSclass();
                            int sfirstyear = student_login.getSfirstyear();

                            Student student1 = new Student(sname, sid, spwd, sgender, scontact, sfirstyear, sclass, smajor, scollege);
                            studentService.Update(dbConnector, student1);

                            lblHello_student_present.setText(String.format("%s,?????????", studentService.CheckById(dbConnector, student1.getId()).get(0).getName()));
                            lblGender_present_student.setText(studentService.CheckById(dbConnector, student1.getId()).get(0).getGender());
                            lblContact_present_student.setText(studentService.CheckById(dbConnector, student1.getId()).get(0).getContact());
                        }
                    };

                    btnSubmit.addActionListener(actionListener_changeinfo);

                    panel_container_student.removeAll();
                    panel_container_student.add(panel_changeinfoPage_student);
                    panel_container_student.validate();
                    panel_container_student.repaint();
                    System.out.println("6");
                    panel_changeinfoPage_student.setVisible(true);

                } else if (e.getSource().equals(btnAbout_student)) {
                    JPanel panel_about_student = new JPanel();
                    panel_container_student.add(panel_about_student, "about");
                    panel_about_student.setLayout(null);

                    JPanel panel_title_about_student = new JPanel();
                    panel_title_about_student.setLayout(null);
                    panel_title_about_student.setForeground(SystemColor.activeCaption);
                    panel_title_about_student.setBackground(SystemColor.scrollbar);
                    panel_title_about_student.setBounds(0, 0, 553, 46);
                    panel_about_student.add(panel_title_about_student);

                    JLabel lbltitle_about = new JLabel("??????SPWD??????????????????");
                    lbltitle_about.setFont(new Font("????????????", Font.BOLD, 16));
                    lbltitle_about.setBounds(10, 10, 200, 22);
                    panel_title_about_student.add(lbltitle_about);

                    JLabel lbl_spa = new JLabel("SPWD??????????????????");
                    lbl_spa.setFont(new Font("????????????", Font.BOLD, 16));
                    lbl_spa.setBounds(207, 149, 170, 28);
                    panel_about_student.add(lbl_spa);

                    JLabel lbl_spa_1 = new JLabel("Version 10.5.608");
                    lbl_spa_1.setFont(new Font("????????????", Font.PLAIN, 12));
                    lbl_spa_1.setBounds(227, 174, 115, 28);
                    panel_about_student.add(lbl_spa_1);

                    JLabel lblNewLabel_3_1_1_1 = new JLabel("Developed by:");
                    lblNewLabel_3_1_1_1.setBounds(185, 234, 95, 16);
                    lblNewLabel_3_1_1_1.setFont(new Font("????????????", Font.PLAIN, 12));
                    panel_about_student.add(lblNewLabel_3_1_1_1);

                    JLabel lblNewLabel_3_1_1_1_1 = new JLabel("Xia Runcheng");
                    lblNewLabel_3_1_1_1_1.setBounds(284, 234, 95, 16);
                    lblNewLabel_3_1_1_1_1.setFont(new Font("????????????", Font.PLAIN, 12));
                    panel_about_student.add(lblNewLabel_3_1_1_1_1);

                    JLabel lblNewLabel_3_1_1_1_1_1 = new JLabel("Wang Handi");
                    lblNewLabel_3_1_1_1_1_1.setBounds(284, 254, 95, 16);
                    lblNewLabel_3_1_1_1_1_1.setFont(new Font("????????????", Font.PLAIN, 12));
                    panel_about_student.add(lblNewLabel_3_1_1_1_1_1);

                    JLabel lblNewLabel_3_1_1_1_1_1_1 = new JLabel("Dong Liyao");
                    lblNewLabel_3_1_1_1_1_1_1.setBounds(284, 274, 95, 16);
                    lblNewLabel_3_1_1_1_1_1_1.setFont(new Font("????????????", Font.PLAIN, 12));
                    panel_about_student.add(lblNewLabel_3_1_1_1_1_1_1);

                    JLabel lblNewLabel_3 = new JLabel("Copyright ?? 2022 SpecialWudi Inc. Practice makes PERFECT.");
                    lblNewLabel_3.setBounds(86, 406, 391, 16);
                    lblNewLabel_3.setFont(new Font("????????????", Font.PLAIN, 12));
                    panel_about_student.add(lblNewLabel_3);

                    JLabel lblNewLabel_3_1 = new JLabel("BJUT-11-B105 ????????????");
                    lblNewLabel_3_1.setBounds(205, 383, 147, 16);
                    lblNewLabel_3_1.setFont(new Font("????????????", Font.PLAIN, 12));
                    panel_about_student.add(lblNewLabel_3_1);

                    JLabel lblNewLabel_3_1_1 = new JLabel("???????????????156XXXX9915");
                    lblNewLabel_3_1_1.setBounds(201, 362, 181, 16);
                    lblNewLabel_3_1_1.setFont(new Font("????????????", Font.PLAIN, 12));
                    panel_about_student.add(lblNewLabel_3_1_1);

                    java.net.URL fileURL = this.getClass().getResource("/newjwglxt/jwglxt/util/logo.png");
                    assert fileURL != null;
                    ImageIcon img = new ImageIcon(fileURL);
                    Image image = img.getImage();
                    image = image.getScaledInstance(64, 64, Image.SCALE_AREA_AVERAGING);
                    img.setImage(image);

                    JLabel label = new JLabel(img);
                    label.setBounds(247, 73, 64, 64);
                    panel_about_student.add(label);

                    panel_container_student.removeAll();
                    panel_container_student.add(panel_about_student);
                    panel_container_student.validate();
                    panel_container_student.repaint();
                    System.out.println("7");
                    panel_about_student.setVisible(true);

                } else if (e.getSource().equals(btnExit_student)) {
                    contentPane.removeAll();
                    LoginPanel loginPanel = new LoginPanel();
                    contentPane.add(loginPanel.getPanel());
                    contentPane.validate();
                    contentPane.repaint();
                    loginPanel.getPanel().setVisible(true);
                    dbConnector.closeConnection();
                }
            }
        };

        btnHomePage_student.addActionListener(actionlistenerStudent);
        btnMyCourse_student.addActionListener(actionlistenerStudent);
        btn_dropcoursepresent.addActionListener(actionlistenerStudent);
        btnGrade_student.addActionListener(actionlistenerStudent);
        btnShowtable_student.addActionListener(actionlistenerStudent);
        btnChangeInfo_student.addActionListener(actionlistenerStudent);
        btnAbout_student.addActionListener(actionlistenerStudent);
        btnExit_student.addActionListener(actionlistenerStudent);
    }

}
