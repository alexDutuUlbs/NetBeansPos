/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

/**
 *
 * @author User
 */
public class OrderDetails {

    private Integer id;
    private Integer id_cashier;

    public OrderDetails(Integer id, Integer id_cashier) {
        this.id = id;
        this.id_cashier = id_cashier;
    }

    public Integer getId() {
        return id;
    }

    public Integer getId_cashier() {
        return id_cashier;
    }
    
    
}
