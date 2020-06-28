package com.czh.seck.entity;

import java.time.LocalDateTime;

public class Stock {

    private long itemId;
    private String itemName;
    private int itemStock;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private LocalDateTime creationTime;

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemStock() {
        return itemStock;
    }

    public void setItemStock(int itemStock) {
        this.itemStock = itemStock;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemStock=" + itemStock +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", creationTime=" + creationTime +
                '}';
    }

}
