package com.borgi.doctolib_app.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "Id",name="id",required=true,value="0")
    private Long id;
    @ApiModelProperty(notes = "Nom",name="name",required=true,value="testnom")
    private String nom;
    @ApiModelProperty(notes = "Prenom",name="prenom",required=true,value="testprenom")
    private String prenom;
    @ApiModelProperty(notes = "Ville",name="ville",required=true,value="testville")
    private String ville;
    @ApiModelProperty(notes = "Numéro sécurité social",name="ss",required=true,value="00000")
    private String ss;

    public Patient(String nom, String prenom, String ville, String ss) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.ville = ville;
        this.ss = ss;
    }

    public Patient() {

    }

    public Long getId() {
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

    @Override
    public String toString() {
        return "Patient\n [nom= "
                + nom +", prenom= "
                +prenom +", ville= "
                + ville + ", Numéro Securite Sociale= "
                + ss + "]";
    }

}
