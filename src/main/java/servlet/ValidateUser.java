/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import converter.UserDetails;
import ejb.UserBean;
import java.io.IOException;
import javax.annotation.security.DeclareRoles;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@DeclareRoles({"AdminRole", "ClientRole", "ManagerRole"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"ManagerRole"}))
@WebServlet(name = "ValidateUser", urlPatterns = {"/ValidateUser"})
public class ValidateUser extends HttpServlet {

    @EJB
    UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDetails user = userBean.getUserById(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("user", user);
        request.getRequestDispatcher("/WEB-INF/pages/validateUser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String position = request.getParameter("position");
        String userId = request.getParameter("user_id");

        userBean.updateUser(userId, username, password, email, position);

        response.sendRedirect(request.getContextPath() + "/Customers");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
