package com.czh.seck.dto;

import com.czh.seck.entity.Stock;

import java.time.format.DateTimeFormatter;

public class StockResult {

    private long itemId;
    private String itemName;
    private int itemStock;
    private String startTime;
    private String endTime;
    private String creationTime;

    public StockResult(Stock stock) {
        this.itemId = stock.getItemId();
        this.itemName = stock.getItemName();
        this.itemStock = stock.getItemStock();
        this.startTime = stock.getStartTime().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss"));
        this.endTime = stock.getEndTime().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss"));
        this.creationTime = stock.getCreationTime().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss"));
    }

    @Override
    public String toString() {
        return "StockResult{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemStock=" + itemStock +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", creationTime='" + creationTime + '\'' +
                '}';
    }

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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

}
