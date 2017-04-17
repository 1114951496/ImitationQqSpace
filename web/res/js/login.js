/**
 * Created by yyh on 2017/2/27.
 */
function btDown(bt) {
    bt.style.backgroundColor = "#4a7794"
}

function btUp(bt) {
    bt.style.backgroundColor = "#4a77d4"
}



function Register() {
    email = document.getElementById("email");
    yzm = document.getElementById("yzm");
    username=document.getElementById("username");
    userpassword=document.getElementById("userpassword");
    if (email.value.length == 0 || yzm.value.length == 0||username.value.length==0||userpassword.value.length==0) {
        alert("请将表单填写完整!");
    } else {
        tjForm = document.getElementById("tjform");
        tjForm.action = "register";
        tjForm.submit();
    }
}

function Login() {
    loginid=document.getElementById("loginid");
    loginpwd=document.getElementById("loginid");
    if (loginid.value.length==0||loginpwd.value.length==0) {
        alert("请将表单填写完整!");
    } else {
        tjForm = document.getElementById("tjform");
        tjForm.action = "login";
        tjForm.submit();
    }
}

function yz(obj) {
    email = document.getElementById("email");
    if (email.value.length == 0) {
        alert("请填写邮箱!");
    } else {
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
        xmlhttp.open("get", "http://localhost:8080/sendYzm?email=" + email.value, true);
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
    }
}

var logORregVar = 0;
function logORreg(obj) {
    if (logORregVar == 0) {
        register = document.getElementById("registerCon");
        register.style.display = "block";
        login = document.getElementById("loginCon");
        login.style.display = "none";
        formTitle = document.getElementById("title");
        formTitle.innerHTML = "Register";
        obj.innerHTML = ">>登录";
        logORregVar = 1;
    } else {
        register = document.getElementById("registerCon");
        register.style.display = "none";
        login = document.getElementById("loginCon");
        login.style.display = "block";
        formTitle = document.getElementById("title");
        formTitle.innerHTML = "Login";
        obj.innerHTML = ">>注册";
        logORregVar = 0;
    }

}