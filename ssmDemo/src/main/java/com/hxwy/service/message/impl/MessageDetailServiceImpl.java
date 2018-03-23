package com.hxwy.service.message.impl;

import java.util.List;

import com.hxwy.service.message.MessageDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hxwy.dao.message.MessageDetailMapper;

@Service
public class MessageDetailServiceImpl<T> implements MessageDetailService<T> {
	@Autowired
	private MessageDetailMapper<T> mapper;
	@Override
	public List<T> queryList(T t){
		return mapper.queryList(t);
	}
}
