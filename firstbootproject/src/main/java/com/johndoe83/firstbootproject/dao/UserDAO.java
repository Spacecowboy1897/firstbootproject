package com.johndoe83.firstbootproject.dao;


import com.johndoe83.firstbootproject.model.User;

import java.util.List;


public interface UserDAO {

    List<User> index();

    User show(Long id);

    void save(User user);

    void update(Long id, User updatedUser);

    void delete(Long id);
}