
package controller;

import DaoImpl.DaoMethods;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deletecontroller")
public class DeleteController extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        int id=Integer.parseInt(request.getParameter("id"));
        DaoMethods d=new DaoMethods();
        boolean set=d.deleteUser(id);
        RequestDispatcher v = request.getRequestDispatcher("beforecontroller");
        v.forward(request, response);
        
        
        
        
        
        
        
        
        
        
        
        
        response.setContentType("text/html;charset=UTF-8");
     PrintWriter out = response.getWriter();
       
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
