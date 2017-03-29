package cn.mk95.www.bean;

import javax.persistence.*;

/**
 * Created by YangYongHao on 2017/3/29.
 * Annotation:
 */
@Entity
@Table(name = "friend", schema = "easyspace", catalog = "")
public class FriendEntity {
    private int userid;
    private String fidurl;

    @Id
    @Column(name = "userid", nullable = false)
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "fidurl", nullable = false, length = 100)
    public String getFidurl() {
        return fidurl;
    }

    public void setFidurl(String fidurl) {
        this.fidurl = fidurl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FriendEntity that = (FriendEntity) o;

        if (userid != that.userid) return false;
        if (fidurl != null ? !fidurl.equals(that.fidurl) : that.fidurl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userid;
        result = 31 * result + (fidurl != null ? fidurl.hashCode() : 0);
        return result;
    }
}
