package cn.mk95.www.tag;

import cn.mk95.www.bean.UserEntity;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by 睡意朦胧 on 2017/4/16.
 */
public class SessArray extends SimpleTagSupport{
    private ArrayList Arr;
    private UserEntity user;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public void setArr(ArrayList arr) {
        Arr = arr;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter jspWriter = getJspContext().getOut();
        HttpSession session= ServletActionContext.getRequest().getSession();
        Arr=(ArrayList) session.getAttribute("users");
        jspWriter.println("<table style=''>");
        for (int i=0;i<Arr.size();i++){
            user= (UserEntity) Arr.get(i);
            jspWriter.println("<tr>");
            jspWriter.println("<td>"+user.getUserid()+"</td>");
            jspWriter.println("<td>"+user.getUsername()+"</td>");
            jspWriter.println("<td><a href=delectfriend.action?id="+user.getUserid()+">删除</a></td>");
            jspWriter.println("</tr>");
        }
        jspWriter.println("</table>");
    }
}
