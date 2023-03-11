package com.jim.sprjfx.mapper;

import com.jim.sprjfx.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Jim
 * @Description
 * @createTime 2022年12月07日
 */
@Mapper
public interface UserMapper {

    // 配合 resources/mybatis/UserMapper.xml 向数据库中插入用户
    public int insertUser(User user);

    // resources/mybatis/UserMapper.xml 使用用户名查找用户
    public User getUserByUsername(String username);

}
