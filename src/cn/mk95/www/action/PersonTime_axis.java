package cn.mk95.www.action;

import cn.mk95.www.bean.NoteEntity;
import cn.mk95.www.bean.UserEntity;
import cn.mk95.www.interfaces.NoteDao;
import cn.mk95.www.interfaces.UserDao;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by 睡意朦胧 on 2017/4/13.
 */
public class PersonTime_axis extends ActionSupport{
    private UserDao userDao;
    private UserEntity user;
    private NoteEntity note;
    private NoteDao noteDao;

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
        HttpServletRequest request= ServletActionContext.getRequest();
        HttpSession session=request.getSession();
        String MyId=request.getParameter("id");
        user=(UserEntity)userDao.findUserById(Integer.parseInt(MyId));
        Date date=user.getRegistertime();
        int year=date.getYear();
        int month=date.getMonth();
        int day=date.getDay();
        Calendar now=Calendar.getInstance();

        return ERROR;
    }
}
