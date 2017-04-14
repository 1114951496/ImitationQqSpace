package cn.mk95.www.interfaces;

import cn.mk95.www.bean.ShareEntity;

import java.util.Date;
import java.util.List;

/**
 * Created by YangYongHao on 2017/3/29.
 * Annotation:
 */
public interface ShareDao extends BaseDao<ShareEntity> {
    public List findShareByUserId(int userid);
    public List findShareByShareId(int shareid);
    public List findShareByid(int userid,int noteid);
    public List findShareByTime(Date time);
}
