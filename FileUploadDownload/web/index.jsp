<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Servlet File Upload/Download</title>
    </head>
    <body>
        <br><br><br><br>
    <center>
        
        <form action="upload" method="post" enctype="multipart/form-data">
            <table width="400px" align="center" border=2>
                <tr>
                    <td align="center" colspan="2">Form Details</td>
                </tr>
                 <tr>
                    <td> ID </td>
                    <td>
                        <input type="text" required="" name="id">
                    </td>
                </tr>
                <tr>
                    <td> Name </td>
                    <td>
                        <input type="text" required="" name="name">
                    </td>
                </tr>
                <tr>
                    <td>Select File </td>
                    <td>
                        <input type="file" required="" name="file">
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Submit"></td>
                </tr>
            </table>

        </form>
        <br><a href = "before">View List</a>
    </center>
</body>
</html>