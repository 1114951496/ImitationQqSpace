package cn.mk95.www.bean;

/**
 * Created by yangyonghao on 2017/3/12.
 * Time:21:39.
 */
public class AlbumEntity {
    private int userid;
    private String photourl;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

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
