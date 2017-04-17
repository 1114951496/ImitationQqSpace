package cn.mk95.www.tag;

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

    public void setArr(ArrayList arr) {
        Arr = arr;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter jspWriter = getJspContext().getOut();
        HttpSession session= ServletActionContext.getRequest().getSession();
        Arr=(ArrayList) session.getAttribute("usernames");
        jspWriter.println("<ul>");
        for (int i=0;i<Arr.size();i++){
            jspWriter.println("<li>"+Arr.get(i)+"</li>");
        }
        jspWriter.println("</ul>");
    }
}
