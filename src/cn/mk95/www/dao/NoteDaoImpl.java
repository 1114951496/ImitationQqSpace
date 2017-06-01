package cn.mk95.www.dao;

import cn.mk95.www.bean.NoteEntity;
import cn.mk95.www.bean.UserEntity;
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
    /**
     * 通过userid查询数据，以时间增加
     * @param userid
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public List findNoteByIdOrderByDate(int userid, int pageNo, int pageSize) {
        List<NoteEntity> noteEntities=findByPage("select en from NoteEntity en where en.userid=? order by notetime",pageNo,pageSize,userid);
        return noteEntities;
    }

    @Override
    public List<NoteEntity> findFriendsNewsByTime(ArrayList<UserEntity> friends,Integer pageNo) {
        String hsql="select en from NoteEntity en where";
        System.out.print(friends.size()+"!");
        for(int i=0;i<friends.size();i++){
            hsql=hsql+" en.userid="+ friends.get(i).getUserid();
            if(i<friends.size()-1) {
                System.out.print(i);
                hsql = hsql + " or";
            }
        }
        hsql=hsql+" order by en.notetime desc";
        System.out.print(hsql);
        List<NoteEntity> list=findByPage(hsql,pageNo,10);
        System.out.print(list);
        return list;
    }
}
