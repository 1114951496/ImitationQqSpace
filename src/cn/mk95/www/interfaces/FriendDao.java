package cn.mk95.www.interfaces;

import cn.mk95.www.bean.FriendEntity;

import java.util.List;

/**
 * Created by YangYongHao on 2017/3/29.
 * Annotation:
 */
public interface FriendDao extends BaseDao<FriendEntity> {
    public List findFriendByUserId(int userid);
}
