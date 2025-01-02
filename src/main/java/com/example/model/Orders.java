package com.example.model;

import java.io.Serializable;
import java.util.Date;

public class Orders implements Serializable {

    private String content;
    private Date timestamp;

    public Orders() {
    }

    public Orders(String content, Date timestamp) {
        this.content = content;
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Order{" +
                "content='" + content + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
