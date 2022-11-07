package newjwglxt.jwglxt.service.idx1;

import newjwglxt.jwglxt.dao.idx1.CourseDaoImpl;
import newjwglxt.jwglxt.entity.*;
import newjwglxt.jwglxt.service.idx2.ChooseCourseService;
import newjwglxt.jwglxt.service.idx2.DropCourseService;
import newjwglxt.jwglxt.util.DbConnector;

import java.util.ArrayList;
import java.util.Vector;

public class CourseService implements Service_idx1<Course> {
    @Override
    public void Add(DbConnector dbConnector, Course course) {
        CourseDaoImpl courseDao = new CourseDaoImpl();
        courseDao.Insert(dbConnector.getConnection(), course);
    }

    @Override
    public void Delete(DbConnector dbConnector, Course course) {
        CourseDaoImpl courseDao = new CourseDaoImpl();
        courseDao.Delete(dbConnector.getConnection(), course);
    }

    @Override
    public void Update(DbConnector dbConnector, Course course) {
        CourseDaoImpl courseDao = new CourseDaoImpl();
        courseDao.Update(dbConnector.getConnection(), course);
    }

    @Override
    public ArrayList<Course> CheckById(DbConnector dbConnector, int id) {
        CourseDaoImpl courseDao = new CourseDaoImpl();
        return courseDao.SelectById(dbConnector.getConnection(), id);
    }

    @Override
    public ArrayList<Course> CheckByIdRough(DbConnector dbConnector, int id) {
        CourseDaoImpl courseDao = new CourseDaoImpl();
        return courseDao.SelectByIdRough(dbConnector.getConnection(), id);
    }

    @Override
    public ArrayList<Course> CheckByName(DbConnector dbConnector, String name) {
        CourseDaoImpl courseDao = new CourseDaoImpl();
        return courseDao.SelectByName(dbConnector.getConnection(), name);
    }

    @Override
    public ArrayList<Course> CheckByNameRough(DbConnector dbConnector, String name) {
        CourseDaoImpl courseDao = new CourseDaoImpl();
        return courseDao.SelectByNameRough(dbConnector.getConnection(), name);
    }

    public ArrayList<Course> CheckTeacherCourses(DbConnector dbConnector, int tid) {
        CourseDaoImpl courseDao = new CourseDaoImpl();
        return courseDao.SelectByTeacherID(dbConnector.getConnection(), tid);
    }

    public ArrayList<Course> CheckByDepartmentRough (DbConnector dbConnector, String department) {
        CourseDaoImpl courseDao = new CourseDaoImpl();
        return courseDao.SelectedByDepartmentRough(dbConnector.getConnection(), department);
    }

    public ArrayList<Course> CheckByKclbRough (DbConnector dbConnector, String kclb) {
        CourseDaoImpl courseDao = new CourseDaoImpl();
        return courseDao.SelectedByKclbRough(dbConnector.getConnection(), kclb);
    }

    public ArrayList<Course> CheckByTeacherNameRough (DbConnector dbConnector, String tname) {
        CourseDaoImpl courseDao = new CourseDaoImpl();
        TeacherService teacherService = new TeacherService();
        return courseDao.SelectByTeacherID(dbConnector.getConnection(), teacherService.CheckByNameRough(dbConnector, tname).get(0).getId());
    }

    // 为studentPanel的可选课程功能返回该学生除去已选的课程之外的课程的信息
    public Vector<Vector<Object>> getCourseVector_exceptSelectedCourses(DbConnector dbConnector, Student student) {
        CourseDaoImpl courseDao = new CourseDaoImpl();
        TeacherService teacherService = new TeacherService();
        ArrayList<Course> allCourses = courseDao.Select(dbConnector.getConnection());

        //全部课程的id
        ArrayList<Integer> allCourses_cid = new ArrayList<>();
        for (Course course : allCourses) {
            allCourses_cid.add(course.getCid());
        }

        ChooseCourseService chooseCourseService = new ChooseCourseService();
        DropCourseService dropCourseService = new DropCourseService();

        ArrayList<ChooseCourse> chosenCourses = chooseCourseService.CheckBySid(dbConnector, student.getId());

        //所有所选课程的id
        ArrayList<Integer> chosenCourses_cid = new ArrayList<>();
        for (ChooseCourse chooseCourse : chosenCourses) {
            chosenCourses_cid.add(chooseCourse.getCccid());
        }

        ArrayList<DropCourse> dropCourses = dropCourseService.CheckBySid(dbConnector, student.getId());

        //所有退课的id
        ArrayList<Integer> droppedCourses_cid = new ArrayList<>();
        for (DropCourse dropCourse : dropCourses) {
            droppedCourses_cid.add(dropCourse.getDccid());
        }

        //所有可选课程的id
        ArrayList<Integer> courses_cid = new ArrayList<>();
        for (int x : allCourses_cid) {
            //选课表和退课表都没有
            if (!chosenCourses_cid.contains(x) && !droppedCourses_cid.contains(x)) {
                courses_cid.add(x);
            } else if (!chosenCourses_cid.contains(x) && dropCourseService.CheckBySidAndCid(dbConnector, student.getId(), x).get(0).getDchandle() == 1) {
                //选课表没有，退课表必须是批准
                courses_cid.add(x);
            }
        }

        CourseService courseService = new CourseService();

        Vector<Vector<Object>> courseCol = new Vector<>();
        for (int cid : courses_cid) {
            Vector<Object> courseRow = new Vector<>();
            courseRow.add(courseService.CheckById(dbConnector, cid).get(0).getCname());
            courseRow.add(cid);
            courseRow.add(courseService.CheckById(dbConnector, cid).get(0).getCtime());
            courseRow.add(courseService.CheckById(dbConnector, cid).get(0).getCroom());
            courseRow.add(courseService.CheckById(dbConnector, cid).get(0).getCcredit());
            courseRow.add(courseService.CheckById(dbConnector, cid).get(0).getCkclb());
            courseRow.add(teacherService.CheckById(dbConnector, courseService.CheckById(dbConnector, cid).get(0).getCteacherid()).get(0).getName());
            courseCol.add(courseRow);
        }
        return courseCol;
    }

    // 为teacherPanel的我教的课程功能返回该老师所教的所有课程信息
    public Vector<Vector<Object>> getMyCourseVector_teacher(DbConnector dbConnector, Teacher teacher) {
        CourseDaoImpl courseDao = new CourseDaoImpl();
        ArrayList<Course> myAllCourses = courseDao.SelectByTeacherID(dbConnector.getConnection(), teacher.getId());
        Vector<Vector<Object>> courseCol = new Vector<>();
        for (Course course : myAllCourses) {
            Vector<Object> courseRow = new Vector<>();
            courseRow.add(course.getCid());
            courseRow.add(course.getCname());
            courseRow.add(course.getCdepartment());
            courseRow.add(course.getCcredit());
            courseRow.add(course.getCkclb());
            courseRow.add(course.getCroom());
            courseRow.add(course.getCtime());
            courseRow.add(course.getCsigned_num());
            courseRow.add(course.getCmax_num());
            courseCol.add(courseRow);
        }
        return courseCol;
    }

    // 为teacherPanel的成绩管理的JcomboBox返回该老师所教的课的Name向量
    public Vector<String> getMyCourseNameVector_teacher(DbConnector dbConnector, Teacher teacher) {
        CourseDaoImpl courseDao = new CourseDaoImpl();
        ArrayList<Course> myAllCourses = courseDao.SelectByTeacherID(dbConnector.getConnection(), teacher.getId());
        Vector<String> vector_myCourseName = new Vector<>();
        for (Course course : myAllCourses)
            vector_myCourseName.add(String.format("[%d]%s", course.getCid(), course.getCname()));
        return vector_myCourseName;
    }

    // 为jwadminPanel的课程管理的表格返回所有课程信息
    public Vector<Vector<Object>> getAllCourseVector_jwadmin(DbConnector dbConnector) {
        CourseDaoImpl courseDao = new CourseDaoImpl();
        TeacherService teacherService = new TeacherService();
        ArrayList<Course> allCourses = courseDao.Select(dbConnector.getConnection());
        Vector<Vector<Object>> courseCol = new Vector<>();
        for (Course course : allCourses) {
            Vector<Object> courseRow = new Vector<>();
            courseRow.add(course.getCid());
            courseRow.add(course.getCname());
            courseRow.add(course.getCdepartment());
            courseRow.add(course.getCcredit());
            courseRow.add(course.getCkclb());
            courseRow.add(teacherService.CheckById(dbConnector, course.getCteacherid()).get(0).getName());
            courseRow.add(course.getCroom());
            courseRow.add(course.getCtime());
            courseRow.add(course.getCsigned_num());
            courseRow.add(course.getCmax_num());
            courseCol.add(courseRow);
        }
        return courseCol;
    }

    public Vector<Vector<Object>> getSelectedByCnameVectorForStudent(DbConnector dbConnector, Student student, String cname) {
        CourseService courseService = new CourseService();
        TeacherService teacherService = new TeacherService();
        ArrayList<Course> courses = courseService.CheckByNameRough(dbConnector, cname);

        ArrayList<Integer> allCourses_cid = new ArrayList<>();
        for (Course course : courses) {
            allCourses_cid.add(course.getCid());
        }

        ChooseCourseService chooseCourseService = new ChooseCourseService();
        DropCourseService dropCourseService = new DropCourseService();

        ArrayList<ChooseCourse> chosenCourses = chooseCourseService.CheckBySid(dbConnector, student.getId());

        //所有所选课程的id
        ArrayList<Integer> chosenCourses_cid = new ArrayList<>();
        for (ChooseCourse chooseCourse : chosenCourses) {
            chosenCourses_cid.add(chooseCourse.getCccid());
        }

        ArrayList<DropCourse> dropCourses = dropCourseService.CheckBySid(dbConnector, student.getId());

        //所有退课的id
        ArrayList<Integer> droppedCourses_cid = new ArrayList<>();
        for (DropCourse dropCourse : dropCourses) {
            droppedCourses_cid.add(dropCourse.getDccid());
        }

        //所有可选课程的id
        ArrayList<Integer> courses_cid = new ArrayList<>();
        for (int x : allCourses_cid) {
            //选课表和退课表都没有
            if (!chosenCourses_cid.contains(x) && !droppedCourses_cid.contains(x)) {
                courses_cid.add(x);
            } else if (!chosenCourses_cid.contains(x) &&
                    dropCourseService.CheckBySidAndCid(dbConnector, student.getId(), x).get(0).getDchandle() == 1) {
                //选课表没有，退课表必须是批准
                courses_cid.add(x);
            }
        }

        Vector<Vector<Object>> courseCol = new Vector<>();
        for (int cid : courses_cid) {
            Vector<Object> courseRow = new Vector<>();
            courseRow.add(courseService.CheckById(dbConnector, cid).get(0).getCname());
            courseRow.add(cid);
            courseRow.add(courseService.CheckById(dbConnector, cid).get(0).getCtime());
            courseRow.add(courseService.CheckById(dbConnector, cid).get(0).getCroom());
            courseRow.add(courseService.CheckById(dbConnector, cid).get(0).getCcredit());
            courseRow.add(courseService.CheckById(dbConnector, cid).get(0).getCkclb());
            courseRow.add(teacherService.CheckById(dbConnector,
                    courseService.CheckById(dbConnector, cid).get(0).getCteacherid()).get(0).getName());
            courseCol.add(courseRow);
        }
        System.out.println(courses);
        return courseCol;

    }

    public Vector<Vector<Object>> getSelectedByDepartmentVectorForStudent(DbConnector dbConnector, Student student, String department) {
        CourseService courseService = new CourseService();
        TeacherService teacherService = new TeacherService();
        ArrayList<Course> courses = courseService.CheckByDepartmentRough(dbConnector, department);

        ArrayList<Integer> allCourses_cid = new ArrayList<>();
        for (Course course : courses) {
            allCourses_cid.add(course.getCid());
        }

        ChooseCourseService chooseCourseService = new ChooseCourseService();
        DropCourseService dropCourseService = new DropCourseService();

        ArrayList<ChooseCourse> chosenCourses = chooseCourseService.CheckBySid(dbConnector, student.getId());

        //所有所选课程的id
        ArrayList<Integer> chosenCourses_cid = new ArrayList<>();
        for (ChooseCourse chooseCourse : chosenCourses) {
            chosenCourses_cid.add(chooseCourse.getCccid());
        }

        ArrayList<DropCourse> dropCourses = dropCourseService.CheckBySid(dbConnector, student.getId());

        //所有退课的id
        ArrayList<Integer> droppedCourses_cid = new ArrayList<>();
        for (DropCourse dropCourse : dropCourses) {
            droppedCourses_cid.add(dropCourse.getDccid());
        }

        //所有可选课程的id
        ArrayList<Integer> courses_cid = new ArrayList<>();
        for (int x : allCourses_cid) {
            //选课表和退课表都没有
            if (!chosenCourses_cid.contains(x) && !droppedCourses_cid.contains(x)) {
                courses_cid.add(x);
            } else if (!chosenCourses_cid.contains(x) && dropCourseService.CheckBySidAndCid(dbConnector, student.getId(), x).get(0).getDchandle() == 1) {
                //选课表没有，退课表必须是批准
                courses_cid.add(x);
            }
        }

        Vector<Vector<Object>> courseCol = new Vector<>();
        for (int cid : courses_cid) {
            Vector<Object> courseRow = new Vector<>();
            courseRow.add(courseService.CheckById(dbConnector, cid).get(0).getCname());
            courseRow.add(cid);
            courseRow.add(courseService.CheckById(dbConnector, cid).get(0).getCtime());
            courseRow.add(courseService.CheckById(dbConnector, cid).get(0).getCroom());
            courseRow.add(courseService.CheckById(dbConnector, cid).get(0).getCcredit());
            courseRow.add(courseService.CheckById(dbConnector, cid).get(0).getCkclb());
            courseRow.add(teacherService.CheckById(dbConnector, courseService.CheckById(dbConnector, cid).get(0).getCteacherid()).get(0).getName());
            courseCol.add(courseRow);
        }
        System.out.println(courses);
        return courseCol;

    }

    public Vector<Vector<Object>> getSelectedByKclbVectorForStudent(DbConnector dbConnector, Student student, String kclb) {
        CourseService courseService = new CourseService();
        TeacherService teacherService = new TeacherService();
        ArrayList<Course> courses = courseService.CheckByKclbRough(dbConnector, kclb);

        ArrayList<Integer> allCourses_cid = new ArrayList<>();
        for (Course course : courses) {
            allCourses_cid.add(course.getCid());
        }

        ChooseCourseService chooseCourseService = new ChooseCourseService();
        DropCourseService dropCourseService = new DropCourseService();

        ArrayList<ChooseCourse> chosenCourses = chooseCourseService.CheckBySid(dbConnector, student.getId());

        //所有所选课程的id
        ArrayList<Integer> chosenCourses_cid = new ArrayList<>();
        for (ChooseCourse chooseCourse : chosenCourses) {
            chosenCourses_cid.add(chooseCourse.getCccid());
        }

        ArrayList<DropCourse> dropCourses = dropCourseService.CheckBySid(dbConnector, student.getId());

        //所有退课的id
        ArrayList<Integer> droppedCourses_cid = new ArrayList<>();
        for (DropCourse dropCourse : dropCourses) {
            droppedCourses_cid.add(dropCourse.getDccid());
        }

        //所有可选课程的id
        ArrayList<Integer> courses_cid = new ArrayList<>();
        for (int x : allCourses_cid) {
            //选课表和退课表都没有
            if (!chosenCourses_cid.contains(x) && !droppedCourses_cid.contains(x)) {
                courses_cid.add(x);
            } else if (!chosenCourses_cid.contains(x) && dropCourseService.CheckBySidAndCid(dbConnector, student.getId(), x).get(0).getDchandle() == 1) {
                //选课表没有，退课表必须是批准
                courses_cid.add(x);
            }
        }

        Vector<Vector<Object>> courseCol = new Vector<>();
        for (int cid : courses_cid) {
            Vector<Object> courseRow = new Vector<>();
            courseRow.add(courseService.CheckById(dbConnector, cid).get(0).getCname());
            courseRow.add(cid);
            courseRow.add(courseService.CheckById(dbConnector, cid).get(0).getCtime());
            courseRow.add(courseService.CheckById(dbConnector, cid).get(0).getCroom());
            courseRow.add(courseService.CheckById(dbConnector, cid).get(0).getCcredit());
            courseRow.add(courseService.CheckById(dbConnector, cid).get(0).getCkclb());
            courseRow.add(teacherService.CheckById(dbConnector, courseService.CheckById(dbConnector, cid).get(0).getCteacherid()).get(0).getName());
            courseCol.add(courseRow);
        }
        System.out.println(courses);
        return courseCol;

    }

    public Vector<Vector<Object>> getSelectedByTeacherVectorForStudent(DbConnector dbConnector, Student student, String tname) {
        CourseService courseService = new CourseService();
        TeacherService teacherService = new TeacherService();
        ArrayList<Course> courses = courseService.CheckByTeacherNameRough(dbConnector, tname);

        ArrayList<Integer> allCourses_cid = new ArrayList<>();
        for (Course course : courses) {
            allCourses_cid.add(course.getCid());
        }

        ChooseCourseService chooseCourseService = new ChooseCourseService();
        DropCourseService dropCourseService = new DropCourseService();

        ArrayList<ChooseCourse> chosenCourses = chooseCourseService.CheckBySid(dbConnector, student.getId());

        //所有所选课程的id
        ArrayList<Integer> chosenCourses_cid = new ArrayList<>();
        for (ChooseCourse chooseCourse : chosenCourses) {
            chosenCourses_cid.add(chooseCourse.getCccid());
        }

        ArrayList<DropCourse> dropCourses = dropCourseService.CheckBySid(dbConnector, student.getId());

        //所有退课的id
        ArrayList<Integer> droppedCourses_cid = new ArrayList<>();
        for (DropCourse dropCourse : dropCourses) {
            droppedCourses_cid.add(dropCourse.getDccid());
        }

        //所有可选课程的id
        ArrayList<Integer> courses_cid = new ArrayList<>();
        for (int x : allCourses_cid) {
            //选课表和退课表都没有
            if (!chosenCourses_cid.contains(x) && !droppedCourses_cid.contains(x)) {
                courses_cid.add(x);
            } else if (!chosenCourses_cid.contains(x) && dropCourseService.CheckBySidAndCid(dbConnector, student.getId(), x).get(0).getDchandle() == 1) {
                //选课表没有，退课表必须是批准
                courses_cid.add(x);
            }
        }

        Vector<Vector<Object>> courseCol = new Vector<>();
        for (int cid : courses_cid) {
            Vector<Object> courseRow = new Vector<>();
            courseRow.add(courseService.CheckById(dbConnector, cid).get(0).getCname());
            courseRow.add(cid);
            courseRow.add(courseService.CheckById(dbConnector, cid).get(0).getCtime());
            courseRow.add(courseService.CheckById(dbConnector, cid).get(0).getCroom());
            courseRow.add(courseService.CheckById(dbConnector, cid).get(0).getCcredit());
            courseRow.add(courseService.CheckById(dbConnector, cid).get(0).getCkclb());
            courseRow.add(teacherService.CheckById(dbConnector, courseService.CheckById(dbConnector, cid).get(0).getCteacherid()).get(0).getName());
            courseCol.add(courseRow);
        }
        System.out.println(courses);
        return courseCol;

    }

    public boolean ifIdExist(DbConnector dbConnector, int id) {
        if (Integer.toString(id).length() != 4)
            return false;
        else {
            CourseDaoImpl courseDao = new CourseDaoImpl();
            ArrayList<Course> courses = courseDao.Select(dbConnector.getConnection());
            for (Course course : courses) {
                if (course.getCid() == id)
                    return true;
            }
            return false;
        }

    }

    // 获取所有课程
    public ArrayList<Course> selectAllCourses(DbConnector dbConnector) {
        CourseDaoImpl courseDao = new CourseDaoImpl();

        return courseDao.Select(dbConnector.getConnection());
    }

    public Vector<Vector<Object>> CheckByIdRough_Vector(DbConnector dbConnector, int tid) {
        CourseDaoImpl courseDao = new CourseDaoImpl();
        ArrayList<Course> myAllCourses = courseDao.SelectByIdRough(dbConnector.getConnection(), tid);
        Vector<Vector<Object>> courseCol = new Vector<>();
        for (Course course : myAllCourses) {
            Vector<Object> courseRow = new Vector<>();
            courseRow.add(course.getCid());
            courseRow.add(course.getCname());
            courseRow.add(course.getCdepartment());
            courseRow.add(course.getCcredit());
            courseRow.add(course.getCkclb());
            courseRow.add(course.getCroom());
            courseRow.add(course.getCtime());
            courseRow.add(course.getCsigned_num());
            courseRow.add(course.getCmax_num());
            courseCol.add(courseRow);
        }
        return courseCol;
    }

    public Vector<Vector<Object>> CheckByNameRough_Vector(DbConnector dbConnector, String name) {
        CourseDaoImpl courseDao = new CourseDaoImpl();
        ArrayList<Course> myAllCourses = courseDao.SelectByNameRough(dbConnector.getConnection(), name);
        Vector<Vector<Object>> courseCol = new Vector<>();
        for (Course course : myAllCourses) {
            Vector<Object> courseRow = new Vector<>();
            courseRow.add(course.getCid());
            courseRow.add(course.getCname());
            courseRow.add(course.getCdepartment());
            courseRow.add(course.getCcredit());
            courseRow.add(course.getCkclb());
            courseRow.add(course.getCroom());
            courseRow.add(course.getCtime());
            courseRow.add(course.getCsigned_num());
            courseRow.add(course.getCmax_num());
            courseCol.add(courseRow);
        }
        return courseCol;
    }

    public Vector<Vector<Object>> CheckByCollegeRough_Vector(DbConnector dbConnector, String co) {
        CourseDaoImpl courseDao = new CourseDaoImpl();
        ArrayList<Course> myAllCourses = courseDao.SelectedByDepartmentRough(dbConnector.getConnection(), co);
        Vector<Vector<Object>> courseCol = new Vector<>();
        for (Course course : myAllCourses) {
            Vector<Object> courseRow = new Vector<>();
            courseRow.add(course.getCid());
            courseRow.add(course.getCname());
            courseRow.add(course.getCdepartment());
            courseRow.add(course.getCcredit());
            courseRow.add(course.getCkclb());
            courseRow.add(course.getCroom());
            courseRow.add(course.getCtime());
            courseRow.add(course.getCsigned_num());
            courseRow.add(course.getCmax_num());
            courseCol.add(courseRow);
        }
        return courseCol;
    }

    public Vector<Vector<Object>> CheckByKclb_Vector(DbConnector dbConnector, String k) {
        CourseDaoImpl courseDao = new CourseDaoImpl();
        ArrayList<Course> myAllCourses = courseDao.SelectedByKclbRough(dbConnector.getConnection(), k);
        Vector<Vector<Object>> courseCol = new Vector<>();
        for (Course course : myAllCourses) {
            Vector<Object> courseRow = new Vector<>();
            courseRow.add(course.getCid());
            courseRow.add(course.getCname());
            courseRow.add(course.getCdepartment());
            courseRow.add(course.getCcredit());
            courseRow.add(course.getCkclb());
            courseRow.add(course.getCroom());
            courseRow.add(course.getCtime());
            courseRow.add(course.getCsigned_num());
            courseRow.add(course.getCmax_num());
            courseCol.add(courseRow);
        }
        return courseCol;
    }

    public Vector<Vector<Object>> CheckByTnameRough_Vector(DbConnector dbConnector, String tn) {
        CourseDaoImpl courseDao = new CourseDaoImpl();
        ArrayList<Course> myAllCourses = courseDao.SelectedByTNameRough(dbConnector.getConnection(), tn);
        Vector<Vector<Object>> courseCol = new Vector<>();
        //你好
        for (Course course : myAllCourses) {
            Vector<Object> courseRow = new Vector<>();
            courseRow.add(course.getCid());
            courseRow.add(course.getCname());
            courseRow.add(course.getCdepartment());
            courseRow.add(course.getCcredit());
            courseRow.add(course.getCkclb());
            courseRow.add(course.getTname());
            courseRow.add(course.getCroom());
            courseRow.add(course.getCtime());
            courseRow.add(course.getCsigned_num());
            courseRow.add(course.getCmax_num());
            courseCol.add(courseRow);
        }
        return courseCol;
    }

}
