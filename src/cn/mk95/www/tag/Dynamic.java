package cn.mk95.www.tag;

import cn.mk95.www.bean.HomeDynamic;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by YangYongHao on 2017/4/7.
 * Annotation:该自定义标签基于bootstrap.min.css和bootstrap-theme.min.css，
 * 应以<div class="container-fluid"><div class="row">包围该标签
 * 用于网站主页动态显示模板,每次调用显示一行
 * 预设鼠标over和leave事件名称如下：
 * onmouseover="myDongtaiModuleMouseover(this)"
 * onmouseleave="myDongtaiModuleMouseleave(this)"
 * 预设动态class：
 * <div class="myDongtaiModule"></div>
 */
public class Dynamic extends SimpleTagSupport {
    private int row;    //一行显示的数据个数,标签属性，必需
    private int page;        //当前行，标签属性，必需
    private int type;   //获取的动态类型，标签属性，必需  1：最新动态  2：热门动态

    public void setType(int type) {
        this.type = type;
    }

    private ArrayList<HomeDynamic> homeDynamics = new ArrayList<>();  //主页动态

    public void setRow(int row) {
        this.row = row;
    }

    public void setPage(int page) {
        this.page = page;
    }


    @Override
    public void doTag() throws JspException, IOException {
        int num = 12 / row;
        String itemClassName = "col-md-" + num;
        JspWriter jspWriter = getJspContext().getOut();
        jspWriter.println("<div class=\"container-fluid\"><div class=\row\">");
        for (int i = 0; i < row; i++) {
            if (homeDynamics.size()>i&&homeDynamics.get(i) != null) {
                jspWriter.println(
                        "<!--单个动态模板,定义每行" + row + "条数据-->\n" +
                                "                                    <div class=\"" + itemClassName + "\">\n" +
                                "                                        <div class=\"myDongtaiModule\" onmouseover=\"myDongtaiModuleMouseover(this)\"\n" +
                                "                                             onmouseleave=\"myDongtaiModuleMouseleave(this)\">\n" +
                                "                                            <!--动态头-->\n" +
                                "                                            <div class=\"container-fluid\">\n" +
                                "                                                <div class=\"row\">\n" +
                                "                                                    <div class=\"col-md-5\">\n" +
                                "                                                        <a href=\"" + homeDynamics.get(i).getUserUrl() + "\"><img src=\"" + homeDynamics.get(i).getImgUrl() + "\" class=\"img-circle\"\n" +
                                "                                                                         style=\"width:85px;padding-top: 3px\"/></a>\n" +
                                "                                                    </div>\n" +
                                "                                                    <div class=\"col-md-7\">\n" +
                                "                                                        <h4>ID:" + homeDynamics.get(i).getId() + "</h4>\n" +
                                "                                                        <h4>Name:" + homeDynamics.get(i).getName() + "</h4>\n" +
                                "                                                    </div>\n" +
                                "                                                </div>\n" +
                                "                                            </div>\n" +
                                "                                            <!--动态内容-->\n" +
                                "                                            <div style=\"display: block;margin-top: 10px\" class=\"myDongtaiContent\">\n" +
                                "                                                <span style=\"font-weight: 900;font-size: 30px\">“</span>\n" +
                                "                                                <a href=\"" + homeDynamics.get(i).getContentUrl() + "\" style=\"font-size: 20px\">" + homeDynamics.get(i).getDynamicContent() +
                                "                                                </a>\n" +
                                "                                                <span style=\"font-weight: 900;font-size: 30px\">...”</span>\n" +
                                "                                            </div>\n" +
                                "                                        </div>\n" +
                                "                                    </div>");
            } else {
                jspWriter.println("<div class=\"" + itemClassName + "\">\n" + "</div>");
            }

        }
        jspWriter.println("</div></div>");
    }

    public void getDynamic() {

    }
}
