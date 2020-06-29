package com.czh.seck.enums;

public enum SeckillResultEnum {

    SUCCESS(1, "秒杀成功"),
    END(0, "秒杀结束"),
    REPEATED_KILL(-1, "重复秒杀"),
    INNER_ERROR(-2, "系统异常"),
    DATA_REWRITE(-3, "数据篡改");

    private int state;
    private String stateInfo;

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

    SeckillResultEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public static SeckillResultEnum of(int state) {
        for (SeckillResultEnum sre : values())
            if (sre.getState() == state) return sre;
        return null;
    }

}
