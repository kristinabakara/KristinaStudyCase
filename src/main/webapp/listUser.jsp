<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List User</title>
</head>
<body>


<table border=1>
        <thead>
            <tr>
                <th>User Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Username</th>
                <th>Password</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.userid}</td>
                    <%-- <td><c:out value="${user.userid}" /></td> --%>
                    <td><c:out value="${user.firstname}" /></td>
                    <td><c:out value="${user.lastname}" /></td>
                    <td><c:out value="${user.username}" /></td>
                    <td><c:out value="${user.password}" /></td>
                    <td><a href="GetUser?action=edit&userId=<c:out value="${user.userid}"/>">Update</a></td>
                    <td><a href="GetUser?action=delete&userId=<c:out value="${user.userid}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="GetUser?action=insert">Add User</a></p>



</body>
</html>