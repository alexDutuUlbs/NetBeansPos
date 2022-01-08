/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.User;
import converter.UserDetails;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

    public UserDetails getUserById(Integer id) {
        LOG.info("findUserById");
        User user = em.find(User.class, id);
        UserDetails userDetails = new UserDetails(user);
        return userDetails;
    }

    public void addUser(String email, String username, String password, String position) {
        LOG.info("addUser");

        User user = new User();
        user.setEmail(email);
        user.setUsername(username);
        String shaPassword = PasswordUtil.convertToSha256(password);
        user.setPassword(shaPassword);
        user.setPosition(position);

        em.persist(user);
    }

    public List<UserDetails> getAllUsers() {
        LOG.info("getAllUsers");
        try {
            Query query = em.createQuery("SELECT u FROM User u");
            List<User> users = (List<User>) query.getResultList();
            return userDetailsConverter(users);
        } catch (Exception ex) {
            throw new EJBException(ex);
        }
    }

    private List<UserDetails> userDetailsConverter(List<User> users) {
        List<UserDetails> detailsList = new ArrayList<>();
        for (User user : users) {
            UserDetails userDetails = new UserDetails(user.getId(),
                    user.getEmail(),
                    user.getUsername(),
                    user.getPassword(),
                    user.getPosition());
            detailsList.add(userDetails);
        }
        return detailsList;
    }

    public void deleteUser(User user) {
        LOG.info("deleteUser");
        user = em.merge(user);
        em.remove(user);
    }

    public void updateUser(String userId, String username, String password, String email, String position) {
        LOG.info("updateUser");
        User user = em.find(User.class, Integer.parseInt(userId));
        user.setEmail(email);
        user.setPosition(position);
        user.setUsername(username);
        String shaPassword = PasswordUtil.convertToSha256(password);
        user.setPassword(shaPassword);
    }
}
