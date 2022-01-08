package servlet;

import converter.OrderDetails;
import converter.OrderItemDetails;
import ejb.OrdersBean;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import javax.annotation.security.DeclareRoles;
import javax.ejb.EJB;

@DeclareRoles({"AdminRole", "ClientRole", "ManagerRole"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"AdminRole", "ClientRole", "ManagerRole"}))
@WebServlet(name = "Orders", value = "/Orders")
public class Orders extends HttpServlet {

    @EJB
    OrdersBean ordersBean; 
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<OrderDetails> orderIdList=ordersBean.getAllOrderIds();
        List<OrderItemDetails> orderItemList=ordersBean.getAllOrderItems();
        request.setAttribute("orderIdList", orderIdList);
        request.setAttribute("orderList", orderItemList);
        request.getRequestDispatcher("/WEB-INF/pages/orders.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
