/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import converter.OrderDetails;
import converter.OrderItemDetails;
import entity.OrderItem;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entity.Orders;
import entity.Product;
import entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJBException;
import javax.persistence.Query;

/**
 *
 * @author adutu
 */
@Stateless
public class OrdersBean {

    private static final Logger LOG = Logger.getLogger(OrdersBean.class.getName());

    @PersistenceContext
    private EntityManager em;
    
    public List<OrderDetails> getAllOrderIds(){
        List<OrderDetails> orderList;
        try {
            Query query = em.createQuery("SELECT u FROM Orders u");
            List<Orders> orders = (List<Orders>) query.getResultList();
            orderList = ordersDetailsConverter(orders);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
        return orderList;
    }
    
    public List<OrderItemDetails> getAllOrderItems(){
        List<OrderItemDetails> orderList;
        try {
            Query query = em.createQuery("SELECT u FROM OrderItem u");
            List<OrderItem> orders = (List<OrderItem>) query.getResultList();
            orderList = orderItemDetailsConverter(orders);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
        return orderList;
    }

    public Integer newOrderId(Integer idCashier) {
        Orders order = new Orders();
        order.setId_cashier(idCashier);

        em.persist(order);
        List<OrderDetails> orderList=getAllOrderIds();
        Integer orderId = 0;
        for (OrderDetails orderItem : orderList) {
            orderId = orderItem.getId();
        }

        System.out.println("ORDER ID IS:" + orderId);
        return orderId;
    }

    public boolean addNewOrder(List<OrderItemDetails> orderList) {
        
         LOG.info("addNewOrder");
        
        OrderItem order;
        for (OrderItemDetails orderItem : orderList) {
            order = new OrderItem();
            order.setIdOrder(orderItem.getIdOrder());
            order.setIdProduct(orderItem.getIdProduct());
            order.setQuantity(orderItem.getQuantity());
            updateStock(orderItem.getIdProduct(), orderItem.getQuantity());
            try {
                em.persist(order);
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    private List<OrderDetails> ordersDetailsConverter(List<Orders> orders) {
        List<OrderDetails> detailsList = new ArrayList<>();
        OrderDetails orderItem;
        for (Orders order : orders) {
            orderItem = new OrderDetails(order.getId(), order.getId_cashier());
            detailsList.add(orderItem);
        }
        return detailsList;
    }

    private List<OrderItemDetails> orderItemDetailsConverter(List<OrderItem> orders) {
       List<OrderItemDetails> detailsList = new ArrayList<>();
        OrderItemDetails orderItem;
        for (OrderItem order : orders) {
            orderItem = new OrderItemDetails(order.getId(), order.getIdOrder(), order.getIdProduct(), order.getQuantity());
            detailsList.add(orderItem);
        }
        return detailsList;
    }

    private void updateStock(Integer idProduct, Integer quantity) {
        Product product= em.find(Product.class, idProduct);
        product.setQuantity(product.getQuantity()-quantity);
    }

    public boolean findOrderById(Integer orderId) {
        Orders order=em.find(Orders.class, orderId);
        if(order!=null){
            return true;
        }else{
            return false;
        }
    }

    public void returnOrder(Integer orderId) {
        Orders order=em.find(Orders.class, orderId);
        List<OrderItem> orderList;
        try {
            Query query = em.createQuery("SELECT u FROM OrderItem u");
            orderList = (List<OrderItem>) query.getResultList();
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
        for(OrderItem orderItem: orderList){
            if(orderItem.getIdOrder().equals(order.getId())){
                updateStock(orderItem.getIdProduct(), -(orderItem.getQuantity()));
                em.remove(orderItem);
            }
        }
        em.remove(order);
    }
}
