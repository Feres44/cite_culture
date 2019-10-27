/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entity.User;
import Service.ServiceUser;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author HP AYEDI
 */
public class LoginController implements Initializable {

    @FXML
    private TextField tfuser;
    @FXML
    private TextField tfpass;
    @FXML
    private Button tfLogin;
    @FXML
    private Button tfsign;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Login(ActionEvent event) throws SQLException, MalformedURLException {
        ServiceUser SU = new ServiceUser();
        User u = new User();
        try {
            String role;
            if (tfuser.getText().isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur login");
                alert.setHeaderText(null);
                alert.setContentText("username invalide!");
                alert.show();
                tfuser.clear();
            } else if (!(SU.checkUsername(tfuser.getText()))) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur login");
                alert.setHeaderText(null);
                alert.setContentText("username introuvable!");
                alert.show();
                tfuser.clear();
            } else {
                role = SU.getRole(tfuser.getText());
                if (role.equals("Member") && !SU.checkPassword(tfpass.getText(), tfuser.getText())) {
                    System.out.println("wrong password");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erreur login");
                    alert.setHeaderText(null);
                    alert.setContentText("password incorrect!");
                    alert.show();
                    tfpass.clear();
                } else if (!role.equals("1") && !SU.checkPassword((tfpass.getText()), tfuser.getText())) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erreur login");
                    alert.setHeaderText(null);
                    alert.setContentText("password incorrect!");
                    alert.show();
                    tfpass.clear();
                } else {
                    switch (role) {
                        case "Member": {
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("/View/afficheM.fxml"));

                            try {
                                Parent root = loader.load();
                                tfLogin.getScene().setRoot(root);
                            } catch (IOException ex) {
                                System.out.println(ex.getMessage());
                            }
                            break;
                        }
                        case "Admin": {
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("/View/affiche.fxml"));
                            try {
                                Parent root = loader.load();
                                tfLogin.getScene().setRoot(root);
                            } catch (IOException ex) {
                                ex.printStackTrace();
                                System.out.println(ex.getMessage());
                            }
                            break;
                        }
                        default:
                            break;
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            System.out.println("null pointer");
        }
    }

    @FXML
    private void Signup(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/Signup.fxml"));
        Parent root = loader.load();
        tfsign.getScene().setRoot(root);

    }
}