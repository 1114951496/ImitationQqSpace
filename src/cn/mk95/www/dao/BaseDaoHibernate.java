package cn.mk95.www.dao;

import cn.mk95.www.interfaces.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

/**
 * Created by YangYongHao on 2017/3/29.
 * Annotation:
 */
public class BaseDaoHibernate<T> implements BaseDao<T> {

    private SessionFactory sessionFactory;

    private Transaction transaction;

    public Session init() {
        try {
            setSession(getSessionFactory().getCurrentSession());
            setTransaction(getSession().beginTransaction());
        }catch (Exception e){

        }
        return session;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    private Session session;

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Transaction getTransaction() {
        return transaction;
    }


    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Override
    public T get(Class<T> entity, Serializable id) {
        //Session session = getSessionFactory().getCurrentSession();
//        try {
//            Transaction transaction = session.beginTransaction();
//            return session.get(entity, id);
//        } catch (Exception e) {
        return session.get(entity, id);
        // }
    }

    @Override
    public Serializable save(T entity) {
        //Session session = getSessionFactory().getCurrentSession();
        //Transaction transaction = session.beginTransaction();
        Serializable serializable = session.save(entity);
        transaction.commit();
        return serializable;
    }

    @Override
    public void update(T entity) {
        // Session session = getSessionFactory().getCurrentSession();
        //Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
    }

    @Override
    public void delete(T entity) {
        //Session session = getSessionFactory().getCurrentSession();
        //Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
    }

    @Override
    public void delete(Class<T> entity, Serializable id) {
        //Session session = getSessionFactory().getCurrentSession();
        //Transaction transaction = session.beginTransaction();
        session.createQuery("delete " + entity.getSimpleName() + " en where en.id = ?")
                .setParameter("0", id)
                .executeUpdate();
        transaction.commit();
    }

    @Override
    public List<T> findAll(Class<T> entity) {
        return find("select en from " + entity.getSimpleName() + " en");
    }

    @Override
    public long findCount(Class<T> entity) {
        List<?> list = find("select count(*) from " + entity.getSimpleName());
        if (list != null && list.size() == 1) {
            return (Long) list.get(0);
        }
        return 0;
    }


    //根据hql查询实体
    public List<T> find(String hql) {
        //Session session = getSessionFactory().getCurrentSession();
        return (List<T>) session.createQuery(hql).list();
    }

    //根据带占位符参数的hql语句查询实体
    public List<T> find(String hql, Object... params) {
        //Session session = getSessionFactory().getCurrentSession();
        //Transaction transaction = session.beginTransaction();
        Query query = session.createQuery(hql);
        for (int i = 0, len = params.length; i < len; i++) {
            query.setParameter(i, params[i]);
        }
        List<T> list = (List<T>) query.list();
        return list;
    }

    /**
     * 使用不带占位符的hql分页查询
     *
     * @param hql      需要查询的hql语句
     * @param pageNo   查询第pageNo页的记录
     * @param pageSize 每页需要显示的记录数
     * @return 当前页的所有记录
     */
    public List<T> findByPage(String hql, int pageNo, int pageSize) {
        //Session session = getSessionFactory().getCurrentSession();
        return session.createQuery(hql)
                .setFirstResult((pageNo - 1) * pageSize)
                .setMaxResults(pageSize)
                .list();
    }

    /**
     * 使用带占位符的hql分页查询
     *
     * @param hql      需要查询的hql语句
     * @param pageNo   查询第pageNo页的记录
     * @param pageSize 每页需要显示的记录数
     * @param params   占位符参数
     * @return 当前页的所有记录
     */
    public List<T> findByPage(String hql, int pageNo, int pageSize, Object... params) {
        //Session session = getSessionFactory().getCurrentSession();
        //Transaction transaction = session.beginTransaction();
        Query query = session.createQuery(hql);
        for (int i = 0, len = params.length; i < len; i++) {
            query.setParameter(i, params[i]);
        }
        return query.setFirstResult((pageNo - 1) * pageSize)
                .setMaxResults(pageSize)
                .list();
    }
}
