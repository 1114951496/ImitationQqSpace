package cn.mk95.www.bean;

import java.sql.Timestamp;

/**
 * Created by yangyonghao on 2017/3/12.
 * Time:21:39.
 */
public class UserEntity {
    private int userid;
    private String username;
    private String usersex;
    private Timestamp registertime;
    private String email;
    private String sign;
    private String icon;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsersex() {
        return usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex;
    }

    public Timestamp getRegistertime() {
        return registertime;
    }

    public void setRegistertime(Timestamp registertime) {
        this.registertime = registertime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (userid != that.userid) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (usersex != null ? !usersex.equals(that.usersex) : that.usersex != null) return false;
        if (registertime != null ? !registertime.equals(that.registertime) : that.registertime != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (sign != null ? !sign.equals(that.sign) : that.sign != null) return false;
        if (icon != null ? !icon.equals(that.icon) : that.icon != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userid;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (usersex != null ? usersex.hashCode() : 0);
        result = 31 * result + (registertime != null ? registertime.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (sign != null ? sign.hashCode() : 0);
        result = 31 * result + (icon != null ? icon.hashCode() : 0);
        return result;
    }
}
