<%--
  Created by IntelliJ IDEA.
  User: geonoo
  Date: 2024. 8. 19.
  Time: 오후 3:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <script>
        alert('<%=request.getAttribute("msg")%>');
        location.href = "<%=request.getAttribute("path")%>"
    </script>
</body>
</html>
