package controller;

import Dao.DaoImpl;
import connection.DbConnection;
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
import java.sql.*;
// login servlet to take data and check if true by calling method
@WebServlet("/login")
public class MyLoginController extends HttpServlet {

    Employee e;
    DaoImpl d;

    @Override
    public void init() {

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        HttpSession s = request.getSession();
        RequestDispatcher v = null;
        String email = request.getParameter("email");
        String password = request.getParameter("password");
       
        d = new DaoImpl();
        e = new Employee();
        e= d.log(email, password);
        
        try {
            if (e != null  && email!=null && email != "" && password!=null && password!="") {
                s.setAttribute("name", e);
                v = request.getRequestDispatcher("view.jsp");
            } else {
                v = request.getRequestDispatcher("reg.jsp");

            }
            v.forward(request, response);
        } catch (ServletException | IOException ed) {
            System.out.println(ed);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(MyLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(MyLoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
