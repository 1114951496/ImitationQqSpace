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
    private ArrayList<UserEntity> Arr=new ArrayList<>();
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
        Arr=(ArrayList<UserEntity>) session.getAttribute("users");
        user= (UserEntity) session.getAttribute("selectfriend");
        if (user==null) {
            jspWriter.println("<form action=\"selectfriend\" method=\"get\">");
            jspWriter.println("搜索: <input type=\"text\" name=\"fname\" />");
            jspWriter.println("<input type=\"submit\" value=\"Submit\" />");
            jspWriter.println("<table class=\"altrowstable\" id=\"alternatecolor\">");
            jspWriter.println("<tr>");
            jspWriter.println("<th>" + "好友ID" + "</th>");
            jspWriter.println("<th>" + "好友名字" + "</th>");
            jspWriter.println("<th>" + "是否删除好友" + "</th>");
            jspWriter.println("<th>" + "是否进入" + "</th>");
            jspWriter.println("</tr>");
            for (int i = 0; i < Arr.size(); i++) {
                user = (UserEntity) Arr.get(i);
                jspWriter.println("<tr>");
                jspWriter.println("<td>" + user.getUserid() + "</td>");
                jspWriter.println("<td>" + user.getUsername() + "</td>");
                jspWriter.println("<td><a href=delectfriend?friendid=" + user.getUserid() + ">删除</a></td>");
                jspWriter.println("<td><a href=infriend?friendid=" + user.getUserid() + ">进入好友空间</a></td>");
                jspWriter.println("</tr>");
            }
            jspWriter.println("</table>");
        }else{
            jspWriter.println("<table class=\"altrowstable\" id=\"alternatecolor\">");
            jspWriter.println("<tr>");
            jspWriter.println("<th>" + "好友ID" + "</th>");
            jspWriter.println("<th>" + "好友名字" + "</th>");
            jspWriter.println("<th>" + "是否删除好友" + "</th>");
            jspWriter.println("<th>" + "是否进入" + "</th>");
            jspWriter.println("</tr>");
            jspWriter.println("<tr>");
            jspWriter.println("<td>" + user.getUserid() + "</td>");
            jspWriter.println("<td>" + user.getUsername() + "</td>");
            if (Arr.indexOf(user)==-1){
                jspWriter.println("<td><a href=addfriend>加为好友</a></td>");
            }else {
                jspWriter.println("<td><a href=delectfriend?friendid=" + user.getUserid() + ">删除</a></td>");
                jspWriter.println("<td><a href=infriend?friendid=" + user.getUserid() + ">进入好友空间</a></td>");
            }
            jspWriter.println("</tr>");
            jspWriter.println("</table>");
        }
    }
}
