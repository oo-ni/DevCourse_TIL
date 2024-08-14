<%--
  Created by IntelliJ IDEA.
  User: geonoo
  Date: 2024. 8. 14.
  Time: 오후 3:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>니가 들고온 쿠키~</h3>
<%
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
    for (Cookie c : cookies) {
%>
    쿠키 이름 : <%= c.getName()%> <br>
    쿠키 값 : <%= c.getValue()%> <br>
    <hr>
<% }
    } else {
        response.getWriter().println("쿠키 없는데! <br>");
}
%>
</body>
</html>
