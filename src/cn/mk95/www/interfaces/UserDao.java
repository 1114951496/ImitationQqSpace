package cn.mk95.www.interfaces;

import cn.mk95.www.bean.UserEntity;

/**
 * Created by YangYongHao on 2017/3/29.
 * Annotation:
 */
public interface UserDao extends BaseDao<UserEntity> {
    public UserEntity findUserByName(String name);
    public UserEntity findUserById(int id);
}
