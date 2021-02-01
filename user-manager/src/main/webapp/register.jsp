<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.hcl.usermanager.domain.Account"%>

<html>
  <head>
    <%@ include file="parts/bootstrap.jsp" %>
    <%@ include file="parts/style.jsp" %>

    <title>User Registration</title>
  </head>
  <body class="text-left">
  <main class="form-signup">
    <h1 class="mb-3 text-center">Register</h1>

    <form action='register' method='post'>
      <div class="mb-3">
        <label for="usernameInput" class="form-label">Username</label>
        <input type="text" class="form-control" id="usernameInput" name='username' required
          value="${accountInput.username}">
        <p style="color:red;"><c:out value="${usernameAlert}"/></p>
      </div>

      <div class="mb-3">
        <label for="passwordInput" class="form-label">Password</label>
        <input type="password" class="form-control" id="passwordInput" name='password' required>
        <p style="color:red;"><c:out value="${passwordAlert}"/></p>
      </div>

      <div class="mb-3">
        <label for="firstNameInput" class="form-label">First Name</label>
        <input type="text" class="form-control" id="firstNameInput" name='firstName' required
          value="${accountInput.firstName}">
        <p style="color:red;"><c:out value="${firstNameAlert}"/></p>
      </div>

      <div class="mb-3">
        <label for="lastNameInput" class="form-label">Last Name</label>
        <input type="text" class="form-control" id="lastNameInput" name='lastName' required
          value="${accountInput.lastName}">
        <p style="color:red;"><c:out value="${lastNameAlert}"/></p>
      </div>

      <div class="mb-3">
        <label for="emailInput" class="form-label">Email Address</label>
        <input type="email" class="form-control" id="emailInput" aria-describedby="emailHelp" name='email' required
          value="${accountInput.email}">
      </div>

      <div class="mb-3">
        <fmt:formatDate value="${accountInput.birthday}" var="formattedBirthday" type="date" pattern="yyyy-MM-dd" />
        <label for="birthdayInput" class="form-label">Birthday</label>
        <input class="form-control" type="date" id="birthdayInput" name='birthday' required
          value="${formattedBirthday}">
        <p style="color:red;"><c:out value="${birthdayAlert}"/></p>
      </div>

      <button class="w-100 btn btn-lg btn-primary" type="submit">Register</button>
    </form>

  </main>
  </body>
</html>
