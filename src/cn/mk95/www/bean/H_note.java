package cn.mk95.www.bean;


import java.sql.Timestamp;

/**
 * Created by 睡意朦胧 on 2017/5/31.
 */
public class H_note {
    private int id;
    private String noteTitle;
    private Timestamp time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }


}
