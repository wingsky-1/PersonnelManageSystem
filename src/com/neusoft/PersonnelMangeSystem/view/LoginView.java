package com.neusoft.PersonnelMangeSystem.view;

import com.neusoft.PersonnelMangeSystem.dao.impl.UserDaoImpl;
import com.neusoft.PersonnelMangeSystem.entity.User;
import com.neusoft.PersonnelMangeSystem.util.ViewPrints;
import com.neusoft.PersonnelMangeSystem.util.ViewScanners;

/**
 * @author 火羽白
 * @date 2020/9/28
 */
public class LoginView {
    static User nowUser = new User();

    public LoginView() {
        init();
    }

    private void init() {
        if (login()) {
            ViewPrints.init();
            ViewPrints.append("登录成功");
            ViewPrints.print();
            new MainView();
        } else {
            reLogin();
        }
    }

    private boolean login() {
        ViewPrints.init();
        ViewPrints.append("请输入员工编号:");
        ViewPrints.print();
        nowUser.setEmoNo(ViewScanners.nextInt());
        if (nowUser.getEmoNo() == ViewScanners.ERROR_INT) {
            return false;
        } else {
            ViewPrints.append("请输入员工密码:");
            ViewPrints.print();
            nowUser.setEmpPassword(ViewScanners.nextString());
            return new UserDaoImpl().searchUser(nowUser);
        }
    }

    private void reLogin() {
        ViewPrints.init();
        ViewPrints.append("用户名或密码错误,是否重新登录?(Y/N)");
        ViewPrints.print();
        String input = ViewScanners.nextString();
        if (input.equalsIgnoreCase(ViewScanners.YES)) {
            init();
        } else if (input.equalsIgnoreCase(ViewScanners.NO)) {
            ViewPrints.exit();
        } else {
            ViewPrints.printError(ViewPrints.INPUT_ERROR);
            reLogin();
        }
    }
}
