/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entite.User;
import Service.ServiceUser;
import java.net.URL;
import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import Controllers.ForgotPassController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import utils.DataSource;

/**
 * FXML Controller class
 *
 * @author Elyes
 */
public class ResetPassController implements Initializable {


    @FXML
    private TextField txtResetPass;
    @FXML
    private TextField txtVerResetPass;
    @FXML
    private Button tfReset;
    @FXML
    private Label tfemail;
    @FXML
    private Button tfback;
    @FXML
    private Button tflogin;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    void setmail(String mailu) {
        tfemail.setText(mailu);  
    }

    
    
    @FXML
    private void ResetP(ActionEvent event) {
        if(txtResetPass.getText().equals(txtVerResetPass.getText())){
            try{
                User u = new User();
                ServiceUser su = new ServiceUser();
                su.ResetPass(tfemail.getText(), txtResetPass.getText());
                JOptionPane.showMessageDialog(null, "reset Successfully");
            }catch(Exception ex){
                JOptionPane.showConfirmDialog(null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "password do not match");
        }
    }

    @FXML
    private void backlogin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/ForgotPass.fxml"));
        Parent root = loader.load();
        tfback.getScene().setRoot(root);  
        
    }

    @FXML
    private void Gotologin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/Login.fxml"));
        Parent root = loader.load();
        tflogin.getScene().setRoot(root);
        
        
        
    }

    
    
}