package cn.mk95.www.bean;

import java.sql.Timestamp;

/**
 * Created by yangyonghao on 2017/3/12.
 * Time:21:39.
 */
public class CommentEntity {
    private int noteid;
    private Timestamp commenttime;
    private int commentid;
    private String commenturl;

    public int getNoteid() {
        return noteid;
    }

    public void setNoteid(int noteid) {
        this.noteid = noteid;
    }

    public Timestamp getCommenttime() {
        return commenttime;
    }

    public void setCommenttime(Timestamp commenttime) {
        this.commenttime = commenttime;
    }

    public int getCommentid() {
        return commentid;
    }

    public void setCommentid(int commentid) {
        this.commentid = commentid;
    }

    public String getCommenturl() {
        return commenturl;
    }

    public void setCommenturl(String commenturl) {
        this.commenturl = commenturl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentEntity that = (CommentEntity) o;

        if (noteid != that.noteid) return false;
        if (commentid != that.commentid) return false;
        if (commenttime != null ? !commenttime.equals(that.commenttime) : that.commenttime != null) return false;
        if (commenturl != null ? !commenturl.equals(that.commenturl) : that.commenturl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = noteid;
        result = 31 * result + (commenttime != null ? commenttime.hashCode() : 0);
        result = 31 * result + commentid;
        result = 31 * result + (commenturl != null ? commenturl.hashCode() : 0);
        return result;
    }
}
