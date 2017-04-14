package cn.mk95.www.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by 睡意朦胧 on 2017/4/14.
 */
public class NoteEntityPK implements Serializable {
    private int userid;
    private Timestamp notetime;
    private int id;

    @Column(name = "userid")
    @Id
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Column(name = "notetime")
    @Id
    public Timestamp getNotetime() {
        return notetime;
    }

    public void setNotetime(Timestamp notetime) {
        this.notetime = notetime;
    }

    @Column(name = " id")
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NoteEntityPK that = (NoteEntityPK) o;

        if (userid != that.userid) return false;
        if (id != that.id) return false;
        if (notetime != null ? !notetime.equals(that.notetime) : that.notetime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userid;
        result = 31 * result + (notetime != null ? notetime.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}
