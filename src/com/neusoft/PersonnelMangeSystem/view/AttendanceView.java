package com.neusoft.PersonnelMangeSystem.view;

import com.neusoft.PersonnelMangeSystem.dao.impl.AttendanceDaoImpl;
import com.neusoft.PersonnelMangeSystem.entity.Attendance;
import com.neusoft.PersonnelMangeSystem.util.ViewPrints;
import com.neusoft.PersonnelMangeSystem.util.ViewScanners;

import java.util.Date;
import java.util.LinkedList;

/**
 * @author 火羽白
 * @date 2020/9/28
 */
public class AttendanceView {
    private static final int ATTENDANCES_MAX_TIMES = 2;
    private LinkedList<Attendance> attendances;
    private final Attendance attendance;

    public AttendanceView() {
        attendance = new Attendance(LoginView.nowUser.getEmoNo());
        init();
    }

    private void init() {
        attendances = new AttendanceDaoImpl().getTodayAttendanceByEmpNo(attendance);
        if (attendances.size() == ATTENDANCES_MAX_TIMES) {
            ViewPrints.appendHeader();
            ViewPrints.append(attendance.info());
            ViewPrints.append(attendances.getFirst().toString());
            ViewPrints.append(attendances.getLast().toString());
            ViewPrints.appendFooter();
            completeAttendance();
            return;
        }
        if (!attendances.isEmpty()) {
            ViewPrints.appendHeader();
            ViewPrints.append(attendance.info());
            ViewPrints.append(attendances.getFirst().toString());
            ViewPrints.appendFooter();
            judgeToAttendance();
        } else {
            toAttendance();
        }
    }

    private void completeAttendance() {
        ViewPrints.init();
        ViewPrints.append("已完成打卡,输入任意数据返回上一级");
        ViewPrints.print();
        ViewScanners.nextString();
        ViewPrints.back();
    }
    private void unCompleteAttendance() {
        ViewPrints.init();
        ViewPrints.append("打卡失败,请稍后再来,输入任意数据返回上一级");
        ViewPrints.print();
        ViewScanners.nextString();
        ViewPrints.back();
    }

    private void toAttendance() {
        ViewPrints.init();
        ViewPrints.append("输入任意数据进行打卡");
        ViewPrints.print();
        ViewScanners.nextString();
        attendance.setAttendanceDate(new Date());
        if(new AttendanceDaoImpl().toAttendance(attendance)){
            init();
        }else{
            unCompleteAttendance();
        }
    }

    private void judgeToAttendance() {
        if(attendances.getFirst().getType() == Attendance.OFF_WORK){
            completeAttendance();
        }else if(attendances.getFirst().getType() == attendance.getType()){
            completeAttendance();
        }else{
            toAttendance();
        }
    }

}
