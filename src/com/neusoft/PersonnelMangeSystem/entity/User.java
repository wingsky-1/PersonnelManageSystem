package com.neusoft.PersonnelMangeSystem.entity;

/**
 * @author 火羽白
 * @date 2020/9/27
 */
public class User {
    private int emoNo = 0;
    private String empPassword = null;
    private int empLevel = 0;

    public User() {

    }

    public User(int emoNo, String empPassword) {
        this.emoNo = emoNo;
        this.empPassword = empPassword;
    }

    public int getEmoNo() {
        return emoNo;
    }

    public void setEmoNo(int emoNo) {
        this.emoNo = emoNo;
    }

    public String getEmpPassword() {
        return empPassword;
    }

    public void setEmpPassword(String empPassword) {
        this.empPassword = empPassword;
    }

    public int getEmpLevel() {
        return empLevel;
    }

    public void setEmpLevel(int empLevel) {
        this.empLevel = empLevel;
    }
    public static String info(){
        return "emoNo" + "\t\t" + "empPassword" + "\t\t" + "empLevel";
    }

    @Override
    public String toString() {
        return emoNo +"\t" + empPassword +"\t" + empLevel;
    }
}
