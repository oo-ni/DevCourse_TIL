<%@ page import="com.grepp.boot.model.dto.UserDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    UserDTO loginUser = (UserDTO) session.getAttribute("loginUser");
    if(loginUser != null){
%>
<%= loginUser.getUserId() %>님 로그인 중이시네요. 환영합니다.<br/>
<a href="<%= request.getContextPath() %>/users/logout">[로그아웃]</a>
<%
}else{
%>
<a href="<%= request.getContextPath() %>/users/login">[로그인 하러 가기]</a>
<a href="<%= request.getContextPath() %>/users/join">[회원가입]</a>
<%}%>
<hr>

