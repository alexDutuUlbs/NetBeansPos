package servlet;

import converter.OrderItemDetails;
import converter.ProductDetails;
import converter.ProductOrderJoin;
import ejb.OrdersBean;
import ejb.ProductBean;
import entity.OrderItem;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

@WebServlet(name = "Return", value = "/Return")
public class Return extends HttpServlet {

    @EJB
    OrdersBean ordersBean;

    @EJB
    ProductBean productBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/returns.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<ProductDetails> productList = productBean.getAllProducts();
        List<ProductOrderJoin> productOrderJoin = new ArrayList<>();
        List<OrderItemDetails> orderItemList = ordersBean.getAllOrderItems();

        Integer orderId = Integer.parseInt(request.getParameter("orderId"));
        System.out.println("console-log");
        System.out.println(orderId);
        if (ordersBean.findOrderById(orderId)) {

            for (OrderItemDetails orderItem : orderItemList) {
                if (orderId.equals(orderItem.getIdOrder())) {
                    int productIndex = productList.indexOf(new ProductDetails(orderItem.getIdProduct()));
                    ProductDetails product = productList.get(productIndex);
                    productOrderJoin.add(new ProductOrderJoin(product.getId(), product.getName(), product.getQuantity(), product.getPrice(), orderItem.getIdOrder(), orderItem.getQuantity()));
                }
            }
            System.out.println(productOrderJoin);
            request.setAttribute("activated", true);
            request.setAttribute("orderItemList", productOrderJoin);
            request.getRequestDispatcher("/WEB-INF/pages/returns.jsp").forward(request, response);
        }
    }
}
