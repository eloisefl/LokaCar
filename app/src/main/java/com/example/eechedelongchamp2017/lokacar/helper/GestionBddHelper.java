package com.example.eechedelongchamp2017.lokacar.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.eechedelongchamp2017.lokacar.bo.DataContract;

public class GestionBddHelper extends SQLiteOpenHelper{

    public GestionBddHelper(Context context){

        super(context, DataContract.DATABASE_NAME, null, DataContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DataContract.CREATE_TABLE_GERANT);
        db.execSQL(DataContract.CREATE_TABLE_AGENCE);

        // Table Voiture & tables liées (+ agence avant)
        db.execSQL(DataContract.CREATE_TABLE_MARQUE);
        db.execSQL(DataContract.CREATE_TABLE_MODELE);
        db.execSQL(DataContract.CREATE_TABLE_TYPE_LOCATIF);
        db.execSQL(DataContract.CREATE_TABLE_TARIF);
        db.execSQL(DataContract.CREATE_TABLE_VOITURE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion < newVersion) {
            db.execSQL(DataContract.QUERY_DELETE_TABLE + DataContract.NOM_TABLE_GERANT);
            db.execSQL(DataContract.QUERY_DELETE_TABLE + DataContract.NOM_TABLE_AGENCE);

            // Table Voiture & tables liées (+ agence avant)
            db.execSQL(DataContract.QUERY_DELETE_TABLE + DataContract.NOM_TABLE_MARQUE);
            db.execSQL(DataContract.QUERY_DELETE_TABLE + DataContract.NOM_TABLE_MODELE);
            db.execSQL(DataContract.QUERY_DELETE_TABLE + DataContract.NOM_TABLE_TYPE_LOCATIF);
            db.execSQL(DataContract.QUERY_DELETE_TABLE + DataContract.NOM_TABLE_TARIF);
            db.execSQL(DataContract.QUERY_DELETE_TABLE + DataContract.NOM_TABLE_VOITURE);

            onCreate(db);
        }
    }
}
