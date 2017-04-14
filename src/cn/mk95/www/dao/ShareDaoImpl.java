package cn.mk95.www.dao;

import cn.mk95.www.bean.ShareEntity;
import cn.mk95.www.interfaces.ShareDao;

import java.util.Date;
import java.util.List;

/**
 * Created by YangYongHao on 2017/3/29.
 * Annotation:
 */
public class ShareDaoImpl extends BaseDaoHibernate<ShareEntity> implements ShareDao {
    @Override
    public List findShareByUserId(int userid) {
        return null;
    }

    @Override
    public List findShareByShareId(int shareid) {
        return null;
    }

    @Override
    public List findShareByid(int userid, int noteid) {
        return null;
    }

    @Override
    public List findShareByTime(Date time) {
        return null;
    }
}
