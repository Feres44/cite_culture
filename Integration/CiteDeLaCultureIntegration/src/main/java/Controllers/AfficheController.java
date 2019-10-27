/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Entite.Evenement;
import Entite.Stand;
import Service.ServiceEvenement;
import Service.ServiceStand;
import Service.ServiceUser;
import java.io.IOException;
import static java.lang.System.in;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Elyes
 */
public class AfficheController implements Initializable {

    @FXML
    private TableView<Evenement> id_table;
    @FXML
    private TableColumn<Evenement, Number> Id_event;
    @FXML
    private TableColumn<Evenement, String> Type_event;
    @FXML
    private TableColumn<Evenement, String> Description_event;
    @FXML
    private TableColumn<Evenement, String> Image_event;
    @FXML
    private TableColumn<Evenement, String> Titre_event;
    @FXML
    private TableColumn<Evenement, String> Date_event;
    @FXML
    private TableColumn<Evenement, String> Heure_event;
    @FXML
    private TableColumn<Evenement, Number> Prix_event;
    @FXML
    private TableColumn<Evenement, String> User_name_event;
    private ObservableList<Evenement> data = FXCollections.observableArrayList();
    List<Evenement> ev = new ArrayList<>();
    @FXML
    private Button id_ajouter;
    @FXML
    private Button id_modifer;
    @FXML
    private Button id_suprimer;
    @FXML
    private Label tflogin;
    @FXML
    private ImageView tfphoto;
    @FXML
    private Button tfRetour;
    @FXML
    private Label tfidevent;
    @FXML
    private Label tfdateevent;
    @FXML
    private Label tfheureevent;
    @FXML
    private Label tfprixevent;
    @FXML
    private Label tfsaleevent;
    @FXML
    private Label tftitreevent;
    @FXML
    private Label tftypeevent;
    @FXML
    private Label tfdescevent;

    /**
     * Initializes the controller class.
     */
    void login(String log) {
        tflogin.setText(log);

    }

    void image(String filepath) {
        Image imag = new Image("file:" + filepath);
        tfphoto.setImage(imag);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceEvenement sp = new ServiceEvenement();
        try {
            ev = sp.readAll1();
            data.addAll(ev);
            //Id_event.setCellValueFactory(new PropertyValueFactory<>("id_event"));
            Type_event.setCellValueFactory(new PropertyValueFactory<>("type_event"));
            Description_event.setCellValueFactory(new PropertyValueFactory<>(" description_event"));
            Image_event.setCellValueFactory(new PropertyValueFactory<>("image_event"));
            Titre_event.setCellValueFactory(new PropertyValueFactory<>("titre_event"));
            Date_event.setCellValueFactory(new PropertyValueFactory<>("date_event"));
            Heure_event.setCellValueFactory(new PropertyValueFactory<>("heure_event"));
            Prix_event.setCellValueFactory(new PropertyValueFactory<>("prix_event"));
            User_name_event.setCellValueFactory(new PropertyValueFactory<>("user_name_event"));

            id_table.setItems(data);

        } catch (SQLException ex) {
            Logger.getLogger(AfficheController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Ajouter_event(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/AjouterEvent.fxml"));
        Parent root = loader.load();
        id_ajouter.getScene().setRoot(root);

        ServiceUser SU = new ServiceUser();
        AjouterEventController aec = loader.getController();
        aec.login(tflogin.getText());

        String filepath;
        filepath = SU.searchImage(tflogin.getText());
        aec.image(filepath);

    }

    @FXML
    private void Modifier_event(ActionEvent event) throws IOException, SQLException {

        if (Integer.valueOf(tfidevent.getText()) < 99999) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Views/ModifierEvent.fxml"));
            Parent root = loader.load();
            id_modifer.getScene().setRoot(root);

            ServiceUser SU = new ServiceUser();
            ModifierEventController mec = loader.getController();
            mec.login(tflogin.getText());

            String filepath;
            filepath = SU.searchImage(tflogin.getText());
            mec.image(filepath);

            mec.idevent(tfidevent.getText());

            mec.titreevent(tftitreevent.getText());
            mec.typeevent(tftypeevent.getText());
            mec.dateevent(tfdateevent.getText());
            mec.heureevent(tfheureevent.getText());
            mec.descevent(tfdescevent.getText());
            mec.prixevent(tfprixevent.getText());
            mec.saleevent(tfsaleevent.getText());

            String filepath1;
            ServiceEvenement SE = new ServiceEvenement();
            filepath1 = SE.searchImage(tfidevent.getText());
            mec.image(filepath1);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Please Select an Event");
            alert.show();

        }

    }

    @FXML
    private void sup_event(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Are you sure you want to delete this Event");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            Evenement e = new Evenement();
            e.setId_evenement(Integer.valueOf(tfidevent.getText()));
            ServiceEvenement se = new ServiceEvenement();
            try {
                se.SuprimerEvenement(e.getId_evenement());

            } catch (SQLException ex) {
                Logger.getLogger(StandDetailedController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            // ... user chose CANCEL or closed the dialog
        }

    }

    @FXML
    private void Back(ActionEvent event) throws IOException, SQLException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/Views/Window.fxml"));
        Parent root = loader.load();
        tfRetour.getScene().setRoot(root);

        ServiceUser SU = new ServiceUser();
        WindowController wc = loader.getController();
        wc.login(tflogin.getText());

        String filepath;
        filepath = SU.searchImage(tflogin.getText());
        wc.image(filepath);
    }

    @FXML
    private void detail(MouseEvent event) {
        Evenement e = id_table.getSelectionModel().getSelectedItem();
        tfidevent.setText(Integer.toString(e.getId_evenement()));
        tftitreevent.setText(e.getTitre_event());
        tftypeevent.setText(e.getType_event());
        tfdateevent.setText(e.getDate_event());
        tfheureevent.setText(e.getHeure_event());
        tfdescevent.setText(e.getDescription_event());
        tfprixevent.setText(Integer.toString(e.getPrix_event()));
        tfsaleevent.setText(e.getSalle_event());

    }

}
