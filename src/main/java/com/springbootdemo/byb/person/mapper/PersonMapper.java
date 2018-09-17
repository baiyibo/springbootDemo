/*
*
* personMapper.java
* Copyright(C) 2017-2020 fendo公司
* @date 2018-08-30
*/
package com.springbootdemo.byb.person.mapper;

import com.springbootdemo.byb.person.model.Person;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PersonMapper {
    /**
     *
     * @mbggenerated 2018-08-30
     */
    @Delete({
        "delete from Person",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2018-08-30
     */
    @Insert({
        "insert into Person (id, name, ",
        "age)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{age,jdbcType=INTEGER})"
    })
    int insert(Person record);

    /**
     *
     * @mbggenerated 2018-08-30
     */
    @Select({
        "select",
        "id, name, age",
        "from Person",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="age", property="age", jdbcType=JdbcType.INTEGER)
    })
    Person selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated 2018-08-30
     */
    @Select({
        "select",
        "id, name, age",
        "from Person",
        "order by age desc"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="age", property="age", jdbcType=JdbcType.INTEGER)
    })
    List<Person> selectAll();

    /**
     *
     * @mbggenerated 2018-08-30
     */
    @Update({
        "update Person",
        "set name = #{name,jdbcType=VARCHAR},",
          "age = #{age,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Person record);
}