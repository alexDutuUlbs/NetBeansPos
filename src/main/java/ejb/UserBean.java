/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.User;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import util.PasswordUtil;

/**
 *
 * @author User
 */
@Stateless
public class UserBean {

    private static final Logger LOG = Logger.getLogger(UserBean.class.getName());

    @PersistenceContext
    private EntityManager em;

    public User getUserById(Integer id) {
        LOG.info("findUserById");
        return em.find(User.class, id);
    }

    public void addUser(String email, String username, String password) {
        LOG.info("addUser");

        User user = new User();
        user.setEmail(email);
        user.setUsername(username);
        String shaPassword = PasswordUtil.convertToSha256(password);
        user.setPassword(shaPassword);

        em.persist(user);
    }

}
