<%--
  Created by IntelliJ IDEA.
  User: 睡意朦胧
  Date: 2017/5/30
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="y" uri="/WEB-INF/y_tag.tld" %>
<%@taglib prefix="h" uri="/WEB-INF/h_tag.tld" %>
<html>
<head>
    <title>我的日志</title>
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
        <ul>
        <s:iterator value="#session.MnoteTitles" id="titles">
            <li><a href="#"><s:property value="#titles"/></a>  </li>
        </s:iterator>
            <li>
                <s:if test="#session.NotePageNo-1>0"><a href="home.action?NotePageNo=<s:property value='#session.NotePageNo-1'/> ">上一页</a></s:if>
                <s:if test="#session.NotePageNo+1<#session.MaxPages"><a href="home.action?NotePageNo=<s:property value='#session.NotePageNo+1'/>">下一页</a></s:if></li>
        </ul>

    </div>
    <div class="col-md-2"></div>
</div>
<%@include file="../default_ft.jsp"%>
<script src="../../res/js/jquery.min.js"></script>
<script src="../../res/js/bootstrap.min.js"></script>
</body>
</html>
