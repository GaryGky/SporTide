//添加赛事
function addGame() {
    $.post({
        url: "", //添加比赛的url
        data: {
            //一些数据，待确定。
        },
        success: function (flag) {
            console.log("添加成功");
            if (flag) {
                //添加成功的提示。
            }
        }
    });
}

//删除比赛
function delGame() {
    $.post({
        url: "", //删除比赛
        data: {
            //game id? 还是 game name
        },
        success: function (flag) {
            console.log('比赛删除成功');
            if (flag) {
                //删除成功提示
            }
        }
    });
}

//获取比赛信息
function getGameInfo() {
    $.get({
        url: "/getGameByLimit",
        data: {
            "pageNum": 1, // 页号: 相当于数据库索引时的偏移
            "entries": 10, // 每页展示的数据量，相当于数据库索引时的limit
        },
        success: function (data) {
            var inject = "";
            for (var i = 0; i < data.length; i++) {
                inject += ("<tr>" +
                    "<td>" + data[i].home + "</td>" +
                    "<td>" + data[i].away + "</td>" +
                    "<td>" + data[i].teamPoints + "</td>" +
                    "<td>" + data[i].date + "</td>" +
                    "<td>" + data[i].arena + "</td>" +
                    "<td>" + data[i].audNum + "</td>" + // 观众人数
                    +"</tr>"
                );
            }
            $("#game_table_content").html(inject);
        }
    });
}