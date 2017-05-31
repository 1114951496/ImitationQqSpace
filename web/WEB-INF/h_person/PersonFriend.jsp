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
    <script type="text/javascript">
        function altRows(id){
            if(document.getElementsByTagName){

                var table = document.getElementById(id);
                var rows = table.getElementsByTagName("tr");

                for(i = 0; i < rows.length; i++){
                    if(i % 2 == 0){
                        rows[i].className = "evenrowcolor";
                    }else{
                        rows[i].className = "oddrowcolor";
                    }
                }
            }
        }

        window.onload=function(){
            altRows('alternatecolor');
        }
    </script>


    <!-- CSS goes in the document HEAD or added to your external stylesheet -->
    <style type="text/css">
        table.altrowstable {
            padding: 0px;
            margin-top: 3px;
            font-family: verdana,arial,sans-serif;
            font-size:11px;
            color:#333333;
            border-width: 1px;
            border-color: #a9c6c9;
            border-collapse: collapse;
            width: 100%;
        }
        table.altrowstable th {
            padding: 0;
            border-color: #a9c6c9;
            font-size: 15px;
        }
        table.altrowstable td {
            padding: 0;
            border-color: #a9c6c9;
            font-size: 15px;
            text-align: center;
        }
        .oddrowcolor{
            background-color:#d4e3e5;
        }
        .evenrowcolor{
            background-color:#c3dde0;
        }
    </style>
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
