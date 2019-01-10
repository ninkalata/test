<%@page import="com.demo.dao.UserDao"%>
<jsp:useBean id="U" class="com.demo.model.User"></jsp:useBean>
<jsp:setProperty property="*" name="U"/>

<%
UserDao.delete(U);
response.sendRedirect("viewusers.jsp");
%>