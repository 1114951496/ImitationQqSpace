package cn.mk95.www.bean;

import java.sql.Timestamp;

/**
 * Created by yangyonghao on 2017/3/12.
 * Time:21:39.
 */
public class EmailyzEntity {
    private String email;
    private int yzm;
    private Timestamp sendtime;
    private Integer flag;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getYzm() {
        return yzm;
    }

    public void setYzm(int yzm) {
        this.yzm = yzm;
    }

    public Timestamp getSendtime() {
        return sendtime;
    }

    public void setSendtime(Timestamp sendtime) {
        this.sendtime = sendtime;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmailyzEntity that = (EmailyzEntity) o;

        if (yzm != that.yzm) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (sendtime != null ? !sendtime.equals(that.sendtime) : that.sendtime != null) return false;
        if (flag != null ? !flag.equals(that.flag) : that.flag != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = email != null ? email.hashCode() : 0;
        result = 31 * result + yzm;
        result = 31 * result + (sendtime != null ? sendtime.hashCode() : 0);
        result = 31 * result + (flag != null ? flag.hashCode() : 0);
        return result;
    }
}
