<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/4/10
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">
    <script src="${pageContext.request.contextPath}/static/JS/jquery-3.4.1.js"></script>
    <script>
        function a1() {
            $.post({
                url: "${pageContext.request.contextPath}/getScore",
                data: {
                    "date": $("#date").val(),
                },
                success: function (data) {
                    console.log(data);
                    var inject = "";
                    for (var i = 0; i < data.length; i++) {
                        inject += ("<tr>" +
                            "<td>" + data[i].team + "</td>" +
                            "<td>" + data[i].opponent + "</td>" +
                            "<td>" + data[i].teamPoints + " : " + data[i].opponentPoints +
                            "</td>"
                            + "</tr>"
                        )
                    }
                    $("#content").html(inject);
                }
            })
        }
    </script>
</head>
<body>

<div class="form-inline">
    <input id="date" type="text" placeholder="Input Date"
           class="form-control">
    <button class="btn btn-primary" onclick="a1()">Query By
        Date
    </button>
</div>


<table class="table table-striped">
    <thead>
    <tr>
        <th>Team</th>
        <th>Opponent</th>
        <th>Score</th>
    </tr>
    </thead>

    <%--通过script动态添加数据--%>
    <tbody id="content">

    </tbody>
</table>
</body>
</html>
