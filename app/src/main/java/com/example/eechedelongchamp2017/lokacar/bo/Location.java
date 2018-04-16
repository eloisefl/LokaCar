package com.example.eechedelongchamp2017.lokacar.bo;

import java.util.Date;
import java.util.List;

public class Location {

    private Conducteur conducteur;
    private Voiture voiture;
    private Date debutLocation;
    private Date finLocation;
    private List<Etat> etats;

    public Location() {

    }

    public Location(Conducteur conducteur, Voiture voiture, Date debutLocation, Date finLocation, List<Etat> etats) {
        this.conducteur = conducteur;
        this.voiture = voiture;
        this.debutLocation = debutLocation;
        this.finLocation = finLocation;
        this.etats = etats;
    }

    public Conducteur getConducteur() {
        return conducteur;
    }

    public void setConducteur(Conducteur conducteur) {
        this.conducteur = conducteur;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

    public Date getDebutLocation() {
        return debutLocation;
    }

    public void setDebutLocation(Date debutLocation) {
        this.debutLocation = debutLocation;
    }

    public Date getFinLocation() {
        return finLocation;
    }

    public void setFinLocation(Date finLocation) {
        this.finLocation = finLocation;
    }

    public List<Etat> getEtats() {
        return etats;
    }

    public void setEtats(List<Etat> etats) {
        this.etats = etats;
    }

    @Override
    public String toString() {
        return "Location{" +
                "conducteur=" + conducteur +
                ", voiture=" + voiture +
                ", debutLocation=" + debutLocation +
                ", finLocation=" + finLocation +
                ", etats=" + etats +
                '}';
    }
}
