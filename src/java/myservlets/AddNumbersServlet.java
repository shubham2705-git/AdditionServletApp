/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myservlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddNumbersServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();
        String fno = request.getParameter("fno");
        String sno = request.getParameter("sno");
        RequestDispatcher rd = null;
        if(fno.isEmpty() || sno.isEmpty()){
            pw.println("<span style='color:crimson'>Please input both values</span>");
            rd = request.getRequestDispatcher("index.html");
            rd.include(request,response);
        }else{
            try{
                int first = Integer.parseInt(fno);
                int second = Integer.parseInt(sno);
                int sum=first+second;
                request.setAttribute("fno",first);
                request.setAttribute("sno",second);
                request.setAttribute("total",sum);
                rd = request.getRequestDispatcher("DisplayResultServlet");
                rd.forward(request,response);
            }catch(NumberFormatException ex){
                pw.println("<span style='color:crimson'>Please input integer only</span>");
                rd = request.getRequestDispatcher("index.html");
                rd.include(request,response);
                
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
