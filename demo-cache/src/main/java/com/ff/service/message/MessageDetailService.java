package com.ff.service.message;

import java.util.List;

public interface MessageDetailService<T> {
    public List<T> queryList(T t);
    public List<Object> test();
}
