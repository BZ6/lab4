package web.xelj8.lab4.repository;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import web.xelj8.lab4.model.User;

@Stateless
public class UserRepository {
    @PersistenceContext
    private EntityManager db;

    public void save(User user) {
        db.persist(user);
    }

    public User findByUsername(String username) {
        TypedQuery<User> query = db.createQuery("from User u where u.username = :username", User.class).setParameter("username", username);
        return query.getResultStream().findAny().orElse(null);
    }

    public User findById(Long id) {
        TypedQuery<User> query = db.createQuery("from User u where u.id = :id", User.class).setParameter("id", id);
        return query.getResultStream().findAny().orElse(null);
    }
}
