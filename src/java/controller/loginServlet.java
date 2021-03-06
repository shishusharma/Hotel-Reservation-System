import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {

        public void service(HttpServletRequest request, HttpServletResponse response)
        {
            PrintWriter out=null;
             System.out.println("bharat");
           try
            {
            response.setContentType("text/html;charset=UTF-8");
            out = response.getWriter();
           
            String userid = request.getParameter("username").trim();
            String password = request.getParameter("userpassword").trim();
        
                String msg = hrs.HRSManager.validateUser(userid, password);
                out.println(msg);
                if (msg.equalsIgnoreCase("success")) {
                    HttpSession hs = request.getSession();
                    if (hs != null) 
                    {
                        hs.setAttribute("username",hrs.HRSManager.getUserName(userid));
                        hs.setAttribute("user_id",userid);
                       //response.sendRedirect("home.jsp");
                        request.getRequestDispatcher("./home.jsp").forward(request, response);

                    } 
                

                } else {

                    boolean flag = hrs.HRSManager.getExistUserid(userid);
                    if (flag ==true) {
                        ServletContext sc = getServletContext();
                        sc.setAttribute("ouser", userid);
                        sc.setAttribute("omsg", "Invalid Password!");
                        request.getRequestDispatcher("./index.jsp").forward(request, response);
                    } else {
                        ServletContext sc = getServletContext();
                        sc.setAttribute("ouser", null);
                        sc.setAttribute("omsg", "Invalid Username OR Password!");
                        request.getRequestDispatcher("./index.jsp").forward(request, response);
                    }

                }
            


            }catch(Exception ex){}
        
    }
       

}
