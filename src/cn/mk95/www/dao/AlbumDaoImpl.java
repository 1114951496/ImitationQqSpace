package cn.mk95.www.dao;

import cn.mk95.www.bean.AlbumEntity;
import cn.mk95.www.interfaces.AlbumDao;

/**
 * Created by YangYongHao on 2017/3/29.
 * Annotation:
 */
public class AlbumDaoImpl extends BaseDaoHibernate<AlbumEntity> implements AlbumDao {
    @Override
    public AlbumEntity findAlbumByUserId(int userid) {
        return null;
    }
}
