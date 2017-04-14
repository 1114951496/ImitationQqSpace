package cn.mk95.www.interfaces;

import cn.mk95.www.bean.AlbumEntity;

import java.util.List;

/**
 * Created by YangYongHao on 2017/3/29.
 * Annotation:
 */
public interface AlbumDao extends BaseDao<AlbumEntity> {
    public AlbumEntity findAlbumByUserId(int userid);
}
