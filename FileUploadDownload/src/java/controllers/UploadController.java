package controllers;

import db.DbQueries;
import jakarta.servlet.RequestDispatcher;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/upload")
@MultipartConfig(
        location = "G:\\save",
        fileSizeThreshold = 1024 * 1024 * 10,
        maxFileSize = 1024 * 1024 * 1000,
        maxRequestSize = 1024 * 1024 * 1000
)
public class UploadController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Part part = request.getPart("file");
        String name = request.getParameter("name");
        int id=Integer.parseInt(request.getParameter("id"));
        String filename = part.getSubmittedFileName();
        String filepath = "G:\\save\\" + filename;
        
        part.write(filename);
        DbQueries d = new DbQueries();
        String m;
        try {
            boolean set = d.saveFile(id,name, filename, filepath);

            if (set) {
                request.setAttribute("fn", filename);
                m = "uploded and saved in databse successfully ...";
                request.setAttribute("attr", m);
                RequestDispatcher v = request.getRequestDispatcher("view.jsp");
                v.forward(request, response);
            } else {
                 RequestDispatcher v = request.getRequestDispatcher("index.jsp");
                v.forward(request, response);
            }

        } catch (SQLException e) {
            System.out.println(e);
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
