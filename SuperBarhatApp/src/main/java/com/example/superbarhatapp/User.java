package com.example.superbarhatapp;


public class User {
    private String post;
    private String fio;
    private String login;
    private String password;
    private String last_log;
    private String typeLog;

    public User(String post, String fio, String login, String password, String last_log, String typeLog) {
        this.post = post;
        this.fio = fio;
        this.login = login;
        this.password = password;
        this.last_log = last_log;
        this.typeLog = typeLog;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLast_log() {
        return last_log;
    }

    public void setLast_log(String last_log) {
        this.last_log = last_log;
    }

    public String getTypeLog() {
        return typeLog;
    }

    public void setTypeLog(String typeLog) {
        this.typeLog = typeLog;
    }

}

