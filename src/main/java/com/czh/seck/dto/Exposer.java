package com.czh.seck.dto;

import java.time.LocalDateTime;

public class Exposer {

    private boolean exposed;
    private String md5;
    private long itemId;
    private LocalDateTime now;
    private LocalDateTime start;
    private LocalDateTime end;

    public Exposer(boolean exposed, long itemId) {
        this.exposed = exposed;
        this.itemId = itemId;
    }

    public Exposer(boolean exposed, long itemId, LocalDateTime now, LocalDateTime start, LocalDateTime end) {
        this.exposed = exposed;
        this.itemId = itemId;
        this.now = now;
        this.start = start;
        this.end = end;
    }

    public Exposer(boolean exposed, String md5, long itemId) {
        this.exposed = exposed;
        this.md5 = md5;
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return "Exposer{" +
                "exposed=" + exposed +
                ", md5=" + md5 +
                ", itemId=" + itemId +
                ", now=" + now +
                ", start=" + start +
                ", end=" + end +
                '}';
    }

    public boolean isExposed() {
        return exposed;
    }

    public void setExposed(boolean exposed) {
        this.exposed = exposed;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public LocalDateTime getNow() {
        return now;
    }

    public void setNow(LocalDateTime now) {
        this.now = now;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

}
