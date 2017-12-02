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
public class FXMLPrintController implements Initializable {
    ObservableList<String> list2 = FXCollections.observableArrayList("Print Hitam Putih","Print Warna", "Print Foto", "Print Brosur", "Print Majalah");
    
    @FXML
    private JFXButton submit;

    @FXML
    private JFXTextField jml_lembar;

    @FXML
    private JFXTextField harga_lembar;

    @FXML
    private  JFXComboBox<String> jenis_print;
    
     @FXML
    private JFXTextField nama_pelanggan;

    @FXML
    private JFXTextField alamat_pelanggan;
    
        @FXML
    private JFXButton resetp;

    
    String Jenis_print, Nama_pelanggan, Alamat_pelanggan;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        jenis_print.setValue("--Pilih--");
        jenis_print.setItems(list2);
        
    }    
    
    int jumlahkertas,hargalembar;
    
    @FXML
    private void submit1(ActionEvent event) throws IOException {
        kirim();
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
            
            Nota.setdataFC(Jenis_print, jumlahkertas, hargalembar,  Nama_pelanggan, Alamat_pelanggan );
        }
        catch (IOException e) {
            System.out.println("Batal membuat window baru" + e);
        }
            
        
    }
    
    void kirim(){
        if(nama_pelanggan.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Harap inputkan nama Anda");
        }else if (alamat_pelanggan.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Harap isikan alamat Anda");
        }else if (jenis_print.getValue().equals("")){
            JOptionPane.showMessageDialog(null, "Harap pilih jenis print");
        }else if (jml_lembar.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Harap isikan jumlah lembar");
        }
        Jenis_print = jenis_print.getValue().toString();
            jumlahkertas = Integer.parseInt(jml_lembar.getText());
            hargalembar = Integer.parseInt(harga_lembar.getText());
            Nama_pelanggan = nama_pelanggan.getText();
            Alamat_pelanggan = alamat_pelanggan.getText();
    }
    @FXML
    void print(ActionEvent event) {
        if(jenis_print.getValue().equals("Print Hitam Putih")){
            harga_lembar.setText("500");
        }else if(jenis_print.getValue().equals("Print Warna")){
            harga_lembar.setText("1000");
        }else if(jenis_print.getValue().equals("Print Foto")){
            harga_lembar.setText("1500");
        }
        else if(jenis_print.getValue().equals("Print Brosur")){
            harga_lembar.setText("2000");
        }else if(jenis_print.getValue().equals("Print Majalah")){
            harga_lembar.setText("2500");
        }
    }

        @FXML
    void resetp(ActionEvent event) {
        nama_pelanggan.setText("");
        alamat_pelanggan.setText("");
        jenis_print.setValue("--Pilih--");
        jml_lembar.setText("");
        harga_lembar.setText("");
    }
}
