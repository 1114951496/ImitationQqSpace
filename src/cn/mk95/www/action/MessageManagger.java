package cn.mk95.www.action;

import cn.mk95.www.bean.MessageEntity;
import cn.mk95.www.bean.UserEntity;
import cn.mk95.www.interfaces.MessageDao;
import cn.mk95.www.interfaces.UserDao;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;


/**
 * Created by 睡意朦胧 on 2017/5/3.
 */
public class MessageManagger extends ActionSupport{
    private UserEntity user;
    private UserDao userDao;
    private MessageEntity message;
    private MessageDao messageDao;
    ArrayList<MessageEntity> messages=new ArrayList<>();
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setMessage(MessageEntity message) {
        this.message = message;
    }

    public void setMessageDao(MessageDao messageDao) {
        this.messageDao = messageDao;
    }

    /**
     * 查看留言板
     * @return 成功获取Message列表并在View中显示
     */
    public String CheckMessage(){
        messageDao.init();
        userDao.init();
        if (ServletActionContext.getRequest().getSession().getAttribute("Messages")==null) {
            if ((UserEntity)ServletActionContext.getRequest().getSession().getAttribute("friend")!=null){
                user=(UserEntity)ServletActionContext.getRequest().getSession().getAttribute("friend");
                messages = (ArrayList<MessageEntity>) messageDao.findMessageByUserId(user.getUserid());
                ServletActionContext.getRequest().getSession().setAttribute("Messages", messages);
            }else {
                user = (UserEntity) ServletActionContext.getRequest().getSession().getAttribute("user");
                messages = (ArrayList<MessageEntity>) messageDao.findMessageByUserId(user.getUserid());
                ServletActionContext.getRequest().getSession().setAttribute("Messages", messages);
            }
        }
        return SUCCESS;
    }
    /**
     * 写留言
     */
    public String WriteMessage(){
        messageDao.init();
        HttpServletRequest request= ServletActionContext.getRequest();
        HttpSession session=request.getSession();
        user=(UserEntity)session.getAttribute("user");
        Calendar calendar= Calendar.getInstance();
        /* 获取当前时间 */
        message.setSendtime(new Timestamp(calendar.getTime().getTime()));
        message.setSenduserid(user.getUserid());
        message.setText(text);
        if (session.getAttribute("friend")!=null){
            message.setUserid(((UserEntity)session.getAttribute("friend")).getUserid());
        }else
            message.setUserid(user.getUserid());
        messages=(ArrayList<MessageEntity>)session.getAttribute("Messages");
        messages.add(message);
        session.setAttribute("Messages",messages);
        messageDao.save(message);
        return SUCCESS;
    }
}
