package com.example.beans;

public class Action {
    String action;
    String status;

    public Action(String action, String status) {
        this.action = action;
        this.status = status;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
