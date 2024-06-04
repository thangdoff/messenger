package com.example.messenger2.UserChat;

public class User {
    private int recourceId;
    private String userName;

    public User(int recourceId, String userName) {
        this.recourceId = recourceId;
        this.userName = userName;
    }

    public int getRecourceId() {
        return recourceId;
    }

    public void setRecourceId(int recourceId) {
        this.recourceId = recourceId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
