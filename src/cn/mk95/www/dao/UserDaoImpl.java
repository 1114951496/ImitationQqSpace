package cn.mk95.www.dao;

import cn.mk95.www.bean.UserEntity;
import cn.mk95.www.interfaces.UserDao;

import java.util.List;

/**
 * Created by YangYongHao on 2017/3/29.
 * Annotation:
 */
public class UserDaoImpl extends BaseDaoHibernate<UserEntity> implements UserDao {
    @Override
    public UserEntity findUserByName(String name) {
        List<UserEntity> userEntities=find("select en from UserEntity en where en.username=?0",name);
        if(userEntities.size()==0)
            return null;
        return userEntities.get(0);
    }

    @Override
    public UserEntity findUserById(int id) {
        List<UserEntity> userEntities=find("select en from UserEntity en where en.userid=?0",id);
        if(userEntities.size()==0)
            return null;
        return userEntities.get(0);
    }

}
