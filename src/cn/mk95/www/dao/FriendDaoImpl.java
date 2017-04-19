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
    public FriendEntity findFriendByUserId(int userid) {
        List<FriendEntity> friendEntities=find("select en from FriendEntity en where en.userid=?",userid);
        if(friendEntities.size()==0)
            return null;
        return friendEntities.get(0);
    }
}
