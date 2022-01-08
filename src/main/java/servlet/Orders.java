package servlet;

import converter.OrderDetails;
import converter.OrderItemDetails;
import converter.ProductDetails;
import converter.ProductOrderJoin;
import ejb.OrdersBean;
import ejb.ProductBean;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.ejb.EJB;

@DeclareRoles({"AdminRole", "ClientRole", "ManagerRole"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"AdminRole", "ClientRole", "ManagerRole"}))
@WebServlet(name = "Orders", value = "/Orders")
public class Orders extends HttpServlet {

    @EJB
    OrdersBean ordersBean;

    @EJB
    ProductBean productBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<OrderDetails> orderIdList = ordersBean.getAllOrderIds();
        List<OrderItemDetails> orderItemList = ordersBean.getAllOrderItems();
        List<ProductDetails> productList = productBean.getAllProducts();
        List<ProductOrderJoin> productOrderJoin = new ArrayList<>();

        for (OrderItemDetails orderItem : orderItemList) {
            int productIndex = productList.indexOf(new ProductDetails(orderItem.getIdProduct()));
            ProductDetails product = productList.get(productIndex);
            productOrderJoin.add(new ProductOrderJoin(product.getId(), product.getName(), product.getQuantity(), product.getPrice(), orderItem.getIdOrder(), orderItem.getQuantity()));
        }
        System.out.println(productOrderJoin);
        request.setAttribute("orderDetails", productOrderJoin);
        request.setAttribute("orderIdList", orderIdList);
//        request.setAttribute("orderList", orderItemList);
        request.getRequestDispatcher("/WEB-INF/pages/orders.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
