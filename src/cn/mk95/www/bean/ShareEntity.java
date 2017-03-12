package cn.mk95.www.bean;

import java.sql.Timestamp;

/**
 * Created by yangyonghao on 2017/3/12.
 * Time:21:39.
 */
public class ShareEntity {
    private int userid;
    private int shareid;
    private Timestamp sharetime;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getShareid() {
        return shareid;
    }

    public void setShareid(int shareid) {
        this.shareid = shareid;
    }

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
