package com.czh.seck.entity;

import java.time.LocalDateTime;

public class SuccessKilledOrder {

    private long itemId;
    private long userPhoneNumber;
    private byte state;
    private LocalDateTime creationTime;

    private Stock stock;

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public long getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(long userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public byte getState() {
        return state;
    }

    public void setState(byte state) {
        this.state = state;
    }

    public LocalDateTime getCreateTime() {
        return creationTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.creationTime = createTime;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "SuccessKilledOrder{" +
                "itemId=" + itemId +
                ", userPhoneNumber=" + userPhoneNumber +
                ", state=" + state +
                ", createTime=" + creationTime +
                ", stock=" + stock +
                '}';
    }

}
