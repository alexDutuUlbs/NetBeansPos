/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

/**
 *
 * @author adutu
 */
public class ProductOrderJoin {
    private Integer productId;
    private String productNamename;
    private Integer productQuantity;
    private Double price;
    private Integer orderId;
    private Integer orderQuantity;

    public ProductOrderJoin(Integer productId, String productNamename, Integer productQuantity, Double price, Integer orderId, Integer orderQquantity) {
        this.productId = productId;
        this.productNamename = productNamename;
        this.productQuantity = productQuantity;
        this.price = price;
        this.orderId = orderId;
        this.orderQuantity = orderQquantity;
    }

    public Integer getProductId() {
        return productId;
    }

    public String getProductNamename() {
        return productNamename;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public Integer getOrderQuantity() {
        return orderQuantity;
    }
    
    

    @Override
    public String toString() {
        return "ProductOrderJoin{" + "productId=" + productId + ", productNamename=" + productNamename + ", productQuantity=" + productQuantity + ", price=" + price + ", orderId=" + orderId + ", orderQquantity=" + orderQuantity + '}';
    }
    
    
}
