package com.kl.todo.domain.dao;

import com.kl.todo.domain.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: May 17, 2010
 * Time: 10:24:45 AM
 * To change this template use File | Settings | File Templates.
 */


public class JpaUserDao implements UserDao {

    EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @Override
    public Collection<User> findUsers() {
        return this.entityManager.createQuery("select u from User u order by u.username").getResultList();
    }

    @Override
    public User findUserByUsername(String username) {
        return (User)this.entityManager.createQuery("select u from User u where u.username = :username").setParameter("username", username).getSingleResult();
    }

    @Override
    public void save(User user) {
       this.entityManager.merge(user);
    }

    @Override
    public User findUserById(Long id) {
        return (User) this.entityManager.createQuery("select u from User u where u.id = :id").setParameter("id", id).getSingleResult();
    }

}
