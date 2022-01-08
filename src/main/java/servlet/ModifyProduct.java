/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import converter.ProductDetails;
import ejb.ProductBean;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author User
 */
@WebServlet(name = "ModifyProduct", urlPatterns = {"/ModifyProduct"})
public class ModifyProduct extends HttpServlet {

    @EJB
    ProductBean productBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDetails product = productBean.getProductById(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("product", product);
        request.getRequestDispatcher("/WEB-INF/pages/modifyProduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        String productName = request.getParameter("productName");
        double price = Double.parseDouble(request.getParameter("productPrice"));
        int quantity = Integer.parseInt(request.getParameter("initialQuantity")) + Integer.parseInt(request.getParameter("productQuantity"));
        productBean.updateProduct(productId, productName, price, quantity);

        response.sendRedirect(request.getContextPath() + "/Products");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
