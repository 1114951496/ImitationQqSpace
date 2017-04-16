package cn.mk95.www.service;

import cn.mk95.www.bean.NoteEntity;
import cn.mk95.www.interfaces.NoteDao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 * Created by YangYongHao on 2017/4/16.
 * Annotation:
 */
public class NoteService {
    private NoteDao noteDao;

    private String noteRoot="/WEB-INF/userData/";


    /**
     * 初始化note
     * @param noteEntity
     * @param user_id
     * @param note_title
     * @return 返回生成的note存储路径
     */
    public String initNote(NoteEntity noteEntity,int user_id,String note_title,NoteDao noteDao){
        this.noteDao=noteDao;
        Calendar calendar=Calendar.getInstance();
        noteEntity.setNotetime(new Timestamp(calendar.getTime().getTime()));
        //note路径
        String url=noteRoot+user_id+"/"+note_title+"/"+calendar.getTime().getTime();

        noteEntity.setCommentid(0);
        noteEntity.setLove(0);
        int note_id=noteDao.countUserNote(user_id);
        noteEntity.setNoteid(note_id);
        noteEntity.setUserid(user_id);
        noteEntity.setId(noteDao.countNote()+1);
        noteEntity.setNoteurl(url);
        return noteRoot+user_id+"/"+note_title+"/";
    }


    public boolean saveNoteFile(String url,String dir,String noteContent){
        FileOutputStream fileOutputStream;
        try {
            File file=new File(dir);
            if(!file.exists())
                file.mkdir();
            fileOutputStream=new FileOutputStream(url);
            fileOutputStream.write(noteContent.getBytes());
            fileOutputStream.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
