
package controller;

import Dao.DaoImpl;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Employee;
// register servlet to save data into the instance of the bean and forword to next page
@WebServlet("/regcontrol")
public class MyRegisterController extends HttpServlet {
    DaoImpl d;
    @Override
    public void init(){
        d=new DaoImpl();
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        String nname = request.getParameter("name");
        String eemail = request.getParameter("email");
        String ppassword = request.getParameter("password");
        String ccontact = request.getParameter("contact");
       Employee e=new Employee(nname , eemail , ppassword , ccontact);
       HttpSession s=request.getSession();
       s.setAttribute("attr", e);
       
        try {
            d.registerEmployee(e);
        } catch (SQLException ee) {
            System.out.println(ee);
        }

        RequestDispatcher v=request.getRequestDispatcher("login.jsp");
        v.forward(request, response);
    }
   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);

        } catch (SQLException ex) {
            Logger.getLogger(MyRegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(MyRegisterController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
