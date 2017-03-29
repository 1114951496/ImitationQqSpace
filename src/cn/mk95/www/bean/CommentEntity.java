package cn.mk95.www.bean;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by YangYongHao on 2017/3/29.
 * Annotation:
 */
@Entity
@Table(name = "comment", schema = "easyspace", catalog = "")
@IdClass(CommentEntityPK.class)
public class CommentEntity {
    private int noteid;
    private Timestamp commenttime;
    private int commentid;
    private String commenturl;

    @Id
    @Column(name = "noteid", nullable = false)
    public int getNoteid() {
        return noteid;
    }

    public void setNoteid(int noteid) {
        this.noteid = noteid;
    }

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
    @Column(name = "commenturl", nullable = false, length = 20)
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
