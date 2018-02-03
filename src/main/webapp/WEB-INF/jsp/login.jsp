<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2018/1/29
  Time: 16:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.3.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
    <title>登录</title>
</head>
<body>
    <div class="container">
        <form class="form-horizontal" role="form" action="${pageContext.request.contextPath}/login" method="post">
            <div class="alert alert-danger">${error}</div>
            <div class="form-group">
                <label class="col-sm-2 control-label" >账号</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="username" name="email" placeholder="email@example.com">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">密码</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="password" name="pwd" placeholder="请输入密码">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" id="rememberMe">记住我
                        </label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button id="login" type="submit" class="btn btn-default">提交</button>
                </div>
            </div>
        </form>
    </div>

</body>
</html>
