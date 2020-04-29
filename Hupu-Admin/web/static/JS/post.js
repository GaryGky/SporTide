function getLimitPost() {
    var entry = $("select[name='datatable_length']").val();
    $.get({
        url: "/Hupu-Admin/post/getLimitPost",
        data: {
            "entries": entry
        },
        success: function (data) {
            console.log(data);
            window.location.reload();
        }
    });
}

//删除帖子
function delPost(id) {

    $.post({
        url: "/Hupu-Admin/post/delPost",
        data: {"id": id},
        success: function (map) {
            console.log(map);
            window.location.reload();
        }
    });
}

function getLimitCom() {
    var entry = $("select[name='datatable_length']").val();
    $.get({
        url: "/Hupu-Admin/post/getLimitCom",
        data: {
            "entries": entry
        },
        success: function (data) {
            console.log(data);
            window.location.reload();
        }
    });

}


//删除评论
function delComment(id) {
    $.post({
        url: "/Hupu-Admin/post/delComment",
        data: {"id": id},
        success: function (map) {
            console.log(map);
            window.location.reload();
        }
    })
}

