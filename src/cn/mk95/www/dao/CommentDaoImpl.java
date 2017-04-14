package cn.mk95.www.dao;

import cn.mk95.www.bean.CommentEntity;
import cn.mk95.www.interfaces.CommentDao;

import java.util.List;

/**
 * Created by YangYongHao on 2017/3/29.
 * Annotation:
 */
public class CommentDaoImpl extends BaseDaoHibernate<CommentEntity> implements CommentDao {
    @Override
    public List findCommentByNoteId(int noteid) {
        return null;
    }
}
