<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/4/16
  Time: 19:48
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

    <title>管理员登录</title>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/static/vendors/bootstrap/dist/css/bootstrap.min.css"
          rel="stylesheet">
    <!-- Font Awesome -->
    <link href="${pageContext.request.contextPath}/static/vendors/font-awesome/css/font-awesome.min.css"
          rel="stylesheet">
    <!-- NProgress -->
    <link href="${pageContext.request.contextPath}/static/vendors/nprogress/nprogress.css"
          rel="stylesheet">
    <!-- Animate.css -->
    <link href="${pageContext.request.contextPath}/static/vendors/animate.css/animate.min.css"
          rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="${pageContext.request.contextPath}/static/build/css/custom.min.css"
          rel="stylesheet">

    <script
            src="${pageContext.request.contextPath}/static/JS/login.js"></script>
</head>

<body class="login">
<div>
    <a class="hiddenanchor" id="signup"></a>
    <a class="hiddenanchor" id="signin"></a>

    <div class="login_wrapper">
        <div class="animate form login_form">
            <section class="login_content">
                <div>
                    <h1>Login Form</h1>
                    <div>
                        <input type="text" id="username" class="form-control"
                               placeholder="Username" required=""/>
                    </div>
                    <div>
                        <input type="password" id="userpassword"
                               class="form-control" placeholder="Password"
                               required=""/>
                    </div>
                    <br>
                    <div>
                        <a class="btn btn-default submit"
                           onclick="login()" href="#">Log in</a>
                    </div>

                    <div class="clearfix"></div>

                    <div class="separator">
                        <p class="change_link">New to site?
                            <a href="#">Please contact customer service
                            </a>
                            <!--
                            <a href="#signup" class="to_register"> Create
                                Account </a>
                            -->
                        </p>

                        <div class="clearfix"></div>
                        <br/>

                        <div>
                            <h1><i class="fa"></i> NBA GAME INFORMATION</h1>
                            <p>©2020 All Rights Reserved. NBA GAME INFORMATION! is a
                                background management system.</p>
                        </div>
                    </div>
                    <!-- 暂时不考虑自助注册-->
                </div>
            </section>
        </div>
    </div>
</div>
<!-- jQuery -->
<script src="${pageContext.request.contextPath}/static/vendors/jquery/dist/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/JS/login.js"></script>
</body>
</html>
