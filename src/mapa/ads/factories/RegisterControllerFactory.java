/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapa.ads.factories;

import mapa.ads.controller.RegisterController;
import mapa.ads.dao.UserDao;
import mapa.ads.service.UserService;

/**
 *
 * @author souzz
 */
public class RegisterControllerFactory extends ControllerFactory {
     private UserService userService;
     
     public RegisterControllerFactory() {
        super();
         UserDao userDao = new UserDao(this.conn);
        this.userService = new UserService(userDao);
    }
    
    public RegisterController build () {
        return new RegisterController(this.userService);
    }
}
