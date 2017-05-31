package cn.mk95.www.interfaces;

import cn.mk95.www.bean.NoteEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by YangYongHao on 2017/3/29.
 * Annotation:
 */
public interface NoteDao extends BaseDao<NoteEntity> {
    public List findNoteByTime(int uerid, Date notetime);
    public List findNoteByIdOrderByDate(int userid,int pageNo,int pageSize);
    /**
     * 通过id找到作者
     * @param id
     * @return
     */
    public int findAuthorById(int id);

    /**
     * 通过id得到NoteEntity
     * @param id
     * @return
     */
    public NoteEntity findNoteById(int id);
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
     * 查询最新note
     * @param page
     * @param num
     * @return
     */
    public ArrayList<NoteEntity> findNewNote(int page,int num);

    /**
     * 得到最大id
     * @return
     */
    public int findMaxId();

    /**
     * 获取最热门note
     * @param page
     * @param num
     * @return
     */
    public ArrayList<NoteEntity> findHotNote(int page,int num);
}
