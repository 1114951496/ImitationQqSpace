package cn.mk95.www.dao;

import cn.mk95.www.bean.NoteEntity;
import cn.mk95.www.interfaces.NoteDao;

import java.util.ArrayList;
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
    public int findAuthorById(int id) {
        List<NoteEntity> list = find("select en from NoteEntity en where en.id=?", id);
        return list.get(0).getUserid();
    }

    @Override
    public NoteEntity findNoteById(int id) {
        List<NoteEntity> noteEntities = find("select en from NoteEntity en where en.id=?", id);
        if (noteEntities.size() == 0)
            return null;
        return noteEntities.get(0);
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
     *
     * @param user_id
     * @return
     */
    public int countUserNote(int user_id) {
        return findNoteByUserid(user_id).size();
    }

    public int countNote() {
        return findAllNote().size();
    }

    @Override
    public ArrayList<NoteEntity> findNewNote(int page, int num) {
        ArrayList<NoteEntity> newNotes = (ArrayList<NoteEntity>) findByPage("from NoteEntity en order by en.notetime desc", page, num);
        return newNotes;
    }

    @Override
    public int findMaxId() {
        int max=find("from NoteEntity where id=(select max(en.id) from NoteEntity en)").get(0).getId();
        return max;
    }
}
