package com.neusoft.PersonnelMangeSystem.util;

import java.sql.*;

/**
 * @author 火羽白
 * @date 2020/9/27
 */
public class DbHelps {
    private static final String DRIVER = "oracle.jdbc.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static final String USER = "personnel";
    private static final String PASSWORD = "wk030620";

    private static Connection connection = null;

    public static Connection getConnection() {
        openConnection();
        return connection;
    }

    private static void openConnection() {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
        } catch (ClassNotFoundException | SQLException ignored) {
            connection = null;
        }
    }

    public static boolean closeConnection(Connection connection){
        if(connection == null){
            return true;
        }else{
            try {
                connection.close();
                return true;
            } catch (SQLException e) {
                return false;
            }
        }
    }

    public static boolean closePreparedStatement(PreparedStatement preparedStatement){
        if(preparedStatement == null){
            return true;
        }else{
            try {
                preparedStatement.close();
                return true;
            } catch (SQLException e) {
                return false;
            }
        }
    }

    public static boolean closeResultSet(ResultSet resultSet){
        if(resultSet == null){
            return true;
        }else{
            try {
                resultSet.close();
                return true;
            } catch (SQLException e) {
                return false;
            }
        }
    }

    public static boolean closeAll(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet){
        return (closeResultSet(resultSet) && closePreparedStatement(preparedStatement) && closeConnection(connection));
    }
}
