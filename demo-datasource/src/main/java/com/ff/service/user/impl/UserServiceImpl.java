package com.ff.service.user.impl;

import com.ff.dao.master.user.UserMapper;
import com.ff.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl<T> implements UserService<T>   {
    @Autowired
    private UserMapper<T> userMapper;

    @Override
    public T queryById(T t) {
        return userMapper.queryById(t);
    }
}
