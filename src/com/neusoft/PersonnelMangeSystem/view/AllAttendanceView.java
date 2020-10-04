package com.neusoft.PersonnelMangeSystem.view;

import com.neusoft.PersonnelMangeSystem.dao.impl.AttendanceDaoImpl;
import com.neusoft.PersonnelMangeSystem.entity.Attendance;
import com.neusoft.PersonnelMangeSystem.util.ViewPrints;
import com.neusoft.PersonnelMangeSystem.util.ViewScanners;

import java.util.LinkedList;

/**
 * @author 火羽白
 * @date 2020/9/30
 */
public class AllAttendanceView {
    private final Attendance attendance;

    public AllAttendanceView() {
        attendance = new Attendance(LoginView.nowUser.getEmoNo());
        init();
    }

    private void init() {
        ViewPrints.appendHeader();
        ViewPrints.append(Attendance.info());
        printAttendanceInfo();
        ViewPrints.appendFooter();
        ViewPrints.append("输入任意数据进行返回");
        ViewPrints.print();
        ViewScanners.nextString();
        ViewPrints.back();
    }

    private void printAttendanceInfo() {
        LinkedList<Attendance> attendances = new AttendanceDaoImpl().getAllAttendanceByEmpNo(attendance);
        for (Attendance a : attendances) {
            ViewPrints.append(a.toString());
        }
    }
}
