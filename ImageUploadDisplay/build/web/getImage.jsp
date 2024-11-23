
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.io.*"%>
<%@page   import="dbconnection.DbConnection"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GET IMAGE</title>
    </head>
    <body>
        <%
            int id = Integer.parseInt(request.getParameter("id"));
            try {
                Connection con = DbConnection.getConnection();
                String sql = "select image from imagetable where id=?";
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setInt(1, id);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                        Blob blob=rs.getBlob("image");
                        byte b[]=blob.getBytes(1, (int) blob.length());
                         response.setContentType("image/gif");
                        OutputStream os=response.getOutputStream();
                        os.write(b);
                        os.flush();
                      os.close();
                        
                }else{
                out.println("<h1>not found</h1>");
            }
            } catch (Exception e) {
                System.out.println(e);
            }


        %>
    </body>
</html>
