<%-- 
    Document   : view
    Created on : Nov 14, 2024, 1:09:47 AM
    Author     : computop
--%>

<%@page import="model.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      <h2>you successfully logged in </h2>
       <%
           HttpSession ss=request.getSession();  
         Employee s=(Employee) ss.getAttribute("name");
       %>
   <h2>name : </h2> <%= s.getName() %> <br>
    <h2>contact : </h2> <%= s.getContact() %> <hr><br>
    <a href="log.jsp">logOut</a>
    </body>
</html>
