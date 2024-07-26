package com.johndoe83.firstbootproject.dao;

import com.johndoe83.firstbootproject.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> index() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User show(Long id) {
        if (id == null) {
            throw new EntityNotFoundException();
        } else {
            return entityManager.find(User.class, id);
        }
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(Long id, User updatedUser) {
        if (id == null) {
            throw new EntityNotFoundException();
        } else {
            entityManager.merge(updatedUser);
        }
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            throw new EntityNotFoundException();
        } else {
            entityManager.remove(entityManager.find(User.class, id));
        }
    }
}