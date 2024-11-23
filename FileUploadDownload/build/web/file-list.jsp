<%@taglib   prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LIST PAGE</title>
    </head>
    <body>
    <center>
        <table border="2">
            <tr>
                <th>Id</th><th>Name</th><th>File Name</th><th>File Path</th>
            </tr>
            <tbody>
            <c:forEach var="f" items="${requestScope.list}">
                <tr>
                    <td><c:out value="${f.id}" /></td>
                    
                  <td> <c:out value="${f.name}" /></td>
                   
                   <td> <c:out value="${f.filename}" /></td>
                   
                  <td> <c:out value="${f.filepath}" /> </td>
                   
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </center>
</body>
</html>
