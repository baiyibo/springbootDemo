/*
*
* SysPermission.java
* Copyright(C) 2017-2020 byb.hwh公司
* @date 2018-08-31
*/
package com.springbootdemo.byb.SysPermission.model;

public class SysPermission {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String permission;

    /**
     * 
     */
    private Integer roleId;

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
     * @return permission 
     */
    public String getPermission() {
        return permission;
    }

    /**
     * 
     * @param permission 
     */
    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    /**
     * 
     * @return role_id 
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 
     * @param roleId 
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}