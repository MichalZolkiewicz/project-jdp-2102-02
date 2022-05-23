package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.UserDto;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.service.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @RequestMapping(method = RequestMethod.GET, value = "getAllUsers")
    public List<UserDto> getAllUsers() {
        List<User> users = userDbService.getAllUsers();
        return userMapper.mapToUserDtoList(users);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getUser")
    public UserDto getUser(@RequestParam int userId) {
        User user = userDbService.getUser(userId);
        return userMapper.mapToUserDto(user);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto, @RequestParam String password) {
        User user = userMapper.mapToUser(userDto);
        user.setPassword(password);
        userDbService.saveUser(user);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteUser")
    public void deleteUser(@RequestParam int userId) {
        userDbService.deleteUser(userId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "blockUser")
    public void blockUser(@RequestParam int userId) {
        User user = userDbService.getUser(userId);
        user.setStatus(true);

        userDbService.saveUser(user);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "unblockUser")
    public void unblockUser(@RequestParam int userId) {
        User user = userDbService.getUser(userId);
        user.setStatus(false);

        userDbService.saveUser(user);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createTokenUserKey")
    public void createUserTokenKey(@RequestParam int userId) {
        User user = userDbService.getUser(userId);

        User userWithToken = userDbService.saveTokenUserKey(user);
        userDbService.saveUser(userWithToken);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updatePassword")
    public void updatePassword(@RequestParam int userId, @RequestParam String password) {
        User user = userDbService.getUser(userId);
        user.setPassword(password);

        userDbService.saveUser(user);
    }
}



