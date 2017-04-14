package cn.mk95.www.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by YangYongHao on 2017/4/12.
 * Annotation:
 */
public class WriteNote extends ActionSupport {
    private String title;
    private String note;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String execute() throws Exception {
        //用户登录认证
        return ActionSupport.SUCCESS;
    }

    public String upNote(){
        System.out.println(title+"\n  >>>"+note);
        return ActionSupport.SUCCESS;
    }
}
