package cn.mk95.www.interfaces;

import cn.mk95.www.bean.UserEntity;

import java.util.List;

/**
 * Created by YangYongHao on 2017/3/29.
 * Annotation:
 */
public interface UserDao extends BaseDao<UserEntity> {
    public List<UserEntity> findUserByName(String name);
    public UserEntity findUserById(int id);
}
