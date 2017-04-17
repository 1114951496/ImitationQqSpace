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

    private String noteRoot="/userData/";


    public static String getWebInfPath(){
        String path1=NoteService.class.getClassLoader().getResource("").getPath();
        String path2=path1.substring(0,path1.length()-9);
        System.out.println("WebInfPath:" +path2);
        return path2;
    }

    /**
     * 初始化note
     * @param noteEntity
     * @param user_id
     * @param note_title
     * @return 返回note的绝对路径
     */
    public String initNote(NoteEntity noteEntity,int user_id,String note_title,NoteDao noteDao){
        this.noteDao=noteDao;
        Calendar calendar=Calendar.getInstance();
        long l=calendar.getTime().getTime();
        noteEntity.setNotetime(new Timestamp(l));
        //note路径,存在数据库的是WEB-INF之后的路径
        String path=getWebInfPath()+noteRoot+user_id+"/"+note_title;
        String url=noteRoot+user_id+"/"+l+".txt";
        System.out.println(url);
        noteEntity.setCommentid(0);
        noteEntity.setLove(0);
        int note_id=noteDao.countUserNote(user_id);
        noteEntity.setNoteid(note_id);
        noteEntity.setUserid(user_id);
        noteEntity.setId(noteDao.countNote()+1);
        noteEntity.setNoteurl(url);
        return path;
    }


    public boolean saveNoteFile(String url,String dir,String noteContent){
        FileOutputStream fileOutputStream;
        try {
            File file=new File(dir);
            if(!file.exists())
                file.mkdirs();
            fileOutputStream=new FileOutputStream(url);
            fileOutputStream.write(noteContent.getBytes());
            fileOutputStream.flush();
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
