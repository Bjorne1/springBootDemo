package com.example.elasticsearch;

import io.searchbox.annotations.JestId;

/**
 * @description:
 * @author: wenchangsheng
 * @date: created in 2019/1/15
 */
public class Article {

    @JestId
    private int id;
    private String title;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
