/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasakhirfotocopy;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Umi Tiara
 */
public class FXMLFotocopyController implements Initializable {

    ObservableList<String> list1 = FXCollections.observableArrayList("FotoCopy Hitam Putih","FotoCopy Warna", "FotoCopy Print Copy");

    
    @FXML
    private JFXButton submitfo;
    @FXML
    private  JFXComboBox<String> jenis_fotocopy;
    @FXML
    private JFXTextField jml_lembar_fc;
    @FXML
    private JFXTextField harga_lembar_fo;
    
        @FXML
    private JFXTextField nama_pelanggan1;

    @FXML
    private JFXTextField alamat_pelanggan1;
    
        @FXML
    private JFXButton resetf;
    

    
String Jenis_fotocopy,Jml_lembar_FC,Harga_lembar_FO, Nama_pelanggan, Alamat_pelanggan;
    /**
     * Initializes the controller class.
     * @param url
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        jenis_fotocopy.setValue("--Pilih--");
        jenis_fotocopy.setItems(list1);
    }   
    int JML_lembar_fc, Harga_lembar_fo;
      @FXML
    void fotocopy(ActionEvent event) {
        int harga;
        if(jenis_fotocopy.getValue().equals("FotoCopy Hitam Putih")){
            harga_lembar_fo.setText("500");
        }else if(jenis_fotocopy.getValue().equals("FotoCopy Warna")){
            harga_lembar_fo.setText("1000");
        }else if(jenis_fotocopy.getValue().equals("FotoCopy Print Copy")){
            harga_lembar_fo.setText("1500");
        } 
    }

    
    @FXML
    private void submit(ActionEvent event) throws IOException {
        kirim1();
        try{
        ((Node)(event.getSource())).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLNota.fxml"));
            Scene scene = new Scene (fxmlLoader.load(), 590, 505);
            
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Menu Awal");
            stage.show();
            
            
            
            FXMLNotaController Nota = new FXMLNotaController();
            Nota = fxmlLoader.getController();
            
            Nota.setdataFC(Jenis_fotocopy, JML_lembar_fc, Harga_lembar_fo, Nama_pelanggan, Alamat_pelanggan);
        }catch (IOException e) {
            System.out.println("Batal membuat window baru" + e);
        }           
    }
    
    void kirim1(){
        if(nama_pelanggan1.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Harap inputkan nama Anda");
        }else if (alamat_pelanggan1.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Harap isikan alamat Anda");
        }else if (jenis_fotocopy.getValue().equals("")){
            JOptionPane.showMessageDialog(null, "Harap pilih jenis fotocopy");
        }else if (jml_lembar_fc.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Harap isikan jumlah lembar");
        }
        
        Jenis_fotocopy = jenis_fotocopy.getValue().toString();
            JML_lembar_fc = Integer.parseInt(jml_lembar_fc.getText());
            Harga_lembar_fo = Integer.parseInt(harga_lembar_fo.getText());
            Nama_pelanggan = nama_pelanggan1.getText();
            Alamat_pelanggan = alamat_pelanggan1.getText();
    }
    
    
    @FXML
    void resetf(ActionEvent event) {
        nama_pelanggan1.setText("");
        alamat_pelanggan1.setText("");
        jenis_fotocopy.setValue("--Pilih--");
        jml_lembar_fc.setText("");
        harga_lembar_fo.setText("");
    }
}
