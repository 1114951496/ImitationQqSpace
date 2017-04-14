package cn.mk95.www.interfaces;

import cn.mk95.www.bean.NoteEntity;
import java.util.Date;
import java.util.List;

/**
 * Created by YangYongHao on 2017/3/29.
 * Annotation:
 */
public interface NoteDao extends BaseDao<NoteEntity> {
    public List findNoteByTime(int uerid, Date notetime);
    public List findNoteByid(int userid);
}
