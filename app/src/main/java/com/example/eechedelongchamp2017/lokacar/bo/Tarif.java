package com.example.eechedelongchamp2017.lokacar.bo;

public class Tarif {
    private int id;
    private float prixJournalier;
    private boolean isSaisonHaute;
    private boolean isSaisonBasse;

    public Tarif() {
    }

    public Tarif(int id, float prixJournalier, boolean isSaisonHaute, boolean isSaisonBasse) {
        this.id = id;
        this.prixJournalier = prixJournalier;
        this.isSaisonHaute = isSaisonHaute;
        this.isSaisonBasse = isSaisonBasse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrixJournalier() {
        return prixJournalier;
    }

    public void setPrixJournalier(float prixJournalier) {
        this.prixJournalier = prixJournalier;
    }

    public boolean isSaisonHaute() {
        return isSaisonHaute;
    }

    public void setSaisonHaute(boolean saisonHaute) {
        isSaisonHaute = saisonHaute;
    }

    public boolean isSaisonBasse() {
        return isSaisonBasse;
    }

    public void setSaisonBasse(boolean saisonBasse) {
        isSaisonBasse = saisonBasse;
    }

    @Override
    public String toString() {
        return "Tarif{" +
                "id=" + id +
                ", prixJournalier=" + prixJournalier +
                ", isSaisonHaute=" + isSaisonHaute +
                ", isSaisonBasse=" + isSaisonBasse +
                '}';
    }
}
