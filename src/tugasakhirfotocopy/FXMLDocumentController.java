/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasakhirfotocopy;

import java.awt.Component;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Umi Tiara
 */
public class FXMLDocumentController implements Initializable {

    

    @FXML
    private RadioButton rdb_print;

    @FXML
    private RadioButton rdb_fotocopy;
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    @FXML
    void print(ActionEvent event) throws IOException {
 
        ((Node)(event.getSource())).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLPrint.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 690);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("PRINT");
            stage.show();
            
            

            FXMLNotaController Nota = new FXMLNotaController();
            Nota = fxmlLoader.getController();
            
            
       } 
    @FXML
    void fotocopy(ActionEvent event) throws IOException {
            ((Node)(event.getSource())).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLFotocopy.fxml"));
            Scene scene = new Scene (fxmlLoader.load(), 600, 670);
            
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("FOTOCOPY");
            stage.show();
            
            
    }
    
}
