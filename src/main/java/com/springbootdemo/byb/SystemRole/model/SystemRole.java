/*
*
* SystemRole.java
* Copyright(C) 2017-2020 byb.hwh公司
* @date 2018-08-31
*/
package com.springbootdemo.byb.SystemRole.model;

public class SystemRole {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String roleName;

    /**
     * 
     */
    private Integer userId;

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
     * @return role_name 
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 
     * @param roleName 
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * 
     * @return user_id 
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 
     * @param userId 
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}