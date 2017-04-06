package cn.mk95.www.action;

import cn.mk95.www.bean.RegisterYzEntity;
import cn.mk95.www.interfaces.RegisterYzDao;
import cn.mk95.www.util.EmailUtil;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by YangYongHao on 2017/4/1.
 * Annotation:
 */

public class SendYzm extends ActionSupport {
    private EmailUtil emailUtil;
    private RegisterYzDao registerYzDao;

    public RegisterYzDao getRegisterYzDao() {
        return registerYzDao;
    }

    public void setRegisterYzDao(RegisterYzDao registerYzDao) {
        this.registerYzDao = registerYzDao;
    }

    public EmailUtil getEmailUtil() {
        return emailUtil;
    }

    public void setEmailUtil(EmailUtil emailUtil) {
        this.emailUtil = emailUtil;
    }

    public String sendYzm() {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response=ServletActionContext.getResponse();
        String email = request.getParameter("email");
        RegisterYzEntity registerYzEntity = registerYzDao.findByEmail(email);
        try {
            PrintWriter writer=response.getWriter();
            if (registerYzEntity == null || (registerYzEntity != null && emailUtil.timeComparator(registerYzEntity.getSendTime(), 2))) {
                if(registerYzEntity==null)
                    registerYzEntity=new RegisterYzEntity();
                int yzm=emailUtil.getYZM();
                emailUtil.sendSystemEmail(email, "注册", ""+yzm);
                registerYzEntity.setRegisterEmail(email);
                registerYzEntity.setYzm(yzm);
                Date date=Calendar.getInstance().getTime();
                Timestamp timestamp=new Timestamp(date.getTime());
                registerYzEntity.setSendTime(timestamp);
                if(registerYzEntity==null)
                    registerYzDao.save(registerYzEntity);
                else
                    registerYzDao.update(registerYzEntity);
                writer.print("send success!");
            }
            else {
                writer.print("send error!send time>2m?");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ActionSupport.ERROR;
    }
}
