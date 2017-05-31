package cn.mk95.www.service;

import cn.mk95.www.bean.HomeDynamic;
import cn.mk95.www.bean.NoteEntity;
import cn.mk95.www.bean.UserEntity;
import cn.mk95.www.dao.NoteDaoImpl;
import cn.mk95.www.interfaces.NoteDao;
import cn.mk95.www.interfaces.UserDao;
import cn.mk95.www.util.StringUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by YangYongHao on 2017/4/16.
 * Annotation:
 */
public class NoteService {

    private String noteRoot = "/userData/";


    public static String getWebInfPath() {
        String path1 = NoteService.class.getClassLoader().getResource("").getPath();
        String path2 = path1.substring(0, path1.length() - 9);
        System.out.println("WebInfPath:" + path2);
        return path2;
    }

    /**
     * 初始化note
     *
     * @param noteEntity
     * @param user_id
     * @param note_title
     * @return 返回note的绝对路径
     */
    public synchronized String initNote(NoteEntity noteEntity, int user_id, String note_title, NoteDao noteDao) {
        Calendar calendar = Calendar.getInstance();
        long l = calendar.getTime().getTime();
        noteEntity.setNotetime(new Timestamp(l));
        //note路径,存在数据库的是WEB-INF之后的路径
        String path = getWebInfPath() + noteRoot + user_id + "/" + StringUtil.encode(note_title);
        String url = noteRoot + user_id + "/" + StringUtil.encode(note_title) + "/" + l + ".txt";
        System.out.println(url);
        noteEntity.setCommentid(0);
        noteEntity.setLove(0);
        int note_id = noteDao.countUserNote(user_id);
        noteEntity.setNoteid(note_id);
        noteEntity.setUserid(user_id);
        noteEntity.setId(noteDao.findMaxId() + 1);
        noteEntity.setNoteurl(url);
        return path;
    }


    public boolean saveNoteFile(String url, String dir, String noteContent) {
        FileOutputStream fileOutputStream;
        noteContent = StringUtil.encode(noteContent);
        try {
            File file = new File(dir);
            if (!file.exists())
                file.mkdirs();
            String strings[] = url.split("/");
            String filename = strings[strings.length - 1];
            //文件名
            File cacheFile = new File(dir, filename);//设置参数
            cacheFile.createNewFile();//生成文件
            fileOutputStream = new FileOutputStream(NoteService.getWebInfPath() + url);
            OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream, "utf-8");
            writer.write(noteContent);
            writer.close();
            fileOutputStream.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 通过对noteurl处理得到真实title
     *
     * @param noteurl
     * @return
     */
    public String getNoteTitle(String noteurl) {
        String strings[] = noteurl.split("/");
        //得到的是title的16进制表示
        String noteTitle = strings[strings.length - 2];
        //调用StringUtil的decode方法转换
        return StringUtil.decode(noteTitle);
    }

    /**
     * 传入路径，对文件内容进行16进制转String操作
     *
     * @param path
     * @return
     */
    public static String getNoteFileContent(String path) {
        try {
            FileInputStream is = new FileInputStream(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String content = new String();
            String buff;
            while ((buff = reader.readLine()) != null)
                content += buff;
            System.out.println(content);
            content = StringUtil.decode(content);
            reader.close();
            is.close();
            return content;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public ArrayList<HomeDynamic> newNoteListToDynamicList(int page, int num, NoteDao noteDao, UserDao userDao) {
        ArrayList<HomeDynamic> homeDynamics = new ArrayList<>();  //主页动态
        ArrayList<NoteEntity> newNotes = noteDao.findNewNote(page, num);
        noteListToDynamicList(newNotes,homeDynamics,userDao);
        return homeDynamics;
    }

    public ArrayList<HomeDynamic> hotNoteListToDynamicList(int page, int num,NoteDao noteDao, UserDao userDao) {
        ArrayList<HomeDynamic> homeDynamics = new ArrayList<>();  //主页动态
        ArrayList<NoteEntity> hotNotes = noteDao.findHotNote(page, num);
        noteListToDynamicList(hotNotes,homeDynamics,userDao);
        return homeDynamics;
    }

    public void noteListToDynamicList(ArrayList<NoteEntity> notes,ArrayList<HomeDynamic> homeDynamics, UserDao userDao){
        for (NoteEntity noteEntity : notes) {
            HomeDynamic homeDynamic = new HomeDynamic();
            UserEntity userEntity;
            userEntity=userDao.findUserById(noteEntity.getUserid());
            homeDynamic.setContentUrl("/readNote?id=" + noteEntity.getId());
            String content = getNoteFileContent(NoteService.getWebInfPath()
                    + noteEntity.getNoteurl());
            homeDynamic.setId(userEntity.getUserid()+"");
            homeDynamic.setDynamicContent(content.length() > 20 ? content.substring(0, 20) : content);
            homeDynamic.setImgUrl(userEntity.getIcon());
            homeDynamic.setName(userEntity.getUsername());
            homeDynamic.setUserUrl("/infriend?friendid="+userEntity.getUserid());
            System.out.println("  content:"+homeDynamic.getDynamicContent()+"  url:"+homeDynamic.getContentUrl()+"  id:"+homeDynamic.getId());
            homeDynamics.add(homeDynamic);
        }
    }
}
