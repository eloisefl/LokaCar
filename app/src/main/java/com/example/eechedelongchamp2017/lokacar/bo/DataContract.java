package com.example.eechedelongchamp2017.lokacar.bo;

public abstract class DataContract {
    public final static String DATABASE_NAME = "LokaCar.db";
    public final static int DATABASE_VERSION = 1;

    public final static String COL_ID = "ID";;
    public final static String COL_NOM = "NOM";
    public final static String COL_ADRESSE = "ADRESSE";

    // table Gérant
    public final static String NOM_TABLE_GERANT = "Gerant";
    public final static String COL_PRENOM= "PRENOM";
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
                    + COL_GERANT + " TEXT)"
                    + "FOREIGN KEY Agence(id) REFERENCES Gerant(id)";

    // Destruction d'une table
    public final static String QUERY_DELETE_TABLE = "DROP TABLE IF EXISTS ";

}
