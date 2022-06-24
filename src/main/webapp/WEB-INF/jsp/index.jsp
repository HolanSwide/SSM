<%--
  Created by IntelliJ IDEA.
  User: holan
  Date: 2022/6/24
  Time: 0:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
<h1 align="center">EVANGELION</h1><br><hr><br>
<form align="center" action="${pageContext.request.contextPath}/user/login">
    <br>Username: <label for="username"></label><input type="text" id="username" name="username" value="Hello" ><br>
    <br>Password: <label for="password"></label><input type="password" id="password" name="password" ><br>
    <br><button type="submit" id="submit" name="submit">LOGIN</button>
</form>

<hr>

<form align="center" action="${pageContext.request.contextPath}/user/register">
    <br>Username: <label for="username"></label><input type="text" id="Rusername" name="username" value="Hello" ><br>
    <br>Password: <label for="password"></label><input type="password" id="Rpassword" name="password" ><br>
    <br><button type="submit" id="register" name="register">REGISTER</button>
</form>

</body>
</html>
<script>
    function a() {
        alert( "${msg}" );
    }
    window.onload=a;
</script>

<script>

    /* 3.获取响应 */
</script>
