package com.example.cache.service;

import com.example.cache.bean.AppCache;
import com.example.cache.dao.AppCacheDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

/**
 * @Description: 测试缓存service
 * @Author: WenChangSheng
 * @Date: Created in 2019/1/10 13:56
 */
@Service
//@CacheConfig(cacheNames = "appCache") 类似于在controller上@RequetMapping
public class AppCacheService {
    @Autowired
    private AppCacheDao appCacheDao;

    /**
     * 开启缓存，默认key为传参
     */
    @Cacheable(cacheNames = {"appCache"})
    public AppCache get(String id) {
        System.out.println("get From database");
        return appCacheDao.get(id);
    }

    /**
     * 更新数据，同时更新缓存
     */
    @CachePut(cacheNames = {"appCache"}, key = "#appCache.id")
    public AppCache update(AppCache appCache) {
        appCacheDao.update(appCache);
        return appCache;
    }

    /**
     * 删除缓存
     * allEntries=true 清除appCache缓存中的所有数据
     */
    @CacheEvict(cacheNames = "appCache", key = "#id")
    public String delete(String id) {
        appCacheDao.delete(id);
        return id;
    }

    /**
     * 定义复杂的缓存规则
     */
    @Caching(
            cacheable = {
                    //缓存key为手机号
                    @Cacheable(cacheNames = "appCache", key = "#telephone")
            },
            put = {
                    //返回数据后，再缓存key为id和proSampleId
                    @CachePut(cacheNames = "appCache", key = "#result.id"),
                    @CachePut(cacheNames = "appCache", key = "#result.proSampleId")
            }
    )
    public AppCache getByTelephone(String telephone) {
        return appCacheDao.getByTelephone(telephone);
    }
}
