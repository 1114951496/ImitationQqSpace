package cn.mk95.www.dao;

import cn.mk95.www.bean.FriendEntity;
import cn.mk95.www.interfaces.FriendDao;

import java.util.List;

/**
 * Created by YangYongHao on 2017/3/29.
 * Annotation:
 */
public class FriendDaoImpl extends BaseDaoHibernate<FriendEntity> implements FriendDao {
    @Override
    public List findFriendByUserId(int userid) {
        return null;
    }
}
