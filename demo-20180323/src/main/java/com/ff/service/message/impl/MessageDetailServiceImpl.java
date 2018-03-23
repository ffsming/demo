package com.ff.service.message.impl;

import java.util.List;

import com.ff.dao.message.MessageDetailMapper;
import com.ff.service.message.MessageDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MessageDetailServiceImpl<T> implements MessageDetailService<T> {
	@Autowired
	private MessageDetailMapper<T> mapper;
	@Override
	public List<T> queryList(T t){
		return mapper.queryList(t);
	}
}
