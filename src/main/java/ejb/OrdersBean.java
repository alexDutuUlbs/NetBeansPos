/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author adutu
 */
@Stateless
public class OrdersBean {

    private static final Logger LOG = Logger.getLogger(OrdersBean.class.getName());

    @PersistenceContext
    private EntityManager em;

}
