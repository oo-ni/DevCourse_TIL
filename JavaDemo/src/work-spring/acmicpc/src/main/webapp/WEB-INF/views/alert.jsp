<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script>
    alert('<%=request.getAttribute("msg")%>');
    location.href = '<%=request.getAttribute("path")%>';
</script>

</body>
</html>