package com.borgi.doctolib_app.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
public class Patient {


    private int id;
    private String nom;
    private String prenom;
    private String ville;
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
