package com.borgi.doctolib_app.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
public class Patient {


    @ApiModelProperty(notes = "Id",name="id",required=true,value="0")
    private int id;
    @ApiModelProperty(notes = "Nom",name="name",required=true,value="testnom")
    private String nom;
    @ApiModelProperty(notes = "Prenom",name="prenom",required=true,value="testprenom")
    private String prenom;
    @ApiModelProperty(notes = "Ville",name="ville",required=true,value="testville")
    private String ville;
    @ApiModelProperty(notes = "Numéro sécurité social",name="ss",required=true,value="00000")
    private String ss;

    private static final AtomicInteger count = new AtomicInteger(0);


    public Patient(String nom, String prenom, String ville, String ss) {
        this.id = count.incrementAndGet();
        this.nom = nom;
        this.prenom = prenom;
        this.ville = ville;
        this.ss = ss;
    }

    public Patient() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public String getVille() {
        return ville;
    }
    public String getSs() {
        return ss;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setSs(String ss) {
        this.ss = ss;
    }

    @Override
    public String toString() {
        return "Patient\n [nom= "
                + nom +", prenom= "
                +prenom +", ville= "
                + ville + ", Numéro Securite Sociale= "
                + ss + "]";
    }

}
