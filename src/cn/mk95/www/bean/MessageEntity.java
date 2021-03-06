package cn.mk95.www.bean;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by 睡意朦胧 on 2017/5/12.
 */
@Entity
@Table(name = "message", schema = "easyspace", catalog = "")
@IdClass(MessageEntityPK.class)
public class MessageEntity {
    private int userid;
    private int senduserid;
    private Timestamp sendtime;
    private String text;

    @Id
    @Column(name = "userid")
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Id
    @Column(name = "senduserid")
    public int getSenduserid() {
        return senduserid;
    }

    public void setSenduserid(int senduserid) {
        this.senduserid = senduserid;
    }

    @Id
    @Column(name = "sendtime")
    public Timestamp getSendtime() {
        return sendtime;
    }

    public void setSendtime(Timestamp sendtime) {
        this.sendtime = sendtime;
    }

    @Basic
    @Column(name = "text")
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
        if (senduserid != that.senduserid) return false;
        if (sendtime != null ? !sendtime.equals(that.sendtime) : that.sendtime != null) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userid;
        result = 31 * result + senduserid;
        result = 31 * result + (sendtime != null ? sendtime.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }
}
