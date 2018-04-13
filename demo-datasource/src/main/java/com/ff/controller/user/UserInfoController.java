package com.ff.controller.user;

import com.ff.pojo.user.UserModel;
import com.ff.pojo.user.UserPointModel;
import com.ff.service.user.UserPointService;
import com.ff.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserInfoController {

    @Autowired
    private UserPointService<UserPointModel> userPointService;

    @Autowired
    private UserService<UserModel> userService;

    @RequestMapping("/require_user_list")
    @ResponseBody
    public Map<String, Object> require(@RequestBody UserPointModel model)
            throws Exception {

        log.info("查询游戏数据，请求参数==" + model);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        UserPointModel pointModel = userPointService.queryById(model);
        UserModel userModel = new UserModel();
        userModel.setUid(Long.valueOf(model.getUid()));
        userModel = userService.queryById(userModel);

        resultMap.put("state", "0");
        resultMap.put("msg", "查询成功");

        log.info("返回结果=="+resultMap);
        return resultMap;

    }

}

