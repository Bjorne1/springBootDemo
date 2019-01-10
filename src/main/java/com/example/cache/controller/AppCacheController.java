package com.example.cache.controller;

import com.example.cache.bean.AppCache;
import com.example.cache.service.AppCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description:
 * @Author: WenChangSheng
 * @Date: Created in 2019/1/10 13:57
 */
@RestController
public class AppCacheController {

    @Autowired
    private AppCacheService appCacheService;

    @GetMapping("/appCache/{id}")
    public AppCache get(@PathVariable String id) {
        return appCacheService.get(id);
    }

    @GetMapping("/appCache/telephone/{telephone}")
    public AppCache getByTelephone(@PathVariable String telephone) {
        return appCacheService.getByTelephone(telephone);
    }

    @PostMapping("/appCache/{id}")
    public AppCache update(@PathVariable String id) {
        AppCache appCache = new AppCache();
        appCache.setId(id);
        appCache.setProSampleId("11158942867090040010002100001111");
        appCache.setTelephone("13047911112");
        return appCacheService.update(appCache);
    }

    @DeleteMapping("/appCache/{id}")
    public String delete(@PathVariable String id) {
        return appCacheService.delete(id);
    }
}
