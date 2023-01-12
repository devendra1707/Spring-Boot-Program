<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@page session="false"%>
<html>
<head>
<title>Welcome</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	 <sec:csrfInput />     
	<h3 style="color: red;">Hello Admin</h3>
</body>
</html>