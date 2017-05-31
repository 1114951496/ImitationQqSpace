package cn.mk95.www.action;

import cn.mk95.www.bean.FriendEntity;
import cn.mk95.www.bean.UserEntity;
import cn.mk95.www.interfaces.BaseDao;
import cn.mk95.www.interfaces.FriendDao;
import cn.mk95.www.interfaces.NoteDao;
import cn.mk95.www.interfaces.UserDao;
import cn.mk95.www.service.Check_Friends;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by 睡意朦胧 on 2017/4/12.
 */
public class PersonPage extends ActionSupport{
    private UserEntity user;
    private UserDao userDao;
    private BaseDao baseDao;
    ArrayList<UserEntity> friends=new ArrayList<>();
    private Check_Friends check_friends;
    private PersonTime_axis personTime_axis;
    private NoteDao noteDao;

    public NoteDao getNoteDao() {
        return noteDao;
    }

    public void setNoteDao(NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    public PersonTime_axis getPersonTime_axis() {
        return personTime_axis;
    }

    public void setPersonTime_axis(PersonTime_axis personTime_axis) {
        this.personTime_axis = personTime_axis;
    }

    public Check_Friends getCheck_friends() {
        return check_friends;
    }

    public void setCheck_friends(Check_Friends check_friends) {
        this.check_friends = check_friends;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }
    public String MyPage() throws IOException {
        HttpServletRequest request= ServletActionContext.getRequest();
        HttpSession session=request.getSession();
        /**
         *  System.out.println(user.getUserid());
         * if(baseDao.get(UserEntity.class,MyId)==null){
         *      return ERROR;
         * }
         *
         * 所有到的实现类在第一次使用时必须调用init（）；
         */
        noteDao.init();
        userDao.init();
        friends= (ArrayList<UserEntity>) session.getAttribute("users");
        user=(UserEntity) userDao.findUserById(((UserEntity)session.getAttribute("user")).getUserid());
        session.setAttribute("Muser",user);
        session.removeAttribute("Messages");
        session.removeAttribute("albums");
        session.removeAttribute("MaxPages");
        session.removeAttribute("MnoteTitles");
        session.removeAttribute("NotePageNo");
        session.removeAttribute("noteids");
        session.removeAttribute("users");
        personTime_axis.MyHome();
        System.out.println(user);
        if (friends==null){
            friends=check_friends.CheckFriendsById(((UserEntity)session.getAttribute("user")).getUserid());
            session.setAttribute("users", friends);
        }
        return SUCCESS;
    }
}
