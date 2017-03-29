package cn.mk95.www.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by YangYongHao on 2017/3/29.
 * Annotation:
 */
public class CommentEntityPK implements Serializable {
    private int noteid;
    private int commentid;

    @Column(name = "noteid", nullable = false)
    @Id
    public int getNoteid() {
        return noteid;
    }

    public void setNoteid(int noteid) {
        this.noteid = noteid;
    }

    @Column(name = "commentid", nullable = false)
    @Id
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
