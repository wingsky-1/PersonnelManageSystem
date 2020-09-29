package com.neusoft.PersonnelMangeSystem.dao.impl;

import com.neusoft.PersonnelMangeSystem.dao.UserDao;
import com.neusoft.PersonnelMangeSystem.entity.User;
import com.neusoft.PersonnelMangeSystem.util.DbHelps;
import com.neusoft.PersonnelMangeSystem.view.ChangePasswordView;
import com.neusoft.PersonnelMangeSystem.view.LoginView;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 火羽白
 * @date 2020/9/27
 */
public class UserDaoImpl implements UserDao {

    @Override
    public boolean searchUser(User user) {
        if(user.getEmpPassword().length() < ChangePasswordView.MIN_LENGTH_PASSWORD){
            return false;
        }
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DbHelps.getConnection();
            if (connection == null) {
                return false;
            }
            String sql = "select EMPPASSWORD from USERINFO where EMPNO = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user.getEmoNo());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("EMPPASSWORD").equals(user.getEmpPassword());
            }
        } catch (SQLException ignored) {
        }finally {
            DbHelps.closeAll(connection,preparedStatement,resultSet);
        }
        return false;
    }

    @Override
    public boolean changePassword(User nowUser, String newPassword) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int result = 0;
        try {
            connection = DbHelps.getConnection();
            if (connection == null) {
                return false;
            }
            String sql = "update USERINFO set EMPPASSWORD = ? where EMPNO = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,newPassword);
            preparedStatement.setInt(2, nowUser.getEmoNo());
            result = preparedStatement.executeUpdate();
        } catch (SQLException ignored) {
        }finally {
            DbHelps.closeAll(connection,preparedStatement,null);
        }
        return result == 1;
    }
}
