/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapa.ads.factories;
import java.sql.Connection; 
import java.sql.SQLException;
import mapa.ads.database.ConnectionFactory;
/**
 *
 * @author souzz
 */
public class ControllerFactory {
    protected Connection conn;
  
    public ControllerFactory () {
       try {
           this.conn = ConnectionFactory.getConnection(); 
       } catch (SQLException e) {
           System.out.print(e.getMessage());
       }
   }
}
