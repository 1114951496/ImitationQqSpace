package cn.mk95.www.bean;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by YangYongHao on 2017/3/30.
 * Annotation:
 */
@Entity
@Table(name = "share", schema = "easyspace", catalog = "")
@IdClass(ShareEntityPK.class)
public class ShareEntity {
    private int userid;
    private int noteid;
    private int shareid;
    private Timestamp sharetime;

    @Id
    @Column(name = "userid", nullable = false)
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "noteid", nullable = false)
    public int getNoteid() {
        return noteid;
    }

    public void setNoteid(int noteid) {
        this.noteid = noteid;
    }

    @Id
    @Column(name = "shareid", nullable = false)
    public int getShareid() {
        return shareid;
    }

    public void setShareid(int shareid) {
        this.shareid = shareid;
    }

    @Id
    @Column(name = "sharetime", nullable = false)
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

        ShareEntity that = (ShareEntity) o;

        if (userid != that.userid) return false;
        if (noteid != that.noteid) return false;
        if (shareid != that.shareid) return false;
        if (sharetime != null ? !sharetime.equals(that.sharetime) : that.sharetime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userid;
        result = 31 * result + noteid;
        result = 31 * result + shareid;
        result = 31 * result + (sharetime != null ? sharetime.hashCode() : 0);
        return result;
    }
}
