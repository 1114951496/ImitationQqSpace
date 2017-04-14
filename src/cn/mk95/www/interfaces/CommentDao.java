package cn.mk95.www.interfaces;

import cn.mk95.www.bean.CommentEntity;

import java.util.List;

/**
 * Created by YangYongHao on 2017/3/29.
 * Annotation:
 */
public interface CommentDao extends BaseDao<CommentEntity> {
    public List findCommentByNoteId(int noteid);
}
