<%--
  Created by IntelliJ IDEA.
  User: v.davidenko
  Date: 18.01.2016
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>

<body>

<h3>&nbsp;&nbsp;Login form</h3>

<form action="/loginform" method="post">
    <table border="1" cellpadding="5" align="left">
        <tr>
            <td>Login:</td>
            <td><input type="text" name="login" size="10" maxlength="10"/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password" size="10" maxlength="10"/></td>
        </tr>
        <tr>
            <td align="center"><input type="submit" value="Login"/></td>
            <td align="center"><a href="/regform.jsp">Registration</a></td>
        </tr>
    </table>

</form>

</body>

</html>