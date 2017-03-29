<%--
  Created by yangyonghao
  Date: 2017/3/12
  Time: 10:00
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>简单空间</title>

    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">

    <link href="res/css/bootstrap.min.css" rel="stylesheet">
    <style>
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

<%@include file="WEB-INF/default_nav.jsp"%>

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
                    <div class="carousel-inner" style="height: 350px">
                        <div class="item active">
                            <img alt="Carousel Bootstrap First" class="index-top-img"
                                 src="res/img/index1.jpg"/>
                            <div class="carousel-caption" style="position: absolute;top: 200px">
                                <h4>
                                    First Thumbnail label
                                </h4>
                                <p>
                                    Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi
                                    porta
                                    gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
                                </p>
                            </div>
                        </div>
                        <div class="item">
                            <img alt="Carousel Bootstrap Second" class="index-top-img"
                                 src="res/img/index2.jpg"/>
                            <div class="carousel-caption" style="position: absolute;top: 200px">
                                <h4>
                                    Second Thumbnail label
                                </h4>
                                <p>
                                    Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi
                                    porta
                                    gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
                                </p>
                            </div>
                        </div>
                        <div class="item">
                            <img alt="Carousel Bootstrap Third" class="index-top-img"
                                 src="res/img/index3.jpg"/>
                            <div class="carousel-caption" style="position: absolute;top: 200px">
                                <h4>
                                    Third Thumbnail label
                                </h4>
                                <p>
                                    Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi
                                    porta
                                    gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
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

                            <div class="container-fluid">
                                <div class="row">
                                    <!--单个动态模板,定义每行4条数据-->
                                    <div class="col-md-3">
                                        <div class="myDongtaiModule" onmouseover="myDongtaiModuleMouseover(this)"
                                             onmouseleave="myDongtaiModuleMouseleave(this)">
                                            <!--动态头-->
                                            <div class="container-fluid">
                                                <div class="row">
                                                    <div class="col-md-5">
                                                        <a href="#"><img src="res/img/defPhoto.jpg" class="img-circle"
                                                                         style="width:100%;padding-top: 3px"/></a>
                                                    </div>
                                                    <div class="col-md-7">
                                                        <h4>ID:001</h4>
                                                        <h4>Name:test</h4>
                                                    </div>
                                                </div>
                                            </div>
                                            <!--动态内容-->
                                            <div style="display: block;margin-top: 10px" class="myDongtaiContent">
                                                <span style="font-weight: 900;font-size: 30px">“</span>
                                                <a href="#" style="font-size: 20px">这是动态的内容，我有一个说话的背景这是动态的内容，我有一个说话的背景这是动态的内容，我有一个说话的背景
                                                </a>
                                                <span style="font-weight: 900;font-size: 30px">...”</span>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-md-3">
                                    </div>
                                    <div class="col-md-3">
                                    </div>
                                    <div class="col-md-3">
                                    </div>
                                </div>
                            </div>

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


<script src="res/js/jquery.min.js"></script>
<script src="res/js/bootstrap.min.js"></script>
</body>
</html>
