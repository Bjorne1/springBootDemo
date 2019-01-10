package com.example.cache.dao;

import com.example.cache.bean.AppCache;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @Description:
 * @Author: WenChangSheng
 * @Date: Created in 2019/1/10 11:40
 */
@Mapper
public interface AppCacheDao {

    @Select("SELECT * FROM app_user_sample WHERE id=#{id}")
    AppCache get(String id);

    @Update("UPDATE app_user_sample SET telephone=#{telephone},pro_sample_id=#{proSampleId}  WHERE id=#{id}")
    void update(AppCache appCache);

    @Delete("DELETE FROM app_user_sample WHERE id=#{id}")
    void delete(String id);

    @Select("SELECT * FROM app_user_sample WHERE telephone=#{telephone}")
    AppCache getByTelephone(String telephone);
}
