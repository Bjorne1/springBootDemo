package com.example.elasticsearch;

import java.util.List;

/**
 * @description:
 * @author: wenchangsheng
 * @date: created in 2019/1/15
 */
public interface BookRepository {

    /**
     * 这个官方文档里面有好多格式化的方法名，这个能直接模糊查询
     *
     * @param name
     * @return
     */
    List<Book> findBookNameLike(String name);
}
