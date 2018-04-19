package com.example.eechedelongchamp2017.lokacar.bo;

import java.util.List;

public class TypeLocatif {
    private int id;
    private String nom;
    private List<Voiture> voitures;
    private Tarif tarif;

    public TypeLocatif() {
    }

    public TypeLocatif(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public TypeLocatif(String nom) {
        this.nom = nom;
    }

    public TypeLocatif(int id, String nom, List<Voiture> voitures, Tarif tarif) {
        this.id = id;
        this.nom = nom;
        this.voitures = voitures;
        this.tarif = tarif;
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

    public Tarif getTarif() {
        return tarif;
    }

    public void setTarif(Tarif tarif) {
        this.tarif = tarif;
    }

    @Override
    public String toString() {
        return "TypeLocatif{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", voiture=" + voitures +
                ", tarif=" + tarif +
                '}';
    }
}
