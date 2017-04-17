<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by yangyonghao
  Date: 2017/2/27
  Time: 11:15
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="res/css/login.css"/>
    <script src="res/js/login.js"></script>
</head>
<body>
<div id="user">
    <h1 id="title">Login</h1>

    <form id="tjform" action="login" method="post">
        <div id="registerCon">
            <input type="text" placeholder="用户名" name="user.username" id="username"></input>
            <input type="password" placeholder="密码" name="user.password" id="userpassword"></input>
            <input type="text" placeholder="邮箱" name="user.email" id="email"></input>
            <input type="text" placeholder="6位验证码" name="yzm" style="display: inline;width: 153px" id="yzm"></input>
            &nbsp;<button class="but" type="button" style="width: auto;display: inline;" onclick="yz(this)" onmousedown="btDown(this)" onmouseup="btUp(this)">获取验证码</button>
            <button class="but" type="button" onclick="Register()" onmousedown="btDown(this)" onmouseup="btUp(this)" style="width: 100%">注册</button>
        </div>
        <div id="loginCon">
            <input type="text" placeholder="用户id" name="loginid" id="loginid"></input>
            <input type="password" placeholder="密码" name="loginpwd" id="loginpwd"></input>
            <button class="but" type="button" onclick="Login()" onmousedown="btDown(this)" onmouseup="btUp(this)">登录</button>
            <button class="but" type="button" onmousedown="btDown(this)" onmouseup="btUp(this)">忘记密码</button>
        </div>
    </form>
    <span id="logORreg" onclick="logORreg(this)">>>注册</span>
</div>
</body>
</html>
