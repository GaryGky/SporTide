<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/4/16
  Time: 19:42
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

    <title>添加比赛 </title>
    <link rel="shortcut icon" href="http://114.115.134.119:8080/logo/DEN.png"/>
    <!-- Bootstrap -->
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
    <!-- bootstrap-wysiwyg -->
    <link href="${pageContext.request.contextPath}/static/vendors/google-code-prettify/bin/prettify.min.css"
          rel="stylesheet">
    <!-- Select2 -->
    <link href="${pageContext.request.contextPath}/static/vendors/select2/dist/css/select2.min.css"
          rel="stylesheet">
    <!-- Switchery -->
    <link href="${pageContext.request.contextPath}/static/vendors/switchery/dist/switchery.min.css"
          rel="stylesheet">
    <!-- starrr -->
    <link href="${pageContext.request.contextPath}/static/vendors/starrr/dist/starrr.css"
          rel="stylesheet">
    <!-- bootstrap-daterangepicker -->
    <link href="${pageContext.request.contextPath}/static/vendors/bootstrap-daterangepicker/daterangepicker.css"
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

        <jsp:include page="Hupu_top_nav.jsp" flush="true" />


        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">
                <div class="page-title">
                    <div class="title_left">
                        <h3>Form Validation</h3>
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
                                <h2>Form validation
                                    <small>sub title</small>
                                </h2>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <form class="" action="" method="post"
                                      novalidate>
                                    <p>For alternative validation library <code>parsleyJS</code>
                                        check out in the <a
                                                href="form.html">form page</a>
                                    </p>
                                    <span class="section">Personal Info</span>
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
                                        <label class="col-form-label col-md-3 col-sm-3  label-align">Occupation<span
                                                class="required">*</span></label>
                                        <div class="col-md-6 col-sm-6">
                                            <input class="form-control"
                                                   class='optional'
                                                   name="occupation"
                                                   data-validate-length-range="5,15"
                                                   type="text"/></div>
                                    </div>
                                    <div class="field item form-group">
                                        <label class="col-form-label col-md-3 col-sm-3  label-align">email<span
                                                class="required">*</span></label>
                                        <div class="col-md-6 col-sm-6">
                                            <input class="form-control"
                                                   name="email" class='email'
                                                   required="required"
                                                   type="email"/></div>
                                    </div>
                                    <div class="field item form-group">
                                        <label class="col-form-label col-md-3 col-sm-3  label-align">Confirm
                                            email address<span
                                                    class="required">*</span></label>
                                        <div class="col-md-6 col-sm-6">
                                            <input class="form-control"
                                                   type="email" class='email'
                                                   name="confirm_email"
                                                   data-validate-linked='email'
                                                   required='required'/></div>
                                    </div>
                                    <div class="field item form-group">
                                        <label class="col-form-label col-md-3 col-sm-3  label-align">Number
                                            <span
                                                    class="required">*</span></label>
                                        <div class="col-md-6 col-sm-6">
                                            <input class="form-control"
                                                   type="number" class='number'
                                                   name="number"
                                                   data-validate-minmax="10,100"
                                                   required='required'></div>
                                    </div>
                                    <div class="field item form-group">
                                        <label class="col-form-label col-md-3 col-sm-3  label-align">Date<span
                                                class="required">*</span></label>
                                        <div class="col-md-6 col-sm-6">
                                            <input class="form-control"
                                                   class='date' type="date"
                                                   name="date"
                                                   required='required'></div>
                                    </div>
                                    <div class="field item form-group">
                                        <label class="col-form-label col-md-3 col-sm-3  label-align">Time<span
                                                class="required">*</span></label>
                                        <div class="col-md-6 col-sm-6">
                                            <input class="form-control"
                                                   class='time' type="time"
                                                   name="time"
                                                   required='required'></div>
                                    </div>
                                    <div class="field item form-group">
                                        <label class="col-form-label col-md-3 col-sm-3  label-align">Password<span
                                                class="required">*</span></label>
                                        <div class="col-md-6 col-sm-6">
                                            <input class="form-control"
                                                   type="password"
                                                   name="password"
                                                   data-validate-length="6,8"
                                                   required='required'/></div>
                                    </div>
                                    <div class="field item form-group">
                                        <label class="col-form-label col-md-3 col-sm-3  label-align">Repeat
                                            password<span
                                                    class="required">*</span></label>
                                        <div class="col-md-6 col-sm-6">
                                            <input class="form-control"
                                                   type="password"
                                                   name="password2"
                                                   data-validate-linked='password'
                                                   required='required'/></div>
                                    </div>
                                    <div class="field item form-group">
                                        <label class="col-form-label col-md-3 col-sm-3  label-align">Telephone<span
                                                class="required">*</span></label>
                                        <div class="col-md-6 col-sm-6">
                                            <input class="form-control"
                                                   type="tel" class='tel'
                                                   name="phone"
                                                   required='required'
                                                   data-validate-length-range="8,20"/>
                                        </div>
                                    </div>
                                    <div class="field item form-group">
                                        <label class="col-form-label col-md-3 col-sm-3  label-align">message<span
                                                class="required">*</span></label>
                                        <div class="col-md-6 col-sm-6">
                                            <textarea required="required"
                                                      name='message'></textarea>
                                        </div>
                                    </div>
                                    <div class="ln_solid">
                                        <div class="form-group">
                                            <div class="col-md-6 offset-md-3">
                                                <button type='submit'
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
<!-- bootstrap-progressbar -->
<script src="${pageContext.request.contextPath}/static/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
<!-- iCheck -->
<script src="${pageContext.request.contextPath}/static/vendors/iCheck/icheck.min.js"></script>
<!-- bootstrap-daterangepicker -->
<script src="${pageContext.request.contextPath}/static/vendors/moment/min/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/static/vendors/bootstrap-daterangepicker/daterangepicker.js"></script>
<!-- bootstrap-wysiwyg -->
<script src="${pageContext.request.contextPath}/static/vendors/bootstrap-wysiwyg/js/bootstrap-wysiwyg.min.js"></script>
<script src="${pageContext.request.contextPath}/static/vendors/jquery.hotkeys/jquery.hotkeys.js"></script>
<script src="${pageContext.request.contextPath}/static/vendors/google-code-prettify/src/prettify.js"></script>
<!-- jQuery Tags Input -->
<script src="${pageContext.request.contextPath}/static/vendors/jquery.tagsinput/src/jquery.tagsinput.js"></script>
<!-- Switchery -->
<script src="${pageContext.request.contextPath}/static/vendors/switchery/dist/switchery.min.js"></script>
<!-- Select2 -->
<script src="${pageContext.request.contextPath}/static/vendors/select2/dist/js/select2.full.min.js"></script>
<!-- Parsley -->
<script src="${pageContext.request.contextPath}/static/vendors/parsleyjs/dist/parsley.min.js"></script>
<!-- Autosize -->
<script src="${pageContext.request.contextPath}/static/vendors/autosize/dist/autosize.min.js"></script>
<!-- jQuery autocomplete -->
<script src="${pageContext.request.contextPath}/static/vendors/devbridge-autocomplete/dist/jquery.autocomplete.min.js"></script>
<!-- starrr -->
<script src="${pageContext.request.contextPath}/static/vendors/starrr/dist/starrr.js"></script>
<!-- Custom Theme Scripts -->
<script src="${pageContext.request.contextPath}/static/build/js/custom.min.js"></script>

</body>
</html>
