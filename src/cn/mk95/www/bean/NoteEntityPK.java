package cn.mk95.www.bean;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by yangyonghao on 2017/3/12.
 * Time:21:39.
 */
public class NoteEntityPK implements Serializable {
    private int noteid;
    private int userid;
    private Timestamp notetime;

    public int getNoteid() {
        return noteid;
    }

    public void setNoteid(int noteid) {
        this.noteid = noteid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Timestamp getNotetime() {
        return notetime;
    }

    public void setNotetime(Timestamp notetime) {
        this.notetime = notetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NoteEntityPK that = (NoteEntityPK) o;

        if (noteid != that.noteid) return false;
        if (userid != that.userid) return false;
        if (notetime != null ? !notetime.equals(that.notetime) : that.notetime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = noteid;
        result = 31 * result + userid;
        result = 31 * result + (notetime != null ? notetime.hashCode() : 0);
        return result;
    }
}
