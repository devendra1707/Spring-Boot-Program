<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register User</title>
</head>
<body>
	<h3 style="color: red;">Register New User</h3>

	<div id="registerEmployee">
		<form:form action="/register" method="post" modelAttribute="user">
			<p>
				
			
				<label>Enter username</label>
				<form:input path="username" />
			</p>
			<p>
				<label>Enter password</label>
				<form:input path="password" />
			</p>
			<input type="SUBMIT" value="Submit" />
		</form:form>
		 <sec:csrfInput />     
	</div>
</body>
</html>