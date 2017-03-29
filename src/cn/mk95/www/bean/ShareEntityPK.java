package cn.mk95.www.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by YangYongHao on 2017/3/29.
 * Annotation:
 */
public class ShareEntityPK implements Serializable {
    private int userid;
    private int shareid;
    private Timestamp sharetime;

    @Column(name = "userid", nullable = false)
    @Id
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Column(name = "shareid", nullable = false)
    @Id
    public int getShareid() {
        return shareid;
    }

    public void setShareid(int shareid) {
        this.shareid = shareid;
    }

    @Column(name = "sharetime", nullable = false)
    @Id
    public Timestamp getSharetime() {
        return sharetime;
    }

    public void setSharetime(Timestamp sharetime) {
        this.sharetime = sharetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShareEntityPK that = (ShareEntityPK) o;

        if (userid != that.userid) return false;
        if (shareid != that.shareid) return false;
        if (sharetime != null ? !sharetime.equals(that.sharetime) : that.sharetime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userid;
        result = 31 * result + shareid;
        result = 31 * result + (sharetime != null ? sharetime.hashCode() : 0);
        return result;
    }
}
