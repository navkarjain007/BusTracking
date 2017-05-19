package com.example.hp.busproject;

/**
 * Created by HP on 15-Feb-17.
 */

public class DatabaseGetterSetter {
    private String BusRouteNo;
    private String DriverName;
    private String PhoneNo;

    public String getDriverEmail() {
        return DriverEmail;
    }

    public void setDriverEmail(String driverEmail) {
        DriverEmail = driverEmail;
    }

    public String getDriverPassword() {
        return DriverPassword;
    }

    private String DriverEmail;
    private String DriverPassword;
    public DatabaseGetterSetter() {
    }


    public String getBusRouteNo() {
        return BusRouteNo;
    }

    public void setBusRouteNo(String busRouteNo) {
        BusRouteNo = busRouteNo;
    }

    public String getDriverName() {
        return DriverName;
    }

    public void setDriverName(String driverName) {
        DriverName = driverName;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        PhoneNo = phoneNo;
    }

    public void setDriverPassword(String password) { DriverPassword=password;
    }
}