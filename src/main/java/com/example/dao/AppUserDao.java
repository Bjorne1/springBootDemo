package com.example.dao;

import com.example.entity.AppUser;

import java.util.List;

public interface AppUserDao {

    List<AppUser> get();

    int deleteByPrimaryKey(String id);

    int insert(AppUser appUser);

    int insertSelective(AppUser appUser);

    AppUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AppUser appUser);

    int updateByPrimaryKey(AppUser appUser);
}