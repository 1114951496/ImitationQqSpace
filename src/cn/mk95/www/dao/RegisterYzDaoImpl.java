package cn.mk95.www.dao;

import cn.mk95.www.bean.RegisterYzEntity;
import cn.mk95.www.interfaces.RegisterYzDao;

import java.util.List;

/**
 * Created by YangYongHao on 2017/3/29.
 * Annotation:
 */
public class RegisterYzDaoImpl extends BaseDaoHibernate<RegisterYzEntity> implements RegisterYzDao {
    @Override
    public RegisterYzEntity findByEmail(String email) {
        List list = find("select en from RegisterYzEntity en where en.registerEmail=?0", email);
        if (list.size() == 0) {
            System.out.println("findByEmail return null");
            return null;
        }
        else
            return (RegisterYzEntity) list.get(0);
    }
}
