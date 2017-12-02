package tugasakhirfotocopy;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Umi Tiara
 */
public class FXMLNotaController implements Initializable {

     @FXML
    private JFXTextField kasir;

    @FXML
    private JFXTextField nama_pel;

    @FXML
    private JFXTextField alamat_pel;

    @FXML
    private JFXTextField barang;

    @FXML
    private JFXTextField bayar;

    @FXML
    private JFXTextField kembali;

    @FXML
    private JFXTextField total;
    
    @FXML
    private JFXTextField jml_lembar1;

    @FXML
    private JFXTextField hargaper2;
    
    @FXML
    private JFXButton exit;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void setdataFC(String jenis_fotocopy, int jml_lembar, int harga_lembar, String nama_pelanggan, String alamat_pelanggan){
        
        nama_pel.setText(nama_pelanggan);
        alamat_pel.setText(alamat_pelanggan);
        jml_lembar1.setText(""+jml_lembar);
        hargaper2.setText(""+harga_lembar);
        barang.setText(jenis_fotocopy);
        int Total = jml_lembar * harga_lembar;
        bayar.setText(""+ Total);
    } 
    @FXML
    private void enter(ActionEvent event){
        int Bayar = Integer.parseInt(bayar.getText());
        int Total;
        int Kembali = Integer.parseInt(kembali.getText());
        Total = Kembali - Bayar;
        total.setText(""+ Total);
    }
     @FXML
    private void exit(ActionEvent event) {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }
}   