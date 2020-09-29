package com.neusoft.PersonnelMangeSystem.dao;

import com.neusoft.PersonnelMangeSystem.entity.Attendance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * @author 火羽白
 * @date 2020/9/28
 */
public interface AttendanceDao {
    public  LinkedList<Attendance> getAttendanceByEmpNo(Attendance attendance);
    public  LinkedList<Attendance> getTodayAttendanceByEmpNo(Attendance attendance);
    public boolean toAttendance(Attendance attendance);
    public Attendance resultSetToAttendance(ResultSet resultSet) throws SQLException;
}
