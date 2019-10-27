/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Elyes
 */
public class Stand {
    private int id_stand,idU_fk;
    private String titre_stand,proprietaire_stand,type_marchandise,date_fin_stand,date_debut_stand,PhotoStand,actif;

    
    
    //Constructors

    public Stand(int id_stand, String titre_stand, String proprietaire_stand, 
            String type_marchandise, String date_fin_stand, String date_debut_stand,
            int idU_fk, String PhotoStand, String actif) {
        this.id_stand = id_stand;
        this.idU_fk = idU_fk;
        this.titre_stand = titre_stand;
        this.proprietaire_stand = proprietaire_stand;
        this.type_marchandise = type_marchandise;
        this.date_fin_stand = date_fin_stand;
        this.date_debut_stand = date_debut_stand;
        this.PhotoStand = PhotoStand;
        this.actif = actif;
    }

    public Stand(String titre_stand, String proprietaire_stand, String type_marchandise, 
            String date_fin_stand, String date_debut_stand,int idU_fk, String PhotoStand, String actif) {
        this.idU_fk = idU_fk;
        this.titre_stand = titre_stand;
        this.proprietaire_stand = proprietaire_stand;
        this.type_marchandise = type_marchandise;
        this.date_fin_stand = date_fin_stand;
        this.date_debut_stand = date_debut_stand;
        this.PhotoStand = PhotoStand;
        this.actif = actif;
    }

    public Stand() {
    }
    
    
    
    
    //Getters and Setters:
    public int getId_stand() {
        return id_stand;
    }

    public void setId_stand(int id_stand) {
        this.id_stand = id_stand;
    }

    public String getTitre_stand() {
        return titre_stand;
    }

    public void setTitre_stand(String titre_stand) {
        this.titre_stand = titre_stand;
    }

    public String getProprietaire_stand() {
        return proprietaire_stand;
    }

    public void setProprietaire_stand(String proprietaire_stand) {
        this.proprietaire_stand = proprietaire_stand;
    }

    public String getType_marchandise() {
        return type_marchandise;
    }

    public void setType_marchandise(String type_marchandise) {
        this.type_marchandise = type_marchandise;
    }

    public String getDate_debut_stand() {
        return date_debut_stand;
    }

    public void setDate_debut_stand(String date_debut_stand) {
        this.date_debut_stand = date_debut_stand;
    }

    public String getDate_fin_stand() {
        return date_fin_stand;
    }

    public void setDate_fin_stand(String date_fin_stand) {
        this.date_fin_stand = date_fin_stand;
    }

    public int getIdU_fk() {
        return idU_fk;
    }

    public void setIdU_fk(int idU_fk) {
        this.idU_fk = idU_fk;
    }

    public String getPhotoStand() {
        return PhotoStand;
    }

    public void setPhotoStand(String PhotoStand) {
        this.PhotoStand = PhotoStand;
    }

    public String getActif() {
        return actif;
    }

    public void setActif(String actif) {
        this.actif = actif;
    }

    @Override
    public String toString() {
        return "Stand{" + "id_stand=" + id_stand + ", idU_fk=" + idU_fk + ", titre_stand=" + titre_stand + ", proprietaire_stand=" + proprietaire_stand + ", type_marchandise=" + type_marchandise + ", date_fin_stand=" + date_fin_stand + ", date_debut_stand=" + date_debut_stand + ", PhotoStand=" + PhotoStand + ", actif=" + actif + '}';
    }
    
}
