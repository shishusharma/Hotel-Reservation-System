/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "EditBooking", urlPatterns = {"/EditBooking"})
public class EditBooking extends HttpServlet {

    
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String bno=request.getParameter("bno");
            String name=request.getParameter("ecname");
            String address=request.getParameter("eadr");
            String contact=request.getParameter("econtact");
            String occ=request.getParameter("eoccupancy");
            String days=request.getParameter("edays");
            String gender=request.getParameter("egender");
            String nationality=request.getParameter("enationality");
            String status=request.getParameter("estatus");
            String purpose=request.getParameter("epurpose");
            out.println(hrs.HRSManager.updateBooking(bno,name,address,contact,new Integer(occ),new Integer(days),gender,
                                                     nationality,status,purpose ));
        }
    }

}
