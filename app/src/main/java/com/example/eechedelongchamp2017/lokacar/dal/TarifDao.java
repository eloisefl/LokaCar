package com.example.eechedelongchamp2017.lokacar.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.util.Log;

import com.example.eechedelongchamp2017.lokacar.bo.DataContract;
import com.example.eechedelongchamp2017.lokacar.bo.Tarif;
import com.example.eechedelongchamp2017.lokacar.bo.TypeLocatif;
import com.example.eechedelongchamp2017.lokacar.helper.GestionBddHelper;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TarifDao {

    private GestionBddHelper dbHelper;
    private TypeLocatifDao daoTypeLoc;

    public TarifDao(Context context) {
        this.dbHelper = new GestionBddHelper(context);
        daoTypeLoc = new TypeLocatifDao(context);
    }

    // Get ContentValues (without id)
    private ContentValues getContentValues(Tarif obj) {
        ContentValues values = new ContentValues();
        values.put(DataContract._PRIX, obj.getPrixJournalier());

        if (obj.isSaisonHaute()) values.put(DataContract._IS_SAISON_HAUTE, 1);
        else values.put(DataContract._IS_SAISON_HAUTE, 0);

        if (obj.isSaisonBasse()) values.put(DataContract._IS_SAISON_BASSE, 1);
        else values.put(DataContract._IS_SAISON_BASSE, 0);

        values.put(DataContract._ID_TYPE_LOCATIF, obj.getTypeLocatif().getId());

        return values;
    }

    // Get Tarif from cursor
    private Tarif getTarif(Cursor cursor) {

        int id = cursor.getInt(cursor.getColumnIndex(DataContract.COL_ID));
        float prixJournalier = cursor.getFloat(cursor.getColumnIndex(DataContract._PRIX));

        boolean isSaisonHaute = false, isSaisonBasse = false;
        if (cursor.getInt(cursor.getColumnIndex(DataContract._IS_SAISON_HAUTE)) == 1)
            isSaisonHaute = true;
        if (cursor.getInt(cursor.getColumnIndex(DataContract._IS_SAISON_BASSE)) == 1)
            isSaisonBasse = true;

        int idTypeLocatif = cursor.getInt(cursor.getColumnIndex(DataContract._ID_TYPE_LOCATIF));
        TypeLocatif typeLocatif = daoTypeLoc.selectById(idTypeLocatif);

        return new Tarif(id, prixJournalier, isSaisonHaute, isSaisonBasse, typeLocatif);
    }

    // select all
    public List<Tarif> selectAll() {

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(
                DataContract.NOM_TABLE_TARIF,
                null,
                null,
                null,
                null,
                null,
                null);

        List<Tarif> objects = new ArrayList<>() ;

        if(cursor != null && cursor.moveToFirst()){
            while (cursor.moveToNext()) {
                objects.add(getTarif(cursor));
            }
            cursor.close();
        }

        return objects;
    }

    // select all
    public List<Tarif> selectByTypeLoc(int idTypeLoc) {

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(
                DataContract.NOM_TABLE_TARIF,
                null,
                DataContract._ID_TYPE_LOCATIF+" = "+idTypeLoc,
                null,
                null,
                null,
                null);

        List<Tarif> objects = new ArrayList<>() ;

        if(cursor != null && cursor.moveToFirst()){
            while (cursor.moveToNext()) {
                objects.add(getTarif(cursor));
            }
            cursor.close();
        }

        return objects;
    }

    // Insert
    public void insert(Tarif obj){

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        long id = db.insert(DataContract.NOM_TABLE_TARIF, null, getContentValues(obj));
        obj.setId((int)id);
        db.close();
    }

    // Delete
    public int delete(int id) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int res = db.delete(DataContract.NOM_TABLE_TARIF,
                DataContract.COL_ID + " = ?",
                new String[]{String.valueOf(id)});
        return res;

    }

}
