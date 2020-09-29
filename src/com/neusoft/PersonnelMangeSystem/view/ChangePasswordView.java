package com.neusoft.PersonnelMangeSystem.view;

import com.neusoft.PersonnelMangeSystem.dao.impl.UserDaoImpl;
import com.neusoft.PersonnelMangeSystem.util.ViewPrints;
import com.neusoft.PersonnelMangeSystem.util.ViewScanners;

/**
 * @author 火羽白
 * @date 2020/9/28
 */
public class ChangePasswordView {
    public static final int MIN_LENGTH_PASSWORD = 6;
    private static final int SHORT_PASSWORD = 0;
    private static final int DIFFERENT_PASSWORD = 1;

    public ChangePasswordView() {
        init();
    }

    private void init() {
        judgePassword();
    }

    private void judgePassword() {
        ViewPrints.init();
        ViewPrints.append("请输入当前用户密码:");
        ViewPrints.print();
        String input = ViewScanners.nextString();
        if (LoginView.nowUser.getEmpPassword().equals(input)) {
            changePassword();
        } else {
            reJudgePassword();
        }
    }

    private void reJudgePassword() {
        ViewPrints.init();
        ViewPrints.append("输入的密码与当前用户密码不一致，是否重试?(Y/N)");
        ViewPrints.print();
        String input = ViewScanners.nextString();
        if (ViewScanners.YES.equalsIgnoreCase(input)) {
            judgePassword();
        } else if (ViewScanners.NO.equalsIgnoreCase(input)) {
            ViewPrints.back();
        } else {
            ViewPrints.printError(ViewPrints.INPUT_ERROR);
            reJudgePassword();
        }
    }

    private void changePassword() {
        ViewPrints.append("请输入更改后的密码:(输入exit退出修改)");
        ViewPrints.print();
        String newPassword = ViewScanners.nextString();
        if (newPassword.equalsIgnoreCase(ViewScanners.EXIT)) {
            ViewPrints.back();
            return;
        }
        if (newPassword.length() < MIN_LENGTH_PASSWORD) {
            reChangePassword(SHORT_PASSWORD);
        } else {
            setNewPassword(newPassword);
        }
    }

    private void reChangePassword(int flag) {
        ViewPrints.init();
        switch (flag) {
            case SHORT_PASSWORD:
                ViewPrints.append("密码长度不得少于6位,请重新输入:");
                break;
            case DIFFERENT_PASSWORD:
                ViewPrints.append("两次输入的密码不一致,请重新输入:");
                break;
            default:
        }
        ViewPrints.print();
        changePassword();
    }

    private void setNewPassword(String newPassword) {
        ViewPrints.append("请再次输入更改后的密码:");
        ViewPrints.print();
        String input = ViewScanners.nextString();
        if (newPassword.equals(input)) {
            if (new UserDaoImpl().changePassword(LoginView.nowUser, newPassword)) {
                LoginView.nowUser.setEmpPassword(newPassword);
                changeSuccess();
            } else {
                retry();
            }
        } else {
            reChangePassword(DIFFERENT_PASSWORD);
        }
    }

    private void changeSuccess() {
        ViewPrints.init();
        ViewPrints.append("密码修改成功");
        ViewPrints.print();
        ViewPrints.back();
    }

    private void retry() {
        ViewPrints.init();
        ViewPrints.append("修改密码失败,是否重试?(Y/N)");
        ViewPrints.print();
        String input = ViewScanners.nextString();
        if (ViewScanners.YES.equalsIgnoreCase(input)) {
            changePassword();
        } else if (ViewScanners.NO.equalsIgnoreCase(input)) {
            ViewPrints.back();
        } else {
            ViewPrints.printError(ViewPrints.INPUT_ERROR);
            retry();
        }
    }
}
