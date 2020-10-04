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
    LinkedList<Attendance> getAllAttendanceByEmpNo(Attendance attendance);

    LinkedList<Attendance> getTodayAttendanceByEmpNo(Attendance attendance);

    boolean toAttendance(Attendance attendance);

    Attendance resultSetToAttendance(ResultSet resultSet) throws SQLException;
}
