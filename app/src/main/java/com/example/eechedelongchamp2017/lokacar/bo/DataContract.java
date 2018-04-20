package com.example.eechedelongchamp2017.lokacar.bo;

public abstract class DataContract {
    public final static String DATABASE_NAME = "LokaCar.db";
    public final static int DATABASE_VERSION = 1;

    public final static String COL_ID = "ID";
    public final static String COL_NOM = "NOM";
    public final static String COL_ADRESSE = "ADRESSE";

    // table Gérant
    public final static String NOM_TABLE_GERANT = "Gerant";
    public final static String COL_PRENOM = "PRENOM";
    public final static String COL_TEL = "TEL";
    public final static String COL_EMAIL = "EMAIL";
    public final static String COL_LOGIN = "LOGIN";
    public final static String COL_MDP = "MDP";
    public final static String CREATE_TABLE_GERANT =
            "CREATE TABLE IF NOT EXISTS "
            + NOM_TABLE_GERANT + " ("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_NOM + " TEXT, "
            + COL_PRENOM + " TEXT, "
            + COL_ADRESSE + " TEXT, "
            + COL_TEL + " TEXT, "
            + COL_EMAIL + " TEXT, "
            + COL_LOGIN + " TEXT ,"
            + COL_MDP + " TEXT)";

    // table Agence
    public final static String NOM_TABLE_AGENCE = "Agence";
    public final static String COL_GERANT = "GERANT";
    public final static String CREATE_TABLE_AGENCE =
            "CREATE TABLE IF NOT EXISTS "
                    + NOM_TABLE_AGENCE + " ("
                    + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COL_NOM + " TEXT, "
                    + COL_ADRESSE + " TEXT, "
                    + COL_GERANT + " INTEGER, "
                    + "FOREIGN KEY (" + COL_GERANT + ") REFERENCES " + NOM_TABLE_GERANT+"("+COL_ID+"))";

    // Destruction d'une table
    public final static String QUERY_DELETE_TABLE = "DROP TABLE IF EXISTS ";

    /*
     * table Voiture & tables liées
     */
    // table Marque
    public final static String NOM_TABLE_MARQUE = "Marque";
    public final static String CREATE_TABLE_MARQUE =
            "CREATE TABLE IF NOT EXISTS " + NOM_TABLE_MARQUE + " ("
                    + COL_ID + " integer NOT NULL PRIMARY KEY AUTOINCREMENT, "
                    + COL_NOM + " text NOT NULL)";

    // table Modele
    public final static String NOM_TABLE_MODELE = "Modele";
    public final static String _ID_MARQUE = "idMarque";
    public final static String CREATE_TABLE_MODELE =
            "CREATE TABLE IF NOT EXISTS " + NOM_TABLE_MODELE + " ("
                    + COL_ID + " integer NOT NULL PRIMARY KEY AUTOINCREMENT, "
                    + _ID_MARQUE + " integer NOT NULL, "
                    + COL_NOM + " text NOT NULL,"
                    + "FOREIGN KEY ("+_ID_MARQUE+") REFERENCES "+NOM_TABLE_MARQUE+"("+COL_ID+") "
            +")";

    // table TypeLocatif
    public final static String NOM_TABLE_TYPE_LOCATIF = "TypeLocatif";
    public final static String CREATE_TABLE_TYPE_LOCATIF =
            "CREATE TABLE IF NOT EXISTS " + NOM_TABLE_TYPE_LOCATIF + " ("
                    + COL_ID + " integer NOT NULL PRIMARY KEY AUTOINCREMENT, "
                    + COL_NOM + " text NOT NULL)";

    // table Tarif
    public final static String NOM_TABLE_TARIF = "Tarif";
    public final static String _PRIX = "prix";
    public final static String _IS_SAISON_HAUTE = "isSaisonHaute";
    public final static String _IS_SAISON_BASSE = "isSaisonBasse";
    public final static String _ID_TYPE_LOCATIF = "idTypeLocatif";
    public final static String CREATE_TABLE_TARIF =
            "CREATE TABLE IF NOT EXISTS " + NOM_TABLE_TARIF + " ("
                    + COL_ID + " integer PRIMARY KEY AUTOINCREMENT, "
                    + _PRIX + " integer NOT NULL, "
                    + _IS_SAISON_HAUTE + " integer NOT NULL,"
                    + _IS_SAISON_BASSE + " integer NOT NULL,"
                    + _ID_TYPE_LOCATIF + " integer NOT NULL,"
                    + "FOREIGN KEY ("+_ID_TYPE_LOCATIF+") REFERENCES "+NOM_TABLE_TYPE_LOCATIF+"("+COL_ID+")"
            +")";

    // table Voiture
    public final static String NOM_TABLE_VOITURE = "Voiture";
    public final static String _IMMATRICULATION = "immatriculation";
    public final static String _NBPLACES = "nbPlaces";
    public final static String _NBPORTES = "nbPortes";
    public final static String _IS_ESSENCE = "isEssense";
    public final static String _IS_DIESEL = "isDiesel";
    public final static String _PUISSANCE_MOTEUR = "puissanceMoteur";
    public final static String _IS_LOUE = "isLoue";
    public final static String _IS_DISPONIBLE = "isDisponible";
    public final static String _PHOTO_NOM = "photoNom";
    public final static String _PHOTO_CONTENT = "photoContent";
    public final static String _ID_AGENCE = "idAgence";
    public final static String _ID_MODELE = "idModele";
    public final static String CREATE_TABLE_VOITURE =
            "CREATE TABLE IF NOT EXISTS " + NOM_TABLE_VOITURE + " ("
                    + _IMMATRICULATION + " text NOT NULL PRIMARY KEY, "
                    + _NBPLACES + " integer, "
                    + _NBPORTES + " integer, "
                    + _IS_ESSENCE + " integer DEFAULT 0, "
                    + _IS_DIESEL + " integer DEFAULT 1, "
                    + _PUISSANCE_MOTEUR + " integer, "
                    + _IS_LOUE + " integer NOT NULL DEFAULT 0, "
                    + _IS_DISPONIBLE + " integer NOT NULL DEFAULT 0, "
                    + _PHOTO_NOM + " text, "
                    + _PHOTO_CONTENT + " blob, "
                    + _ID_MARQUE + " integer NOT NULL, "
                    + _ID_MODELE + " integer NOT NULL, "
                    + _ID_TYPE_LOCATIF + " integer NOT NULL, "
                    + _ID_AGENCE + " integer NOT NULL, "
                    + "FOREIGN KEY ("+_ID_MARQUE+") REFERENCES "+NOM_TABLE_MARQUE+"("+COL_ID+"), "
                    + "FOREIGN KEY ("+_ID_MODELE+") REFERENCES "+NOM_TABLE_MODELE+"("+COL_ID+"), "
                    + "FOREIGN KEY ("+_ID_TYPE_LOCATIF+") REFERENCES "+NOM_TABLE_TYPE_LOCATIF+"("+COL_ID+"), "
                    + "FOREIGN KEY ("+_ID_AGENCE+") REFERENCES "+NOM_TABLE_AGENCE+"("+COL_ID+") "
            +")";

}
