package cn.mk95.www.action;

import cn.mk95.www.bean.UserEntity;
import cn.mk95.www.interfaces.BaseDao;
import cn.mk95.www.interfaces.UserDao;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by 睡意朦胧 on 2017/4/12.
 */
public class PersonPage extends ActionSupport{
    private UserEntity user;
    private UserDao userDao;
    private BaseDao baseDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }
    public String MyPage(){
        HttpServletRequest request= ServletActionContext.getRequest();
        HttpSession session=request.getSession();

       // System.out.println(user.getUserid());
//        if(baseDao.get(UserEntity.class,MyId)==null){
//            return ERROR;
//        }
        /**
         * 所有到的实现类在第一次使用时必须调用init（）；
         */
        userDao.init();
        user=(UserEntity) userDao.findUserById(((UserEntity)session.getAttribute("user")).getUserid());
        System.out.println(user);
        session.setAttribute("username",user.getUsername());
        session.setAttribute("usersex",user.getUsersex());
        session.setAttribute("email",user.getEmail());
        session.setAttribute("sign",user.getSign());
        session.setAttribute("icon",user.getIcon());
        session.setAttribute("userid",user.getUserid());
        return SUCCESS;
    }

}
