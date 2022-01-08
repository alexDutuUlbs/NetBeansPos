/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import converter.ProductDetails;
import entity.Product;
import entity.Product_;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author adutu
 */
@Stateless
public class ProductBean {

    private static final Logger LOG = Logger.getLogger(ProductBean.class.getName());

    @PersistenceContext
    private EntityManager em;

    public ProductDetails getProductById(Integer id) {
        LOG.info("findUserById");
        return convertProduct(em.find(Product.class, id));
    }

    public boolean productNameExist(String productName) {
        LOG.info("productNameExist");
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Product> criteria = builder.createQuery(Product.class);
        Root<Product> from = criteria.from(Product.class);
        criteria.select(from);
        criteria.where(builder.equal(from.get(Product_.name), productName));
        TypedQuery<Product> typed = em.createQuery(criteria);
        try {
            Product product = typed.getSingleResult();
            return true;
        } catch (final NoResultException nre) {
            return false;
        }
    }

    public void addProduct(String name, Integer quantity, Double price) {
        LOG.info("addProduct");

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);

        em.persist(product);
    }

    public List<ProductDetails> getAllProducts() {
        LOG.info("getAllProducts");
        try {
            Query query = em.createQuery("SELECT u FROM Product u");
            List<Product> product = (List<Product>) query.getResultList();
            return productDetailsConverter(product);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    private List<ProductDetails> productDetailsConverter(List<Product> products) {
        List<ProductDetails> detailsList = new ArrayList<>();
        for (Product prod : products) {
            ProductDetails productDetails = new ProductDetails(prod.getId(), prod.getName(), prod.getQuantity(), prod.getPrice());
            detailsList.add(productDetails);
        }
        return detailsList;
    }

    private ProductDetails convertProduct(Product product) {
        ProductDetails productDetails = new ProductDetails(product.getId(), product.getName(), product.getQuantity(), product.getPrice());
        return productDetails;
    }

    public void updateProduct(int productId, String productName, double price, int quantity) {
        LOG.info("updateProduct");
        Product product = em.find(Product.class, productId);
        product.setName(productName);
        product.setPrice(price);
        product.setQuantity(quantity);
    }

}
