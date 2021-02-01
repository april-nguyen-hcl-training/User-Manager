<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.hcl.usermanager.domain.Account"%>

<html>
  <head>
    <%@ include file="parts/bootstrap.jsp" %>
    <%@ include file="parts/style.jsp" %>
    <title>Welcome</title>
  </head>
  <body class="text-left">
  <main class="account">
    <p class="mb-3" style="color:green;"><c:out value="${accountSuccessAlert}"/></p>

    <h1>Hello, <c:out value="${account.username}"/></h1>

    <p>First Name: <c:out value="${account.firstName}"/></p>
    <p>Last Name: <c:out value="${account.lastName}"/></p>
    <p>Email: <c:out value="${account.email}"/></p>

    <fmt:formatDate value="${account.birthday}" var="formattedBirthday" type="date" pattern="MMMM dd, yyyy" timeZone="z" />
    <p>Birthday: <c:out value="${formattedBirthday}"/></p>

    <fmt:formatDate value="${account.dateCreated}" var="formattedDateCreated" type="date" pattern="MMMM dd, yyyy" timeZone="z"/>
    <p>Joined: <c:out value="${formattedDateCreated}"/></p>

    <a href="logout">Logout</a>
  </main>
  </body>
</html>
