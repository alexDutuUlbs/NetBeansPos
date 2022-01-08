package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import javax.annotation.security.DeclareRoles;

@DeclareRoles({"AdminRole", "ClientRole", "ManagerRole"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"AdminRole", "ClientRole", "ManagerRole"}))
@WebServlet(name = "Orders", value = "/Orders")
public class Orders extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/orders.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
