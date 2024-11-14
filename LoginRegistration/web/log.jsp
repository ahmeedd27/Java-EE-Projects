<%-- 
    Document   : log
    Created on : Nov 14, 2024, 10:19:34 AM
    Author     : computop
logout
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
       <%
       
       session.removeAttribute("name");
       RequestDispatcher v=request.getRequestDispatcher("login.jsp");
       v.forward(request, response);
       
       %>
    </body>
</html>
