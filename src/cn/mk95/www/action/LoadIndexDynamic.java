package cn.mk95.www.action;

import cn.mk95.www.bean.HomeDynamic;
import cn.mk95.www.interfaces.NoteDao;
import cn.mk95.www.interfaces.UserDao;
import cn.mk95.www.service.NoteService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * Created by YangYongHao on 2017/5/30.
 * Annotation:
 */
public class LoadIndexDynamic extends ActionSupport{
    private NoteDao noteDao;
    private NoteService noteService;
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public NoteDao getNoteDao() {
        return noteDao;
    }

    public void setNoteDao(NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    public NoteService getNoteService() {
        return noteService;
    }

    public void setNoteService(NoteService noteService) {
        this.noteService = noteService;
    }

    @Override
    public String execute() throws Exception {
        noteDao.init();
        userDao.init();
        ArrayList<HomeDynamic> homeNewDynamics_page1=noteService.newNoteListToDynamicList(1,4,noteDao,userDao);
        ArrayList<HomeDynamic> homeHotDynamics_page1=noteService.hotNoteListToDynamicList(1,4,noteDao,userDao);
        HttpServletRequest request= ServletActionContext.getRequest();
        request.setAttribute("homeNewDynamics_page1",homeNewDynamics_page1);
        request.setAttribute("homeHotDynamics_page1",homeHotDynamics_page1);
        int flag=1;
        request.setAttribute("flag",flag);
        return ActionSupport.SUCCESS;
    }
}
