package servlet;

import converter.OrderItemDetails;
import converter.ProductDetails;
import ejb.OrdersBean;
import ejb.ProductBean;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.annotation.security.DeclareRoles;
import javax.ejb.EJB;
import javax.inject.Inject;

@DeclareRoles({"AdminRole", "ClientRole", "ManagerRole"})
@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"AdminRole", "ClientRole", "ManagerRole"}))
@WebServlet(name = "NewOrder", value = "/NewOrder")
public class NewOrder extends HttpServlet {

    @EJB
    ProductBean productBean;
    
    @EJB
    OrdersBean ordersBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductDetails> products = productBean.getAllProducts();
        request.setAttribute("products", products);
        request.getRequestDispatcher("/WEB-INF/pages/newOrder.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //System.out.println("orderBean//////////////////////////"+ordersBean.newOrder(1));
        
        String userId=(String) request.getSession().getAttribute("userId");
        Integer orderId=ordersBean.newOrderId(Integer.parseInt(userId));       //get user id
        
        String orderRaw=request.getParameter("order");
        List<OrderItemDetails> orderList=new ArrayList<>();
        StringTokenizer st=new StringTokenizer(orderRaw, "#");
        while(st.hasMoreTokens()){
            Integer productId=Integer.parseInt(st.nextToken());
            Integer quantity=Integer.parseInt(st.nextToken());
            orderList.add(new OrderItemDetails(orderId, productId, quantity));
        }
        boolean success=ordersBean.addNewOrder(orderList);
        if(success){
            
             response.sendRedirect(request.getContextPath() + "/Orders");
        }else{
             response.sendRedirect(request.getContextPath() + "/NewOrder");
        }
    }
}
