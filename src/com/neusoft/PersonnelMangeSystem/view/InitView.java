package com.neusoft.PersonnelMangeSystem.view;

import com.neusoft.PersonnelMangeSystem.util.DbHelps;
import com.neusoft.PersonnelMangeSystem.util.ViewPrints;

import java.sql.Connection;

/**
 * @author 火羽白
 * @date 2020/9/28
 */
public class InitView {
    private static final int CONNECTION_MAX_TIMES = 5;
    private Connection connection = null;

    public InitView() {
        init();
    }

    private void init() {
        for (int i = 0; i < CONNECTION_MAX_TIMES; i++) {
            connection = DbHelps.getConnection();
            if (connection != null) {
                break;
            }
        }
        if (connection == null) {
            ViewPrints.init();
            ViewPrints.printError(ViewPrints.CONNECTION_ERROR);
            ViewPrints.exit();
            return;
        }
        ViewPrints.appendHeader();
        ViewPrints.append("\t\t欢迎使用人事管理系统");
        ViewPrints.appendFooter();
        new LoginView();
    }
}
