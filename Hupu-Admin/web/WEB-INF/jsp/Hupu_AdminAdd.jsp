<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/4/16
  Time: 19:32
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

    <title>管理员添加</title>

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
            white-space:nowrap;overflow:hidden;text-overflow: ellipsis;
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
                            <li><a href="/toHome"><i
                                    class="fa fa-home"></i> 首页</a>
                            </li>
                            <li><a><i class="fa fa-flag-checkered"></i> 赛事管理
                                <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a
                                            href="/toGameTable">赛事信息</a>
                                    </li>
                                    <li><a href="/toGameAdd">添加赛事</a>
                                    </li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-users"></i> 用户管理 <span
                                    class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li><a href="/toUserTable">用户信息</a>
                                    </li>
                                    <li><a href="/toAdminAdd">添加管理员</a>
                                    </li>
                                </ul>
                            </li>
                            <li><a><i class="fa fa-pencil-square-o"></i> 论坛管理
                                <span class="fa fa-chevron-down"></span></a>
                                <ul class="nav child_menu">
                                    <li>
                                        <a href="/toPostTable">帖子信息</a>
                                    </li>
                                    <li>
                                        <a href="/toComTable">评论信息</a>
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
                                <a class="dropdown-item" href="${pageContext.request.contextPath}/index.jsp"><i
                                        class="fa fa-sign-out pull-right"></i>
                                    Log Out</a>
                            </div>
                        </li>

                    </ul>
                </nav>
            </div>
        </div>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">
                <div class="page-title">
                    <div class="title_left">
                        <h3>Administrator Info</h3>
                    </div>

                    <div class="title_right">
                        <div class="col-md-5 col-sm-5 form-group pull-right top_search">
                            <div class="input-group">
                                <input type="text" class="form-control"
                                       placeholder="Search for...">
                                <span class="input-group-btn">
                    <button class="btn btn-default" type="button">Go!</button>
                  </span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="clearfix"></div>

                <div class="row">
                    <div class="col-md-12 col-sm-12">
                        <div class="">
                            <div class="x_title">
                                <h2>power an email to register an admin
                                    account</h2>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <div>
                                    <span class="section">Administrator Info</span>

                                    <div class="field item form-group">
                                        <label
                                                class="col-form-label col-md-3 col-sm-3  label-align">admin_name<span
                                                class="required">*</span></label>
                                        <div class="col-md-6 col-sm-6">
                                            <input id="admin_name"
                                                   class="form-control"
                                                   name="admin_name"
                                                   required="required"
                                                   type="text"/>
                                        </div>
                                    </div>
                                    <div class="field item form-group">
                                        <label
                                                class="col-form-label col-md-3 col-sm-3  label-align">password<span
                                                class="required">*</span></label>
                                        <div class="col-md-6 col-sm-6">
                                            <input id="admin_pwd1"
                                                   class="form-control "
                                                   type="password"
                                                   name="admin_pwd1"
                                                   required='required'/>
                                        </div>
                                    </div>

                                    <div class="field item form-group">
                                        <label class="col-form-label col-md-3 col-sm-3  label-align">Confirm
                                            password<span
                                                    class="required">*</span></label>
                                        <div class="col-md-6 col-sm-6">
                                            <input id="admin_pwd2"
                                                   class="form-control email"
                                                   type="password"
                                                   name="admin_pwd2"
                                                   required='required'/>
                                        </div>
                                    </div>

                                    <div class="ln_solid">
                                        <div class="form-group">
                                            <div class="col-md-6 offset-md-3">
                                                <button class="btn btn-primary"
                                                        onclick="addAdmin()">
                                                    Submit
                                                </button>

                                                <button type='reset'
                                                        class="btn btn-success">
                                                    Reset
                                                </button>

                                            </div>
                                        </div>
                                    </div>
                                    </form>
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
    <!-- Chart.js -->
    <script src="${pageContext.request.contextPath}/static/vendors/Chart.js/dist/Chart.min.js"></script>
    <!-- gauge.js -->
    <script src="${pageContext.request.contextPath}/static/vendors/gauge.js/dist/gauge.min.js"></script>
    <!-- bootstrap-progressbar -->
    <script src="${pageContext.request.contextPath}/static/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
    <!-- iCheck -->
    <script src="${pageContext.request.contextPath}/static/vendors/iCheck/icheck.min.js"></script>
    <!-- Skycons -->
    <script src="${pageContext.request.contextPath}/static/vendors/skycons/skycons.js"></script>
    <!-- Flot -->
    <script src="${pageContext.request.contextPath}/static/vendors/Flot/jquery.flot.js"></script>
    <script src="${pageContext.request.contextPath}/static/vendors/Flot/jquery.flot.pie.js"></script>
    <script src="${pageContext.request.contextPath}/static/vendors/Flot/jquery.flot.time.js"></script>
    <script src="${pageContext.request.contextPath}/static/vendors/Flot/jquery.flot.stack.js"></script>
    <script src="${pageContext.request.contextPath}/static/vendors/Flot/jquery.flot.resize.js"></script>
    <!-- Flot plugins -->
    <script src="${pageContext.request.contextPath}/static/vendors/flot.orderbars/js/jquery.flot.orderBars.js"></script>
    <script src="${pageContext.request.contextPath}/static/vendors/flot-spline/js/jquery.flot.spline.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/vendors/flot.curvedlines/curvedLines.js"></script>
    <!-- DateJS -->
    <script src="${pageContext.request.contextPath}/static/vendors/DateJS/build/date.js"></script>
    <!-- JQVMap -->
    <script src="${pageContext.request.contextPath}/static/vendors/jqvmap/dist/jquery.vmap.js"></script>
    <script src="${pageContext.request.contextPath}/static/vendors/jqvmap/dist/maps/jquery.vmap.world.js"></script>
    <script src="${pageContext.request.contextPath}/static/vendors/jqvmap/examples/js/jquery.vmap.sampledata.js"></script>
    <!-- bootstrap-daterangepicker -->
    <script src="${pageContext.request.contextPath}/static/vendors/moment/min/moment.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/vendors/bootstrap-daterangepicker/daterangepicker.js"></script>

    <!-- Custom Theme Scripts -->
    <script src="${pageContext.request.contextPath}/static/build/js/custom.min.js"></script>

    <script src="${pageContext.request.contextPath}/static/JS/user.js"></script>
</body>
</html>
