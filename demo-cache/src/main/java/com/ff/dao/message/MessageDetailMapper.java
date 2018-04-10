package com.ff.dao.message;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MessageDetailMapper<T>{
	
	public List<T> queryList(T t);
	
}
 