/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasakhirfotocopy;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Umi Tiara
 */
public class FXMLAwalController implements Initializable { 
    @FXML
    private Button signupkuy1;

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    void daftarkuy(ActionEvent event) throws IOException {
         ((Node)(event.getSource())).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLLogin.fxml"));
            Scene scene = new Scene (fxmlLoader.load(), 550, 300);
            
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Menu Awal");
            stage.show();
    }
}
