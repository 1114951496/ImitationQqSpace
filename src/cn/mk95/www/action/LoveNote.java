package cn.mk95.www.action;

import cn.mk95.www.bean.NoteEntity;
import cn.mk95.www.interfaces.NoteDao;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 * Created by YangYongHao on 2017/5/31.
 * Annotation:
 */
public class LoveNote{
    private int id;
    private NoteDao noteDao;

    public void setId(int id) {
        this.id = id;
    }

    public void setNoteDao(NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    public synchronized String love() throws Exception {
        HttpServletResponse response= ServletActionContext.getResponse();
        HttpServletRequest request=ServletActionContext.getRequest();
        HashMap<Integer,Integer> loveMap= (HashMap<Integer, Integer>) request.getSession().getAttribute("loveMap");
        PrintWriter writer=response.getWriter();
        if(loveMap==null){
            loveMap=new HashMap<>();
        }
        if(loveMap.get(id)!=null&&loveMap.get(id)==1){
            writer.print("2");
            writer.flush();
            writer.close();
            return ActionSupport.SUCCESS;
        }
        noteDao.init();
        id=Integer.parseInt(request.getParameter("id"));
        NoteEntity noteEntity=noteDao.findNoteById(id);
        noteEntity.setLove(noteEntity.getLove()+1);
        try {
            noteDao.save(noteEntity);

            loveMap.put(id,1);
            request.getSession().setAttribute("loveMap",loveMap);
            writer.print("1");
        }catch (Exception e){
            writer.print("0");
        }
        writer.flush();
        writer.close();
        return ActionSupport.SUCCESS;
    }
}
