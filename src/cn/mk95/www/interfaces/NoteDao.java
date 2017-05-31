package cn.mk95.www.interfaces;

import cn.mk95.www.bean.NoteEntity;
import cn.mk95.www.bean.UserEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by YangYongHao on 2017/3/29.
 * Annotation:
 */
public interface NoteDao extends BaseDao<NoteEntity> {
    public List findNoteByTime(int uerid, Date notetime);
    public List findNoteByid(int userid);

    /**
     * 通过用户id查询所有note
     * @param user_id
     * @return
     */
    public List findNoteByUserid(int user_id);

    /**
     * 通过url寻找note
     * @param url
     * @return
     */
    public NoteEntity findNoteByNoteUrl(String url);

    /**
     *
     * @return
     */
    public List<NoteEntity> findAllNote();

    /**
     * 统计某一用户的note总数
     * @param user_id
     * @return
     */
    public int countUserNote(int user_id);

    public int countNote();

    /**
     * 查询好友最新的note
     * @param friends
     * @param pageNo
     * @return
     */
    public List<NoteEntity> findFriendsNewsByTime(ArrayList<UserEntity> friends, Integer pageNo);
}
