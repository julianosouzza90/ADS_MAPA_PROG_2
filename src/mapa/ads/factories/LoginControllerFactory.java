/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapa.ads.factories;

import java.sql.SQLException;
import mapa.ads.controller.LoginController;
import mapa.ads.dao.UserDao;
import mapa.ads.database.ConnectionFactory;
import mapa.ads.service.UserService;


/**
 *
 * @author souzz
 */
public class LoginControllerFactory  extends ControllerFactory{
    private UserService userService;
    public LoginControllerFactory() {
        super();
        UserDao userDao = new UserDao(this.conn);
        this.userService = new UserService(userDao);
    }
    
    public LoginController build () {
        return new LoginController(this.userService);
    }
}
