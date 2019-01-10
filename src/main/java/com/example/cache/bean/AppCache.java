package com.example.cache.bean;

/**
 * @Description:
 * @Author: WenChangSheng
 * @Date: Created in 2019/1/10 11:41
 */
public class AppCache {
    private String id;
    private String telephone;
    private String proSampleId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getProSampleId() {
        return proSampleId;
    }

    public void setProSampleId(String proSampleId) {
        this.proSampleId = proSampleId;
    }

    @Override
    public String toString() {
        return "AppCache{" +
                "id='" + id + '\'' +
                ", telephone='" + telephone + '\'' +
                ", proSampleId='" + proSampleId + '\'' +
                '}';
    }
}
