package com.ff.controller;

import com.ff.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class TestController {

    @RequestMapping("/list")
    public String list(Model model){
        /**
         * service.queryList();
         */
        List<Object> list = new ArrayList<>();
        User user = new User();
        user.setName("张三");
        user.setId(1);
        user.setAge(20);
        list.add(user);
        user = new User(2,"lisi",18);
        list.add(user);
        model.addAttribute("user",list);
        return "list";
    }
    @RequestMapping("/toAdd")
    public String toAdd(Model model,Integer id){
        if(id != null){
            //查询
            /**
             * service.queryById(id);
             */
            log.info("修改");
            User user = new User(2,"lisi",18);
            model.addAttribute("user",user);
        }else{
            log.info("新增");
            User user = new User();
            model.addAttribute("user",user);
        }
        return "add";
    }
    @RequestMapping("/save")
    public String save(User user){
        log.info("保存："+user.toString());

        /**
         * service.save(user);
         */
        return "redirect:list";
    }
    @RequestMapping("/delete")
    public String toAdd(Integer id){
        log.info("删除："+id);
        /**
         * service.delete(id);
         */
        return "redirect:list";
    }

}
