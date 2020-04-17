//获取当前Admin的信息
function getCurAdmin() {

}

//添加Admin的信息
function addAdmin() {
    console.log("进入添加函数");
    $.post({
        url: "/addAdmin",
        data: {
            "name": $("#admin_name").val(),
            "pwd1": $("#admin_pwd1").val(),
            "pwd2": $("#admin_pwd2").val()
        },
        success: function (msg) {
            console.log(msg);
            if (msg === "admin-add") {
                // 注册成功
                console.log("注册成功");
                window.location.href = "/index.jsp";
            } else {
                // 注册失败
                alert("两次输入的密码不一致");
            }
        }
    });
}

//获取user信息
function getMyUser() {
    alert("调用getUser");
    $.get({
        url: "/getMyUser",
        success: function (data) {
            console.log(data);
            var inject = "";
            for (var i = 0; i < data.length; i++) {
                inject += ("<tr>" +
                    "<td>" + data[i].user_id + "</td>" +
                    "<td>" + data[i].user_nikeName + "</td>" +
                    "<td>" + data[i].user_email + " </td>" +
                    "<td>" + data[i].user_time + " </td>" +
                    "<td>" + data[i].user_status + " </td>" +
                    "<td>" + "删除" + "</td>"
                    + "</tr>"
                );
            }
            $("#user_info_table").append(inject);
        }
    });
}

//删除user
function delUser() {
    $.post({
        url: "",
        data: {},
        success: function (flag) {

        }
    });
}

