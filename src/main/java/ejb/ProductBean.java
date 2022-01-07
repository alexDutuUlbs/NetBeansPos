/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import converter.ProductDetails;
import entity.Product;
import entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author adutu
 */
@Stateless
public class ProductBean {

    @PersistenceContext
    private EntityManager em;
    
    public ProductDetails getUserById(Integer id) {
        //LOG.info("findUserById");
        return convertProduct(em.find(Product.class, id));
    }

    public void addProduct(String name, Integer quantity, Double price) {
        //LOG.info("addUser");

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);

        em.persist(product);
    }
    
    public List<ProductDetails> getAllProducts(){
        try {
            Query query = em.createQuery("SELECT u FROM Product u");
            List<Product> product = (List<Product>) query.getResultList();
            return productDetailsConverter(product);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }
    
    private List<ProductDetails> productDetailsConverter(List<Product> products) {
        List<ProductDetails> detailsList=new ArrayList<>();
        for(Product prod: products){
            ProductDetails productDetails=new ProductDetails(prod.getId(), prod.getName(), prod.getQuantity(), prod.getPrice());
            detailsList.add(productDetails);
        }
        return detailsList;
    }

    private ProductDetails convertProduct(Product product) {
       ProductDetails productDetails=new ProductDetails(product.getId(), product.getName(), product.getQuantity(), product.getPrice());
       return productDetails;
    }
    
}
