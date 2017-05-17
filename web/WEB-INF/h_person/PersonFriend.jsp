<%--
  Created by IntelliJ IDEA.
  User: 睡意朦胧
  Date: 2017/4/16
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="y" uri="/WEB-INF/y_tag.tld" %>
<%@taglib prefix="h" uri="/WEB-INF/h_tag.tld" %>
<html>
<head>
    <title>好友</title>
    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">

    <link href="../../res/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../res/css/navigation.css" rel="stylesheet">
</head>
<body>
    <%@include file="MyPage.jsp"%>
    <div class="container-fluid">
        <div class="col-md-2"></div>
        <div class="col-md-8">
            <h:SessArray />
        </div>
        <div class="col-md-2"></div>
    </div>
    <%@include file="../default_ft.jsp"%>
    <script src="../../res/js/jquery.min.js"></script>
    <script src="../../res/js/bootstrap.min.js"></script>
</body>
</html>
