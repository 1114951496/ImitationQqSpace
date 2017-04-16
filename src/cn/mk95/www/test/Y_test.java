package cn.mk95.www.test;

import cn.mk95.www.dao.NoteDaoImpl;
import cn.mk95.www.interfaces.CommentDao;
import cn.mk95.www.interfaces.NoteDao;
import cn.mk95.www.interfaces.UserDao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by YangYongHao on 2017/4/16.
 * Annotation:
 */
public class Y_test {
    @Test
    public void test1(){
        ApplicationContext ac=new FileSystemXmlApplicationContext("D:\\GitHub\\ImitationQqSpace\\web\\WEB-INF\\applicationContext.xml");
        NoteDao noteDao= (NoteDao) ac.getBean("noteDao");
        noteDao.countUserNote(1);
    }

    @Test
    public void test2(){
        ApplicationContext ac=new FileSystemXmlApplicationContext("D:\\GitHub\\ImitationQqSpace\\web\\WEB-INF\\applicationContext.xml");
        UserDao userDao= (UserDao) ac.getBean("userDao");
        userDao.init();
        userDao.findUserById(1);
    }

    @Test
    public void test3(){
        ApplicationContext ac=new FileSystemXmlApplicationContext("D:\\GitHub\\ImitationQqSpace\\web\\WEB-INF\\applicationContext.xml");
        NoteDao noteDao= (NoteDao) ac.getBean("noteDao");
        noteDao.init();
        System.out.println(noteDao.find("from NoteEntity"));
    }

    @Test
    public void test4(){
        ApplicationContext ac=new FileSystemXmlApplicationContext("D:\\GitHub\\ImitationQqSpace\\web\\WEB-INF\\applicationContext.xml");
        CommentDao commentDao= (CommentDao) ac.getBean("commentDao");
        Session session = commentDao.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.createQuery("from CommentEntity ");
        transaction.commit();
    }
}
