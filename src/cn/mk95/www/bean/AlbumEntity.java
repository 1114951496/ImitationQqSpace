package cn.mk95.www.bean;

import javax.persistence.*;

/**
 * Created by YangYongHao on 2017/3/29.
 * Annotation:
 */
@Entity
@Table(name = "album", schema = "easyspace", catalog = "")
public class AlbumEntity {
    private int userid;
    private String photourl;

    @Id
    @Column(name = "userid", nullable = false)
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "photourl", nullable = true, length = 20)
    public String getPhotourl() {
        return photourl;
    }

    public void setPhotourl(String photourl) {
        this.photourl = photourl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AlbumEntity that = (AlbumEntity) o;

        if (userid != that.userid) return false;
        if (photourl != null ? !photourl.equals(that.photourl) : that.photourl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userid;
        result = 31 * result + (photourl != null ? photourl.hashCode() : 0);
        return result;
    }
}
