package com.neusoft.PersonnelMangeSystem.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author 火羽白
 * @date 2020/9/28
 */
public class ViewScanners {
    private static final Scanner IN = new Scanner(System.in);
    public static final String YES = "Y";
    public static final String NO = "N";
    public static final String EXIT = "EXIT";
    public static final int ERROR_INT = Integer.MIN_VALUE;
    public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-dd-MM HH:mm:ss");

    public static String nextString() {
        return IN.nextLine();
    }

    public static int nextInt() {
        int get = ERROR_INT;
        try {
            get = Integer.parseInt(IN.nextLine());
        } catch (NumberFormatException e) {
            ViewPrints.printError(ViewPrints.INPUT_ERROR);
        }
        return get;
    }

    public static Date nextDate() {
        java.util.Date get = null;
        try {
            get = SIMPLE_DATE_FORMAT.parse(IN.nextLine());
        } catch (ParseException e) {
            e.printStackTrace();
            ViewPrints.printError(ViewPrints.INPUT_ERROR);
        }
        return get;
    }

    public static void main(String[] args) {
        System.out.println(nextDate());
    }
}
