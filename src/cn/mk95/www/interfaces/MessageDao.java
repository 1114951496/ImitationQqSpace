package cn.mk95.www.interfaces;

import cn.mk95.www.bean.MessageEntity;

import java.util.List;

/**
 * Created by YangYongHao on 2017/3/29.
 * Annotation:
 */
public interface MessageDao extends BaseDao<MessageEntity> {
    public List findMessageByUserId(int userid);
}
