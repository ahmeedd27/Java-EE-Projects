
package com.mycompany.fileuploadmavenproject;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;




@WebServlet("/uploadsingle")
@MultipartConfig(
       location="D:\\save",
        fileSizeThreshold= 1024 * 1024 ,// 1mega // that means if file less than 1 megabyte
                                         //  will stored on server (حفظ مؤقت) and if bigger than 1 mega
                                         // it will stored on disk
        maxFileSize=  1024 * 1024 * 10,
        maxRequestSize=1024 * 1024 * 11
)
public class UploadSingleController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String desc=request.getParameter("description");
        System.out.println("Description : "+desc);
        
        String m="";
        try{
        Part part=request.getPart("file");//this file in doublequates that is in html form in form input
      // idintify the part i want from the request 
        //HttpServletRequest.getPart(name) // getInputStream used to read content of a part
        part.write(getFileName(part));// saves the uploaded file with the given filename location in the annotation
         m="your file uploaded!!!";
        }catch(ServletException | IOException ee){
            System.out.println(ee);
        }
       request.setAttribute("message", m);
       request.getRequestDispatcher("view.jsp").forward(request, response);
         
         
         response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
     }
    
    
        private String getFileName(Part p){
            String cD=p.getHeader("content-disposition");
            if(!cD.contains("filename=")){
                return null;
            }
            int beginIndex=cD.indexOf("filename=")+10;
            int endIndex=cD.length()-1;
            
            
            return cD.substring(beginIndex, endIndex);
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
