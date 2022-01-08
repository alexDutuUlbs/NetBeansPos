/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import ejb.OrdersBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author adutu
 */
@WebServlet(name = "DeleteOrder", urlPatterns = {"/DeleteOrder"})
public class DeleteOrder extends HttpServlet {
    
    @EJB
    OrdersBean ordersBean;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Integer orderId = Integer.parseInt(request.getParameter("orderIdConfirm"));
        System.out.println("console-log-delete");
        System.out.println(orderId);
        ordersBean.returnOrder(orderId);
        response.sendRedirect(request.getContextPath() + "/Orders");
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
