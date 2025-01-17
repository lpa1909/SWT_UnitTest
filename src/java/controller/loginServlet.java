/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.DBContext;
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
import model.Account;

/**
 *
 * @author NGUYEN LAN
 */
@WebServlet(name="loginServlet", urlPatterns={"/login"})
public class loginServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet loginServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet loginServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//    throws ServletException, IOException {
//        
//        try {
//            String email = request.getParameter("email");
//            String password = request.getParameter("pass");
//            
//            DBContext db = new DBContext();
//            Account a = db.login(email, password);
//            if(a == null){
//                request.setAttribute("mess", "Your email or password is wrong");
//                request.getRequestDispatcher("login.jsp").forward(request, response);
//            }else{
//                HttpSession session = request.getSession();
//                session.setAttribute("acc", a);
//                session.setMaxInactiveInterval(1728000);
//                response.sendRedirect("home");
//            }
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(loginServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("pass");
            if(email.isEmpty() || password.isEmpty()){
                request.setAttribute("mess", "Email or password is not empty.");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            DBContext db = new DBContext();
            Account a = db.login(email, password);
            if(a == null){
                request.setAttribute("mess", "Your email or password is wrong");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }else{
                HttpSession session = request.getSession();
                session.setAttribute("acc", a);
                session.setMaxInactiveInterval(1728000);
                response.sendRedirect("home");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(loginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
