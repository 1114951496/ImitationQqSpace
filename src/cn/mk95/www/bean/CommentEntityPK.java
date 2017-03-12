package cn.mk95.www.bean;

import java.io.Serializable;

/**
 * Created by yangyonghao on 2017/3/12.
 * Time:21:39.
 */
public class CommentEntityPK implements Serializable {
    private int noteid;
    private int commentid;

    public int getNoteid() {
        return noteid;
    }

    public void setNoteid(int noteid) {
        this.noteid = noteid;
    }

    public int getCommentid() {
        return commentid;
    }

    public void setCommentid(int commentid) {
        this.commentid = commentid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentEntityPK that = (CommentEntityPK) o;

        if (noteid != that.noteid) return false;
        if (commentid != that.commentid) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = noteid;
        result = 31 * result + commentid;
        return result;
    }
}
