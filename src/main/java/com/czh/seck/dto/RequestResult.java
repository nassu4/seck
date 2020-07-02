package com.czh.seck.dto;

public class RequestResult<T> {

    private int state;
    private T data;
    private String errorInfo;

    public RequestResult(int state, T data) {
        this.state = state;
        this.data = data;
    }

    public RequestResult(int state, String errorInfo) {
        this.state = state;
        this.errorInfo = errorInfo;
    }

    @Override
    public String toString() {
        return "RequestResult{" +
                "state=" + state +
                ", data=" + data +
                ", errorInfo='" + errorInfo + '\'' +
                '}';
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

}
