
package mapa.ads.service;

import mapa.ads.dao.UserDao;
import mapa.ads.model.User;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author souzz
 */
public class UserService {
    
    UserDao userDao;
    public UserService(UserDao userdao) {
        this.userDao = userdao;
    }
    
    public User create(User user) throws Exception{
        User findUser = this.userDao.getByLogin(user.getLogin());
        
        if(findUser != null) {
            throw new Exception("Já existe um usuário cadastro com este login.");
        }
       
        return this.userDao.Create(user);
    }
    public boolean authenticate(String login, String password) throws Exception {
        User user = this.userDao.getByLoginAndPassword(login, password);
        if(user != null) {
           return true;
        }
        
        return false;
    
    }
}
