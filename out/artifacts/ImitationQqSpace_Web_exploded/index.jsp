<%--
  Created by yangyonghao
  Date: 2017/3/12
  Time: 10:00
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="y" uri="/WEB-INF/y_tag.tld" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>简单空间</title>

    <link href="res/css/bootstrap.min.css" rel="stylesheet">
    <style>
        html {
            overflow-x: hidden;
        }

        body {
            background: #c4e3f3;
        }

        .index-top-img {
            width: 100%;
            height: 100%;
            object-fit: cover;
        }

        .myDongtaiModule {
            background: #A6FFA6;
            box-shadow: 1px 1px 2px #006000;
        }
    </style>
    <script>
        function myDongtaiModuleMouseover(obj) {
            obj.style.position = "relative";
            obj.style.top = "-2px";
            obj.style.left = "-1px";
            obj.style.boxShadow = "2px 2px 4px #006000";
        }
        function myDongtaiModuleMouseleave(obj) {
            obj.style.position = "";
            obj.style.top = "";
            obj.style.left = "";
            obj.style.boxShadow = "1px 1px 2px #006000";
        }
    </script>
</head>
<body>

<%@include file="WEB-INF/default_nav.jsp" %>

<s:if test="#request.flag==null">
    <% response.sendRedirect("/indexAction"); %>
</s:if>

<!--轮播图，中心8区域-->
<div class="container-fluid">
    <div class="row">
        <div class="col-md-2">
        </div>
        <div class="col-md-8">
            <div style="box-shadow: 2px 4px 6px #B15BFF;margin-top: 13px">
                <div class="carousel slide" id="carousel-948985">
                    <ol class="carousel-indicators">
                        <li class="active" data-slide-to="0" data-target="#carousel-948985">
                        </li>
                        <li data-slide-to="1" data-target="#carousel-948985">
                        </li>
                        <li data-slide-to="2" data-target="#carousel-948985">
                        </li>
                    </ol>
                    <div class="carousel-inner">
                        <%--style="height: 350px"--%>
                        <div class="item active">
                            <img alt="Carousel Bootstrap First" class="index-top-img"
                                 src="res/img/index1.jpg"/>
                            <div class="carousel-caption">
                                <!--style="position: absolute;top: 200px"-->
                                <h4 style="color: #F22929">
                                    欢迎光临easyspace
                                </h4>
                                <p style="color: #B15B22">
                                    床前明月光，疑是地上霜。
                                    举头望明月，低头思故乡。
                                </p>
                            </div>
                        </div>
                        <div class="item">
                            <img alt="Carousel Bootstrap Second" class="index-top-img"
                                 src="res/img/index2.jpg"/>
                            <div class="carousel-caption">
                                <h4 style="color: #F22929">
                                    一步一步走出明天的模样
                                </h4>
                                <p style="color: #B15B22">
                                    真是个不错的选择。
                                </p>
                            </div>
                        </div>
                        <div class="item">
                            <img alt="Carousel Bootstrap Third" class="index-top-img"
                                 src="res/img/index3.jpg"/>
                            <div class="carousel-caption">
                                <h4 style="color: #F22929">
                                    提莫队长正在报道
                                </h4>
                                <p style="color: #B15B22">
                                    QWERTYUIOPASDFGHJKLZXCVBNM
                                </p>
                            </div>
                        </div>
                    </div>
                    <a class="left carousel-control" href="#carousel-948985" data-slide="prev"><span
                            class="glyphicon glyphicon-chevron-left"></span></a>
                    <a class="right carousel-control" href="#carousel-948985" data-slide="next"><span
                            class="glyphicon glyphicon-chevron-right"></span></a>
                </div>
            </div>
        </div>
        <div class="col-md-2">
        </div>
    </div>
</div>

<!--动态,中心8区域-->
<div class="container-fluid">
    <div class="row">
        <div class="col-md-2">
        </div>
        <div class="col-md-8" style="margin-top: 13px">
            <div class="panel-group" id="panel-272678">
                <div class="panel-default">
                    <div class="panel-heading" style="margin-top: 5px">
                        <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-272678"
                           href="#collapse1">最新动态</a>
                    </div>
                    <div id="collapse1" class="panel-collapse collapse in">
                        <div class="panel-body">
                            <y:dynamic row="4" page="1" type="1"/>
                        </div>
                    </div>
                </div>
                <div class="panel-default">
                    <div class="panel-heading" style="margin-top: 5px">
                        <a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-272678"
                           href="#collapse2">热门动态</a>
                    </div>
                    <div id="collapse2" class="panel-collapse collapse in">
                        <div class="panel-body">


                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-2">
        </div>
    </div>
</div>

<%@include file="/WEB-INF/default_ft.jsp" %>
<script src="res/js/jquery.min.js"></script>
<script src="res/js/bootstrap.min.js"></script>
</body>
</html>
