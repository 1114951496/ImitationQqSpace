package cn.mk95.www.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by 睡意朦胧 on 2017/5/12.
 */
public class MessageEntityPK implements Serializable {
    private int userid;
    private int senduserid;
    private Timestamp sendtime;

    @Column(name = "userid")
    @Id
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Column(name = "senduserid")
    @Id
    public int getSenduserid() {
        return senduserid;
    }

    public void setSenduserid(int senduserid) {
        this.senduserid = senduserid;
    }

    @Column(name = "sendtime")
    @Id
    public Timestamp getSendtime() {
        return sendtime;
    }

    public void setSendtime(Timestamp sendtime) {
        this.sendtime = sendtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageEntityPK that = (MessageEntityPK) o;

        if (userid != that.userid) return false;
        if (senduserid != that.senduserid) return false;
        if (sendtime != null ? !sendtime.equals(that.sendtime) : that.sendtime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userid;
        result = 31 * result + senduserid;
        result = 31 * result + (sendtime != null ? sendtime.hashCode() : 0);
        return result;
    }
}
