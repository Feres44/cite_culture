/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entite.Evenement;
import Service.ServiceEvenement;
import Service.ServiceUser;
import java.io.IOException;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Elyes
 */
public class ModifierEventController implements Initializable {

    @FXML
    private TextField description_event;
    @FXML
    private TextField type_event;
    @FXML
    private TextField titre_event;
    @FXML
    private TextField prix_event;
    @FXML
    private TextField salle_event;
    @FXML
    private TextField heure_event;
    @FXML
    private TextField date_event;
    @FXML
    private Button affiche1;
    @FXML
    private ImageView tfphoto;
    @FXML
    private Label tflogin;
    @FXML
    private Label tfidevent;
    @FXML
    private ImageView tfimageevent;
    @FXML
    private TextField tfproducer;

    /**
     * Initializes the controller class.
     */
    
    void login(String log) throws SQLException {
        tflogin.setText(log);
        ServiceUser su = new ServiceUser();
        String creator = su.SearchName(tflogin.getText()) + " " + su.SearchPrename(tflogin.getText());
        tfproducer.setText(creator);

    }

    void image(String filepath) {
        Image imag = new Image("file:" + filepath);
        tfphoto.setImage(imag);
    }
    
    void idevent(String log) {
        tfidevent.setText(log);
    }
    
    void titreevent(String titre){
        titre_event.setText(titre);    
    }
    
    void typeevent(String type){
        type_event.setText(type);    
    }
    
    void dateevent(String date){
        date_event.setText(date);    
    }
    
    void heureevent(String heure){
        heure_event.setText(heure);    
    }
    
    void descevent(String desc){
        description_event.setText(desc);    
    }
     
    void prixevent(String prix){
        prix_event.setText(prix);    
    }
    
    void saleevent(String sale){
        salle_event.setText(sale);    
    }
    
    void imageeevent(String filepath){
        Image imag = new Image("file:" + filepath);
        tfimageevent.setImage(imag);
    }
    
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void ModifierEvenement(ActionEvent event) throws SQLException{
        Evenement e = new Evenement();
        e.setType_event(type_event.getText());
        e.setDescription_event(description_event.getText());
        e.setDate_event(date_event.getText());
        e.setPrix_event(Integer.valueOf(prix_event.getText()));
        e.setHeure_event(heure_event.getText());
        e.setTitre_event(titre_event.getText());
        e.setSalle_event(salle_event.getText());
        ServiceEvenement es = new ServiceEvenement();
        try {
            es.ModifierEvenement(Integer.valueOf(tfidevent.getText()), e.getType_event(), 
                    e.getDescription_event(), e.getImage_event(), e.getTitre_event(), e.getDate_event(),
                    e.getHeure_event(), e.getPrix_event(), e.getSalle_event(),
                     tfproducer.getText());
        } catch (SQLException ex) {
            Logger.getLogger(ModifierEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void affiche(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/affiche.fxml"));
        Parent root = loader.load();
        
        affiche1.getScene().setRoot(root);
        AfficheController ac = loader.getController();
        ServiceUser SU = new ServiceUser();
        ac.login(tflogin.getText());

        String filepath;
        filepath = SU.searchImage(tflogin.getText());
        ac.image(filepath);
   
    }

}
