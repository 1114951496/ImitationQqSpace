package cn.mk95.www.dao;

import cn.mk95.www.bean.MessageEntity;
import cn.mk95.www.interfaces.MessageDao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by YangYongHao on 2017/3/29.
 * Annotation:
 */
public class MessageDaoImpl extends BaseDaoHibernate<MessageEntity> implements MessageDao {
    @Override
    public List<MessageEntity> findMessageByUserId(int userid) {
        List<MessageEntity> MessageEntities=find("select en from MessageEntity en where en.userid=?",userid);
        if(MessageEntities.size()==0)
            return null;
        return MessageEntities;
    }

}
