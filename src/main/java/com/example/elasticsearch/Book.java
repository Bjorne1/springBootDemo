package com.example.elasticsearch;

/**
 * @description:
 * @author: wenchangsheng
 * @date: created in 2019/1/15
 */
//@Document(indexName = "wcs", type = "book")
public class Book {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
