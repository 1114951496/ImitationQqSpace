package cn.mk95.www.interfaces;


import java.io.Serializable;
import java.util.List;

/**
 * Created by YangYongHao on 2017/3/29.
 * Annotation:
 */
public interface BaseDao<T> {
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
}
