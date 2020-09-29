package com.neusoft.PersonnelMangeSystem.dao;

import com.neusoft.PersonnelMangeSystem.entity.User;

/**
 * @author 火羽白
 * @date 2020/9/27
 */
public interface UserDao {
    /**
     * 在数据库用户表中查找存不存在于user对应的员工编号和密码
     * 
     * @param user
     *            被查找的员工账号和密码
     * @return 是否找到对应的员工账号与密码
     */
    boolean searchUser(User user);

    /**
     * 修改当前用户的密码
     * 
     * @param nowUser
     *            当前用户
     * @param newPassword
     *            修改后的密码
     * @return 密码修改是否成功
     */
    boolean changePassword(User nowUser, String newPassword);
}
