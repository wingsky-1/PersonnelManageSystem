package com.neusoft.PersonnelMangeSystem.view;

import com.neusoft.PersonnelMangeSystem.util.ViewPrints;
import com.neusoft.PersonnelMangeSystem.util.ViewScanners;

/**
 * @author 火羽白
 * @date 2020/9/28
 */
public class MainView {
    private static final int GENERAL_INFORMATION = 1;
    private static final int WORK_INFORMATION = 2;
    private static final int TODAY_ATTENDANCE = 3;
    private static final int ALL_ATTENDANCE = 4;
    private static final int CHANGE_PASSWORD = 9;
    private static final int EXIT = 0;

    public MainView() {
        init();
    }

    private void init() {
        ViewPrints.init();
        ViewPrints.append("请输入功能相对应的数字进行操作");
        ViewPrints.append(GENERAL_INFORMATION + ".查看基本信息");
        ViewPrints.append(WORK_INFORMATION + ".查看工作信息");
        ViewPrints.append(TODAY_ATTENDANCE + ".今日考勤打卡");
        ViewPrints.append(ALL_ATTENDANCE + ".全部考勤信息");
        ViewPrints.append(CHANGE_PASSWORD + ".修改密码");
        ViewPrints.append(EXIT + ".退出系统");
        ViewPrints.print();
        judgeInput();
    }

    private void judgeInput() {
        int input = ViewScanners.nextInt();
        if (input == ViewScanners.ERROR_INT) {
            judgeInput();
            return;
        }
        switch (input) {
            case GENERAL_INFORMATION:
                new GeneralInformationView();
                init();
                break;
            case WORK_INFORMATION:
                new WorkInformationView();
                init();
                break;
            case TODAY_ATTENDANCE:
                new TodayAttendanceView();
                init();
                break;
            case ALL_ATTENDANCE:
                new AllAttendanceView();
                init();
                break;
            case CHANGE_PASSWORD:
                new ChangePasswordView();
                init();
                break;
            case EXIT:
                ViewPrints.exit();
                break;
            default:
                ViewPrints.printError(ViewPrints.INPUT_ERROR);
                judgeInput();
        }
    }
}
