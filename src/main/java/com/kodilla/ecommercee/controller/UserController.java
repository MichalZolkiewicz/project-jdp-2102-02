package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.UserDto;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.service.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserMapper userMapper;
    private final UserDbService userDbService;

    @Autowired
    public UserController(UserMapper userMapper, UserDbService userDbService) {
        this.userMapper = userMapper;
        this.userDbService = userDbService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "createUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        userDbService.saveUser(user);
        System.out.println("User has been created.");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteUser")
    public void deleteUser(@RequestParam("userName") String userName) {
        userDbService.deleteUserByUserName(userName);
        System.out.println("User has been deleted.");
    }

    @RequestMapping(method = RequestMethod.PUT, value = "blockUser")
    public void blockUser(@RequestParam("userId") int userId) {
        userDbService.blockUserByUserId(userId);
        System.out.println("User has been blocked.");
    }

    @RequestMapping(method = RequestMethod.POST, value = "createTokenUserKey")
    public String createUserTokenKey(@RequestParam("email") String email) {
        User user = new User();
        userDbService.saveTokenUserKey(email);
        return user.getTokenUserKey();
    }
}



