package newjwglxt.jwglxt.service.idx2;

import newjwglxt.jwglxt.dao.idx2.ChooseCourseDaoImpl;
import newjwglxt.jwglxt.entity.ChooseCourse;
import newjwglxt.jwglxt.entity.Course;
import newjwglxt.jwglxt.entity.DropCourse;
import newjwglxt.jwglxt.entity.Student;
import newjwglxt.jwglxt.service.idx1.CourseService;
import newjwglxt.jwglxt.service.idx1.StudentService;
import newjwglxt.jwglxt.service.idx1.TeacherService;
import newjwglxt.jwglxt.util.DbConnector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class ChooseCourseService implements Service_idx2<ChooseCourse> {
    @Override
    public void Add(DbConnector dbConnector, ChooseCourse chooseCourse) {
        ChooseCourseDaoImpl chooseCourseDao = new ChooseCourseDaoImpl();
        chooseCourseDao.Insert(dbConnector.getConnection(), chooseCourse);
    }

    @Override
    public void Delete(DbConnector dbConnector, ChooseCourse chooseCourse) {
        ChooseCourseDaoImpl chooseCourseDao = new ChooseCourseDaoImpl();
        chooseCourseDao.Delete(dbConnector.getConnection(), chooseCourse);
    }

    @Override
    public void Update(DbConnector dbConnector, ChooseCourse chooseCourse) {
        ChooseCourseDaoImpl chooseCourseDao = new ChooseCourseDaoImpl();
        chooseCourseDao.Update(dbConnector.getConnection(), chooseCourse);
    }

    @Override
    public ArrayList<ChooseCourse> CheckBySid(DbConnector dbConnector, int sid) {
        ChooseCourseDaoImpl chooseCourseDao = new ChooseCourseDaoImpl();
        return chooseCourseDao.SelectBySid(dbConnector.getConnection(), sid);
    }

    @Override
    public ArrayList<ChooseCourse> CheckByCid(DbConnector dbConnector, int cid) {
        ChooseCourseDaoImpl chooseCourseDao = new ChooseCourseDaoImpl();
        return chooseCourseDao.SelectByCid(dbConnector.getConnection(), cid);
    }

    // 为studentPanel的查询自己已选课程功能返回数据库中该学生已选的课程信息
    public Vector<Vector<Object>> getCourseVector(DbConnector dbConnector, Student student) {
        ChooseCourseService chooseCourseService = new ChooseCourseService();
        TeacherService teacherService = new TeacherService();
        CourseService courseService = new CourseService();
        DropCourseService dropCourseService = new DropCourseService();

        ArrayList<ChooseCourse> chooseCourses = chooseCourseService.CheckBySid(dbConnector, student.getId());
        ArrayList<DropCourse> dropCourses = dropCourseService.CheckBySid(dbConnector, student.getId());
        Vector<Vector<Object>> courseCol = new Vector<>();

        for (DropCourse dropCourse : dropCourses) {
            //退课被驳回
            if (dropCourse.getDchandle() == -1) {
                Vector<Object> courseRowDefeatDrop = new Vector<>();
                courseRowDefeatDrop.add(courseService.CheckById(dbConnector, dropCourse.getDccid()).get(0).getCname());
                courseRowDefeatDrop.add(dropCourse.getDccid());
                courseRowDefeatDrop.add(courseService.CheckById(dbConnector, dropCourse.getDccid()).get(0).getCtime());
                courseRowDefeatDrop.add(courseService.CheckById(dbConnector, dropCourse.getDccid()).get(0).getCroom());
                courseRowDefeatDrop.add(courseService.CheckById(dbConnector, dropCourse.getDccid()).get(0).getCcredit());
                courseRowDefeatDrop.add(courseService.CheckById(dbConnector, dropCourse.getDccid()).get(0).getCkclb());
                courseRowDefeatDrop.add(teacherService.CheckById(dbConnector, courseService.CheckById(dbConnector, dropCourse.getDccid()).get(0).getCteacherid()).get(0).getName());
                courseCol.add(courseRowDefeatDrop);
            }
        }

        for (ChooseCourse chooseCourse : chooseCourses) {
            Vector<Object> courseRow = new Vector<>();
            courseRow.add(courseService.CheckById(dbConnector, chooseCourse.getCccid()).get(0).getCname());
            courseRow.add(chooseCourse.getCccid());
            courseRow.add(courseService.CheckById(dbConnector, chooseCourse.getCccid()).get(0).getCtime());
            courseRow.add(courseService.CheckById(dbConnector, chooseCourse.getCccid()).get(0).getCroom());
            courseRow.add(courseService.CheckById(dbConnector, chooseCourse.getCccid()).get(0).getCcredit());
            courseRow.add(courseService.CheckById(dbConnector, chooseCourse.getCccid()).get(0).getCkclb());
            courseRow.add(teacherService.CheckById(dbConnector, courseService.CheckById(dbConnector, chooseCourse.getCccid()).get(0).getCteacherid()).get(0).getName());
            courseCol.add(courseRow);
        }
        return courseCol;
    }

    public Vector<Vector<Object>> getScoreVector(DbConnector dbConnector, Student student) {
        ChooseCourseDaoImpl chooseCourseDao = new ChooseCourseDaoImpl();
        CourseService courseService = new CourseService();
        ArrayList<ChooseCourse> chooseCourses = chooseCourseDao.Select(dbConnector.getConnection(), student.getId());
        Vector<Vector<Object>> score = new Vector<>();
        for (ChooseCourse chooseCourse : chooseCourses) {
            Vector<Object> scoreRow = new Vector<>();
            scoreRow.add(chooseCourse.getCccid());
            scoreRow.add(courseService.CheckById(dbConnector, chooseCourse.getCccid()).get(0).getCname());
            scoreRow.add(courseService.CheckById(dbConnector, chooseCourse.getCccid()).get(0).getCkclb());
            scoreRow.add(chooseCourse.getCcscore());
            scoreRow.add(courseService.CheckById(dbConnector, chooseCourse.getCccid()).get(0).getCcredit());
            scoreRow.add(chooseCourse.getCcgpa());
            score.add(scoreRow);
        }
        return score;
    }

    // 为teacherPanel的成绩管理功能返回数据库中的sid, sname, score信息
    public Vector<Vector<Object>> getXueshengchengjibiaoVector(DbConnector dbConnector, int courseID) {
        ChooseCourseService chooseCourseService = new ChooseCourseService();
        StudentService studentService = new StudentService();
        // sid_and_score装有选择该课的学生的学号和成绩信息
        ArrayList<ChooseCourse> sid_and_score = chooseCourseService.CheckByCid(dbConnector, courseID);
        // snameArrayList装有选择该课的学生的姓名信息
        ArrayList<Student> snameArrayList = new ArrayList<>();
        for (ChooseCourse chooseCourse : sid_and_score) {
            ArrayList<Student> sname = studentService.CheckById(dbConnector, chooseCourse.getCcsid());
            snameArrayList.add(sname.get(0));
        }
        Vector<Vector<Object>> sid_sname_score_COL = new Vector<>();
        for (int i = 0; i < sid_and_score.size(); i++) {
            Vector<Object> row = new Vector<>();
            row.add(sid_and_score.get(i).getCcsid());
            row.add(snameArrayList.get(i).getName());
            row.add(sid_and_score.get(i).getCcscore());
            sid_sname_score_COL.add(row);
        }
        return sid_sname_score_COL;
    }

    public ArrayList<ChooseCourse> CheckBySidAndCid(DbConnector dbConnector, int sid, int cid) {
        ChooseCourseDaoImpl chooseCourseDao = new ChooseCourseDaoImpl();
        return chooseCourseDao.SelectBySidAndCid(dbConnector.getConnection(), sid, cid);
    }

    public boolean judgeTime(DbConnector dbConnector, int course1_id, int course2_id) {
        CourseService courseService = new CourseService();
        Course course1 = courseService.CheckById(dbConnector, course1_id).get(0);
        Course course2 = courseService.CheckById(dbConnector, course2_id).get(0);
        // 判断时间是否冲突

        //所有课的开始周、结束周；所选课的开始周、结束周
        int course1BeginWeek = new Integer(String.valueOf(course1.getCtime().charAt(0)) + course1.getCtime().charAt(1));
        course1BeginWeek = course1BeginWeek - 1;
        int course1EndWeek = new Integer(String.valueOf(course1.getCtime().charAt(2)) + course1.getCtime().charAt(3));
        course1EndWeek = course1EndWeek - 1;

        int course2BeginWeek = new Integer(String.valueOf(course2.getCtime().charAt(0)) + course2.getCtime().charAt(1));
        course2BeginWeek = course2BeginWeek - 1;
        int course2EndWeek = new Integer(String.valueOf(course2.getCtime().charAt(2)) + course2.getCtime().charAt(3));
        course2EndWeek = course2EndWeek - 1;

        //所有课的日期、开始时间、结束时间；所选课的日期、开始时间、结束时间
        char course1Weekday = course1.getCtime().charAt(4);
        char course2Weekday = course2.getCtime().charAt(4);

        int course1BeginTime = new Integer(String.valueOf(course1.getCtime().charAt(5)) + course1.getCtime().charAt(6));
        course1BeginTime = course1BeginTime - 1;
        int course1EndTime = new Integer(String.valueOf(course1.getCtime().charAt(7)) + course1.getCtime().charAt(8));
        course1EndTime = course1EndTime - 1;

        int course2BeginTime = new Integer(String.valueOf(course2.getCtime().charAt(5)) + course2.getCtime().charAt(6));
        course2BeginTime = course2BeginTime - 1;
        int course2EndTime = new Integer(String.valueOf(course2.getCtime().charAt(7)) + course2.getCtime().charAt(8));
        course2EndTime = course2EndTime - 1;


        int[] course1WeekList = new int[20];
        int[] course2WeekList = new int[20];

        while (course1BeginWeek <= course1EndWeek) {
            course1WeekList[course1BeginWeek] = 1;
            course1BeginWeek++;
        }

        while (course2BeginWeek <= course2EndWeek) {
            course2WeekList[course2BeginWeek] = 1;
            course2BeginWeek++;
        }

        int i;
        for (i = 0; i < 20; i++) {
            if (course1WeekList[i] + course2WeekList[i] == 2) {
                break;
            }
            if (course1WeekList[i] + course2WeekList[i] < 2) {
                if (i == 19) {
                    return true;
                }
            }
        }

        //没到20往下判断,星期几是否冲突
        if (course1Weekday != course2Weekday) {
            return true;
        }

        int[] course1DayList = new int[12];
        int[] course2DayList = new int[12];

        while (course1BeginTime <= course1EndTime) {
            course1DayList[course1BeginTime] = 1;
            course1BeginTime++;
        }

        while (course2BeginTime <= course2EndTime) {
            course2DayList[course2BeginTime] = 1;
            course2BeginTime++;
        }

        int j;
        for (j = 0; j < 12; j++) {
            if (course1DayList[j] + course2DayList[j] == 2) {
                return false;
            }
            if (course1DayList[j] + course2DayList[j] < 2) {
                if (i == 11) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean judgeCourse (DbConnector dbConnector, int sid, int selected_cid) {
        CourseService courseService = new CourseService();
        Course course1 = courseService.CheckById(dbConnector, selected_cid).get(0);

        ChooseCourseService chooseCourseService = new ChooseCourseService();
        ArrayList<ChooseCourse> chooseCourses = chooseCourseService.CheckBySid(dbConnector, sid);

        for (ChooseCourse chooseCourse : chooseCourses) {
            Course course2 = courseService.CheckById(dbConnector, chooseCourse.getCccid()).get(0);
            if (!judgeTime(dbConnector, course1.getCid(), course2.getCid())) {
                return false;
            }
        }
        return true;
    }
}
