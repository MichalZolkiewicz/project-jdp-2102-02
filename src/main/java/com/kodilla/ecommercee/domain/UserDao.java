package com.kodilla.ecommercee.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface UserDao extends CrudRepository<User, Integer> {

    @Override
    User save (User user);

    User findById(int userId);

    @Override
    List<User> findAll();
}