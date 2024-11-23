
package controllers;

import dbconnection.DbConnection;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.InputStream;
import java.sql.*;

@WebServlet("/uploadcontrol")
@MultipartConfig(
maxFileSize = 1024*1024*10

)
public class UploadController extends HttpServlet {

    private static final long serialVersionUID = 1L;

   Connection con;
   PreparedStatement pst;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Part p=request.getPart("image");
        if(p!=null){
            try{
                InputStream is=p.getInputStream();
                String sql="insert into imagetable(image) values(?)";
                con=DbConnection.getConnection();
                 pst=con.prepareStatement(sql);
                pst.setBlob(1,is);
                int set=pst.executeUpdate();
                if(set>0){
                    response.sendRedirect("view.jsp");
                }
                else{
                    response.sendRedirect("index.jsp");
                }
                
                
            }catch(IOException | SQLException e){
                System.out.println(e);
            }
        }
       
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
