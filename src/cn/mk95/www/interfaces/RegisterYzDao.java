package cn.mk95.www.interfaces;

import cn.mk95.www.bean.RegisterYzEntity;

/**
 * Created by YangYongHao on 2017/3/29.
 * Annotation:
 */
public interface RegisterYzDao extends BaseDao<RegisterYzEntity> {
    public RegisterYzEntity findByEmail(String email);
}
