package com.example.hp.busproject;

/**
 * Created by HP on 15-Feb-17.
 */

public class DatabaseParent {
    private String StudentName;
    private String Studentclass;
    private String FatherName;
    private String PhoneNo;
    private String BusNo;
    public DatabaseParent(){}

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getStudentclass() {
        return Studentclass;
    }

    public void setStudentclass(String studentclass) {
        Studentclass = studentclass;
    }

    public String getFatherName() {
        return FatherName;
    }

    public void setFatherName(String fatherName) {
        FatherName = fatherName;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        PhoneNo = phoneNo;
    }

    public String getBusNo() {
        return BusNo;
    }

    public void setBusNo(String busNo) {
        BusNo = busNo;
    }
}
