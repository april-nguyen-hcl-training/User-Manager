<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <%@ include file="parts/bootstrap.jsp" %>
        <%@ include file="parts/style.jsp" %>
        <title>User Login</title>
    </head>

    <body class="text-center">
    <main class="form-signin">

    <p class="mb-3" style="color:green;"><c:out value="${logoutAlert}"/></p>

    <h1 class="mb-3">Please Login</h1>
    <form action='login' method='post'>
        <label for="username" class="visually-hidden">Username</label>
        <input type="text" id="username" class="form-control" placeholder="Username" name='username' required autofocus
          value="${username}">

        <label for="inputPassword" class="visually-hidden">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" name='password' required>

        <p class="mb-3" style="color:red;"><c:out value="${loginAlert}"/></p>

        <button class="w-100 btn btn-lg btn-primary" type="submit">Login</button>
    </form>

    <a href="register">Register</a>
    </main>

    </body>
</html>