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
    </div>
    <div class="col-md-2">
    </div>
</div>


<%@include file="/WEB-INF/default_ft.jsp" %>
<script src="../../res/js/jquery.min.js"></script>
<script src="../../res/js/bootstrap.min.js"></script>
</body>
</html>
