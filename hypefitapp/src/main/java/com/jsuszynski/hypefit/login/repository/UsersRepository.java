package main.java.com.jsuszynski.hypefit.login.repository;

import com.jsuszynski.hypefit.login.domain.User;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;

@Singleton
public class UsersRepository {
    //    @PersistenceContext(unitName = "hypefit-auth")
    EntityManager entityManager;

    public void addUser(User user) {
        entityManager.persist(user);
    }

    public Boolean doesUserExist(User user) {
        if (entityManager.contains(user))
            return true;
        return false;
    }
}
