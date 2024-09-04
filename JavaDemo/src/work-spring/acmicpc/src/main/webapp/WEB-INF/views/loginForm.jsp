<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<h2>로그인</h2>
<form action="<%= request.getContextPath() %>/users/login" method="post">
    <table>
        <tr>
            <td>ID :</td>
            <td><input type="text" id="user_id" name="userId" required/></td>
        </tr>
        <tr>
            <td>PW :</td>
            <td><input type="password" id="user_pw" name="userPw" required/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="LOGIN">
            </td>
        </tr>
    </table>
</form>

<br>
<a href="<%= request.getContextPath() %>/users/register">회원가입</a>
</body>
</html>