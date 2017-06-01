<%--suppress ALL --%>
<%--suppress ALL --%>
<%--
  Created by IntelliJ IDEA.
  User: 睡意朦胧
  Date: 2017/5/30
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="y" uri="/WEB-INF/y_tag.tld" %>
<%@taglib prefix="h" uri="/WEB-INF/h_tag.tld" %>
<html>
<head>
    <title>我的日志</title>
    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">

    <link href="../../res/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../res/css/navigation.css" rel="stylesheet">
    <style>
        article, aside, figure, footer, header, hgroup,
        menu, nav, section { display: block; }

        p {
            margin: 0 0 1em;
        }

        .comment {
            overflow: hidden;
            padding:0 0 1em;
            border-bottom: 1px solid #ddd;
            margin: 0 0 1em;
            *zoom: 1;
        }

        .comment-img {
            float: left;
            margin-right: 33px;
            border-radius: 5px;
            overflow: hidden;
        }

        .comment-img img {
            display: block;
        }

        .comment-body {
            width: 400px;
            overflow: hidden;
        }

        .comment .text {
            padding: 10px;
            border: 1px solid #e5e5e5;
            border-radius: 5px;
            background: #fff;
        }

        .comment .text p:last-child {
            margin: 0;
        }

        .comment .attribution {
            margin: 0.5em 0 0;
            font-size: 14px;
            color: #666;
        }

        /* Decoration */

        .comments,
        .comment {
            position: relative;
        }

        .comments:before,
        .comment:before,
        .comment .text:before {
            content: "";
            position: absolute;
            top: 0;
            left: 65px;
        }

        .comments:before {
            width: 3px;
            bottom: -20px;
            background: rgba(0,0,0,0.1);
        }

        .comment:before {
            width: 9px;
            height: 9px;
            border: 3px solid #fff;
            border-radius: 100px;
            margin: 16px 0 0 -6px;
            box-shadow: 0 1px 1px rgba(0,0,0,0.2), inset 0 1px 1px rgba(0,0,0,0.1);
            background: #ccc;
        }

        .comment:hover:before {
            background: orange;
        }

        .comment .text:before {
            top: 18px;
            left: 78px;
            width: 9px;
            height: 9px;
            border-width: 0 0 1px 1px;
            border-style: solid;
            border-color: #e5e5e5;
            background: #fff;
            -webkit-transform: rotate(45deg);
            -moz-transform: rotate(45deg);
            -ms-transform: rotate(45deg);
            -o-transform: rotate(45deg);
        }
    </style>
</head>
<body style="overflow-x: hidden">
<%@include file="MyPage.jsp"%>
<div class="container-fluid">
    <div class="col-md-2"></div>
    <div class="col-md-8">
<s:iterator value="#session.Mnotes" id="notes">
        <section class="comments">
            <article class="comment">
                <a class="comment-img" href="readNote.action?id=<s:property value='#notes.id'/>">
                    <img src="../../res/img/defPhoto.jpg" alt="" width="50" height="50">
                </a>
                <div class="comment-body">
                    <div class="text">
                        <p><s:property value="#notes.noteTitle"/></p>
                    </div>
                    <p class="attribution"><s:property value="#notes.time"/></p>
                </div>
            </article>
        </section>
</s:iterator>
        <div class="js-load-more">加载更多</div>
    </div>
    <div class="col-md-2"></div>
</div>
<%@include file="../default_ft.jsp"%>
<script src="../../res/js/jquery.min.js"></script>
<script src="../../res/js/bootstrap.min.js"></script>
<script language="JavaScript" type="text/javascript">
    $(function () {
        /*初始化*/
        var counter = 0; /*计数器*/
        var pageStart = 0; /*offset*/
        var isEnd = false;/*结束标志*/

        /*首次加载*/
        getData(pageStart);

        /*监听加载更多*/
        $(window).scroll(function(){
            if(isEnd == true){
                return;
            }

            // 当滚动到最底部以上100像素时， 加载新内容
            // 核心代码
            if ($(document).height() - $(this).scrollTop() - $(this).height()<100){
                counter ++;
                pageStart = counter * 10;

                getData(pageStart);
            }
        });
    });
    function getData(pageStart) {
        $.ajax({
            type:"GET",
            url:"home?",
            data:{NotePageNo:pageStart},
            datatype:"json",
            success:function (reponse) {
                var data=reponse.list;
                var sum = reponse.list.length;

                var result = '';

                if(sum - pageStart < size ){
                    size = sum - pageStart;
                }

                /*使用for循环模拟SQL里的limit(offset,size)*/
                for(var i=pageStart; i< (pageStart+size); i++){
                    result +='<section class="comments">'+
                        '<article class="comment">'+
                        '<a class="comment-img" href="readNote.action?id='+data[i].id+'">'+
                        '<img src="../../res/img/defPhoto.jpg" alt="" width="50" height="50">'+
                        '</a>'+
                        '<div class="comment-body">'+
                        '<div class="text">'+
                        '<p>'+data[i].noteTitle+'</p>'+
                        '</div>'+
                        '<p class="attribution">'+data[i].time+'</p>'+
                        '</div>'+
                        '</article>'+
                        '</section>';
                }

                $('.js-blog-list').append(result);

                /*******************************************/

                /*隐藏more按钮*/
                if ( (pageStart + size) >= sum){
                    $(".js-load-more").hide();
                }else{
                    $(".js-load-more").show();
                }
            },
            error: function(xhr, type){
                alert('Ajax error!');
            }

        })
    };
</script>
</body>
</html>
