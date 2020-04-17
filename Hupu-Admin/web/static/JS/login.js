//登录验证
function login() {
    console.log("into login");
    $.post({
        url: "/adminLogin", //登录验证url
        data: {
            "name": document.getElementById("username").value,
            "password": document.getElementById("userpassword").value
        },
        success: function (flag, status,xhr) {
            if (flag === "loginSuccess") {
                alert("登录成功");
                window.location.href = "/toHome"; // 跳到首页
            } else {
                alert("请输入正确的用户名和密码");
            }
        }
    });
}

//还是用一个注册吧，感觉login页面有点空。。
function register() {
    $.post({
        url: "", //注册的url
        data: {
            "name": document.getElementById("registername").value,
            "email": document.getElementById("registerEmail").value,
            "password": document.getElementById("registerpassword").value
        },
        success: function (flag) {
            console.log(flag);
            if (flag) {
                //显示注册成功
                window.location.href = "Hupu_Login.html";
            }
        }
    });
}

//登出 登出的话需要传送什么参数, user_id?
function logout() {
    $.post({
        url: "/logout",
        data: {},
        success: function (response) {
            console.log('response');
            window.location.href = "index.jsp";
        }
    });
}
