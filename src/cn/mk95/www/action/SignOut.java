package cn.mk95.www.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

/**
 * Created by YangYongHao on 2017/4/6.
 * Annotation:
 */
public class SignOut extends ActionSupport {
    @Override
    public String execute() throws Exception {
        ServletActionContext.getRequest().getSession().removeAttribute("user");
        return ActionSupport.SUCCESS;
    }
}
