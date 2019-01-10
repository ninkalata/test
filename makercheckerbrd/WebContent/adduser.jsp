<%@page import="com.demo.dao.UserDao"%>
<jsp:useBean id="U" class="com.demo.model.User"></jsp:useBean>
<jsp:setProperty property="*" name="U"/>

<%
int i=UserDao.save(U);
if(i>0){
response.sendRedirect("adduser-success.jsp");
}else{
response.sendRedirect("adduser-error.jsp");
}
%>