package cn.mk95.www.action;

import cn.mk95.www.bean.RegisterYzEntity;
import cn.mk95.www.bean.UserEntity;
import cn.mk95.www.interfaces.RegisterYzDao;
import cn.mk95.www.interfaces.UserDao;
import cn.mk95.www.util.EmailUtil;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;

/**
 * Created by YangYongHao on 2017/3/28.
 * Annotation:
 */
public class LoginAndRegister extends ActionSupport {

    private UserEntity user;
    private UserDao userDao;
    private RegisterYzDao registerYzDao;
    private String yzm;
    private String loginpwd;
    private String loginid;
    private EmailUtil emailUtil;

    public void setEmailUtil(EmailUtil emailUtil) {
        this.emailUtil = emailUtil;
    }

    public void setLoginid(String loginid) {
        this.loginid = loginid;
    }

    public void setLoginpwd(String loginpwd) {
        this.loginpwd = loginpwd;
    }

    public RegisterYzDao getRegisterYzDao() {
        return registerYzDao;
    }

    public void setRegisterYzDao(RegisterYzDao registerYzDao) {
        this.registerYzDao = registerYzDao;
    }

    public String getYzm() {
        return yzm;
    }

    public void setYzm(String yzm) {
        this.yzm = yzm;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String register() {
        Session session=userDao.init();
        registerYzDao.init();
        System.out.println("-------------register-------------");
//        UserEntity userEntity=userDao.findUserByName(user.getUsername());
//        if(userEntity!=null)
//            return ActionSupport.ERROR;
//        else {
        System.out.println(user.getEmail() + " " + user.getUsername() + " " + user.getPassword());
        RegisterYzEntity registerYzEntity = registerYzDao.findByEmail(user.getEmail());
        if (registerYzEntity != null && registerYzEntity.getYzm() == Integer.parseInt(yzm)&&registerYzEntity.getFlag()!=1) {
            user.setUsersex("bm");
            user.setRegistertime(new Timestamp(Calendar.getInstance().getTime().getTime()));
            registerYzEntity.setFlag(1);
            registerYzDao.save(registerYzEntity);
            userDao.save(user);
            ServletActionContext.getRequest().getSession().setAttribute("user", user);
        } else
            return ActionSupport.ERROR;
        //发送用户id到用户邮箱
        session.flush();
        System.out.println(user.getUserid());
        try {
            emailUtil.sendSystemEmail(user.getEmail(),"注册id","你好，你的注册id是"+user.getUserid());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ActionSupport.SUCCESS;
    }

    public String login() {
        userDao.init();
        user.setUserid(Integer.parseInt(loginid));
        user.setPassword(loginpwd);
        System.out.println("-------------login-------------  " + user.getUserid() + "  " + user.getPassword());
        UserEntity userEntity = userDao.findUserById(user.getUserid());
        if (userEntity != null && userEntity.getPassword().equals(user.getPassword())) {
            ServletActionContext.getRequest().getSession().setAttribute("user", userEntity);
            return ActionSupport.SUCCESS;
        }
        return ActionSupport.ERROR;
    }

    public String test() {
        userDao.init();
        System.out.println("--------------测试：" + userDao.findCount(UserEntity.class));

        return ActionSupport.SUCCESS;
    }
}
