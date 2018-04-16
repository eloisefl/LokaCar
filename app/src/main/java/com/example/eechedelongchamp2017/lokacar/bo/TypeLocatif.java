package com.example.eechedelongchamp2017.lokacar.bo;

public class TypeLocatif {
    private int id;
    private String nom;
    private Voiture voiture;
    private Tarif tarif;

    public TypeLocatif() {
    }

    public TypeLocatif(int id, String nom, Voiture voiture, Tarif tarif) {
        this.id = id;
        this.nom = nom;
        this.voiture = voiture;
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

    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
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
                ", voiture=" + voiture +
                ", tarif=" + tarif +
                '}';
    }
}
