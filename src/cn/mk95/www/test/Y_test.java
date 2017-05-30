package cn.mk95.www.test;

import cn.mk95.www.dao.NoteDaoImpl;
import cn.mk95.www.interfaces.CommentDao;
import cn.mk95.www.interfaces.NoteDao;
import cn.mk95.www.interfaces.UserDao;
import cn.mk95.www.service.NoteService;
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
        NoteDao noteDao= (NoteDao) ac.getBean("noteDao");
        NoteService noteService=new NoteService();
        //noteService.newNoteListToDynamicList(1,5,noteDao);

    }
}
