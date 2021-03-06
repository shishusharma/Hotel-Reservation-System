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

@WebServlet(name = "EditTariffServlet", urlPatterns = {"/EditTariffServlet"})
public class EditTariffServlet extends HttpServlet {

        public void service(HttpServletRequest request, HttpServletResponse response)
        {
            PrintWriter out=null;
            try
            {
        response.setContentType("text/html;charset=UTF-8");
        out=response.getWriter();
        String id=request.getParameter("tariff_id1");
        String rtype=request.getParameter("eroomtype");
        String btype=request.getParameter("ebedtype");
        String tariff=request.getParameter("etariff");
        String description=request.getParameter("edescription");
        if(!rtype.equalsIgnoreCase("null"))
        {
            out.println(hrs.HRSManager.editTariff(id,rtype, btype, tariff, description));
        }
        else
            out.println("Choose Room Type. Plz, Try again.");
            }catch(Exception ex){}
        
    }
       

}
