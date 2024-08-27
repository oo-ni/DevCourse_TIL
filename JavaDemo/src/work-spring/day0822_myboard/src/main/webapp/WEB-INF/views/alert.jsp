<%--
  Created by IntelliJ IDEA.
  User: geonoo
  Date: 2024. 8. 22.
  Time: 오후 2:19
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
    location.href = '<%=request.getAttribute("path")%>'
</script>
</body>
</html>
