
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "BillingServlet", urlPatterns = {"/BillingServlet"})
public class BillingServlet extends HttpServlet {

   
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action=request.getParameter("action");
        try(PrintWriter out = response.getWriter();){
             
             if(action.equalsIgnoreCase("days")){
               String bn=request.getParameter("bn");
               out.println(hrs.HRSManager.getDays(bn));
             }
             
              if(action.equalsIgnoreCase("amount")){
               String bn=request.getParameter("bn");
               out.println(hrs.HRSManager.getAmount(bn));
             }
              
               if(action.equalsIgnoreCase("status")){
               String bn=request.getParameter("bn");
               out.println(hrs.HRSManager.getStatus(bn));
             }
               
               if(action.equalsIgnoreCase("name")){
               String bn=request.getParameter("bn");
               out.println(hrs.HRSManager.getCustName(bn));
             }
               
               if(action.equalsIgnoreCase("submit")){
               String bbn=request.getParameter("bbn");
               String bdate=request.getParameter("bdate");
               String bdays=request.getParameter("days");
               String bamount=request.getParameter("amt");
               String ptype=request.getParameter("ptype");
               String bname=request.getParameter("cname");
               String bcard=request.getParameter("card");
               String bremarks=request.getParameter("remarks");
               out.println(hrs.HRSManager.roomBilling(bbn,bdate,new Integer(bdays),new Integer(bamount),ptype,bcard,bname,bremarks));
               
             }
             
                 }
        
      }
}
