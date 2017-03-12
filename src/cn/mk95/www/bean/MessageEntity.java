package cn.mk95.www.bean;

import java.sql.Timestamp;

/**
 * Created by yangyonghao on 2017/3/12.
 * Time:21:39.
 */
public class MessageEntity {
    private int userid;
    private Timestamp sendtime;
    private String text;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Timestamp getSendtime() {
        return sendtime;
    }

    public void setSendtime(Timestamp sendtime) {
        this.sendtime = sendtime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageEntity that = (MessageEntity) o;

        if (userid != that.userid) return false;
        if (sendtime != null ? !sendtime.equals(that.sendtime) : that.sendtime != null) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userid;
        result = 31 * result + (sendtime != null ? sendtime.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }
}
