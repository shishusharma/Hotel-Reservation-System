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

@WebServlet(name = "TariffServlet", urlPatterns = {"/TariffServlet"})
public class TariffServlet extends HttpServlet {

        public void service(HttpServletRequest request, HttpServletResponse response)
        {
            PrintWriter out=null;
            try
            {
        response.setContentType("text/html;charset=UTF-8");
        out=response.getWriter();
        String rtype=request.getParameter("roomtype");
        String btype=request.getParameter("bedtype");
        String tariff=request.getParameter("tariff");
        String description=request.getParameter("description");
        if(!rtype.equalsIgnoreCase("-1"))
        {
            out.println(hrs.HRSManager.saveTariff(rtype, btype, tariff, description));
        }
        else
            out.println("Choose Room Type. Plz, Try again.");
            }catch(Exception ex){}
        
    }
       

}
