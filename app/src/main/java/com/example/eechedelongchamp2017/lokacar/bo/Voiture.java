package com.example.eechedelongchamp2017.lokacar.bo;

import java.sql.Blob;
import java.util.List;

public class Voiture {

    private String immatriculation;
    private int nbPortes;
    private int nbPlaces;
    private boolean isEssence;
    private boolean isDiesel;
    private int puissanceMoteur;
    private Marque marque;
    private boolean isLoue;
    private boolean isDisponible;
    private String photoNom;
    private Blob photoContent;
    private TypeLocatif typeLocatif;
    private List<Location> locations;
    private Agence agence;

    public Voiture() {

    }

    public Voiture(String immatriculation, int nbPortes, int nbPlaces, boolean isEssence,
                   boolean isDiesel, int puissanceMoteur, Marque marque, boolean isLoue,
                   boolean isDisponible, String photoNom, Blob photoContent,
                   TypeLocatif typeLocatif, List<Location> locations, Agence agence) {
        this.immatriculation = immatriculation;
        this.nbPortes = nbPortes;
        this.nbPlaces = nbPlaces;
        this.isEssence = isEssence;
        this.isDiesel = isDiesel;
        this.puissanceMoteur = puissanceMoteur;
        this.marque = marque;
        this.isLoue = isLoue;
        this.isDisponible = isDisponible;
        this.photoNom = photoNom;
        this.photoContent = photoContent;
        this.typeLocatif = typeLocatif;
        this.locations = locations;
        this.agence = agence;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public int getNbPortes() {
        return nbPortes;
    }

    public void setNbPortes(int nbPortes) {
        this.nbPortes = nbPortes;
    }

    public int getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public boolean isEssence() {
        return isEssence;
    }

    public void setEssence(boolean essence) {
        isEssence = essence;
    }

    public boolean isDiesel() {
        return isDiesel;
    }

    public void setDiesel(boolean diesel) {
        isDiesel = diesel;
    }

    public int getPuissanceMoteur() {
        return puissanceMoteur;
    }

    public void setPuissanceMoteur(int puissanceMoteur) {
        this.puissanceMoteur = puissanceMoteur;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public boolean isLoue() {
        return isLoue;
    }

    public void setLoue(boolean loue) {
        isLoue = loue;
    }

    public boolean isDisponible() {
        return isDisponible;
    }

    public void setDisponible(boolean disponible) {
        isDisponible = disponible;
    }

    public String getPhotoNom() {
        return photoNom;
    }

    public void setPhotoNom(String photoNom) {
        this.photoNom = photoNom;
    }

    public Blob getPhotoContent() {
        return photoContent;
    }

    public void setPhotoContent(Blob photoContent) {
        this.photoContent = photoContent;
    }

    public TypeLocatif getTypeLocatif() {
        return typeLocatif;
    }

    public void setTypeLocatif(TypeLocatif typeLocatif) {
        this.typeLocatif = typeLocatif;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    @Override
    public String toString() {
        return "Voiture{" +
                "immatriculation='" + immatriculation + '\'' +
                ", nbPortes=" + nbPortes +
                ", nbPlaces=" + nbPlaces +
                ", isEssence=" + isEssence +
                ", isDiesel=" + isDiesel +
                ", puissanceMoteur=" + puissanceMoteur +
                ", marque=" + marque +
                ", isLoue=" + isLoue +
                ", isDisponible=" + isDisponible +
                ", photoNom='" + photoNom + '\'' +
                ", photoContent=" + photoContent +
                ", typeLocatif=" + typeLocatif +
                ", locations=" + locations +
                ", agence=" + agence +
                '}';
    }
}
