package cn.mk95.www.tag;


import cn.mk95.www.bean.UserEntity;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created by YangYongHao on 2017/3/29.
 * Annotation:
 */
public class IsLogin extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        JspWriter jspWriter=getJspContext().getOut();
        HttpSession session = ServletActionContext.getRequest().getSession();
        UserEntity user = (UserEntity) session.getAttribute("user");
        if(user==null){
            jspWriter.println("<li><a href=\"login.jsp\">登录/注册</a></li>");
        }else{
            jspWriter.println("<li><a href=\"#\">"+user.getUsername()+"</a></li>");

            jspWriter.println("<li class=\"dropdown\">\n" +
                    "                            <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">Dropdown<strong\n" +
                    "                                    class=\"caret\"></strong></a>\n" +
                    "                            <ul class=\"dropdown-menu\">\n" +
                    "                                <li>\n" +
                    "                                    <a href=\"mypage\">我的空间</a>\n" +
                    "                                </li>\n" +
                    "                                <li>\n" +
                    "                                    <a href=\"#\">我的资料</a>\n" +
                    "                                </li>\n" +
                    "                                <li>\n" +
                    "                                    <a href=\"writeNote\">写note</a>\n" +
                    "                                </li>\n" +
                    "                                <li class=\"divider\">\n" +
                    "                                </li>\n" +
                    "                                <li>\n" +
                    "                                    <a href=\"signOut.action\">退出</a>\n" +
                    "                                </li>\n" +
                    "                            </ul>\n" +
                    "                        </li>");
        }

    }
}