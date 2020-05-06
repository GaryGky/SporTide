<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/4/16
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>查看评论</title>

    <!-- Bootstrap -->
    <link href="cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
    <link href="${pageContext.request.contextPath}/static/vendors/bootstrap/dist/css/bootstrap.min.css"
          rel="stylesheet">
    <!-- Font Awesome -->
    <link href="${pageContext.request.contextPath}/static/vendors/font-awesome/css/font-awesome.min.css"
          rel="stylesheet">
    <!-- NProgress -->
    <link href="${pageContext.request.contextPath}/static/vendors/nprogress/nprogress.css"
          rel="stylesheet">
    <!-- iCheck -->
    <link href="${pageContext.request.contextPath}/static/vendors/iCheck/skins/flat/green.css"
          rel="stylesheet">
    <!-- Datatables -->

    <link href="${pageContext.request.contextPath}/static/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css"
          rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="${pageContext.request.contextPath}/static/build/css/custom.min.css"
          rel="stylesheet">
    <style type="text/css">
        table {
            table-layout: fixed;
        }

        td {
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
        }
    </style>
</head>

<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <div class="col-md-3 left_col">
            <div class="left_col scroll-view">
                <div class="navbar nav_title" style="border: 0;">
                    <a href="#"
                       class="site_title"><i
                            class="fa fa-trophy"></i>
                        <span>NBA INFO CMS</span></a>
                </div>

                <div class="clearfix"></div>

                <!-- menu profile quick info -->
                <div class="profile clearfix">
                    <%--<div class="profile_pic">--%>
                    <%--<!--管理员头像-->--%>
                    <%--<img src="images/img.jpg" alt="..."--%>
                    <%--class="img-circle profile_img">--%>
                    <%--</div>--%>
                    <div class="profile_info">
                        <span>Welcome, </span>
                        <!--管理员<span>Welcome,</span>名字-->
                        <h2>${sessionScope.admin}</h2>
                    </div>
                </div>
                <!-- /menu profile quick info -->

                <br/>

                <!-- sidebar menu -->
                <div id="sidebar-menu"
                     class="main_menu_side hidden-print main_menu">
                    <div class="menu_section">
                        <h3>General</h3>
                        <ul class="nav side-menu">
                            <!-- yx add -->
                            <li>
                                <a href="${pageContext.request.contextPath}/jump/toHome"><i
                                        class="fa fa-home"></i> 首页</a>
                            </li>
                            <li><a><i class="fa fa-flag-checkered"></i> 赛事管理
                                <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a
                                            href="${pageContext.request.contextPath}/jump/toGameTable">赛事信息</a>
                                    </li>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/jump/toGameAdd">添加赛事</a>
                                    </li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-users"></i> 用户管理 <span
                                    class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/jump/toUserTable">用户信息</a>
                                    </li>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/jump/toAdminAdd">添加管理员</a>
                                    </li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-pencil-square-o"></i> 论坛管理
                                <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/jump/toPostTable">帖子信息</a>
                                    </li>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/jump/toComTable">评论信息</a>
                                    </li>
                                </ul>
                            </li>
                            <!-- yx add end -->
                        </ul>
                    </div>
                </div>
                <!-- /sidebar menu -->

                <!-- /menu footer buttons -->

                <!-- /menu footer buttons -->
            </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
            <div class="nav_menu">
                <div class="nav toggle">
                    <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                </div>
                <nav class="nav navbar-nav">
                    <ul class=" navbar-right">
                        <li class="nav-item dropdown open"
                            style="padding-left: 15px;">
                            <a href="javascript:;"
                               class="user-profile dropdown-toggle"
                               aria-haspopup="true" id="navbarDropdown"
                               data-toggle="dropdown" aria-expanded="false">
                                ${sessionScope.admin}
                            </a>
                            <div class="dropdown-menu dropdown-usermenu pull-right"
                                 aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="javascript:;">
                                    Profile</a>
                                <a class="dropdown-item" href="javascript:;">
                                    <span class="badge bg-red pull-right">50%</span>
                                    <span>Settings</span>
                                </a>
                                <a class="dropdown-item" href="javascript:;">Help</a>
                                <a class="dropdown-item"
                                   href="${pageContext.request.contextPath}/index.jsp"><i
                                        class="fa fa-sign-out pull-right"></i>
                                    Log Out</a>
                            </div>
                        </li>

                    </ul>
                </nav>
            </div>
        </div>
        <!-- /jump/top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">
                <div class="row">
                    <div class="col-md-12 col-sm-12 ">
                        <div class="">
                            <div class="x_title">
                                <h2>所有评论信息
                                    <!--
                                    <small>Users</small>
                                    -->
                                </h2>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <div class="row">
                                    <div class="col-sm-12">
                                        <div class="card-box table-responsive">
                                            <p class="text-muted font-13 m-b-30">
                                            </p>
                                            <table id="datatable"
                                                   class="table table-striped table-bordered"
                                                   style="width:100%; table-layout: fixed">
                                                <thead>
                                                <tr>
                                                    <th>Id</th>
                                                    <th>帖子</th>
                                                    <th>作者</th>
                                                    <th>内容</th>
                                                    <th>时间</th>
                                                    <th>删除</th>
                                                </tr>
                                                </thead>

                                                <tbody id="com-info-table">
                                                <c:forEach var="comment"
                                                           items="${sessionScope.comMap}">
                                                    <tr>
                                                        <td>${comment.id}</td>
                                                        <td>${comment.post_label}</td>
                                                        <td>${comment.from_user_name}</td>
                                                        <td>${comment.info}</td>
                                                        <td>${comment.time}</td>
                                                        <td>
                                                            <button
                                                                    onclick="delComment(${comment.id})"
                                                                    class="btn btn-primary"
                                                                    style="display: block;width: 60px;height: 30px;background: #0b2e13">
                                                                删除
                                                            </button>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /page content -->

        <!-- footer content -->
        <footer>
            <div class="pull-right">
                Gentelella - Bootstrap Admin Template by <a
                    href="https://colorlib.com">Colorlib</a>
            </div>
            <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
    </div>
</div>

<!-- jQuery -->
<script src="${pageContext.request.contextPath}/static/vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="${pageContext.request.contextPath}/static/vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
<!-- FastClick -->
<script src="${pageContext.request.contextPath}/static/vendors/fastclick/lib/fastclick.js"></script>
<!-- NProgress -->
<script src="${pageContext.request.contextPath}/static/vendors/nprogress/nprogress.js"></script>
<!-- iCheck -->
<script src="${pageContext.request.contextPath}/static/vendors/iCheck/icheck.min.js"></script>
<!-- Datatables -->
<script src="${pageContext.request.contextPath}/static/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/static/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
<script src="${pageContext.request.contextPath}/static/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
<script src="${pageContext.request.contextPath}/static/vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
<script src="${pageContext.request.contextPath}/static/vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
<script src="${pageContext.request.contextPath}/static/vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
<script src="${pageContext.request.contextPath}/static/vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
<script src="${pageContext.request.contextPath}/static/vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
<script src="${pageContext.request.contextPath}/static/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/static/vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
<script src="${pageContext.request.contextPath}/static/vendors/jszip/dist/jszip.min.js"></script>
<script src="${pageContext.request.contextPath}/static/vendors/pdfmake/build/pdfmake.min.js"></script>
<script src="${pageContext.request.contextPath}/static/vendors/pdfmake/build/vfs_fonts.js"></script>

<!-- Custom Theme Scripts -->
<script src="${pageContext.request.contextPath}/static/build/js/custom.min.js"></script>
<script src="${pageContext.request.contextPath}/static/JS/post.js"></script>
<script type="text/javascript">
    window.onload = function () {
        getLimitCom();
    }
</script>
</body>
</html>
