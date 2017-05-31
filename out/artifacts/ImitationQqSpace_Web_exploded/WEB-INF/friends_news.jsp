<%--
  Created by IntelliJ IDEA.
  User: LU
  Date: 2017/5/30
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="y" uri="/WEB-INF/y_tag.tld" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>朋友圈</title>
    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">

    <link href="../../res/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../res/css/navigation.css" rel="stylesheet">

    <script type="text/javascript">
        $(document).ready(function(){
            var range = 50;             //距下边界长度/单位px
            var elemt = 500;           //插入元素高度/单位px
            var maxnum = 10;            //设置加载最多次数
            var num = 1;
            var totalheight = 0;
            var main = $("#content");                     //主体元素
            $(window).scroll(function(){
                var srollPos = $(window).scrollTop();    //滚动条距顶部距离(页面超出窗口的高度)

                //console.log("滚动条到顶部的垂直高度: "+$(document).scrollTop());
                //console.log("页面的文档高度 ："+$(document).height());
                //console.log('浏览器的高度：'+$(window).height());

                totalheight = parseFloat($(window).height()) + parseFloat(srollPos);
                if(($(document).height()-range) <= totalheight  && num != maxnum) {
                    main.append("hello");
                    num++;
                }
                //ajax传值pageNo
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
                xmlhttp.open("post", "../../FriendNewsPage.action?pageNo=" + num, true);
                xmlhttp.send(null);
                //alert("已发送请求！");
                xmlhttp.onreadystatechange = function () {
                    var r = xmlhttp.readyState;
                    if (r == 4) {
                        if (xmlhttp.status == 200) {
                            //alert("请求已送达！");
                            responContent = xmlhttp.responseText.toString();
                            if (responContent != null) {
                                alert(responContent);
                            } else {
                                alert("出现未知错误。。。");
                            }
                        }
                    }
                }
            });
        });
    </script>
</head>
<body>
<%@include file="./h_person/MyPage.jsp"%>
<div class="container-fluid">
    <div class="col-md-2"></div>
    <div class="col-md-8">

    </div>
    <div class="col-md-2"></div>
</div>

<%@include file="./default_ft.jsp"%>
<script src="../../res/js/jquery.min.js"></script>
<script src="../../res/js/bootstrap.min.js"></script>

</body>
</html>
