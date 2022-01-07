package servlet;

import ejb.UserBean;
import converter.UserDetails;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;

@WebServlet(name = "Customers", value = "/Customers")
public class Customers extends HttpServlet {
    
    @EJB
    UserBean userBean;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<UserDetails> users=userBean.getAllUsers();
        System.out.println(users);
        request.setAttribute("users", users);
        request.getRequestDispatcher("/WEB-INF/pages/customers.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}