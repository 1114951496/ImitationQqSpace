package cn.mk95.www.dao;

import cn.mk95.www.bean.AlbumEntity;
import cn.mk95.www.interfaces.AlbumDao;

import java.util.List;

/**
 * Created by YangYongHao on 2017/3/29.
 * Annotation:
 */
public class AlbumDaoImpl extends BaseDaoHibernate<AlbumEntity> implements AlbumDao {
    @Override
    public AlbumEntity findAlbumByUserId(int userid) {
        List<AlbumEntity> albumEntities=find("select en from AlbumEntity en where en.userid=?",userid);
        if(albumEntities.size()==0)
            return null;
        return albumEntities.get(0);
    }

}
