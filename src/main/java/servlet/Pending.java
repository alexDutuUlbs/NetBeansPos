/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import converter.UserDetails;
import ejb.UserBean;
import java.io.IOException;
import java.util.List;
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
@DeclareRoles({"AdminRole", "ClientRole", "ManagerRole", "InvalidRole"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"ManagerRole"}))
@WebServlet(name = "Pending", urlPatterns = {"/Pending"})
public class Pending extends HttpServlet {

    @EJB
    UserBean userBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<UserDetails> userDetails = userBean.getAllUsers();
        request.setAttribute("users", userDetails);
        request.getRequestDispatcher("/WEB-INF/pages/pending.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Pending v1.0";
    }// </editor-fold>

}
