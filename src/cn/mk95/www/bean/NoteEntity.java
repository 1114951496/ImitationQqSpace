package cn.mk95.www.bean;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by YangYongHao on 2017/4/19.
 * Annotation:
 */
@Entity
@Table(name = "note", schema = "easyspace", catalog = "")
@IdClass(NoteEntityPK.class)
public class NoteEntity {
    private int userid;
    private String noteurl;
    private Timestamp notetime;
    private Integer commentid;
    private int noteid;
    private Integer id;
    private Integer love;

    @Id
    @Column(name = "userid", nullable = false)
    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "noteurl", nullable = false, length = 255)
    public String getNoteurl() {
        return noteurl;
    }

    public void setNoteurl(String noteurl) {
        this.noteurl = noteurl;
    }

    @Basic
    @Column(name = "notetime", nullable = true)
    public Timestamp getNotetime() {
        return notetime;
    }

    public void setNotetime(Timestamp notetime) {
        this.notetime = notetime;
    }

    @Basic
    @Column(name = "commentid", nullable = true)
    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    @Id
    @Column(name = "noteid", nullable = false)
    public int getNoteid() {
        return noteid;
    }

    public void setNoteid(int noteid) {
        this.noteid = noteid;
    }

    @Basic
    @Column(name = "id", nullable = true)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "love", nullable = true)
    public Integer getLove() {
        return love;
    }

    public void setLove(Integer love) {
        this.love = love;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NoteEntity that = (NoteEntity) o;

        if (userid != that.userid) return false;
        if (noteid != that.noteid) return false;
        if (noteurl != null ? !noteurl.equals(that.noteurl) : that.noteurl != null) return false;
        if (notetime != null ? !notetime.equals(that.notetime) : that.notetime != null) return false;
        if (commentid != null ? !commentid.equals(that.commentid) : that.commentid != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (love != null ? !love.equals(that.love) : that.love != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userid;
        result = 31 * result + (noteurl != null ? noteurl.hashCode() : 0);
        result = 31 * result + (notetime != null ? notetime.hashCode() : 0);
        result = 31 * result + (commentid != null ? commentid.hashCode() : 0);
        result = 31 * result + noteid;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (love != null ? love.hashCode() : 0);
        return result;
    }
}
