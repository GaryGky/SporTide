//添加赛事
function addGame() {
    $.post({
        url: "", //添加比赛的url
        data: {
            //一些数据，待确定。
        },
        success: function(flag) {
            console.log("添加成功");
            if(flag) {
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
        success: function(flag) {
            console.log('比赛删除成功');
            if(flag){
                //删除成功提示
            }
        }
    });
}

//获取比赛信息
function getGameInfo() {
    $.post({
        url: "",
        data: {
            //需要什么
        },
        success: function(data) {
            var inject = "";
            for (var i = 0; i < data.length; i++) {
                inject += ("<tr>" +
                    "<td>" + data[i].team + "</td>" +
                    "<td>" + data[i].opponent + "</td>" +
                    "<td>" + data[i].teamPoints + " : " + data[i].opponentPoints +
                    "</td>"
                    + "</tr>"
                );
            }
            $("#content").html(inject);
        }
    });
}