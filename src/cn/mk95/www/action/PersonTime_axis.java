package cn.mk95.www.action;

import cn.mk95.www.bean.UserEntity;
import cn.mk95.www.interfaces.UserDao;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by 睡意朦胧 on 2017/4/13.
 */
public class PersonTime_axis extends ActionSupport{
    private UserDao userDao;
    private UserEntity user;

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

        return ERROR;
    }
}
