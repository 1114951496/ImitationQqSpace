package cn.mk95.www.action;

import cn.mk95.www.bean.NoteEntity;
import cn.mk95.www.bean.UserEntity;
import cn.mk95.www.interfaces.NoteDao;
import cn.mk95.www.service.NoteService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

/**
 * Created by YangYongHao on 2017/4/12.
 * Annotation:
 */
public class WriteNote extends ActionSupport {
    private String title;
    private String note;
    private NoteDao noteDao;
    private NoteService noteService;
    private NoteEntity noteEntity;

    public void setNoteEntity(NoteEntity noteEntity) {
        this.noteEntity = noteEntity;
    }

    public void setNoteService(NoteService noteService) {
        this.noteService = noteService;
    }

    public void setNoteDao(NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String execute() throws Exception {
        //用户登录认证
        HttpSession session = ServletActionContext.getRequest().getSession();
        UserEntity user = (UserEntity) session.getAttribute("user");
        if (user != null)
            return ActionSupport.SUCCESS;
        else
            return ActionSupport.ERROR;
    }

    public String upNote() {
        noteDao.init();
        HttpSession session = ServletActionContext.getRequest().getSession();
        UserEntity user = (UserEntity) session.getAttribute("user");
        System.out.println(title + "\n>>>" + note);
        String dir=noteService.initNote(noteEntity,user.getUserid(),title,noteDao);
        boolean b=noteService.saveNoteFile(noteEntity.getNoteurl(),dir,note);
        if(b){
            noteDao.save(noteEntity);
            return ActionSupport.SUCCESS;
        }else {
            return ActionSupport.ERROR;
        }
    }
}
