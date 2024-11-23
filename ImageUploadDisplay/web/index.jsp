

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    <body>
        <center>
         <b>Upload | <a href="view.jsp">View</a></b><br/><br/>
        <form action="uploadcontrol" method="post" enctype="multipart/form-data">
            <input type="file" name="image" required="required"/><br/><br/>
            <input type="submit"/>
        </form>
         </center>
    </body>
</html>
