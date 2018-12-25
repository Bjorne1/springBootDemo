package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.entity.AppUser;
import com.example.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Description:
 * @Author: WenChangSheng
 * @Date: Created in 2018/8/31 11:16
 */
@RestController
@RequestMapping("/v1/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String get(@RequestParam(name = "pageNum", required = false, defaultValue = "1")
                              int pageNum,
                      @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                              int pageSize) {
        PageInfo<AppUser> pageInfo = userService.get(pageNum, pageSize);
        return JSON.toJSONString(pageInfo);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String add(HttpServletRequest request) {
        String username = request.getParameter("username");
        AppUser appUser = new AppUser();
        appUser.setId("15305229018200020010100100000512");
        appUser.setUsername(username);
        appUser.setSex(1);
        appUser.setUpdateTime(new Date());
        appUser.setDel(0);
        int add = userService.add(appUser);
        if (add == 1) {
            return JSON.toJSONString(true);
        }
        return JSON.toJSONString(false);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public String update(String id, HttpServletRequest request) {
        String username = request.getParameter("username");
        AppUser appUser = new AppUser();
        appUser.setId(id);
        appUser.setUsername(username);
        appUser.setSex(111);
        appUser.setUpdateTime(new Date());
        appUser.setDel(0);
        int update = userService.update(appUser);
        if (update == 1) {
            return JSON.toJSONString(true);
        }
        return JSON.toJSONString(false);
    }

}
