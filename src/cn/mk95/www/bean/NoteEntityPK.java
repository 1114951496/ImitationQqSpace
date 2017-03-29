package cn.mk95.www.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by YangYongHao on 2017/3/29.
 * Annotation:
 */
public class NoteEntityPK implements Serializable {
    private int noteid;
    private int userid;
    private Timestamp notetime;

    @Column(name = " noteid", nullable = false)
    @Id
    public int getNoteid() {
        return noteid;
    }

    public void setNoteid(int noteid) {
        this.noteid = noteid;
    }

    @Column(name = "userid", nullable = false)
    @Id
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Column(name = "notetime", nullable = false)
    @Id
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
