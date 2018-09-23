package com.example.service;

import com.example.dao.AppUserDao;
import com.example.entity.AppUser;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Description:
 * @Author: WenChangSheng
 * @Date: Created in 2018/8/31 11:16
 */
@Service
public class UserService {
    @Autowired
    AppUserDao appUserDao;

    public PageInfo<AppUser> get(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<AppUser> appUserList = appUserDao.get();
        return new PageInfo<>(appUserList);
    }

    public int update(AppUser appUser) {
        return appUserDao.updateByPrimaryKey(appUser);
    }

    public int add(AppUser appUser) {
        return appUserDao.insert(appUser);
    }
}
