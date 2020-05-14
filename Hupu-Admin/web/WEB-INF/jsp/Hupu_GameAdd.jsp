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
    <link rel="shortcut icon" href="http://114.115.134.119:8080/logo/LAL.png"/>
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

        <jsp:include page="Hupu_top_nav.jsp" flush="true"/>

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
                                <h2>管理端新闻发布</h2>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <form enctype="multipart/form-data"
                                      action="#"
                                      id="post-form">
                                    <span class="section">发布新闻</span>
                                    <div class="field item form-group">
                                        <label class="col-form-label col-md-3 col-sm-3  label-align">Name<span
                                                class="required">*</span></label>
                                        <div class="col-md-6 col-sm-6">
                                            <input class="form-control"
                                                   data-validate-length-range="6"
                                                   data-validate-words="2"
                                                   name="name"
                                                   placeholder="ex. John f. Kennedy"
                                                   required="required"/>
                                        </div>
                                    </div>


                                    <div class="field item form-group">
                                        <label
                                                class="col-form-label col-md-3 col-sm-3  label-align">Title<span
                                                class="required">*</span></label>
                                        <div class="col-md-6 col-sm-6">
                                            <input class="form-control"
                                                   type="text" class='tel'
                                                   name="phone"
                                                   required='required'
                                                   data-validate-length-range="8,20"/>
                                        </div>
                                    </div>
                                    <div class="field item form-group">
                                        <label
                                                class="col-form-label col-md-3 label-align">Content
                                            <span
                                                    class="required">*</span></label>
                                        <div class="col-md-6">
                                            <div class="x_content">
                                                <div id="alerts"></div>
                                                <div class="btn-toolbar editor"
                                                     data-role="editor-toolbar"
                                                     data-target="#editor-one">
                                                    <div class="btn-group">
                                                        <a class="btn dropdown-toggle"
                                                           data-toggle="dropdown"
                                                           title="Font"><i
                                                                class="fa fa-font"></i><b
                                                                class="caret"></b></a>
                                                        <ul class="dropdown-menu">
                                                        </ul>
                                                    </div>

                                                    <div class="btn-group">
                                                        <a class="btn dropdown-toggle"
                                                           data-toggle="dropdown"
                                                           title="Font Size"><i
                                                                class="fa fa-text-height"></i>&nbsp;<b
                                                                class="caret"></b></a>
                                                        <ul class="dropdown-menu">
                                                            <li>
                                                                <a data-edit="fontSize 5">
                                                                    <p style="font-size:17px">
                                                                        Huge</p>
                                                                </a>
                                                            </li>
                                                            <li>
                                                                <a data-edit="fontSize 3">
                                                                    <p style="font-size:14px">
                                                                        Normal</p>
                                                                </a>
                                                            </li>
                                                            <li>
                                                                <a data-edit="fontSize 1">
                                                                    <p style="font-size:11px">
                                                                        Small</p>
                                                                </a>
                                                            </li>
                                                        </ul>
                                                    </div>

                                                    <div class="btn-group">
                                                        <a class="btn"
                                                           data-edit="bold"
                                                           title="Bold (Ctrl/Cmd+B)"><i
                                                                class="fa fa-bold"></i></a>
                                                        <a class="btn"
                                                           data-edit="italic"
                                                           title="Italic (Ctrl/Cmd+I)"><i
                                                                class="fa fa-italic"></i></a>
                                                        <a class="btn"
                                                           data-edit="strikethrough"
                                                           title="Strikethrough"><i
                                                                class="fa fa-strikethrough"></i></a>
                                                        <a class="btn"
                                                           data-edit="underline"
                                                           title="Underline (Ctrl/Cmd+U)"><i
                                                                class="fa fa-underline"></i></a>
                                                    </div>

                                                    <div class="btn-group">
                                                        <a class="btn"
                                                           data-edit="insertunorderedlist"
                                                           title="Bullet list"><i
                                                                class="fa fa-list-ul"></i></a>
                                                        <a class="btn"
                                                           data-edit="insertorderedlist"
                                                           title="Number list"><i
                                                                class="fa fa-list-ol"></i></a>
                                                        <a class="btn"
                                                           data-edit="outdent"
                                                           title="Reduce indent (Shift+Tab)"><i
                                                                class="fa fa-dedent"></i></a>
                                                        <a class="btn"
                                                           data-edit="indent"
                                                           title="Indent (Tab)"><i
                                                                class="fa fa-indent"></i></a>
                                                    </div>

                                                    <div class="btn-group">
                                                        <a class="btn"
                                                           data-edit="justifyleft"
                                                           title="Align Left (Ctrl/Cmd+L)"><i
                                                                class="fa fa-align-left"></i></a>
                                                        <a class="btn"
                                                           data-edit="justifycenter"
                                                           title="Center (Ctrl/Cmd+E)"><i
                                                                class="fa fa-align-center"></i></a>
                                                        <a class="btn"
                                                           data-edit="justifyright"
                                                           title="Align Right (Ctrl/Cmd+R)"><i
                                                                class="fa fa-align-right"></i></a>
                                                        <a class="btn"
                                                           data-edit="justifyfull"
                                                           title="Justify (Ctrl/Cmd+J)"><i
                                                                class="fa fa-align-justify"></i></a>
                                                    </div>

                                                    <div class="btn-group">
                                                        <a class="btn dropdown-toggle"
                                                           data-toggle="dropdown"
                                                           title="Hyperlink"><i
                                                                class="fa fa-link"></i></a>
                                                        <div class="dropdown-menu input-append">
                                                            <input class="span2"
                                                                   placeholder="URL"
                                                                   type="text"
                                                                   data-edit="createLink"/>
                                                            <button class="btn"
                                                                    type="button">
                                                                Add
                                                            </button>
                                                        </div>
                                                        <a class="btn"
                                                           data-edit="unlink"
                                                           title="Remove Hyperlink"><i
                                                                class="fa fa-cut"></i></a>
                                                    </div>

                                                    <div class="btn-group">
                                                        <a class="btn"
                                                           title="Insert picture (or just drag & drop)"
                                                           id="pictureBtn"><i
                                                                class="fa fa-picture-o"></i></a>
                                                        <input type="file"
                                                               id="file"
                                                               name="file"
                                                               data-role="magic-overlay"
                                                               data-target="#pictureBtn"
                                                               data-edit="insertImage"/>
                                                    </div>

                                                    <div class="btn-group">
                                                        <a class="btn"
                                                           data-edit="undo"
                                                           title="Undo (Ctrl/Cmd+Z)"><i
                                                                class="fa fa-undo"></i></a>
                                                        <a class="btn"
                                                           data-edit="redo"
                                                           title="Redo (Ctrl/Cmd+Y)"><i
                                                                class="fa fa-repeat"></i></a>
                                                    </div>
                                                </div>

                                                <div id="editor-one"
                                                     class="editor-wrapper"></div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="ln_solid">
                                        <div class="form-group">
                                            <div class="col-md-6 offset-md-3">
                                                <button onclick="submit()"
                                                        class="btn btn-primary">
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

<script type="text/javascript">
    function submit() {
        var form = $("#post-form");
        alert(form);
    }
</script>
</body>
</html>
