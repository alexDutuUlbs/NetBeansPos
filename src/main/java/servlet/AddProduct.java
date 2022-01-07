/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import ejb.ProductBean;
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
@WebServlet(name = "AddProduct", urlPatterns = {"/AddProduct"})
public class AddProduct extends HttpServlet {

    @EJB
    ProductBean productBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/addProduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("productName");
        Double price = Double.parseDouble(request.getParameter("productPrice"));
        Integer quantity = Integer.parseInt(request.getParameter("productQuantity"));
        if (productBean.productNameExist(name)) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<div class=\"modal\" tabindex=\"-1\" role=\"dialog\">\n"
                    + "  <div class=\"modal-dialog\" role=\"document\">\n"
                    + "    <div class=\"modal-content\">\n"
                    + "      <div class=\"modal-header\">\n"
                    + "        <h5 class=\"modal-title\">Modal title</h5>\n"
                    + "        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n"
                    + "          <span aria-hidden=\"true\">&times;</span>\n"
                    + "        </button>\n"
                    + "      </div>\n"
                    + "      <div class=\"modal-body\">\n"
                    + "        <p>Modal body text goes here.</p>\n"
                    + "      </div>\n"
                    + "      <div class=\"modal-footer\">\n"
                    + "        <button type=\"button\" class=\"btn btn-primary\">Save changes</button>\n"
                    + "        <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Close</button>\n"
                    + "      </div>\n"
                    + "    </div>\n"
                    + "  </div>\n"
                    + "</div>");
            request.getRequestDispatcher("/WEB-INF/pages/addProduct.jsp").forward(request, response);
            out.close();
        } else {
            productBean.addProduct(name, quantity, price);
            response.sendRedirect(request.getContextPath() + "/Products");
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
