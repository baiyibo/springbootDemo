/*
*
* SysPermissionMapper.java
* Copyright(C) 2017-2020 byb.hwh公司
* @date 2018-08-31
*/
package com.springbootdemo.byb.SysPermission.mapper;

import com.springbootdemo.byb.SysPermission.model.SysPermission;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface SysPermissionMapper {
    /**
     *
     * @mbggenerated 2018-08-31
     */
    @Delete({
        "delete from sys_permission",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2018-08-31
     */
    @Insert({
        "insert into sys_permission (id, permission, ",
        "role_id)",
        "values (#{id,jdbcType=INTEGER}, #{permission,jdbcType=VARCHAR}, ",
        "#{roleId,jdbcType=INTEGER})"
    })
    int insert(SysPermission record);

    /**
     *
     * @mbggenerated 2018-08-31
     */
    @Select({
        "select",
        "id, permission, role_id",
        "from sys_permission",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="permission", property="permission", jdbcType=JdbcType.VARCHAR),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER)
    })
    SysPermission selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2018-08-31
     */
    @Select({
        "select",
        "id, permission, role_id",
        "from sys_permission",
        "order by age desc,username asc"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="permission", property="permission", jdbcType=JdbcType.VARCHAR),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER)
    })
    List<SysPermission> selectAll();

    /**
     *
     * @mbggenerated 2018-08-31
     */
    @Update({
        "update sys_permission",
        "set permission = #{permission,jdbcType=VARCHAR},",
          "role_id = #{roleId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SysPermission record);
}