package com.example.eechedelongchamp2017.lokacar.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.eechedelongchamp2017.lokacar.bo.DataContract;
import com.example.eechedelongchamp2017.lokacar.bo.Agence;
import com.example.eechedelongchamp2017.lokacar.helper.GestionBddHelper;

public class AgenceDao {
    private SQLiteDatabase db;
    private GestionBddHelper helper;

    public AgenceDao (Context context){
        helper = new GestionBddHelper(context);
        db = helper.getWritableDatabase();
    }

    public void insertAgence(Agence agence) {
        ContentValues values = new ContentValues();
            values.put(DataContract.COL_NOM, agence.getNomAgence());
            values.put(DataContract.COL_GERANT, 1);
        db.insert(DataContract.NOM_TABLE_AGENCE,null, values);
    }

}
