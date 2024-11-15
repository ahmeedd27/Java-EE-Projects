<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

    <head>
        <title>User Management Application</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>

    <body>

        <header>
            <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">


                <ul class="navbar-nav">
                    <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Users</a></li>
                </ul>
            </nav>
        </header>
        <br>

        <div class="row">
           

            <div class="container">
                <h3 class="text-center">List of Users</h3>
                <hr>
                <div class="container text-left">

                    <a href="adduser.html" class="btn btn-success">Add
                        New User</a>
                </div>
                <br>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Country</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach var="user" items="${adu}">

                            <tr>
                                <td>
                                    <c:out value="${user.id}" />
                                </td>
                                <td>
                                    <c:out value="${user.name}" />
                                </td>
                                <td>
                                    <c:out value="${user.email}" />
                                </td>
                                <td>
                                    <c:out value="${user.country}" />
                                </td>
                                <td>
                                    <a class="edit-btn" href="edituser.jsp?id=<c:out value='${user.id}' />">Edit</a>
                                   &nbsp;&nbsp;&nbsp;&nbsp;
                                    <a class="delete-btn" href="deletecontroller?id=<c:out value='${user.id}' />">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>

                    </tbody>

                </table>
            </div>
        </div>
    </body>

</html>