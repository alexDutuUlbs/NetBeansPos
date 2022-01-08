package servlet;

import ejb.UserBean;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import javax.annotation.security.DeclareRoles;
import javax.ejb.EJB;

@DeclareRoles({"AdminRole", "ClientRole", "ManagerRole"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"AdminRole", "ClientRole", "ManagerRole"}))
@WebServlet(name = "Dashboard", value = "/Dashboard")
public class Dashboard extends HttpServlet {
    
    @EJB
    UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("userId", userBean.getUserIdByName(request.getRemoteUser()));
        request.getRequestDispatcher("/WEB-INF/pages/dashboard.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
