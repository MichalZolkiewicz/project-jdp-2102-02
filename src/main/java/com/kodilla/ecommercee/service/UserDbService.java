package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class UserDbService {

    private final UserDao userDao;

    public User saveUser(User user) {
        return userDao.save(user);
    }

    public void deleteUser(final int userId) {
        userDao.deleteById(userId);
    }

    public User saveTokenUserKey(User user) {
        Random random = new Random();
        String tokenUserKey = String.valueOf(random.nextInt(99999999)) ;
        user.setTokenUserKey(tokenUserKey);
        return user;
    }

    public User getUser(final int userId) {
        return userDao.findById(userId);
    }

    public List<User> getAllUsers() {
        return userDao.findAll();
    }
}

