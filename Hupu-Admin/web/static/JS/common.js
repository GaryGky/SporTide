function listen(e) {
    console.log(e);
    var next = $("#datatable_next");
    var previous = $("#datatable_previous");
    next.children("a").attr("href",
        "${pageContext.request.contextPath}/addPageNum");
    previous.children("a").attr("href",
        "${pageContext.request.contextPath}/subPageNum");

    $("select[name='datatable_length']").bind("change", function () {
        if (e === "game") {
            getGameInfo();
        } else if (e === "post") {
            getLimitPost();
        } else if (e === "comment") {
            getLimitCom();
        }
    });


    previous.children("a").bind("click", function () {
        $.get({
            url: "/subPageNum"
        });
        if (e === "game") {
            getGameInfo();
        } else if (e === "post") {
            getLimitPost();
        } else if (e === "comment") {
            getLimitCom();
        }
    });

    next.children("a").bind("click", function () {
        $.get({
            url: "/addPageNum"
        });
        if (e === "game") {
            getGameInfo();
        } else if (e === "post") {
            getLimitPost();
        } else if (e === "comment") {
            getLimitCom();
        }
    });
}