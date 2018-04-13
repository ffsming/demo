package com.ff.service.user.impl;

import com.ff.dao.cluster.user.UserPointMapper;
import com.ff.service.user.UserPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPointServiceImpl<T> implements UserPointService<T> {
    @Autowired
    private UserPointMapper<T> mapper;

    @Override
    public T queryById(T t) {
        return mapper.queryById(t);
    }
}
