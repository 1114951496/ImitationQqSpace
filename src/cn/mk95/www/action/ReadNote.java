package cn.mk95.www.action;

import cn.mk95.www.bean.NoteEntity;
import cn.mk95.www.bean.UserEntity;
import cn.mk95.www.interfaces.NoteDao;
import cn.mk95.www.service.NoteService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by YangYongHao on 2017/4/18.
 * Annotation:
 */
public class ReadNote extends ActionSupport{
    private NoteDao noteDao;
    private int id;
    private NoteService noteService;

    public void setNoteService(NoteService noteService) {
        this.noteService = noteService;
    }

    public void setNoteDao(NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String execute() throws Exception {
        noteDao.init();
        HttpServletRequest request=ServletActionContext.getRequest();
        if(request.getParameter("id")==null){
            id=(int) request.getAttribute("id");
        }else{
            id=Integer.parseInt(request.getParameter("id"));
        }
        NoteEntity note=noteDao.findNoteById(id);
        String noteTitle=noteService.getNoteTitle(note.getNoteurl());
        request.getSession().setAttribute("requestNoteTitle",noteTitle);
        request.getSession().setAttribute("requestNoteContent",
                NoteService.getNoteFileContent(NoteService.getWebInfPath()+note.getNoteurl()));
        request.getSession().setAttribute("sid",noteTitle+id);
        return ActionSupport.SUCCESS;
    }
}
