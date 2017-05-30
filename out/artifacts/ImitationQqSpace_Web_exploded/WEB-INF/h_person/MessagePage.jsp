<%--
  Created by IntelliJ IDEA.
  User: 睡意朦胧
  Date: 2017/5/3
  Time: 17:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="y" uri="/WEB-INF/y_tag.tld" %>
<%@taglib prefix="h" uri="/WEB-INF/h_tag.tld" %>
<html>
<head>
    <title>留言板</title>
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
        <s:if test="#session.Messages==null">没有留言</s:if>
        <s:else>
            <table style="text-align: center">
                <tr>
                    <td>留言者ID </td>
                    <td>留言 </td>
                    <td>留言时间 </td>
                </tr>
            <s:iterator value="#session.Messages" id="message">
                <tr>
                    <td><s:property value="#message.senduserid"/> </td>
                    <td><s:property value="#message.text"/> </td>
                    <td><s:property value="#message.sendtime"/> </td>
                </tr>
            </s:iterator>
            </table>
        </s:else>
            <form action="MessageInput">
                留言吗？<input type="text" value="输入留言" name="text" id="text">
                <button type="submit" value="留言">留言</button>
            </form>
        </div>
        <div class="col-md-2"></div>
    </div>
    <%@include file="../default_ft.jsp"%>
    <script src="../../res/js/jquery.min.js"></script>
    <script src="../../res/js/bootstrap.min.js"></script>
</body>
</html>
