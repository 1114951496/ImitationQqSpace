<%--
  Created by IntelliJ IDEA.
  User: 睡意朦胧
  Date: 2017/5/24
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="y" uri="/WEB-INF/y_tag.tld" %>
<%@taglib prefix="h" uri="/WEB-INF/h_tag.tld" %>
<html>
<head>
    <title>相册</title>
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
            <s:if test="#session.Muser.userid==#session.user.userid">
                <s:form action="addphoto" enctype="multipart/form-data" method="POST">
                    <s:file name="file" lable="选择文件"/>
                    <s:fielderror/>
                    <s:submit value="图片上传"/>
                </s:form>
            </s:if>
            <table style="text-align: center">
                <s:iterator value="#session.albums" id="album">
                    <tr>
                        <td><s:property value="#album"/></td>
                        <td><img src="<s:property value='#album'/>"> </td>
                    </tr>
                </s:iterator>
            </table>
        </div>
        <div class="col-md-2"></div>
    </div>
    <%@include file="../default_ft.jsp"%>
    <script src="../../res/js/jquery.min.js"></script>
    <script src="../../res/js/bootstrap.min.js"></script>
</body>
</html>
