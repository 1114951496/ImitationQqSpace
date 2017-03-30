package cn.mk95.www.action;

import cn.mk95.www.bean.UserEntity;
import cn.mk95.www.dao.UserDaoImpl;
import com.opensymphony.xwork2.ActionSupport;
/**
 * Created by YangYongHao on 2017/3/28.
 * Annotation:
 */
public class LoginAndRegister extends ActionSupport{

    private UserEntity userEntity;
    private UserDaoImpl userDao;

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public UserDaoImpl getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public String register(){
        System.out.println("-------------register-------------");
        return ActionSupport.SUCCESS;
    }

    public String login(){
        System.out.println("-------------login-------------");

        return ActionSupport.SUCCESS;
    }

    public String test(){
        System.out.println("--------------测试："+userDao.findCount(UserEntity.class));

        return ActionSupport.SUCCESS;
    }
}
