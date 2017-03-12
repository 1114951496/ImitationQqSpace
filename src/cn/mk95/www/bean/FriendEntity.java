package cn.mk95.www.bean;

/**
 * Created by yangyonghao on 2017/3/12.
 * Time:21:39.
 */
public class FriendEntity {
    private int userid;
    private String fid;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FriendEntity that = (FriendEntity) o;

        if (userid != that.userid) return false;
        if (fid != null ? !fid.equals(that.fid) : that.fid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userid;
        result = 31 * result + (fid != null ? fid.hashCode() : 0);
        return result;
    }
}
