package cn.mk95.www.interfaces;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;

/**
 * Created by YangYongHao on 2017/3/29.
 * Annotation:
 */
public interface BaseDao<T> {

    //初始化session和Transaction
    public Session init();
    public SessionFactory getSessionFactory();
    //根据id加载实体
    public T get(Class<T> entity, Serializable id);
    //保存实体
    public Serializable save(T entity);
    //更新实体
    public void update(T entity);
    //删除实体
    public void delete(T entity);
    //根据id删除实体
    public void delete(Class<T> entity, Serializable id);
    //获取所有实体
    public List<T> findAll(Class<T> entity);
    //获取实体总数
    public long findCount(Class<T> entity);

    //根据hql查询实体
    public List<T> find(String hql);

    //根据带占位符参数的hql语句查询实体
    public List<T> find(String hql,Object... params);

    /**
     * 使用不带占位符的hql分页查询
     * @param hql 需要查询的hql语句
     * @param pageNo 查询第pageNo页的记录
     * @param pageSize 每页需要显示的记录数
     * @return 当前页的所有记录
     */
    public List<T> findByPage(String hql,int pageNo,int pageSize);

    /**
     * 使用带占位符的hql分页查询
     * @param hql 需要查询的hql语句
     * @param pageNo 查询第pageNo页的记录
     * @param pageSize 每页需要显示的记录数
     * @param params 占位符参数
     * @return 当前页的所有记录
     */
    public List<T> findByPage(String hql,int pageNo,int pageSize,Object... params);
}
