package cn.mk95.www.action;

import cn.mk95.www.bean.H_note;
import cn.mk95.www.bean.NoteEntity;
import cn.mk95.www.bean.UserEntity;
import cn.mk95.www.interfaces.NoteDao;
import cn.mk95.www.interfaces.UserDao;
import cn.mk95.www.service.NoteService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by 睡意朦胧 on 2017/4/13.
 */
public class PersonTime_axis extends ActionSupport{
    private UserDao userDao;
    private UserEntity user;
    private NoteEntity note;
    private NoteDao noteDao;
    private int pageNo;
    private NoteService noteService;
    public NoteService getNoteService() {
        return noteService;
    }

    public void setNoteService(NoteService noteService) {
        this.noteService = noteService;
    }

    public NoteEntity getNote() {
        return note;
    }

    public void setNote(NoteEntity note) {
        this.note = note;
    }

    public NoteDao getNoteDao() {
        return noteDao;
    }

    public void setNoteDao(NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public String MyHome(){
        noteDao.init();
        HttpServletRequest request= ServletActionContext.getRequest();
        HttpSession session=request.getSession();
        user=(UserEntity)session.getAttribute("Muser");
        if (request.getParameter("NotePageNo")==null){
            pageNo=1;
            session.setAttribute("NotePageNo",pageNo);
        }else{
            pageNo=(int)session.getAttribute("NotePageNo");
            session.setAttribute("NotePageNo",pageNo);
        }
        ArrayList<H_note> my_notes=new ArrayList<>();
        ArrayList<NoteEntity> notes=(ArrayList<NoteEntity>)noteDao.findNoteByIdOrderByDate(user.getUserid(),pageNo,10);
        for(int i=0;i<notes.size();i++){
            H_note my_note=new H_note();
            my_note.setId(notes.get(i).getId());
            my_note.setNoteTitle(noteService.getNoteTitle(notes.get(i).getNoteurl()));
            my_note.setTime(notes.get(i).getNotetime());
            my_notes.add(my_note);
        }
        int maxPages=(int)noteDao.countUserNote(user.getUserid())/10;
        session.setAttribute("MaxPages",maxPages);
        session.setAttribute("Mnotes",my_notes);
        return SUCCESS;
    }
}
