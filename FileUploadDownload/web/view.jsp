<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Page</title>
    </head>
    <body>
        <center>
        <c:if test="${requestScope.attr!=null}">
            <c:out value="${requestScope.attr}" />    
        </c:if><br><br><br>
        <c:if test="${requestScope.fn!=null}">
            <c:set var="file" scope="request" value="${requestScope.fn}" />  
        </c:if>
        <a href="<c:url value="download?filename=${file}"/>">DOWNLOAD</a> &nbsp;&nbsp;&nbsp;
        <a href="<c:url  value="before" />">VIEW LIST</a>
            
            
            
            
            </center>
    </body>
</html>
