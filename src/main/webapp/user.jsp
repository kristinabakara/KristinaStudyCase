<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>USER</title>
</head>
<body>

    <form method="POST" action='GetUser' name="frmAddUser">
        User ID : <input type="text" name="userid" readonly="readonly"
            value="<c:out value="${user.userid}" />" /> <br /> 
        First Name : <input
            type="text" name="firstName"
            value="<c:out value="${user.firstname}" />" /> <br /> 
        Last Name : <input
            type="text" name="lastName"
            value="<c:out value="${user.lastname}" />" /> <br /> 
        Username : <input
            type="text" name="username"
            value="<c:out value="${user.username}" />" /> <br /> 
        Password : <input type="text" name="password"
            value="<c:out value="${user.password}" />" /> <br /> <input
            type="submit" value="Submit" />
    </form>
</body>
</html>