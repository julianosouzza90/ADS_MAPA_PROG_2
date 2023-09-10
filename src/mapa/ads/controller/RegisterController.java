package mapa.ads.controller;

import mapa.ads.model.User;
import mapa.ads.service.UserService;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author souzz
 */
public class RegisterController {
    private UserService  userService;
    
    public RegisterController(UserService userService) {
        this.userService = userService;
    }
    
    public boolean create(User user) throws Exception {
        
        User userCreated =  this.userService.create(user);
        
        if(userCreated == null) {
            return false;
        }
        return true;
    }
}
