<%--
  Created by IntelliJ IDEA.
  User: 睡意朦胧
  Date: 2017/4/12
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="y" uri="/WEB-INF/y_tag.tld" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>个人主页</title>

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">

    <link href="../../res/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../res/css/navigation.css" rel="stylesheet">
</head>
<body>
<%@include file="../default_nav.jsp" %>

<!--个人信息-->
<div class="container-fluid">
    <div class="row">
        <div class="col-md-2">
        </div>
        <div class="col-md-8">
            <!--头像-->
            <div class="col-md-3">
                <div style="text-align: center">
                <a href="#"><img src="../../res/img/defPhoto.jpg" class="img-circle" style="width: 120px;margin-top: 30px"></a>
                </div>
            </div>
            <!--人物信息-->
            <div class="col-md-9">
            </div>
            <div style="position: relative;left: -20px;top: 28px">
                <ul style="list-style: none;padding-top: 50px;font-size: 13px">
                    <li>姓名:<s:property value="#session.Muser.username"/></li>
                    <li>性别:<s:property value="#session.Muser.usersex"/></li>
                    <li>email:<s:property value="#session.Muser.email"/></li>
                    <li>个性签名:<s:property value="#session.Muser.sign"/></li>
                </ul>
            </div>
        </div>
        <div class="col-md-2">
        </div>
    </div>
</div>

<!--导航栏-->
<s:if test="#session.Muser.userid==#session.user.userid">
<div class="container-fluid">
    <div class="row">
        <div class="col-md-2">
        </div>
        <div id="nav" class="col-md-8" style="padding:0;margin-top: 13px;margin-bottom: 15px;background-color:#cccccc;font-size: 20px">

                <a href="home" class="col-lg-2" >主页</a>
                <a href="MyFriend" class="col-lg-2" >好友</a>
                <a href="friendnews" class="col-lg-3" >朋友圈</a>
                <a href="Album" class="col-lg-2" >相册</a>
                <a href="CheckMessage" class="col-lg-3" >留言板</a>
        </div>
        <div class="col-md-2">
        </div>
    </div>
</div>

</s:if>
<s:else>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-2">
            </div>
            <div id="nav" class="col-md-8" style="padding:0;margin-top: 13px;background-color:#cccccc;font-size: 20px">
                <a href="home" class="col-lg-4" >主页</a>
                <a href="#" class="col-lg-4" >相册</a>
                <a href="CheckMessage" class="col-lg-4" >留言板</a>
            </div>
            <div class="col-md-2">
            </div>
        </div>
    </div>
</s:else>
<!---<%@include file="../default_ft.jsp" %>-->
<script src="../../res/js/jquery.min.js"></script>
<script src="../../res/js/bootstrap.min.js"></script>
</body>
</html>
