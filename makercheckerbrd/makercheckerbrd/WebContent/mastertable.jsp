<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Users</title>
</head>
<body>

<%@page import="com.demo.dao.UserDao,com.demo.model.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Users List</h1>

<%
List<User> list=UserDao.getAllRecords();
request.setAttribute("list",list);
for(int i=0;i<17;i++)
{
System.out.println(list);
}
%>

<table border="1" width="90%">
<tr><th>CustomerId</th>
<th>CustomerCode</th>
<th>CustomerName</th>
<th>CustomerAddress1</th>
<th>CustomerAddress2</th>
<th>customerPinCode</th>
<th>Emailaddress</th>
<th>ContactNumber</th>
<th>PrimaryContactPerson</th>
<th>RecordStatus</th>
<th>ActiveInactiveFlag</th>

 <th>CreateDate</th>
 <th>CreateBy</th>
 <th>ModifiedDate</th>
<th>ModifiedBy</th>
<th>AuthorizedDate</th>
<th>AuthorizedBy</th>
<th>Edit</th>
<th>Delete</th></tr>
<c:forEach items="${list}" var="U">
	<tr><td>${U.getCustomerId()}</td>
	<td>${U.getCustomerCode()}</td>
	<td>${U.getCustomerName()}</td>
	<td>${U.getCustomerAddress1()}</td>
	<td>${U.getCustomerAddress2()}</td>
	<td>${U.getCustomerPinCode()}</td>
	<td>${U.getEmailaddress()}</td>
	<td>${U.getContactNumber()}</td>
	<td>${U.getPrimaryContactPerson()}</td>
	<td>${U.getRecordStatus()}</td>
	<td>${U.getActiveInactiveFlag()}</td>
	<td>${U.getCreateDate( )}</td>
	<td>${U.getCreateBy()}</td>
	<td>${U.getModifiedDate( ) }</td>
	<td>${U.getModifiedBy()}</td>
	 <td>${U.getAuthorizedDate( ) }</td>
	 <td>${U.getAuthorizedBy()}</td>
	 <td><a href="editform.jsp?customerCode=${U.getCustomerCode()}">Edit</a>
	 </td><td><a href="deleteuser.jsp?customerCode=${U.getCustomerCode()}">Delete</a></td></tr>
	
</c:forEach>
</table>
<br/><a href="adduserform.jsp">Add New User</a>

</body>
</html>