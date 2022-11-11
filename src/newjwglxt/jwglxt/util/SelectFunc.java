package newjwglxt.jwglxt.util;

import newjwglxt.jwglxt.service.idx1.CourseService;
import newjwglxt.jwglxt.service.idx1.JwadminService;
import newjwglxt.jwglxt.service.idx1.StudentService;
import newjwglxt.jwglxt.service.idx1.TeacherService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import static newjwglxt.jwglxt.util.ComboboxStyle.setComboboxStyle;
import static newjwglxt.jwglxt.util.Judge.isNum;
import static newjwglxt.jwglxt.util.QuickButton.primaryBorderButton;

public class SelectFunc {
    private JPanel panel_Chazhao;

    public SelectFunc(String role, DbConnector dbConnector, JPanel panel_category, int btn_y, JPanel panel_container) {
        switch (role) {
            case "xtadmin": {
                init_xtadmin(dbConnector, panel_category, btn_y, panel_container);
                break;
            }
            case "jwadmin": {
                init_jwadmin(dbConnector, panel_category, btn_y, panel_container);
                break;
            }
        }
    }

    private void init_xtadmin(DbConnector dbConnector, JPanel panel_category, int btn_y, JPanel panel_container) {
        // left
        JButton btnUnknown8 = primaryBorderButton("查找");
        btnUnknown8.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnUnknown8.setBounds(10, btn_y, 130, 35);
        panel_category.add(btnUnknown8);

        // right
        panel_Chazhao = new JPanel();
        panel_Chazhao.setLayout(null);
        panel_container.add(panel_Chazhao);

        // title
        JPanel panel_title_zhuye_jwadmin = new JPanel();
        panel_title_zhuye_jwadmin.setLayout(null);
        panel_title_zhuye_jwadmin.setForeground(SystemColor.activeCaption);
        panel_title_zhuye_jwadmin.setBackground(SystemColor.scrollbar);
        panel_title_zhuye_jwadmin.setBounds(0, 0, 553, 46);
        panel_Chazhao.add(panel_title_zhuye_jwadmin);

        JLabel lblNewLabel_8_1 = new JLabel("查找");
        lblNewLabel_8_1.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lblNewLabel_8_1.setBounds(10, 10, 64, 22);
        panel_title_zhuye_jwadmin.add(lblNewLabel_8_1);

        // search combobox
        JComboBox jComboBox = new JComboBox();
        jComboBox.setModel(new DefaultComboBoxModel(new String[]{"教职工号", "姓名"}));
        setComboboxStyle(jComboBox);
        jComboBox.setSelectedIndex(0);
        jComboBox.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        jComboBox.setBounds(553 - 70 - 10 - 10 - 140 - 90 - 20, 56, 110, 26);
        panel_Chazhao.add(jComboBox);

        JTextField textFielda = new JTextField();
        textFielda.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        textFielda.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textFielda.setBounds(553 - 70 - 10 - 140, 56, 140-10, 26);
        panel_Chazhao.add(textFielda);

        JButton btnCreateCourse_1a = primaryBorderButton("查找");
        btnCreateCourse_1a.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnCreateCourse_1a.setBounds(553 - 70 - 10, 56, 70, 26);
        panel_Chazhao.add(btnCreateCourse_1a);

        // table
        JScrollPane scrollPane_jiaoshiliebiao = new JScrollPane();
        scrollPane_jiaoshiliebiao.setBounds(10, 46 + 10 + 26 + 10, 553 - 20, 451 - 46 - 10 - 10 - 10 - 26);
        panel_Chazhao.add(scrollPane_jiaoshiliebiao);

        Vector<String> table_title = new Vector<>();
        table_title.add("教职工号");
        table_title.add("姓名");
        table_title.add("性别");
        table_title.add("联系方式");

        JTable table_jiaoshiliebiao = new JTable();
        table_jiaoshiliebiao.getTableHeader().setReorderingAllowed(false);
        table_jiaoshiliebiao.getTableHeader().setFont(new Font("微软雅黑", Font.PLAIN, 11));
        table_jiaoshiliebiao.setFont(new Font("微软雅黑", Font.PLAIN, 11));

        JwadminService jwadminService = new JwadminService();
        table_jiaoshiliebiao.setModel(new DefaultTableModel(jwadminService.getAllJwadminVector(dbConnector), table_title));
        scrollPane_jiaoshiliebiao.setViewportView(table_jiaoshiliebiao);

        JLabel lblNewLabel_8_1g = new JLabel("请检查输入!");
        lblNewLabel_8_1g.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_8_1g.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_8_1g.setForeground(Color.red);
        lblNewLabel_8_1g.setBounds(553 - 70 - 10 - 20 - 140 - 90 - 10 - 100 - 10, 56, 100, 30);
        panel_title_zhuye_jwadmin.add(lblNewLabel_8_1g);
        lblNewLabel_8_1g.setVisible(false);

        btnUnknown8.addActionListener(e -> {
            lblNewLabel_8_1g.setVisible(false);
            panel_container.removeAll();
            panel_container.add(panel_Chazhao);
            panel_container.validate();
            panel_container.repaint();
            panel_Chazhao.setVisible(true);
        });

        btnCreateCourse_1a.addActionListener(e -> {
            String str = textFielda.getText();
            Vector<Vector<Object>> vectors = null;

            if (str.equals("")) {
                vectors = jwadminService.getAllJwadminVector(dbConnector);
            } else {
                if (jComboBox.getSelectedItem().equals("教职工号")) {
                    if (isNum(str)) {
                        System.out.println("f");
                        vectors = jwadminService.CheckByIdRough_Vector(dbConnector, Integer.parseInt(str));
                    }
                }
                if (jComboBox.getSelectedItem().equals("姓名")) {
                    vectors = jwadminService.CheckByNameRough_Vector(dbConnector, str);
                }
            }
            table_jiaoshiliebiao.setModel(new DefaultTableModel(vectors, table_title) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            });

        });

    }

    private void init_jwadmin(DbConnector dbConnector, JPanel panel_category, int btn_y, JPanel panel_container) {
        // left
        JButton btnUnknown8 = primaryBorderButton("查找");
        btnUnknown8.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnUnknown8.setBounds(10, btn_y, 130, 35);
        panel_category.add(btnUnknown8);

        // right
        panel_Chazhao = new JPanel();
        panel_Chazhao.setLayout(null);
        panel_container.add(panel_Chazhao);

        // title
        JPanel panel_title_zhuye_jwadmin = new JPanel();
        panel_title_zhuye_jwadmin.setLayout(null);
        panel_title_zhuye_jwadmin.setForeground(SystemColor.activeCaption);
        panel_title_zhuye_jwadmin.setBackground(SystemColor.scrollbar);
        panel_title_zhuye_jwadmin.setBounds(0, 0, 553, 46);
        panel_Chazhao.add(panel_title_zhuye_jwadmin);

        JLabel lblNewLabel_8_1 = new JLabel("查找");
        lblNewLabel_8_1.setFont(new Font("微软雅黑", Font.BOLD, 16));
        lblNewLabel_8_1.setBounds(10, 10, 64, 22);
        panel_title_zhuye_jwadmin.add(lblNewLabel_8_1);

        // radio button
        JRadioButton rdbtnNewRadioButton0 = new JRadioButton("课程");
        rdbtnNewRadioButton0.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        rdbtnNewRadioButton0.setBounds(10, 56, 60, 23);
        rdbtnNewRadioButton0.setSelected(true);
        panel_Chazhao.add(rdbtnNewRadioButton0);

        JRadioButton rdbtnNewRadioButton1 = new JRadioButton("教师");
        rdbtnNewRadioButton1.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        rdbtnNewRadioButton1.setBounds(140 - 35 - 35, 56, 60, 23);
        panel_Chazhao.add(rdbtnNewRadioButton1);

        JRadioButton rdbtnNewRadioButton2 = new JRadioButton("学生");
        rdbtnNewRadioButton2.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        rdbtnNewRadioButton2.setBounds(270 - 70 - 70, 56, 60, 23);
        panel_Chazhao.add(rdbtnNewRadioButton2);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rdbtnNewRadioButton0);
        buttonGroup.add(rdbtnNewRadioButton1);
        buttonGroup.add(rdbtnNewRadioButton2);

        // search combobox
        JComboBox<String> jComboBox = new JComboBox<>();
        DefaultComboBoxModel<String> defaultComboBoxModel0 = new DefaultComboBoxModel<>(new String[]{"课程编号", "课程名称", "开课部门", "课程类别", "教师姓名"});
        jComboBox.setModel(defaultComboBoxModel0);
        setComboboxStyle(jComboBox);
        jComboBox.setSelectedIndex(0);
        jComboBox.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        jComboBox.setBounds(213 + 20, 56, 110, 26);
        panel_Chazhao.add(jComboBox);


        DefaultComboBoxModel<String> defaultComboBoxModel1 = new DefaultComboBoxModel<>(new String[]{"教职工号", "姓名", "入职年份", "职称", "学部（院）"});

        DefaultComboBoxModel<String> defaultComboBoxModel2 = new DefaultComboBoxModel<>(new String[]{"学号", "姓名", "入学年份", "行政班", "专业", "学部（院）"});

        JTextField textFielda = new JTextField();
        textFielda.setBorder(new QuickButton.RoundBorder(Color.black, 0));
        textFielda.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        textFielda.setBounds(553 - 70 - 10 - 10 - 140 + 20, 56, 120, 26);
        panel_Chazhao.add(textFielda);

        JButton btnCreateCourse_1a = primaryBorderButton("查找");
        btnCreateCourse_1a.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        btnCreateCourse_1a.setBounds(553 - 70 - 10, 56, 70, 26);
        panel_Chazhao.add(btnCreateCourse_1a);

        // table
        JScrollPane scrollPane_jiaoshiliebiao = new JScrollPane();
        scrollPane_jiaoshiliebiao.setBounds(10, 46 + 10 + 26 + 10, 553 - 20, 451 - 46 - 10 - 10 - 10 - 26);
        panel_Chazhao.add(scrollPane_jiaoshiliebiao);

        Vector<String> table_title0 = new Vector<>();
        table_title0.add("课程编号");
        table_title0.add("课程名称");
        table_title0.add("开课部门");
        table_title0.add("学分");
        table_title0.add("课程类别");
        table_title0.add("教师");
        table_title0.add("地点");
        table_title0.add("时间");
        table_title0.add("报名人数");
        table_title0.add("最大人数");

        Vector<String> table_title1 = new Vector<>();
        table_title1.add("教师编号");
        table_title1.add("姓名");
        table_title1.add("性别");
        table_title1.add("入职年份");
        table_title1.add("职称");
        table_title1.add("学部（院）");
        table_title1.add("联系方式");

        Vector<String> table_title2 = new Vector<>();
        table_title2.add("学号");
        table_title2.add("姓名");
        table_title2.add("性别");
        table_title2.add("入学年份");
        table_title2.add("专业");
        table_title2.add("行政班");
        table_title2.add("学部（院）");
        table_title2.add("联系方式");

        JTable table_jiaoshiliebiao = new JTable();
        table_jiaoshiliebiao.getTableHeader().setReorderingAllowed(false);
        table_jiaoshiliebiao.getTableHeader().setFont(new Font("微软雅黑", Font.PLAIN, 11));
        table_jiaoshiliebiao.setFont(new Font("微软雅黑", Font.PLAIN, 11));


        JLabel lblNewLabel_8_1g = new JLabel("请检查输入!");
        lblNewLabel_8_1g.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        lblNewLabel_8_1g.setHorizontalAlignment(SwingConstants.RIGHT);
        lblNewLabel_8_1g.setForeground(Color.red);
        lblNewLabel_8_1g.setBounds(103, 56, 100, 30);
        panel_title_zhuye_jwadmin.add(lblNewLabel_8_1g);
        lblNewLabel_8_1g.setVisible(false);

        ActionListener actionListener0 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = textFielda.getText();
                Vector<Vector<Object>> vectors = null;
                CourseService courseService = new CourseService();
                if (str.equals("")) {
                    vectors = courseService.getAllCourseVector_jwadmin(dbConnector);
                } else {
                    if (jComboBox.getSelectedItem().equals("课程编号")) {
                        if (isNum(str)) {
                            System.out.println("f");
                            vectors = courseService.CheckByIdRough_Vector(dbConnector, Integer.parseInt(str));
                        }
                    }
                    if (jComboBox.getSelectedItem().equals("课程名称")) {
                        vectors = courseService.CheckByNameRough_Vector(dbConnector, str);
                    }
                    if (jComboBox.getSelectedItem().equals("开课部门")) {
                        vectors = courseService.CheckByCollegeRough_Vector(dbConnector, str);
                    }
                    if (jComboBox.getSelectedItem().equals("课程类别")) {
                        vectors = courseService.CheckByKclb_Vector(dbConnector, str);
                    }
                    if (jComboBox.getSelectedItem().equals("教师姓名")) {
                        vectors = courseService.CheckByTnameRough_Vector(dbConnector, str);
                    }
                }
                table_jiaoshiliebiao.setModel(new DefaultTableModel(vectors, table_title0) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                });
            }
        };

        ActionListener actionListener1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = textFielda.getText();
                Vector<Vector<Object>> vectors = null;
                TeacherService teacherService = new TeacherService();
                if (str.equals("")) {
                    vectors = teacherService.getAllTeacherVector_jwadmin(dbConnector);
                } else {
                    if (jComboBox.getSelectedItem().equals("教职工号")) {
                        if (isNum(str)) {
                            System.out.println("f");
                            vectors = teacherService.CheckByIdRough_Vector(dbConnector, Integer.parseInt(str));
                        }
                    }
                    if (jComboBox.getSelectedItem().equals("姓名")) {
                        vectors = teacherService.CheckByNameRough_Vector(dbConnector, str);
                    }
                    if (jComboBox.getSelectedItem().equals("入职年份")) {
                        vectors = teacherService.CheckByFirstYearRough_Vector(dbConnector, str);
                    }
                    if (jComboBox.getSelectedItem().equals("职称")) {
                        vectors = teacherService.CheckByTitleRough_Vector(dbConnector, str);
                    }
                    if (jComboBox.getSelectedItem().equals("学部（院）")) {
                        vectors = teacherService.CheckByCollegeRough_Vector(dbConnector, str);
                    }
                }
                table_jiaoshiliebiao.setModel(new DefaultTableModel(vectors, table_title1) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                });
            }
        };

        ActionListener actionListener2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = textFielda.getText();
                Vector<Vector<Object>> vectors = null;
                StudentService studentService = new StudentService();
                if (str.equals("")) {
                    vectors = studentService.getAllStudentVector(dbConnector);
                } else {
                    if (jComboBox.getSelectedItem().equals("学号")) {
                        if (isNum(str)) {
                            System.out.println("f");
                            vectors = studentService.CheckByIdRough_Vector(dbConnector, Integer.parseInt(str));
                        }
                    }
                    if (jComboBox.getSelectedItem().equals("姓名")) {
                        vectors = studentService.CheckByNameRough_Vector(dbConnector, str);
                    }
                    if (jComboBox.getSelectedItem().equals("入学年份")) {
                        vectors = studentService.CheckByFirstYearRough_Vector(dbConnector, str);
                    }
                    if (jComboBox.getSelectedItem().equals("行政班")) {
                        vectors = studentService.CheckByClass_Vector(dbConnector, str);
                    }
                    if (jComboBox.getSelectedItem().equals("专业")) {
                        vectors = studentService.CheckByMajorRough_Vector(dbConnector, str);
                    }
                    if (jComboBox.getSelectedItem().equals("学部（院）")) {
                        vectors = studentService.CheckByCollegeRough_Vector(dbConnector, str);
                    }
                }
                table_jiaoshiliebiao.setModel(new DefaultTableModel(vectors, table_title2) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                });
            }
        };

        // 左侧查找按钮AL
        btnUnknown8.addActionListener(e0 -> {
            CourseService courseService0 = new CourseService();
            table_jiaoshiliebiao.setModel(new DefaultTableModel(courseService0.getAllCourseVector_jwadmin(dbConnector), table_title0));
            scrollPane_jiaoshiliebiao.setViewportView(table_jiaoshiliebiao);
            textFielda.setText("");
            rdbtnNewRadioButton0.setSelected(true);
            jComboBox.setModel(defaultComboBoxModel0);

            btnCreateCourse_1a.removeActionListener(actionListener1);
            btnCreateCourse_1a.addActionListener(actionListener0);

            lblNewLabel_8_1g.setVisible(false);
            panel_container.removeAll();
            panel_container.add(panel_Chazhao);
            panel_container.validate();
            panel_container.repaint();
            panel_Chazhao.setVisible(true);
        });

        // radiobutton AL
        rdbtnNewRadioButton0.addActionListener(e -> {
            jComboBox.setModel(defaultComboBoxModel0);
            textFielda.setText("");
            CourseService courseService = new CourseService();
            table_jiaoshiliebiao.setModel(new DefaultTableModel(courseService.getAllCourseVector_jwadmin(dbConnector), table_title0));
            table_jiaoshiliebiao.updateUI();

            btnCreateCourse_1a.removeActionListener(actionListener1);
            btnCreateCourse_1a.removeActionListener(actionListener2);
            btnCreateCourse_1a.addActionListener(actionListener0);
        });

        rdbtnNewRadioButton1.addActionListener(e -> {
            jComboBox.setModel(defaultComboBoxModel1);
            textFielda.setText("");
            TeacherService teacherService = new TeacherService();
            table_jiaoshiliebiao.setModel(new DefaultTableModel(teacherService.getAllTeacherVector_jwadmin(dbConnector), table_title1));
            table_jiaoshiliebiao.updateUI();

            btnCreateCourse_1a.removeActionListener(actionListener0);
            btnCreateCourse_1a.removeActionListener(actionListener2);
            btnCreateCourse_1a.addActionListener(actionListener1);
        });

        rdbtnNewRadioButton2.addActionListener(e -> {
            jComboBox.setModel(defaultComboBoxModel2);
            textFielda.setText("");
            StudentService studentService = new StudentService();
            table_jiaoshiliebiao.setModel(new DefaultTableModel(studentService.getAllStudentVector(dbConnector), table_title2));
            table_jiaoshiliebiao.updateUI();

            btnCreateCourse_1a.removeActionListener(actionListener0);
            btnCreateCourse_1a.removeActionListener(actionListener1);
            btnCreateCourse_1a.addActionListener(actionListener2);
        });

    }

}
