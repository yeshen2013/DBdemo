package com.lyyexample.mapper;

import com.lyyexample.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by liuyangyang on 2018/4/15.
 */
@Mapper
@Component(value = "userMapper")
public interface UserMapper {

    @Select(value = {"select * from user where name = #{name}"})
    public User getUserInfo(String name);

    @Select(value = {"select * from user"})
    public List<User> getAll();

    @Insert(value = "insert into user (name,password,create_time,update_time) values(#{name},#{passWord},#{createTime},#{updateTime})")
    public boolean insert(@Param("name") String name, @Param("passWord") String passWord, @Param("createTime") Date createTime, @Param("updateTime") Date updateTime);

    @Update(value = "update user set name=#{name},password=#{passWord},update_time=#{updateTime} where id = #{id}")
    public boolean update(@Param("id") int id,@Param("name") String name, @Param("passWord") String passWord,@Param("updateTime") Date updateTime);

    @Delete(value = "delete from user where name = #{name}")
    public boolean deleteByName(@Param("name") String name);

    @Delete(value = "delete from user where id = #{id}")
    public boolean deleteById(@Param("id") int id);
}
