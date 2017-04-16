package cn.mk95.www.action;

import cn.mk95.www.bean.RegisterYzEntity;
import cn.mk95.www.bean.UserEntity;
import cn.mk95.www.interfaces.RegisterYzDao;
import cn.mk95.www.interfaces.UserDao;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.sql.Timestamp;
import java.util.Calendar;

/**
 * Created by YangYongHao on 2017/3/28.
 * Annotation:
 */
public class LoginAndRegister extends ActionSupport{

    private UserEntity user;
    private UserDao userDao;
    private RegisterYzDao registerYzDao;
    private String yzm;

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

    public String register(){
        userDao.init();
        registerYzDao.init();
        System.out.println("-------------register-------------");
        UserEntity userEntity=userDao.findUserByName(user.getUsername());
        if(userEntity!=null)
            return ActionSupport.ERROR;
        else {
            System.out.println(user.getEmail()+" "+user.getUsername()+" "+user.getPassword());
            RegisterYzEntity registerYzEntity=registerYzDao.findByEmail(user.getEmail());
            if(registerYzEntity!=null&&registerYzEntity.getYzm()==Integer.parseInt(yzm)){
                user.setUsersex("bm");
                user.setRegistertime(new Timestamp(Calendar.getInstance().getTime().getTime()));
                userDao.save(user);
                ServletActionContext.getRequest().getSession().setAttribute("user",user);
            }

            else
                return ActionSupport.ERROR;
        }
        return ActionSupport.SUCCESS;
    }

    public String login(){
        userDao.init();
        System.out.println("-------------login-------------  "+user.getUsername()+"  "+user.getPassword());
        UserEntity userEntity=userDao.findUserByName(user.getUsername());
        if(userEntity!=null&&userEntity.getPassword().equals(user.getPassword())){
            ServletActionContext.getRequest().getSession().setAttribute("user",userEntity);
            return ActionSupport.SUCCESS;
        }
        return ActionSupport.ERROR;
    }

    public String test(){
        userDao.init();
        System.out.println("--------------测试："+userDao.findCount(UserEntity.class));

        return ActionSupport.SUCCESS;
    }
}
