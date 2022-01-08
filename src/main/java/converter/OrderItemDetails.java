package converter;

/**
 *
 * @author adutu
 */
public class OrderItemDetails {
    private Integer id;
    private Integer idOrder;
    private Integer idProduct;
    private Integer quantity;

    public OrderItemDetails(Integer id, Integer idOrder, Integer idProduct, Integer quantity) {
        this.id = id;
        this.idOrder = idOrder;
        this.idProduct = idProduct;
        this.quantity = quantity;
    }

    public OrderItemDetails(Integer idOrder, Integer idProduct, Integer quantity) {
        this.idOrder = idOrder;
        this.idProduct = idProduct;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public Integer getQuantity() {
        return quantity;
    }
    
    
}
