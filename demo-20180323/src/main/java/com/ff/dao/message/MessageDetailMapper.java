package com.ff.dao.message;

import java.util.List;
public interface MessageDetailMapper<T>{
	
	public List<T> queryList(T t);
	
}
 