package servlet;

import ejb.UserBean;
import converter.UserDetails;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.ejb.EJB;

@DeclareRoles({"AdminRole", "ClientRole", "ManagerRole"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"AdminRole", "ManagerRole"}))
@WebServlet(name = "Users", value = "/Users")
public class Users extends HttpServlet {
    
    @EJB
    UserBean userBean;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<UserDetails> users=userBean.getAllUsers();
        System.out.println(users);
        request.setAttribute("users", users);
        request.getRequestDispatcher("/WEB-INF/pages/users.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
