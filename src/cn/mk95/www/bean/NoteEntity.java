package cn.mk95.www.bean;

import java.sql.Timestamp;

/**
 * Created by yangyonghao on 2017/3/12.
 * Time:21:39.
 */
public class NoteEntity {
    private int noteid;
    private int userid;
    private String noteurl;
    private Timestamp notetime;
    private int like;
    private int commentid;

    public int getNoteid() {
        return noteid;
    }

    public void setNoteid(int noteid) {
        this.noteid = noteid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getNoteurl() {
        return noteurl;
    }

    public void setNoteurl(String noteurl) {
        this.noteurl = noteurl;
    }

    public Timestamp getNotetime() {
        return notetime;
    }

    public void setNotetime(Timestamp notetime) {
        this.notetime = notetime;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
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
