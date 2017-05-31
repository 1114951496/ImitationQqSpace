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
<body style="overflow-x: hidden">
<%@include file="../default_nav.jsp" %>

<div class="row">
    <div class="col-md-2">
    </div>
    <div class="col-md-8">
        <div>
            <label style="font-size: 25px;align-self: center">${session.requestNoteTitle}</label>

            <div style="background-color: #d5d5d5;">
                <div style="font-size: 18px;">${session.requestNoteContent}</div>
            </div>

        </div>
        <div style="text-align: center;">
            <button onclick="goLove()"><img src="../../res/img/love1.png" id="love" style="width: 100px;height: 100px">
            </button>
        </div>
        <!--高速版-->
        <div id="SOHUCS" sid="${session.sid}"></div>
        <script charset="utf-8" type="text/javascript" src="http://changyan.sohu.com/upload/changyan.js"></script>
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

<script>
    function goLove() {
        var id = ${request.id};
        if (window.XMLHttpRequest) {
            xmlhttp = new XMLHttpRequest();
        } else if (window.ActiveXObject) {
            try {
                xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
            } catch (e) {
                try {
                    xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
                } catch (e) {
                    window.alert("你的浏览器不支持ajax");
                }
            }
        }
        //alert("准备发送请求");

        xmlhttp.open("get", "/loveNote?id=" + id, true);
        xmlhttp.send(null);
        //alert("已发送请求！");
        xmlhttp.onreadystatechange = function () {
            var r = xmlhttp.readyState;
            if (r == 4) {
                if (xmlhttp.status == 200) {
                    //alert("请求已送达！");
                    responContent = xmlhttp.responseText.toString();
                    if (responContent == 1) {
                        alert("点赞成功！");
                        var love = $("#love");
                        love.attr('src',"../../res/img/love2.png") ;
                        love.removeAttr('onclick');
                    } else if (responContent == 0) {
                        alert("点赞失败！");
                    } else if (responContent == 2) {
                        alert("你已经点过赞了，不能再点赞!");
                    } else {
                        alert("出现未知错误。。。");
                    }
                }
            }
        }
    }
</script>


<script src="../../res/js/jquery.min.js"></script>
<%@include file="/WEB-INF/default_ft.jsp" %>
<script src="../../res/js/bootstrap.min.js"></script>
</body>
</html>
