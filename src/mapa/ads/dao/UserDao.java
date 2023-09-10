package mapa.ads.dao;

import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import mapa.ads.model.User;

/**
 *
 * @author souzz
 */
public class UserDao {

    private Connection connection;

    public UserDao(Connection conn) {
        this.connection = conn;
    }

    public User Create(User user) {
        String sql = "INSERT INTO usuario (nome, login, senha, email) VALUES (?,?,?,?)";

        try (PreparedStatement pstm = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
            pstm.setString(1, user.getName());
            pstm.setString(2, user.getLogin());
            pstm.setString(3, user.getPassword());
            pstm.setString(4, user.getEmail());
            
            int rowsAffected = pstm.executeUpdate();
         
            if(rowsAffected > 0) {
                
                ResultSet  generatedKeys = pstm.getGeneratedKeys();
                generatedKeys.next();
                user.setId( generatedKeys.getInt(1));
                return user;
            }
          
        } catch (SQLException e) {
              System.out.println(e.getMessage() + e.getStackTrace());
        }
        return null;
    }

     public User getByLogin(String login) {
        String sql = "SELECT * FROM usuario WHERE login = ?";
        try (PreparedStatement pstmt = this.connection.prepareStatement(sql)) {
            pstmt.setString(1, login);
            ResultSet result = pstmt.executeQuery();
            if (result.next()) {

                return new User(
                        result.getInt("id"),
                        result.getString("nome"),
                        result.getString("login"),
                        result.getString("senha"),
                        result.getString("email")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public User getByLoginAndPassword(String login, String password) {
        String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";
        try (PreparedStatement pstmt = this.connection.prepareStatement(sql)) {
            pstmt.setString(1, login);
            pstmt.setString(2, password);
            ResultSet result = pstmt.executeQuery();
            if (result.next()) {

                return new User(
                        result.getInt("id"),
                        result.getString("nome"),
                        result.getString("login"),
                        result.getString("senha"),
                        result.getString("email")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
