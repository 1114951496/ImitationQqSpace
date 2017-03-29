package cn.mk95.www.bean;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by YangYongHao on 2017/3/29.
 * Annotation:
 */
@Entity
@Table(name = "note", schema = "easyspace", catalog = "")
@IdClass(NoteEntityPK.class)
public class NoteEntity {
    private int noteid;
    private int userid;
    private String noteurl;
    private Timestamp notetime;
    private int like;
    private int commentid;

    @Id
    @Column(name = " noteid", nullable = false)
    public int getNoteid() {
        return noteid;
    }

    public void setNoteid(int noteid) {
        this.noteid = noteid;
    }

    @Id
    @Column(name = "userid", nullable = false)
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "noteurl", nullable = false, length = 20)
    public String getNoteurl() {
        return noteurl;
    }

    public void setNoteurl(String noteurl) {
        this.noteurl = noteurl;
    }

    @Id
    @Column(name = "notetime", nullable = false)
    public Timestamp getNotetime() {
        return notetime;
    }

    public void setNotetime(Timestamp notetime) {
        this.notetime = notetime;
    }

    @Basic
    @Column(name = "like", nullable = false)
    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    @Basic
    @Column(name = "commentid", nullable = false)
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

        NoteEntity that = (NoteEntity) o;

        if (noteid != that.noteid) return false;
        if (userid != that.userid) return false;
        if (like != that.like) return false;
        if (commentid != that.commentid) return false;
        if (noteurl != null ? !noteurl.equals(that.noteurl) : that.noteurl != null) return false;
        if (notetime != null ? !notetime.equals(that.notetime) : that.notetime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = noteid;
        result = 31 * result + userid;
        result = 31 * result + (noteurl != null ? noteurl.hashCode() : 0);
        result = 31 * result + (notetime != null ? notetime.hashCode() : 0);
        result = 31 * result + like;
        result = 31 * result + commentid;
        return result;
    }
}
