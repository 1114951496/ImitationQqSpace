package cn.mk95.www.util;

import com.sun.mail.util.MailSSLSocketFactory;
import org.junit.Test;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

/**
 * Created by YangYongHao on 2017/3/28.
 * Annotation:
 */
public class EmailUtil {

    private InputStream in;

    public void sendSystemEmail(String sendTo, String subject, String content) throws IOException {
        Properties syspro = new Properties();
        try {
            in = getClass().getResourceAsStream("systemEmail.properties");
            syspro.load(in);

            //ssl认证
            MailSSLSocketFactory sslSocketFactory = new MailSSLSocketFactory();
            sslSocketFactory.setTrustAllHosts(true);
            syspro.put("mail.smtp.ssl.enable", "true");
            syspro.put("mail.smtp.ssl.socketFactory", sslSocketFactory);
            //构建授权信息，用于SMTP身份验证
            Authenticator authenticator = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    String user = syspro.getProperty("mail.user");
                    String password = syspro.getProperty("mail.password");
                    return new PasswordAuthentication(user, password);
                }
            };

            //使用环境属性和授权信息创建邮件会话
            Session mailSession = Session.getInstance(syspro, authenticator);
            //创建邮件消息
            MimeMessage message = new MimeMessage(mailSession);
            //设置发件人
            InternetAddress form = new InternetAddress(syspro.getProperty("mail.user"));
            message.setFrom(form);
            //设置收件人，应该可设置多个
            InternetAddress to = new InternetAddress(sendTo);
            message.setRecipient(MimeMessage.RecipientType.TO, to);

            message.setSubject(subject);
            message.setContent(content, "text/html;charset=UTF-8");
            Transport.send(message);
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("--------FileNotFoundException--------:" + e.getMessage());
            if (in != null)
                in.close();
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void sendSystemEmailTest() {
        try {
            new EmailUtil().sendSystemEmail("1114951496@qq.com", "测试", "<h1 style=\"background=#111111;\">这是测试邮件</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 与当前时间做对比，小于m分钟则返回true
     *
     * @param timestamp 与当前时间比较的时间
     * @param m         时间段（分钟）
     * @return 小于m分钟则返回true
     */
    public boolean timeComparator(Timestamp timestamp, int m) {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        date.setMinutes(date.getMinutes() - m);
        if (timestamp.before(date)) {
            return true;
        }
        return false;
    }

    public int getYZM() {
        Random random = new Random();
        String result = "";
        for (int i = 0; i < 6; i++) {
            result += random.nextInt(10);
        }
        int yzm=Integer.parseInt(result);
        if(yzm<100000)
            yzm=yzm+100000;
        return yzm;
    }

    @Test
    public void test(){
        System.out.println(getYZM());
    }

}
