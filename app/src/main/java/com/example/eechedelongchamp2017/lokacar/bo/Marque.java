package com.example.eechedelongchamp2017.lokacar.bo;

import java.util.List;

public class Marque {

    private int id;
    private String nom;
    private List<Voiture> voitures;
    private Modele modele;

    public Marque() {

    }

    public Marque(String nom) {
        this.nom = nom;
    }

    public Marque(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Marque(int id, String nom, List<Voiture> voitures, Modele modele) {
        this.id = id;
        this.nom = nom;
        this.voitures = voitures;
        this.modele = modele;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Voiture> getVoitures() {
        return voitures;
    }

    public void setVoitures(List<Voiture> voitures) {
        this.voitures = voitures;
    }

    public Modele getModele() {
        return modele;
    }

    public void setModele(Modele modele) {
        this.modele = modele;
    }

    @Override
    public String toString() {
        return "Marque{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", voitures=" + voitures +
                ", modele=" + modele +
                '}';
    }
}
