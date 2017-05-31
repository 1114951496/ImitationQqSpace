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
            border-color: #a9c6c9;
            font-size: 15px;
            text-align: center;
        }
        table.altrowstable td {
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
        <s:if test="#session.Messages==null">没有留言</s:if>
        <s:else>
            <table class="altrowstable" id="alternatecolor">
                <tr>
                    <th>留言者ID </th>
                    <th>留言 </th>
                    <th>留言时间 </th>
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
