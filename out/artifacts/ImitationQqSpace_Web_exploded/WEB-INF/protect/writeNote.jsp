<%--
  Created by IntelliJ IDEA.
  User: YangYongHao
  Date: 2017/4/12
  Time: 18:57
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="y" uri="/WEB-INF/y_tag.tld" %>
<!DOCTYPE html>
<html>
<head>
    <title>WriteNote</title>

    <!-- include libraries(jQuery, bootstrap) -->
    <link href="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.css" rel="stylesheet">
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.js"></script>
    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>

    <!-- include summernote css/js-->
    <link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.3/summernote.css" rel="stylesheet">
    <script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.3/summernote.js"></script>
    <style>
        html {
            overflow-x: hidden;
        }

        .title {
            width: 220px;
            -webkit-border-radius: 3px;
            -moz-border-radius: 3px;
            border-radius: 3px;
            height: 25px;
            font-size: 15px;
            border: 1px solid #cccccc;
            outline: none;
            color: #808080;
            padding-left: 5px;
            margin-left: 5px;
        }

        .green:focus {
            transition: border linear .2s, box-shadow linear .5s;
            -moz-transition: border linear .2s, -moz-box-shadow linear .5s;
            -webkit-transition: border linear .2s, -webkit-box-shadow linear .5s;
            outline: none;
            border-color: rgba(19, 105, 172, .75);
            box-shadow: 0 0 3px rgba(19, 105, 192, .5);
            -moz-box-shadow: 0 0 3px rgba(241, 39, 232, .5);
            -webkit-box-shadow: 0 0 3px rgba(19, 105, 252, 3);
        }
    </style>
</head>
<body>
<%@include file="/WEB-INF/default_nav.jsp" %>

<div class="container-fluid">
    <div class="row">
        <div class="col-md-2">
        </div>
        <div class="col-md-8">
            <form action="upNote.action" method="post" id="form">
                <div style="margin-top: 5px;margin-bottom: 5px;margin-left: 20px">
                    <b>标题:</b>
                    <input type="text" name="title" size="20" class="title green" onblur="checkLen(this,20)">
                    <div style="
                    font-family: lucida sans unicode,lucida grande,sans-serif;
                    color: #F22929;
                    font-size: 12px;
                    letter-spacing: 0pt;
                    word-spacing: 9.6pt;
                    display: inline;
                    ">
                        注意：标题长度应不超过20且不能为空
                    </div>
                </div>
                <div id="summernote"></div>
                <input type="hidden" name="note" id="noteContent">
                <input type="button" onclick="sub()" value="发表" style="margin-bottom: 20px"/>
            </form>
        </div>
        <div class="col-md-2">
        </div>
    </div>
</div>

<script>
    var title_len = 0;
    function sub() {
        var form = document.getElementById("form");
        var noteContent = document.getElementById("noteContent");
        var content = $('#summernote').summernote('code');
        if (content == null || title_len == 0) {
            alert("所有内容不能为空");
        } else {
            noteContent.value = content;
            form.submit();
        }
    }

    $(document).ready(function () {
        $('#summernote').summernote({
            lang: 'zh-CN',
            height: 500,                 // set editor height
            minHeight: 500,             // set minimum height of editor
            maxHeight: 800,             // set maximum height of editor
            focus: true                  // set focus to editable area after initializing summernote
        });
    });

    function checkLen(obj, len) {
        if (obj.value.length > len) {
            alert("error : title's len > " + len + "!");
        } else if (obj.value.length == 0) {
            alert("error : title's len = 0!");
        } else
            title_len = 1;
    }
</script>


<%@include file="/WEB-INF/default_ft.jsp" %>
</body>
</html>
