package cn.mk95.www.dao;

import cn.mk95.www.interfaces.BaseDao;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

/**
 * Created by YangYongHao on 2017/3/29.
 * Annotation:
 */
public class BaseDaoHibernate<T> implements BaseDao<T>{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public T get(Class<T> entity, Serializable id) {
        return (T)sessionFactory.getCurrentSession().get(entity, id);
    }

    @Override
    public Serializable save(T entity) {
        return sessionFactory.getCurrentSession().save(entity);
    }

    @Override
    public void update(T entity) {
        sessionFactory.getCurrentSession().update(entity);
    }

    @Override
    public void delete(T entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    @Override
    public void delete(Class<T> entity, Serializable id) {
        sessionFactory.getCurrentSession().createQuery("delete "+entity.getSimpleName()+" en where en.id = ?0")
                .setParameter("0",id)
                .executeUpdate();
    }

    @Override
    public List<T> findAll(Class<T> entity) {
        return find("select en from "+entity.getSimpleName()+" en");
    }

    @Override
    public long findCount(Class<T> entity) {
        List<?> list=find("select count(*) from "+entity.getSimpleName());
        if(list!=null&&list.size()==1){
            return (Long)list.get(0);
        }
        return 0;
    }


    //根据hql查询实体
    public List<T> find(String hql){
        return (List<T>)sessionFactory.getCurrentSession().createQuery(hql).list();
    }

    //根据带占位符参数的hql语句查询实体
    public List<T> find(String hql,Object... params){
        Query query=sessionFactory.getCurrentSession().createQuery(hql);
        for(int i=0,len=params.length;i<len;i++){
            query.setParameter(i+"",params[i]);
        }
        return (List<T>)query.list();
    }

    /**
     * 使用不带占位符的hql分页查询
     * @param hql 需要查询的hql语句
     * @param pageNo 查询第pageNo页的记录
     * @param pageSize 每页需要显示的记录数
     * @return 当前页的所有记录
     */
    public List<T> findByPage(String hql,int pageNo,int pageSize){
        return sessionFactory.getCurrentSession()
                .createQuery(hql)
                .setFirstResult((pageNo-1)*pageSize)
                .setMaxResults(pageSize)
                .list();
    }

    /**
     * 使用带占位符的hql分页查询
     * @param hql 需要查询的hql语句
     * @param pageNo 查询第pageNo页的记录
     * @param pageSize 每页需要显示的记录数
     * @param params 占位符参数
     * @return 当前页的所有记录
     */
    public List<T> findByPage(String hql,int pageNo,int pageSize,Object... params){
        Query query=sessionFactory.getCurrentSession().createQuery(hql);
        for(int i=0,len=params.length;i<len;i++){
            query.setParameter(i,params[i]);
        }
        return query.setFirstResult((pageNo-1)*pageSize)
                .setMaxResults(pageSize)
                .list();
    }
}
