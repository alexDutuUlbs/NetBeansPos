/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author User
 */
public class OrderDetails {

    private Integer id;
    private Integer id_cashier;
    private Calendar date;
    private Double total;

    public OrderDetails(Integer id, Integer id_cashier, Calendar date, Double total) {
        this.id = id;
        this.id_cashier = id_cashier;
        this.date = date;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public Integer getId_cashier() {
        return id_cashier;
    }

    public Calendar getDate() {
        return date;
    }

    public Double getTotal() {
        return total;
    }

    public String getDateAsString(){
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        String formatted=format1.format(date.getTime());
        return formatted;
    }
    
}
