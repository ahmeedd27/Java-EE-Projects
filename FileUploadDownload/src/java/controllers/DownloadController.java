
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.FileInputStream;

@WebServlet("/download")
public class DownloadController extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      // PrintWriter out = response.getWriter();
      ServletOutputStream sos=response.getOutputStream();
       String filename=request.getParameter("filename");
       String path = "G:\\save\\";
       response.setContentType("APPLICATION/OCTET-STREAM");
       response.setHeader("Content-Disposition", "attachment;filename=\""+filename+"\"");
       FileInputStream fis=new FileInputStream(path+filename);
       response.setContentLength(fis.available());
       int i;
       while((i=fis.read())!=-1){
           sos.write(i);
           sos.flush() ;
           sos.close();
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
