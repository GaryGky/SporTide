//获取所有帖子
function getAllPost() {
    $.get({
        url: "/allPost",
        data: {},
        success: function (data) {
            var inject = "";
            for (var i = 0; i < data.length; i++) {
                inject += ("<tr>" +
                    "<td>" + data[i].post_id + "</td>" +
                    "<td>" + data[i].post_info + "</td>" +
                    "<td>" + data[i].post_type + " </td>" +
                    "<td>" + data[i].user_id + " </td>" +
                    "<td>" + data[i].post_time + " </td>" +
                    "<td>" + data[i].post_commentNum + " </td>" +
                    "<td>" + data[i].post_collectNum + " </td>" +
                    "<td>" + data[i].post_transpondNum + " </td>" +
                    "<td> <button onclick=\"delPost(" + data[i].post_id + ")\">删除 </td>"
                    + "</tr>");
            }
            $("#post-info-table").append(inject);
        }
    });
}

//删除帖子
function delPost(id) {

    $.post({
        url: "/delPost",
        data: {"id": id},
        success: function (map) {
            console.log(map);
            window.location.reload();
        }
    });
}


function getAllComment() {
    // alert("加载评论");
    $.post({
        url: "/getAllCom",
        data: {},
        success: function (data) {
            console.log(data);
            var inject = "";
            for (var i = 0; i < data.length; i++) {
                inject += ("<tr>" +
                    "<td>" + data[i].id + "</td>" +
                    "<td>" + data[i].post_id + "</td>" +
                    "<td>" + data[i].from_uid + " </td>" +
                    "<td>" + data[i].info + " </td>" +
                    "<td>" + data[i].time + " </td>" +
                    "<td> <button onclick=\"delComment(" + data[i].id + ")\">删除 </td>"
                    + "</tr>");
            }
            $("#com-info-table").append(inject);
        }
    });
}


//删除评论
function delComment(id) {
    $.post({
        url: "/delComment",
        data: {"id": id},
        success: function (map) {
            console.log(map);
            window.location.reload();
        }
    })
}

