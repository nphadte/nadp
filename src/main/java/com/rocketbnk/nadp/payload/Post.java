package com.rocketbnk.nadp.payload;

import java.time.LocalDateTime;

public class Post {

    private LocalDateTime  time;

    private Integer        userid;

    private String         firstname;

    private String         lastname;

    private String         text_note;

    public Post(LocalDateTime time, Integer userid, String firstname, String lastname, String text_note) {
        this.time = time;
        this.userid = userid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.text_note = text_note;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getText_note() {
        return text_note;
    }

    public void setText_note(String text_note) {
        this.text_note = text_note;
    }
}
