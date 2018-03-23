package com.hxwy.service.message;

import java.util.List;

public interface MessageDetailService<T> {
    public List<T> queryList(T t);
}
