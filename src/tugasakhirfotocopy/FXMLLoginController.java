 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasakhirfotocopy;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.awt.Component;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
    
/**
 *
 * @author Umi Tiara
 */
public class FXMLLoginController {
     @FXML
    private JFXPasswordField password;

    @FXML
    private JFXTextField username;

    @FXML
    private JFXButton signup;
    
    String Username;

    public void login(ActionEvent event) throws IOException {
    Connection connection;
        PreparedStatement ps;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fotocopy", "root","");
            ps = connection.prepareStatement("SELECT * FROM `admin` WHERE username=? AND password =?");
            ps.setString(1,username.getText());
            ps.setString(2,password.getText());
            ResultSet result = ps.executeQuery();
        if(result.next()){
                if(username.getText().equals(result.getString("username")) && password.getText().equals(result.getString("password"))){
                javax.swing.JOptionPane.showMessageDialog(null, "You Success Login");        
        ((Node)(event.getSource())).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 730, 470);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("FOTOCOPY");
            stage.show();  
                }
       } else{
              javax.swing.JOptionPane.showMessageDialog(null, "Please Try Again"); 
            }
    } catch(java.sql.SQLException ex){
            Component rootPane = null;
         javax.swing.JOptionPane.showMessageDialog(rootPane, "Please Reconnect"); 
    }    
    }
    
    @FXML
    private void signup(ActionEvent event) throws IOException, SQLException{
        String user = username.getText();
        String p = password.getText();
        
        try{
            try(Statement statement = (Statement) login_koneksi.GetConnection().createStatement()){
                statement.executeUpdate("INSERT INTO admin VALUES ('"+user+"', '"+p+"')");
            } 
            JOptionPane.showMessageDialog(null, "You Success SIgnUp");
            username.clear();
            password.clear();
    }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Please Try Again");
        }
    }                
                
    }


