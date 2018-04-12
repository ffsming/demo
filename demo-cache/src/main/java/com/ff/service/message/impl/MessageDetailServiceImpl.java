package com.ff.service.message.impl;

import com.ff.dao.message.MessageDetailMapper;
import com.ff.service.message.MessageDetailService;
import com.ff.util.cache.RCacheable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class MessageDetailServiceImpl<T> implements MessageDetailService<T> {
	@Autowired
	private MessageDetailMapper<T> mapper;
	@Override
	public List<T> queryList(T t){
		return mapper.queryList(t);
	}

	@Override
	@RCacheable(name="cache1",expireTime = 600)
	public List<Object> test() {
		log.info("库里取值");
		List<Object> list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			list.add(i);
		}
		return list;
	}
}
