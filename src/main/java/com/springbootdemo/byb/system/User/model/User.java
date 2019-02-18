/*
*
* User.java
* Copyright(C) 2017-2020 byb.hwh公司
* @date 2018-08-31
*/
package com.springbootdemo.byb.system.User.model;

public class User {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String password;

    /**
     * 
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return name 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name 
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 
     * @return password 
     */
    public String getPassword() {
        return password;
    }

    /**
     * 
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}