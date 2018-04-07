package com.jsuszynski.repository;

import com.jsuszynski.domain.Credentials;
import com.jsuszynski.domain.User;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
public class UsersRepository {
    @PersistenceContext("hypefit-auth")
    EntityManager entityManager;

    public Boolean authenticate(Credentials credentials) {
        User user = new User(credentials.getPassword(), credentials.getLogin());
        if()
    }
}
