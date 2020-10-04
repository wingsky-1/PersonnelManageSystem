package com.neusoft.PersonnelMangeSystem.entity;

import com.neusoft.PersonnelMangeSystem.util.ViewScanners;

import java.util.Calendar;
import java.util.Date;

/**
 * @author 火羽白
 * @date 2020/9/28
 */
public class Attendance {
    private Date todayDate;
    public static final int ONE_DAY_TIME = 86400;
    public static final int HALF_DAY_TIME = 43200;
    public static final int GO_TO_WORK = 1;
    public static final int OFF_WORK = 2;
    private int attendanceNo;
    private int empNo;
    private Date attendanceDate;
    private int type;

    public Attendance() {
        todayDate = todayDate();
        attendanceNo = 0;
        empNo = 0;
        attendanceDate = new Date();
        type = 0;
    }

    public Attendance(int empNo) {
        this();
        this.empNo = empNo;
        if (attendanceDate.getTime() - todayDate.getTime() < HALF_DAY_TIME) {
            type = GO_TO_WORK;
        } else {
            type = OFF_WORK;
        }
    }

    public Attendance(int attendanceNo, int empNo, Date attendanceDate, int type) {
        this.attendanceNo = attendanceNo;
        this.empNo = empNo;
        this.attendanceDate = attendanceDate;
        this.type = type;
    }

    private Date todayDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    public int getAttendanceNo() {
        return attendanceNo;
    }

    public void setAttendanceNo(int attendanceNo) {
        this.attendanceNo = attendanceNo;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Date getTodayDate() {
        return todayDate;
    }

    public String getTodayDateString(){
        return ViewScanners.SIMPLE_DATE_FORMAT.format(todayDate).split(" ")[0];
    }

    public static String info() {
        return "attendanceNo" + "\t" + "empNo" + "\t\t" + "attendanceDate" + "\t\t\t" + "type";
    }

    @Override
    public String toString() {
        return attendanceNo + "\t\t\t\t" + empNo + "\t" + ViewScanners.SIMPLE_DATE_FORMAT.format(attendanceDate) + "\t\t" + (type == OFF_WORK ? "下班打卡" : "上班打卡");
    }
}
