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


@WebServlet(name = "RoomServlet", urlPatterns = {"/RoomServlet"})
public class RoomServlet extends HttpServlet {
 
    public void service(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
        PrintWriter out=null;
        try{
            res.setContentType("text/html");
            out=res.getWriter();
            String rno=req.getParameter("rno");
            String rtype=req.getParameter("roomtype");
            String btype=req.getParameter("bedtype");
            if(!rtype.equalsIgnoreCase("-1") && !btype.equalsIgnoreCase("-1")){
                out.println(hrs.HRSManager.saveRoom(rno, rtype, btype));
            }else 
                out.println("please choose roomtype/bedtype!");
            
        }catch(Exception e){}
        }
    }
   

