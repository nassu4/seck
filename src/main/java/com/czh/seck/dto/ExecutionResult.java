package com.czh.seck.dto;

import com.czh.seck.entity.SuccessKilledOrder;
import com.czh.seck.enums.SeckillResultEnum;

public class ExecutionResult {

    private long itemId;
    private int state;
    private String stateInfo;
    private SuccessKilledOrder successKilledOrder;

    public ExecutionResult(long itemId, SeckillResultEnum sre) {
        this.itemId = itemId;
        this.state = sre.getState();
        this.stateInfo = sre.getStateInfo();
    }

    public ExecutionResult(long itemId, SeckillResultEnum sre, SuccessKilledOrder successKilledOrder) {
        this.itemId = itemId;
        this.state = sre.getState();
        this.stateInfo = sre.getStateInfo();
        this.successKilledOrder = successKilledOrder;
    }

    @Override
    public String toString() {
        return "ExecutionResult{" +
                "itemId=" + itemId +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", successKilledOrder=" + successKilledOrder +
                '}';
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public SuccessKilledOrder getSuccessKilledOrder() {
        return successKilledOrder;
    }

    public void setSuccessKilledOrder(SuccessKilledOrder successKilledOrder) {
        this.successKilledOrder = successKilledOrder;
    }

}
