package com.jsuszynski.hypefit.login.repository;


import com.jsuszynski.hypefit.login.domain.Credentials;
import com.jsuszynski.hypefit.login.domain.User;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Singleton
public class UsersRepository {
    @PersistenceContext(unitName = "hypefit-auth")
    EntityManager entityManager;

    public User authenticate(Credentials credentials) {
        Optional<User> user = Optional.ofNullable((User) entityManager.createQuery("from users where login=:login, password=:password")
                .setParameter("password", credentials.getPassword())
                .setParameter("login", credentials.getLogin()).getSingleResult());
        if (user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }

    public void register(User user) {
        entityManager.persist(user);
    }

}
