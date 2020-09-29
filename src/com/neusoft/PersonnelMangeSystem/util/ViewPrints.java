package com.neusoft.PersonnelMangeSystem.util;

/**
 * @author 火羽白
 * @date 2020/9/28
 */
public class ViewPrints {
    private static StringBuilder viewPrint = new StringBuilder();
    public static final int UNDEVELOPED_ERROR = 0;
    public static final int INPUT_ERROR = 1;
    public static final int CONNECTION_ERROR = 2;

    public static void init() {
        if (viewPrint.length() != 0) {
            viewPrint = new StringBuilder();
        }
    }

    public static void print() {
        System.out.print(viewPrint);
        init();
    }

    public static void append(String append) {
        viewPrint.append(append).append("\n");
    }

    public static void printError(int error) {
        init();
        switch (error) {
            case UNDEVELOPED_ERROR:
                append("功能开发中,请输入任意数据返回上一级目录！");
                break;
            case INPUT_ERROR:
                append("输入不合法!");
                break;
            case CONNECTION_ERROR:
                append("数据库连接失败，系统正在退出！");
                break;
            default:
                append("非法操作,请重新输入！");
        }
        print();
    }

    public static void appendHeader() {
        ViewPrints.init();
        append("==========================================================================================");
        append("");
    }

    public static void appendFooter() {
        append("");
        append("==========================================================================================");
        print();
    }

    public static void exit(){
        init();
        append("系统退出成功！");
        print();
    }

    public static void back(){
        init();
        append("返回上一级中");
        print();
    }
}
