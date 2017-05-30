<%--
  Created by IntelliJ IDEA.
  User: YangYongHao
  Date: 2017/4/20
  Time: 9:06
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>readNote</title>
    <link href="../../res/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%@include file="../default_nav.jsp" %>

<div class="row">
    <div class="col-md-2">
    </div>
    <div class="col-md-8">
        <div>
            <label style="font-size: 25px;align-self: center" >${session.requestNoteTitle}</label>

            <div style="background-color: #d5d5d5">
                <div style="font-size: 18px;">${session.requestNoteContent}</div>
            </div>

        </div>

        <!--高速版-->
        <div id="SOHUCS" sid="${session.sid}"></div>
        <script charset="utf-8" type="text/javascript" src="http://changyan.sohu.com/upload/changyan.js" ></script>
        <script type="text/javascript">
            window.changyan.api.config({
                appid: 'cyt1cpgdM',
                conf: 'prod_53e7a72ffc50d07d1010adaf416443fc'
            });
        </script>
    </div>
    <div class="col-md-2">
    </div>
</div>


<%@include file="/WEB-INF/default_ft.jsp" %>
<script src="../../res/js/jquery.min.js"></script>
<script src="../../res/js/bootstrap.min.js"></script>
</body>
</html>
