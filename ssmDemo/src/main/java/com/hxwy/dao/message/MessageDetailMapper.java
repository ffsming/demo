package com.hxwy.dao.message;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
public interface MessageDetailMapper<T>{
	
	public List<T> queryList(T t);
	
}
 