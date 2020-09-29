package com.neusoft.PersonnelMangeSystem.dao.impl;

import com.neusoft.PersonnelMangeSystem.dao.AttendanceDao;
import com.neusoft.PersonnelMangeSystem.entity.Attendance;
import com.neusoft.PersonnelMangeSystem.util.DbHelps;

import java.sql.*;
import java.util.Date;
import java.util.LinkedList;

/**
 * @author 火羽白
 * @date 2020/9/28
 */
public class AttendanceDaoImpl implements AttendanceDao {

    @Override
    public LinkedList<Attendance> getAttendanceByEmpNo(Attendance attendance) {
        return null;
    }

    @Override
    public LinkedList<Attendance> getTodayAttendanceByEmpNo(Attendance attendance) {
        LinkedList<Attendance> res = new LinkedList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DbHelps.getConnection();
            if (connection != null) {
                String sql =
                    "select ATTENDANCENO, EMPNO, ATTENDANCEDATE, TYPE from ATTENDANCE where EMPNO = ? and to_char(ATTENDANCEDATE,'yyyy-dd-MM') = ?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, attendance.getEmpNo());
                preparedStatement.setString(2, attendance.getTodayDateString());
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    res.add(resultSetToAttendance(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbHelps.closeAll(connection, preparedStatement, resultSet);
        }
        return res;
    }

    @Override
    public boolean toAttendance(Attendance attendance) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int result = 0;
        try {
            connection = DbHelps.getConnection();
            if (connection != null) {
                String sql = "insert into ATTENDANCE values (SEQ_ATTENDANCE_ATTENDANCENO.nextval, ?, ?, ?)";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, attendance.getEmpNo());
                preparedStatement.setTimestamp(2, new Timestamp(attendance.getAttendanceDate().getTime()));
                preparedStatement.setInt(3, attendance.getType());
                result = preparedStatement.executeUpdate();
                if (result == 1) {
                    connection.commit();
                } else {
                    connection.rollback();
                }
            }
        } catch (SQLException ignored) {
        } finally {
            DbHelps.closeAll(connection, preparedStatement, null);
        }
        return result == 1;
    }

    @Override
    public Attendance resultSetToAttendance(ResultSet resultSet) throws SQLException {
        return new Attendance(resultSet.getInt(1), resultSet.getInt(2), new Date(resultSet.getTimestamp(3).getTime()),
            resultSet.getInt(4));
    }
}
