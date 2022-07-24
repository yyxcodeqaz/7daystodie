package com.daystodie.entity;


public class HoldUser {

  private long holdId;
  private long userId;
  private long commodityId;
  private long holdCommodityTime;


  public long getHoldId() {
    return holdId;
  }

  public void setHoldId(long holdId) {
    this.holdId = holdId;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public long getCommodityId() {
    return commodityId;
  }

  public void setCommodityId(long commodityId) {
    this.commodityId = commodityId;
  }


  public long getHoldCommodityTime() {
    return holdCommodityTime;
  }

  public void setHoldCommodityTime(long holdCommodityTime) {
    this.holdCommodityTime = holdCommodityTime;
  }

}
