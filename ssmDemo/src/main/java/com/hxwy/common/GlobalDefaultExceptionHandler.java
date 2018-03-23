package com.hxwy.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 异常拦截器
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {
    private final static Logger log = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Map<String, Object> defaultErrorHandler(HttpServletRequest req, Exception e) {
        //打印异常信息：
        e.printStackTrace();
        log.error(e.getMessage(), e);
        Map<String , Object> resultMap = new HashMap<String , Object>();
        resultMap.put("state", "1");
        resultMap.put("msg","服务器异常，请稍后重试");
        return resultMap;
    }
}
