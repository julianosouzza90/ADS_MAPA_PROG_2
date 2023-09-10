/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapa.ads.controller;

import mapa.ads.model.User;
import mapa.ads.service.UserService;

/**
 *
 * @author souzz
 */
public class LoginController {
    private UserService  userService;
    public LoginController(UserService userService) {
        this.userService = userService;
    }
    public User create(User user) throws Exception {
        return this.userService.create(user);
    }
    public boolean authenticate(String login, String password) throws Exception {
        return this.userService.authenticate(login, password);
    }
}
