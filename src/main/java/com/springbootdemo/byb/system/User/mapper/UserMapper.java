/*
*
* UserMapper.java
* Copyright(C) 2017-2020 byb.hwh公司
* @date 2018-08-31
*/
package com.springbootdemo.byb.system.User.mapper;

import com.springbootdemo.byb.system.User.model.User;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    /**
     *
     * @mbggenerated 2018-08-31
     */
    @Delete({
        "delete from sys_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2018-08-31
     */
    @Insert({
        "insert into sys_user (id, name, ",
        "password)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR})"
    })
    int insert(User record);

    /**
     *
     * @mbggenerated 2018-08-31
     */
    @Select({
        "select",
        "id, name, password",
        "from sys_user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR)
    })
    User selectByPrimaryKey(Integer id);
    @Select({
            "select",
            "id, name, password",
            "from sys_user",
            "where id = #{name,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR)
    })
    User selectByName(String name);

    @Select({
            "select password from sys_user where name = #{username,jdbcType=VARCHAR}"
    })
    String getPassword(String username);
    /**
     *
     * @mbggenerated 2018-08-31
     */
    @Select({
        "select",
        "id, name, password",
        "from sys_user",
        "order by age desc,username asc"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR)
    })
    List<User> selectAll();

    /**
     *
     * @mbggenerated 2018-08-31
     */
    @Update({
        "update sys_user",
        "set name = #{name,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);
}