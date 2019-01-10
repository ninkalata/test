<%@page import="com.demo.dao.UserDao"%>
<jsp:useBean id="U" class="com.demo.model.User"></jsp:useBean>
<jsp:setProperty property="*" name="U"/>

<%

String code=request.getParameter("customerCode");
System.out.println(code);
//request.getSession(true).setAttribute("code",code);

System.out.println();

int i=UserDao.update(U);
response.sendRedirect("viewusers.jsp");

%>