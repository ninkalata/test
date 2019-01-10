<%-- <%@page import="com.demo.dao.UserDao"%>
<jsp:useBean id="U" class="com.demo.model.User"></jsp:useBean>
<jsp:setProperty property="*" name="U" /> --%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style>
input[type=text], select {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
}

input[type=textarea], input[input=text]:focus {
	background-color: #ddd;
	outline: none;
}

/* Overwrite default styles of hr */
hr {
	border: 1px solid #f1f1f1;
	margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
	background-color: #008CBA;
	color: white;
	padding: 16px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	opacity: 0.9;
}

.registerbtn:hover {
	opacity: 1;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
	background-color: #f1f1f1;
	text-align: center;
}

div {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}
</style>

</head>
<body style="background-color: powderblue;">
	<title>Edit Form</title>
</head>
<body>
	<%@page import="com.demo.dao.UserDao,com.demo.model.User "%>

	<%
		String customerCode = request.getParameter("customerCode");
	
	
		User U=UserDao.getRecordById(customerCode);  
		 
		 %>


	<h1>Edit Form</h1>
	<center>
		<form action="edituser.jsp" name="U" style="width: 500px"
			method="post">
			<div class="container">
				<div class="dropdown">
					<h1>REGISTER FORM</h1>
					<p>Please fill in this form to create an account.</p>
					<hr>



					<label for="customerCode"><b>CustomerCode</b></label> <input
						type="text" placeholder="Enter CustomerCode" name="customerCode"
						value="<%=U.getCustomerCode()%>" required /> <label
						for="customerName"><b>CustomerName</b></label> <input type="text"
						placeholder="customerName" name="customerName"
						value="<%=U.getCustomerName()%>" required
						pattern="^[a-zA-Z0-9 ]*$" title="Invalid characters"> <label
						for="customerAddress1"><b>CustomerAddress1</b></label>
					<textarea rows="2" cols="60" placeholder="CustomerAddress1"
						name="customerAddress1" value="<%=U.getCustomerAddress1()%>"
						required></textarea>

					<label for="customerAddress2"><b>CustomerAddress2</b></label>
					<textarea rows="2" cols="60" placeholder="CustomerAddress2"
						name="customerAddress2" value="<%=U.getCustomerAddress2()%>"
						required></textarea>

					<label for="customerPinCode"><b>customerPinCode</b></label> <input
						type="text" placeholder="CustomerPinCode" name="customerPinCode"
						value="<%=U.getCustomerPinCode()%>" pattern=".{6}"
						title="Pin code should be 6 digits"> <label
						for="emailaddress"><b>Emailaddress</b></label> <input type="text"
						placeholder="Emailaddress" name="emailaddress" id=" emailaddress "
						value="<%=U.getEmailaddress()%>"
						pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"
						title="Invalid Email format" value="ninkalata@gmail.com">

					<label for="contactNumber"><b>ContactNumber</b></label> <input
						type="text" placeholder="ContactNumber" name="contactNumber"
						value="<%=U.getContactNumber()%>" required> <label
						for="primaryContactPerson"><b>PrimaryContactPerson</b></label> <input
						type="text" placeholder="PrimaryContactPerson"
						name="primaryContactPerson" required
						value="<%=U.getPrimaryContactPerson()%>" /> <label
						for="activeInactiveFlag"><b>ActiveInactiveFlag</b></label> <select
						name="activeInactiveFlag" value="<%=U.getActiveInactiveFlag()%>">
						<option value="A">Active</option>
						<option value="I">Inactive</option>
					</select> <label for="createdBy"><b>CreatedBy</b></label> <input type="text"
						placeholder="CreatedBy" name="createdBy" required
						value="<%=U.getCreateBy()%>" value=" maker"
						title="invalid user id" /> <label for="modifiedBy"><b>ModifiedBy</b></label>
					<input type="text" placeholder="modifiedBy" name="modifiedBy"
						value="<%=U.getModifiedBy()%>" required /> <label
						for="authorizedBy"><b>AuthorizedBy</b></label> <input type="text"
						placeholder="AuthorizedBy" name="authorizedBy"
						value="<%=U.getAuthorizedBy()%>" required />

					<hr>
					<hr>


					<button type="submit" class="registerbtn">Register</button>
				</div>
			</div>
			</div>

		</form>