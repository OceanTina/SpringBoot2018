package com.huawei.huawei.model;

public class User {
    private int ID;
    private String UserName;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", UserName='" + UserName + '\'' +
                '}';
    }
}
