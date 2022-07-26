package com.daystodie.entity;


public class Commodity {

    private long commodityId;
    private String commodityName;
    private String commodityCode;
    private String commodityVersion;
    private String commodityContentKey;
    private String commodityKey;

    public long getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(long commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public void setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
    }

    public String getCommodityVersion() {
        return commodityVersion;
    }

    public void setCommodityVersion(String commodityVersion) {
        this.commodityVersion = commodityVersion;
    }

    public String getCommodityContentKey() {
        return commodityContentKey;
    }

    public void setCommodityContentKey(String commodityContentKey) {
        this.commodityContentKey = commodityContentKey;
    }

    public String getCommodityKey() {
        return commodityKey;
    }

    public void setCommodityKey(String commodityKey) {
        this.commodityKey = commodityKey;
    }
}
