package cn.mk95.www.bean;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by YangYongHao on 2017/4/20.
 * Annotation:
 */
@Entity
@Table(name = "comment", schema = "easyspace", catalog = "")
public class CommentEntity {
    private Timestamp commenttime;
    private int commentid;
    private int userid;
    private String commenturl;
    private int nid;

    @Basic
    @Column(name = "commenttime", nullable = false)
    public Timestamp getCommenttime() {
        return commenttime;
    }

    public void setCommenttime(Timestamp commenttime) {
        this.commenttime = commenttime;
    }

    @Id
    @Column(name = "commentid", nullable = false)
    public int getCommentid() {
        return commentid;
    }

    public void setCommentid(int commentid) {
        this.commentid = commentid;
    }

    @Basic
    @Column(name = "userid", nullable = false)
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "commenturl", nullable = false, length = 255)
    public String getCommenturl() {
        return commenturl;
    }

    public void setCommenturl(String commenturl) {
        this.commenturl = commenturl;
    }

    @Basic
    @Column(name = "nid", nullable = false)
    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentEntity that = (CommentEntity) o;

        if (commentid != that.commentid) return false;
        if (userid != that.userid) return false;
        if (nid != that.nid) return false;
        if (commenttime != null ? !commenttime.equals(that.commenttime) : that.commenttime != null) return false;
        if (commenturl != null ? !commenturl.equals(that.commenturl) : that.commenturl != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = commenttime != null ? commenttime.hashCode() : 0;
        result = 31 * result + commentid;
        result = 31 * result + userid;
        result = 31 * result + (commenturl != null ? commenturl.hashCode() : 0);
        result = 31 * result + nid;
        return result;
    }
}
