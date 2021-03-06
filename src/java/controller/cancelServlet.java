package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "cancelServlet", urlPatterns = {"/cancelServlet"})
public class cancelServlet extends HttpServlet {

        public void service(HttpServletRequest request, HttpServletResponse response)
        {
            PrintWriter out=null;
            String action=request.getParameter("action");
            try
            {
         if(action.equalsIgnoreCase("cancelRoom"))
         {       
        response.setContentType("text/html;charset=UTF-8");
        out=response.getWriter();
        String bno=request.getParameter("bookingno");
        String cdate=request.getParameter("date");
        String reason=request.getParameter("reason");
        String roomno=request.getParameter("rno");
        out.println(hrs.HRSManager.cancelRoom(bno,cdate,roomno,reason)); 
              }
         if(action.equalsIgnoreCase("fetchDetail")){ 
                   response.setContentType("text/html;charset=UTF-8");
                   out=response.getWriter();
                   String bno=request.getParameter("bookingno");
                   out.println(hrs.HRSManager.fetchDetail(bno)); 
               } 
            }catch(Exception ex){}
            
            
        
    }
       

}
