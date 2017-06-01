package cn.mk95.www.service;

import cn.mk95.www.bean.DynamicFNews;
import cn.mk95.www.bean.NoteEntity;
import cn.mk95.www.bean.UserEntity;
import cn.mk95.www.interfaces.NoteDao;
import cn.mk95.www.interfaces.UserDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by LU on 2017/5/30.
 */
public class FriendsNewsService {
    private NoteDao noteDao;
    private NoteService noteService;
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public NoteService getNoteService() {
        return noteService;
    }

    public void setNoteService(NoteService noteService) {
        this.noteService = noteService;
    }

    public void setNoteDao(NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    public NoteDao getNoteDao() {
        return noteDao;
    }

    ArrayList<NoteEntity> arrayList=new ArrayList<>();
    ArrayList<DynamicFNews> dynamicFNewss=new ArrayList<>();
    public ArrayList getNewsNote(ArrayList<UserEntity> friends,Integer pageNo){
        noteDao.init();
        userDao.init();
        arrayList=(ArrayList<NoteEntity>) noteDao.findFriendsNewsByTime(friends,pageNo);
        for(NoteEntity noteEntity:arrayList){
            DynamicFNews dynamicFNews=new DynamicFNews();
            dynamicFNews.setContentUrl("/readNote?id=" + noteEntity.getId());
            String content = noteService.getNoteFileContent(NoteService.getWebInfPath()
                    + noteEntity.getNoteurl());
            dynamicFNews.setDynamicContent(content.length() > 20 ? content.substring(0, 20) : content);
            dynamicFNews.setId(noteEntity.getUserid());
            dynamicFNews.setImgUrl(".."+userDao.findUserById(noteEntity.getUserid()).getIcon());
            dynamicFNews.setNotetime(noteEntity.getNotetime());
            dynamicFNews.setNoteTitle(noteService.getNoteTitle(noteEntity.getNoteurl()));
            System.out.println("================================"+noteService.getNoteTitle(noteEntity.getNoteurl()));
            dynamicFNews.setUserName(userDao.findUserById(noteEntity.getUserid()).getUsername());
            dynamicFNews.setUserUrl("");
            dynamicFNewss.add(dynamicFNews);
        }
        return dynamicFNewss;
    }
}
