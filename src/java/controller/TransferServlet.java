
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TransferServlet", urlPatterns = {"/TransferServlet"})
public class TransferServlet extends HttpServlet {

    
    public void service(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        String action=req.getParameter("action");
        try (PrintWriter out = res.getWriter()) {
            //to return room number according to booking number
            if(action.equalsIgnoreCase("roomnum")){
            String bn=req.getParameter("bn");
            out.println(hrs.HRSManager.getBookedRoom(bn));
            }
            
            //to get customer details
            
            //to submit transfer data
            if(action.equalsIgnoreCase("transfer")){
            String ch=req.getParameter("chk");
            String bn1=req.getParameter("bn");
            String rn=req.getParameter("rn");
            String nrn=req.getParameter("nrn");
            String date=req.getParameter("tdate");
            String reason=req.getParameter("reason");
            
                out.println(hrs.HRSManager.transferRoom(bn1,rn,nrn,date,reason));
            }
        }
    }

}
