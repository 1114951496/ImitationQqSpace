package cn.mk95.www.dao;

import cn.mk95.www.bean.NoteEntity;
import cn.mk95.www.interfaces.NoteDao;

import java.util.Date;
import java.util.List;

/**
 * Created by YangYongHao on 2017/3/29.
 * Annotation:
 */
public class NoteDaoImpl extends BaseDaoHibernate<NoteEntity> implements NoteDao {

    @Override
    public List findNoteByTime(int userid, Date notetime) {
        String hql1 = "select en from NoteEntity en where en.username=" + userid + " and en.notetime like " + notetime + "%";
        List<NoteEntity> noteEntities = find(hql1);
        if (noteEntities.size() == 0)
            return null;
        return noteEntities;
    }

    @Override
    public List findNoteByid(int userid) {
        List<NoteEntity> noteEntities=find("select en from NoteEntity en where en.username=?0",userid);
        if(noteEntities.size()==0)
            return null;
        return noteEntities;
    }

    @Override
    public List findNoteByUserid(int user_id) {
        List<NoteEntity> noteEntities = find("select en from NoteEntity en where en.userid=?", user_id);
        return noteEntities;
    }

    @Override
    public NoteEntity findNoteByNoteUrl(String url) {
        List<NoteEntity> noteEntities = find("select en from NoteEntity en where en.noteurl=?", url);
        if (noteEntities.size() == 0)
            return null;
        else
            return noteEntities.get(0);
    }

    @Override
    public List<NoteEntity> findAllNote() {
        return find("from NoteEntity");
    }

    /**
     * 统计某一用户的note总数
     * @param user_id
     * @return
     */
    public int countUserNote(int user_id){
        return findNoteByUserid(user_id).size();
    }

    public int countNote(){
        return findAllNote().size();
    }
}
