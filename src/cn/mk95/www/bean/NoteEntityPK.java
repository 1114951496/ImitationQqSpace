package cn.mk95.www.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by YangYongHao on 2017/4/19.
 * Annotation:
 */
public class NoteEntityPK implements Serializable {
    private int userid;
    private int noteid;

    @Column(name = "userid", nullable = false)
    @Id
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Column(name = "noteid", nullable = false)
    @Id
    public int getNoteid() {
        return noteid;
    }

    public void setNoteid(int noteid) {
        this.noteid = noteid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NoteEntityPK that = (NoteEntityPK) o;

        if (userid != that.userid) return false;
        if (noteid != that.noteid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userid;
        result = 31 * result + noteid;
        return result;
    }
}
