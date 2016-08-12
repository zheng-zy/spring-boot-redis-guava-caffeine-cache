package com.cache.me.entity;

/**
 * @desc: 用户类
 * @author: zhengzy
 * @date: 2016/8/12
 */
public class User {
    private Long id;
    private String firstName;
    private String lastName;

    public User() {

    }

    public User(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
