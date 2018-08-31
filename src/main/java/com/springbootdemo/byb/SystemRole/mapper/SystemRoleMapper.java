/*
*
* SystemRoleMapper.java
* Copyright(C) 2017-2020 byb.hwh公司
* @date 2018-08-31
*/
package com.springbootdemo.byb.SystemRole.mapper;

import com.springbootdemo.byb.SystemRole.model.SystemRole;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface SystemRoleMapper {
    /**
     *
     * @mbggenerated 2018-08-31
     */
    @Delete({
        "delete from sys_role",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2018-08-31
     */
    @Insert({
        "insert into sys_role (id, role_name, ",
        "user_id)",
        "values (#{id,jdbcType=INTEGER}, #{roleName,jdbcType=VARCHAR}, ",
        "#{userId,jdbcType=INTEGER})"
    })
    int insert(SystemRole record);

    /**
     *
     * @mbggenerated 2018-08-31
     */
    @Select({
        "select",
        "id, role_name, user_id",
        "from sys_role",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role_name", property="roleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER)
    })
    SystemRole selectByPrimaryKey(Integer id);

    @Select({
            "select",
            "role_name",
            "from sys_role",
            "where user_id = #{userid,jdbcType=INTEGER}"
    })
    String  getRoleByUserId(Integer userid);

    /**
     *
     * @mbggenerated 2018-08-31
     */
    @Select({
        "select",
        "id, role_name, user_id",
        "from sys_role",
        "order by age desc,username asc"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role_name", property="roleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER)
    })
    List<SystemRole> selectAll();

    /**
     *
     * @mbggenerated 2018-08-31
     */
    @Update({
        "update sys_role",
        "set role_name = #{roleName,jdbcType=VARCHAR},",
          "user_id = #{userId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SystemRole record);
}