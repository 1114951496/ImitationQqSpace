package cn.mk95.www.action;

import cn.mk95.www.bean.HomeDynamic;
import cn.mk95.www.interfaces.NoteDao;
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
        ArrayList<HomeDynamic> homeNewDynamics_page1=noteService.newNoteListToDynamicList(1,4,noteDao);
        HttpServletRequest request= ServletActionContext.getRequest();
        request.setAttribute("homeNewDynamics_page1",homeNewDynamics_page1);
        return ActionSupport.SUCCESS;
    }
}
