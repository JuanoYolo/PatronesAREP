package services;

import java.util.Date;

public class Message {
    private String info;
    private Date date;

    public Message(String info, Date date) {
        this.info = info;
        this.date = date;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
