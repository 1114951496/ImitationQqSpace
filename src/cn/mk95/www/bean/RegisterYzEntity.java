package cn.mk95.www.bean;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by YangYongHao on 2017/3/29.
 * Annotation:
 */
@Entity
@Table(name = "register_yz", schema = "easyspace", catalog = "")
public class RegisterYzEntity {
    private String registerEmail;
    private int yzm;
    private int flag;
    private Timestamp sendTime;

    @Id
    @Column(name = "register_email", nullable = false, length = 20)
    public String getRegisterEmail() {
        return registerEmail;
    }

    public void setRegisterEmail(String registerEmail) {
        this.registerEmail = registerEmail;
    }

    @Basic
    @Column(name = "yzm", nullable = false)
    public int getYzm() {
        return yzm;
    }

    public void setYzm(int yzm) {
        this.yzm = yzm;
    }

    @Basic
    @Column(name = "flag", nullable = false)
    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Basic
    @Column(name = "sendTime", nullable = false)
    public Timestamp getSendTime() {
        return sendTime;
    }

    public void setSendTime(Timestamp sendTime) {
        this.sendTime = sendTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegisterYzEntity that = (RegisterYzEntity) o;

        if (yzm != that.yzm) return false;
        if (flag != that.flag) return false;
        if (registerEmail != null ? !registerEmail.equals(that.registerEmail) : that.registerEmail != null)
            return false;
        if (sendTime != null ? !sendTime.equals(that.sendTime) : that.sendTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = registerEmail != null ? registerEmail.hashCode() : 0;
        result = 31 * result + yzm;
        result = 31 * result + flag;
        result = 31 * result + (sendTime != null ? sendTime.hashCode() : 0);
        return result;
    }
}
