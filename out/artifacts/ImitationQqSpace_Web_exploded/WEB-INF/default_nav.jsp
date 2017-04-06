<%--
  Created by IntelliJ IDEA.
  User: YangYongHao
  Date: 2017/3/29
  Time: 9:08
  Annotation: 使用<%@include file="WEB-INF/default_nav.jsp"%>方式include该文件时，需要添加如下文件引用:
                1)<link href="res/css/bootstrap.min.css" rel="stylesheet">
                2)<script src="res/js/jquery.min.js"></script>
                3)<script src="res/js/bootstrap.min.js"></script>
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="y" uri="WEB-INF/y_tag.tld" %>
<html>
<head>
    <title>default_nav</title>
    <style>
        body {
            background: #c4e3f3;
        }
    </style>
</head>

<body>

<!--网站主页顶部黑色导航条-->
<div class="container-fluid" style="margin: 0;padding: 0;">
    <div class="row">
        <div class="col-md-12">
            <nav class="navbar-default navbar-inverse" role="navigation">
                <div class="navbar-header" style="height: 50px">
                    <button type="button" class="navbar-toggle" data-toggle="collapse"
                            data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span
                            class="icon-bar"></span><span class="icon-bar"></span>
                    </button>
                    <div style="margin-left: 50px;margin-right: 50px;text-align:center;vertical-align:middle;height: 50px;width: 50px">
                        <img href="index.jsp" src="res/img/logo.png" style="height: 50px;width: 50px;"/>
                    </div>
                </div>

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="active">
                            <a href="#">主页</a>
                        </li>
                        <li>
                            <a href="#">声明</a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">其他<strong
                                    class="caret"></strong></a>
                            <ul class="dropdown-menu">

                                <li>
                                    <a href="#">开发团队</a>
                                </li>
                                <li>
                                    <a href="#">联系我们</a>
                                </li>
                                <li>
                                    <a href="https://github.com/1114951496/ImitationQqSpace">GitHub</a>
                                </li>
                                <%--<li class="divider">--%>
                                <%--</li>--%>
                                <%--<li>--%>
                                <%--<a href="#"></a>--%>
                                <%--</li>--%>
                            </ul>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <y:isLogin/>
                        <!--   <li>
                               <a href="#">Link</a>
                           </li>
                           <li class="dropdown">
                               <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown<strong
                                       class="caret"></strong></a>
                               <ul class="dropdown-menu">
                                   <li>
                                       <a href="#">Action</a>
                                   </li>
                                   <li>
                                       <a href="#">Another action</a>
                                   </li>
                                   <li>
                                       <a href="#">Something else here</a>
                                   </li>
                                   <li class="divider">
                                   </li>
                                   <li>
                                       <a href="#">Separated link</a>
                                   </li>
                               </ul>
                           </li>  -->
                        <li style="padding-left: 40px;">
                        </li>
                    </ul>
                </div>
            </nav>
        </div>
    </div>
</div>
</body>
</html>
