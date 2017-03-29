package cn.mk95.www.action;

import com.opensymphony.xwork2.ActionSupport;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by YangYongHao on 2017/3/28.
 * Annotation:
 */
public class LoginAndRegister extends ActionSupport{

    public String register(){
        System.out.println("-------------register-------------");
        return ActionSupport.SUCCESS;
    }

    public String login(){
        System.out.println("-------------login-------------");

        return ActionSupport.SUCCESS;
    }

    @Test
    public void test(){
        //ApplicationContext ac2=new ClassPathXmlApplicationContext("y_springConfig.xml");
        ApplicationContext ac = new FileSystemXmlApplicationContext("/web/WEB-INF/applicationContext.xml");
    }
}
