package cn.mk95.www.service;

import cn.mk95.www.bean.NoteEntity;
import cn.mk95.www.bean.UserEntity;
import cn.mk95.www.interfaces.NoteDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by LU on 2017/5/30.
 */
public class FriendsNewsService {
    private NoteDao noteDao;

    public void setNoteDao(NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    public NoteDao getNoteDao() {
        return noteDao;
    }

    ArrayList<NoteEntity> arrayList=new ArrayList<>();
    public ArrayList getNewsNote(ArrayList<UserEntity> friends,Integer pageNo){
        noteDao.init();
        arrayList=(ArrayList<NoteEntity>) noteDao.findFriendsNewsByTime(friends,pageNo);
        return arrayList;
    }
}
