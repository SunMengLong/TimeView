package com.menglong.timeview;

/**
 * Created by Pooh on 2018/7/11.
 */

public class DataBean {
    private String content;
    private String time;

    public DataBean(String content, String time) {
        this.content = content;
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
