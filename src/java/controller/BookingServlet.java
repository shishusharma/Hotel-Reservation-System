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


@WebServlet(name = "BookingServlet", urlPatterns = {"/BookingServlet"})
public class BookingServlet extends HttpServlet {

     public void service(HttpServletRequest request, HttpServletResponse response)
        {
            PrintWriter out=null;
            try
            {
                
        response.setContentType("text/html;charset=UTF-8");
        out=response.getWriter();
        
       //if the booking form is being submitted
       
        String cname=request.getParameter("cname");
        String add=request.getParameter("adr");
        String roomno=request.getParameter("rno");
        String contact=request.getParameter("contact");
        String gender=request.getParameter("gender");
        String nationality=request.getParameter("nationality");
        String occupancy=request.getParameter("occupancy");
        String days=request.getParameter("days");
        String date=request.getParameter("date");
        String status=request.getParameter("Status");
        String purpose=request.getParameter("purpose");
         out.println(hrs.HRSManager.saveBooking( date, roomno, cname, add, gender, contact,nationality, purpose,
          new Integer(occupancy), new Integer(days),status));
        
       
 
            }catch(Exception ex){}
        
    }
    
}
