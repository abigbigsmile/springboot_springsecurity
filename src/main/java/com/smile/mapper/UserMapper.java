package com.smile.mapper;

import com.smile.model.User;
import org.springframework.stereotype.Component;

@Component(value = "userMapper")
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User findUserByName(String username);
}